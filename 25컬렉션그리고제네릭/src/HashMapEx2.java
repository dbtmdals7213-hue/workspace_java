import java.util.Map;      //Map인터페이스
import java.util.Set;      //Set인터페이스
import java.util.HashMap;  //Map부모인터페이스를 구현한 자식 HashMap클래스
import java.util.Iterator; //Iterator인터페이스

//===================================================================
//[응용 문제 2] HashMap 에 같은 key 로 다시 저장하면 어떻게 될까? + 전체 출력
//===================================================================
//과목 이름을 key, 시험 점수를 value 로 저장하는 문제입니다.
//
//[요구사항]
// 1단계 : key 는 String, value 는 Integer 를 저장하는
//         HashMap 객체를 생성해서 Map 인터페이스 타입 참조변수 map 에 저장하세요.
//
// 2단계 : put 메소드를 사용해서 아래 4번의 저장을 순서대로 실행하세요.
//           key          value
//          "자바"    ,   70
//          "DB"      ,   85
//          "HTML"    ,   90
//          "자바"    ,   95    <- 같은 key "자바" 로 다시 저장!
//
// 3단계 : size 메소드를 사용해서 아래 문장을 출력하세요.
//         HashMap에 저장된 key 총 갯수 얻기 : 3
//         (4번 put 했는데 왜 3개인지 주석으로 이유를 적어보세요.)
//
// 4단계 : get 메소드를 사용해서 key "자바" 와 연결되어 저장된
//         value 를 꺼내와 아래 문장을 출력하세요.
//         자바 : 95
//         (70 이 아니라 95 가 출력되는 이유를 주석으로 적어보세요.)
//
// 5단계 : keySet 메소드로 Set 배열을 반환 받고
//         iterator 메소드로 Iterator 객체를 반환 받은 후
//         while 반복문 + hasNext + next 메소드를 사용해서
//         저장된 모든 (key : value) 를 아래 형태로 출력하세요.
//         자바 : 95
//         DB : 85
//         HTML : 90
//         (출력 순서는 저장한 순서와 다를 수 있습니다.)
//===================================================================

public class HashMapEx2 {
	public static void main(String[] args) {

		//1단계 : Map부모 인터페이스를 구현한 자식 HashMap클래스의 배열객체 메모리 생성
		Map<String, Integer> map = new HashMap<String, Integer>();


		//2단계 : put 메소드로 4번 저장 (마지막은 같은 key "자바" 로 저장)
		map.put("자바", 70);
		map.put("DB", 85);
		map.put("HTML", 90);
		map.put("자바", 95);


		//3단계 : size 메소드로 저장된 key 총 갯수 출력
		System.out.println("HashMap 에 저장된 key 총 개수 얻기 : " + map.size());


		//4단계 : get 메소드로 key "자바" 의 value 꺼내와 출력
		String key = "자바";
		Integer val = map.get(key);
		System.out.println(key + " : " + val);

		
		//5단계 : keySet 메소드 + Iterator 객체로 전체 (key : value) 출력
		Set<String> set = map.keySet();
		Iterator iterator = set.iterator();

		while(iterator.hasNext()) {
			String k = (String)iterator.next();
			Integer v = map.get(k);
			
			System.out.println(k + " : " + v);
		}
		
	}//----- main
}//--- class
