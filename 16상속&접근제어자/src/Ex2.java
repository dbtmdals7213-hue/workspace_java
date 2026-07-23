
/*
	주제:	 상속 기능을 사용하지 않고 Point2D, Point3D 클래스 설계 시
		 각 클래스 내부의 코드가 중복되는 예를 상속으로 해결하자
*/

//======================================================
// [Before] 상속을 하지 않은 경우 - 두 클래스에 같은 코드가 중복 작성됨
//======================================================

// 2차원 평면의 좌표 값을 저장하는 Point2D_Before 클래스 설계
class Point2D_Before {
	
	private int x;
	private int y;
	
	// get 단어로 시작되는 메소드들을 -> getter 라고 부르고
	// set 단어로 시작되는 메소드들을 -> setter 라고 부릅니다.
	public int getX() { return this.x; } // getter 메소드: 변수 값을 반환하는 메소드
	public int getY() { return this.y; } // getter 메소드
	
	public void setX(int x) { this.x = x; } // setter 메소드: 변수 값을 변경하는 메소드
	public void setY(int y) { this.y = y; } // setter 메소드
}

// 3차원 공간의 좌표 값을 저장하는 클래스
// x, y, z 변수 + getter / setter 메소드가 Point2D_Before 클래스와 완전히 똑같이 "중복" 작성됨
class Point3D_Before {
	
	private int x; // <- Point2D_Before 클래스의 x 와 중복
	private int y; // <- Point2D_Before 클래스의 y 와 중복
	
	private int z; // <- Point3D_Before 클래스에 새롭게 정의한 변수, 중복되지 않음

	/* getter / setter 역할 메스드들 자동으로 만들기 단축 키 alt + shift + s r */
	public int getX() {return this.x; } // 중복 코드
	public void setX(int x) { this.x = x; } // 중복 코드
	public int getY() { return this.y; } // 중복 코드
	public void setY(int y) { this.y = y; } // 중복 코드
		
	public int getZ() { return this.z; }
	public void setZ(int z) { this.z = z; }
}
//2차원 평면의 좌표 값을 저장하는 클래스(부모 클래스)
//==================================================================================
// [After] 상속을 사용한 경우 - Point3D 클래스가 Point2D 클래스를 상속 받아 중복 코드 제거 후 만들었다.
//==================================================================================
// 상속 문법: class 자식클래스명 extends 부모클래스명 {}
//==================================================================================

class Point2D {
	
	private int x;
	private int y;
	
	// 메소드 이름이 get 단어로 시작하는 getter 역할을 하는 메소드와
	// 메소드 이름이 set 단어로 시작하는 setter 역할을 하는 메소드 모두 만들기
	// getter / setter 메소드들 만들기 단축 키 -> alt + shift + s r
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}

// 3차원 공간의 좌표 값을 저장하는 클래스(자식 클래스)
// Point2D 의 x, y, getX(), setX(), getY(), setY() 를 상속 받아 그대로 사용하고
// z 변수 관련 코드만 새로 추가하면 되므로 중복 코드 작성이 없어진다 

//상속 문법: class 자식클래스명 extends 부모클래스명 {}
class Point3D extends Point2D {
	
	private int z;

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
}

public class Ex2 {

	public static void main(String[] args) {
		
		System.out.println("------- Before (상속 미사용) -------");
		Point3D_Before before = new Point3D_Before();
		before.setX(10);
		before.setY(20);
		before.setZ(30);
		System.out.println(before.getX() + ", " + before.getY() + ", " + before.getZ());
		
		System.out.println("-------- After (상속 사용) --------");
		Point3D point3d = new Point3D();
		point3d.setX(10); // 상속받은 부모(Point2D) 소유의 메소드로, 부모 소유의 x 변수에 저장
		point3d.setY(20); // 상속받은 부모(Point2D) 소유의 메소드로, 부모 소유의 y 변수에 저장
		point3d.setZ(30); // Point3D 자신의 메소드로, 자신의 z 변수에 저장
		System.out.println(point3d.getX() + ", " + point3d.getY() + ", " + point3d.getZ());
	}

}


