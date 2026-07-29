package sec05.exam02;

class A {// 바깥 외부 클래스
	
	String field = "A-field"; // A 바깥 외부 클래스의 인스턴스 변수
	
	void method() {  System.out.println("A-method"); } // A 바깥 외부 클래스의 인스턴스 메소드
	
	// 인스턴스 멤버 중첩 클래스 B 선언
	class B {
		
		String field = "B-fi"; // B 인스턴스 멤버 중첩 클래스의 인스턴스 변수
		
		void method() { System.out.println("B-method"); } // B 인스턴스 멤버 중첩 클래스 내부의 인스턴스 메소드
		
		void print() {// B 인스턴스 멤버 중첩 클래스 내부의 인스턴스 메소드 하나 더 추가
			
			// B 인스턴스 멤버 중첩 클래스의 인스턴스 변수와 인스턴스 메소드를 사용하기 위해 this 이용
			System.out.println(this.field);
			this.method();
			
			// 바깥 외부 A 클래스의 객체에 포함된 인스턴스 변수와 인스턴스 메소드를 사용하기 위해 바깥클래스명.this 이용
			System.out.println(A.this.field);
			A.this.method();
		}
	}
	
	// 바깥 외부 A 의 인스턴스 메소드 선언
	void useB() {
		
		B b = new B();
		b.print();
	}
}

public class AExample {

	public static void main(String[] args) {
		
		// 외부 바깥 A 객체 메모리의 useB 인스턴스 메소드 호출
		new A().useB();
	}

}


