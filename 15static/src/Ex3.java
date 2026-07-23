
/*
	주제: 멤버변수 초기화 방법
	
		멤버변수 초기화?
		- 처음 선언한 변수에 값 저장하는 것.
	
		멤버변수 초기화 방법
			방법1. 명시적 초기화
			방법2. 생성자 이용한 초기화
			방법3. 초기화 블럭을 이용한 초기화
				1. 클래스 초기화 블럭 static{} 이용: 클래스 변수를 초기화 하는데 사용
				2. 객체 초기화 블럭 {} 이용: 객체 변수를 초기화 하는데 사용
*/

public class Ex3 {
	
	//방법1. 명시적 초기화: 개발자가 직접 코드를 작성해서 변수 값 초기화
	int door = 4;
	
	//방법2. 생성자 이용한 초기화
	public Ex3() {
		
		System.out.println("생성자를 이용하여 변수 초기화");
	}
	
	//방법3. 초기화 블럭을 이용한 초기화
	//1. 클래스 초기화 블럭
	static {
		
		System.out.println("호출 순서 알아보기");
		System.out.println("static{ 클래스 초기화 블럭 사용 }");
	}
	
	//2. 객체 초기화 블럭
	{
		
		System.out.println("{ 객체 초기화 블럭 사용 }");
	}

	public static void main(String[] args) {
		
		System.out.println("main 메소드로 진입하여 Ex3 ex3 = new Ex3(); 객체 메모리 생성합니다.");
		Ex3 ex3 = new Ex3();
		
		System.out.println("main 메소드로 진입하여 Ex3 ex4 = new Ex3(); 객체 메모리 생성합니다.");
		Ex3 ex4 = new Ex3();
	}

}


