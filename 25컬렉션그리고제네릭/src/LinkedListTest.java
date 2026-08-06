
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
		
		// ArrayList 전체 배열 메모리의 각 칸에 추가로 저장된 Integer 래퍼 객체들을 반환(얻어) 받아 출력
		System.out.println("ArrayList: ");
		
		// 향상된 for 반복문을 이용하여 ArrayList 배열에 저장된 Integer 객체들을 반복해서 얻어 출력
		for(int i : arrayList) {
			// ★ 꺼내지는 것은 Integer 객체인데 담는 변수는 기본 자료형 int 다?
			// -> 오토 언박싱:	컴파일러가 Integer객체.intValue() 를 자동으로 호출해
			//				Integer 객체 속의 int 값을 꺼내 i 변수에 담아 준다.(박싱의 반대)
			System.out.println(i);
		}
		
		arrayList.remove(1);
		
		System.out.println("--------------------------------");
		//===================================================
		//3. LinkedList 의 삭제 동작: 이동 없이 "링크 수정" 만 일어난다.
		//===================================================
		
		// List 부모 인터페이스를 구현 받은 자식 LinkedList 클래스의 배열 메모리 구조 생성해서 살펴보자.
		List<Integer> linkedList = new LinkedList<Integer>();
		
		linkedList.add(40); // Integer.valueOf(40); 래퍼 객체를 담은 노드가 만들어져 연결됨
		linkedList.add(50);
		linkedList.add(60);
		
		// LinkedList 의 1번째 노드(데이터 50) 하나 삭제
		linkedList.remove(1);
		
		System.out.println("LinkedList: ");
		
		for(int i : linkedList) {
			
			System.out.println(i);
		}
		
	}// === main 메소드

}// --- LinkedListTest 클래스


