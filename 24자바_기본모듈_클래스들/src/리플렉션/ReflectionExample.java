package 리플렉션;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//================================
// 리플렉션으로 분석할 대상 특정 클래스 만들기
//================================
class Car2 {
	
	// --------------- 변수(필드) ---------------
	private String model; // 자동차 모델명을 저장할 변수(필드)
	private String owner; // 자동차 소유자 명을 저장할 변수(필드)
	
	// ---------- 생성자(Constructor) ----------
	public Car2() {} // 기본 생성자
	public Car2(String model) { this.model = model; } // model 인스턴스 변수 초기화 할 생성자
	
	// ------------- 메소드(Method) -------------
	public String getModel() { return this.model; } // model 인스턴스 변수 값 외부 클래스로 반환 할 getter 메소드
	public void setModel(String model) { this.model = model; } // model 인스턴스 변수 값 변경할 setter 메소드
	public String getOwner() { return this.owner; } // owner 인스턴스 변수 값 외부 클래스로 반환 할 getter 메소드
	public void setOwner(String owner) { this.owner = owner; } // owner 인스턴스 변수 값 변경할 setter 메소드
}// --- Car2 클래스

//======================
// 리플렉션 기법을 실행할 클래스
//======================
public class ReflectionExample {

	private static void printParameters(Class[] parameters) {// [ , class java.lang.String] 배열
		
		// 매개변수 Class[] parameters 로 전달받은 배열에 저장된 new Class(); 객체 개수만큼 반복
		for(int i = 0; i < parameters.length; i++) {
			
			// 매개변수 이름(자료형 이름)이 작성된 생성자의 클래스 경로 전체 출력
			System.out.print(parameters[i].getName());
			
			// 생성자의 마지막 매개변수가 아닐 경우 매개변수 사이를 구분하기 위한 , 콤마 출력
			if(i < parameters.length - 1) {
				
				System.out.print(",");
			}// if 조건문
		}// for 반복문
		
	}// === printParameters 메소드
	
	public static void main(String[] args) {
		
		// 클래스 이름만 가지고 Class 객체를 얻는 방법
		//방법1.	Class claszz = 클래스 이름.class;
		// 설명: class Car2 {...} 분석할 대상 클래스의 정보를 가진 new Class() 객체 얻기
		Class claszz = Car2.class;
		
		//=====================================================
		// class Car2 {...} 에 만들어 놓은 생성자 정보(메타 정보) 얻어 출력
		//=====================================================
		System.out.println("[생성자 정보]");
		
		Constructor[] constructors = claszz.getDeclaredConstructors();
		
		for(Constructor constructor : constructors) {// class Car2 {...} 에 만들어져 있는 생성자 개수만큼 반복
			
			// 생성자가 만들어져 있는 패키지 경로를 포함한 클래스명 전체 출력 -> getName() 메소드 호출 -> 리플렉션.Car2
			System.out.print(constructor.getName() + "(");
			
			// 해당 생성자의 매개변수 타입 목록 조회
			Class[] parameters = constructor.getParameterTypes();
			//				   = [ , class java.lang.String] 배열
			
			// 생성자의 매개변수 이름 목록 출력하기 위해 위에 만들어 놓은 메소드 호출!
			printParameters(parameters);
			
			System.out.println(")");
		}// for 반복문
		
		System.out.println(); // 한 줄 줄바꿈 출력
		
		//======================================================
		// class Car2 {...} -> Car2.class 의 변수(필드) 정보 얻어 출력
		//======================================================
		System.out.println("[변수(필드) 정보]");
		
		Field[] fields = claszz.getDeclaredFields();
		
		for(Field field: fields) {
			
			// 변수 자료형 타입 + 변수 이름 출력
			System.out.println(field.getType().getName() + " " + field.getName());
		}
		
		System.out.println(); // 한 줄 줄바꿈 출력
		
		//==================================================
		// class Car2 {...} -> Car2.class 의 메소드 정보 얻어 출력
		//==================================================
		System.out.println("[메소드 정보]");
		
		// class Car2 {...} 에 만들어 놓은 모든 메소드들을 하나 하나씩 각각 Method 객체어 정보를 담은 후
		// Method 배열에 최종 저장 후 반환 받습니다.
		Method[] methods = claszz.getDeclaredMethods();
		
		for(Method method : methods) {
			
			// 만들어 놓은 메소드 이름 출력
			System.out.print(method.getName() + "(");
		
			// 만들어 놓은 메소드의 매개변수 자료형 개수만큼 저장된 new Class() 객체의 배열 얻기
			Class[] parameters = method.getParameterTypes();
			
			// 위에 만들어 놓은 printParameters 메소드의 매개변수로 Class[] 배열을 전달해서
			// 메소드의 매개변수 자료형 출력하기 위해 메소드를 호출합니다.
			printParameters(parameters);
			
			// class Car2 {} 에 만들어 놓은 메소드 매개변수 자리 ) 출력
			System.out.println(")");
		}
		
	}// === main 메소드

}// --- ReflectionExample


