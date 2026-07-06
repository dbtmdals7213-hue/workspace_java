
// [예제] 1부터 10사이의 정수 중 3의 배수만 제외하고 출력하기 - 파일이름 : F02.java
/*

	반복문{
	
		...
		
		continue;
	
		...
	}
	
	continue 역시 break 와 유사하게 반복문 안에서 사용되지만,
	break 문은 완전히 반복문을 벗어나는 반면에
	continue 문의 반복을 계속하기 위해서 증감식으로 제어가 옮겨집니다.
*/


public class F02 {

	public static void main(String[] args) {
		
		int n;
		
		for(n = 1; n <= 10; n++) {
			
			if(n % 3 == 0) { // n 변수값이 3의 배수이냐?
				continue; // 증감식 n++ 로 가서 연산해라!
			}
			
			// 출력: 	1	2	4	5	7	8	10
			System.out.print("	" + n);
			
		}// for
		
		System.out.println("\n==========================================");
		
		
		int i = 1; // 초기식
		
		while(i <= 10) {
			
			if(i % 3 == 0) {
				continue; // 조건식으로 가서 조건검사해!
			}
			
			System.out.print("i -> " + i + "    ");
			
			i++;
		}// while
		
	}

}
