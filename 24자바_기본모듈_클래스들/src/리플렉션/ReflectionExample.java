package 리플렉션;


//================================
// 리플렉션으로 분석할 대상 특정 클래스 만들기
//================================
class Car2 {
	
	// --------------- 변수(필드) ---------------
	private String model; // 자동차 모델명을 저장할 변수(필드)
	private String owner; // 자동차 소유자 명을 저장할 변수(필드)
	
	// ---------- 생성자(Constructor) ----------
	public Car2() {} // 기본 생성자
	public Car2(String model) { this.model = model; } // model 인스턴스 변수 초기화 할 생성자
	
	// ------------- 메소드(Method) -------------
	public String getModel() { return this.model; } // model 인스턴스 변수 값 외부 클래스로 반환 할 getter 메소드
	public void setModel(String model) { this.model = model; } // model 인스턴스 변수 값 변경할 setter 메소드
	public String getOwner() { return this.owner; } // owner 인스턴스 변수 값 외부 클래스로 반환 할 getter 메소드
	public void setOwner(String owner) { this.owner = owner; } // owner 인스턴스 변수 값 변경할 setter 메소드
}// --- Car2 클래스

//======================
// 리플렉션 기법을 실행할 클래스
//======================
public class ReflectionExample {

	private static void printParameters(Class[] parameters) {
		
		
	}// === printParameters 메소드
	
	public static void main(String[] args) {
		
		// 클래스 이름만 가지고 Class 객체를 얻는 방법
		//방법1.	Class claszz = 클래스 이름.class;
		// 설명: class Car2{...} 분석할 대상 클래스의 정보를 가진 new Class() 객체 얻기
		Class claszz = Car2.class;
		
		
		
		
		
	}// === main 메소드

}// --- ReflectionExample


