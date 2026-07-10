
// [예제] 매개변수로 전달받은 하나의 문자열을 화면에 출력한 후 한 줄 줄바꿈 하는 기능의 메서드 만들기

public class Example2 {

	// 사용자 정의 메서드 printMessage 만들기
	// 기능: 매개변수 message 로 전달받은 문자열을 화면에 출력 후 한 줄 줄바꿈하는 기능
	public static void printMessage(String message) {
		
			// void -> "메서드를 호출한 줄로 반환할 값이 없다" 라는 의미의 예약어.
		
		System.out.println(message);
	}
	
	
	// main 메서드
	public static void main(String[] args) {
		// "안녕하세요" 출력 후 한 줄 줄바꿈 기능 printMessage 메서드에게 시키고 싶다.
		printMessage("안녕하세요");
		
		// "집에 가고 싶다" 출력 후 한 줄 줄바꿈 기능 printMessage 메서드에게 시키고 싶다.
		printMessage("집에 가고 싶다");
	}

}
