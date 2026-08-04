package 수학연산관련클래스들;

public class MathTest {

	public static void main(String[] args) {
		
		int v1 = Math.abs(-5); // -5의 절대값 5를 구해 반환
		System.out.println("-5의 절대값 v1 변수 값: " + v1); // -5의 절대값 v1 변수 값: 5
		
		double v2 = Math.abs(-3.14); // -3.14의 절대값 3.14를 구해 반환
		System.out.println("-3.14의 절대값 v2 변수 값: " + v2); // -3.14의 절대값 v2 변수 값: 3.14
		
		int v7 = Math.max(5, 9); // 5와 9중에 큰 값 하나 9를 반환
		System.out.println("5와 9중 최대값은? v7: " + v7); // 5와 9중 최대값은? v7: 9
		
		double v8 = Math.max(5.3, 2.5); // 5.3과 2.5중에 큰 값 하나 5.3을 반환
		System.out.println("5.3과 2.5중 최대값은? v8: " + v8); // 5.3과 2.5중 최대값은? v8: 5.3
		
		int v9 = Math.min(5, 9); // 5와 9 중에 최소값 5하나를 반환
		System.out.println("5와 9중 최소값은? v9: " + v9); // 5와 9중 최소값은? v9: 5
		
		double v10 = Math.min(5.3, 2.5); // 5.3과 2.5중에 최소값 하나 2.5를 반환
		System.out.println("5.3과 2.5중 최소값은? v10: " + v10); // 5.3과 2.5중 최소값은? v10: 2.5
		
		// Math 클래스의 floor 메소드 호출 시 매개변수로 5.3을 전달하면
		// 5.3에서 소수점 첫 번째 자리 3을 내림 처리한 5.0을 만들어 반환해줍니다.
		double v11 = Math.floor(5.3); // 5.3 -> 5.0
		System.out.println("v11: " + v11); // 5.0
		
		// Math 클래스의 floor 메소드 호출 시 매개변수로 5.923을 전달하면
		// 5.923에서 소수점 첫 번째자리 9이하를 버린 5.0을 만들어 반환해줍니다.
		v11 = Math.floor(5.923); // 5.923 -> 5.0
		System.out.println("v11: " + v11); // 5.0
		
		// Math 클래스의 floor 메소드 호출 시 매개변수로 음수 값 -5.3을 전달하면
		// -5.3에서 소수점 첫 번째 자리의 값 3을 올림 처리해서 -6.0을 만들어서 반환해줍니다.
		double v12 = Math.floor(-5.3); // -5.3 -> -6.0
		System.out.println("v12: " + v12); // -6.0 
		
		// Math 클래스에 만들어 놓은 ceil 메소드 호출 시 매개변수로 5.3을 전달하면?
		// 5.3의 소수점 첫 번째 자리 3에서 무조건 올림 처리한 6.0을 만들어서 반환합니다.
		double v3 = Math.ceil(5.3); // 5.3 -> 6.0
		System.out.println("v3: " + v3); // 6.0
		
		// Math 클래스에 만들어 놓은 ceil 메소드 호출 시 매개변수로 5.923을 전달하면?
		// 5.923의 소수점 첫 번째 자리 9에서 무조건 올림 처리한 6.0을 만들어서 반환합니다.
		double v4 = Math.ceil(5.923); // 5.923 -> 6.0
		System.out.println("v4: " + v4); // 6.0
		
		// 음수 -5.3을 매개변수로 전달하면 소수점 첫 번째 자리 3을 없앤 -5.0으로 만들어 반환합니다.
		v4 = Math.ceil(-5.3); // -5.3 -> -5.0
		System.out.println("v4: " + v4); // -5.0
		
		// 음수 -3.7을 매개변수로 전달하면 소수점 첫 번째 자리 7을 없앤 -3.0으로 만들어 반환합니다.
		v4 = Math.ceil(-3.7); // -3.7 -> -3.0
		System.out.println("v4: "+ v4); // -3.0
		
		// 1 ~ 12 랜덤 값을 정수로 10개 만들어서 반복해서 출력
		for(int i = 0; i < 10; i++) {// i 가 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 가 될 때까지 1씩 증가하면서 10번 반복
			
			System.out.println((int)(Math.random() * 12) + 1);
		}
		
		// 5의 2승 -> 25.0을 구하고 싶다.
		System.out.println(Math.pow(5, 2)); // 25.0
		
		// PI(원주율)
		System.out.println(Math.PI); // 3.141592653589793
		
	}// === main 메소드

}// --- MathTest 클래스


