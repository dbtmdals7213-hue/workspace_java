import java.util.HashMap; // Map 부모 인터페이스를 구현한 자식 HashMap 클래스
import java.util.Iterator;
import java.util.Map; // Map 인터페이스
import java.util.Map.Entry; // Map 인터페이스 내부에 만들어져 있는 중첩(내부) Entry 인터페이스
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
		// Map 부모 인터페이스를 구현한 자식 HashMap 클래스의 배열이 포함된 객체 생성
		Map<String, Integer> map = new HashMap<String, Integer>();
		//	 key  ,	 value
		
		// HashMap 표형의 메모리 구조에 데이터(key-value) 를 한 쌍의 형태로 묶어서 한 행에 추가로 저장
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95); // <- 같은 key "홍길동" 에 대한 value 를 추가하면
							 //	   기존에 map.put("홍길동", 90); 이용해서 저장했던 행은 제거되고
							 //    map.put("홍길동", 95); 이용해서 저장한 행이 HashMap 에 추가되어 저장됨
		
		System.out.println("HashMap 에 저장된 key 총 개수 얻기: " + map.size());
		//				   "HashMap 에 저장된 key 총 개수 얻기: 3"
		
		System.out.println();
		
		// HashMap 에 저장된 특정 key 를 이용해 value 얻기
		// -> V get(Object key): 매개변수로 전달하는 key 의 value 를 반환합니다.
		
		//1. "홍길동" key 자체를 변수에 저장
		String key = "홍길동";
		
		//2. "홍길동" key 를 이용해 95 value 를 얻어 저장
		Integer value = map.get(key);
		
		System.out.println(key + " : " + value);
		// 홍길동 : 95
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		
		// HashMap 공간에 저장된 key-vale 를 모두 반복해서 얻어 출력
		while(keyIterator.hasNext()) {
			
			// key 들만 차례로 반복해서 자식 Itr 배열에서 얻습니다.
			String k = keyIterator.next(); // "홍길동"
			
			// key 를 이용해 HashMap 표의 공간에 key-value 중 value 를 얻습니다.
			Integer v = map.get(k);
			
			System.out.println(k + " : " + v);
		}// while 반복문
		
		System.out.println("------------------------------------");
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		
		
	}// === main 메소드

}// --- HashMapTest 클래스


