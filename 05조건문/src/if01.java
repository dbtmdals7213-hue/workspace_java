
/*
	주제: 절대 값 구하기
	
		절대 값? 음수이면 부호를 변경한다.
*/

public class if01 {

	public static void main(String[] args) {
		
		int num;
		
		num = -5;
		
		// 조건문: 변수 num 에 저장된 값이 0보다 작은 음수냐? 라고
		//		 컴퓨터에게 묻는 조건문으로 작성
		if(num < 0) {
			
			// num = -(-5); 이므로 부호가 변경된 5를 num 변수에 저장함.
			num = -num;
		}
		
		// -5의 절대 값 5가 출력됩니다.
		System.out.println("absolute num = " + num); // 5
		
		// 변수 num 에 양의 정수 5 저장
		num = 5;
		
		// 변수 num 에 저장된 값이 0보다 작은 음수냐? 라고 컴퓨터에게 묻는 조건문
		// 결론: 0보다 큰 양수이기 때문에 조건문의 조건식의 결과가 false 이므로 아래 if 문은 실행되지 않음.
		if(num < 0) {
			num = -num;
		}
		
		// 변수 num 에 저장된 원래의 값 5가 출력된다.
		System.out.println("num = " + num); // 5

	}

}
