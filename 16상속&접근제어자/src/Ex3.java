
// 주제: 두 클래스의 상속 관계에서 private 접근 제어자를 지정한 변수 또는 메소드 사용 실습

//=======================================================================
// 부모 클래스 A
//=======================================================================

// 참고. Object 클래스는 자바에서 모든 클래스의 부모 역할을 하는 클래스이기 때문에
//	    A 클래스를 만들어 놓으면 Object 클래스를 상속 받고 있는 형태가 된다.
class A {// 부모 역할을 하는 클래스
	
	// 변수를 선언하는 문법: 접근제어자 자료형 변수명
	public int p; // p 변수 메모리는 어디서든지 접근 가능(public 이기 때문)
	
	private int n;
	
	public void setN(int n) {// 매개변수 n: 바깥 클래스에서 전달해준 새 값이 잠시 담기는 변수
		
		this.n = n;
		// this.n : "이 객체가 소유한" private 변수 n(왼쪽)
		// = : 매개변수 n 의 값을 대입
		// n : 방금 매개변수로 전달받은 값(오른쪽)
	}
	
	public int getN() {
		
		return this.n; // return : 이 메소드를 호출한 쪽으로 값을 "돌려준다" 는 뜻
	}
}// --- class A

//=======================================================================
// 자식 클래스 B
// -> 기존에 만들어져 있는 A 클래스의 멤버를 상속 받아 새로운 기능을 확장한 B 자식 클래스 만든다.
//=======================================================================
class B extends A {// extends A : "B 는 A 를 상속받는다." 는 선언
	
	private int m; // 5
	
	// private 변수 m 에 값을 저장하는 setter 메소드
	public void setM(int m) {
		
		this.m = m; // this.m(B 객체 소유의 객체 변수) 에 매개변수 m 의 값을 저장
	}
	
	// private 변수 m 의 값을 외부 클래스로 반환하는 getter 메소드
	public int getM() {
		
		return this.m;
	}
	
	// B 객체가 가진 모든 변수 정보를 한 줄의 문자열로 만들어 반환하는 메소드
	public String toString() {
		
		return "n = " + getN() + ", " + "m = " + this.m;
	}
}// --- class B


public class Ex3 {

	public static void main(String[] args) {
		
		B b = new B();
		
		b.setM(5);
		
		
	}

}


