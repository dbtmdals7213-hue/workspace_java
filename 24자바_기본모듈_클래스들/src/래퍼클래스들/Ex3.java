package 래퍼클래스들;

public class Ex3 {

	public static void main(String[] args) {
		
		// 기본 자료형 정수 데이터 하나 수동 박싱
		Integer num01 = new Integer(10); // 10 수동 박싱
		Integer num02 = new Integer("20"); // 문자열 객체 메모리에서 20을 추출해서 Integer 객체의 변수에 저장
		
		// 래퍼 클래스의 객체 메모리 내부에 저장된 기본 자료형 값을 꺼내오는 수동 언 박싱
		int n01 = num01.intValue(); // 수동 언 박싱 -> 10
		int n02 = num02.intValue(); // 수동 언 박싱 -> "20" 을 꺼내올 때 정수 20으로 변환 후 반환
		
		int sum = n01 + n02;
		//  30  =  10 + 20
		
		System.out.println(sum); // 30
		
		System.out.println("sum 변수 값 30을 2진수로 변환 -> " + Integer.toBinaryString(sum));
		//				   "sum 변수 값 30을 2진수로 변환 -> " + "11110"

		System.out.println("sum 변수 값 30을 8진수로 변환 -> " + Integer.toOctalString(sum));
		//		   		   "sum 변수 값 30을 8진수로 변환 -> " + "36"					
		
		System.out.println("sum 변수 값 30을 16진수로 변환 -> " + Integer.toHexString(sum));
		//				   "sum 변수 값 30을 16진수로 변환 -> " + "1e"

		// 수동 박싱: 기본 자료형 데이터를 래퍼 클래스의 객체 메모리에 저장
		Integer num03 = new Integer(30);

		// 수동 언 박싱: 위 박싱된 Integer 객체 메모리 내부의 인스턴스 변수에 저장된 30을 30.0으로 변환해서 꺼내와 얻는 작업.
		// 방법 -> Integer 클래스 내부에 만들어진 double doubleValue() 메소드 사용!
		double result = num03.doubleValue(); // 30.0으로 언 박싱됨
		System.out.println(result); // 30.0
		
	}// === main 메소드

}// --- Ex3 클래스


