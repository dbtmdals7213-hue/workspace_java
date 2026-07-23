//==========================================================================
// ★ 종합문제. 은행계좌(BankAccount) - 계좌번호 자동생성 + 은행 전체 자산 관리 ★
//--------------------------------------------------------------------------
// 지금까지 배운 내용을 모두 결합하는 문제입니다:
//   - 생성자 오버로딩 + this() 체이닝
//   - 인스턴스변수 vs 클래스변수(static)
//   - 인스턴스메소드 vs 클래스메소드(static)
//   - 배열 + 반복문
//   - boolean을 반환하는 메소드
//
// [설정] 계좌를 만들 때마다 계좌번호가 1001, 1002, 1003... 처럼 자동으로
//        하나씩 증가하며 부여되고, 은행 전체의 "총 계좌 수"와 "총자산"을
//        모든 계좌가 공유하는 클래스변수로 관리한다.
//==========================================================================
package EX;

class BankAccount {

	// [1] 객체 변수 선언 (계좌 하나마다 개별로 가지는 값)
	// int accountNumber - 이 계좌만의 고유 계좌번호
	// String owner - 예금주 이름
	// int balance - 현재 잔액

	// >>> 여기에 객체 변수 3개를 선언하세요.
	int accountNumber;
	String owner;
	int balance;

	// [2] 클래스 변수 선언 (모든 계좌가 공유하는 값)
	// static int accountCount = 0 - 지금까지 생성된 계좌 총 개수
	// static int totalAsset = 0 - 은행 전체 총자산 (모든 계좌 잔액의 합)

	// >>> 여기에 클래스 변수 2개를 선언하세요. (0으로 명시적 초기화)
	static int accountCount = 0;
	static int totalAsset = 0;

	// [3] 생성자 ① - 예금주 이름만 매개변수로 받는 생성자 (초기잔액 0)
	// ★ this() 생성자 호출구문으로 아래 생성자 ②에게 위임하세요.

	// >>> 여기에 생성자 ①을 작성하세요.
	public BankAccount(String owner) {

		this(owner, 0);
	}

	// [4] 생성자 ② - 예금주 이름 + 초기잔액을 매개변수로 받는 생성자
	// 기능 순서:
	// 1) accountCount를 1 증가시킨다 (accountCount += 1;)
	// 2) 이 계좌의 accountNumber를 "1000 + accountCount" 값으로 저장한다
	// (계좌가 하나씩 생길 때마다 1001, 1002, 1003...으로 자동 부여됨)
	// 3) owner, balance를 매개변수로 받은 값으로 저장한다
	// 4) totalAsset에 이번 계좌의 balance만큼 더한다 (은행 전체 총자산 갱신)

	// >>> 여기에 생성자 ②를 작성하세요.
	public BankAccount(String owner, int balance) {

		accountCount += 1;
		accountNumber = 1000 + accountCount;
		this.owner = owner;
		this.balance = balance;
		totalAsset += balance;
	}

	// [5] 인스턴스메소드 - deposit (입금)
	// 매개변수: int amount
	// 반환타입: void
	// 기능:
	// - this.balance 에 amount만큼 더하기
	// - totalAsset 에도 amount만큼 더하기 (은행 전체 총자산도 함께 갱신)
	// - 출력: "[계좌번호]에 amount원 입금 완료 (잔액: balance원)"
	// 예) [1002]에 20000원 입금 완료 (잔액: 70000원)

	// >>> 여기에 deposit 메소드를 작성하세요.
	public void deposit(int amount) {

		this.balance += amount;
		totalAsset += amount;
		System.out.println("[" + accountNumber + "]에 " + amount + "원 입금 완료 (잔액: " + this.balance + "원)");
	}

	// [6] 인스턴스메소드 - withdraw (출금) ★boolean을 반환하는 메소드★
	// 매개변수: int amount
	// 반환타입: boolean (출금 성공하면 true, 실패하면 false)
	// 기능 순서:
	// 조건문 : amount가 this.balance보다 크면 (잔액이 부족하면)
	// "[계좌번호] 잔액 부족으로 출금 실패" 출력 후 false 반환
	// 그 외 : this.balance 에서 amount만큼 빼고,
	// totalAsset 에서도 amount만큼 뺀 뒤
	// "[계좌번호]에서 amount원 출금 완료 (잔액: balance원)" 출력 후
	// true 반환

	// >>> 여기에 withdraw 메소드를 작성하세요.
	public boolean withdraw(int amount) {

		if (amount > this.balance) {

			System.out.println("[" + this.accountNumber + "] 잔액 부족으로 출금 실패");
			return false;
		} else {

			this.balance -= amount;
			totalAsset -= amount;

			System.out.println("[" + this.accountNumber + "]에서 " + amount + "원 출금 완료 (잔액: " + this.balance + "원)");
			return true;
		}
	}

	// [7] 인스턴스메소드 - showInfo (계좌 정보 출력)
	// 출력형식: "계좌번호: XXXX / 예금주: OOO / 잔액: XXXX원"

	// >>> 여기에 showInfo 메소드를 작성하세요.
	public void showInfo() {

		System.out.println("계좌번호: " + this.accountNumber + " / 예금주: " + this.owner + " / 잔액: " + this.balance + "원");
	}

	// [8] 클래스메소드(static) - showBankStatus (은행 전체 현황 출력)
	// ★static 메소드이므로 this 사용 불가 - accountCount/totalAsset만 접근 가능★
	// 출력형식(세 줄):
	// ===== 은행 전체 현황 =====
	// 총 계좌 수: X개
	// 총자산: XXXX원

	// >>> 여기에 showBankStatus 메소드를 작성하세요.
	public static void showBankStatus() {

		System.out.println("===== 은행 전체 현황 =====");
		System.out.println("총 계좌 수: " + accountCount + "개");
		System.out.println("총자산: " + totalAsset + "원");
	}

}

public class Test2 {
	public static void main(String[] args) {

		// [9] 계좌 3개를 배열에 담아 생성하기
		// ★배열 문법: BankAccount[] accounts = new BankAccount[3];
		// accounts[0] : 생성자① 사용 - 예금주 "김철수" (초기잔액 0, 계좌번호 자동 1001)
		// accounts[1] : 생성자② 사용 - 예금주 "이영희", 초기잔액 50000 (계좌번호 자동 1002)
		// accounts[2] : 생성자② 사용 - 예금주 "박민수", 초기잔액 30000 (계좌번호 자동 1003)

		// >>> 여기에 배열 생성 + 계좌 3개 담는 코드를 작성하세요.
		BankAccount[] accounts = new BankAccount[3];
		accounts[0] = new BankAccount("김철수", 0);
		accounts[1] = new BankAccount("이영희", 50000);
		accounts[2] = new BankAccount("박민수", 30000);

		// [10] for 반복문으로 배열을 처음부터 끝까지 돌며 각 계좌의 showInfo() 호출

		// >>> 여기에 for문을 작성하세요.
		for (int i = 0; i < accounts.length; i++) {

			accounts[i].showInfo();
		}

		System.out.println();

		// [11] accounts[1] (이영희) 계좌가 20000원 입금

		// >>> 여기에 deposit 호출 코드를 작성하세요.
		accounts[1].deposit(20000);

		// [12] accounts[2] (박민수) 계좌가 50000원 출금 시도
		// (박민수 잔액은 30000원뿐이라 50000원 출금은 실패해야 정상!)
		// ★withdraw의 반환값(boolean)을 변수에 저장한 뒤 if문으로 성공/실패를 나눠 출력★
		// 성공하면 "출금 처리 완료" 출력, 실패하면 "출금 처리 불가" 출력

		// >>> 여기에 withdraw 호출 + boolean 변수 저장 + if문을 작성하세요.
		boolean result = accounts[2].withdraw(50000);
		if (result) {// result 가 true 라면(즉, 출금이 성공했다면)

			System.out.println("출금 처리 완료");
		} else {// result 가 false 라면(즉, 출금에 실패했다면)

			System.out.println("출금 처리 불가");
		}

		System.out.println();

		// [13] 은행 전체 현황 출력
		// ★static 메소드이므로 객체가 아니라 "클래스명"으로 호출한다★

		// >>> 여기에 showBankStatus 호출 코드를 작성하세요.

		BankAccount.showBankStatus();
	}
}

/*
 * ===== 정답 코드 작성 시 예상 실행 결과 =====
 * 
 * 계좌번호: 1001 / 예금주: 김철수 / 잔액: 0원 계좌번호: 1002 / 예금주: 이영희 / 잔액: 50000원 계좌번호: 1003
 * / 예금주: 박민수 / 잔액: 30000원
 * 
 * [1002]에 20000원 입금 완료 (잔액: 70000원) [1003] 잔액 부족으로 출금 실패 출금 처리 불가
 * 
 * ===== 은행 전체 현황 ===== 총 계좌 수: 3개 총자산: 100000원
 * 
 * ★확인 포인트★ - 계좌번호가 1001, 1002, 1003으로 "자동으로" 하나씩 증가하는지 (accountCount라는 static
 * 변수 하나를 모든 계좌가 공유하기 때문에 가능함) - 박민수는 입금 없이 출금만 시도했으므로 잔액 30000원 그대로 실패해야 함 -
 * 총자산 100000원 = 0(김철수) + 70000(이영희, 입금후) + 30000(박민수, 출금실패로 그대로) - 총 계좌 수는
 * accounts 배열 길이(3)와 accountCount 값이 일치해야 함
 */
