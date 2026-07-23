
/*
	주제:	 상속 기능을 사용하지 않고 Point2D, Point3D 클래스 설계 시
		 각 클래스 내부의 코드가 중복되는 예를 상속으로 해결하자
*/

// 2차원 평면의 좌표 값을 저장하는 Point2D 클래서 설계

class Point2D {
	
	private int x;
	private int y;
	
	// get 단어로 시작되는 메소드들을 -> getter 라고 부르고
	// set 단어로 시작되는 메소드들을 -> setter 라고 부릅니다.
	public int getX() { return this.x; } // getter 메소드: 변수 값을 반환하는 메소드
	public int getY() { return this.y; } // getter 메소드
	
	public void setX(int x) { this.x = x; } // setter 메소드: 변수 값을 변경하는 메소드
	public void setY(int y) { this.y = y; } // setter 메소드
}


public class Ex2 {

	public static void main(String[] args) {
		
		
	}

}
