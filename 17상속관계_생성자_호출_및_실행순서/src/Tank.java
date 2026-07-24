
//[4] Tank 클래스 - Unit 부모 클래스를 상속 받아 자식 클래스로 만들기
public class Tank extends Unit {

	// new Tank("시저탱크", 150, 35)
	public Tank(String name, int hp, int damage) {
		
		super(name, hp, damage);
	}
}
