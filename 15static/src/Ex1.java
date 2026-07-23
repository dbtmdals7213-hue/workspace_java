
public class Ex1 {

	// 멤버 변수 종류
	//종류1. 객체 변수
	//	- static 이 없으므로 객체 메모리에 포함된 변수
	//	- new Ex1(); 객체 메모리 생성하면 객체 메모리에 포함
	//	- JVM 메모리 영역 중에서 Heap 영역에 올라가는 객체 메모리 내부의 개별적 공간을 가지는 변수
	int x;
	
	//종류2. 클래스 변수
	//	- static 작성해서 만든 변수
	//	- public class Ex1 가 처음 JVM 메모리의 Method Area 영역에 올라갈 때 포함된 변수
	//	- 객체 메모리를 생성하지 않고도 클래스명.클래스변수명 을 작성해서 접근 가능한 변수
	static int y;
	
	// 생성자
	public Ex1(int z) {// <--- new Ex1(10); 
		
		this.x += z; // JVM 메모리의 Heap 영역에 올라가는 객체 변수 x 에 z 매개변수로 전달받은 값 누적
		
		Ex1.y += z; // JVM 메모리의 Method Area 영역에 올라가는 클래스 변수 x 에 z 매개변수로 전달받은 값 누적
	}
	
	public static void main(String[] args) {
		
		Ex1 ex1 = new Ex1(10);

		System.out.println("객체 변수 x = " + ex1.x); // 객체 변수 x = 10
		System.out.println("클래스 변수 y = " + Ex1.y); // 클래스 변수 y = 10
		
		Ex1 ex2 = new Ex1(10);
		
		System.out.println("객체 변수 x = " + ex2.x); // 객체 변수 x = 10
		System.out.println("클래스 변수 y = " + Ex1.y); // 클래스 변수 y = 20
		
		Ex1 ex3 = new Ex1(10);
		
		System.out.println("객체 변수 x = " + ex3.x); // 객체 변수 x = 10
		System.out.println("클래스 변수 y = " + Ex1.y); // 클래스 변수 y = 30
	}

}
