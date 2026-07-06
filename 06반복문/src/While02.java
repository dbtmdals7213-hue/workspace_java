
// 주제: 1부터 10사이의 짝수의 합 구하기

public class While02 {

	public static void main(String[] args) {
		
		// 1부터 10사이의 짝수 합 저장할 누적 변수 선언
		int tot = 0;
		
		// 초기식
		int n = 0;
		
		while(n <= 8) {
			
			n += 2; // 증감식
			
			tot += n; // 반복 실행할 코드

			System.out.println(tot);
		}
		
		System.out.println("tot = " + tot);
	}
	
}
