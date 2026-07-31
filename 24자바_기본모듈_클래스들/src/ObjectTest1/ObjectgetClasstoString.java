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


public class ObjectgetClasstoString {

	public static void main(String[] args) {
		
		//====================================================================
		//2. toString() 메소드를 오버라이딩(재정의) 하지 않은 경우(Point2 클래스의 객체일 경우)
		//====================================================================
		Point2 q = new Point2(10, 20);
		
		System.out.println("q = " + q); // "ObjectTest1.Point2@1f32e575"
		
		// 위 출력이 어떻게 만들어지는지 직접 조립 해보면 결과가 같다.
		String manual = q.getClass().getName() + "@" + Integer.toHexString(q.hashCode());
		System.out.println("q = " + manual);
		
		
	}// === main 메소드

}// --- ObjectgetClasstoString 클래스


