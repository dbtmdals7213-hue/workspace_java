
class TestClass2 {
	
	private Object member; // "apple" 자식 문자열 객체를 업 캐스팅으로 인해 member 변수에 저장 가능!
	
	public void setMember(Object member) {// "apple" 자식 문자열 객체를 업 캐스팅으로 인해 member 매개변수로 전달 받아 사용 가능!
		
		this.member = member;
	}// === setMember 메소드
	
	// public Object <- 부모 Object obj 참조변수에 저장될 자식 "apple" 문자열 객체 주소 반환 가능!
	public Object getMember() {
		
		return this.member;
		// return "apple";
	}// === getMember 메소드
	
}// --- TestClass2 클래스


public class GenericTest03 {

	public static void main(String[] args) {
		
		TestClass2 obj01 = new TestClass2();
		
		obj01.setMember("apple");
		
		// getMember() 인스턴스 메소드 호출하면
		// 부모 Object 클래스 자료형의 참조변수에 저장할 자식 String 클래스의 "apple" 문자열 객체 메모리 주소 반환
		Object obj = obj01.getMember();
		
		String temp = (String)obj;
		
		// 다운 캐스팅 후 temp 참조변수로 toUpperCase 메소드 호출 가능 -> "APPLE" 출력
		System.out.println(temp.toUpperCase());
		
	}// === main 메소드

}// --- GenericTest03 클래스
