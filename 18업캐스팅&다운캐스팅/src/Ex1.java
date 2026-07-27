
// 주제:	자바의 다형성 기능 중 업 캐스팅 이해하기

// 부모 클래스
class Tv {
	
	boolean power; // 전원 켜짐 true, 전원 꺼짐 false 저장
	int channel; // 현재 채널 번호 저장
	
	public void power() {// 전원을 켜거나 끄는 기능을 의미하는 메소드
		
		this.power = !power;
	}
	
	public void channelUp() {// 현재 채널 번호를 1증가시키는 기능의 메소드
		
		++channel; // 만약 channel 변수의 값이 10일 때 이 메소드를 호출하면 ++ 1증가되어 저장
	}
	
	
	public void channelDown() {// 현재 채널 번호를 1감소시키는 기능의 메소드
		
		--channel; // 만약 channel 변수의 값이 10일 때 이 메소드를 호출하면 -- 1감소되어 저장시킨다.
	}
}

// 자식 클래스(기본 Tv 기능 + 자막 내용 출력하는 기능)
// - Tv의 기본 기능이 있는 Tv 부모 클래스의 멤버들을 상속받아 Tv 화면에 자막내용을 추가로 보여주는 CaptionTv 자식 클래스 새롭게 만들자
class CaptionTv extends Tv {
	
	String text; // 자막 내용을 보여주기 위해 자막 내용을 문자열로 저장할 변수
	
	public void caption() {// 자막 내용을 화면에 출력하는 기능의 메소드
		
		System.out.println("자막 내용을 출력 기능이 추가된 CaptionTv 자식 클래스의 기능");
	}
}

public class Ex1 {

	public static void main(String[] args) {
		
		// 업 캐스팅? 부모 클래스의 참조변수 하나만 만들어 여러 자식 객체 메모리의 주소 번지 저장하는 기능
		
		// 업 캐스팅 작성 방법
		// 부모클래스자료형 참조변수명 = new 자식클래스의생성자();
		Tv t1 = new CaptionTv();
		
		t1.power = true; // false -> true
		t1.channel = 1; // 0 -> 1
		t1.power(); // true -> false
		t1.channelUp(); // channel = 1 -> 2
		t1.channelDown(); // channel = 2 -> 1
		
		// t1.text = "캡션TV2"; -> 부모 클래스 Tv 자료형의 t1 참조변수로 text 변수에 접근해서 저장할 수 없음.
		// t1.caption(); -> 부모 클래스 Tv 자로형의 t1 참조변수로 caption() 메소드에 접근해서 호출할 수 없음.
	}

}


