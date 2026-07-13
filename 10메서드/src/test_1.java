
/*
	문제 1. 두 수의 합 구하기
		 - 메서드 이름: sum
		 - 매개변수: int a, int b
		 - 반환 타입: int
		 - 설명: 두 개의 정수를 입력받아 그 합을 반환하는 메서드를 작성하세요.
*/

public class test_1 {

	public static int sum(int a, int b) {
		
		return a + b;
	}
	
	public static void main(String[] args) {
		
		System.out.println("5 + 10 = " + sum(5, 10));
	}
	
}
