
// [예제] 다중 for 문에서 제어변수의 변화 알아보기

public class E08 {

	public static void main(String[] args) {
		
		/*
		int i; // 안쪽 for 문 제어변수
		int a; // 바깥 for 문 제어변수
		
		System.out.println("시침 ----------------------->> 분침");
		System.out.println("a(바깥쪽 제어변수) -------> i(안쪽 제어변수)");
		
		for(a = 1; a < 5; a++) { // 4번 반복
			
			for(i = 1; i <= 5; i++) { // 바깥 for 가 1번 반복할 때 안쪽 for 는 5번 반복
				
				System.out.println(a + " -------------------->> " + i);
			}
		}
		*/
		
		int hour, minute, second;
		
		System.out.println("시침 ------------->> 분침 ------------->> 초침");
		System.out.println("hour(바깥쪽 제어변수) ->> minute(중간 제어변수) ->> second(안쪽 제어변수)");
		
		for(hour = 1; hour <= 1; hour++) {
			
			for(minute = 0; minute <= 59; minute++) {
				
				for(second = 0; second <= 59; second++) {
					
					System.out.println(hour + "시 " + minute + "분 " + second + "초");
					
				}// 가장 안쪽 for
				
			}// 안쪽 for
			
		}// 바깥 for

	}//main 메소드

}// class 클래스
