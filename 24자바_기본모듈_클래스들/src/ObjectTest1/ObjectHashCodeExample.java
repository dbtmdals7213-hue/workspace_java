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
		
		//=======================================================================
		//1. 메소드 오버라이딩 하지 않은 경우: Object 의 객체를 생성해서 hashCode 메소드를 직접 호출
		//=======================================================================
		Object object1 = new Object();
		Object object2 = new Object();
		
		// 서로 다른 Object 객체이므로 서로 다른 정수 값이 출력된다.
		// 이 값은 프로그램을 실행할 때마다 달라진다. 고정된 값이 아니다.
		System.out.println("object1.hashCode() = " + object1.hashCode()); // object1.hashCode() = 1392838282
		System.out.println("object2.hashCode() = " + object2.hashCode()); // object2.hashCode() = 989110044
		
		// 한 번더 object1 참조변수가 사용하고 있는 new Object() 객체의 hashCode() 메소드를 호출
		System.out.println("object1.hashCode() 재호출 = " + object1.hashCode()); // object1.hashCode() 재호출 = 1392838282
		
		System.out.println("-------------------------------------------");
		
		//===============================================================
		//2. 메소드 오버라이딩 한 경우: Student 자식 클래스의 hashCode 메소드가 동작한다.
		//===============================================================
		
		// 번호와 이름이 같은 두 개의 Student 객체를 만든다.
		// new 를 두 번 실행했으므로 메모리 상 객체는 두 개이고, 객체 주소값은 서로 다르다.
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");
		
		// 메소드 오버라이딩 한 hashCode 메소드는 번호와 이름으로 값을 계산하므로,
		// 두 객체 주소값이 달라도 두 결과는 항상 같은 정수가 됩니다.
		System.out.println("\"홍길동\".hashCode() = " + "홍길동".hashCode()); // 54150062
		
		System.out.println("s1.hashCode() = " + s1.hashCode()); // 54150063
		System.out.println("s2.hashCode() = " + s2.hashCode()); // 54150063
		
		// 주소값 자체는 다르다는 사실을 == 로 확인한다.
		System.out.println("s1 == s2(주소값 비교) = " + (s1 == s2)); // false
		
		System.out.println("-------------------------------------------");
		
		//=========================================================
		//3. hashCode 메소드와 equals 메소드를 함께 사용해 동등 객체인지 판단한다.
		//=========================================================
		if(s1.hashCode() == s2.hashCode()) {
			//54150063	 ==	  54150063
			
			// 해시코드가 같다는 것만으로는 값이 같다고 단정할 수 없다.
			// 서로 다른 값이 우연히 같은 정수를 만들어 내는 경우도 있기 떄문이다.
			// 그래서 equals 로 인스턴스 변수 값을 최종 확인한다.
			if(s1.equals(s2)) {
				
				System.out.println("해시코드가 같고 인스턴스 변수 값도 같으므로 동등 객체입니다.");
			}else {
			
				System.out.println("해시코드는 같지만 인스턴스 변수 값이 다르므로 동등 객체가 아닙니다.");
			}
		}else {
			
			System.out.println("해시코드가 다르므로 동등 객체가 아닙니다.");
		}
		
		System.out.println("-------------------------------------------");
		
		//====================================================================
		//4. 인스턴스 변수 값이 다른 경우의 Student 객체를 equals 메소드의 매개변수로 전달한 경우
		//====================================================================
		Student s3 = new Student(2, "김철수");
		
		System.out.println("s3.hashCode() = " + s3.hashCode()); // 44541882
		System.out.println("s1.equals(s3) = " + s1.equals(s3)); // 번호와 이름이 다르므로 false
		
		// Student 가 아닌 String 객체를 전달하면 instanceof 검사에서 false 가 되어
		// equals 는 false 를 반환한다. 오류가 발생하지는 않는다.
		System.out.println("s1.equals(\"홍길동\") = " + s1.equals("홍길동")); // false
		
		// 자기 자신 Student 객체끼리 비교하면 번호와 이름이 당연히 같으므로 true
		System.out.println("s1.equals(s1) = " + s1.equals(s1)); // true
	}// === main 메소드

}// --- ObjectHashCodeExample 클래스


