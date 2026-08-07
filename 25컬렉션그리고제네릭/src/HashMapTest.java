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
		
		System.out.println("-------------------");
		
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
		
		System.out.println("-------------------");
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		// HashMap.Itr 자식 객체는 그 다음 HashMap 배열 내부의 각 칸에 저장된 Entry 객체를 하나씩 반복해서 꺼내어 사용할 수 있는 동안만 반복
		// (HashMap 내부에 아직 순회하지 않은 Entry 객체가 있는 동안만 반복)
		while(entryIterator.hasNext()) {
			
			// HashMap.Itr 객체가 현재 사용하고 있는 HashMap 내부의 각 칸에 저장된 Entry 객체를 하나씩 꺼낸다
			Entry<String, Integer> entry = entryIterator.next();
			
			// Entry 객체에 저장된 key 를 꺼낸다.
			String k = entry.getKey();
			
			// Entry 객체에 저장된 value 를 꺼낸다.
			Integer v = entry.getValue();
			
			// 꺼낸 key 와 value 를 같이 출력
			System.out.println(k + " : " + v);
		}// while 반복문
		
		System.out.println();
		
		// HashMap 객체 내부의 인스턴스 변수의 배열 메모리에 저장된 Entry 객체 정보 중 key 를 이용해 Entry 객체(key-value) 한 쌍 삭제
		map.remove("홍길동");
		
		// HashMap 객체 내부의 배열 메모리의 각 칸에 저장된 Entry 객체 개수 얻어 출력
		System.out.println(map.size() + "개"); // "2개"
		
	}// === main 메소드

}// --- HashMapTest 클래스


