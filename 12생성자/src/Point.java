




public class Point {// x 좌표, y 좌표 점 설계도

	//[1] 객체 변수 선언
	// x, y 좌표 값을 각각 저장시킬 int 객체 변수 2개 선언
	int x, y;
	
	//--------------------------------------------------------------------
	
	//[2] 기본 생성자 선언
	public Point() {
		
		// x 객체 변수 값 2로 초기화
		x = 2; 
		// y 객체 변수 값 2로 초기화
		y = 2; 
		
		// "[기본 생성자] Point 기본 생성자 호출됨" <--- 기본 생성자가 호출됨을 확인할 용도로 출력
		System.out.println("[기본 생성자] Point 기본 생성자 호출됨");
	}
	
	public Point(int x_) {
		
		//[3] 위 x 객체 변수 값만 초기화 하는 생성자 선언
		x = x_;
	}
	
	public Point(int x_, int y_) {// <--- new Point (300, 400);
		
		//[4] 위 x 객체 변수, y 객체 변수 값 모두 초기화 하는 생성자 선언
		x = x_;
		y = y_;
	}
	
	//--------------------------------------------------------------------
	
	//[5] 메소드 선언
	public void setY(int y1) {//1. 위 y 객체 변수 값 매개변수로 받아 변경시키는 setY 메소드 만들기
		
		y = y1;
	}
	
	public int getY() {//2. 위 y 객체 변수 값을 외부로 반환하는 getY 메소드 만들기
		
		return y;
	}
	
	public void setX(int x1) {//3. 위 x 객체 변수 값 매개변수로 받아 변경시키는 setX 메소드 만들기
		
		x = x1;
	}
	public int getX() {//4. 위 x 객체 변수 값을 외부로 반환하는 getX 메소드 만들기
	
		return x;
	}
	//5. 현재 x 객체 변수 값 그리고 y 객체 변수 값을 얻어 모두 "출력 x, y : 100, 200" 문자열로 합쳐 출력하는 기능의 printCoordinates 메소드 만들기
	
	public void printCoordinates() {
		
		System.out.println("출력 x, y : " + x + ", " + y);
	}
	
	public static void main(String[] args) {
		
		
		
		
	}

}
