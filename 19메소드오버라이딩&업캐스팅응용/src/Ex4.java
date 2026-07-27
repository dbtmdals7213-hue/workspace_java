
// 주제:	부모 클래스의 변수를 상속 받아 사용하는 예

class Point2D {// 부모 클래스
	
	protected int x = 10;
	protected int y = 20;
}

class Point3D extends Point2D {// 자식 클래스
	
	// 부모 클래스의 변수명과 똑같은 변수명으로 자식 클래스에 변수를 만들어 놓으면
	// 부모 클래스의 변수들은 자식 클래스에 상속되지 않고, 은닉(보호)되어 사용할 수 없게 된다.
	protected int x = 40;
	protected int y = 50;
	protected int z = 30;
	
	// 메소드 기능: x, y, z 변수에 저장된 값 각각 불러와 하나의 문자열로 출력
	// 참고. 부모 클래스의 변수명과 자식 클래스의 변수명이 같을 때 아래와 같이 다르게 출력하자
	public void print() {
		
		System.out.println(super.x + ", " + super.y + ", " + this.z);
		// 10, 20, 30 출력
		
		System.out.println(this.x + ", " + this.y + ", " + this.z);
		// 40, 50, 30 출력
	}
}

public class Ex4 {

	public static void main(String[] args) {
		
		new Point3D().print();
	}

}


