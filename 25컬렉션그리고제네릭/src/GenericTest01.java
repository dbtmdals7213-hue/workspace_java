
// 주제: 정해진 자료형(데이터)만 처리하는 클래스

class TestClass {
	
	// 인스턴스 변수 만들기
	private int member;

	// setter, getter 메소드 만들기
	// alt + shift + s r
	public int getMember() {
		
		return member;
	}// === getMember 메소드

	public void setMember(int member) {
		
		this.member = member;
	}// === setMember 메소드
	
}// --- TestClass 클래스


public class GenericTest01 {

	public static void main(String[] args) {
		
		TestClass obj01 = new TestClass();
		
		obj01.setMember(3); // -> 인스턴스 변수 private int member = 3; 저장됨
		
		System.out.println("인스턴스 변수 member 에 저장된 값을 얻어 출력: " + obj01.getMember()); // 3
		
		// obj01.setMember(3.4); -> 실제 메소드 호출 시 전달되는 값 자체가 3.4 실수 자료형이면 에러 발생
		
		// obj01.setMember("이해할 수 있다?");
		
		System.out.println("인스턴스 변수 member 에 저장된 값을 얻어 출력: " + obj01.getMember()); // 3
		
	}// === main 메소드

}// --- GenericTest01 클래스


