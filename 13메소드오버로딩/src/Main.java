
/*
	주제: 메소드 오버로딩 연습
*/

// add 라는 동일한 이름의 메소드를 4개 작성해 놓은 Calculator 설계도(클래스) 만들기
class Calculator {
	
	// add 메소드 오버로딩 하자
	
	//1. 두 정수를 매개변수로 전달받아 합을 구해 반환하는 기능의 add 메소드 만들기
	public int add(int num1, int num2) {
					//	 5 ,	  10
		return num1 + num2;
	}
	
	//2. 세 개의 정수를 매개변수로 전달받아 합을 구해 반환하는 기능의 add 메소드 만들기
	public int add(int num1, int num2, int num3) {
					//	 5 ,	  10 ,		15
		return num1 + num2 + num3;
	}
	
	//3. 두 실수를 매개변수로 전달받아 두 실수의 합을 구해 반환하는 기능의 add 메소드 만들기
	public double add(double num1, double num2) {
						//	 5.5 ,		  10.5
		return num1 + num2;
	}
	
	//4. 하나의 정수와 하나의 실수를 순서대로 각각 매개변수로 전달받아 합을 구해 반환하는 기능의 add 메소드 만들기
	public double add(int num1, double num2) {
						//	5 ,		   10.5
		return num1 + num2;
	}
	
}// --- Calculator 클래스

public class Main {

	public static void main(String[] args) {
		
		/* class Calculator 클래스 하나를 이용해 객체 메모리 생성 시 기본 생성자 호출! 단! 참조변수명 calculator */
		Calculator calculator = new Calculator();
		
		/* 정수 5와 정수 10의 합을 구해 이 자리에 15 출력 */
		int result = calculator.add(5, 10); // <--- public int add(int num1, int num2){} 메소드 호출
		System.out.println(result);
						// 15
		
		/* 정수 5, 정수 10, 정수 15의 합을 구해 이 자리에 30 출력 */
		result = calculator.add(5, 10, 15); // <--- public int add(int num1, int num2, int num3){} 메소드 호출
		System.out.println(result);
						// 30
		
		/* 실수 5.5, 실수 10.5의 합을 구해 이 자리에 16.0 출력 */
		double sum = calculator.add(5.5, 10.5); // <--- public double add(double num1, double num2){} 메소드 호출
		System.out.println(sum);
						// 16.0
		
		/* 정수 5, 실수 10.5의 합을 구해 이 자리에 15.5 출력 */
		System.out.println(calculator.add(5, 10.5)); // <--- public double add(int num1, double num2){} 메소드 호출
						// 15.5
	}// --- main 메소드

}// --- Main 클래스


