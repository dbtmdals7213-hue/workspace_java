
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
					//	 "홍길동",	  20
		name = name_;
		//	  "홍길동"
		age = age_;
		//		20
	}

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
						//	 "김길동" ,	   50000
		owner = owner_;
		//	  = "김길동"
		balance = balance_;
		//		=  50000
	}
	
}


//연습3. 책(Book) 클래스 - 매개변수 3개 버전
//[문제]
// - 객체 변수:  title(제목, String), author(저자, String), price(가격, int)
// - 기본 생성자: title = "제목없음", author = "작자미상", price=0
// - 매개변수 생성자: 제목, 저자, 가격 3개를 모두 전달받아 초기화
class Book {
	
	String title;
	String author;
	int price;
	
	public Book() {
		
		this("제목없음", "작자미상", 0);
	}
	
	public Book(String title, String author, int price) {
		
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
}


//연습4. 핸드폰(Phone) 클래스 - 생성자 오버로딩 3개 버전
//[문제]
// - 객체 변수: model(모델명, String), storage(저장용량GB, int)
// - 생성자 3개를 만들어 본다.(★ 생성자 오버로딩 ★)
// - 기본 생성자: model = "미정", storage = 128
// - 모델명만 전달받는 생성자: storage 는 128로 고정
// - 모델명 + 용량을 모두 전달받는 생성자

// ※ 생성자 오버로딩?
// - 같은 이름의 생성자를 매개변수의 개수나 타입을 다르게 해서
//	 여러 개 만들어 놓는 문법
// - 객체를 만드는 방법(선택지)이 여러 개 생기는 효과!
class Phone {
	
	String model;
	int storage;
	
	public Phone() {
		
		this("미정", 128);
	}
	
	public Phone(String model) {
		
		this(model, 128);
	}
	
	public Phone(String model, int storage) {
		
		this.model = model;
		this.storage = storage;
	}
}





public class 생성자_연습문제_5개 {

	public static void main(String[] args) {
		
		//연습1 확인. 학생 객체 만들기
		System.out.println("===== 연습1. Student =====");
		
		// 기본 생성자로 Student 클래스로 객체 생성
		Student s1 = new Student();
		
		System.out.println(s1.name); // "무명"
		System.out.println(s1.age); // 0
		
		// 매개변수가 작성되어 있는 생성자로 객체 생성
		Student s2 = new Student("홍길동", 20);
		
		System.out.println(s2.name); // "홍길동"
		System.out.println(s2.age); // 20
		
		//연습2 확인. 은행 계좌 객체 만들기
		System.out.println("===== 연습2. BankAccount =====");
		
		// 기본 생성자로 BankAccount 클래스로 객체 생성
		BankAccount acc1 = new BankAccount();
		
		System.out.println(acc1.owner); // "미지정"
		System.out.println(acc1.balance); // 0
		
		// 매개변수가 작성되어 있는 생성자로 객체 생성
		BankAccount acc2 = new BankAccount("김길동", 50000);
		
		System.out.println(acc2.owner); // "김길동"
		System.out.println(acc2.balance); // 50000
		
	}

}



