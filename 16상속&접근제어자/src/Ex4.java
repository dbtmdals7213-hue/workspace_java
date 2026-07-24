
// 주제: 부모 클래스와 자식 클래스가 같은 패키지에 있는 경우 다양한 접근 제어자를 지정한 멤버(변수 또는 메소드) 접근 범위 알아보기

class AA {// 기존에 만들어져 있는 부모 역할의 클래스
	
	int i; // 자료형 int 앞에 아무것도 작성하지 않으면? default 접근 제어자를 작성한 것입니다.
	
	protected int pro; 
}

class BB extends AA {// 부모 AA 클래스를 상속받아 새롭게 설계하는 자식 역할의 BB 클래스
	
	
	
}



public class Ex4 {

	public static void main(String[] args) {
		
		BB bb = new BB();
		
		
	}

}


