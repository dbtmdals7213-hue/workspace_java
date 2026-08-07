
import java.util.ArrayList;
import java.util.Vector;

// 주제: 제네릭 기법이 작성된 클래스 실제 만들기

class GenericClass<T> {// <- <T> 의미: GenericClass 클래스 설계도 내부에는 아직 결정되지 않는 제네릭 타입을 가진 변수나 메소드 존재
	
	private T member; // 현재 member 인스턴스 변수는 아직 결정되지 않은 T 제네릭 타입을 지정해서 만든 변수
	
	public void setMember(T value) {// 매개변수 value 또한 아직 결정되지 않은 T 제네릭 타입 문자를 지정해서
									// 매개변수 value 를 만들어 놓고 사용할 수 있다.
		
		this.member = value;
	}// === setMember 메소드
	
	// 메소드의 반환 자료형 타입도 아직 결정되지 않은 T 제네릭 타입 문자를 지정해서 메소드를 만들어 놓고 사용할 수 있다.
	public T getMember() {
		
		return this.member;
	}// === getMember 메소드
}// --- GenericClass 클래스


//============================================================================================================


//	<Tv, String>
//	<Car, String>

class Product<K, V> {// <- <K, V> Product 클래스 설계도 내부에는 아직 결정되지 않은 제네릭 타입을 가진 변수나 메소드 존재!
					 //	   <K, V> 제네릭 타입을 작성한 이유: 다양한 종류의 모델 제품 저장하기 위해 제네릭 타입 지정!
	
	// 변수
	private K kind; // Tv kind;
					// Car kind;
	
	private V model; // String model;
					 // String model;
	
	// 메소드
	public K getKind() {
		
		return this.kind;
	}// === getKind 메소드
	
	public void setKind(K kind) {
		
		this.kind = kind;
	}// === setKind 메소드
	
	public V getModel() {
		
		return this.model;
	}// === getModel 메소드
	
	public void setModel(V model) {
		
		this.model = model;
	}// === setModel 메소드
	
}// --- Product 클래스


class Tv {}
class Car {}


//============================================================================================================

interface Rentable<P> {
	
	P rent(); // 추상 메소드
}

// 렌트 대상인 Home 클래스와 Car2 클래스 작성
class Home {
	
	public void turnOnLight() {
		
		System.out.println("전등을 켭니다.");
	}// === turnOnLight 메소드
	
}// --- Home 클래스

class Car2 {
	
	public void run() {
		
		System.out.println("자동차가 달립니다.");
	}// === run 메소드
	
}// --- Car2 클래스


// 집을 렌트해주는 대리점 클래스
class HomeAgency implements Rentable {
	
	@Override
	public Home rent() {
		
		return new Home();
	}
	
}// --- HomeAgency 클래스


// 자동차를 렌트해주는 대리점 클래스
class CarAgency implements Rentable {
	
	@Override
	public Car2 rent() {
		
		return new Car2();
	}// === rent 메소드
	
}// --- CarAgency 클래스


public class GenericTest04 {

	public static void main(String[] args) {
		
		// 집을 렌트(대여) 해주는 대리점 역할의 HomeAgency 클래스의 객체 생성
		HomeAgency homeAgency = new HomeAgency();
		
		// 대리점으로부터 집을 렌트함
		Home home = homeAgency.rent();
		
		// 렌트한 집으로 들어가서 전등을 켭니다.
		home.turnOnLight(); // "전등을 켭니다."
		
		//------------------------------------------------
		
		// 자동차 렌트(대여)해주는 대리점 역할의 CarAgency 클래스의 객체 생성
		CarAgency carAgency = new CarAgency();
		
		// 자동차 렌트(대여) 하자
		Car2 car2 = carAgency.rent();
		
		// 렌트한 자동차로 가서 달립니다.
		car2.run(); // "자동차가 달립니다."
		
		
		
		System.out.println("--------------------------");
		
		// K 는 Car 로, V 는 String 으로 대체
		Product<Car, String> product2 = new Product<Car, String>();
		
		// setter 역할을 하는 메소드를 호출해서 Car 제품 정보 저장
		product2.setKind(new Car());
		product2.setModel("SUV 자동차");
		
		// getter 역할을 하는 메소드를 호출해서 인스턴스 변수 kind, model 에 저장된 객체를 꺼내옵니다.
		Car car = product2.getKind(); // new Car;
		String carModel = product2.getModel(); // "SUV 자동차"
		
		// new Car().equals(new Car());
		boolean result = product2.getKind().equals(product2.getKind());
		
		System.out.println(result); // true
		
		if(product2.getModel().equals("SUV 자동차")) {
			
			System.out.println("두 문자열 객체 내부에 저장된 특정 SUV 자동차 문자열 2개가 같다"); // 출력됨
		}else {
			
			System.out.println("두 문자열 객체 내부에 저장된 특정 SUV 자동차 문자열 2개는 같지 않다");
		}
		
		System.out.println("--------------------------");
		
		// K 는 Tv 로, V 자리에는 String 으로 대체
		Product<Tv, String> product1 = new Product<Tv, String>();
		
		product1.setKind(new Tv());
		product1.setModel("스마트 TV");
		
		Tv tv = product1.getKind(); // Tv kind 인스턴스 변수에 저장된 -> new Tv(); 객체 주소 반환 받아 저장
		
		String tvModel = product1.getModel(); // String model 인스턴스 변수에 저장된 -> "스마트 TV" 객체 주소 반환 받아 저장
		
		System.out.println(tv); // Tv@279f2327
		System.out.println(tvModel); // 스마트 TV
		
		System.out.println("--------------------------");
		
		GenericClass<Double> obj01 = new GenericClass<Double>();
		
		obj01.setMember(3.5); // 3.5는 자동(오토) 박싱이 new Double(3.5); 래퍼 객체로 전달됨
		// obj01.setMember(new Double(3.5));
		
		Double double1 = obj01.getMember(); // new Double(3.5); 객체 주소 번지 반환
		
		System.out.println(double1.doubleValue()); // 3.5
		
		System.out.println("--------------------------");
		
		GenericClass<Integer> obj02 = new GenericClass<Integer>();
		
		obj02.setMember(new Integer(10));
		
		System.out.println(obj02.getMember()); // new Integer(10); 반환 받아
											   // 오토 언박싱이 일어나 10을 꺼내와 10을 출력
		
		System.out.println("--------------------------");
		
		// 우리 개발자가 직접 만든 GenericClass<T> 처럼 Vector 클래스나 ArrayList 클래스 또한 제네릭 클래스 기법으로 설계되어 있다.
		
		Vector<String> obj04 = new Vector<String>();
		obj04.add("문자열1"); // <- add(E e) 메소드에서 add(String e) 로 변경됨
		obj04.add("문자열2");
		
		System.out.println("Vector 배열에 저장된 객체 수 : "+ obj04.size());
		System.out.println("Vector 배열의 모든 칸 수 : " + obj04.capacity());
		
		ArrayList<Integer> obj05 = new ArrayList<Integer>();
		
		obj05.add(new Integer(3));
		obj05.add(new Integer(4));
		obj05.add(5);
		
		Integer integer = obj05.get(0); // 업 캐스팅 X, 다운 캐스팅 X -> 하지않고 Integer 클래스 자료형 변수에 반환받은 객체 저장
		
		int value = integer.parseInt("100"); // "100" -> 100
		
		System.out.println(value + 110); // 100 + 110 = 210
		
	}// === main 메소드

}// --- GenericTest04 클래스


