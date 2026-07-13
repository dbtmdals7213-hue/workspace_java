
/*
	문제 7. 특정 글자 개수 세기
		 - 메서드 이름: countChar
		 - 매개변수: String text, char target
		 - 반환 타입: int
		 - 설명: 문자열(text) 안에 특정 문자(target)가 몇 번 들어있는지 개수를 세어서 반환하는 메서드를 작성하세요.
*/

public class test_7 {

	public static int countChar(String text, char target) {
		
		int count = 0;
		
		for(int i = 1; i < text.length(); i++) {
			
			if(text.charAt(i) == '9') {
				
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		System.out.println("text 문자열에 '9' 가 " + countChar("123456789", '9') + "번 들어있습니다.");
	}

}
