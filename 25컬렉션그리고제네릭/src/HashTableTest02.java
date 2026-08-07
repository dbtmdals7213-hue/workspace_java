import java.util.Hashtable;

public class HashTableTest02 {

	public static void main(String[] args) {
		
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		
		hashtable.put("사과", "Apple");
		hashtable.put("딸기", "Strawberry");
		hashtable.put("포도", "Grapes");
		
		//============ HashTable 클래스의 get 메소드 ============
		// E get(Object key) 메소드를 이용하자!
		// String get(Object key) 메소드 형태로 변경된다.
		
		String value = hashtable.get("포도");	 // 업 캐스팅 안해도 value -> "Grapes" 문자열 객체를 value 로 얻어 저장 가능
											 // 그리고 다운 캐스팅도 하지 않고 String 클래스의 모든 메소드 사용 가능!
		
		if(value != null) {
			
			System.out.println("포도 key 와 함께 연결되어 저장됬던 value -> " + value.toString());
		}
		
	}// === main 메소드

}// --- HashTableTest02 클래스
