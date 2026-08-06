
import java.util.ArrayList; // <- ArrayList 클래스
import java.util.List; // <- ArrayList 클래스의 부모 인터페이스 List
import java.util.Iterator; // <- 가변 배열에 저장된 객체(요소)들을 쉽게 얻게 도와주는 메소드들을 제공하는 인터페이스

public class Collections03 {

	public static void main(String[] args) {
		
		// ArrayList 클래스를 이용해 가변으로 칸이 늘어나는 배열 메모리 생성(업 캐스팅해서 만들기)
		List list = new ArrayList(6); // <- 처음부터 배열 칸 수는 6칸으로 지정
		
		// 0번 index 위치 칸에 "하나" 문자열 객체 주소 저장, size 변수가 0 -> 1로 증가
		list.add("하나");
		list.add(2); // 오토박싱: Integer.valueOf(2); Integer 래퍼 객체로 저장됨
		list.add(3.42); // 오토박싱: Double.valueOf(3.42); Double 래퍼 객체로 저장됨
		list.add("넷");
		list.add("다섯");
		list.add(6); // 오토박싱: Integer.valueOf(6); Integer 래퍼 객체로 저장됨
		
		//================================================
		// 방법1. 기존 방식: for 문 + get(index) 로 반복해서 꺼내오기
		//================================================
		System.out.println("===== 방법1. for 문 + get(index) =====");
		
		// i 를 0부터 size - 1 까지 1씩 증가시키면서 get(i) 로 각 칸의 객체를 꺼낸다.
		for(int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i));
		}
		// 이 방식의 단점: index 가 없는 컬렉션(HashSet 등)에는 get(index) 가 없어서 쓸 수 없다.
		// -> 어떤 컬렉션이든 똑같은 방법으로 꺼내기 위해 Iterator 가 제공된다.
		
		//=======================================================
		// 방법2. Iterator(이터레이터 반복자) 로 반복해서 배열의 객체 값 꺼내오기
		//=======================================================
		System.out.println("====== 방법2. Iterator 인터페이스 ======");
		
		Iterator iterator = list.iterator();
		
		// hasNext() 가 true 를 반환하는 동안(= 아직 안 꺼낸 객체가 남아있는 동안) 반복한다.
		while(iterator.hasNext()) {
			
			System.out.println(iterator.next()); // cursor 위치의 객체 반환 후 cursor 1 증가
		}
		
		//========================
		// Iterator 사용 시 주의 2가지
		//========================
		
		// 주의1.	 Iterator 는 1회용이다.
		//		 위 while 문이 끝난 시점에 cursor 는 이미 끝(6)에 가있으므로
		//		 같은 iterator 로 다시 반복하면 hasNext() 가 false 라 한 번도 실행되지 않는다.
		System.out.println("다 쓴 iterator hasNext() -> " + iterator.hasNext());
		//		 처음부터 다시 ArrayList 배열에서 꺼내고 싶으면? list.iterator() 를 다시 호출해
		//		 cursor = 0 인 새 ArrayList$Itr 객체를 새로 만들어야 한다.
		
		Iterator iterator2 = list.iterator();
		System.out.println("새로 만든 iterator2 참조변수의 ArrayList$Itr 객체의 hasNext() -> " + iterator2.hasNext());
		
		// 주의2.	 hasNext() 확인 없이 next() 만 계속 호출하면?
		//		 ArrayList 원본 배열에 꺼낼 객체가 없는 순간 NoSuchElementException 예외가 발생하여 자바 프로그램이 강제 종료된다.
		//		 그래서 while(itr.hasNext()) { itr.next() }; 형태를 공식처럼 사용한다.
		
		//=================================================
		// 방법3. 향상된 for 문(Iterator 를 자동으로 써주는 촉약 문법)
		//=================================================
		System.out.println("========= 방법3. 향상된 for 문 =========");
		// 작성법: for(꺼낸객체를담을변수선언 : 반복할대상배열) { 반복할코드; }
		// 읽는법: ArrayList 배열에서 객체를 하나씩 꺼내서 Object obj 변수에 담아가며 반복할 코드를 실행해라!
		for(Object obj : list) {
			
			System.out.println(obj);
		}
		
	}// === main 메소드

}// --- Collections03 클래스


