package StringTest;

public class Ex1 {

	public static void main(String[] args) {
		
		//1. String 클래스의 객체 생성 방법 3가지
		
		// 방법1.	 리터럴 문자열 대입. 문자열 상수 풀에 저장된다.
		String s1 = "JAVA";
		
		// 방법2.	 new 연산자 사용. 상수 풀과 별개로 새 객체가 만들어진다.
		String s2 = new String("programming");
		
		// 방법3.	 char 배열을 생성자에 전달한다.
		// 순서1.	 각 문자들이 들어있는 배열을 만든다.
		char[] charArr = {'S', 't', 'r', 'i', 'n', 'g'};
		
		// 순서2.	 배열을 생성자에 전달하면 문자들을 순서대로 이어붙여 하나의 문자열 "String" 을 저장한 객체가 만들어진다.
		String s3 = new String(charArr);
		
		// String 의 toString() 메소드는 저장된 문자열 자체를 반환하도록 재정의(메소드 오버라이딩) 되어 있다.
		// 그래서 toString() 메소드 호출 구문을 작성해 놓든 말든 출력 결과는 같다.
		System.out.println(s1.toString()); // "JAVA"
		System.out.println(s1); // "JAVA"
		System.out.println(s2.toString()); // "programming"
		System.out.println(s3.toString()); // "String"
		System.out.println(s3); // "String"
		
		System.out.println("---------------------------------------------------------");
		
		String str3 = "JSP"; // "JSP" 문자열을 보관하는 String 객체 메모리 생성 후 주소 번지 str3 참조변수에 저장
		String str4 = "JSP";
		
		if(str3 == str4) {
			
			System.out.println("[리터럴] 두 참조 변수가 같은 String 객체 하나를 가리킨다.(== 결과 true)");
		}else {
			
			System.out.println("[리터럴] 서로 다른 String 객체다(== 결과 false)");
		}
		
		System.out.println("---------------------------------------------------------");
		
		//3. 방법2. 로 만든 두 String 객체 비교(new 연산자)
		
		String str1 = new String("Java");
		String str2 = new String("Java");
		
	}

}


