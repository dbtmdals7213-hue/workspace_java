
/*
	조합3. 상속  관계에서 자식 객체 메모리 생성 시 매개변수가 1개 작성된 생성자를 호출하면
		  부모 클래스의 기본생성자가 super(); 구문에 의해 자동으로 호출되는 조합
		  
		  	new 자식클래스생성자(값); ---> 부모 클래스의 기본 생성자가 호출되어 실행됨.
*/

class F {// 부모 클래스
	
	public F() { System.out.println("부모 F 의 기본 생성자 실행됨") ;} // F 의 기본 생성자
	
	public F(int d) { System.out.println("부모 F 의 매개변수 1개 작성된 생성자 실행됨"); } // F 의 매개변수 1개인 생성자
}

// 부모 F 클래스를 상속 받아 새롭게 확장한 자식 G 클래스 만들기
class G extends F {
	
	// 기본 생성자
	public G() {
		
		// super(); F 부모 기본 생성자 호출 구문 생략됨 <--- 이 구문 무조건 실행될 것임
		System.err.println("자식 G 의 기본 생성자 실행됨");
	}
	
	// 매개변수가 1개 작성된 생성자
	public G(int x) {
		
		// super(); F 부모 기본 생성자 호출 구문 생략됨 <--- 이 구문 무조건 실행될 것임
		System.out.println("자식 G 의 매개변수가 1개 작성된 생성자 실행됨");
	}
	
}

public class Ex3 {

	public static void main(String[] args) {
		
		// G 자식 클래스의 매개변수가 1개 작성된 생성자 호출하면서 객체 생성
		new G(5);
	}

}
