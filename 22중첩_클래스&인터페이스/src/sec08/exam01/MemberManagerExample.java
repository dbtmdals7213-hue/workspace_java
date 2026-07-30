package sec08.exam01;

// 알림 발송기 부모 클래스
class Notifier {
	
	public void send(String message) {
		
		System.out.println("[알림] " + message);
	}
}// --- Notifier 클래스

class MemberManager {
	
	// 정적 멤버 중첩 클래스 - 회원 1명의 정보
	public static class Member {
		
		private int id;
		private String name;
		private int age;
		
		public Member(String name, int age) {
			
			this.name = name;
			this.age = age;
		}
		
		public void setId(int id) { this.id = id; }
		
		public int getId() { return this.id; }
		public String getName() { return this.name; }
		public int getAge() { return this.age; }
	}// --- Member 클래스
	
	// 정적 중첩 인터페이스 - 가입 검사 규칙 추상 메소드 제공
	public static interface Validator {
		
		boolean check(Member member);
	}
	
	// 정적 중첩 인터페이스 - 가입 완료 이벤트 규칙 추상 메소드 제공
	public static interface JoinListener {
		
		void onJoin(Member member);
	}
	
	// 회원 한 사람 정보는? new Member(); 객체에 저장됩니다.
	// 가입한 여러 회원의 정보는? 배열을 만들어 new Member(); 들을 각 칸에 저장합니다.
	// 결론: 가입한 여러 회원 정보가 저장된 배열 100칸 생성
	private Member[] members = new Member[100]; // 회원 저장 배열
	
	private int count; // 배열에 저장된 회원 수
	private int nextId = 1; // 다음에 부여할 회원 번호
	
	// 부모 인터페이스 자료형 인스턴스 변수들
	// -> 익명 구현 객체의 주소를 저장할 수 있다.
	private Validator validator;
	private JoinListener joinListener;
	
	// setter: 검사 규칙 등록(교체)
	public void setValidator(Validator validator) {
		
		this.validator = validator;
	}
	
	// setter: 가입 완료 이벤트 등록(교체)
	public void setJoinListener(JoinListener joinListener) {
		
		this.joinListener = joinListener;
	}
	
	//=================
	// 회원 가입 처리 메소드
	//=================
	public void join(Member member) {// <--- new MemberManager.Member("김철수", 20);
									 // <--- new MemberManager.Member("박영희", 35);
		
		// 1단계 검사
		// this.validator 에는 익명 구현 객체가 저장되어 있으므로
		// 메소드 오버라이딩 된 check() 가 실행된다.
		if(this.validator.check(member) == false) {
			
			System.out.println("가입 실패: 가입 조건(이름 입력, 14세 이상)을 만족하지 않습니다.");
			return; // 저장하지 않고 즉시 종료
		}
		// 2단계: 회원 번호 부여 후 배열에 저장
		member.setId(this.nextId);
		this.nextId++;
		
		this.members[this.count] = member;
		this.count++;
		
		// 3단계: 가입 완료 이벤트 실행
		// this.joinListner 에 저장된 익명 구현 객체의 오버라이딩 된 onJoin() 이 최종 실행된다.
		this.joinListener.onJoin(member);
	}// === join 메소드
	
	//================
	// 전체 회원 목록 출력
	//================
	public void printAll() {
		
		System.out.println("-------------------------------");
		System.out.println("[회원 목록] 총 " + this.count + "명");
		
		for(int i = 0; i < this.count; i++) {
			
			//members 배열에 저장된 등록된 Member 객체를 차례대로 얻어 정보 출력
			System.out.println(members[i].getId() + " | " + members[i].getName() + " | " + members[i].getAge() + "세");
		}
		
		
	}
	
	
}// --- MemberManager 클래스



public class MemberManagerExample {

	public static void main(String[] args) {
		
		
	}

}


