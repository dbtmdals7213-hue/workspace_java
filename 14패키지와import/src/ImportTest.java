
// 이미 자바 문법에서 만들어서 제공하는 Scanner 클래스 가져와 사용하기 위해 import 구문 작성

import java.util.Scanner; // <- Scanner 클래스 가져오기

// 아래 java.lang 패키지에 포함된 클래스를 불러오지 않아도 현재 파일에서 사용할 수 있다.
// import java.lang.String;
// import java.lang.System;
// import java.lang.Math;

public class ImportTest {

	public static void main(String[] args) {
		
		//1) java.lang 패키지 안에 포함된 클래스는 import 구문 없이 사용가능
		// 예: class String, class System, class Math ...
		
		String text = "hello";
		System.out.println(text);
		System.out.println(Math.max(3, 7));
		
		//2) java.util.Scanner 클래스 -> 위에서 import 했으므로 사용 가능
		Scanner sc = new Scanner(System.in); // 키보드로부터 입력한 데이터를 바이트 단위로 읽을 통로
		
		System.out.print("이름 입력: ");
		
		// 키보드로부터 입력받은 byte 배열의 데이터를 문자열로 변환해서 제공
		String name = sc.nextLine();
		
		System.out.print("입력한 이름: " + name);
		
		// Scanner 객체 메모리 제거
		sc.close();
	}

}



