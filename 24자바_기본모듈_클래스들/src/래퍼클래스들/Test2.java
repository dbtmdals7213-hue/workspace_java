package 래퍼클래스들;

public class Test2 {

	public static void main(String[] args) {
		
		//=============================================
		// 1부. 문자열 -> 기본 자료형 변환 (parse... 메소드 사용)
		//=============================================
		
		// "123" 문자열을 기본 자료형 값 123으로 변환하여 반환받아 int i 변수에 저장
		int i = Integer.parseInt("123"); // "123" 변환해서 반환 -> 123
		// 123
		// 주의:	"123a" 처럼 숫자로 바꿀 수 없는 문자열을 넣으면 NumberFormatException 예외가 발생한다.
		
		// "true" 문자열을 기본 자료형 값 true 로 변환하여 반환받아 boolean 변수에 저장
		boolean b = Boolean.parseBoolean("true"); // "true" 변환해서 반환 -> true
		// true
		// 참고:	대소문자는 구분하지 않는다. "TRUE", "True" 도 true 로 변환된다.
		//		"true" 가 아닌 모든 문자열("yes", "1" 포함)은 false 로 변환된다.
		
		// "3.141592" 문자열을 기본 자료형 값 3.141592로 변환하여 반환받아 float f 변수에 저장
		float f = Float.parseFloat("3.141592"); // "3.141592" 변환해서 반환 -> 3.141592f
		// 3.141592
		// 참고:	변환 대상 자료형만 다를 뿐, 동작 원리는 parseInt 와 완전히 같다.
		//		(Double.parseDouble, Long.parseLong, Byte.parseByte 등도 전부 동일한 규칙)
		
		//===============================================
		// 2부. 기본 자료형 -> 문자열로 변환(toString() 메소드 사용)
		//===============================================
		
		// 정수 123을 문자열 "123" 으로 변환 후, 저장된 문자열 객체 메모리의 주소를 반환받아 String s1 참조변수에 저장
		String s1 = Integer.toString(123); // 123 변환해서 반환 -> "123"
		// "123"
		
		// 문자 'a' 를 문자열 "a" 로 변환 후, 저장된 문자열 객체 메모리의 주소 번지를 반환받아 String s3 참조변수에 저장
		String s3 = Character.toString('a'); // 'a' 변환해서 반환 -> "a"
		// "a"
		
	}// === main 메소드

}// --- Test2 클래스


