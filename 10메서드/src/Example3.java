
// [예제]	 반환할 값이 없고 매개변수도 없는 메소드 정의 및 호출해서 사용

public class Example3 {

	/*
		반환할 값이 없고 매개변수도 없는 메소드 작성 방법
		
			public static void 메서드명() {
			
				메서드가 해야할 기능 코드;
			}
		void -> 반환할 값이 없다.
	*/
	
	public static void greet() {
		
		System.out.println("안녕하세요");
		// return 결과값; <- 작성 X
	}
	
	public static void main(String[] args) {
		
		// "안녕하세요" 출력하고 싶을 때 greet() 메소드 호출
		greet();
		
		// "안녕하세요" 10번 반복해서 출력하고 싶을 때 for 반복문 안에 greet() 메소드 호출 구문 사용
		for(int i = 1; i <= 10; i++) {
			
			greet();
		}
		
	}

}
