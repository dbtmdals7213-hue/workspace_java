
// [예제] 	정수 하나를 매개변수로 전달받아 절대값을 구해 되돌려주는 메서드 만들기

public class MethodEx03 {

	// abs 메서드
	// 기능: 정수 하나를 매개변수로 전달받아 절대값을 구해 되돌려주는 기능
	public static int abs(int data) {
		
		if(data < 0) {// data 매개변수로 전달 받은 값이 음수이면?
			
			data = -data; // data 매개변수 값을 양수(절대값)로 변경
		}

		return data; // 절대값을 되돌려줍니다.
	}

	
	// main 메서드
	// 기능: 자바프로그램을 처음 시작 시키는 기능
	public static void main(String[] args) {
		
		System.out.println("-1 절대값 => " + abs(-1));
		System.out.println("-10 절대값 => " + abs(-10));
	}

}
