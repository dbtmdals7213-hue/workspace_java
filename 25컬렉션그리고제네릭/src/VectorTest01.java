import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		
		/*
			1. 4개의 객체(요소)를 저장할 수 있는 가변으로 칸이 생성되어 저장되는 Vector 클래스의 객체 생성
			2. 그리고 Vector 가변 배열 메모리의 각 칸에 객체들이 모두 저장된 상태에서
			   add 메소드를 한 번 호출해서 새로운 객체를 추가하면 3칸씩 가변으로 생성되게 하는 Vector 클래스의 객체 생성
		*/
		Vector vector = new Vector(4, 3);
		
		/*
			Vector 가변 배열 메모리 전체의 칸 개수(용량) 얻기
			-> int capacity() 메소드 사용
			★ capacity() 는 Vector 에만 있는 메소드다.(ArrayList 에는 칸 수를 알려주는 메소드가 없다.)
		*/
		System.out.println("Vector 배열 칸 개수(용량): " + vector.capacity() + "칸");
		//				   "Vector 배열 칸 개수(용량): 4칸"
		
		/*
			Vector 가변 배열 메모리 전체 칸에 저장된 객체의 개수 얻기
			-> int size() 메소드 사용
			★ 아직 add 를 한 번도 안 했으므로 칸은 4칸이지만 저장 개수는 0개다.
			(칸 수와 저장 개수는 다른 것이다!)
		*/
		System.out.println("Vector 배열 각 칸에 저장된 객체 수: " + vector.size() + "개");
		//				   "Vector 배열 각 칸에 저장된 객체 수: 0개"
		
		// 일반 for 반복문을 이용하여 Vector 배열 메모리의 각 칸에 객체를 반복해서 저장
		for(int i = 0; i < 5; i++) {
			
			vector.add(i * 10);
		}// for 반복문
		
		/*
			Vector 가변 배열 메모리 전체의 칸 개수(용량) 얻기
			-> 확장이 일어났으므로 4칸이 아니라 7칸이 된다.(4 + 3 = 7)
		*/
		System.out.println("Vector 배열 칸 개수(용량): " + vector.capacity() + "칸");
		//				   "Vector 배열 칸 개수(용량): 7칸"
		
		/*
			Vector 가변 배열 메모리 전체의 칸에 저장된 객체의 개수 얻기
			-> 위 for 반복문을 이용해 add 메소드로 추가를 5번 했으므로 5개가 반환된다.(빈 칸 2개는 세지 않는다.)
		*/
		System.out.println("Vector 배열 각 칸에 저장된 객체 수: " + vector.size() + "개");
		//				   "Vector 배열 각 칸에 저장된 객체 수: 5개"
		
		for(int i = 0; i < vector.size(); i++) {
			// i < 5; -> i 가 5가 되는 순간 for 반복문 종료
			
			System.out.print("  " + vector.get(i));
		}
		
		System.out.println(); // 한 줄 줄바꿈 출력
		
		System.out.println(vector.lastElement()); // 40
		// 4번 칸의 Integer.valueOf(40) 객체가 반환됨
		
		System.out.println(vector.firstElement()); // 0
		// 0번 칸의 Integer.valueOf(0) 객체가 반환됨
		
	}// === main 메소드

}// --- VectorTest01 클래스
