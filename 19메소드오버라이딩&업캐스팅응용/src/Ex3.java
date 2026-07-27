
/*
	주제.	 자식 클래스 BB 내부에서 print 메소드를 오버라이딩 해놓았을 때
		 상속되지 않고 은닉(보호)된 부모 클래스 AA 의 print 메소드를 강제로 호출해서 실행시키는 방법
	
	방법.	 자식 클래스 BB 에 오버라이딩 한 print 메소드 중괄호 내부에서 super.부모 print(); 메소드 호출해서 사용
*/

class AA {// 부모 클래스
	
	public void print(int num) {
		
		System.out.println(num);
	}
	
}

class BB extends AA {// 자식 클래스
	
	// AA 부모 클래스에 만들어 놓은 print 메소드 오버라이딩 해놓자.
	// alt + shift + s v
	@Override
	public void print(int num) {
		
		super.print(num); // super 예약어를 이용해 상속되지 않고 보호된 부모 AA 객체 메모리 영역에 있는 print 메소드를 강제로 호출해서 사용할 수 있음.
		System.out.println(num + 1); // 자식 BB 클래스의 print 메소드 기능에 맞게 구현부 코드 재정의
	}
	
	// BB 자식 클래스에 작성한 메소드
	public void bInfo() {
		
		System.out.println("BB 자식 클래스의 bInfo 메소드이다.");
	}

	
}

public class Ex3 {

	public static void main(String[] args) {
		
		BB bb = new BB();
		bb.print(10);
	}

}
