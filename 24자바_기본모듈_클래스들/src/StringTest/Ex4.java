package StringTest;

public class Ex4 {

	public static void main(String[] args) {
		
		// 검사할 원본 전체 문자열
		String originalString = "Hello, World!";
		//						 0123456789...	<- 인덱스 0 ~ 12
		
		// 제거할 대상 문자열
		String deleteString = "l";
		
		// 제거한 결과 문자열을 누적할 변수
		String modifiedString = "";
		
		for(int i = 0; i < originalString.length(); i++) {
			
			// 인덱스 i 위치의 글자 하나를 잘라낸다.
			String oneChar = originalString.substring(i, i + 1);
			
			// 그 글자가 제거 대상 l 문자열과 다르면 modifiedString 변수에 이어 붙여서 저장
			if(!oneChar.equals(deleteString)) {
				
				modifiedString += oneChar;
			}
		}
		
		System.out.println("원본 문자열: " + originalString);
		System.out.println("modifiedString 변수: " + modifiedString); // "Heo, Word!"
		
		System.out.println("------------------------------------------");
		
		// charAt() 메소드 사용 방식. 결관는 위와 같다.
		String result2 = "";
		
		for(int i = 0; i < originalString.length(); i++) {
			
			char oneChar = originalString.charAt(i);
			
			if(oneChar !='l') {
				
				result2 += oneChar;
			}
		}
		
		System.out.println("charAt(indx) 메소드 방식: " + result2); // "Heo, Word!"
		
	}// === main 메소드

}// --- Ex4 클래스


