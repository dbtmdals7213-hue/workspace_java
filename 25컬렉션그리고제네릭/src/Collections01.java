
import java.util.Set; // 부모 Set 인터페이스 사용을 위한 import
import java.util.HashSet; // Set 부모 인터페이스를 구현한 자식 HashSet 클래스 사용을 위한 import

public class Collections01 {

	public static void main(String[] args) {
		
		Set set = new HashSet();
		
		// HashSet 가변길이 배열에 저장된 객체(데이터)의 개수를 반환하는 size() 메소드 호출
		System.out.println("HashSet 가변 배열 메모리에 저장된 객체의 개수 얻자 -> " + set.size());
		
		// HashSet 가변길이 배열에 객체를 추가하기 위해 add(Object obj) 메소드 사용!
		set.add("하나"); // String 객체("하나")의 주소 번지가 배열에 추가됨
		set.add(2); // 기본 자료형 int 2는 객체가 아니므로 배열에 바로 저장할 수 없다.
					// 컴파일러가Integer.valueOf(2) 를 자동으로 호출해
					// Integer 래퍼 객체로 포장한 후 저장한다. = 자동(오토) 박싱
		
		set.add(3.42); // 자동(오토) 박싱이 일어나 Double.valueOf(3.42); 래퍼 객체가 배열에 추가되어 저장됨
		set.add("넷");
		set.add("five");
		set.add(Integer.valueOf(6)); // 수동 박싱을 직접 작성해 new Integer(6); 래퍼 객체를 추가함
		
		// HashSet 가변길이 배열에 저장된 객체(데이터)의 개수를 반환하는 size() 메소드 호출
		System.out.println("HashSet 가변 배열 메모리에 저장된 객체의 개수 얻자 -> " + set.size()); // 6
		
		//=========================================================
		// Set 인터페이스를 구현한 자식 클래스의 배열 특성 1 확인: 객체 중복 저장 금지
		//=========================================================
		
		//add 메소드는 추가 성공 여부를 boolean(true / false)으로 반환한다.
		// - 배열에 없던 개체를 추가하면 -> 저장하고 true 반환
		// - 배열에 이미 있는 객체를 추가하면 -> 저장을 거부하고 false 반환
		boolean result1 = set.add("여섯"); // "여섯" 은 배열에 없으므로 -> 저장 성공 true 반환
		boolean result2 = set.add("하나"); // "하나" 는 이미 배열에 있으므로 -> 저장 거부 false 반환
		boolean result3 = set.add(2); // 2가 저장된 Integer 래퍼 객체가 이미 배열에 있으므로 -> 저장 거부 false 반환
		
		System.out.println("처음 추가하는 \"여섯\" add 결과 -> " + result1); // true <- 배열에 추가 성공
		System.out.println("이미 존재하는 \"하나\" add 결과 -> " + result2); // false <- 배열에 추가 실패
		System.out.println("이미 존재하는 2가 저장된 Integer 래퍼 객체 add 결과 -> " + result3); // false <- 배열에 추가 실패
		
		// HashSet 가변길이 배열에 저장된 객체(데이터)의 개수를 반환하는 size() 메소드 호출
		System.out.println("HashSet 가변 배열 메모리에 저장된 객체의 개수 얻자 -> " + set.size()); // 7
		
	}// === main 메소드

}// --- Collections01 클래스


