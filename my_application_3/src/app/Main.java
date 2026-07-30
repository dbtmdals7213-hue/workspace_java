package app;

// my_module_a 모듈 프로젝트에서 가져옴
import pack1.A;
import pack2.B;

// my_module_b 모듈 프로젝트에서 가져옴
import pack3.C;
import pack4.D;

public class Main {

	public static void main(String[] args) {
		
		// 인스턴스 VS 객체 차이점
		
		// 인스턴스 -> new 생성자().메소드명();
		
		// 객체 -> 클래스자료형 참조변수 = new 생성자();
		//		  참조변수.메소드명();
		//		  참조변수.메소드명();
		
		new A().method(); // A 인스턴스 생성 후, 인스턴스 method() 호출!
		new B().method(); // B 인스턴스 생성 후, 인스턴스 method() 호출!
		
		C c = new C(); // c 객체 생성 후
		c.method(); // c 객체 메소드 method() 호출!
		
		D d = new D(); // c 객체 생성 후
		d.method(); // c 객체 메소드 method() 호출!
	}

}
