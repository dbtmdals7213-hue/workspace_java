/*
	my_application_2 모듈 프로젝트는
	my_module_a 모듈과 my_module_b 모듈 프로젝트에서 제공하는 패키지들을 사용해야 하므로
	두 모듈 프로젝트에 대해 의존(의지) 설정이 필요하다.
*/
module my_application_2 {
	
	// 의존 설정
	// 컴파일 에러가 발생하는데
	// 필요한 의존 모듈 라이브러리 파일의 경로를 아직 모르기 때문에
	// 즉, 모듈 빌드 패스를 설정하지 않았기 때문에 컴파일 에러가 발생합니다.
	// 해결방법: 모듈 빌드 패스 설정 해주자.
	// requires my_module_a; <--- 직접 의존하기 설정 해제
	// requires my_module_b; <--- 직접 의존하기 설정 해제
	
	requires my_module; // <--- 집합 모듈인 my_module 을 의존하게 설정
}