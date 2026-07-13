
/*
	문제 9. 팩토리얼(Factorial) 구하기
		 - 메서드 이름: factorial
		 - 매개변수: int n
		 - 반환 타입: long
		 - 설명: 정수 n을 입력받아 n! (1부터 n까지의 곱)을 반환하는 메서드를 작성하세요. (곱셈 결과가 매우 커질 수 있으므로 반환 타입을 long으로 설정하세요.)
*/

public class test_9 {
	
	public static long factorial(int n) {
		
		long total = 1;
		
		for(int i = 1; i <= n; i++) {
			
			total *= i;
		}
		
		return total;
	}

	public static void main(String[] args) {
		
		System.out.println("7! 의 값: " + factorial(7));
	}

}
