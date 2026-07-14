
/*
	스토리: 카페에서 음료 한 잔을 주문한다.
		  사이즈(TALL / GRANDE)에 따라 가격이 달라지고, 결제 후 영수증을 출력한다.
*/

//1단계: 현실의 카페 주문 객체 모델링
// - 데이터: 메뉴(menu), 사이즈(size), 기본 가격(basePrice)
// - 기능: 최종 가격 계산(calcPrice), 영수증 출력(printReceipt)

//2단계: class(설계도) 만들기
public class CoffeeOrderTest {
	// 클래스 변수 선언
	String menu; //1. 메뉴명을 저장할 변수 선언
	String size; //2. 사이즈 저장할 변수 선언("TALL" 또는 "GRANDE")
	int basePrice; //3. 기본 가격을 저장할 변수 선언
	
	// 클래스 메소드 선언
	int calcPrice() {
		
		if(size.equals("GRANDE")) {// 문자열 비교는 == 이 아니라 equals() 사용 → 사이즈가 GRANDE 인지 검사
			
			return basePrice + 500;
		}else {
		
		return basePrice;
		}
	}
	
	/*
		메소드명: printReceipt
		기능: calcPrice() 를 호출해 "[영수증] 메뉴: OOO(사이즈) / 가격: XXXX원" 출력
	*/
	void printReceipt() {
		
		// 같은 객체의 calcPrice() 호출 -> 반환 값을 지역 변수 price 에 저장
		int price = calcPrice();
		
		// 메뉴 사이즈 최종 가격을 영수증 형식으로 출력
		System.out.println("[영수증] 메뉴: " + menu + "(" + size + ") / 가격: " + price + "원");
	}
	
	public static void main(String[] args) {
		//3단계: CoffeeOrderTest 클래스 하나를 이용해 new 로 객체 생성 후 데이터 저장 및 사용
		//순서1+순서2. order 객체 생성! 
		CoffeeOrderTest order = new CoffeeOrderTest();
		
		//순서3. order 객체 데이터 설정
		order.menu = "아메리카노"; // 메뉴명 -> "아메리카노" 저장
		order.size = "GRANDE"; // 사이즈 -> "GRANDE" 저장
		order.basePrice = 4000; // 기본 가격 -> 4000 저장
		
		//순서4. 출력: [영수증] 메뉴: 아메리카노(GRANDE) / 가격: 4500원
		order.printReceipt();
	}

}
