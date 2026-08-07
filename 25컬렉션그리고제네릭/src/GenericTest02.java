
// 주제: 정해진 자료형(데이터)만 처리하는 클래스

class TestClass1 {
	
	// 인스턴스 변수 만들기
	private Object member; // = new Integer(3);

	// setter, getter 메소드 만들기
	// alt + shift + s r
	public Object getMember() {
		
		return member;
	}// === getMember 메소드

	public void setMember(Object member) {
		
		this.member = member;
	}// === setMember 메소드
	
}// --- TestClass 클래스


public class GenericTest02 {

	public static void main(String[] args) {
		
		TestClass1 obj01 = new TestClass1();
		
		obj01.setMember(3); // -> 인스턴스 변수 private Object member = new Integer(3);
		
		System.out.println("인스턴스 변수 member 에 저장된 값을 얻어 출력: " + obj01.getMember()); // 3
		
		obj01.setMember(3.4);
		
		obj01.setMember("이해할 수 있다?");
		
		System.out.println("인스턴스 변수 member 에 저장된 값을 얻어 출력: " + obj01.getMember()); // 이해할 수 있다?
		
	}// === main 메소드

}// --- GenericTest01 클래스


