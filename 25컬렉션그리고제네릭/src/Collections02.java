
// 주제: List 인터페이스를 구현한 자식 ArrayList 클래스의 배열 메모리 만들기

import java.util.ArrayList;
import java.util.List;

public class Collections02 {

	public static void main(String[] args) {
		
		//============================
		//1. 기본 생성: new ArrayList();
		//============================
		
		ArrayList list = new ArrayList();
		
		list.add("apple"); // 비어있는 가장 앞 칸(0번 index)에 저장된다.
		list.add("banana"); // 그 다음 칸(1번 index)에 저장된다.
		list.add("cherry"); // 그 다음 칸(2번 index)에 저장된다.
		
		// ArrayList 가변 배열에 저장된 객체의 개수 얻기: size() 메소드 이용
		// 참고.	size() 는 "칸 수 10" 이 아니라 "실제 저장 객체 개수 3" 을 반환 한다는 점에 주의!
		System.out.println("위 ArrayList 가변 배열에 저장된 객체 개수: " + list.size());
		
		//====================================================
		//2. 칸 수를 지정한 생성: new ArrayList(2); + 자동 칸 확장 관찰
		//====================================================
		
		ArrayList list2 = new ArrayList(2); // 처음부터 칸 수를 2칸으로 지정해서 배열 생성
		
		list2.add("apple"); // 0번 index 칸에 저장. size = 1
		list2.add("banana"); // 1번 index 칸에 저장. size = 2
		list2.add("cherry"); // 칸이 가득찬 상태에서 add
							 // 2 X 1.5 = 3칸 짜리 새 배열을 만들어
							 // 기존 객체들을 복사해 옮긴 후 "cheery" 를 저장한다.
		
		System.out.println("ArrayList list2 가변 배열에 저장된 객체의 개수: " + list2.size()); // 3
		
		System.out.println("ArrayList list2 가변 배열의 모습을 문자열로 변환해서 반환 받아 출력");
		System.out.println(list2.toString());
		// 중요!	HashSet 배열과 비교: add 추가한 순서 그대로 "apple" -> "banana" -> "cherry" 출력된다.
		//		ArrayList 배열은 "추가한 순서대로 각 칸에 저장" 이 보장된다.
		
		//===========================================================================
		//3. 업 캐스팅 생성: List 부모 인터페이스의 참조변수에 자식 ArrayList 배열을 생성해서 저장 후 사용
		//===========================================================================
		
		// 업 캐스팅
		List list3 = new ArrayList(2); // 칸 2개 짜리 배열이 처음에 만들어지고,
									   // 칸이 가득 찬 상태에서 새로운 객체를 추가하면 1.5배로 칸이 늘어난다.
		
		list3.add(1); // 1 -> Integer.valueOf(1) 오토 박싱이 일어나 Integer 래퍼 객체로 추가됨
		list3.add("안녕"); // "안녕" 문자열 객체 메모리 추가
		list3.add(true); // true -> Boolean.valueOf(true) 오토 박싱이 일어나 Boolean 래퍼 객체로 추가됨
		
		System.out.print("위 List list3 참조변수에 저장된 new ArrayList(2); 가변 배열의 각 칸에 저장된 객체 개수: ");
		System.out.println(list3.size()); // 3
		
		//======================================
		//4. 메소드들을 실제로 하나씩 실행해서 눈으로 확인하기
		//======================================
		
		List list4 = new ArrayList();
		list4.add("사과");
		list4.add("포도");
		list4.add("수박");
		list4.add("포도"); // List 는 중복 저장 허용!("포도" 가 2개 저장된다. Set 이었다면 거부됐다)
		
		System.out.println("\n===== List 인터페이스 추상 메소드 실습 =====");
		System.out.println("현재 배열: " + list4); // "[사과, 포도, 수박, 포도]"
		
		
	}// === main 메소드

}// --- Collections02 클래스


