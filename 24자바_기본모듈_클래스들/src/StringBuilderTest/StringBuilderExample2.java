package StringBuilderTest;

public class StringBuilderExample2 {

	public static void main(String[] args) {
		
		// 사이트 이용자가 입력창에서 입력했다고 가정한 데이터
		String city = "서울특별시";
		String district = "강남구";
		String street = "테헤란로";
		String buildingNo = "123";
		String detail = "501호(ABC빌딩)";
		
		StringBuilder address = new StringBuilder();
		
		// 순서대로 문자열을 StringBulder 객체 메모리 하나에 추가해서 저장할 수 있음(메소드 체이닝 기법 이용)
		address.append(city)		// "서울특별시"
			   .append(" ")			// "서울특별시 "
			   .append(district)	// "서울특별시 강남구"
			   .append(" ")			// "서울특별시 강남구 "
			   .append(street)		// "서울특별시 강남구 테헤란로"
			   .append(" ")			// "서울특별시 강남구 테헤란로 "
			   .append(buildingNo)	// "서울특별시 강남구 테헤란로 123"
			   .append(" ")			// "서울특별시 강남구 테헤란로 123 "
			   .append(detail);		// "서울특별시 강남구 테헤란로 123 501호(ABC빌딩)"
		
		String fullAddress = address.toString();
		
		System.out.println("최종 주소: " + fullAddress.toString());
		// 최종 주소: 서울특별시 강남구 테헤란로 123 501호(ABC빌딩)
	}// === main 메소드

}// StringBuilderExample2 클래스


