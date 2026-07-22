
/*
	메소드 오버로딩?
		- 같은 이름을 가진 메소드를 매개변수의 자료형 종류나 개수에 따라 여러 개 정의하는 것.
*/

public class ArrayUtils {

	// 메소드 오버로딩 하자
	
	//[1] 정수들이 저장된 배열을 하나 매개변수로 전달받아
	//	  배열에 저장된 값들의 합을 구해 반환하는 기능의 sum 메소드 정의
	public int sum(int[] array) {// 예: {1, 2, 3, 4, 5} 배열을 매개변수 array 로 전달받을 수 있음
		
		int total = 0; // 매개변수 array 로 전달받은 배열의 정수 값들의 합을 누적할 변수
		
		// 향상된 for 반복문 사용하여 매개변수 array 로 전달받은 배열의 각 값을 하나씩 얻어 total 에 누적
		for(int num : array) {
			
			total += num;
		}
		
		return total; // 최종 합 반환
	}
	
	//[1] 실수들이 저장된 배열을 하나 매개변수로 전달받아
	//	  배열에 저장된 값들의 합을 구해 반환하는 기능의 sum 메소드 정의
	public double sum(double[] array) {
		
		double total = 0;
		
		for(double num : array) {// 예: {1.5, 2.5, 3.5} 배열을 매개변수 array 로 받을 수 있음
			
			total += num;
		}
		
		return total; // array 매개변수로 전달받은 배열 안의 모든 실수들이 누적된 합을 반환
	}
	
	//[3] 정수들이 저장된 배열 하나를 매개변수로 전달받아 합계를 계산한 뒤 출력하는 기능의 printSum 메소드 정의
	public void printSum(int[] array) {
		
		System.out.println("array 매개변수로 받은 배열 안의 모든 정수들의 합: " + this.sum(array));
	}
	
	//[4] 실수들이 저장된 배열 하나를 매개변수로 전달받아 합계를 계산한 뒤 출력하는 기능의 printSum 메소드 정의
		public void printSum(double[] array) {
			
			System.out.println("array 매개변수로 받은 배열 안의 모든 실수들의 합: " + this.sum(array));
		}
	
	public static void main(String[] args) {
		
		//1. ArrayUtils 클래스 설계도로 객체 메모리 생성
		ArrayUtils arrayUtils = new ArrayUtils();
		
		//2. 정수들만 저장된 배열 하나 생성
		int[] intArray = {1, 2, 3, 4, 5};
		
		//3. 바로 위 intArray 배열에 저장된 정수들의 합을 구해 출력하고 싶다.
		arrayUtils.printSum(intArray);

		//4. 실수들만 저장된 배열 하나를 생성해서 배열에 저장된 실수들의 합을 구해 출력하고 싶다.
		double[] doubleArray = {1.5, 2.5, 3.5};
		
		arrayUtils.printSum(doubleArray);
	}// --- main 메소드

}// --- ArrayUtils 클래스
