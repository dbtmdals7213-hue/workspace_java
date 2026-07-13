/*
	[예제] 정수들이 저장되어 있는 배열을 매개변수로 전달받아, 배열 안의 모든 값을 더한 후
		  그 결과를 출력하는 sumArray 메서드를 정의하고, main 메서드에서 호출해서 사용합니다.
*/

public class Example6 {

	// sumArray 메서드 정의
	// 기능: 배열에 저장된 모든 값을 더해서 출력하기
	public static void sumArray(int[] numbers) {// <--- {1, 2, 3, 4, 5}
		
		int sum = 0; // 합계를 저장할 변수
		
		// 매개변수 numbers 로 전달받은 배열에 저장된 숫자의 개수만큼 반복하면서 모든 숫자를 sum 에 누적
		for(int i = 0; i < numbers.length; i++) {
			
			sum += numbers[i]; // numbers[i] 는 배열 안의 각 숫자 값들
		}
		
		// 최종 합계 출력
		System.out.println("numbers 배열의 총합: " + sum);
		//					numbers 배열의 총합: 15
	}
	
	// main 메서드
	public static void main(String[] args) {
		
		// 임의의 정수 5개를 가진 배열 생성
		int[] arr = {1, 2, 3, 4, 5};
		
		// sumArray 메서드 호출 -> arr 배열을 int[] numbers 매개변수로 전달
		sumArray(arr);
	}

}
