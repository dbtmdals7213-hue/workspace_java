
// 예제: 2단부터 9단까지 구구단 출력하기

public class E03 {

	public static void main(String[] args) {
		
		int dan; // 단수를 저장하는 변수 선언
		
		int n; // 곱하는 수를 저장하는 변수 선언
		
		for(dan = 2; dan <= 9; dan++) { // 2단 ~ 9단까지 단수만큼 반복
			
			System.out.println("*** " + dan + "단 ***");
			
			for(n = 1; n <= 9; n++) { // 곱하는 수만큼 반복
				
				System.out.println(dan + " X " + n + " = " + dan * n);
				
			}// 안쪽 for 문의 끝
			
		}// 바깥 for 문의 끝

	}// main 메소드 끝

}// E03 클래스 끝
