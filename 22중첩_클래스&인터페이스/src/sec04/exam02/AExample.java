package sec04.exam02;

class A {// 바깥 외부 클래스
	
	// 생성자
	A() {
		
		// 로컬 중첩 클래스 선언 가능
		class B {}
		
		// 로컬 중첩 클래스 B 를 이용해 객체 생성 가능
		B b = new B();
	}
	
	// 메소드
	void method() {
		
		// 로컬 중첩 클래스 선언 가능
		class B {}
				
		// 로컬 중첩 클래스 B 를 이용해 객체 생성 가능
		B b = new B();
	}
	
}

public class AExample {

	public static void main(String[] args) {
		
		
	}

}


