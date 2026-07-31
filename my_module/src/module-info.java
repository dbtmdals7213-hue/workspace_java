// my_module 집합 모듈 프로젝트는 my_module_a 와 my_module_b 를
// 제공할 목적입니다. 둘 다 아래에 의존 설정 하자.
module my_module {
	
	requires transitive my_module_a;
	requires transitive my_module_b;
}