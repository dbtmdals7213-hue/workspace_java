
// 부모 클래스: 기존에 만들어져 있는 클래스
class Parent {
	
	public void parentPrn() {
		
		System.out.println("Parent 부모 클래스의 메소드는 상속될 것이다.");
	}
	
}

// 자식 클래스: 새롭게 만드는 클래스
// -> Child 자식 클래스는 Parent 부모 클래스의 메소드를 상속받아서 새롭게 정의함. -> extends 예약어 사용
class Child extends Parent{
	
	/*
		Parent 부모 클래스에 정의되어 있는 메소드를 상속받아 아래와 같이 작성되어 있는 상태이다.
		단! 우리 개발자 눈에는 보이지 않는다.
		
		public void parentPrn() {
			
			System.out.println("Parent 부모 클래스의 메소드는 상속될 것이다.");
		}
		
	*/
	// Child 자식 클래스에 직접 만들어 놓은 메소드
	public void childPrn() {
		
		System.out.println("Child 클래스의 메소드는 Parent 부모 클래스에서 사용할 수 없다.");
	}
	
}


public class Ex1 {

	public static void main(String[] args) {
		
		// 기존에 만들어져 있던 부모 역할하는 Parent 클래스의 객체 메모리 생성
		Parent p = new Parent();
		p.parentPrn(); // Parent 자기 자신 객체 메모리 내부의 parentPrn() 메소드 호출 가능
		// p.childPrn(); // 컴파일 에러 발생
		
		// Parent 부모 클래스의 메소드를 상속받아 새롭게 설계한 Child 자식 클래스의 객체 메모리 생성
		Child c = new Child();
		c.parentPrn(); // Parent 부로 클래스로부터 상속받은 메소드 호출 가능
		c.childPrn(); // Child 자기 자신 클래스에 만들어놨던 메소드 호출 가능
		
	}

}


