package ex2;

class Account {// 은행 계좌 클래스(설계도)
	
	private long balance; // 계좌 잔고
	
	public Account() {} // 기본 생성자
	
	public long getBalance() {// 계좌 잔고 반환
		
		return this.balance;
	}
	
	// 예금을 하여 계좌 잔고 금액을 변경하기 위한 메소드
	public void deposit(int money) {
		
		this.balance += money;
	}
	
	// 출금을 위한 메소드
	// throws 키워드를 이용해 사용자 정의(InsufficientException) 발생 예외가 메소드 내부에서 발생하면
	// withdraw 메소드를 호출한 코드 줄로 가서 예외 처리하라! 명령하는 구문 작성함.
	public void withdraw(int money) throws InsufficientException {
		
		if(this.balance < money) {
			
			// 개발자가 강제로 예외를 발생시키는 코드를 작성해 놓을 수 있습니다.
			// throw 예약어를 사용해야 합니다.
			// 강제로 예외 발생하는 코드 작성 방법
			// -> throw new 강제로발생시킬_사용자정의_예외클래스의_생성자("예외메세지");
			throw new InsufficientException("잔고 부족: " + (money - this.balance) + "부족함");
		}// if 조건문
		
		// 잔고에서 출금 금액을 차감
		this.balance -= money;
		
	}// === withdraw 메소드
	
}// --- Account 클래스

// 사용자 정의 예외 클래스 만들기
class InsufficientException extends Exception {
	
	public InsufficientException() {} // 기본 생성자
	
	// new InsufficientException("예외 발생 시 사용할 메세지"); 생성자로 객체 생성 시 호출되는 생성자
	// 예외 발생 시 메세지를 저장하는 역할을 합니다.
	public InsufficientException(String message) {
		
		super(message); // 부모 Exception 의 생성자를 호출해 매개변수 message 로 받은 예외 메세지 저장
	}
}// --- InsufficientException 클래스

public class AccountExample {

	public static void main(String[] args) {
		
		// Account(은행 계좌 클래스) 를 이용해 객체 생성
		Account account = new Account();
		
		account.deposit(10000); // 10000원 예금
		
		// 10000원 예금한 후 계좌 잔고 정보 출력
		System.out.println("예금액: " + account.getBalance());
		
		// 30000원 출금하기 - withdraw(출금액전달); 메소드 호출!
		// 참고.	예금한 금액은 10000원인데 30000원을 출금하려고 해서 개발자가 직접 만든 사용자 정의 예외 클래스(InsufficientException)의
		//		객체를 생성해 강제로 예외를 발생시켰었다!
		try {
			
			account.withdraw(30000); // 30000원 출금
		} catch (InsufficientException e) {
			
			e.printStackTrace();
		} 
		
		System.out.println("main 메소드 내부의 자바 프로그램 종료 코드 끝까지 실행되죠? 그래서 예외 처리라는 걸 합니다.");
	}// === main 메소드

}// --- AccountExample


