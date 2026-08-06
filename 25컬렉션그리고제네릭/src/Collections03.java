
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
		
		
		
	}// === main 메소드

}// --- Collections03 클래스
