
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
												//	  0	   1	2	 3	<- index
		
		//(1) intindexOf(Object o): 전달 인자로 준 객체를 앞(0번 index)에서부터 찾아 해당 위치(index)를 반환함
		//							찾지 못하면 -1을 반환함.
		System.out.println("indexOf(\"포도\") -> " + list4.indexOf("포도")); // 1(앞에서부터 찾으므로 3번이 아닌 1번)
		
		//(2) int lastIndexOf(Object o): 저장된 객체를 배열의 마지막 index 위치부터 거꾸로 찾음
		//								 찾으면 해당 위치(index)를 반환하고 찾지 못하면 -1을 반환함
		System.out.println("lastIndexOf(\"포도\") -> " + list4.lastIndexOf("포도")); // 3(뒤에서부터 찾으므로 3번)
		
		//(3) int indexOf(Object o) 를 사용하여 ArrayList 배열에 저장되어 있지 않는 객체 찾기
		System.out.println("indexOf(\"멜론\") -> " + list4.indexOf("멜론")); // 배열에서 찾지 못하면 -1 반환
		
		//(4) E get (int index): 매개변수 index 로 전달한 index 위치에 저장된 객체를 반환
		System.out.println("get(2) -> " + list4.get(2)); // "수박"
		
		//(5) E set(int index, E element): 매개변수 index 로 전달한 index 위치에 저장된 객체를
		//								   매개변수 E element 로 전달한 객체로 대체(교체) 하는 메소드
		//								   대체되기 전의 기존 객체를 반환함
		Object old = list4.set(0, "딸기");	// 0번 index 위치 칸에 저장되어 있는 "사과" 를 "딸기" 로 교체
											// 교체 되기 전 "사과" 객체를 반환합니다.
		System.out.println("set(0, \"딸기\") 의 반환 값(교체 전 객체) -> " + old); // "사과"
		System.out.println("set 메소드 실행 후 배열 모습: " + list4);	// "[딸기, 포도, 수박, 포도]"
																//	  0	   1	2	 3	 <- index
		
		//(6) void add(int index, E element): 매개변수 index 로 전달한 index 위치에
		//									  매개변수 E element 로 전달한 객체를 저장합니다.
		//									  매개변수 index 로 전달한 index 위치에 저장된 기존의 객체는
		//									  뒤로 밀려나 그 다음 index 위치에 저장되게 됩니다.
		list4.add(1, "귤");
		System.out.println("add(1, \"귤\") 실행 후 배열 모습: " + list4); // "[딸기, 귤, 포도, 수박, 포도]"
		
		// "포도"(1번) 부터 뒤에 있던 객체들이 전부 한 칸씩 밀렸다.
		// "[딸기, 귤, 포도, 수박, 포도]"
		//	  0	  1	  2   3   4		<- index
		
		//(7) E remove(int index): 매개변수 index 로 전달한 index 위치에 저장된 객체를 삭제하고
		//						   삭제된 그 객체를 반환함. 뒤에 있던 객체들은 앞으로 한 칸씩 당겨진다.
		//						   (존재하지 않는 index 를 주면 IndexOutOfBoundsException 발생)
		Object removed = list4.remove(3); // 3번 index 위치 칸에 저장된 "수박" 삭제
						 				  // 삭제 시도한 "수박" 객체를 반환
		System.out.println("remove(3) 의 반환 값(삭제된 객체) -> " + removed); // "수박"
		System.out.println("remove(3) 실행 후 배열 모습 -> " + list4); // "[딸기, 귤, 포도, 포도]"
		
		// 참고.	4번 index 위치 칸에 저장되어 있었던 포도가 앞 칸으로 당겨져서 3번 index 위치 칸에 자동 저장된다. 그 후 4번 index 위치 칸 없어짐.
		// "[딸기, 귤, 포도, 포도]"
		//	  0	  1	  2   3   <- index
		
		//(8) boolean remove(Object o): 배열에서 객체를 찾아 첫 번째 것만 삭제. 성공 true / 실패 false 반환
		boolean ok1 = list4.remove("포도"); // 앞 쪽(2번 index 위치 칸)에 저장된 "포도" 하나만 삭제
		System.out.println("remove(\"포도\") 의 반환 값 -> " + ok1); // true
		System.out.println("현재 ArrayList 배열 모습: " + list4); // "[딸기, 귤, 포도]"
		
		// "[딸기, 귤, 포도]"
		//	  0   1   2		<- index
		
		boolean ok2 = list4.remove("멜론"); // "멜론" 은 배열에 없으므로 삭제 실패 값 false 를 반환
		System.out.println("remove(\"멜론\") 의 반환 값 -> " + ok2); // false <- 삭제 실패
		System.out.println("현재 ArrayList 배열 모습: " + list4); // "[딸기, 귤, 포도]"
		
	}// === main 메소드

}// --- Collections02 클래스


