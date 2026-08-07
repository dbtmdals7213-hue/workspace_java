
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
	}
	
	public void setModel(V model) {
		
		this.model = model;
	}
	
}// --- Product 클래스



public class GenericTest04 {

	public static void main(String[] args) {
		
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


