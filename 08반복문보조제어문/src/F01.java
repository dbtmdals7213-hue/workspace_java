
// [예제] break 보조제어문 사용 예 1

public class F01 {

	public static void main(String[] args) {
		
		int n; // int n 변수만 선언해놓으면 기본으로 저장되는 값은 0입니다.
		
		for(n = 1; n <= 10; n++) {
			System.out.print("	" + n); // <-- 10번 반복해서 n 의 값 1씩 증가하면서 출력
		}
		
		System.out.println();
		
		// n 변수값이 3이 되면 더 이상 출력하지 않고 반복을 종료해라!
		// 출력: 1	2
		for(n = 1; n <= 10; n++) {
			
			if(n % 3 == 0) {
				break;
			}
			System.out.print("	" + n); // 1	2
		}

	}

}
