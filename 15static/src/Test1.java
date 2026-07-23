
/*
	연습. 클래스 내부에 멤버변수(객체 변수, 클래스 변수) 만들기
	
	Student 클래스 만들기
	
		정수 하나를 저장할 객체 변수 num 만들기
		
		정수 하나를 저장할 클래스 변수 staticNum 만들기
		
		기본 생성자 만들기
			아무런 일도 하지 않도록 작성 X
		
		객체 메소드 만들기
			메소드명: add
			매개변수: 정수 하나를 전달받을 매개변수
			기능: 매개변수로 전달받은 정수 하나를 객체 변수 num 과 클래스 변수 staticNum 에 각각 누적
*/
class Student {
	
	int num; // 객체 변수
	static int staticNum; // 클래스 변수
	
	public Student() {} // 기본 생성자
	
	public void add(int value) {// 객체 메소드
		
		this.num += value; // 객체 변수 num 에 매개변수 value 의 값을 누적
		Student.staticNum += value; // 클래스 변수 staticNum 에 매개변수 value 의 값을 누적
	}
}


public class Test1 {

	public static void main(String[] args) {
		
		//1. class Student 를 이용해 객체를 셍성하는데 기본 생성자 호출해서 생성
		Student a = new Student();
		
		//2. a 객체 메모리에 포함된 add 메소드 호출할 때 매개변수 value 로 5를 전달해
		//	 객체 변수 num 과 클래스 변수 staticNum 에 각각 누적시키자.
		a.add(5);
		
		//3. a 객체 메모리에 포함된 int num 객체 변수 값 얻어 출력
		//	 JVM 메모리의 Method area 영역에 올라가 있는 static int staticNum 클래스 변수 값 얻어 출력
		System.out.println("---------- a 객체 ----------");
		System.out.println("객체 변수 num = " + a.num); // 참조변수명.객체변수명
		System.out.println("클래스 변수 staticNum = " + Student.staticNum);	 // 참조변수명.클래스변수명
																		 // or
																		 // 클래스명.클래스변수명
		/*
			---------- a 객체 ----------
			객체 변수 num = 5
			클래스 변수 staticNum = 5
		*/
		
		//1-1. class Student 를 이용해 객체를 생성하는데 기본 생성자 호출해서 생성
		Student b = new Student();
		
		//2-1. b 객체 메모리에 포함된 add 메소드 호출할 때 매개변수 value 로 5를 전달해
		//	   객체 변수 num 과 클래스 변수 staticNum 에 각각 누적시키자.
		b.add(5);
		
		//3-1. b 객체 메모리에 포함된 int num 객체 변수 값 얻어 출력
		//	   JVM 메모리의 Method area 영역에 올라가 있는 static int staticNum 클래스 변수 값 얻어 출력
		System.out.println("---------- b 객체 ----------");
		System.out.println("객체 변수 num = " + b.num); // 참조변수명.객체변수명
		System.out.println("클래스 변수 staticNum = " + Student.staticNum);	 // 참조변수명.클래스변수명
																		 // or
																		 // 클래스명.클래스변수명
		/*
			결론: 객체 변수와 클래스 변수 차이점 적어보기
				-> 객체 변수는 객체 메모리를 생성할 때 마다 객체 메모리 내부에 개별적으로 생성되는 메모리 공간
				-> 클래스 변수는 생성된 각 객체 메모리들이 공용으로 사용하는 공용 변수 메모리이기 때문에
				   자바 프로그램이 시작되면 가장 처음 class Student 가 JVM 의 Method area 영역에 올라갈 때
				   class Student 에 포함되어 같이 올라가는 변수 메모리 공간
		*/
	}

}


