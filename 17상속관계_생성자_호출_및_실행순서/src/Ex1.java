
/*
	주제:	 클래스 간의 상속 관계에서 자식 객체 메모리를 생성했을 때
		 자식 생성자와 부모 클래스의 생성자 호출 및 실행 순서
		 
		참고. 호출과 실행은 다른 것이다!
*/

// 할아버지 역할 부모 클래스 만들기
class A {
	
	// A 클래스의 기본 생성자
	public A() {

		System.out.println("A 부모 클래스의 생성자 A 실행!");
	}
}

// 아버지 역할 A 의 자식 클래스 만들기
class B extends A {
	
	// B 클래스의 기본 생성자
	public B() {
	
		System.out.println("B 아버지 클래스의 생성자 B 실행!");
	}
}

// 아들 역할 B 의 자식 클래스 만들기
class C extends B {
	
	// C 클래스의 기본 생성자
	public C() {
		
		System.out.println("C 아들 클래스의 생성자 C 실행!");
	}
}

public class Ex1 {

	public static void main(String[] args) {
		
		// 아들 역할을 하는 C 클래스의 객체 메모리 생성 시 기본 생성자 호출!
		C c = new C();
	}

}
