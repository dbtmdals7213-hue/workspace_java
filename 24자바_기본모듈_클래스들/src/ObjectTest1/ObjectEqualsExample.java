package ObjectTest1;

/*
	Member 클래스 선언
	extends 를 쓰지 않았으므로 컴파일러가 "extends Object" 를 자동으로 붙인다.
	그 결과 Member 는 Object 의 equals 메소드를 상속받는다.
*/
class Member {
	
	// 인스턴스 변수: 각 Member 객체마다 따로 만들어지는 변수. 회원 아이디를 저장한다.
	public String id;
	
	// 기본 생성자: 매개변수 없이 만든 생성자이므로 id 인스턴스 변수는 초기화 되지 않고, null 이 저장된 상태이다.
	public Member() {}
	
	// 매개변수 생성자: 매개변수 id 로 전달받은 아이디를 인스턴스 변수 id 에 초기화한다.
	public Member(String id) {
		
		this.id = id;
		// this.id : 이 Member 객체의 인스턴스 변수 id
		// id: 매개변수로 전달된 값
	}
}

public class ObjectEqualsExample {

	public static void main(String[] args) {
		
		//=====================================================
		//1. 서로 다른 두 개의 new Member 객체의 주소 번지가 같은지 비교한다.
		//=====================================================
		Member member1 = new Member(); // <- 생성된 객체 주소 번지: 0x100
		
		Member member2 = new Member(); // <- 생성된 객체 주소 번지: 0x200
		
		boolean result = member1.equals(member2);
		
		System.out.println("member1.equals(member2) = " + result); // false
		
		// equals 메소드 내부 코드 동작과 동일한 == 연산자로 확인해도 결과는 위와 같다.
		System.out.println("member1 == member2 = " + (member1 == member2));
		
		System.out.println("---------------------------------------");
		
		//===================================
		//2. 같은 객체를 가리키는 두 참조변수를 비교한다.
		//===================================
		
		// new 를 실행하지 않고, member1 참조변수에 저장된 첫 번째 Member 객체의 주소값을 그대로 복사해서 저장
		// member1 과 member3 참조변수는 같은 하나의 Member 객체 메모리는 가리킨다.(사용한다.)
		Member member3 = member1;
		
		// 두 참조변수에 저장된 Member 객체 메모리의 주소값이 같으냐? 같으면? true 출력
		System.out.println("member1.equals(member3) = " + member1.equals(member3)); // true 같음을 의미
	
		//=====================================
		//3. 인스턴스 변수 값이 같아도 결과는 false 이다.
		//=====================================
		
		// 두 객체 모두 인스턴스 변수 값이 "hong" 으로 같다.
		Member member4 = new Member("hong");
		Member member5 = new Member("hong");
		
		System.out.println("member4.id = " + member4.id + ", member5.id = " + member5.id);
		System.out.println("member4.equals(member5) = " + member4.equals(member5)); // false
		
		// 인스턴스 변수 값 자체가 같은지 비교할 때 인스턴스 변수 값 얻어 같은지 비교한다.
		// String 클래스는 equals 메소드가 오버라이딩 되어있어 문자열 값이 같은지 비교한다.
		System.out.println("member4.id.equals(member5.id) = " + member4.id.equals(member5.id)); // true
		
		System.out.println("---------------------------------------");
		
	}

}


