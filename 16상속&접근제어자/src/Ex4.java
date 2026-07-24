
// 주제: 부모 클래스와 자식 클래스가 같은 패키지에 있는 경우 다양한 접근 제어자를 지정한 멤버(변수 또는 메소드) 접근 범위 알아보기

class AA {// 기존에 만들어져 있는 부모 역할의 클래스
	
	int i; // 자료형 int 앞에 아무것도 작성하지 않으면? default 접근 제어자를 작성한 것입니다.
	
	protected int pro;
	
	public int pub;
	
	private int pri;
	
	public int getPri() {
		
		return this.pri; // return this.pri : "이 객체가 소유한" pri 객체 변수의 현재 값을 돌려준다.
	}

	// setter 메소드 만들기 단축 키 -> alt + shift + s r
	public void setPri(int pri) {
		
		this.pri = pri;
	}
	
}// --- class AA {}

class BB extends AA {// 부모 AA 클래스를 상속받아 새롭게 설계하는 자식 역할의 BB 클래스
	
	// BB 자식 클래스에 새롭개 추가되는 기능(메소드들)
	
	void set() {
		
		super.i = 1; // [성공] i 변수는 default 접근 제어자로 만든 변수
					 // BB 는 AA 와 "같은 패키지" 에 있으므로 접근 가능!
		
		super.pro = 2; // [성공] pro 변수는 protected 접근 제어자로 만든 변수.
					   // protected 는 같은 패키지면 무조건 허용이므로 접근 가능!
					   // 게다가 BB 는 자식이기까지 하니 두 가지 자격으로 모두 통과
		
		// super.pri = 3; -> [실패] pri 변수는 private 접근 제어자로 만든 변수.
						  // 같은 패키지여도, 자식 클래스여도 접근 불가능!
						  // private 는 "AA 클래스의 {} 안" 에서만 접근 가능하기 때문.
		
		super.setPri(3); // [성공]
		
		super.pub = 4; // [성공] pub 변수는 public 접근 제어자로 만든 변수.
					   // 어디서든지 접근 가능하므로 당연히 성공.
	}// set() <- class BB 자식 클래스의 메소드
	
	public String get() {// public 접근 제어자를 아용한 get 객체 메소드
		
		return super.i + ", " + super.pro + ", " + super.pub + ", " + super.getPri();
	}
	
}// --- class BB {}

public class Ex4 {

	public static void main(String[] args) {
		
		// BB 자식 클래스의 객체 메모리 생성
		// -> 이 BB 자식 객체 메모리 "한 개" 안에 AA 부모 객체 메모리 영역 + BB 자식 객체 메모리 영역이 함께 만들어진다.
		BB bb = new BB();
		
		// set() 호출 -> 위에서 본 것처럼 부모 메모리 영역의 변수들에 값이 저장됨.
		bb.set();
		
		// get() 호출 -> 저장된 값들을 문자열로 받아 출력
		System.out.println(bb.get()); // 1, 2, 4, 3
	}

}// --- class Ex4 {}


