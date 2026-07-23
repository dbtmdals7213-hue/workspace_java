
// 주제: 자바에서 클래스 안의 멤버 메소드 살펴보기

class AAA {
	
	//멤버변수 종류: 객체 변수, 클래스 변수
	int num; // 객체 변수: 객체를 생성할 때 마다 따로 존재하며, JVM 의 heap 영역에 올라갑니다.
	static int staticNum; // 클래스 변수: class AAA 가 JVM 의 Method area 영역에 올라갈 때 함께 생성되어 올라가는 변수
	
	//생성자 종류: 기본 생성자, 매개변수가 작성된 생성자
	public AAA() {} // 기본 생성자
	
	//멤버 메소드 종류: 객체 메소드, 클래스 메소드
	
	// 객체 메소드1
	// - 객체가 생성된 후에만 호출 가능한 메소드
	// - static 예약어가 작성되어 있지 않은 메소드
	// - 객체 메소드 내부에서 객체 변수와 클래스 변수 모두 접근(저장된 값 불러오거나 저장) 가능
	// - 객체 메소드 내부에서는 this 키워드를 통해 객체 메모리 자신의 객체 변수에 접근(저장된 값 불러오거나 저장) 가능
	public /* static */ void add(int value) {
		
		this.num += value; // <- 객체 변수 num 에 누적
		AAA.staticNum += value; // <- 클래스 변수 staticNum 에 누적
	}
	
	// 객체 메소드2
	//기능: 객체 변수 num 의 값을 외부로 반환
	public int getNum() {
		
		return this.num; // <- 객체 변수 num 의 값을 외부로 반환
	}
	
	// 객체 메소드3
	//기능: 객체 변수 num 의 값을 변경하고, 클래스 변수 staticNum 의 값을 변경
	public void setNum(int num) {
		
		this.num = num; // <- 객체 변수 num 의 값을 매개변수 num 의 값으로 변경
		AAA.staticNum = num; // <- 클래스 변수 staticNum 의 값을 매개변수 num 의 값으로 변경
	}
	
	// 클래스 메소드1
	// - 클래스명으로 호출 가능하고, 객체 메모리 생성 없이도 호출 가능한 메소드.
	// - static 작성해서 만든 메소드.
	// - 클래스 메소드 내부에서는 클래스 변수에만 접근 가능! 객체 변수는 접근 불가능!
	// - 클래스 메소드 내부에서는 this 예약어 작성 불가능!
	public static int getStaticNum() {
		
		return AAA.staticNum; // <- 클래스 변수 staticNum 의 값을 외부로 반환 가능
		// return this.num; <- 객체 변수 num 의 값을 외부로 반환 불가능
	}
	
	// 클래스 메소드2
	// 기능: 매개변수로 전달받은 값을 클래스 변수에 변경
	public static void setStaticNum(int staticNum) {
		
		AAA.staticNum = staticNum; // <- 클래스 변수 staticNum 의 값 변경 가능
		// this.num = staticNum; <- 객체 변수 num 의 값 변경 불가능
	}
	
}

public class Ex2 {

	public static void main(String[] args) {
		
		
	}

}


