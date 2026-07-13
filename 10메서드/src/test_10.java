
/*
	문제 10. 소수(Prime Number) 판별하기
		 - 메서드 이름: isPrime
		 - 매개변수: int num
		 - 반환 타입: boolean
		 - 설명: 정수를 입력받아 그 수가 소수(1과 자기 자신으로만 나누어지는 1보다 큰 자연수)이면 true, 아니면 false를 반환하는 메서드를 작성하세요.
*/

public class test_10 {

	public static boolean isPrime(int num) {
		
		for(int i = 2; i < num; i++) {
			
			if(num % i == 0) {
				
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("17은 소수인가요? -> " + isPrime(17));

	}

}
