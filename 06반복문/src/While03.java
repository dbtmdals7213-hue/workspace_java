
// 주제: 반복 처리할 문장을 한 번 수행한 후 조건식을 나중에 검사해 반복하는 do While 반복문 사용
//		1 ~ 5 까지 반복해서 출력하는 예

public class While03 {

	public static void main(String[] args) {
		
		int i = 1;
		
		do {
			// 무조건 한 번 실행한 후 다시 조건식이 참이면 실행될 코드;
			System.out.println(i);
			i++;
			
		}while(i <= 5); // do while 반복문은 반드시 ; 세미콜론 기호로 끝맺음을 해야한다.
		
	}

}
