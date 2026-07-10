
// [예제] 주어진 값까지의 자연수의 합 구하기

public class MethodEx02 {

	// sum 메서드
	// 기능: 숫자 1부터 n 매개변수로 전달 받은 값까지의 합을 구해 출력하는 기능
	public static void sum(int n) {// <- int n 을 매개변수라고 부른다.
		
		int i;		// 제어 변수
		int tot = 0;	// 합을 누적할 변수
		
		for(i = 1; i <= n; i++) {// 기능: 숫자 1부터 n 매개변수로 전달된 값까지 tot 변수에 누적
			
			tot += i;
		}
		
		System.out.println("1 ~ " + n + " = " + tot ); // 구해진 합을 출력
	}
	
	// main 메서드
	// 기능: 자바프로그램의 코드를 처음 실행 시키는 기능
	public static void main(String[] args) {
		
		// sum 메서드 호출 구문
		// 의미: sum 메소드를 호출할 때 int n 매개변수로 5를 전달해서 숫자1 부터 5까지 합을 구해 출력하게 하자.
		sum(5);
		
		// sum 메서드 호출 구문
		// 의미: sum 메서드야! 내가 10을 전달해줄게 니가 매개변수 int n 으로 10 전달 받아서
		//		숫자 1부터 10까지 합을 구해 출력해줘!
		sum(10);
	}

}
