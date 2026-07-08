
/*
	예제. 5명의 학생 점수를 초기값으로 갖는 배열 메모리를 2번째 생성 방법으로 만든 후
		 점수의 총합을 구하는 평균을 구하는 예
*/

public class Arr01 {

	// main 메소드 기능: 자바 프로그램을 처음 실행하는 기능
	public static void main(String[] args) {
		
		/*
			1. 5명의 학생 점수들을 차례대로 95, 70, 80, 75, 100 점수들을 초기값을 갖는
			score 배열 메모리를 생성합니다.
		*/
		int[] score = {95, 70, 80, 75, 100};
		//				0	1	2	3	4	<-- index
		
		//2. 5명의 학생 점수 총합을 구해 저장할 변수 선언 후 0으로 초기화
		int total = 0;
		
		//3. for 반복문을 이용하여 score 배열에 각 점수를 차례대로 얻어 total 변수에 누적합니다.
		for(int i = 0; i < 5; i++) {
			
			total = total + score[i];
		/*
			i -> 0 일때
				0 =   0   + score[0];
				0 =   0   +   95;
			   95
			   
		    i -> 1 일때
		       95 =   95  + score[1];
		       95 =   95  +   70;
		      165
		    
		    i -> 2 일때
		      165 =  165  + score[2];
		      165 =  165  +   80;
		      245
		      
		    i -> 3 일때
		      245 =  245  + score[3];
		      245 =  245  +   75;
		      320
		      
		    i -> 4 일때
		      320 =  320  + score[4];
		      320 =  320  +  100;
		      420
		*/
			
		}// for
		
		/*
			4. 5명 학생 점수들의 평균을 구해 avg 변수 선언 후 저장
			   평균 = 총합 / 총 개수
		*/
		double avg = total / (double)5;
		//			  420  / (double)5;
		//			  420  /  5.0;

		/*
			5. 5명의 점수 총합과 평균 출력
			Total = 420
			AVG = 84.0
		*/
		System.out.println("Total = " + total);
		System.out.println("AVG = " + avg);
		
	}

}
