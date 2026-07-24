
//[1] Unit 클래스 - 유닛 설계도
public class Unit {
	
	// 객체 변수들
	String name; // 유닛 이름(예: "마린", "저글링", "탱크")
	int hp; // 유닛 체력
	int damage; // 유닛 기본 공격력
	
	// 생성자들
	//1. 유닛 이름, 체력, 공격력을 초기화 할 생성자
	public Unit(String name, int hp, int damage) {
		
		super(); // 부모 Object 클래스의 기본 생성자 호출!
		this.name = name; // 유닛 이름 저장
		this.hp = hp; // 유닛 체력 저장
		this.damage = damage; // 유닛 기본 공격력 저장
	}

	//2. 유닛 이름, 체력만 초기화 할 생성자
	public Unit(String name, int hp) {
		
		super();
		this.name = name;
		this.hp = hp;
	}

	//3. 유닛 이름만 초기화 할 생성자
	public Unit(String name) {
		
		super();
		this.name = name;
	}
	
	
	
	
	
	
}
