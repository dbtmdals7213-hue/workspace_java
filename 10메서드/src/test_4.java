
/*
	문제 4. 세 정수 중 최댓값 구하기
		 - 메서드 이름: maxOfThree
		 - 매개변수: int a, int b, int c
		 - 반환 타입: int
		 - 설명: 세 개의 정수를 입력받아 그중 가장 큰 값을 찾아 반환하는 메서드를 작성하세요.
*/

public class test_4 {

	public static int maxOfThree(int a, int b, int c) {
		
		int maxNum = a;
		if(maxNum < b) {
			maxNum = b;
		}else if(maxNum < c) {
			maxNum = c;
		}
		
		return maxNum;
	}
	
	public static void main(String[] args) {
		
		System.out.println("47, 33, 51 중 가장 큰 수: " + maxOfThree(47, 33, 51)); // 51
	}
	
}
