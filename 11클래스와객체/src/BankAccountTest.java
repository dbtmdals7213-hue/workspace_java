
/*
	1단계: 현실의 부산은행 계좌, 국민은행 계좌 객체들을 모델링하여 데이터 + 기능 추출
	
		데이터 - 계좌번호(accountNumber), 예금주(owner), 잔액(balance)
		기능 - 돈을 입금(deposit), 출금(withdraw), 잔액 확인(checkBalance)
*/

//2단계: 계좌 설계도(클래스) 만들기
public class BankAccountTest {

	// 클래스 변수
	String accountNumber; //1. 계좌번호(예: "123-456-789") 저장할 클래스 변수
	String owner; //2. 예금주(예: "이영희") 저장할 클래스 변수
	double balance; //3. 잔액(예: 10000.0원) 저장할 클래스 변수
	
	//1. 클래스 메소드
	// 메소드명: deposit
	// 기능: 특정 금액(amount)을 입금하면, 잔액(balance)이 증가한다.
	void deposit(double amount) {
		
		balance += amount; // 현재 잔액(balance)에 amount(입금 금액) 을 더한다.
						   // 예: 기존 잔액이 100,000원이었고, 50,000원 입금하면? balance = 150,000원이됨
		
		System.out.println(owner + "님의 계좌에 " + amount + "원이 입금되었습니다.");
		System.out.println("현재 잔액: " + balance + "원");
	}
	
	// 메소드명: withdraw
	// 기능: 출금	- 특정 금액을 출금하면, 잔액(balance)을 감소한다.
	//			  단, 잔액이 부족하면 출금이 실패한다.
	void withdraw(double amount) {
		
		
		if(balance >= amount) {// 현재 잔액이 출금할 금액보다 많거나 같다면? 출금 가능
			
			balance -= amount; // 현재 잔액에서 출금 금액을 뺀다
			
			System.out.println(owner + "님의 계좌에서 " + amount + "원이 출금되었습니다.");
			System.out.println("현재 잔액: " + balance + "원");
		}else {// 현재 잔액이 출금할 금액보다 적다면? 출금 불가
			
			
		}
	}
	
	
	public static void main(String[] args) {
		

	}

}
