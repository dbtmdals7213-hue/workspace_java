package 리플렉션;

// 메타 정보를 읽어볼 대상 클래스. 멤버가 하나도 없는 빈 클래스이다.
// (멤버가 없어도 "리플렉션.Car 라는 클래스가 존재한다" 는 메타 정보는 존재한다.)
class Car {
	
}

public class GetClassExample {

	public static void main(String[] args) throws Exception {
		
		//[1] 클래스 명을 가지고 Class 객체를 얻는 방법
		
		//방법1.	Class 참조변수 = 클래스명.class;
		// Class claszz = Car.class;
		// 만들어져 있는 class Car {} 의 메타 정보가 저장된 Class 객체 얻기
		
		//방법2.	Class 참조변수 = Class.forName("패키지.클래스명");
		// Class claszz = Class.forName("리플렉션.Car");
		// 만들어져 있는 class Car {} 의 메타 정보가 저장된 Class 객체 얻기

		
		//[2] 객체로부터 Class 객체를 얻는 방법
		
		//방법3.	Class 참조변수 = 생성된_객체_참조변수명.getClass();
		//순서1.	먼저 class Car 의 객체를 생성한다.
		Car car = new Car();
		
		//순서2.	getClass(): 이 객체를 만들 때 사용된 클래스의 메타 정보가 담긴
		//					Class 객체의 주소를 반환하는 메소드
		Class claszz = car.getClass();
		// 만들어져 있는 class Car {} 의 메타 정보가 저장된 Class 객체 얻기
		
		// class Class 에 만들어져 있는 getPackageName() 메소드
		// ---> class Car {} 의 메타 정보 중 "패키지 이름" 을 읽어 반환 해줍니다.
		System.out.println("Car 클래스가 만들어져 있는 패키지 경로(메타 정보): " + claszz.getPackageName());
		// "Car 클래스가 만들어져 있는 패키지 경로(메타 정보): 리플렉션"
		
		// class Class 에 만들어져 있는 getSimpleName() 메소드
		// ---> class Car {} 의 메타 정보 중 패키지 이름을 제외한 "클래스 명" 만 읽어 반환 해줍니다.
		System.out.println("new Car(); 객체를 만들 때 사용된 클래스 명(메타 정보): " + claszz.getSimpleName());
		// "new Car(); 객체를 만들 때 사용된 클래스 명(메타 정보): Car"
		
		// class Class 에 만들어져 있는 getName() 메소드
		// ---> class Car {} 의 메타 정보 중 "패키지명.클래스명" 을 읽어 반환 해줍니다.
		System.out.println("Car 클래스가 만들어져 있는 패키지 경로를 포함한 클래스 전체 경로(메타 정보): " + claszz.getName());
		// "Car 클래스가 만들어져 있는 패키지 경로를 포함한 클래스 전체 경로(메타 정보): 리플렉션.Car"
		// (getPackageName() + "." + "getSimpleName() 와 같은 결과)
		
	}// === main 메소드

}// --- GetClassExample 클래스


