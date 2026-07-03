
/* 주제: 해당 문자가 영문자 모음인지를 확인하는 예제 */

public class switch04 {

	public static void main(String[] args) {
	
		char ch = 'i'; // 'i' -> 문자의 아스키코드 값은 105 입니다.
		
		switch (ch) { // <- ch 변수에 저장된 문자가?
			case 'a': // <- 'a' 문자와 같으냐? : 105 == 97
				System.out.println("해당 문자는 'A' 입니다.");
				break;

			case 'e': // <- 'e' 문자와 같으냐? : 105 == 101
				System.out.println("해당 문자는 'E' 입니다.");
				break;
				
			case 'i': // <- 'i' 문자와 같으냐? : 105 == 105
				System.out.println("해당 문자는 'I' 입니다.");
				break;
				
			case 'o': // <- 'o' 문자와 같으냐? : 105 == 111
				System.out.println("해당 문자는 'O' 입니다.");
				break;
				
			case 'u': // <- 'u' 문자와 같으냐? : 105 == 117
				System.out.println("해당 문자는 'U' 입니다.");
				break;
				
			default: // 위의 5가지 경우(a, e, i, o, u) 모두에 해당하지 않는다면 실행됩니다.
				System.out.println("해당 문자는 모음이 아닙니다.");
				break;
		}
		
	}

}
