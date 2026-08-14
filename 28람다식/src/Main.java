
/*
	함수형 인터페이스란?
	 - 추상 메소드를 단 하나만 가진 인터페이스
	 - 람다식으로 익명 메소드를 만들 때 사용되는 인터페이스
	
	함수형 인터페이스를 개발자가 직접 만들어서 사용하려면?
	 - @FunctionalInterface 어노테이션 기호를 인터페이스 위에 작성해서 만든다.
	
	@FunctionalInterface 어노테이션 기호 의미
	 - 이 인터페이스가 함수형 인터페이스로 만들어져 있다! 라고 자바 컴파일러(javac.exe)에게 알려주는 기호.
*/

// 주제:	개발자가 직접 함수형 인터페이스를 만들어서 사용해보자.

@FunctionalInterface
interface MathOperation {
	
	// 추상 메소드
	// 기능:	두 개의 정수를 매개변수로 각각 전달받아 계산한 정수 값을 반환하는 기능
	int operation(int a, int b);
}

public class Main {

	public static void main(String[] args) {
		
		/*
			1. 람다식 작성 X :
				MathOperation 함수형 인터페이스 내부의 operation 추상 메소드를 강제로 오버라이딩(구현)한
				이름이 없는 익명 클래스와 익명 구현 객체를 만들어 add 참조 변수에 저장
				
				메소드 오버라이딩 할 기능 내용
				-> operation 메소드의 매개변수로 두 개의 정수를 각각 전달받아 더한(+) 결과 정수 값을 반환하는 기능
		*/
		MathOperation add = new MathOperation() {
			
			@Override
			public int operation(int a, int b) {
				
				return a + b;
			}
		};
		
		System.out.println(add.operation(5, 3));
		/*
			설명:	 여기서 익명 클래스는 MathOperation 부모 인터페이스의 추상 메소드 operation 을
				 강제로 구현(메소드 오버라이딩) 하는 익명 객체를 생성하며,
				 익명 객체 내부에 operation 추상 메소드를 강제로 오버라이딩 해놓은 것 입니다.
		*/
		
		//===============================================================================================
		
		/*
			2. 람다식 작성 O : 
				MathOperation 함수형 부모 인터페이스 내부의 operation 추상 메소드를 구현한 익명 메소드의 매개변수로 두 개의 정수를
				각각 전달 받아 더한 결과 값 하나를 정수로 반환하는 기능의 익명 메소드를 람다식으로 작성.
		*/
		MathOperation add2 = (int a, int b) -> {return a + b;};
		
		// 5 + 3 결과를 얻고 싶다.
		System.out.println(add2.operation(5, 3)); // 3
		
		/*
			2-1. 람다식 작성 O 연습:
				MathOperation함수형 부모인터페이스 내부의 operation 추상메소드를 구현한 익명메소드의 매개변수로 두개의 정수를 각각 전달 받아서
				첫 매개변수 값에서 두번쨰 매개변수 값을 뺸(-) 계산 결과 값 하나를 정수로 반환하는 기능의 익명메소드를 람다식으로 작성
		*/					
		MathOperation subtract = (int a, int b) -> {return a - b;};
		
		// 5 - 3 결과를 얻고 싶다.
		System.out.println(subtract.operation(5, 3)); // 2
		
		/*
			 2-2. 람다식 작성 O 연습:
				 MathOperation 함수형 부모인터페이스 내부의 operation 추상메소드를 구현한 익명메소드의 매개변수로
				 두 개의 정수를 전달 받아 곱하기(*) 계산 결과를 정수로 반환하는 람다식 작성
		*/
		MathOperation multiply = (a, b) -> a * b;
		
		// 5 * 3 결과를 얻고 싶다.
		System.out.println(multiply.operation(5, 3)); // 15
		
		/*
			2-3. 람다식 작성 O 연습:
				MathOperation 함수형 부모인터페이스 내부의 operation 추상메소드를 구현한 익명메소드의 매개변수로
				두 개의 정수를 전달 받아 나눗셈(/) 계산 결과를 정수로 반환하는 람다식 작성
		*/			
		MathOperation divideDetail = (int a, int b) -> {
			
			if(b == 0) {
				
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			
			// b 매개변수로 전달받은 값이 0이 아니면 나눗셈 연산을 할 수 있기 때문에 아래 코드 작성
			return a / b;
		};
		
		// 10 / 3 몫을 정수로 얻기 위해 익명 메소드 사용
		System.out.println(divideDetail.operation(10, 3));
		
		// 10 / 0 의 몫을 정수로 얻을 수 없다! ArithmeticException 수학 계산 X 예외가 발생한다.
		// System.out.println(divideDetail.operation(10, 0));
		
		/*
	 		2-3. 람다식 작성 O 연습:
	 			MathOperation 함수형 부모인터페이스 내부의 operation 추상메소드를 구현한 익명메소드의 매개변수로
	 			두 개의 정수를 전달 받아 나눗셈(/) 계산 결과를 정수로 반환하는 람다식 작성
		*/
		MathOperation divideDetail2 = (int a, int b) -> {return (b == 0) ? Main.throwException() : a / b;};
		
		// 10 / 3 의 몫 구하기
		System.out.println(divideDetail2.operation(10, 3)); // 3
		
		System.out.println(divideDetail2.operation(10, 0)); // 0 으로 나눌 수 없어서 예외 메세지 출력됨
		
	}// === main Method
	
	//외부에 메소드 하나 만들어서 처리 
	static int throwException() {
		
		throw new ArithmeticException("0으로 나눌 수 없습니다.");
	}

}// --- Main Class




