
/* 주제: if, else 문을 이용하여 해당 문자가 영문 소문자인지 확인하는 예제 */

public class if02 {

	public static void main(String[] args) {
		/*
		ch 변수에 저장된 대문자 J -> 74
		
		소문자 a -> 97
		소문자 z -> 122
		*/
		char ch = 'J';
		
		//         false
		//   false   &&   true
		// 74 >=  97 && 74 <= 122
		if(ch >= 'a' && ch <= 'z') { // ch 변수에 저장된 값이 영문 소문자이냐?
			
			System.out.println("ch 변수에 저장된 문자는? 영문 소문자입니다."); // 출력 X
		}else {
			
			System.out.println("ch 변수에 저장된 문자는? 영문 대문자입니다."); // 출력 O
		}

	}

}
