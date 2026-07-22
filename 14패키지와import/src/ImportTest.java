
// 이미 자바 문법에서 만들어서 제공하는 Scanner 클래스 가져와 사용하기 위해 import 구문 작성

import java.util.Scanner; // <- Scanner 클래스 가져오기

public class ImportTest {

	public static void main(String[] args) {
		
		//1) java.lang 패키지 안에 포함된 클래스는 import 구문 없이 사용가능
		// 예: class String, class System, class Math ...
		
		String text = "hello";
		System.out.println(text);
		System.out.println(Math.max(3, 7));
		
		//2) java.util.Scanner 클래스 -> 위에서 import 했으므로 사용 가능
		
		
	}

}
