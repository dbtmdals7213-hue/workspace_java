
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

//=============================================================================================
// 연습1. 학생(Student) 클래스
//---------------------------------------------------------------------------------------------
// [문제]
// - 객체 변수: name(이름, String), age(나이, int)
// - 기본 생성자: name = "무명", age = 0 으로 초기화
// - 매개변수 생성자: 이름과 나이를 전달받아 초기화
//=============================================================================================
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
}// --- Student 클래스

//=============================================================================================
//연습2. 은행 계좌(BankAccount) 클래스
//---------------------------------------------------------------------------------------------
//[문제]
// - 객체 변수: owner(예금주, String), balance(잔액, int)
// - 기본 생성자: owner = "미지정", balance = 0
// - 매개변수 생성자: 예금주와 첫 입금액을 전달받아 초기화
//=============================================================================================
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
}// --- BankAccount 클래스

//=============================================================================================
//연습3. 책(Book) 클래스 - 매개변수 3개 버전
//---------------------------------------------------------------------------------------------
//[문제]
// - 객체 변수:  title(제목, String), author(저자, String), price(가격, int)
// - 기본 생성자: title = "제목없음", author = "작자미상", price=0
// - 매개변수 생성자: 제목, 저자, 가격 3개를 모두 전달받아 초기화
//=============================================================================================
class Book {
	
	//[1] 객체 변수 정의
	String title;
	String author;
	int price;
	
	//[2] 기본 생성자: title = "제목없음", author = "작자미상", price=0
	public Book() {
		
		this.title = "제목없음";
		this.author = "작자미상";
		this.price = 0;
	}
	
	//[3] 매개변수 생성자: 제목, 저자, 가격 3개를 모두 전달받아 초기화
	public Book(String title, String author, int price) {
					// "자바의정석",	"남궁성" ,	"30000"
		this.title = title;
		this.author = author;
		this.price = price;
	}
}// --- Book 클래스

//=============================================================================================
//연습4. 핸드폰(Phone) 클래스 - 생성자 오버로딩 3개 버전
//---------------------------------------------------------------------------------------------
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
//=============================================================================================
class Phone {
	
	//[1] 객체 변수 정의
	String model;
	int storage;
	
	//[2] 기본 생성자: model = "미정", storage = 128
	public Phone() {
		
		this("미정", 128);
	}
	
	//[3] 모델명만 전달받는 생성자: storage 는 128로 고정
	public Phone(String model) {
				//	 "갤럭시 S26"
		this(model, 128);
	}
	
	public Phone(String model, int storage) {
				//	  "아이폰 17",	 512
		this.model = model;
		this.storage = storage;
	}
}// --- Phone 클래스

//=============================================================================================
//연습5. 피자(Pizza) 클래스 - 생성자 안에서 계산까지
//---------------------------------------------------------------------------------------------
//[문제]
// - 객체 변수: name(피자이름, String), size(크기, String), price(가격, int)
// - 기본 생성자: name = "치즈피자", size = "M", price = 15000
// - 매개변수 생성자: 이름과 크기를 전달받고,
//	 ★ 가격은 생성자 안에서 크기에 따라 자동 계산 ★
//	 M -> 15000원 / L -> 20000원

// ※ 포인트:	생성자 안에는 단순 저장 코드뿐 아니라
//			if 문 같은 로직도 작성할 수 있다.
//=============================================================================================
class Pizza {
	
	String name; // 피자 이름
	String size; // 피자 사이즈
	int price; // 피자 가격
	
	public Pizza() {
		
		this.name = "치즈피자";
		this.size = "M";
		this.price = 15000;
	}
	
	public Pizza(String name, String size) {
				//	 "불고기피자",		 "L"
				//	 "페퍼로니피자",	 "M"
		this.name = name;
		this.size = size;
		
		if(size.equals("L")) this.price = 20000; // L 사이즈는 20000원
		else this.price = 15000; // M 사이즈는 15000원
	}
}// --- Pizza 클래스


public class 생성자_연습문제_5개 {

	public static void main(String[] args) {
		
		//연습1 확인. 학생 객체 만들기
		System.out.println("======= 연습1. Student =======");
		
		// 기본 생성자 Student 클래스로 객체 생성
		Student s1 = new Student();
		System.out.println(s1.name); // "무명"
		System.out.println(s1.age); // 0
		
		// 매개변수가 작성되어 있는 생성자로 객체 생성
		Student s2 = new Student("홍길동", 20);
		System.out.println(s2.name); // "홍길동"
		System.out.println(s2.age); // 20
		
		//-------------------------------------------------------------------
		
		//연습2 확인. 은행 계좌 객체 만들기
		System.out.println("===== 연습2. BankAccount =====");
		
		// 기본 생성자 BankAccount 클래스로 객체 생성
		BankAccount acc1 = new BankAccount();
		System.out.println(acc1.owner); // "미지정"
		System.out.println(acc1.balance); // 0
		
		// 매개변수가 작성되어 있는 생성자로 객체 생성
		BankAccount acc2 = new BankAccount("김길동", 50000);
		System.out.println(acc2.owner); // "김길동"
		System.out.println(acc2.balance); // 50000
		
		//-------------------------------------------------------------------
		
		//연습3 확인. 책 객체 만들기
		System.out.println("======== 연습3. Book ========");
		
		// 기본 생성자 Book 클래스로 객체 생성
		Book book1 = new Book();
		System.out.println(book1.title); // "제목없음"
		System.out.println(book1.author); // "작자미상"
		System.out.println(book1.price); // 0
		
		// 매개변수가 작성되어 있는 생성자로 객체 생성
		Book book2 = new Book("자바의정석", "남궁성", 30000);
		System.out.println(book2.title); // "자바의정석"
		System.out.println(book2.author); // "남궁성"
		System.out.println(book2.price); // 30000
		
		//-------------------------------------------------------------------
		
		//연습4 확인. 핸드폰 객체 만들기
		System.out.println("======== 연습4. Phone ========");
		
		// 생성자 1번 호출(매개변수 0개)
		Phone p1 = new Phone();
		System.out.println(p1.model + " / " + p1.storage + "GB");
		
		// 생성자 2번 호출(매개변수 1개)
		Phone p2 = new Phone("갤럭시 S26");
		System.out.println(p2.model + " / " + p2.storage + "GB"); 
		
		// 생성자 3번 호출(매개변수 2개)
		Phone p3 = new Phone("아이폰 17", 512);
		System.out.println(p3.model + " / " + p3.storage + "GB");
		
		//-------------------------------------------------------------------
		
		// 연습5 확인. 피자 객체 만들기
		System.out.println("======== 연습5. Pizza ========");
		
		Pizza z1 = new Pizza();
		System.out.println(z1.name + " / " + z1.size + " / " + z1.price);
		
		Pizza z2 = new Pizza("불고기피자", "L");
		System.out.println(z2.name + " / " + z2.size + " / " + z2.price);
		
		Pizza z3 = new Pizza("페퍼로니피자", "M");
		System.out.println(z3.name + " / " + z3.size + " / " + z3.price);
	}

}

/*
	======= 연습1. Student =======
	무명
	0
	홍길동
	20
	===== 연습2. BankAccount =====
	미지정
	0
	김길동
	50000
	======== 연습3. Book =========
	제목없음
	작자미상
	0
	자바의정석
	남궁성
	30000
	======== 연습4. Phone ========
	미정 / 128GB
	갤럭시 S26 / 128GB
	아이폰 17 / 512GB
	======== 연습5. Pizza ========
	치즈피자 / M / 15000
	불고기피자 / L / 20000
	페퍼로니피자 / M / 15000
*/