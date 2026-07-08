
// 예제1. 1차원 배열 메모리를 생성하고 값 저장 후 저장된 값을 얻어 출력

public class G01 {

	public static void main(String[] args) {
		
		/*
			배열 메모리 생성 문법1.
			
				자료형 []변수명 = new 자료형[원소개수];
				
		*/
		//1. 5명의 점수를 정수로 저장하기 위한 배열 메모리 생성
		int []score = new int[5];
		
		//2. 생성한 score 배열 메모리의 각 칸(원소)에 접근해서 값을 저장하는 문법
		// 배열명[index] = 저장할_값;
		score[0] = 95;
		score[1] = 70;
		score[2] = 80;
		score[3] = 75;
		score[4] = 100;
		
		//3. 배열의 각 원소(각 칸)에 저장된 값을 꺼내오는 문법
		// 배열명[index]
		
		//--> score 배열 메모리의 0 index 위치 칸에 저장되어 있는 95를 꺼내와 출력
		System.out.println(score[0]); // 95
		
		//--> for 반복문을 이용하여 score 배열 메모리에 각 칸에 저장된 값들을 차례대로 얻어서 출력
		// score[0] = 95
		// score[1] = 70
		// score[2] = 80
		// score[3] = 75
		// score[4] = 100
		for(int i = 0; i <= 4; i++) {
			
			System.out.println("score[" + i + "] = " + score[i] );
			// i = 0 일때, score[0] 이므로 95 출력
			// i = 1 일때, score[1] 이므로 70 출력
			// i = 2 일때, score[2] 이므로 80 출력
			// i = 3 일때, score[3] 이므로 75 출력
			// i = 4 일때, score[4] 이므로 100 출력
		}
		
	}

}
