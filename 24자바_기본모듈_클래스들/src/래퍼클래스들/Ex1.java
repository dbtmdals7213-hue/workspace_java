package 래퍼클래스들;

// 자바 문법에서 제공해주는 Integer 라는 이름의 래퍼 클래스를 직접 흉내내어 만들어보자.
class IntWrapper extends Object {
	
	private int num; // 기본 자료형의 정수 데이터를 저장시킬 변수
					 // 3 또는 7을 저장할 수 있음
	
	// 래퍼 Integer 클래스 역할을 하는 IntWrapper 클래스의 객체 생성 시 호출되는 생성자
	// 역할: 위 private int num; 인스턴스 변수 값 초기화
	public IntWrapper(int num) {
		
		this.num = num;
	}
	
	// Object 부모 클래스에 만들어져 있는 toString() 메소드 오버라이딩
	@Override
	public String toString() {
		
		// 기능 재구현: num 인스턴스 변수에 저장된 기본 자료형 값 3을 가져와 하나의 문자열로 만들어 반환
		return "" + this.num; // "3"
	}
	
}// --- IntWrapper 클래스

public class Ex1 {

	// 정수3 또는 7을 매개변수로 전달 받아 문자열 형태로 출력해주는 기능의 클래스 메소드 만들기
	public static void showData(Object obj) {// <--- new IntWrapper(3);
											 // <--- new IntWrapper(7);
		
		System.out.println(obj.toString());
	}
	
	public static void main(String[] args) {
		
		//1. 래퍼 Integer 클래스를 흉내내어 만든 IntWrapper 클래스의 객체 생성 시 생성자로 3을 전달해 저장시킨다.
		IntWrapper intWrapper = new IntWrapper(3);
		
		//2. showData 메소드 호출할 때 Object 부모의 자식 래퍼 객체인 new IntWrapper(3); 객체 주소를 매개변수로 전달
		Ex1.showData(intWrapper);
		
		//1-2. IntWrapper 클래스의 객체 생성 시 생성자로 7을 전달해 저장시킨 후 showData 메소드 호출 시 매개변수로 전달
		Ex1.showData(new IntWrapper(7));
		
	}// === main 메소드

}// --- Ex1 클래스
