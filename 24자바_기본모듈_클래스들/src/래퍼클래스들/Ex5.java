package 래퍼클래스들;

public class Ex5 {

	public static void main(String[] args) {
		
		int n1 = 10; // <- 기본 자료형 int 값 10. Stack 공간에 직접 저장된다.
		
		int n2; // <- 기본 자료형 변수 선언만 함(아직 값 없음)
		
		Integer num1; // <- 참조 자료형 변수 선언만 함(아직 객체 주소 값 없음)
		
		// 박싱(수동 박싱)은 이렇게 해야 한다.
		// 방법2. Integer 래퍼 클래스의 static 메소드 valueOf() 사용
		// num1 = Integer.valueOf(n1); <- 수동 박싱
		
		// 아래 한 줄을 쓰면 자동(오토) 박싱이 일어나 10을 Integer 객체의 인스턴스 변수에 저장하게 된다.
		num1 = n1;
		//	 = 10;
		//	 = Integer.valueOf(n1); <- 컴파일러가 실제로는 이렇게 자동으로 작성해 준다.
		
		System.out.println("자동(오토) 박싱");
		System.out.println("기본 자료형 변수 n1 의 값: " + n1); // 10
		// toString(): Integer 객체 안에 저장된 10을 문자열 "10" 으로 만들어 반환한다.
		System.out.println("참조 자료형 변수 num1 의 Integer 래퍼 객체 메모리 내부에 자동으로 박싱된 10: " + num1.toString());
		
		// 자동(오토) 박싱
		// 기본 자료형 10을 자동(오토) 박싱해서 저장
		Integer num3 = 10; // Integer.valueOf(10);
						   // 위와 같이 수동으로 박싱한 것과 같은 의미이다.
		// 자동(오토) 언박싱
		// Integer 객체 메모리 내부에 저장된 기본 자료형 10을 자동(오토) 언박싱으로 꺼내서 얻자
		int value = num3; // num3.intValue();
						  // 위와 같이 수동으로 언박싱한 코드와 같은 의미이다.
		
		System.out.println("value: " + value);
		
	}// === main 메소드

}// --- Ex5 클래스


