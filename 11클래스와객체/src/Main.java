
/*
	스토리: 반려 동물은 배고픔 수치(0 ~ 100)를 가진다.
		  먹이를 주면 배고픔이 줄고, 놀아주면 배고픔이 늘어난다.
*/

//1단계: 현실의 반려 동물 객체 모델링
// - 데이터: 이름(name), 배고픔(hunger, 0 ~ 100)
// - 기능: 먹이주기(feed), 놀아주기(play), 상태 확인(checkStatus)

//2단계 class 설계 - 클래스명: PetTest
class PetTest {// 클래스 변수 선언
	String name; //1. 반려 동물 이름 저장할 변수 선언
	int hunger; //2. 배고픔 저장할 변수 선언
	
	// 클래스 메소드 선언
	/*
		메소드명: feed
		기능: hunger 를 amount 만큼 줄인다(0보다 작아지지 않게)
	*/
	void feed(int amount) {
		// 현재 배고픔에서 먹인 양 만큼 차감
		hunger -= amount;
		
		// 0보다 작아지면 0으로 고정(하한선 처리)
		if(hunger < 0) {
			
			hunger = 0;
		}
		
		// 이름과 변경된 배고픔 수치 출력
		System.out.println(name + " 밥 먹었다! 배고픔: " + hunger);
	}
	
	/*
		메소드명: play
		기능: 배고픔 증가
	*/
	void play(int amount) {
		// 현재 배고픔에 논 만큼 증가
		hunger += amount;
		
		// 100을 넘으면 100으로 고정(상한선 처리)
		if(hunger > 100) hunger = 100;
			
		// 이름과 변경된 배고픔 수치 출력
		System.out.println(name + " 신나게 놀았다! 배고픔: " + hunger);
	}
	
		/*
			메소드명: checkStatus
			기능: 배고픔 상태 출력
		 */
		void checkStatus() {
			
			System.out.println(name + "의 현재 배고픔: " + hunger);
		}
}

// Main 설계도(class) 역할: 자바 프로그램을 가동시키는 main 메소드를 포함하고 있는 설계도 일 뿐입니다.
public class Main {// -----> Main.java 컴파일 Main.class 실행 파일로 생성
	
	public static void main(String[] args) {
		//3단계: new 연산자로 객체 메모리 생성 후 사용
		
		//순서1+2. 참조 변수 선언 + 객체 메모리 생성 후 참조 변수에 주소 번지 저장
		PetTest pet = new PetTest();
		
		
		pet.name = "초코";
		pet.hunger = 60;
		
		pet.feed(10);
		pet.play(20);
		pet.checkStatus();

	}

}
