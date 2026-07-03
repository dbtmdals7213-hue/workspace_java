
/*
	예제 주제: 1부터 100까지 소수를 모두 출력하고, 그 총합 구하기
	
	※ 소수란? 1과 자기 자신으로만 나누어 떨어지는 1보다 큰 양의 정수(예: 2, 3, 5, 7, 11 ...)
*/

public class For06 {

	public static void main(String[] args) {
		
		int primeSum = 0; // 소수들의 합을 누적할 변수 선언 후 초기 값 0 저장
		int count = 0; // 발견된 소수의 개수를 세어 저장할 변수 선언 후 초기 값 0 저장
		
		System.out.println("<< \t 1부터 100사이의 소수 목록 \t >>");
		
		// 1은 소수가 아니므로 2부터 100까지 반복 검사합니다.
		for(int i = 2; i <= 100; i++) {
			
			boolean isPrime = true; // <- true: i 변수 값이 소수라고 가정
			
			// 2부터 자기 자신(i 변수 값)보다 1작은 수까지 나누어봅니다.
			for(int j = 2; j < i; j++) {
				
				// 나누어 떨어지는 수가 하나라도 있다면 소수가 아님
				if(i % j == 0) {
					isPrime = false;
					
					break; // 소수가 아니라는 것을 알았으니 더 이상 반복 검사할 필요가 없이 반복문 종료
				} // if
				
			} // 안쪽 for
			
			// 안쪽 내부 for 반복문이 끝난 후, isPrime 이 여전히 true 라면 소수임
			if(isPrime) {
				System.out.print(i + "\t"); // 소수 Tab
				primeSum += i; // 총합에 더하기
				count++; // 소수 개수 증가
				
				// 한 줄에 5개씩 출력하기 위한 줄바꿈 처리
				if(count % 5 == 0) {
					System.out.println();
				}
			}
			
		} // 바깥 for
		System.out.println("===================================");
		System.out.println("1부터 100까지 발견된 소수의 개수: " + count + "개");
		System.out.println("1부터 100까지 소수의 총합: " + primeSum);
		
	}

}
