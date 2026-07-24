
class AA /* extends Object */ {// 부모 클래스
	
	// 기본 생성자
	public AA() {
		
		// super(); <- 부모 Object 클래스의 기본 생성자 호출하는 구문 생략된 것임.
		System.out.println("AA 부모 클래스의 기본 생성자");
	}
	
	// 매개변수가 1개 작성된 생성자
	public AA(int x) {
		
		// super(); <- 부모 Object 클래스의 기본 생성자 호출하는 구문 생략된 것임.
		System.out.println("AA 부모 클래스의 매개변수가 1개 작성된 생성자");
	}
}

class BB extends AA {// 자식 클래스
	
	// 기본 생성자: 매개변수를 작성하지 않은 생성자
	public BB() {
		
		// super(); <- 부모 AA 클래스의 기본 생성자 AA() 를 호출하는 구문 생략되어 있음.
		System.out.println("BB 자식 클래스의 기본 생성자");
	}
	// 매개변수가 1개 작성된 생성자
	public BB(int x) {
		
		// super(); <- 부모 AA 클래스의 기본 생성자 AA() 를 호출하는 구문 생략되어 있음.
		System.out.println("BB 자식 클래스의 매개변수가 1개 작성된 생성자");
	}
	
}

public class Ex2 {

	public static void main(String[] args) {
		
		new BB();
	}

}
