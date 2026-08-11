
/*
	주제:	 PrintStream 클래스를 사용하여
		 프로그램에서 만든 데이터를 파일에 출력(기록)하는 예제
		 
	PrintStream 클래스
	 - "출력 전용 스트림 통로" 역할을 하는 클래스
	 - 다양한 자료형(int, double, char, boolean, String)을 따로 변환하지 않아도 바로 출력할 수 있다.
	 - System.out 상수 메모리 내부적으로 PrintStream 클래스의 객체 주소를 보관하고 있다.
*/

import java.io.PrintStream;
import java.io.FileNotFoundException;

public class PrintStreamTest1 {

	public static void main(String[] args) {
		
		//======================
		//1. PrintStream 객체 생성
		//======================
		// - "ps.txt" 파일과 연결된 출력 스트림(통로) PrintStream 클래스의 객체를 생성한다.
		// 의미:	자바 프로그램에서 만든 데이터를 ps.txt 파일로 보내기 위한 출력 스트림(통로)를 만드는 것.
		// - 주의!
		//1. 파일이 존재하지 않으면 새로 생성됨
		//2. 파일을 만들 수 없는 상황이면 예외 발생
		try {
			
			PrintStream out = new PrintStream("ps.txt");
			
			//============================
			//2. println() 메소드로 데이터 출력
			//============================
			// println() 특징
			// - 데이터를 문자 형태로 변환하여 출력
			// - 출력한 후 자동으로 줄 바꿈(엔터) 처리
			// - PrintStream 출력 스트림 통로를 통해 연결된 "ps.txt" 파일로 데이터를 내보내어 기록(출력)한다.
			out.println(10); // 정수 10을 문자 "10" 으로 바꿔서 ps.txt 파일에 기록
			out.println(3.4); // 실수 3.4를 문자 "3.4" 로 바꿔서 ps.txt 파일에 기록
			out.println('A'); // 문자 A 를 ps.txt 파일에 기록
			out.println(true); // 논리 값 true 를 문자 "true" 로 바꿔서 ps.txt 파일에 기록
			out.println("Hello"); // 문자열 Hello 를 파일 문자 단위로 ps.txt 파일에 기록
			
			//============================================
			//3. 스트림 통로 닫기(중요!)
			// close() 를 호출하면
			// - 남아있는 데이터가 파일로 완전히 내보내져서 출력(기록)되고
			//	 파일과의 연결이 종료된다.
			// close() 를 호출하지 않으면
			// - 파일에 데이터가 안 써지거나
			//	 일부 데이터만 저장할 수 있다.
			//============================================
			
		}catch (FileNotFoundException e) {
			
			// 파일을 생성할 수 없거나
			// 파일이 저장된 경로가 잘못된 경우 발생하는 FileNotFoundException 예외 메세지 및 처리
			e.printStackTrace();
		}// catch 블럭
		
	}// === main Method

}// --- PrintStreamTest1 Class


