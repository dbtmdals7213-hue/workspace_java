package StringTest;

public class Ex2 {

	public static void main(String[] args) {
		
		String str5 = "JAVA_Study";
		//			   0123456789	<- 인덱스
		
		//1. length(): 전체 문자열의 총 문자 개수 반환한다.
		System.out.println("length() = " + str5.length()); // 10
		
		System.out.println("-------------------------------------------------------");
		
		//2. charAt(인덱스): 전달한 인덱스 위치의 문자 하나를 반환한다. 반환 타입은 char 다.
		System.out.println("charAt(0) = " + str5.charAt(0)); // "J"
		System.out.println("charAt(9) = " + str5.charAt(9)); // "y"
		
		// 없는 인덱스를 매개변수로 넣으면 실행 중 예외가 발생한다.
		// str5.charAt(10);
		// -> StringIndexOutOfBoundsException
		
		System.out.println("-------------------------------------------------------");
		
		//3. equals(Object obj): String 객체 메모리에 보관된 문자열 값이 같은지 비교한다.
		String str1 = new String("Coffee");
		String str2 = new String("House");
		
		// 두 String 객체 메모리에 저장된 문자열 값이 같으냐?
		if(str1.equals(str2)) {
			
			System.out.println("두 문자열이 같다."); // 실행되지 않는다.
		}else {
			
			System.out.println("두 문자열이 다르다."); // 실행됨
		}
		
		String str3 = new String("House");
		
		// str2 참조변수의 String 객체 메모리 내부의 "House" 와
		// str3 참조변수의 String 객체 메모리 내부의 "House" 가 같으냐?
		if(str2.equals(str3)) {
			
			System.out.println("str2 와 str3 이 참조하고 있는 String 객체 메모리 안의 문자열은 같다."); // 실행됨
		}
		
		// ! 논리 부정 연산자는 결과를 반대로 뒤집는다. !true 는 false 가 되고, !false 는 true 가 된다.
		String str6 = "저장할문자열1";
		String str7 = "저장할문자열2";
		
		// 두 String 객체 메모리 안의 문자열이 다르냐? 라고 물어봅시다.
		if(!str6.equals(str7)) {
			
			System.out.println("str6 과 str7 이 사용하고 있는 String 객체 메모리 안의 문자열은 다르다."); // 실행됨
		}
		
		// 리터럴 문자열에 직접 메소드를 호출해도 된다. 리터럴 문자열 자체가 String 객체를 표현하기 때문이다.
		System.out.println("A".equals("B")); // false
		
		// equals 메소드는 대문자와 소문자를 구분해서 같은지 비교한다.
		System.out.println("JAVA".equals("java")); // false
		
		// equalsIgnoreCase 메소드는 대문자와 소문자를 구분하지 않고 같은지 비교한다.
		System.out.println("JAVA".equalsIgnoreCase("java")); // true
		
		System.out.println("-------------------------------------------------------");
		
		//4. subString(): 전체 문자열의 일부를 잘라서 새 문자열로 만들어 반환한다.
		String a = new String("AndroidJSPJAVA");
		//					   0123456789....	<- 인덱스
		
		String temp1, temp2;
		
		// 인덱스 7위치의 문자부터 9인덱스 위치의 문자까지 잘라서 하나의 문자열로 얻자
		temp2 = a.substring(7, 10);
		
		System.out.println("substring(7, 10) = " + temp2); // "JSP"
		
		// 인덱스 7 위치의 문자부터 끝까지 잘라서 하나의 문자열로 얻자
		temp1 = a.substring(7);
		
		System.out.println("substring(7) = " + temp1); // "JSPJAVA"
		
		// a 참조변수의 String 객체 메모리 안의 전체 문자열은 변경되지 않는다.
		System.out.println("원본 a = " + a); // "AndroidJSPJAVA"
		
		System.out.println("-------------------------------------------------------");
		
		//5. trim(): 전체 문자열에서 앞, 뒤 공백만 제거한 새 문자열을 만들어 반환한다.
		String b = new String("    JA     VA      ");
		String temp3 = b.trim();
		
		System.out.println("trim() 결과: [" + temp3 + "]"); // [JA     VA]
		
		// strip(): trim 과 비슷하지만 어러 나라의 공백 문자까지 처리한다.(Java 11 이상)
		System.out.println("strip() 결과: [" + b.strip() + "]"); // [JA     VA]
		
		System.out.println("-------------------------------------------------------");
		
		//6. concat(): 두 문자열을 이어붙인 새 문자열을 반환한다.
		String c = "JAVA";
		String d = new String("PG");
		
		String temp4 = c.concat(d);
		System.out.println("concat() 결과: " + (c + d)); // "JAVAPG"
		
		// + 연산자로 이어 붙이는 것과 결과는 같다.
		System.out.println("+ 연산자 결과: " + (c + d)); // "JAVAPG"
		
		System.out.println("-------------------------------------------------------");
		
		//7. contains(): 특정 문자열이 포함되어 있는지 검사한다.
		//	 포함되어 있으면 true, 없으면 false 를 반환한다.
		
		String e = new String("필요없는문자열해당문자열필요없는문자열");
		
		boolean result = e.contains("해당문자열");
		System.out.println("\"해당문자열\" 포함 여부 = " + result); // true
		
		result = e.contains("문자열");
		System.out.println("\"문자열\" 포함 여부 = " + result); // true
		
		result = e.contains("JAVA");
		System.out.println("\"JAVA\" 포함 여부 = " + result); // false
		
		System.out.println("-------------------------------------------------------");
		
		//8. replace(): 찾은 부분을 다른 것으로 바꾼 새 문자열을 반환한다.
		String f = new String("JAVAJSPC");
		
		// 작은 따옴표는 문자 하나(char), 큰 따옴표는 문자열(String)이다.
		String result2 = f.replace('C', '!');
        System.out.println("문자 단위 replace   => " + result2);   // JAVAJSP!

        result2 = f.replace("JSPC", "PROGRAMMING");
        System.out.println("문자열 단위 replace => " + result2);   // JAVAPROGRAMMING

        // 빈 문자열로 바꾸면 해당 부분이 제거되는 효과가 된다.
        System.out.println("A 제거              => " + f.replace("A", ""));   // JVJSPC
		
        System.out.println("-------------------------------------------------------");
        
		//9. toLowerCase() / toUpperCase(): 소문자, 대문자로 바꾼다.
		String lowerStr = "Hello World";
		System.out.println("toLowerCase() = " + lowerStr.toLowerCase());
		System.out.println("toUpperCase() = " + lowerStr.toUpperCase());
		
		System.out.println("-------------------------------------------------------");
		
		//10. String.valueOf(): 다른 타입의 값을 문자열로 바꾼다.
		// -> 특정 값을 문자열로 변환
		String newStr = String.valueOf(10);
		System.out.println("valueOf(10) = " + newStr); // "10"
		
		// 문자열 "10" 이 되었는지 확인한다. length() 메소드 호출해보자
		// 숫자 10이라면 length() 메소드 호출 불가능할 것이다.
		System.out.println("newStr.length() = " + newStr.length()); // 2
		
		// 3.14 실수를 문자열 "3.14" 로 변경해서 얻고 싶다.
		System.out.println(String.valueOf(3.14)); // "3.14"
		
		// true 불린을 문자열 "true" 로 변경해서 얻고 싶다.
		System.out.println(String.valueOf(true)); // "true"
		
		// -> 문자열을 정수 숫자로 변환
		int num = Integer.parseInt("10");
		System.out.println(num + 5); // 15
		
	}// === main 메소드

}// --- Ex2 클래스


