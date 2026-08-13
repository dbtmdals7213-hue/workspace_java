
// 함수형 인터페이스 예 실습 - Ex1.java

// 람다식? 함수형 인터페이스를 구현한 익명 객체의 익명 메소드를 만드는 식.

// 함수형 인터페이스란? 오직 하나의 추상 메소드만 작성되어 있는 인터페이스로 람다식 작성 시 사용됩니다.

//========================= 자바에서 제공해주는 java.util.function 패키지에 포함된 함수형 인터페이스들 불러오기 =========================
import java.util.function.Function; // Function 함수형 인터페이스 내부의 apply 추상 메소드를 오버라이딩해서 익명 메소드(람다식) 작성을 위해 불러온다.

import java.util.function.Predicate; // Predicate 함수형 인터페이스 내부의 test 추상 메소드를 오버라이딩해서 익명 메소드(람다식) 작성을 위해 불러온다.

import java.util.function.Consumer; // Consumer 함수형 인터페이스 내부의 accept 추상 메소드를 오버라이딩해서 익명 메소드(람다식) 작성을 위해 불러온다.

public class Ex1 {

	public static void main(String[] args) {
		
		// 예시로 5를 매개변수 i 로 전달하면 "숫자: 5" 라는 문자열을 반환하는 람다식 작성
		Function<Integer, String> intToString = (i) -> {return "숫자: " + i;};
		/*
			설명
				이름이 없는 익명 객체 주소 번지를 intToString 참조 변수에 Function 부모 인터페이스의 자식 익명 객체로 저장되어 있다.
				익명 객체 내부에는 Function 함수형 부모 인터페이스 내부에 apply 추상 메소드를 강제로 오버라이딩한 이름이 없는 익명 메소드를
				람다식 (i) -> {return "숫자: " + i;}; 으로 작성하여 정의했다.
		*/
		System.out.println(intToString.apply(5)); // "숫자: 5" 문자열을 반환 받아 이 자리에 출력
		
		/*
			2. Predicate<T> 함수형 인터페이스
			 - 값을 매개변수로 받아서 boolean 값을 반환 하는 기능의 test 추상 메소드가 작성된 함수형 인터페이스
			 - T 는 매개변수로 전달받는 값의 타입을 의미하며, boolean 값을 반환합니다.
			
			Predicate<String> isEmpty = new Predicate<String>(){
			
				부모 인터페이스 Predicate 에 작성된 추상 메소드 test 를 강제로 오버라이딩해서 작성
				-> boolean test(String t) 추상 메소드를 강제로 오버라이딩
				
				@Override
				public boolean test(String t) {
					
					return t.isEmpty();
				}
			};
		*/
		// test 메소드의 매개변수로 전달하는 문자열이 없는 경우에는 true 반환하고, 그렇지 않으면 false 반환하는 람다식으로 익명 메소드 작성
		Predicate<String> isEmpty = (String t) -> {return t.isEmpty();};
		
		// 메소드 오버라이딩해서 작성해놓은 이름이 없는 익명 메소드를 test(""); 형태로 호출해서 반환받은 결과 출력
		System.out.println(isEmpty.test("")); // true
		
		
		
	}// === main Method

}// --- Ex1 Class




