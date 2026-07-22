package com.myapp;
/*
	com.external.models 패키지에 포함된 User 클래스와
	com.myapp.models 패키지에 포함된 User 다른 클래스
	
	즉, 두 User 클래스의 이름이 같기 때문에 둘 다 한 번에 import 구문을 작성하면
	충돌이 일어나 자바 컴파일러가 어떤 패키지 안의 User 클래스를 사용하는지 모름!
	
	충돌 해결 방법. 하나의 User 클래스만 import 구문을 작성하고, 다른 하나의 User 클래스는
				패키지 경로를 포함한 클래스 이름 전체 경로를 코드 사용지 직접 기술
*/

import com.myapp.models.User;

public class MainApp {

	public static void main(String[] args) {
		
		//1. import com.myapp.models.User; 이렇게 작성한 User 클래스 사용해 객체 생성 가능
		User localUser = new User("홍길동");
		localUser.printInfo();
		
		//2. 다른 하나의 User 클래스는 패키지 경로를 포함한 클래스 이름 전체 경로를 코드 사용지 직접 기술
		//	패키지명.클래스명 참조변수 = new 패키지명.생성자명(1234);
		com.external.models.User externalUser = new com.external.models.User(1234);
		externalUser.printInfo();
	}

}
