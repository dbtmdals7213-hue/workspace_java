package nioTest;

import java.nio.charset.StandardCharsets;   // 문자 인코딩 상수를 모아 둔 클래스. UTF_8 을 사용한다
import java.nio.file.Files;                 // 파일 읽기/쓰기를 실행하는 클래스. 메서드가 전부 static
import java.nio.file.Path;                  // 파일 경로를 담는 객체의 타입
import java.nio.file.StandardOpenOption;    // 파일을 열 때 지정하는 옵션 상수 모음 (APPEND 등)
import java.io.IOException;                 // 파일 작업 실패 시 발생하는 예외 클래스
import java.util.ArrayList;                 // 요소를 순서대로 담는 목록 클래스
import java.util.List;                      // 목록의 타입. ArrayList 를 담는 변수의 타입으로 쓴다

/*
 * ==================================================================
 * [NIO 예제 2] 텍스트 파일 쓰기와 읽기
 * ==================================================================
 *
 * ------------------------------------------------------------------
 * 1. 용어 정리 (이 예제에 나오는 자바 용어)
 * ------------------------------------------------------------------
 *
 *   스트림(통로) 	  : 프로그램과 파일 사이에서 데이터가 지나가는 연결.
 *                  NIO 에서는 Files 가 내부에서 열고 닫으므로
 *                  내 코드에는 보이지 않는다.
 *   바이트         : 파일에 실제로 저장되는 숫자 단위. 파일 안에는
 *                  문자가 아니라 바이트가 들어 있다.
 *   인코딩         : 문자를 바이트로 바꾸는 규칙. 우리는 UTF-8 을 쓴다.
 *                  UTF-8 에서 영어/숫자/기호는 1바이트, 한글은 3바이트다.
 *   String       : 문자열을 담는 객체. Heap 에 만들어진다.
 *   List<String> : String 만 담는 목록. <String> 은 요소의 타입 지정이다.
 *   ArrayList    : List 의 실제 구현 클래스. 요소를 넣은 순서대로 보관한다.
 *
 *
 * ------------------------------------------------------------------
 * 2. 이 예제에서 배우는 Files 메서드 4개
 * ------------------------------------------------------------------
 *
 *   쓰기
 *     Files.writeString(경로, String, 인코딩)   String 을 파일로 저장
 *     Files.write(경로, List, 인코딩)           List 를 한 줄씩 파일로 저장
 *
 *   읽기
 *     Files.readString(경로, 인코딩)            파일 전체를 String 하나로 반환
 *     Files.readAllLines(경로, 인코딩)          파일을 줄 단위로 잘라 List 로 반환
 *
 *   저장할 때와 읽을 때 인코딩이 다르면 한글이 깨진다.
 *   그래서 항상 StandardCharsets.UTF_8 로 통일한다.
 *
 *
 * ------------------------------------------------------------------
 * 2-1. IO(java.io) 와의 비교 - 같은 일을 하는 옛날 방식
 * ------------------------------------------------------------------
 *
 *   [이 예제의 NIO 코드와 IO 대응 코드]
 *
 *     NIO (이 예제, 각 1줄)   		| IO (java.io 방식, 여러 줄 직접 구현)
 *     -------------------------+------------------------------------------
 *     Files.writeString       	| FileWriter 통로 열기 + write + close
 *     Files.readString        	| FileReader 통로 열기 + 끝까지 읽는 반복 + close
 *     Files.readAllLines      	| BufferedReader 로 readLine 반복 + List.add + close
 *     APPEND 옵션             	| new FileWriter(경로, true) 의 true 인자
 *
 *   [통로 관점의 차이]
 *
 *     IO  : 통로(스트림) 객체를 내 코드로 만들고, 흘리고, 닫는다
 *
 *       [Heap String] --> [FileWriter 쓰기 통로 ==>] --> [디스크]
 *        내 코드가 함 :     열기      write      close 전부
 *
 *     NIO : 같은 통로 작업을 Files 가 내부에서 대신한다
 *
 *       [Heap String] ==(Files 내부: 열기+이동+닫기 자동)==> [디스크]
 *        내 코드가 함 :  Files.writeString(...) 호출 1줄
 *
 *     통로가 사라진 것이 아니라, 통로 관리를 Files 에게 맡긴 것이다.
 *     각 구간([1], [3], [4])에서 IO 로 짜면 어떤 코드였는지 다시 비교한다.
 *
 *
 * ------------------------------------------------------------------
 * 3. 실행 순서
 * ------------------------------------------------------------------
 *
 *   [1] String 을 파일로 저장한다.(스트림에 바이트가 흐르는 과정 모델링)
 *   [2] 파일 전체를 String 으로 읽는다
 *   [3] 줄 단위로 읽어 List 에 담고, 계산까지 한다.(반복 추적표)
 *   [4] APPEND 옵션으로 파일 끝에 이어쓴다.
 *   [5] List 를 만들어 파일로 저장한다.
 *   [6] 저장 결과를 다시 읽어 확인한다.
 * ==================================================================
 */
public class Nio02_TextReadWrite {

    public static void main(String[] args) throws IOException {
    	
    	// member.txt 의 경로를 담은 Path 객체를 JVM 의 Heap 영역에 만든다.
    	Path path = Path.of("member.txt");
    	
    	//======================================
    	//[1] String 을 파일로 저장하기 - writeString
    	//======================================
    	System.out.println("============= [1] 문자열 통째로 쓰기 =============");
    	
    	String content = "홍길동, 20, 서울 \n"
    				   + "김철수, 25, 부산 \n"
    				   + "이영희, 23, 대구 \n";
    	
    	// Files.writeString(경로, String, 인코딩)
    	// - 전달할 경로의 파일이 없으면 만들고, 이미 있으면 내용을 전부 지우고 새로 쓴다.(덮어쓰기)
    	Files.writeString(path, content, StandardCharsets.UTF_8);
    	
    	System.out.println("member.txt 에 기록(저장) 완료");
    	System.out.println("파일 크기: " + Files.size(path) + "bytes");
    	System.out.println();
    	
    	//=========================================================
    	//[2] 파일 전체의 데이터를 String 문자열로 읽기 - readString 메소드 사용
    	//=========================================================
    	System.out.println("============== [2] 파일 통째로 읽기 ==============");
    	
    	// Files.readString(경로, 인코딩)
    	// - 스트림 통로 열리고, 디스크의 바이트가 UTF-8 규칙으로 다시 문자로 바뀌어
    	//	 String 객체 하나로 JVM Heap 영역에 만들어진 뒤, 그 참조가 반환된다.
    	//	 저장할 때 UTF-8 이었으므로 읽을 때도 UTF-8. 다르면 한글이 깨져서 읽어 들여집니다.
    	String readAll = Files.readString(path, StandardCharsets.UTF_8);
    	
    	System.out.println("읽은 내용 전체 아래에 출력");
    	System.out.println(readAll.toString());
    	System.out.println();
    	
    	//====================================================
    	//[3] 줄 단위로 읽어 List 배열에 담기 - readAllLines 메소드 사용
    	// readString() 메소드는 파일을 읽어와서 보여주는 용도까지만 가능하다.
    	// 값을 계산하려면 줄 단위로 자르고, 쉼표 단위로 또 잘라야 한다.
    	//====================================================
    	System.out.println("===== [3] 파일의 정보를 줄 단위로 읽어서 가공하기 =====");
    	
    	// readAllLines 메소드 호출 시 매개변수로 member.txt 경로 정보가 저장된 Path 객체 전달하고,
    	// 매개변수로 UTF_8 상수를 전달하면 BufferedReader 입력 스트림 통로와 member.txt 파일과
    	// 연결시키고, ArrayList 배열을 하나 생성하고, 줄 단위로 잘라서 문자열을 읽어들여
    	// ArrayList 배열에 반복해서 추가시킵니다.
    	// 마지막으로 ArrayList 배열 자체를 반환 해줍니다.
    	List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
    	
    	// size(): ArrayList 배열에 담긴 문자열 객체의 개수를 int 로 반환한다.
    	System.out.println("파일에서 읽어들인 총 줄 수: " + lines.size());
    	System.out.println();
    	
    	for(String line : lines) {
    		
    		// split(","): 문자열을 쉼표 위치에서 잘라 String 배열에 담아 반환한다.
    		String[] arr = line.split(",");
    		
    		String name = arr[0]; // 0번 index 칸의 요소를 이름으로 사용
    		int age = Integer.parseInt(arr[1].trim());
    		String city = arr[2]; // 2번 index 칸의 요소를 지역으로 사용
    		
    		System.out.println("이름: " + name + " 내년 나이: " + (age + 1) + " 사는 지역:" + city);
    	}// for 반복문
    	System.out.println();
    	
    	//==============================
    	//[4] 파일 끝에 이어쓰기 - APPEND 옵션
    	//==============================
    	Files.writeString(path, "박민수, 30, 인천\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    	
    	System.out.println("이어쓰기 후 파일 크기: " + Files.size(path) + "bytes");
    	
    	// 다시 member.txt 파일에 저장된 데이터들을 한 줄 단위로 읽어서 읽어들인 한 줄씩 ArrayList 배열에 각 칸에 저장 후
    	// ArrayList 배열 자체를 반환해오자
    	List<String> after = Files.readAllLines(path, StandardCharsets.UTF_8);
    	System.out.println("이어쓰기 후 줄 수: " + after.size()); // 출력: 4
    	System.out.println();
    	
    	//==============================================================================
    	//[5] List 를 만들어 파일로 저장하기 - Files.write() 메소드 사용
    	// List 배열을 하나 먼저 만들고, 파일에 기록할 문자열을 List 배열에 모두 추가 후 그것을 파일에 보내 기록
    	//==============================================================================
    	
    	List<String> newList = new ArrayList<>();
    	
    	newList.add("상품코드, 상품명, 가격");
    	newList.add("P001, 키보드, 35000");
    	newList.add("P002, 마우스, 18000");
    	
    	Path productPath = Path.of("product.txt"); // 저장할 파일의 경로 객체
    	
    	// Files.write(경로, List, 인코딩)
    	// - List 배열의 요소를 앞에서부터 한 줄씩 파일에 쓴다.
    	//	 각 요소 뒤에 줄바꿈을 자동으로 넣어 준다.
    	//	 그래서 add 추가할 때 \n 을 붙이면 줄바꿈이 두 번 되어 빈 줄이 생긴다. 조심하자!
    	Files.write(productPath, newList, StandardCharsets.UTF_8);
    	
    	System.out.println("product.txt 저장 완료(" + Files.size(productPath) + " bytes)");
    	System.out.println();
    	
    	//=============================
    	//[6] 파일에 저장 결과를 다시 읽어 확인
    	//=============================
    	System.out.println("============ [6] 파일 저장 결과 확인 ============");
    	
    	List<String> productLines = Files.readAllLines(productPath, StandardCharsets.UTF_8);
    	
    	// for 문: 행 번호를 출력해야 하므로 일반 for 문 사용
    	for(int i = 0; i < productLines.size(); i++) {
    		
    		System.out.println((i + 1) + "행: " + productLines.get(i));
    	}
    	System.out.println();
    	
    }// === main Method

}// --- Nio02_TextReadWrite Class




