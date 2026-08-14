import java.util.ArrayList;                  //가변 크기 배열(컬렉션) 클래스
import java.util.Arrays;                     //asList 로 고정 크기 List 를 만들 때 사용
import java.util.HashMap;                    //키-값 쌍을 저장하는 컬렉션 (주소록 표로 사용)
import java.util.List;                       //목록의 공통 규격(인터페이스)
import java.util.Map;                        //키-값 저장소의 공통 규격(인터페이스)
import java.util.function.Consumer;          //값을 받아 처리만 하는 함수형 인터페이스 (Ex1)
import java.util.stream.Collectors;          //스트림 결과를 List 로 모을 때 사용 (Ex3,4,5)

/*
 * ==================================================================
 * [람다 응용 예제] 주소별 메뉴 조회기
 *                 (순수 자바 + 람다식만 사용.)
 * ==================================================================
 *
 * ------------------------------------------------------------------
 * 0. 먼저 알아야 할 것 - "주소를 주면 결과를 돌려주는 프로그램"
 * ------------------------------------------------------------------
 *
 *   이 예제가 만드는 것은 아주 단순하다.
 *
 *     문자열 주소를 하나 건네주면  -->  그에 맞는 결과 문자열을 돌려준다
 *
 *   예를 들어
 *     "/menu"          를 주면  -->  "전체 메뉴 : 아메리카노 3000원 / ..."
 *     "/menu/average"  를 주면  -->  "평균 가격 : 4200.0원"
 *     "/event"         를 주면  -->  "404 : 없는 주소입니다"  (등록 안 된 주소)
 *
 *   카페 키오스크를 떠올리면 쉽다.
 *     화면의 버튼(주소)을 누르면 --> 그 버튼에 연결된 기능이 실행되어 --> 결과가 뜬다
 *
 *   여기서 핵심 질문 하나가 생긴다.
 *
 *     "버튼(주소 문자열) 과 기능(메소드) 을 어떻게 연결해 두지?"
 *
 *   지금까지 배운 것으로는 if 문을 길게 쓰는 방법밖에 없다.
 *
 *     if (url.equals("/menu")) { ... }
 *     else if (url.equals("/menu/under")) { ... }
 *     else if (url.equals("/menu/sorted")) { ... }
 *     ... 주소가 100개면 if 가 100개 -->  못 쓸 코드가 된다
 *
 *   그래서 이 예제는 다른 방법을 쓴다.
 *
 *     "주소 문자열" 과 "실행할 기능" 을 표(Map)에 한 쌍씩 등록해 두고,
 *     주소가 들어오면 표에서 꺼내 실행한다.
 *
 *   그런데 Map 에는 "값(객체)" 만 담을 수 있다. 메소드는 못 담는다.
 *   메소드를 값처럼 담으려면 어떻게 해야 하나?
 *
 *     --> 바로 이때 쓰는 것이 "함수형 인터페이스 + 람다식" 이다.
 *         람다식은 "메소드 하나를 값처럼 다룰 수 있게 만든 것" 이기 때문이다.
 *
 *   이 예제의 전부가 이 한 문장이다.
 *
 * ------------------------------------------------------------------
 * 1. 이 예제의 전체 구조 (클래스 4개의 역할)
 * ------------------------------------------------------------------
 *
 *   RequestHandler  : "기능의 모양" 을 정해 둔 규격 (함수형 인터페이스)
 *   Menu            : 메뉴 1개의 데이터 (이름, 가격)
 *   MenuService     : 메뉴 데이터를 스트림으로 가공하는 담당
 *   MiniServer      : 주소와 기능을 표에 등록하고, 주소가 오면 찾아 실행하는 담당
 *   LambdaMvcPreview: 실행 클래스. 등록하고 요청해 본다
 *
 * ------------------------------------------------------------------
 * 2. 전체 동작 흐름 (주소 "/menu/under" 에 "4000" 을 준 경우)
 * ------------------------------------------------------------------
 *
 *   [1] 표에서 "/menu/under" 라는 키를 찾는다
 *        |
 *        v
 *   [2] 그 키에 연결된 람다식(기능)을 꺼낸다
 *        |
 *        v
 *   [3] 꺼낸 람다를 실행한다. 이때 "4000" 이 람다의 param 자리에 들어간다
 *        |
 *        v
 *   [4] 람다 안에서 MenuService 를 호출해 스트림으로 데이터를 거른다
 *        |
 *        v
 *   [5] 만들어진 응답 문자열을 돌려준다 --> 화면에 출력
 *
 * ------------------------------------------------------------------
 * 3. 사용하는 람다 문법과 출처 예제 정리
 * ------------------------------------------------------------------
 *
 *   @FunctionalInterface 직접 정의       	<- Main.java 에서 학습
 *   람다식으로 익명메소드 작성           		<- Ex1
 *   Consumer<String> 로 출력 처리        	<- Ex1
 *   stream().filter(조건람다)            	<- Ex2, Ex3, Ex5
 *   mapToInt().average().orElse(0.0)   <- Ex2, Ex2_1
 *   sorted(비교람다)                     	<- Ex4, Ex6
 *   collect(Collectors.toList())       <- Ex3, Ex4, Ex5
 *
 * ------------------------------------------------------------------
 * 4. 나중에 배울 것과의 연결 (지금은 읽기만 하고 넘어가도 된다)
 * ------------------------------------------------------------------
 *
 *   나중에 Spring 이라는 도구로 홈페이지를 만들 때,
 *   "주소와 기능을 연결하는 표" 가 도구 안에 이미 들어 있다.
 *   이름만 다를 뿐 지금 만드는 구조와 똑같다.
 *   그때 "아 이거 그때 만들어 본 그 표구나" 하고 알아보면 된다.
 * ==================================================================
 */

//==================================================================
// [1] 함수형 인터페이스 - "기능의 모양" 을 정해 두는 규격
//
//   왜 필요한가?
//     Map 의 값 자리에 "기능(메소드)" 을 담고 싶은데,
//     자바에서 메소드는 그냥은 값이 될 수 없다.
//     그래서 "이런 모양의 기능" 이라는 규격(인터페이스)을 먼저 만들어 두고,
//     그 규격에 맞는 람다식을 값처럼 담는다.
//
//   Main.java 에서 배운 @FunctionalInterface 직접 정의 방식이다.
//==================================================================

@FunctionalInterface
interface RequestHandler {
	
	// 추상 메소드: 이 인터페이스가 정한 기능을 이름으로 표현하는 메소드
	String handle(String param);
}// --- RequestHandler 인터페이스


//============================
//[2] 메뉴 1개의 데이터를 담는 클래스
//============================
class Menu {
	
	String name; // 메뉴 이름
	int price; // 메뉴 가격
	
	public Menu(String name, int price) {
		
		this.name = name;
		this.price = price;
	}// Menu 생성자
	
}// --- Menu Class


//====================================================
//[3] 메뉴 데이터를 가공하는 클래스
// 기능 4개(전체 목록 / 가격 필터 / 정렬 / 평균)를 스트림으로 처리한다.
//====================================================
class MenuService {
	
	// 데이터 준비: 메뉴 5개가 저장된 고정 크기 배열 준비
	List<Menu> menuList = Arrays.asList(new Menu("아메리카노", 3000),
										new Menu("라떼", 4500),
										new Menu("케이크", 6500),
										new Menu("쿠키", 2000),
										new Menu("주스", 5000)
	);
	
	//---------------------------------------------
	//기능1:	전체 메뉴를 "이름 가격원" 형태의 문자열 목록으로 반환
	//---------------------------------------------
	public List<String> findAll(){
		
		// 결과를 담을 가변 크기 배열을 만든다.(칸이 자동으로 늘어난다.)
		List<String> result = new ArrayList<>();
		
		for(Menu m : menuList) {
			
			result.add(m.name + " " + m.price + "원");
		}// for 반복문
		
		return result; // 조립된 ArrayList 배열 목록을 호출한 곳(람다)으로 돌려준다.
	}// === findAll Method
	
	//----------------------------------
	//기능2:	지정한 가격 이하의 메뉴만 걸러서 반환
	//----------------------------------
	public List<String> findUnder(int maxPrice) {// <--- 기준 가격 4000원
		
		List<String> result = new ArrayList<>(); // 결과를 담을 가변 크기 배열
		
		//순서1.	menuList 고정 크기 배열의 Menu 객체를 읽어들일 데이터 스트림 통로 만들어 반환
		List<Menu> filtered = menuList.stream()
		
		//순서2.	Stream<Menu> 데이터 스트림 통로의 Menu 객체를 하나씩 m 매개변수로 전달해 조건식을 확인하고,
		//		조건이 참인 객체만 남긴 새로운 Stream<Menu> 데이터 스트림 객체를 반환한다.
		// 조건:	특정 메뉴의 가격이 매개변수 int maxPrice 로 받은 기준 가격 이하인가?
		.filter(m -> m.price <= maxPrice)
		
		//순서3.	Stream<Menu> 통로에 남은 Menu 객체들을 ArrayList 배열에 담아 반환(최종 연산)
		.collect(Collectors.toList());
		
		// 걸러진 Menu(메뉴) 객체들을 "이름 가격원" 문자열로 조립한다.
		for(Menu m : filtered) {
			
			result.add(m.name + " " + m.price + "원");
		}// for 반복문
		
		return result; // ArrayList result 배열 반환 ["아메리카노 3000원", "쿠키 2000원"]
	}// === findUnder Method
	
	//-----------------------------
	//기능3:	가격이 싼 순서로 정렬해서 반환
	//-----------------------------
	public List<String> findSorted() {
		
		List<String> result = new ArrayList<>();
		
		//순서1.	menuList 고정 크기 배열의 Menu 객체들을 읽어들일 데이터 스트림 통로를 만들어 반환
		List<Menu> sorted = menuList.stream()
		
		//순서2.	Stream<Menu> 통로의 Menu 객체를 두 개씩(a, b) 자리에 담아 비교하며
		//		순서를 정한 Stream<Menu> 통로 객체를 반환
		.sorted((a, b) -> a.price - b.price)
		
		//순서3.	정렬된 순서대로 ArrayList 배열에 Menu 객체를 담아 반환
		.collect(Collectors.toList());
		
		// 정렬된 메뉴들을 "메뉴이름 가격원" 문자열로 조립해서 ArrayList 에 추가 후 반환
		for(Menu m : sorted) {
			
			result.add(m.name + " " + m.price + "원");
		}// for 반복문
		
		return result;
	}// === findSorted
	
	//-----------------------------------
	//기능4:	전체 메뉴의 평균 가격 계산 후 돌려주기
	//-----------------------------------
	public double findAverage() {
		
		//순서1.	Menu 객체를 읽어들인 데이터 스트림 통로를 만들어 반환
		double average = menuList.stream()
		
		//순서2.	Stream<Menu> 통로 객체에서 price 값만 꺼내어
		//		int 숫자가 흐르는 IntStream 통로 객체로 바꿔서 반환한다.
		.mapToInt(m -> m.price)
		
		//순서3.	IntStream 통로 숫자들의 평균을 계산해 OptionalDouble 이라는 객체 메모리에 담아 반환한다.
		// OptionalDouble 객체 메모리에 담아 반환하는 이유: 메뉴 price 가 위 IntStream 통로에 없으면 평균을 구할 수 없기 때문에
		.average()
		
		//순서4.	OptinalDouble 객체 메모리(상자)를 열어 평균을 꺼낸다.(반환한다.) 만약 평균 값이 저장되어 있지 않으면 0.0을 돌려 받게 하자
		.orElse(0.0);
		
		return average;// 계산된 평균 값을 돌려준다.(반환한다.)
	}// === findAverage Method
	
}// --- MenuService Class


//=====================================================
//[4] 주소와 기능을 연결해두고, 요청 주소가 들어오면 찾아 실행하는 클래스
//=====================================================
class MiniServer {
	
	// 주소록 표(HashMap): 키 = 주소 문자열, 값 = 그 주소에서 실행할 람다식
	// HashMap 의 put(키, 값); 추가함
	// get(키) -> 값 얻음
	// containsKey(키);
	
	Map<String, RequestHandler> mappingTable = new HashMap<>();
	
	//--------------------------------------------------------
	// 주소 등록 메소드
	// "이 주소로 요청이 오면 이 기능을 실행해라" 를 표(HashMap)에 한 줄 추가
	//--------------------------------------------------------
	public void addMapping(String url, RequestHandler handler) {
		
		// put(키, 값): 표에 한 쌍으로 등록된다.
		mappingTable.put(url, handler);
		
		System.out.println("[등록] " + url + " 처리 람다 등록 완료");
	}// === addMapping Method
	
	//-----------------------------------------------------------------
	// 주소 처리 메소드
	// 주소를 받아 표(HashMap)에서 기능(람다식)을 찾아 실행하고, 그 결과 문자열을 돌려준다.
	//-----------------------------------------------------------------
	public String dispatch(String url, String param) {
		
		// 표(HashMap)의 containsKey(키): 표에 그 키가 등록되어 있으면 true, 없으면 false 반환
		boolean exists = mappingTable.containsKey(url);
		
		// 사용자가 요청한 url 주소가 표(HashMap)에 등록되지 않은 주소이면?
		// (404 는 "그런 주소 없음" 을 뜻하는 널리 쓰이는 번호다.)
		if(!exists) {
			
			// 등록되지 않은 주소에 대한 안내 문자열을 돌려주는 메소드를 끝낸다.
			return "404 : " + url + " 은 없는 주소입니다.";
		}
		
		// 사용자가 요청한 url 주소가 표(HashMap)에 등록된 주소이면?
		// get(키):	표에서 그 키에 저장된 값(람다식)을 꺼내온다.
		//			꺼낸 람다식의 익명 자식 구현 객체를 handler 변수에 저장
		RequestHandler handler = mappingTable.get(url);
		
		return handler.handle(param);
	}// === dispatch Method
	
}// --- MiniServer Class


//===========================
//[5] 자바 프로그램 실행시키는 클래스
//===========================
public class LambdaMvcPreview {

	public static void main(String[] args) {
		
		// 데이터 가공 담당 객체와, 주소록 표 담당 객체를 각각 1개씩 만든다.
		MenuService service = new MenuService();
		MiniServer server = new MiniServer();
		
		//==========================
		//[1] 주소 4개에 기능(람다식) 등록
		//==========================
		server.addMapping("/menu", (param) -> {
			
			// 데이터 가공은 MenuService 에게 맡긴다.(역할 분담)
			List<String> list = service.findAll();
			
			// 응답 문자열의 앞 부분을 먼저 만들어 준다.
			String response = "전체 메뉴: ";
			
			// 목록을 하나씩 꺼내 뒤에 "전체 메뉴: " 뒤에 계속 누적해서 연결하자
			for(String s : list) {
				
				response = response + s + " / ";
			}
			
			return response;
		});
		
		//---------------------------------------------
		//등록2.	지정 가격 이하 메뉴(param 자리로 가격이 넘어온다.)
		//---------------------------------------------
		server.addMapping("/menu/under", (param) -> {
			
			// param 은 문자열("4000") 이므로 계산에 쓰려면 정수로 바꿔야 한다.
			int maxPrice = Integer.parseInt(param);
			
			// 바꾼 기준 가격 4000을 기준으로 가격 필터 기능을 호출한다.
			List<String> list = service.findUnder(maxPrice);
			
			String response = maxPrice + "원 이하";
			
			for(String s : list) {
				
				response = response + s;
			}
			
			return response;
		});
		
		//-------------------------------------------------
		//등록3.	가격 싼 가격 순 정렬 목록(param 을 쓰지 않는 기능이다.)
		//-------------------------------------------------
		server.addMapping("/menu/sorted", (param) -> {
			
			List<String> list = service.findSorted(); // 정렬 기능 사용 후 메뉴 정보들을 ArrayList 배열에 담아 반환 받기
			
			String response = "가격순: ";
			
			for(String s : list) {
				
				response = response + s;
			}
			
			return response; // 가격 싼 가격 순 정렬 목록 반환
		});
		
		//----------------------------
		//등록4.	평균 가격
		//----------------------------
		server.addMapping("/menu/average", (param) -> "평균 가격: " + service.findAverage() + "원");
		
		System.out.println();
		
		
		
		
		
		
	}// === main Method

}// --- LambdaMvcPreview Class




