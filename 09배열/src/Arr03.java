
public class Arr03 {

	public static void main(String[] args) {
		/*
			예제. 2차원 배열 전체 메모리를 선언한 후
				 배열의 칸에 값을 대입하고,
				 값을 얻어 출력하는 자바 프로그램 작성
		*/
		
		// 2차원 표 형태의 배열 메모리 생성 문법
		
			// 자료형[][] 변수명 = new 자료형[행 개수][열 개수];
		
		
		//1. 정수 값을 저장시킬 5행 3열 15칸의 2차원 배열 메모리 생성
		int [][] score = new int [5][3];
		
		// 2차원 배열의 행에 대한 열의 위치 칸에 값 저장 문법(배열 초기화 문법)
		
			// 배열명[행 위치][행 위치에 대한_열 위치] = 값;
		
		score[0][0] = 10;	score[0][1] = 90;	score[0][2] = 70;
		score[1][0] = 60;	score[1][1] = 80;	score[1][2] = 65;
		score[2][0] = 55;	score[2][1] = 60;	score[2][2] = 85;
		score[3][0] = 90;	score[3][1] = 75;	score[3][2] = 95;
		score[4][0] = 60;	score[4][1] = 30;	score[4][2] = 80;
		
		//2. for 반복문을 이용해 2차원 배열에 각 칸에 저장된 값을 반복해서 꺼내와 출력
		
		// 행의 개수만큼 반복
		for(int row = 0; row < 5; row++) {
			
			// 하나의 행에 대한 열의 개수만큼 반복
			for(int col = 0; col < 3; col++) {
				
				System.out.print("  " + score[row][col]);
				
			}// 안쪽 for
			
			System.out.println();
			
		}//바깥 for
		
		/*  
			10  90  70
			60  80  65
			55  60  85
			90  75  95
			60  30  80
		*/
		
	}

}
