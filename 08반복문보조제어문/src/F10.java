
// [예제] break 문의 사용 예 2 - 파일이름 : F10.java
/*

	다중 반복문에서 break 문이 사용되었을 경우에는 가장 근접한 반복문에서만 벗어 납니다.

	바깥쪽 반복문{
		안쪽 반복문{
			break;
			 |	
		};	 |
			 |
	      <-- 벗어남
	};

	만일 바깥쪽 반복문 밖으로 벗어나려면 어떻게 해야 할까요?
	레이블을 사용해야 합니다. break 다음에 레이블명을 기술하면 완전히 반복문에서 벗어날 수 있습니다.
*/

public class F10 {

	public static void main(String[] args) {
		
		int i;
		int a;
		
		for(a = 1; a < 10; a++) {
			
			for(i = 1; i <= 10; i++) {
				
				if(i % 3 == 0) {
					break; // <--- 다중 for 에서 안쪽 for 내부에 break 가 실행되면 안쪽 for 만 종료
				}
				
				System.out.print("   i -> " + i);
				
			}// 안쪽 for
			
			System.out.println("\n a -> " + a);
			
		}// 바깥 for
		
		System.out.println("----------------------------------------------\n");
		
		// 레이블명을 exit_for 로 지정해놓고
		exit_for:
		
		for(a = 1; a < 10; a++) {
			
			for (i = 1; i <= 10; i++) {
				
				if(i % 3 == 0) {
					break exit_for; // 안쪽 for 문 내에서 특정 조건에 만족할 경우 바깥 for 문 밖으로 벗어나기 위해
									// break 레이블명; 구문을 사용함.
				}
				System.out.print("   i -> " + i);
				
			}// 안쪽 for
			
			System.out.println("\n a -> " + a);
			
		}// 바깥 for
		
		System.out.println("\n--------------------바깥 for 그 다음 코드 실행");
		
	}

}
