
// [예제] while 문을 이용한 무한 루프 - 파일이름 : F03.java
/*
	while( true ) {
	
		 .....
	
	}


	while 문은 조건식의 결과가 참이면 반복을 계속하고 거짓이면 반복문을 벗어납니다.
	while 문을 이용한 무한 루프는 일반적으로 조건식에 true 를 기술하여 표현합니다.

*/

public class F03 {

	public static void main(String[] args) {
		
		int n = 0;
		
		while(true) {
			
			System.out.println("Fall Wonderland");
			
			if(++n >= 10) {
				break;
			}
			// 증감식 안 적으면 위 출력문이 무한 반복해서 출력됩니다.
		}
		
	}

}
