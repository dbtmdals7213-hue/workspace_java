
// 현재 B 클래스가 PB 패키지 경로에 만들어져 있다고 자바 컴파일러에게 알려주는 패키지 선언문
package PB;

/*
	다른 패키지 PA 에 만들어져 있는 A 클래스를 현재 PB 패키지의 B 클래스 내부에서 사용하기 위해
	import 구문을 작성해서 자바 컴파일러에게 알려주는 구문
	
	작성방법
		import 외부다른패키지명.사용할외부클래스명;
*/
import PA.A;

// 다른 패키지 PA 에 만들어져 있는 부모 A 클래스의 멤버를 상속 받아 새로운 자식 B 클래스 만들기
public class B extends A {

	void set() {
		
		//[1] default 변수 i
		//	  부모 A 클래스에서 접근 제어자를 아무것도 안 붙여 만든 변수
		//	  default 는 "같은 패키지" 에서만 접근을 허용하는데,
		//	  지금 B 는 다른 패키지(PA) 에 있으므로 자식 클래스여도 접근 불가!
		// super.i = 1;
		
		//[2] protected 변수 pro
		//	  protected 는 "같은 패키지" 또는 "다른 패키지의 자식 클래스" 에게
		//	  접근을 허용한다. B 는 다른 패키지지만  A 의 자식이므로 접근 가능!
		//	  (default 와의 차이가 바로 이 "자식 예외" 한 가지다.)
		super.pro = 2;
		
		//[3] private 변수 pri
		//	  private 는 "선언한 A 클래스의 {} 안" 에서만 접근 허용.
		//	  같은 패키지든 다른 패키지든 자식이든 아니든 전부 불가!
		// super.pri = 3;
		
		//[4] public 변수 pub
		//	  public 은 패키지가 달라도, 상속 관계가 아니여도
		//	  어디서든 접근을 허용한다. 접근 가능!
		pub = 4; // 역시 super. 을 붙여 부모 영역임을 명시할 수 있다.
	}
	
	public static void main(String[] args) {
		
		B b = new B();
		b.set(); // pro 에 2, pub 에 4저장(i 와 pri 는 접근 불가라 건드리지 못함)
		b.print(); // 부모에게 상속받은 print() 메소드 호출
	}

}
