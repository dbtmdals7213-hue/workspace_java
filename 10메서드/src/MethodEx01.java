
// [예제] Hello World 출력하는 기능의 메서드 만들기

/*
	void 형 메서드
		메서드의 몸체에 기술한 명령을 실행할 뿐 메서드의 실행 결과를 되돌리지 않는 경우가 있습니다.
		메서드의 리턴 값이 없는 경우 "리턴이 없다" 라는 것을 적극적으로 표현하기 위해서
		void 라는 특별한 자료형이 준비되어 있습니다.
*/

public class MethodEx01 {

	// hello_func 메서드
	// Hello World 출력하는 기능
	public static void hello_func() {
		System.out.println("Hello World");
	}
	
	
	// main 메서드
	// 기능: 자바프로그램 처음 가동 시키는 기능
	public static void main(String[] args) {
		
		// 사용자 정의 hello_func 메서드 호출해서 사용
		hello_func();
		
	}

}
