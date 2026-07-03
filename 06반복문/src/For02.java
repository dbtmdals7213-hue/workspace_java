
/*
	주제: 자바에서 for 반복문을 사용하여 반복 작업 수행하는 예제.
*/

public class For02 {

	public static void main(String[] args) {
		
		//1. 반복을 제어할 i 변수 선언
		int i;
		
		//2. for 문을 사용하여 i = 1; 부터 4가 될 때까지만 1씩 증가하여 4번 반복해서 i 변수 값 출력
		for(i = 1; i <= 4; i++) {
			
			/*
				조건식의 결과가 true 인 동안 반복해서 실행됩니다.
				반복 1회차: i = 1 => 출력: 1
				반복 2회차: i = 2 => 출력: 2
				반복 3회차: i = 3 => 출력: 3
				반복 4회차: i = 4 => 출력: 4
			*/
			System.out.println(i);
			
		} // --- for
		//					----->> 5
		System.out.println("----->> " + i);
		
	} // --- main 메소드 끝

} // --- class 끝
