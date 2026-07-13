
/*
	1. 객체(Object)
		-> 현실 세계의 속성(데이터) + 동작(행동, 기능)을 가진 모든 물건 또는 대상을 의미
	
	2. 객체(Object)의 구성
		-> 속성(데이터) + 동작(행동, 기능)
		
	3. 객체 지향 프로그래밍(Object Oriented Programming)
		-> 현실 세계에 존재하는 사물과 대상, 그리고 그에 따른 동작을 있는 그대로 실체화 시키는 형태의 프로그래밍
		
	객체 지향 프로그래밍 3단계 기법
	
		1단계. 현실에 존재하는 객체를 모델링(데이터와 동작을 추출하는 작업)
		
			LGTV 객체, 삼성TV 객체, 대우TV 객체
			
			LGTV 객체 모델링
				데이터: 크기, 높이, 채널 값, 색상, 전원 on/off 상태 값, ...
				기능: 채널 높이기, 채널 낮추기, 볼륨 높이기, 볼륨 낮추기, 전원 켜기, 전원 끄기, ...
				
		2단계. 각 TV 객체들의 공통점 TV 를 찾아서 자바코드로 설계도(class) 만들기
			class 구성요소 => 멤버변수 + 메서드
*/
class TV {// <--- TV 클래스(설계도)
	
	// 멤버변수(1단계에서 추출한 데이터 저장 용도)
	String color; // 색상
	boolean power; // 전원 상태 값 -> 전원 켜짐 = true, 전원 꺼짐 = false
	int channel; // 현재 채널 값
	
	// 메서드(1단계에서 추출한 기능 정의 용도)
	// 기능1. 전원을 켜거나 끄는 기능
	void power() {
		power = !power;
	}
	// 기능2. 채널 1높이기 기능
	void channelUp() {
		channel++;
	}
	// 기능3. 채널 1낮추기 기능
	void channelDown() {
		channel--;
	}
	
}
/*
	3단계. 위 2단계에서 만들어진 class(설계도) 하나를 이용해
		현실에 존재하는 객체들처럼 자바코드로 객체 메모리들을 만들어서 사용하는 단계.
*/

public class Ex2 {

	public static void main(String[] args) {
		
		// 2단계에서 만들어진 class(설계도) TV 하나를 이용해 lgTv 객체 메모리를 만든다.

		// 순서1. 생성한 lgTv 객체 메모리의 주소값을 저장할 참조변수 선언
		// 작성 문법
		//	클래스자료형 참조변수명;
			  TV	  lgTv;
					
		// 순서2. new 연산자를 이용해 TV 클래스 설계도로 lgTv 객체 메모리 하나 생성 후
		//		 생성된 lgTv 객체 메모리의 주소번지(16진수) 값을 lgTv 참조변수에 대입해서 저장
		// 작성문법
		//	참조변수명 = new 클래스명();
			 lgTv  =  new TV();
		
		// 순서3. 생성된 lgTv 메모리 내부에 포함된 객체 변수들의 값을 설정해서 저장
		// 작성문법
		//	참조변수명.객체변수명 = 저장할 값;
			lgTv.color = "빨간색";
			lgTv.channel = 7;
			lgTv.power = true;
		// 작성문법
		//	참조변수명.객체메소드명();
			lgTv.channelDown();
			
			System.out.println("현재 lgTv 객체의 채널 값은? " + lgTv.channel + "입니다."); // 6
	}

}
