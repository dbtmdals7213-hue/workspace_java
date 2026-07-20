
/*
	★ 생성자(Constructor) 만들기 연습 5개 ★
	
	[ 공통 규칙 ]
	1. 생성자 이름은 반드시 클래스 이름과 동일하게 작성한다.
	2.
	3.
	4. new 생성자() 호출 시 자동으로 단 한 번만 실행된다.
	
	[ 연습 목차 ]
	연습1. 학생(Student) 클래스 - 기본
	연습2. 은행 계좌(BankAccount) - 기본
	연습3. 책(Book) 클래스 - 매개변수 3개
	연습4. 핸드폰(Phone) 클래스 - 생성자 3개 오버로딩
	연습5. 피자(Pizza) 클래스 - 생성자 안에서 계산까지
*/
// 연습1. 학생(Student) 클래스

// [문제]
// - 객체 변수: name(이름, String), age(나이, int)
// - 기본 생성자: name = "무명", age = 0 으로 초기화
// - 매개변수 생성자: 이름과 나이를 전달받아 초기화
class Student {
	
	//[1] 객체 변수 정의
	String name;
	int age;
	
	//[2] 기본 생성자 정의
	public Student() {
		
		name = "무명";
		age = 0;
	}
	//[3] 매개변수가 있는 생성자 정의
	public Student(String name_, int age_) {
		
		name = name_;
		age = age_;
	}
	
//연습2. 은행 계좌(BankAccount) 클래스
	
//[문제]
// - 객체 변수: owner(예금주, String), balance(잔액, int)
// - 기본 생성자: owner = "미지정", balance = 0
// - 매개변수 생성자: 예금주와 첫 입금액을 전달받아 초기화
class BankAccount {
	
	//[1] 객체 변수 정의
	String owner;
	int balance;
	
	//[2] 기본 생성자 정의
	public BankAccount() {
		
		owner = "미지정";
		balance = 0;
	}
	
	//[3] 매개변수가 있는 생성자 정의
	public BankAccount(String owner_, int balance_) {
		
		owner = owner_;
		balance = balance_;
	}
	
}
	
	
	
	
}

public class 생성자_연습문제_5개 {

	public static void main(String[] args) {
		
		
		
		
		
		
	}

}
