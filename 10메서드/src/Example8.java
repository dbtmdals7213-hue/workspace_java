
// [예제] 정수 배열에서 두 번째로 큰 값을 찾아 출력하는 기능의 메서드 만들기

public class Example8 {

	/*
		메서드 명: findSecondMax
		
		매개변수: int[] numbers
		
		기능:	 1. numbers 배열에서 가장 큰 값과 두 번째로 큰 값을 찾기
			 2. 두 번째로 큰 값 출력
			 
		조건:	 1. numbers 배열에 같은 값이 있어도 두 번째로 큰 "다른 값" 을 찾아야 합니다.
			 2. 최대값과 두 번째로 최대값이 같은 경우는 두 번째로 최대값으로 한 번만 출력합니다.
	*/
	public static void findSecondMax(int[] numbers) {// arr = {5, 1, 9, 2, 9, 7, 3}
		
		// 매개변수 numbers 로 받은 배열의 값들을 모두 검사해서 가장 최대값 하나 저장
		int max = numbers[0]; // 5
		
		// 매개변수 numbers 로 받은 배열의 값들을 모두 검사해서 두 번째로 큰 값 하나 저장
		int secondMax = Integer.MIN_VALUE; // Integer.MIN_VALUE 는 int 형이 가질 수 있는 가장 작은 수(-2147483648) 입니다.
		
		for(int i = 1; i < numbers.length; i++) {
			
			// current 변수에 현재 검사 중인 값을 저장합니다.
			int current = numbers[i];
			
			// ------- 경우1 -------
			// 만약 현재 검사 값(current)이 지금까지의 최대값(max)보다 크면?
			// -> current 가 새로운 최대값(max)이 되며,
			// - 기존 max 값은 두 번째로 큰 값(secondMax)이 됩니다.
			if(current > max) {
				
				secondMax = max; // 이전 max(가장 큰 값) 를 secondMax(두 번째로 큰 값 변수로 저장)
				max = current; // current 를 max(새로운 가장 큰 값) 으로 설정
			
			// ------- 경우2 -------
			// current 가 max 보다 크지 않다면, 두 번째로 큰 값 후보인지 확인한다.	
			// current 가 secondMax 보다 크고, 동시에 max 와 같지 않아야 한다.
			}else if(current > secondMax && current != max) {
				
				secondMax = current;
				//   1    =    1;
			}// else if
			
			System.out.println("i = " + i + ", current = " + current + ", max = " + max + ", secondMax = " + secondMax);
			
		}// for
		
		System.out.println("두 번째로 큰 값: " + secondMax); // 7
	}
	
	public static void main(String[] args) {
		// arr 배열 생성
		int[] arr = {5, 1, 9, 2, 9, 7, 3};
		
		// findSecondMax 메서드를 호출할 때 int[] numbers 매개변수에 arr 배열 주소번지를 전달해서
		// 배열에서 두 번째로 큰 값을 찾습니다.
		findSecondMax(arr);
	}

}
