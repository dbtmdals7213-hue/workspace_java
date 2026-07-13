
// 객체 지향 프로그래밍 3단계 기법
// 1단계: 현실의 객체를 모델링
// 2단계: 현실의 객체의 클래스 설계도 만들기
// 3단계: 클래스 설계도를 이용해 객체 메모리 만든 후 사용

// 1단계: 현실의 영의 학생 객체 모델링
// 데이터 - 이름, 나이, 학번
// 동작 - 공부하기, 영희 정보 출력

// 2단계: 현실의 영희 객체의 클래스 설계도 만들기
/*
	클래스명: Student
	
		멤버변수 선언
			1. 학생 이름(문자열) 저장할 name 변수 선언
			
			2. 학생 나이(정수) 저장할 age 변수 선언
			
			3. 학생 학번(문자열) 저장할 studentId 변수 선언
			
		메소드 선언
			1. 학생이 공부하는 동작 출력 기능의 study 메소드 선언
				예) "영희 학생이 공부하고 있습니다."
				
			2. 학생 정보를 출력하는 기능의 printInfo 메소드 선언
				예) "이름: 영희, 나이: 20, 학번: 2025001"
*/
public class Student {
	
	String name;
	int age;
	String studentId;
	
	void study() {
		System.out.println(name + " 학생이 공부하고 있습니다.");
	}
	
	void printInfo() {
		System.out.println("이름: " + name + ", 나이: " + age + ", 학번: " + studentId);
	}

	public static void main(String[] args) {
		/*
			3단계: Student 클래스를 이용해 영희 객체 생성 후 데이터 저장하고 사용
			
				순서1. Student 클래스 이용해 영희 객체 생성! 단! 참조변수명은 student1 로 작성
				
				순서2. 순서1. 에서 생성한 영희 객체에 이름 "영희" 로 저장, 나이 20으로 저장, 학번 "2025001" 로 저장
				
				순서3. 영희 학생 객체 정보 출력하기 위해 printInfo 메소드 호출!
				
				순서4. 영희 학생 객체가 공부하는 동작 출력하기 위해 study 메소드 호출!
		*/
		Student student1 = new Student();
		
		student1.name = "영희";
		student1.age = 20;
		student1.studentId = "2025001";
		
		student1.printInfo(); // 출력 → 이름: 영희, 나이: 20, 학번: 2025001
		
		student1.study(); // 출력 → 영희 학생이 공부하고 있습니다.
	}

}
