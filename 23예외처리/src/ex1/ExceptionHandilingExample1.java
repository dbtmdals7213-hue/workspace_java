package ex1;

public class ExceptionHandilingExample1 {

	/*
		클래스 메소드
		기능:	 매개변수 data 로 하나의 전체 문자열을 전달받아
			 전체 문자열의 총 문자 개수를 구해서 변수에 저장하고
			 변수에 저장된 문자열의 총 문자 개수 출력
	*/
	public static void printLength(String data) {
		// "ThisIsJava" <- 정상적으로 넘겨 받은 문자열
		// 또는
		// null <- 비정상적으로 넘겨 받은 null
		
		//		   = "ThisIsJava".length(); -> 총 문자 개수 10 반환
		//		   = null.length(); -> NullPointerException 실행 예외 발생!
		int result = data.length();
		
		System.out.println("매개변수 data로 전달받은 전체 문자열의 총 개수: " + result);
	}
		
	public static void main(String[] args) {
		
		System.out.println("[자바 프로그램 시작 코드]");
		
		ExceptionHandilingExample1.printLength("ThisIsJava");
		
		ExceptionHandilingExample1.printLength(null);
		
		System.out.println("[자바 프로그램 마지막 코드 실행 후 종료]");
	}

}
