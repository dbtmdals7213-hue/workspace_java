
/*
	주제: 업 캐스팅 이해하기
	
	업 캐스팅이란? 부모 클래스 자료형의 참조변수 하나만 만들어
			   하나 이상의 자식 객체 메모리의 주소 번지를 대입하여 저장시키는 기능
*/

// 부모 클래스
class Parent {
	
	public void parentPrn() { System.out.println("부모 Parent 클래스의 parentPrn 메소드"); }
}

// 자식 클래스
class Child extends Parent {
	
	// Parent 부모 클래스로부터 상속 받은 메소드
	/* public void parentPrn() { System.out.println("부모 Parent 클래스의 parentPrn 메소드"); } */
	
	// Child 자식 클래스의 메소드
	public void childPrn() { System.out.println("자식 Child 클래스의 childPrn 메소드"); }
}

public class Ex2 {

	public static void main(String[] args) {
		
		// 주제1.	 일반 기본 자료형(int, double, float ...) 의 형 변환(강제 캐스팅)
		
		// 4바이트 크기의 변수 메모리에 정수 하나를 저장시키기 위해 a 변수를 선언하고 10을 저장
		int a = 10; // -> 작은 4byte 크기의 변수 메모리에 저장된 데이터 10
		
		// 8바이트 크기의 변수 메모리에 정수 하나를 저장시키기 위해 b 변수를 선언하고 20을 저장
		long b = 20; // -> 큰 8byte 크기의 변수 메모리에 저장된 데이터 20
		
		// 8바이트 크기의 b 변수 메모리에 4바이트 크기의 a 변수 메모리에 저장된 정수 10을 저장하려고 할 때
		// 개발자가 직접 형 변환(강제 캐스팅)해서 b = (long)a; 처럼 8바이트 크기에 저장할 10L 로 만들어 저장할 수 있지만
		// 자동 형 변환이 일어나 저장됩니다.
		b = a; // 10L;
		
		//--------------------------------------------------------------------------------------------------
		
		// 주제2.	 객체 메모리의 주소 번지를 대입하기 위한 참조변수를 만들 때
		//		 가장 앞에 작성하는 참조자료형(클래스 자료형, 인터페이스 자료형 ...) 사용!
		
		// 자식클래스자료형 참조변수 = new 자식클래스생성자();
		Child c = new Child();
		
	}

}


