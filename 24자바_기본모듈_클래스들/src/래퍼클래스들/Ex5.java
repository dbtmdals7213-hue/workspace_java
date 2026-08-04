package 래퍼클래스들;

public class Ex5 {

	public static void main(String[] args) {
		
		int n1 = 10; // <- 기본 자료형 int 값 10. Stack 공간에 직접 저장된다.
		
		int n2; // <- 기본 자료형 변수 선언만 함(아직 값 없음)
		
		Integer num1; // <- 참조 자료형 변수 선언만 함(아직 객체 주소 값 없음)
		
		// 박싱(수동 박싱)은 이렇게 해야 한다.
		// 방법2. Integer 래퍼 클래스의 static 메소드 valueOf() 사용
		// num1 = Integer.valueOf(n1); <- 수동 박싱
		
		// 아래 한 줄을 쓰면 자동(오토) 박싱이 일어나 10을 Integer 객체의 인스턴스 변수에 저장하게 된다.
		num1 = n1;
		//	 = 10;
		//	 = Integer.valueOf(n1); <- 컴파일러가 실제로는 이렇게 자동으로 작성해 준다.
		
		System.out.println("자동(오토) 박싱");
		System.out.println("기본 자료형 변수 n1 의 값: " + n1); // 10
		// toString(): Integer 객체 안에 저장된 10을 문자열 "10" 으로 만들어 반환한다.
		System.out.println("참조 자료형 변수 num1 의 Integer 래퍼 객체 메모리 내부에 자동으로 박싱된 10: " + num1.toString());
		
		// 자동(오토) 박싱
		// 기본 자료형 10을 자동(오토) 박싱해서 저장
		Integer num3 = 10; // Integer.valueOf(10);
						   // 위와 같이 수동으로 박싱한 것과 같은 의미이다.
		// 자동(오토) 언박싱
		// Integer 객체 메모리 내부에 저장된 기본 자료형 10을 자동(오토) 언박싱으로 꺼내서 얻자
		int value = num3; // num3.intValue();
						  // 위와 같이 수동으로 언박싱한 코드와 같은 의미이다.
		
		System.out.println("value: " + value);
		
		// ---------------- 자동(오토) 박싱, 자동(오토) 언박싱 연습 ----------------
		
		// 정수 10을 Integer 객체 메모리의 인스턴스 변수에 저장하기 위해 자동(오토) 박싱하기
		// 참조변수 it 선언해서 저장
		Integer it = 10; // <--- 수동 박싱하려면? Integer.valueOf(10); 을 작성해야 했을 것이다.
		
		// 자동(오토) 박싱된 10을 자동(오토) 언박싱을 통해 얻어 출력!
		System.out.println(it); // 10
		// 위 줄을 수동 언박싱으로 작성하면 아래와 같다.
		// System.out.println(it.intValue());
		
		// double 자료형의 실수 3.14를 Double 래퍼 클래스의 객체 메모리에 저장하기 위해 자동(오토) 박싱하기
		// 참조변수 du 선언해서 저장
		Double du = 3.14; // <--- 수동 박싱하려면? Double.valueOf(3.14); 을 작성해야 했을 것이다.
		
		// 자동(오토) 박싱하여 Double 객체 메모리에 저장된 3.14를 자동(오토) 언박싱해서 얻자
		// double b; 변수 선언 후 저장
		double b = du; // <--- 수동 언박싱하려면? du.doubleValue(); 을 작성해야 했을 것이다.
		
		System.out.println(b); // 자동 언박싱 후 출력: 3.14
		
		System.out.println("----------------------------------------------------------------");
		
		// 주제: 자동(오토) 박싱과 자동(오토) 언박싱을 통해서 산술 연산(+, -, *, /, 등) 해보기
		
		// 10 자동(오토) 박싱
		Integer c1 = 10; // new Integer(10) 객체 메모리 주소를 참조변수 c1 에 저장
		
		// 20 자동(오토) 박싱
		Integer c2 = 20; // new Integer(20) 객체 메모리 주소를 참조변수 c2 에 저장
		
		c2 += 3;
		// c2 = c2 + 3; <--- += 를 풀어 쓴 형태
		// c2 = Integer.valueOf(c2.intValue() + 3); <--- 컴파일러가 실제로 작성해주는 코드 형태
		
		System.out.println(c2.intValue()); // 수동 언박싱해서 얻은 23 출력
		
		c1++;
		// c1 = c1 + 1; <--- ++ 를 풀어 쓴 형태
		
		// 순서1. c1.intValue(); 자동 언박싱으로 10을 얻는다.
		// 순서2. 10 + 1 을 계산해서 11로 만들어준다.
		// 순서3. c1 = 11; 대입해서 저장하기 위해 Integer.valueOf(11); 자동 박싱을 통해 c1 참조변수에 대입해서 저장
		// 순서4. c1 = new Integer(11); <--- 결과
		
		// 현재 c1 참조변수가 사용하고 있는 new Integer(11) 객체의 11과
		// 현재 c2 참조변수가 사용하고 있는 new Integer(23) 객체의 23을 + 연산해보자.
		int addResult = c1 + c2; // c1, c2 각각 Integer 객체 내부에 저장된 정수 값이
								 // 자동(오토) 언박싱된 후에 + 연산을 하게 된다.

		// int addResult = c1.intValue() + c2.intValue();
		//				 =		 11		 +		 23
		//				 =				34;
		System.out.println("addResult 변수 값: " + addResult); // 34
		
		// 현재 c1 참조변수가 사용하고 있는 new Integer(11) 객체의 11과
		// 현재 c2 참조변수가 사용하고 있는 new Integer(23) 객체의 23을 - 연산해보자.
		
		int minResult = c1 - c2; // c1, c2 각각 Integer 객체 내부에 저장된 정수 값이
								 // 자동(오토) 언박싱된 후에 - 연산을 하게 된다.
								 // 11, 23을 각각 얻은 후 11 - 23 을 하게 되어 결가는 -12가 된다.
		System.out.println("minResult 변수 값: " + minResult); // -12
		
	}// === main 메소드

}// --- Ex5 클래스


