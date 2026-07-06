
//[예제] 1부터 10 사이의 짝수의 합과 홀수의 합 구하기

public class E01 {

	public static void main(String[] args) {
		int n; // 제어변수 선언
		int odd_tot, even_tot; // 홀수의 합과 짝수의 합을 누적해서 저장할 변수 선언
		
		// 제어변수 값이 홀수가 구해지도록 하여 그 제어변수 값을 누적해서 홀수의 합을 구합니다.
		for(odd_tot = 0, n = 1; n <= 10; n += 2) {
			
			odd_tot += n; // 구해진 n 변수값 odd_tot 변수에 반복해서 누적
		}
		// 참고: 만일 1개 이상의 변수에 초기값을 지정하려할 때 , 로 연결하여 기술하면 됩니다.

		// 제어변수 값이 짝수가 구해지도록 하여 그 제어변수 값을 누적해서 짝수의 합을 구합니다.
		for(even_tot = 0, n = 2; n <= 10; n += 2) {
			
			even_tot += n;
		}
			
		System.out.println("odd_tot(1 + 3 + 5 + 7 + 9) = " + odd_tot);
		// 출력: odd_tot(1 + 3 + 5 + 7 + 9) = 25
		
		System.out.println("even_tot(2 + 4 + 6 + 8 + 10) = " + even_tot);
		// 출력: even_tot(2 + 4 + 6 + 8 + 10) = 30
	}

}
