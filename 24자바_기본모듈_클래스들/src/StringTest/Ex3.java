package StringTest;

/*
	데이터 베이스의 member 테이블에서 조회한 회원 한 사람의 정보를 담아 둘 DTO 클래스다.
	이렇게 데이터를 담아서 전달하는 용도로만 쓰는 클래스를 DTO 라고 부른다.
*/
class MemberDTO {
	
	// private 로 인스턴스 변수 선언
	private String name; // 회원 이름
	private String address; // 회원 전체 주소. 예) "광주시 북구 북문로 112/505호"
	
	// 생성자. MemberDTO 객체를 만들 때 이름과 주소를 전달받아 인스턴스 변수를 초기화한다.
	public MemberDTO(String name, String address) {
		
		this.name = name;
		this.address = address;
	}
	
	// getter 메소드. private 인스턴스 변수의 값을 외부 클래스에서 읽을 수 있게 해준다.
	public String getName() {
		
		return this.name;
	}
	
	public String getAddress() {
		
		return this.address;
	}
	
	// 회원 전체 주소("광주시 북구 북문로 112/505호")에서 상세 주소("505호") 부분만 잘라내어 반환하는 메소드
	public String getDetailAddress() {
		
		int lastIndex = this.address.lastIndexOf('/');
		
		if(lastIndex != -1 && lastIndex + 1 < this.address.length()) {
			
			// 슬래시 다음 위치부터 끝 문자까지 잘라서 반환한다. 결과는 "505호" 가 된다.
			// 상세 주소 "505호" 반환
			return address.substring(lastIndex + 1);
		}
		// 슬래시가 없거나(상세 주소가 없거나), 슬래시 뒤에 글자가 없으면(상세 주소가 없으면?) 전체 주소를 그대로 반환하자
		return this.address;
	}
	
}// --- MemberDTO 클래스

public class Ex3 {

	public static void main(String[] args) {
		
		// final 을 붙이면 값을 바꿀 수 없는 상수 메모리가 된다.
		// 상수의 이름은 모두 대문자로 쓰고, 단어 사이는 밑 줄로 구분하는 것이 관례이다.
		final int MEMBER_COUNT = 5;
		
		MemberDTO[] memberArray = new MemberDTO[MEMBER_COUNT];
		
		// 배열 각 칸에 MemberDTO 객체를 만들어 차례대로 넣는다.
		memberArray[0] = new MemberDTO("홍길동", "서울시 강남구 테헤란로 123/101호");
		memberArray[1] = new MemberDTO("김청수", "부산시 해운대구 해변로 456/202호");
		memberArray[2] = new MemberDTO("이영희", "대구시 수성구 수성로 789/303호");
		memberArray[3] = new MemberDTO("박지민", "인천시 남동구 남동대로 101/404호");
		memberArray[4] = new MemberDTO("최준호", "광주시 북구 북문로 112/505호");
		
		for(MemberDTO memberdto : memberArray) {
			
			System.out.println("이름: " + memberdto.getName() + ", 전체 주소: " + memberdto.getAddress());
		}
		
		System.out.println("---------------------------------------------");
		
		// 슬래시가 없는(상세 주소가 없는) 주소의 회원일 때의 동작도 확인한다. -> 상세 주소 없기 때문에 전체 주소가 그대로 반환된다.
		MemberDTO noDetail = new MemberDTO("정하나", "제주시 연동 999");
		System.out.println("이름: " + noDetail.getName() + ", 상세 주소: " + noDetail.getDetailAddress());
		
		// indexOf 메소드와 lastIndexOf 메소드의 차이를 직접 확인한다.
		String text = "apple, banana, cherry, banana, date";
		
		System.out.println("indexOf(\"banana\") = " + text.indexOf("banana")); // 7
		System.out.println("lastIndexOf(\"banana\") = " + text.lastIndexOf("banana")); // 23
		System.out.println("lastIndexOf(\"melon\") = " + text.lastIndexOf("melon")); // -1
		
	}// === main 메소드

}// --- Ex3 클래스


