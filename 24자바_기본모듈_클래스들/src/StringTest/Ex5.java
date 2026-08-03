package StringTest;

public class Ex5 {

	public static void main(String[] args) {
		
		// 원본 문자열
		String originalString = "Hello, World!"; // 변경 -> "Heo, Word!"
		
		// 제거할 대상 문자열
		String deleteString = "l";
		
		// 결과를 저장할 변수
		String modifiedString = ""; // "Heo, Word!"
		
		modifiedString = originalString.replace(deleteString, "");
		
		System.out.println("원본 문자열: " + originalString);
		System.out.println("modifiedString: " + modifiedString); // "Heo, Word!"
		
		System.out.println("----------------------------------");
		
		String test = "Hello, World!";
		
		test.replace("l", ""); // 결과를 버리는 코드
		System.out.println("변수에 저장하지 않는 경우: " + test); // "Hello, World!" (그대로)
		
		test = test.replace("l", ""); // 올바른 사용
		System.out.println("변수에 저장한 경우: " + test);
		
		// 여러 글자를 한 번에 치환할 수 있다.
		System.out.println(originalString.replace("lo", "")); // "Hel, World!"
		
		// 전체 문자열에서 대문자 "L" 을 "" 로 치환 시 대문자와 소문자는 구분하기 때문에 아무런 영향이 없다.
		System.out.println(originalString.replace("L", "")); // "Hello, World!"
		
	}// === main 메소드

}// --- Ex5 클래스


