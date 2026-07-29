package sec02.exam02;

class A {// 바깥 외부 클래스
	
	/* public A() {} 자바 컴파일러가 기본 생성자 자동 추가 */
	
	// 인스턴스 멤버 중첩 클래스 B 만들기
	class B {
		
		int field1 = 1; // 인스턴스 변수 선언 가능!
		
		static int field2 = 2; // 클래스 변수 선언 가능!(JDK 17버전부터 작성 가능)
		
		B() { System.out.println("B-생성자 실행됨"); } // 생성자 선언 가능!
		
		void method1() { System.out.println("B-method1 실행됨"); } // 인스턴스 메소드 선언 가능!
		
		static void method2() { System.out.println("B-method2 실행됨"); } // 클래스 메소드 선언 가능!(JDK 17버전부터 작성 가능)
	}
	
	// 바깥 외부 A 클래스의 인스턴스 메소드 선언
	void useB() {
		
		// B 인스턴스 멤버 중첩 클래스를 이용해 객체 생성 및 메소드 호출해서 사용 가능한가?
		B b = new B();
		b.method1(); // 인스턴스 메소드 호출 가능!
		System.out.println(b.field1); // 인스턴스 변수 값 가져와 출력 가능!
	}
}

public class AExample {

	public static void main(String[] args) {
		
		// 바깥 외부 A 클래스의 객체 생성
		A a = new A();
		// 바깥 외부 A 클래스의 객체 메모리에 포함된 useB() 인스턴스 메소드 호출!
		a.useB();
	}

}
