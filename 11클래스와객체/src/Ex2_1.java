
//1단계. 보라색 원, 빨간색 원, 파란색 원 객체들을 모델링하여 데이터 + 기능 추출
//데이터: 색, 원의 반지름
//기능: 원의 면적을 구하는 기능

//2단계. 원 설계도(클래스) 만들기
class Circle {
	
	// 클래스 변수
	double radius; //1. 원의 반지름 저장할 변수
	
	// 클래스 메소드
	//1. 메소드명: setRadius
	//	 기능: 매개변수로 전달받은 반지름 값을 위 radius 변수에 저장하는 기능
	void setRadius(double newRadius){
		
		radius = newRadius;
	}
	
	//2. 메소드명: calculateArea
	//	 기능: 원의 면적을 구해서 반환하는 기능
	double calculateArea() {
		
		return radius * radius * 3.14; // 원 면적 = 반지름 X 반지름 X 3.14
	}
}

public class Ex2_1 {

	public static void main(String[] args) {
		
		//3단계. 2단계에서 만든 class Circle 설계도 하나를 이용해 객체 메모리 생성 후 사용
		
		//순서1. Circle 설계도(클래스)를 하나를 이용해 객체 메모리 생성 후 참조변수에 객체 메모리 주소번지 저장
		// 클래스자료형 참조변수명 = new 클래스자료형();
		Circle circle = new Circle();

		//순서2. 반지름 값 5를 double radius 객체 변수에 저장
		circle.setRadius(5);
		System.out.println(circle.radius); // 5.0
		
		//순서3. 원 면적을 구하기 위해 new Circle(); 객체 메모리 내부에 포함된 calculateArea() 메소드 호출하자
		System.out.println(circle.calculateArea()); // 78.5
		
		// -------------------------------------------------------------------------------------
		//3단계. 2단계에서 만든 class Circle 설계도(클래스) 하나를 이용해 객체 메모리 생성 후 사용
		//순서1. Circle 설계도(클래스)를 하나를 이용해 객체 메모리 생성 후 참조변수에 객체 메모리 주소번지 저장
		// 클래스자료형 참조변수명 = new 클래스자료형();
		Circle circle2 = new Circle();
		
		//순서2. 반지름 값 3을 double radius 객체 변수에 저장
		circle2.radius = 3;
		System.out.println(circle2.radius);
		
		//순서3. 원 면적을 구하기 위해 new Circle(); 객체 메모리 내부에 포함된 calculateArea() 메소드 호출하자
		double result = circle2.calculateArea();
		System.out.println(result);
	}

}
