package pack1;

import pack2.B; // 같은 my_module_a 모듈 프로젝트의 다른 pack2 패키지의 B 클래스 가져옴.

import pack3.C; // my_module_b 모듈 프로젝트 소속의 C 클래스 사용을 위해 가져옴.

public class A {

	// 메소드 선언
	public void method() {
		
		System.out.println("A-method 실행");
		
		// B 클래스 사용
		B b = new B();
		b.method();
	}
	
	// 메소드 선언
	public C getC() {
		
		return new C();
	}
}
