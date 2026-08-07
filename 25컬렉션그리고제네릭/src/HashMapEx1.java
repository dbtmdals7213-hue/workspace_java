import java.util.Map;     //Map인터페이스
import java.util.HashMap; //Map부모인터페이스를 구현한 자식 HashMap클래스

//===================================================================
//[응용 문제 1] HashMap 배열 메모리에 상품-가격 데이터 저장하고 꺼내오기
//===================================================================
//수업 예제 HashMapTest 와 똑같은 순서로
//상품 이름을 key, 가격을 value 로 저장하고 출력하는 문제입니다.
//
//[요구사항]
// 1단계 : key 는 String, value 는 Integer 를 저장하는
//         HashMap 객체를 생성해서 Map 인터페이스 타입 참조변수 map 에 저장하세요.
//
// 2단계 : put 메소드를 사용해서 아래 3쌍의 (key-value) 데이터를 저장하세요.
//           key           value
//          "노트북"   ,   1500000
//          "마우스"   ,   30000
//          "키보드"   ,   80000
//
// 3단계 : size 메소드를 사용해서 아래 문장을 출력하세요.
//         HashMap에 저장된 key 총 갯수 얻기 : 3
//
// 4단계 : get 메소드를 사용해서 key "마우스" 와 연결되어 저장된
//         value 30000 을 int 변수 price 에 저장한 후 아래 문장을 출력하세요.
//         마우스 : 30000
//
// 5단계 : containsKey 메소드를 사용해서 key "모니터" 가
//         HashMap 에 저장되어 있는지 확인하고,
//         저장되어 있지 않으면 아래 문장을 출력하세요.
//         모니터 key는 HashMap에 저장되어 있지 않습니다.
//===================================================================

public class HashMapEx1 {
	public static void main(String[] args) {

		//1단계 : Map부모 인터페이스를 구현한 자식 HashMap클래스의 배열객체 메모리 생성
		Map<String, Integer> map = new HashMap<String, Integer>();


		//2단계 : put 메소드로 (key-value) 3쌍 저장
		map.put("노트북", 1500000);
		map.put("마우스", 30000);
		map.put("키보드", 80000);
		

		//3단계 : size 메소드로 저장된 key 총 갯수 출력
		System.out.println("HashMap 에 저장된 key 총 개수 얻기 : " + map.size());


		//4단계 : get 메소드로 key "마우스" 의 value 꺼내와 출력
		String key = "마우스";
		Integer price = map.get(key);
		System.out.println(key + " : " + price);


		//5단계 : containsKey 메소드로 key "모니터" 저장 여부 확인 후 출력
		if(map.containsKey("모니터") == false) {
			
			System.out.println("모니터 key 는 HashMap 에 저장되어 있지 않습니다.");
		}
		
	}//----- main
}//--- class
