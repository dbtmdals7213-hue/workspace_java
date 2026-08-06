
import java.util.Queue; // Queue 인터페이스 불러오기(offer, poll, peek 추상 메소드 사용 목적)
import java.util.LinkedList; // Queue 와 List 두 인터페이스를 모두 구현한 자식 LinkedList 클래스 불러오기
import java.util.List; // 부모 List 인터페이스 불러오기(업 캐스팅용)
import java.util.ArrayList; // List 인터페이스를 구현한 자식 ArrayList 클래스 불러오기

public class LinkedListTest {

	public static void main(String[] args) {
		
		//===========================================
		//1. LinkedList 를 Queue(선입 선출 구조) 로 사용하기
		//===========================================
		
		// 업 캐스팅을 이용한 자식 구현 LinkedList 클래스의 객체 생성
		Queue myQue = new LinkedList();
		
		// boolean offer(E o): Queue 의 뒤쪽에 객체를 넣는다. 성공하면 true 반환
		myQue.offer("1-자바"); // 제일 먼저 들어감 -> 제일 먼저 나올 예정
		myQue.offer("2-C++");
		myQue.offer("3-API");
		myQue.offer("4-JSP");
		
		// peek() 메소드가 null 아닌 동안 = 앞 쪽에 꺼낼 객체가 남아 있는 동안만 반복
		while(myQue.peek() != null) {
			
			// poll(): 앞 쪽 객체를 꺼내서 반환하고, Queue 에서 제거한다.
			System.out.println(myQue.poll());
		}
		
		System.out.println("--------------------------------");
		
		//================================================
		//2. ArrayList 의 삭제 동작: 뒤 객체들의 "이동" 이 발생한다.
		//================================================
		
		// List 부모 인터페이스를 implements 구현한 LinkedList 자식 클래스와 ArrayList 자식 클래스의 배열 메모리 차이점을 알아보자
		
		// ArrayList 배열 메모리 생성 후 사용
		// <> 기호 내부에 Integer 클래스명을 작성해서 Integer 객체만 저장 가능한 ArrayList 배열 메모리를 생성하자.
		// 생성자에 2를 전달했으므로 처음 칸 수는 2칸이다.
		List<Integer> arrayList = new ArrayList<Integer>(2);
		// ArrayList 배열 메모리의 각 칸에 Integer 객체(요소) 추가
		arrayList.add(10); // arrayList.add(Integer.valueOf(10));
		arrayList.add(20); // arrayList.add(Integer.valueOf(20));
		arrayList.add(30); // 칸이 가득찬 상태에서 추가!
		
		
	}// === main 메소드

}// --- LinkedListTest 클래스


