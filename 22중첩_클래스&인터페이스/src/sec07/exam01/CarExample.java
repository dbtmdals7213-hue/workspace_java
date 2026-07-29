package sec07.exam01;

class A {// 부모 클래스

	int num;
	void print() {
		
		System.out.println("출력");
	}
	
}

public class CarExample {

	public static void main(String[] args) {
		
		// 의미1. A 를 상속 받은 부모 클래스의 생성자를 호출해 이름이 없는 익명 자식 클래스를 만드는 동시에
		// 의미2. 이름이 없는 익명 자식 객체 메모리를 생성한다는 의미
		new A() {

			@Override
			void print() {
				
				System.out.println("이름이 없는 익명 자식 구현 객체의 메소드이다.");
			}
		};
		
		
	}

}
