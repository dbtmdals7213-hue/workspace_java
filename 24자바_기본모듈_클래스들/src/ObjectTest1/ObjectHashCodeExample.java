package ObjectTest1;

class Student {
	
	// private: 클래스 밖에서 직접 접근할 수 없다. 접근하려면 아래 getter 메소드를 사용한다.
	private int no; // 학생 번호
	private String name; // 학생 이름
	
	// 생성자: 객체를 만들 때 학생 번호와 이름을 매개변수로 받아 각 인스턴스 변수에 저장한다.
	public Student(int no, String name) {
		
		super();
		this.no = no;
		this.name = name;
	}
	
	// getter 메소드: private 인 인스턴스 변수의 값을 외부에서 읽을 수 있게 해준다.
	public int getNo() {
		
		return this.no;
	}
	public String getName() {
		
		return this.name;
	}

	@Override
	public int hashCode() {
		
		// 예) no 가 1, name 이 "홍길동" 인 경우
		//	  "홍길동".hashCode() 의 값에 1을 더한 값이 반환된다.
		return this.no + this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Student target) {
			
			if(this.no == target.getNo() && this.name.equals(target.getName())) {
				
				return true; // 번호와 이름이 모두 같으므로 동긍 객체로 판단한다.
			}
		}
		
		return false;
	}// === equals 메소드
	
	
	
}// --- Student 클래스



public class ObjectHashCodeExample {

	public static void main(String[] args) {
		
		//==============================================
		//1. Object 의 객체를 생성해서 hashCode 메소드를 직접 호출
		//==============================================
		Object object1 = new Object();
		Object object2 = new Object();
		
		// 서로 다른 Object 객체이므로 서로 다른 정수 값이 출력된다.
		// 이 값은 프로그램을 실행할 때마다 달라진다. 고정된 값이 아니다.
		System.out.println("object1.hashCode() = " + object1.hashCode()); // object1.hashCode() = 1392838282
		System.out.println("object2.hashCode() = " + object2.hashCode()); // object2.hashCode() = 989110044
		
		// 한 번더 object1 참조변수가 사용하고 있는 new Object() 객체의 hashCode() 메소드를 호출
		System.out.println("object1.hashCode() 재호출 = " + object1.hashCode()); // object1.hashCode() 재호출 = 1392838282
	}

}


