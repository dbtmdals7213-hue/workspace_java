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
		
		// 정수 123을 16진수 형태의 문자열 "7b" 로 변환 후, 저장된 문자열 개체 메모리의 주소를 반환받아 String s2 참조변수에 저장
		String s2 = Integer.toHexString(123); // 123 변환해서 반환 -> "7b"
		// "7b"
		// 참고:	16진수는 0 ~ 9 다음을 a ~ f 로 표현하는 진법이다.
		//		123 = (16 × 7) + 11 이고, 11을 16진수로 쓰면 b 이므로 결과가 "7b" 가 된다.
		//		2진수 변환은 toBinaryString(123) -> "1111011", 8진수는 toOctalString(123) -> "173"
		
		// 문자 'a' 를 문자열 "a" 로 변환 후, 저장된 문자열 객체 메모리의 주소 번지를 반환받아 String s3 참조변수에 저장
		String s3 = Character.toString('a'); // 'a' 변환해서 반환 -> "a"
		// "a"
		
		// boolean 자료형의 값 true 를 문자열 "true" 로 변환 후, 저장된 문자열 객체 메모리의 주소를 반환받아 String s4 참조변수에 저장
		String s4 = Boolean.toString(true); // true 변환해서 반환 -> "true"
		// "true"
		
		//=================
		// 반환 결과 확인용 출력
		//=================
		System.out.println("===== 1부. 문자열 -> 기본 자료형으로 변환 =====");
		System.out.println("i = " + i); // 123
		System.out.println("b = " + b); // true
		System.out.println("f = " + f);	// 3.141592
		// 기본 자료형으로 변환되었으므로 산술 연산이 가능함을 확인
		System.out.println("i + 1 = " + (i + 1)); // 124 <- 진짜 숫자라서 계산이 된다!
		
		System.out.println("===== 2부. 기본 자료형 -> 문자열로 변환 =====");
		System.out.println("s1 = " + s1); // "123"
		System.out.println("s2 = " + s2); // "7b"
		System.out.println("s3 = " + s3); // "a"
		System.out.println("s4 = " + s4); // "true"
		// 문자열로 변환되었으므로 + 는 산술이 아니라 문자열 결합이 됨을 확인
		System.out.println("s1 + 1 = " + (s1 + 1)); // "1231" <- 문자열이라서 "1" 이 이어 붙는다!
		
	}// === main 메소드

}// --- Test2 클래스


