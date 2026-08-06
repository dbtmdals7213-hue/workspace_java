
import java.util.Vector; // <- 가변으로 칸이 늘어나는 배열을 생성할 때 사용되는 클래스
						 // <- ArrayList 와 친구
						 // <- List 인터페이스가 부모 인터페이스입니다.

import java.util.Enumeration; // <- Iterator 인터페이스와 친구

public class EnumerationTest01 {

	public static void main(String[] args) {
		
		Vector vector = new Vector();
		
		// Integer 래퍼 객체 5개를 반복해서 만들어서 Vector 배열 메모리의 각 칸에 차례대로 저장!
		// 추가할 객체 데이터 -> 0, 10, 20, 30, 40
		for(int i = 0; i < 5; i++) {
			
			vector.add(i * 10);
		}// for 반복문
		
		// 위 Vector 배열 메모리 전체의 각 칸에 저장된 Integer 래퍼 객체들을 for 일반 반복문을 이용해 얻어 출력
		for(int i = 0; i < vector.size(); i++) {
			
			System.out.println(vector.get(i));
		}
		
		Enumeration enu = vector.elements();
		
		while(enu.hasMoreElements()) {
			
			System.out.println(enu.nextElement());
		}
		
	}// === main 메소드

}// --- EnumerationTest01 클래스


