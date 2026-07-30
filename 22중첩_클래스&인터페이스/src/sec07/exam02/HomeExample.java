package sec07.exam02;

//---------------------------
// 부모 인터페이스: RemoteControl
//---------------------------
interface RemoteControl {
	
	// 추상 메소드: 몸통 {} 구현부가 없이 세미콜론 ; 으로 끝나는 메소드
	
	void turnOn(); // 전월을 켠다
	
	void turnOff(); // 전원을 끈다
}

//------------------------------------------------------
// Home 클래스: 익명 구현 객체를 3가지 위치에서 사용해 보기 위해 만든다.
//------------------------------------------------------
class Home {
	
	//===========================================
	// 사용 위치1: 인스턴스 변수에 익명 구현 객체 생성해서 저장
	//===========================================
	// 해석1. new 부모인터페이스명() { 메소드 오버라이딩 };
	// -> 부모 인터페이스 내부에 만들어 놓은 모든 추상 메소드를 강제로 오버라이딩 시킨 익명 구현 클래스와 익명 구현 객체 생성
	// 해석2. private RemoteControl rc =
	// -> rc 참조 변수에 업 캐스팅해서 익명 구현 객체의 주소 저장
	private RemoteControl rc = new RemoteControl() {
		
		// 부모 RemoteControl 인터페이스 내부에 작성된 추상 메소드들 모두 강제 메소드 오버라이딩
		@Override
		public void turnOn() { System.out.println("TV의 전원을 켭니다."); }
		
		@Override
		public void turnOff() { System.out.println("TV의 전원을 끕니다."); }
	};
	
	
}




public class HomeExample {

	public static void main(String[] args) {
		
		
	}

}
