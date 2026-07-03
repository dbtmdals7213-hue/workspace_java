
/*
	주제: if, else if, else 문을 사용하여,
		 해당 문자가 영문 소문자이거나 영문 대문자인지 검사하고,
		 아닌지 확인하는 예제
*/

public class if03 {

	public static void main(String[] args) {
		
		char ch = 'J'; // 문자 J 는 아스키코드 값 74

		/*
			참고. 문자의 아스키코드 값
				소문자 a -> 97;
				소문자 z -> 122;
				대문자 A -> 65;
				대문자 Z -> 90;
		*/
		
		if(ch >= 'a' && ch <= 'z') { //1. ch 변수에 저장된 문자가 영문 소문자이냐?
		// 74 >=  97 && 74 <= 122
		//   false   &&   true
		//          false
			
			System.out.println("ch 변수의 문자는 영문 소문자입니다.");
			
		}else if(ch >= 'A' && ch <= 'Z') { //2. ch 변수에 저장된 문자가 영문 대문자이냐?
			
			System.out.println("ch 변수의 문자는 영문 대문자입니다.");
			
		}else {
			// 위 두 조건식의 결과가 모두 false 이면 실행될 코드 작성
			// 즉, 영문 소문자, 대문자가 아닌 경우 출력
			System.out.println("ch 변수의 문자는 영문자가 아닙니다.");
			
		}
		
	}

}
