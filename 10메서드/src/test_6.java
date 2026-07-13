
/*
	문제 6. 1부터 N까지의 합 구하기
		 - 메서드 이름: sumUpTo
		 - 매개변수: int n
		 - 반환 타입: int
		 - 설명: 1부터 입력받은 정수 n까지의 총합을 구하여 반환하는 메서드를 작성하세요.
*/

public class test_6 {

	public static int sumUpTo(int n) {
		
		int sum = 0;
		
		for(int i = 1; i <= n; i++) {
			
			sum += i;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		System.out.println("1부터 15까지의 총합: " + sumUpTo(15)); // 120
	}

}
