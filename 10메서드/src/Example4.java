
// [예제] 다양한 형태의 메서드 만들어 보기

public class Example4 {
	
	/* 메서드 정의 */
	
	//1. 메서드명: printStudentInfo
	// 기능: 학생명 하나를 문자열로 매개변수로 전달받고, 학생 나이 하나를 매개변수로 전달받아
	//		"이름: 홍길동, 나이: 30" <- 출력 후 한 줄 줄바꿈 하는 기능
	public static void printStudentInfo(String name, int age) {
							// 이름: 홍길동, 나이: 30
		System.out.println("이름: " + name + ", 나이: " + age);
	}
	
	//2. 메서드명: add
	// 기능: 정수 2개를 매개변수로 각각 전달받아 합을 구해 반환하는 기능
	public static int add(int a, int b) {
		
		return a + b;
	}
	
	//3. 메서드명: add2
	// 기능: 실수 2개를 매개변수로 각각 전달받아 합을 구해 반환하는 기능
	public static double add2(double x, double y) {
		
		return x + y;
	}

	public static void main(String[] args) {
		//4. 위 각각의 메서드 호출 구문을 사용하여 아래와 같이 출력되게 하자
		/*
			이름: 홍길동, 나이: 30
			15
			16.0
		*/
		printStudentInfo("홍길동", 30);
		System.out.println(add(5, 10)); // 15
		System.out.println(add2(5.5, 10.5)); // 16.0
	}

}
