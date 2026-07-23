
/*
	주제: 변수의 초기화 시기와 실행 순서
	
		객체 변수 초기화 순서
			1. 객체 변수 자료형의 기본값으로 먼저 초기화
				int num; <- 0
				
			2. 명시적 초기화
				num = 10;
				
			3. 객체 초기화 블럭 {} 을 이용한 초기화
				{
					num = 100;
				}
				
			4. 생성자를 이용한 초기화
				public 생성자명() {
					
					this.객체변수명 = 1000;
				}
*/

public class Init {

	// 변수 초기화 방법1. 명시적 초기화 - 개발자가 직접 = 대입 연산자를 이용해 초기화
	static int cv = 1;
	int iv = 1;
	
	// 변수 초기화 방법2. 초기화 블럭 사용
	//1. 클래스 초기화 블럭 이용 static {}
	static { Init.cv = 2; }
	
	//2. 객체 초기화 블럭 이용 {}
	{ this.iv = 2; }
	
	// 변수 초기화 방법3. 생성자 사용
	public Init() { this.iv = 3; }
	
	
	public static void main(String[] args) {
		
		Init i = new Init();
		
		System.out.println(Init.cv); // 클래스 변수 cv 값 2 얻어 출력
		
		System.out.println(i.iv); // 객체 변수 iv 값 3 얻어 출력
	}

}
