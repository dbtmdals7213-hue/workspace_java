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
	private ClickListener clickListener; // <--- new OkListener(); 자식 객체 저장
										 // <--- new CancelLitener(); 자식 객체 저장
	
	// 외부 바깥 Button 클래스의 인스턴스 메소드를 setter 로 만들기
	public void setClickListener(ClickListener clickListener) {
		
		this.clickListener = clickListener;
	}
	
	// 외부 바깥 Button 클래스의 인스턴스 메소드 click 만들기
	// 기능:	Button 객체가 click 이벤트가 발생했을 때 click 이벤트를 처리할 기능
	public void click() {
		
		this.clickListener.onClick();
	}
	
}// --- class Button 외부 바깥 클래스 끝

public class ButtonExample {// <--- 외부 바깥 클래스 역할

	public static void main(String[] args) {// <--- 외부 바깥 클래스 내부의 정적 메소드
		
		// Button 클래스의 객체 생성
		Button btnOk = new Button(); // <button>OK</button> 버튼 역할
		
		/*
			위 Button 객체에 click 이벤트가 발생했을 때 click 이벤트를 처리할 코드가 작성되는
			OkListener 자식 클래스를 로컬 중첩 클래스로 만들기
			
			만드는 방법 ->
				Button 클래스 내부에 만들어 놓은 중첩 인터페이스 ClickListener 내부의 추상 메소드 강제로 오버라이딩해서 만든다.
		*/
		class OkListener implements Button.ClickListener {
			
			@Override
			public void onClick() {
				
				// click 이벤트 처리할 코드 작성
				System.out.println("Button btnOK = new Button() 버튼을 클릭했으니 선물을 줄게요!");
			}
		}// --- class OkListener 로컬 중첩 클래스 끝
		
		// 위 Button btnOk = new Button(); 객체에 click 이벤트 처리할 OkListener 로컬 중첩 클래스의 객체 등록
		btnOk.setClickListener(new OkListener());
		
		// 위 Button btnOk = new Button(); 객체를 click 하는 동작 강제로 하기
		btnOk.click();
		
		//-----------------------------------------------------------------------------------------------
		
		// Cancel 역할을 하는 Button 클래스의 객체 생성
		Button btnCancel = new Button(); // <button>Cancel</button> 버튼 역할
		
		// Button btnCancel = new Button() 버튼 객체에 click 이벤트를 처리할 클래스를 로컬 중첩 클래스로 만든다.
		class CancelListener implements Button.ClickListener {

			@Override
			public void onClick() {
				
				// click 이벤트 처리할 코드 작성
				System.out.println("Button btnCancel = new Button() 취소 버튼을 클릭했으니 집으로 가겠다.");
			}
		}// --- class CancelListener 로컬 중첩 클래스 끝
		
		btnCancel.setClickListener(new CancelListener());
		
		// Button btnCancel = new Button(); 객체의 click 메소드 호출해서 강제로 click 이벤트 동작 발생하게 하기
		btnCancel.click();
		
	}// -- main 메소드 끝

}// --- ButtonExample 외부 바깥 클래스 끝


