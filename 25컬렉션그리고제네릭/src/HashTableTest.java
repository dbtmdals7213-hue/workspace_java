
import java.util.Hashtable;
import java.util.Map;
import java.util.Enumeration;

// 주제: Map 부모 인터페이스를 구현 받은 자식 HashTable 클래스의 배열 메모리 만들어 사용해보기
public class HashTableTest {

	public static void main(String[] args) {
		
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		
		// HashTable 표 형태의 배열 메모리에 데이터(key-value)를 저장할 때 put 메소드 사용
		// key 또한 객체로 넣고, value 또한 객체로 넣습니다.
		//			   key , value
		hashtable.put("사과", "Apple");
		hashtable.put("딸기", "Strawberry");
		hashtable.put("포도", "Grapes");
		
		//=============================== HashTable 클래스의 get 메소드 ===============================
		// Object get(Object key) 메소드를 이용하자!
		// - get 메소드는 key 를 매개변수로 집어 넣으면?
		//	 HashTable 표 메모리 전체에 저장된(key-value) 중 value 를 Object obj 에 저장할 자식 객체로 얻는 메소드.
		
		// HashTable 전체 표 구조의 배열 메모리 안에 저장되어 있는 value 중에서 "Grapes: 객체를 얻고 싶다.
		String value = hashtable.get("포도");	 // 업 캐스팅 안해도 value -> "Grapes" 문자열 객체를 value 로 얻어 저장 가능
		//	 "Grapes"						 // 그리고 다운 캐스팅도 하지 않고 String 클래스에 만들어 놓은 메소드 호출 가능
		
		// key - "포도" 를 이용해서 value - "Grapes" 을 HashTable 표 메모리에서 꺼내올 수 있는지 확인
		if(value != null) {
			
			System.out.println("포도 key 와 함께 연결되어 저장됬던 value -> " + value.toString());
			//					포도 key 와 함께 연결되어 저장됬던 value ->   + "Grapes"
		}
		
		/*
			HashTable 배열에 저장된 모든 Key(객체) 들을 일일이 기억하지 못하므로
			모든 Key(객체) 들만 뽑아내서 Enumeration 배열에 담아 Enumeration 배열 주소 자체를 반환
			-> keys() 메소드
		*/
		Enumeration enumeration = hashtable.keys();
		
		// keys() 메소드를 호출해서 반환 받은 ["사과", "딸기", "포도"] Enumeration 배열에 저장된 key 들이 있으면 반복
		while(enumeration.hasMoreElements()) {
			
			//1. Enumeration 배열에 저장되어 있는 key 들을 차례대로 얻어 저장
			String key = (String)enumeration.nextElement();
			
			//2. key 를 이용해 HashTable 배열 전체에 저장된 value 를 차례대로 얻어 저장
			String val = hashtable.get(key);
			
			//3. HashTable 에 저장되어 있는 key - value 형태의 문자열을 반복해서 출력
			System.out.println(key + " - " + val);
			/*
				딸기 - Strawberry
				사과 - Apple
				포도 - Grapes
			*/
		}// while 반복문
		
	}// === main 메소드

}// --- HashTableTest 클래스


