
/* 주제:	업 캐스팅과 다운 캐스팅을 하는 이유 응용 */

// 부모 클래스
class Character {
	
	// 모든 캐릭터의 공격하는 행동을 메소드로 정의
	public void attack() {
		
		System.out.println("공격한다.");
	}
}

// 자식 클래스1: 전사 클래스
class Warrior extends Character {
	
	// 부모 Character 클래스의 attack 메소드 오버라이딩해서 전사의 기능에 맞게 작성
	@Override
	public void attack() {

		System.out.println("검으로 공격한다.");
	}
	
	// 방어 기능의 메소드로 정의
	public void raiseShield() {
		
		System.out.println("방패를 올린다.");
	}
}

// 자식 클래스2: 마법사 클래스
class Mage extends Character {
	
	@Override
	public void attack() {

		System.out.println("마법으로 공격한다.");
	}
	
	public void castSpell() {
		
		System.out.println("마법을 시전한다.");
	}
}

// 모든 캐릭터의 행동을 처리하는 기능의 구현된 클래스
class GameSystem {
	// 매개변수는 업 캐스팅이 일어나 자식 객체 메모리 주소를 전달받음
	public void play(Character character) {// <- new Warrior(); 전사
										   // <- new Mage(); 마법사
		character.attack(); // 호출 가능 이유: 매개변수로 전달받은 자식 객체 메모리 영역일지라도 메소드 오버라이딩 된 메소드이므로 호출할 수 있다.
		// character.raiseShield(); -> 호출해서 사용할 수 없다. 이유: 매개변수 Character character 부모 클래스 자료형으로 만들어 놓았기 때문에
														//	  부모 Character 클래스 내부에 작성된 attack 메소드만 호출 가능
		// character.castSpell(); -> 호출해서 사용할 수 없다
		
		// instanceof 예약어 작성 문법
		// 객체 instanceof 클래스명
		// 해설 -> 앞에 작성한 객체가 뒤에 작성한 클래스로 만들어진 객체이냐? 라고 물어보는 instanceof 예약어로
		// 		  맞으면 true 반환하고, 틀리면 false 를 반환합니다.
		
		// ↓↓↓ 필요한 경우만 다운 캐스팅 ↓↓↓
		// 조건: Character character 매개변수로 전달받은 객체가 Warrior 자식 클래스로 만들어진게 맞아?
		if(character instanceof Warrior) {
			
			// 다운 캐스팅
			// 장점: 자식 객체인 전사 new Warrior() 객체의 모든 멤버를 사용 가능하게 됩니다.
			Warrior w = (Warrior)character;
			
			// 전사 전용 기능 사용
			w.raiseShield();
		}
		
		if(character instanceof Mage) {
			
			Mage m = (Mage)character; // 맞을 때만 다운 캐스팅
			
			// 마법사 전용 기능 사용
			m.castSpell();
		}
	}
}

public class Test3 {

	public static void main(String[] args) {
		
		GameSystem game = new GameSystem();
		
		// 업 캐스팅을 하여 Character 부모 클래스의 참조변수를 만들고 new Warrior(); 전사 객체를 생성해서 저장
		Character character = new Warrior();
		
		game.play(character);
		
		// 업 캐스팅을 하여 Character 부모 클래스의 참조변수에 new Mage(); 마법사 자식 객체를 생성해서 저장
		character = new Mage();
		
		game.play(character);
		
	}

}


