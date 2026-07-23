
// 주제: 변수 초기화와 지역 변수에 대해

public class InitTest {

	// 객체 변수 만들기
	int x; // <- int 의 기본 값으로 0으로 자동 초기화
	int y = x; // <- x 변수는 이미 0으로 초기화 되어있어 y 도 0으로 명시적 초기화가 이루어짐
	
	
	// 객체 메소드 만들기
	public void method1(int y) {// <-- int y; 매개변수이자 지역 변수
		
		// 지역 변수
		// - 메소드 {} 블럭 내부에 선언된 변수
		// - JVM 의 Stack 영역에 포함되며, 해당 method 메소드 실행 중에만 지역 변수 i 가 유효
		// - 지역 변수 i 는 반드시 개발자가 직접 명시적 초기화 한 후 사용해야 합니다.
		int i; // 지역 변수 i 의 값을 다른 곳에서 사용 시 에러 발생!
			   // 지역 변수 i 의 값을 초기화 하지 않았기 때문
		
		// int j = i; <--- X 컴파일 에러: 지역 변수 i 의 값은 초기화 되지 않음
	}
	
	
	// 클래스 변수 만들기
	// - 생성된 모든 객체 메모리가 공유하는 클래스 변수이다.
	// - 명시적 초기화 가능
	static int[] arr = new int[10]; // <--- 개발자가 직접 배열 메모리를 만들어 명시적 초기화
	
	
	// static 클래스 초기화 블럭 이용해 클래스 변수 값 초기화 가능
	static {
		
		// arr 배열의 각 칸에 1 ~ 10 사이의 랜덤 정수 값 초기화
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = (int)(Math.random() * 10) + 1;
		}
	}// --- static {} 클래스 초기화 블럭 끝
	
	
	public static void main(String[] args) {
		
		// 객체 생성 없이 클래스 변수 arr 에 저장된 배열을 가져와 사용해보자
		
		// arr 에 저장된 배열 메모리의 각 칸의 랜덤 값을 반복해서 얻어 출력
		for(int i = 0; i < InitTest.arr.length; i++) {
			
			System.err.println("arr[" + i + "] : " + InitTest.arr[i]);
		}
		
	}

}


