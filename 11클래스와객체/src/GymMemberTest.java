
/*
	스토리: 헬스장 회원은 남은 PT(개인 레슨) 횟수를 가진다.
		  PT를 사용할 때 마다 1회씩 차감되고, 0회면 사용할 수 없다.
*/

//1단계: 현실의 헬스장 회원 객체 모델링(데이터와 기능 추출)
// - 데이터: 이름(name), 회원권 종류(membership), 잔여 PT 횟수(ptCount)
// - 기능: PT 사용(usePT), PT 충전(chargePT), 상태 출력(printStatus)

//2단계: 헬스장 회원 설계도(class) 만들기 => 클래스 변수 + 클래스 메소드 로 구성
public class GymMemberTest {

	// 클래스 변수 선언
	String name; //1. 회원 이름을 저장할 변수 선언
	String membership; //2. 회원권 종류를 저장할 변수 선언
	int ptCount; //3. 잔여 PT 횟수 정보를 저장할 변수 선언
	
	// 클래스 메소드 선언
	/*
		메소드명: usePT
		기능:  PT 1회 사용 처리 	- ptCount 가 0보다 크면 1회 차감하고 진행 메세지 출력,
							  0이면 "PT 횟수가 없습니다. 추가 결제가 필요합니다." 출력
	*/
	void usePT() {
		
		if(ptCount > 0) {// 남은 PT 횟수가 1회 이상인지 검사
			
			ptCount--; // 1회 차감하고
			System.out.println(name + "님 PT 진행! 남은 횟수: " + ptCount + "회"); // 진행 메세지 출력
		}else {// 남은 PT 횟수가 0인 경우 검사
			
			System.out.println("PT 횟수가 없습니다. 추가 결제가 필요합니다.");
		}
		
	}
	
	/*
		메소드명: chargePT
		기능: PT 횟수 충전 - ptCount 에 매개변수 n 을 더하고 충전 완료 메세지 출력
	*/
	void chargePT(int n) {
		
		ptCount += n; // 기존 PT 횟수에 충전할 횟수 n 을 더함
		System.out.println(name + "님 PT " + n + "회 충전 완료. 총 잔여: " + ptCount + "회"); // 충전 횟수와 총 잔여 횟수 를 출력
	}
	
	/*
		메소드명: printStatus
		기능: 회원 상태 출력 - 이름, 회원권, 잔여 PT 횟수를 한 줄로 출력한다.
	*/
	void printStatus() {
		
		System.out.println("이름: " + name + " / 회원권: " + membership + " / 잔여 PT: " + ptCount + "회");
	}
	
	public static void main(String[] args) {
		//3단계: 객체 생성 후 데이터 저장 및 사용
		//순서1. 객체 생성, 참조 변수 m
		GymMemberTest m = new GymMemberTest();
		
		//순서2. 객체 데이터 설정
		//회원이름: "정우성" 저장
		//회원권: "3개월권" 저장
		//PT 횟수: 1 저장
		m.name = "정우성";
		m.membership = "3개월권";
		m.ptCount = 1;
		
		//순서3. 객체 메소드 호출해서 기능 사용
		//힌트! 메소드 4번 호출
		m.usePT(); // ptCount 변수 값이? 1 -> 0 로 변경됨
		m.usePT(); // ptCount 변수 값이 0 이기 때문에 사용 불가
		m.chargePT(5); // ptCount 변수 값이? 0 -> 5 로 변경됨
		m.printStatus();
		/*
			출력: 정우성님 PT 진행! 남은횟수: 0회
				 PT 횟수가 없습니다. 추가 결제가 필요합니다.
				 정우성님 PT 5회 충전 완료. 총 잔여: 5회
				 이름: 정우성 / 회원권: 3개월권 / 잔여 PT: 5회
		*/
	}

}
