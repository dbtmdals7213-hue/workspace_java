package nioTest;

import java.nio.file.Files; // 파일 작업(생성, 확인, 삭제)을 실행하는 클래스. 메소드가 전부 static 이다.
import java.nio.file.Path; // 파일이나 폴더의 경로를 저장하는 객체의 부모 인터페이스 타입
import java.io.IOException; // 파일 입출력 작업 실패 시 발생하는 예외 정보를 제공하는 클래스

public class Nio01_PathBasic {

	public static void main(String[] args) {
		
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
		System.out.println("data 폴더 존재? : " + Files.exists(dirPath));
		
		
	}// === main Method

}// --- Nio01_PathBasic Class




