
/*
	주제:	 메소드 오버라이딩 예제
		 부모 클래스의 메소드를 자식 클래스에서 재정의하는 개념을 설명하는 코드
*/
//========================== 부모 클래스 ==========================

// 모든 도형의 공통 설계도 역할을 하는 부모 클래스
class DObject {
	
	// 변수: 접근제어자 부모클래스자료형 참조변수 선언
	public DObject dObject; // <--- DObject 부모 클래스를 상속 받은 자식 객체 메모리 주소 번지 저장 가능
	
	// 생성자
	// 객체가 생성될 때 자동으로 호출되는 기본 생성자 선언
	public DObject() {
		
		this.dObject = null; // dObject 참조변수를 null 로 초기화 가능
	}
	
	// 메소드: 도형을 그리는 공통 기능을 표현한 메소드
	public void draw() {
		
		System.out.println("도형을 그린다.");
	}
}

//========================== 자식 클래스1 ==========================

// Line 자식 클래스를 새롭게 만들 때 DObject 부모 클래스를 상속 받아 만든다.
class Line extends DObject {
	
	// 부모 DObject 의 draw() 메소드를 그대로 상속 받아 사용하지 않고
	// 자식 Line 클래스의 기능에 맞게 재정의(메소드 오버라이딩)해서 사용하자
	// 요약: 부모 DObject 클래스에 만들어 놓은 draw() 메소드 오버라이딩 하자
	@Override
	public void draw() {// <--- 부모 클래스의 메소드 선언부 그대로 작성
		
		// 선을 그리는 동작으로 변경
		System.out.println("선을 그린다."); // <--- 부모 클래스의 메소드 구현부 재정의
	}
	
	/*
		참고 설명:
		- Line 객체로 draw() 를 호출하면 부모(DObject)의 draw() 는 실행되지 않는다.
		- 자식(Line) 에서 오버라이딩 한 draw() 가 부모 메소드를 가려(은닉) 대신 실행된다.
	*/
}

//========================== 자식 클래스2 ==========================

// Circle 자식 클래스도 마찬가지로 DObject 부모 클래스를 상속 받아 만든다.
class Circle extends DObject {
	
	// 부모 DObject 클래스의 draw() 메소드 오버라이딩 하자
	@Override
	public void draw() {
		
		// 원을 그리는 동작으로 재작성
		System.out.println("원 그리기");
	}
}

public class Ex2 {

	public static void main(String[] args) {
		
		/*
			부모 클래스 -> class DObject
			자식 클래스들 -> class Line, class Circle
			
		*/
		// ========== 1. 자식 클래스의 객체 생성 ==========
		
		Line line = new Line();
		
		line.draw(); // 메소드 오버라이딩 된 Line 의 draw() 메소드가 최종 실행되어 "선을 그린다." 출력됨
		
		// ========== 2. 업 캐스팅 기능을 사용하여 자식 클래스의 객체 생성 ==========
		// 업 캐스팅? 부모 클래스 자료형의 참조변수 하나만 만들어 하나 이상의 자식 객체 메모리의 주소 번지 저장
		DObject dObject = new Circle();
		
		dObject.draw(); // 부모 DObject 의 dObject 참조변수로 draw() 메소드를 호출하면
						// 최종 출력이? "원 그리기" 된다.
	}

}


