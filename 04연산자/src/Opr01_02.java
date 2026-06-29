
public class Opr01_02 {

	public static void main(String[] args) {
		
		String a = "Apple";
		String b = "Banana";
		
		//1. 문자열 + 문자열
		//"Apple" + "Banana" ---> "AppleBanana"
		String c = a + b;
		System.out.println(c); 	// 출력: "AppleBanana"
		
		String str = "결과값: ";
		int n = 10;
		
		//2. 문자열 + 숫자
		//"결과값: "+ 10 ---> "결과값: 10"
	//순서1. "결과값: " + "10" 된 후
	//순서2. "결과값: 10"
		System.out.println(str + n);	// 출력: "결과값: 10"
		
		//3. println(문자열 + 숫자) 메소드 내부에 직접 식을 작성해서 하나의 문자열로 출력이 가능하다.
		System.out.println("결과값: " + 10);	// 출력: "결과값: 10"
		
	}

}
