package nioTest;

import java.nio.file.Files; // 파일 작업(생성, 확인, 삭제)을 실행하는 클래스. 메소드가 전부 static 이다.
import java.nio.file.Path; // 파일이나 폴더의 경로를 저장하는 객체의 부모 인터페이스 타입
import java.io.IOException; // 파일 입출력 작업 실패 시 발생하는 예외 정보를 제공하는 클래스

public class Nio01_PathBasic {

	public static void main(String[] args) throws IOException {
		
		//==================
		//[1] Path 객체 만들기
		//==================
		System.out.println("========== [1] Path 객체 만들기 ==========");
		
		Path dirPath = Path.of("data");
		
		Path filePath = Path.of("data", "memo.txt");
		
		// Path 객체를 println 에 넣으면 toString() 메소드가 자동으로 호출되어 보관하고 있는 경로를 문자열로 반환해 출력해줍니다.
		System.out.println("폴더 경로: " + dirPath.toString()); // 출력: data
		System.out.println("파일 경로: " + filePath.toString()); // 출력: data\memo.txt
		
		System.out.println(); // 빈 줄 출력
		
		//===========================================
		//[2] Path 객체에서 경로 정보 꺼내기
		// 아래 메서드들은 전부 Path 객체의 메소드이다.
		// JVM 의 Heap 에 있는 경로 문자열만 분석해서 답을 준다.
		// 하드디스크에 보관된 실제 파일이 없어도 동작한다.
		//===========================================
		System.out.println("===== [2] Path 객체에서 경로 정보 꺼내기 =====");
		
		// getFileName(): 경로의 마지막 조각을 반환한다.
		// "data\memo.txt" 의 마지막 조각은 "memo.txt"
		// 반환 타입이 String 이 아니라 Path 부모 인터페이스라는 것에 주의한다.
		System.out.println("파일명: " + filePath.getFileName()); // 출력: memo.txt
		
		// getParent(): 마지막 조각을 뺀 나머지 경로를 반환한다.
		// "data\memo.txt" 에서 마지막을 빼면 "data"
		System.out.println("상위 폴더: " + filePath.getParent()); // 출력: data
		
		// toAbsolutePath(): 상대 겨올를 절대 경로로 바꿔서 반환한다.
		// 상대 경로: 프로그램 실행 위치를 기준으로 적은 경로. data\memo.txt
		// 절대 경로: 드라이브(또는 루트)부터 전부 적은 경로.
		// 예) C:\work\myproject\data\memo.txt
		System.out.println("절대 경로: " + filePath.toAbsolutePath());
		
		// getNameCount(): 경로의 조각 개수를 int 로 반환한다.
		// data 조각 + memo.txt 조각 ---> 2개
		System.out.println("경로 조각 수: " + filePath.getNameCount()); // 출력: 2
		
		// getName(인덱스): 해당 인덱스 조각을 반환한다.
		// 인덱스는 배열과 같이 0부터 시작한다.
		// "data\memo.txt"
		//   0	    1		<--- index
		System.out.println("0번 조각: " + filePath.getName(0)); // 출력: data
		System.out.println("1번 조각: " + filePath.getName(1)); // 출력: memo.txt
		
		System.out.println();
		
		//==================================================
		//[3] 하드디스크에 실제로 파일 및 폴더가 존재하는지 확인(생성 전)
		// 여기서부터 Files 클래스를 사용한다.
		// Files 클래스의 메소드는 하드디스크에 접근해서 실제 상태를 확인한다.
		//==================================================
		System.out.println("====== [3] 실제 존재 여부 확인(생성 전) ======");
		
		// Files.exists(Path 객체)
		// -> 전달받은 Path 객체에 보관된 경로가 하드디스크에 실제로 존재하면 true, 없으면 false 를 반환한다.
		// 첫 번째 실행: 아직 안 만들었으므로 둘 다 false
		System.out.println("data 폴더 존재? : " + Files.exists(dirPath)); // false
		System.out.println("memo.txt 존재? : " + Files.exists(filePath)); // false
		
		System.out.println();
		
		//===========
		//[4] 하드디스크에 실제로 파일 및 폴더 생성하기
		//
		// 주의:	이미 존재하는 것을 또 만들면
		//		FileAlreadyExistesException 예외가 발생하며 자바 프로그램 전체는 멈춘다.
		//		그래서 만들기 전에 exists 메소드로 반드시 확인한다.
		//==================================================================
		if(!Files.exists(dirPath)) {
			
			// Files.createDirectory(Path 객체)
			// - 매개변수로 전달받은 Path 객체의 경로에 폴더를 하드디스크에 실제로 만든다.
			// 주의:	상위 폴더가 먼저 만들어져 있어야 한다.
			//		상위 폴더가 없으면 NoSuchFileException 예외가 발생한다.
			Files.createDirectory(dirPath);

			System.out.println("data 폴더 생성 완료");
		}else {
			
			System.out.println("data 폴더는 이미 존재함(생성하지 말자)");
		}
		
		if(!Files.exists(filePath)) {// "data\memo.txt" 파일이 만들어져 있지 않느냐?
			
			// Files.createFile(Path 객체)
			// - 매개변수로 전달받은 Path 객체 경로에 크기 0 byte 인 빈 파일을 하드디스크에 실제로 만든다.
			// 주의:	data 폴더가 먼저 만들어져 있어야 한다.
			//		그래서 폴더 생성 코드가 이 코드 줄보다 위에 작성되어 있다.
			Files.createFile(filePath);
			
			System.out.println("memo.txt 생성 완료");
		}else {
			
			System.out.println("memo.txt 는 이미 존재함(생성하지 말자)");
		}
		
		System.out.println();
		
		//=====================
		//[5] 생성 후 상태 다시 확인
		//=====================
		System.out.println("========== [5] 생성 후 상태 확인 ==========");
		
		// [3] 에서 false 였던 값이 지금은 true 로 나온다.
		System.out.println("memo.txt 존재? : " + Files.exists(filePath)); // true
		
		// Files.isDirectory(Path 객체): 해당 경로가 폴더이면 true 를 반환한다.
		System.out.println("data 는 폴더인가? : " + Files.isDirectory(dirPath)); // true
		System.out.println("memo.txt 는 폴더인가? : " + Files.isDirectory(filePath)); // false
		
		// Files.isRegularFile(Path 객체): 해당 경로가 일반 파일이면 true 를 반환한다.
		System.out.println("memo.txt 는 파일인가? : " + Files.isRegularFile(filePath)); // true
		
		// Files.size(Path 객체): 파일 크기를 바티으 단위 long 값으로 반환한다.
		// 바이트(byte): 컴퓨터가 데이터 크기를 세는 기본 단위
		// long: int 보다 큰 정수를 담은 타입. 2GB 넘는 파일도 표현하기 위해서이다.
		// 방금 만든 빈 파일이므로 0이 나온다.
		System.out.println("memo.txt 크기: " + Files.size(filePath)); // 0 bytes
		
		// Files.isReadable 메소드 / Files.isWritable 메소드
		// 이 프로그램이 해당 파일을 읽을 수 있는지 / 쓸 수 있는지의 boolean 값 하나를 반환해줍니다.
		// 운영체제의 권한 설정에 따라 false 가 나올 수 있다.
		System.out.println("읽기 가능? : " + Files.isReadable(filePath)); // true
		System.out.println("쓰기 가능? : " + Files.isWritable(filePath)); // true
		
		System.out.println();
		
		//=================
		//[정리]
		//=================
		System.out.println("================ [정리] ================");
		System.out.println("1. Path.of 메소드는 JVM 의 Heap 영역에 경로 객체를 만들 뿐, 하드디스크는 안 바뀐다.");
		System.out.println("2. 디스크를 확인하고 바꾸는 것은 전부 Files 클래스의 static 메소드다.");
		System.out.println("3. 파일이나 폴더 생성 전 Files 클래스의 exists() 메소드 실행하면 false, 생성 후에는 true 다.");
		System.out.println("4. exists() 확인 없이 create...() 메소드를 호출하여 생성하면 두 번째 실행에서 예외로 멈춘다.");
		
	}// === main Method

}// --- Nio01_PathBasic Class




