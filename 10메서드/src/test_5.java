
/*
	문제 5. 절대값 구하기
		 - 메서드 이름: absoluteValue
		 - 매개변수: int num
		 - 반환 타입: int
		 - 설명: 정수를 입력받아 그 수의 절대값을 반환하는 메서드를 작성하세요. (예: -5 입력 시 5 반환)
*/

public class test_5 {

	public static int absoluteValue(int num) {
		
		int absoluteNum = 0;
		
		if(num < 0) {
			
			absoluteNum = -num;
		}
		
		return absoluteNum;
	}
	
	public static void main(String[] args) {
		
		System.out.println("-3 절대값 = " + absoluteValue(-3));
	}
	
}
