package StringBuilderTest;

public class StringBuilderExample {

	public static void main(String[] args) {
		
		StringBuilder data = new StringBuilder("ABC");
		
		StringBuilder data2 = data.append("DEF");
		
		// 두 참조변수 data 와 data2 는  같은 객체를 사용하고 있는지 == 로 확인한다.
		System.out.println("data == data2: " + (data == data2)); // true
		
		String newData = data2.toString();
		System.out.println(newData.toString()); // "ABCDEF"
		
		System.out.println(data2.delete(3, 4).toString()); // "ABCEF"
		
		StringBuilder data3 = data2.insert(0, "G");
		
		System.out.println(data3.toString()); // "GABCEF"
		
		// 3개의 참조변수는 StringBuilder 객체 메모리 하나에 접근해서 사용하고 있다.
		System.out.println("data = " + data);
		System.out.println("data2 = " + data2);
		System.out.println("data3 = " + data3);
		
		// 3개의 참조변수에 같은 하나의 StringBuilder 객체 메모리 주소가 저장되어 있는지 확인
		System.out.println(data == data2 && data2 == data3); 
		//					   true				 true
		//								true
		
		System.out.println("---------------------");
		
		/*
			메소드 체이닝 기법? . 도트 연산자를 사용해서 메소드로부터 반환받은 객체의 메소드를 다시 호출하는 기법
		*/
		StringBuilder sb2 = new StringBuilder("안녕하세요").delete(0, 2).append(" 공부");
		
		System.out.println(sb2.toString()); // "하세요 공부"
		
	}// === main 메소드

}// --- StringBuilderExample 클래스


