
// [예제] 가변길이 매개변수를 사용해서 합계를 구하는 메서드 만들기

public class Example5 {

	/*
		[가변길이 매개변수란?]
		
			 - 메서드에서 전달받은 값의 개수를 미리 정하지 않고,
			   메서드를 호출할 때 원하는 값을 넘길 수 있게 해주는 변수
			  
			 - 자바에서는 ...(점 3개) 를 붙여서 가변길이 매개변수를 표현합니다.
		
		[가변길이 매개변수 선언 문법]
		
			public static 반환타입 메서드명(자료형... 매개변수명) {
			
				
			}
	*/
	// [메서드 선언]
	// 메서드명: sum
	// 기능: 여러 개의 정수(int)를 가변길이 매개변수 numbers 로 받아 모두 더한 값을 반환해주는 기능
	public static int sum(int... numbers) {
		
		// [합계 저장용 변수]
		int total = 0;
		
		// [반복문: 가변길이 매개변수 numbers 로 받은 배열의 값을 반복해서 얻어 모두 더함]
		for(int number : numbers) {
			
			// numbers 배열 안에 있는 값들을 하나씩 number 라는 변수에 담아서 반복
			total += number;
		}
		
		// 최종 합계 값을 반환합니다.
		return total;
	}
	
	public static void main(String[] args) {
		
		//1. sum 메서드를 호출할 때 1, 2, 3 세 개의 값을 넘겨봅니다.
		int result1 = sum(1, 2, 3); // 1 + 2 + 3 = 6
		System.out.println("Sum of 1, 2, 3 : " + result1); // 6
		
		//2. sum 메서드를 호출할 때 10, 20, 30, 40, 50 다섯 개의 값을 넘겨봅니다.
		int result2 = sum(10, 20, 30, 40, 50);
		System.out.println("Sum of 10, 20, 30, 40, 50 : " + result2);
		
		//3. sum 메서드를 호출할 때 아무 값도 넘기지 않으면?
		int result3 = sum();
		System.out.println("Sum with no arguments : " + result3);
	}
	
}

/*
	int... numbers 라고 매개변수가 작성되어 있을 때:
	sum(1, 2, 3) 이렇게 호출하면 → numbers = {1, 2, 3} 이런 배열로 들어옵니다.
	sum(10, 20) 이렇게 호출하면 → numbers = {10, 20}
	sum() 이렇게 아무 값도 안주면 → numbers = {} (비어있는 배열)
*/
