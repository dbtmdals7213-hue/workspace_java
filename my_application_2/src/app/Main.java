package app;

import pack1.A; // my_module_a 모듈 프로젝트에서 pack1 패키지에 만들어 놓은 class A 불러오기
// import pack2.B; // my_module_a 모듈 프로젝트에서 pack2 패키지에 만들어 놓은 class B 불러오기

import pack3.C; // my_module_b 모듈 프로젝트에서 pack3 패키지에 만들어 놓은 class C 불러오기
import pack4.D; // my_module_b 모듈 프로젝트에서 pack4 패키지에 만들어 놓은 class D 불러오기

public class Main {

	public static void main(String[] args) {
		
		// my_module_a 모듈 프로젝트 내부의 pack1, pack2 패키지에 만들어 놓은 A, B 클래스를 객체 생성 가능
		A a = new A(); a.method();
		// B b = new B(); b.method();
		
		// my_module_b 모듈 프로젝트를 전이적 의존하고 있기 때문에
		// C 클래스의 객체 생성 가능하고, 메소드 호출 가능!
		C c = new C(); c.method();
		
		// my_module_a 모듈 프로젝트에 포함된 A 클래스의 객체의 getC() 메소드를 호출하여
		// 반환 값으로 new C(); 객체를 반환받아 result 변수에 저장 가능!
		C result = a.getC();
		result.method();

		// my_module_b 모듈 프로젝트를 전이적 의존하고 있기 때문에
		// D 클래스의 객체 생성 가능하고, 메소드 호출 가능!
		D d = new D();	d.method();
	}

}
