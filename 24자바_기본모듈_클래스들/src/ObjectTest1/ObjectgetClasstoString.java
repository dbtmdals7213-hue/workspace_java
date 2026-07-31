package ObjectTest1;

/*
	비교용 클래스
	toString() 을 재정의하지 않았으므로 Object 의 원래 toString() 이 그대로 동작한다.
	출력 형태: 패키지포함클래스이름@16진수해시코드
*/
class Point2 {
	
	int x, y;
	
	public Point2(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
}// --- Point2 클래스

class Point extends Object {
	
	// 인스턴스 변수. 한 점의 가로 좌표와 세로 좌표를 저장한다.
	int x, y;
	
	// 기본 생성자. 값을 넣지 않았으므로 x, y 는 int 의 기본 값인 0이 된다.
	public Point() {}
	
	// 매개변수 생성자. 전달받은 값으로 x, y 를 초기화한다.
	public Point(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		
		// x 가 10, y 가 20이면 결과는 "(10, 20)" 이 된다.
		return "(" + this.x + ", " + this.y + ")";
	}
}

public class ObjectgetClasstoString {

	public static void main(String[] args) {
		
		//===============================
		//1. getClass() 로 클래스 정보 확인하기
		//===============================
		Point p1 = new Point(10, 20);
		
		System.out.println("p1.getClass() = " + p1.getClass());
		//						p1.getClass() = class ObjectTest1.Point
		//										class 	 패키지명	 .클래스명
		System.out.println("p1.getClass().getName() = " + p1.getClass().getName());
		//						p1.getClass().getName() = ObjectTest1.Point
		//													 패키지명	 .클래스명
		// 클래스 이름만 얻자
		System.out.println("p1.getClass().getSimpleName() = " + p1.getClass().getSimpleName());
		//						p1.getClass().getSimpleName() = Point
		//														클래스명
		System.out.println("---------------------------------------------");
		
		//====================================================================
		//2. toString() 메소드를 오버라이딩(재정의) 하지 않은 경우(Point2 클래스의 객체일 경우)
		//====================================================================
		Point2 q = new Point2(10, 20);
		
		System.out.println("q = " + q); // "ObjectTest1.Point2@1f32e575"
		
		// 위 출력이 어떻게 만들어지는지 직접 조립 해보면 결과가 같다.
		String manual = q.getClass().getName() + "@" + Integer.toHexString(q.hashCode());
		
		System.out.println("직접 조립한 문자열 = " + manual);
		
		System.out.println("---------------------------------------------");
		
		//============================================================
		//3. toString 메소드를 오버라이딩(재정의) 한 경우(Point 클래스의 객체일 경우)
		//============================================================
		System.out.println("new Point().toString() = " + new Point().toString());
		
		System.out.println("new Point(10, 20).toString() = " + new Point(10, 20).toString());
		
		Point point = new Point(30, 40);
		
		// 아래 두 줄은 완전히 같은 결과를 낸다.
		// println 에 객체를 넣으면 자바가 내부에서 toString() 을 자동으로 호출하기 때문이다.
		System.out.println("point = " + point);
		System.out.println("point.toString() = " + point.toString());
		
		System.out.println("---------------------------------------------");
		
		//===================================
		//4. toString() 이 자동 호출되는 다른 경우들
		//===================================
		
		// 문자열 + 로 연결할 때도 toString() 이 자동으로 호출된다.
		String s1 = "좌표는 " + point + " 입니다.";
		System.out.println(s1); // 좌표는 (30, 40) 입니다.
		
	}// === main 메소드

}// --- ObjectgetClasstoString 클래스


