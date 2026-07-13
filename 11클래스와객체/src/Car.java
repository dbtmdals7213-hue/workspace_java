
// 객체 지향 프로그래밍 3단계 기법

// 1단계: 현실의 소나타 객체를 모델링(데이터와 기능 추출하는 작업)
// - 데이터: 브랜드, 색상, 속도, 
// - 기능: 가속, 감속

// 2단계: 자바코드로 class 설계(멤버변수 + 메서드)
public class Car {
	
// 멤버변수 선언
	//1. 브랜드 명을 저장할 문자열 변수 선언
	String brand;
	//2. 자동차 색상을 저장할 문자열 변수 선언
	String color;
	//3. 자동차 현재 속도 저장할 정수 변수 선언
	int speed;
	
// 멤버 메서드 선언
	//1. 자동차 현재 속도를 10 증가시키는 기능의 accelerate 메소드 선언
	void accelerate() {
		speed += 10;
		System.out.println(brand + "가속! 현재속도: " + speed + "km/h");
	}
	
	//2. 자동차 현재 속도를 10 감소시키는 기능의 breaks 메소드 선언
	void breaks() {
		speed -= 10;
		System.out.println(brand + "감속! 현재속도: " + speed + "km/h");
	}
	
	public static void main(String[] args) {
		
		// 3단계: 2단계에서 만든 Car 클래스(설계도) 하나를 이용해 "Kia" 자동차 객체 생성 및 사용
		// 순서1. Car 클래스를 이용해 "Kia" 자동차 객체 메모리 하나 생성
		Car kia = new Car();
		
		// 순서2. "Kia" 자동차 객체에 브랜드명을 "Kia" 로 저장 
		//		 					 색상을 "Black" 로 저장
		//							 현재속도를 0으로 저장
		kia.brand = "Kia";
		kia.color = "Black";
		kia.speed = 0;
		
		// 순서3. 현재 속도 10 증가 
		kia.accelerate(); // Kia가속! 현재속도: 10km/h
		
		// 순서4. 현재 속도 10 감소
		kia.breaks(); // Kia감속! 현재속도: 0km/h
		
		//=============================================================================
		
		// 3단계: 2단계에서 만든 Car 클래스(설계도) 하나를 이용해 "Hyundai" 자동차 객체 생성 및 사용
		// 순서1. Car 클래스를 이용해 "Hyundai" 자동차 객체 메모리 하나 생성
		// 클래스자료형 참조변수명 = new 클래스명();
				Car hyundai = new Car();
		/*
					[     ] = ------------------------------------------
									String brand; 	[ null ]
									
									String color; 	[ null ]
									
									int speed;		[  0   ]
									
									void accelerate() { speed += 10 }
									void breaks() { speed -= 10 }
							  ------------------------------------------
		*/
		// 순서2. "Hyundai" 자동차 객체에 브랜드명을 "Hyundai" 로 저장
		//							 색상을 "Red" 로 저장
		//							 현재속도를 0으로 저장
		hyundai.brand = "Hyundai";
		hyundai.color = "Red";
		hyundai.speed = 0;
		
		// 순서3. 현재 속도 10 증가
		hyundai.accelerate(); // Hyundai가속! 현재속도: 10km/h
		
		// 순서4. 현재 속도 10 감소
		hyundai.breaks(); // Hyundai감속! 현재속도: 0km/h
		
	}

}
