
/*
	스토리: 주차장 관리
		
		  주차장은 총 자리 수와 주차된 차량 수를 가진다.
		  
		  자리가 다 차면 입차할 수 없고, 차가 없으면 주차할 수 없다.
		  
	객체 지향 프로그래밍 기법 3단계 중에서
	
		1단계: 현실의 주차장 객체 모델링
		데이터 - 총 자리 수(totalSpots), 현재 주차된 차량 수(currentCars)
		기능 - 입차(enter), 출차(exit), 남은 자리 확인(checkAvailable)
*/

//2단계: 주차장 설계도(class) 만들기
public class ParkingLotTest {

	// 클래스 변수 선언
	int totalSpots; //1. 총 주차 가능 자리 수 저장할 변수
	int currentCars; //2. 현재 주차된 차량 수 저장할 변수
	
	// 클래스 메소드 선언
	/*
		메소드명: enter
		기능: 입차 처리 - 자리가 남아 있으면 입차 처리, 자리가 없으면 "만차입니다. 입차 불가"
	*/
	void enter () {
		// 현재 차량 수가 총 자리 수 보다 적은지(빈자리 있는지) 검사
		if(currentCars < totalSpots) {
			
			currentCars++; // 빈자리가 있으면 차량 수 1증가
			System.out.println("입차 완료! 남은 자리: " + (totalSpots - currentCars) + "자리"); // 총 자리 수 - 현재 차량 수 = 남은 자리 계산해 출력
		}else {
			
			System.out.println("입차 만차입니다. 입차 불가.");
		}
	}
	
	/*
		메소드명: exit
		기능: 출차 처리 - 주차된 차량이 있으면 출차 처리, 없으면? "주차된 차량이 없습니다." 출력
	*/
	void exit() {
		
		if(currentCars > 0) {// 주차된 차량이 1대 이상인지 검사
			
			currentCars--; // 주차된 차량이 있으면? 차량 수 1감소
			System.out.println("출차 완료! 남은 자리: " + (totalSpots - currentCars) + "자리");
		}else {// 주차된 차량이 없는지 검사
			
			System.out.println("주차된 차량이 없습니다.");
		}
	}
	
	/*
		메소드명: checkAvailable
		기능: 남은 자리 수 출력 - 현재 차량 수를 계산해서 출력
	*/
	void checkAvailable() {
		
		//  총 자리 수 - 현재 차량 수 = 남은 자리 구해 지역 변수에 저장
		int available = totalSpots - currentCars;
		
		System.out.println("현재 남은 자리: " + available + " / 총 " + totalSpots + "자리");
	}
	
	public static void main(String[] args) {
		//3단계: new 연산자로 객체 메모리 생성 후 사용
		
		//순서1+2. 참조 변수 선언 + 객체 메모리 생성 후 주소 번지 저장
		ParkingLotTest lot = new ParkingLotTest();

		//순서3. 객체 변수 값 설정
		lot.totalSpots = 2;
		lot.currentCars = 0;
		
		//순서4. 객체 메소드 호출해서 기능들 사용
		lot.enter(); // 입차 기능 사용 currentCars 변수 값이 0 -> 1
					 // 입차 완료! 남은 자리: 1자리 <--- 출력
		
		lot.enter(); // 입차 기능 사용 currentCars 변수 값이 1 -> 2
					 // 입차 완료! 남은 자리: 0자리 <--- 출력
		
		lot.enter(); // 입차 기능 사용
					 // 만차입니다. 입차 불가. <--- 출력
		
		lot.checkAvailable(); // 현재 주차장 정보 출력 기능 사용
							  // 현재 남은 자리: 0 / 총 2자리 <=== 출력
		
		lot.exit(); // 출차 기능 사용 currentCars 변수 값이 2 -> 1
					// 출차 완료! 남은 자리: 1자리 <--- 출력
		
		lot.checkAvailable(); // 현재 주차장 정보 출력 기능 사용
							  // 현재 남은 자리: 1 / 총 2자리 <--- 출력
		
		/*
			출력:	 입차 완료! 남은 자리: 1자리
				 입차 완료! 남은 자리: 0자리
				 만차입니다. 입차 불가.
				 현재 남은 자리: 0 / 총 2자리
				 출차 완료! 남은 자리: 1자리
				 현재 남은 자리: 1 / 총 2자리
		*/
	}

}
