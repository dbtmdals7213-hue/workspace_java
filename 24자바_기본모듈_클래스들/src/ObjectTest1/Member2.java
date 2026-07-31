package ObjectTest1;

public class Member2 {// <- 가입할 회원 한 사람의 정보

	private final String id; // 회원 아이디
	private final String name; // 회원 이름
	private final int age; // 회원 나이
	
	public Member2(String id, String name, int age) {
		
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		
		return id;
	}

	public String getName() {
		
		return name;
	}

	public int getAge() {
		
		return age;
	}

	@Override
	public int hashCode() {
		
		return 0; // 재구현 부분 생략(항상 0을 반환한다)
	}

	@Override
	public boolean equals(Object obj) {
		
		return false; // 재구현 부분 생략(항상 false 를 반환한다)
	}

	@Override
	public String toString() {
		
		return "Member[id = " + id + ", name = " + name + ", age = " + age + "]";
	}
	
}// --- Member2 클래스


