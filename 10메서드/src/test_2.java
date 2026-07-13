
/*
	문제 2. 문자열 반복 출력하기
		 - 메서드 이름: printLoop
		 - 매개변수: String str, int n
		 - 반환 타입: void
		 - 설명: 입력받은 문자열(str)을 n번 반복해서 화면에 출력하는 메서드를 작성하세요. (결과를 반환하지 않고 출력만 합니다.)
*/

public class test_2 {
	
	public static void printLoop(String str, int n) {
		
		for(int i = 1; i <= n; i++) {
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		
		printLoop("Hello World", 5);
	}
}
