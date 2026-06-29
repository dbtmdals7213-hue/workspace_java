
public class Data07 {

	public static void main(String[] args) {
		// 2바이트 크기의 단일 문자를 저장할 수 있는 char형 변수 선언
		char x;
		
		// 변수 x 에 문자 'A' 를 저장!
		// (작은 따옴표 '' 사용에 주의하세요. 실제 메모리에는 65라는 10진수의 이진수가 저장됩니다.)
		x = 'A';
		
		// 출력 형식 지정자: %c(문자), %d(10진수 정수), \n(줄바꿈)
		System.out.printf("문자 %c의 유니코드 정수 번호는 -> %d 입니다.\n", x, (int)x);
		//     			   문자 A의 유니코드 정수 번호는 -> 65 입니다.
		
		x = '0';
		System.out.printf("문자 %c의 유니코드 정수 번호는 -> %d 입니다.\n", x, (int)x);
		//				   문자 0의 유니코드 정수 번호는 -> 48 입니다.
	}

}
