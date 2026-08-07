

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
		
		
		
		
		
		
	}// === main 메소드

}// --- GenericTest03 클래스
