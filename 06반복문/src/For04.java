
// 주제: 구구단 2단 ~ 9단까지 출력하기

public class For04 {

	public static void main(String[] args) {
		
		for(int j = 2; j <= 9; j++) {
			System.out.print("◀-- " + j + "단 --▶ \t");
		}
		for(int i = 1; i <= 9; i++) {
			
			System.out.println();
			
			for(int j = 2; j <= 9; j++) {
				
				System.out.print(j + " * " + i + " = " + (j * i) + "\t");
				
			} // --- 안쪽 for
			
			System.out.print(""); // 한 줄(행) 출력이 끝나면 줄 바꿈
			
		} // --- 바깥 for
		

	}

}
