
// 주제: 정해진 자료형(데이터)만 처리하는 클래스

class TestClass1 {
	
	// 인스턴스 변수 만들기	   // 업 캐스팅으로 저장 가능한 Object 의 자식 객체들
	private Object member; // = new Integer(3);
						   // = new Double(3.4);
						   // = new String("이해할 수 있다?");
	
	// setter, getter 메소드 만들기
	// alt + shift + s r
	public Object getMember() {
		
		return member; // return new Integer(3);
					   // return new Double(3.4);
					   // return new String("이해할 수 있다?");
	}// === getMember 메소드

	public void setMember(Object member) {// 전달받는 자식 객체 -> new Integer(3);
										  // 전달받는 자식 객체 -> new Double(3.4);
										  // 전달받는 자식 객체 -> new String("이해할 수 있다?");
		
		this.member = member;
	}// === setMember 메소드
	
}// --- TestClass 클래스


public class GenericTest02 {

	public static void main(String[] args) {
		
		TestClass1 obj01 = new TestClass1();
		
		obj01.setMember(3); // -> 인스턴스 변수 private Object member = new Integer(3);
		
		System.out.println("인스턴스 변수 member 에 저장된 값을 얻어 출력: " + obj01.getMember()); // 3
		
		obj01.setMember(3.4); // -> 인스턴스 변수 private Object member = new Double(3.4);
		
		System.out.println("인스턴스 변수 member 에 저장된 값을 얻어 출력: " + obj01.getMember()); // 3.4
		
		obj01.setMember("이해할 수 있다?"); // -> 인스턴스 변수 private Object member = new String("이해할 수 있다?");
		
		System.out.println("인스턴스 변수 member 에 저장된 값을 얻어 출력: " + obj01.getMember()); // "이해할 수 있다?"
		
	}// === main 메소드

}// --- GenericTest01 클래스


