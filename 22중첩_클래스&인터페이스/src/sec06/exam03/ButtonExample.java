package sec06.exam03;

// 버튼 설계도(클래스) 만들기
class Button {// 외부 바깥 클래스 역할
	
	// 정적 중첩 인터페이스 만들기
	// 만드는 이유	- 외부 바깥 클래스에서 접근이 불가능 하도록 막고 public 이면서
	//			  Button 객체 생성 없이 사용할 수 있게 하기 위해 만든다.
	public static interface ClickListener {
		
		void onClick(); // 클릭하는 동작(이벤트)을 등록시키는 메소드
	}
	
	// 외부 바깥 Button 클래스의 인스턴스 변수 만들기
	// 참고. ClickListener 부모 인터페이스 내부에 만들어 놓은 규칙(추상 메소드명)을 따르는 자식 객체를 저장할 공간
	private ClickListener clickListener;
	//       인터페이스자료형      참조변수;
}


public class ButtonExample {

	public static void main(String[] args) {
		
		
	}

}
