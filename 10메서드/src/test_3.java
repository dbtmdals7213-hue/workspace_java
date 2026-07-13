
/*
	문제 3. 짝수 판별하기
		 - 메서드 이름: isEven
		 - 매개변수: int number
		 - 반환 타입: boolean
		 - 설명: 입력받은 정수가 짝수면 true, 홀수면 false를 반환하는 메서드를 작성하세요.
*/

public class test_3 {

	public static boolean isEven(int number) {
		
		if(number % 2 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("7은 짝수이다 -> " + isEven(7)); // false
		System.out.println("10은 짝수이다 -> " + isEven(10)); // true
	}

}
