
/*
	문제 8. 배열의 평균값 구하기
		 - 메서드 이름: calculateAverage
		 - 매개변수: int[] arr
		 - 반환 타입: double
		 - 설명: 정수형 배열을 입력받아 모든 요소의 평균을 실수형(double)으로 반환하는 메서드를 작성하세요.
*/

public class test_8 {

	public static double calculateAverage(int[] arr) {
		
		int sum = 0;
		double avg = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			sum += arr[i];
		}
		avg = sum / arr.length;
		
		return avg;
	}
	
	public static void main(String[] args) {
		int []arr = {11, 22, 33, 44, 55};
		
		System.out.println("11, 22, 33, 44, 55 의 평균: " + calculateAverage(arr));
	}

}
