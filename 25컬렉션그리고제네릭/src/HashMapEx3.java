import java.util.Map;       //Map인터페이스
import java.util.Set;       //Set인터페이스
import java.util.HashMap;   //Map부모인터페이스를 구현한 자식 HashMap클래스
import java.util.Iterator;  //Iterator인터페이스
import java.util.Map.Entry; //Map인터페이스 내부에 만들어져 있는 중첩(내부) Entry인터페이스

//===================================================================
//[응용 문제 3] entrySet 으로 전체 출력 + remove 로 삭제 + clear 로 전체 삭제
//===================================================================
//회원 이름을 key, 적립 포인트를 value 로 저장하는 문제입니다.
//
//[요구사항]
// 1단계 : key 는 String, value 는 Integer 를 저장하는
//         HashMap 객체를 생성해서 Map 인터페이스 타입 참조변수 map 에 저장하세요.
//
// 2단계 : put 메소드를 사용해서 아래 3쌍의 (key-value) 데이터를 저장하세요.
//           key          value
//          "김회원"   ,   1000
//          "이회원"   ,   2000
//          "박회원"   ,   3000
//
// 3단계 : entrySet 메소드로 Set 배열을 반환 받고
//         iterator 메소드로 Iterator 객체를 반환 받은 후
//         while 반복문 안에서 Entry 객체를 하나씩 꺼내서
//         getKey 메소드와 getValue 메소드를 사용해
//         저장된 모든 (key : value) 를 아래 형태로 출력하세요.
//         김회원 : 1000
//         박회원 : 3000
//         이회원 : 2000
//         (출력 순서는 저장한 순서와 다를 수 있습니다.)
//
// 4단계 : remove 메소드를 사용해서 key "이회원" 과 일치하는
//         (key-value) 한쌍의 데이터를 삭제한 후
//         size 메소드를 사용해서 아래 문장을 출력하세요.
//         2 개
//
// 5단계 : clear 메소드를 사용해서 HashMap 에 저장된 모든 데이터를 삭제한 후
//         isEmpty 메소드를 사용해서 HashMap 이 비어 있으면
//         아래 문장을 출력하세요.
//         HashMap이 비어 있습니다.
//===================================================================

public class HashMapEx3 {
	public static void main(String[] args) {

		//1단계 : Map부모 인터페이스를 구현한 자식 HashMap클래스의 배열객체 메모리 생성
		Map<String, Integer> map = new HashMap<String, Integer>();


		//2단계 : put 메소드로 (key-value) 3쌍 저장
		map.put("김회원", 1000);
		map.put("박회원", 3000);
		map.put("이회원", 2000);


		//3단계 : entrySet 메소드 + Iterator 객체 + getKey/getValue 로 전체 출력
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			
			Entry<String, Integer> entry = iterator.next();
			
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println(k + " : " + v);
		}

		
		//4단계 : remove 메소드로 key "이회원" 삭제 후 size 출력
		map.remove("이회원");
		System.out.println(map.size() + " 개");


		//5단계 : clear 메소드로 전체 삭제 후 isEmpty 메소드로 확인
		map.clear();
		
		if(map.isEmpty()) {
			
			System.out.println("HashMap 이 비어 있습니다.");
		}


	}//----- main
}//--- class
