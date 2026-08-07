
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
		
		
		
	}// === main 메소드

}// --- HashTableTest 클래스


