package test1;

// 스타크래프트 게임 - 마린, 저글링, 탱크

public class Unit {

	//1. 클래스 변수 - 유닛의 데이터 정보 저장할 용도
	String name; // 이름
	int hp; // 기본 체력
	int damage; // 기본 공격력
	
	//2. 생성자 - 유닛의 데이터 정보를 초기화(처음 설정)
	// 첫 번째 생성자: 유닛의 이름만 매개변수로 받아 체력: 100, 공격력: 10 으로 객체 변수들의 값을 초기화 하는 생성자
	public Unit (String name) {
		
		this(name, 100, 10);
	}
	
	// 두 번째 생성자: 유닛의 이름과 체력만 매개변수로 받아 공격력:10 으로 객체 변수들의 값을 초기화 하는 생성자
	public Unit(String name, int hp) {
				//  "저글링" , 80
		
		this(name, hp, 10);
	}
	
	// 세 번째 생성자: 유닛의 이름, 체력, 공격력 모두 매개변수로 받아 모든 객체 변수들의 값을 초기화 하는 생성자
	public Unit(String name, int hp, int damage) {
		
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}
	
	//3. 메소드 - 유닛들의 행동을 표현
	// 첫 번째 메소드 명: attack
	// 기능: 특정 유닛 객체가 다른 유닛 객체를 공격
	public void attack(Unit target) {// <- new Unit("저글링", 80);
									 // <- new Unit("마린");
		
		//조건문1. 현재 생성된 Unit 클래스에 대한 객체(마린 객체)의 hp 객체 변수의 값이 0보다 작거나 같으면?
		if(this.hp)
		
		
	}
	
	
	public static void main(String[] args) {
		
		// 마린 유닛 역할을 하는 객체 하나 생성
		// 유닛 이름: 마린, 기본체력: 100, 기본 공격력: 10
		Unit marine = new Unit("마린");
		
		// 저글링 유닛 역할을 하는 객체 하나 생성
		// 유닛 이름: 저글링, 기본 체력: 80, 기본 공격력 10
		Unit zergling = new Unit("저글링", 80);
		
		// 전투 시뮬레이션 - 마린 유닛 객체가 저글링을 공격한다.
		marine.attack(zergling);
		
	}

}
