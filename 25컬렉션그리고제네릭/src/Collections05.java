import java.util.List;
import java.util.Vector;

public class Collections05 {

	public static void main(String[] args) {
		
		// 업 캐스팅 하여 Vector 배열 메모리 생성 후 저장
		List vector = new Vector();
		
		// Vector 배열의 각 칸에 문자열 객체 추가
		vector.add("Apple");
		vector.add("banana");
		vector.add("oRANGE");
		
		// 다운 캐스팅을 하여 얻은 자식 문자열 객체 메모리 주소를 저장할 String 클래스 자료형 참조변수 선언
		String temp;
		
		// Vector 배열 객체 메모리의 각 칸에 저장된 문자열 객체 개수만큼 차례로 얻어 사용
		for(int i = 0; i < vector.size(); i++) {
			
			//1단계.	Vector 배열에 저장된 문자열 객체를 반환받기 위해 Object get(int index) 메소드 호출!
			// 결과 -> get 메소드는 무조건! 부모 Object 클래스 자료형의 참조변수에 저장시킬 자식 문자열 객체의 주소 반환해줌
			Object obj = vector.get(i); // i = 0; : "Apple" 문자열 자식 객체 주소 저장
										// i = 1; : "banana" 문자열 자식 객체 주소 저장
										// i = 2; : "oRANGE" 문자열 자식 객체 주소 저장
			
			//2단계.	다운 캐스팅을 하여 String 클래스 내부에 만들어져 있는 toUpperCase(), 메소드를 사용할 수 있게 할
			//		(부모 Object 클래스 자료형의 참조변수 obj 로는 Object 클래스의 없는 toUpperCase() 메소드를 호출할 수 없기 때문)
			temp = (String)obj;
			
			//3단계.	다운 캐스팅 후에 String 클래스의 메소드를 자유롭게 호출해서 사용할 수 있다.
			System.out.println(temp.toUpperCase());
			
			// temp = vector.get(i); <- 컴파일 에러가 발생하는 코드!
		}
		
	}// === main 메소드

}// --- Collections05 클래스


