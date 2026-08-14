
// 주제:	Stream API 에서 제공하는 메소드들 살펴보기 1

import java.util.stream.Stream; // 인터페이스
import java.util.stream.Collectors; // 클래스 

import java.util.Arrays; // 클래스
import java.util.List; // 인터페이스

public class Ex3 {

	public static void main(String[] args) {
		
		//1. 데이터 준비
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		/*
			2. 중간 연산 - 데이터 필터링 시 사용할 filter(Predicate<T> predicate) 추상 메소드
		
			2-1. 스트림의 각 요소에 대해 주어진 조건식을 평가하며,
				 Predicate 함수형 인터페이스를 사용합니다.
				 Predicate 함수형 인터페이스는 boolean 값을 반환하는 test(T t) 추상 메소드가 작성되어 있어서
				 이 조건식에 맞는 요소들만 다음 연산으로 넘깁니다.
				 
			2-2. filter 추상 메소드는 여러 번 체이닝 기법 . 으로 호출할 수 있어, 복잡한 조건식을 단계적으로 나눠서 적용할 수도 있다.
			
				예: .filter(n -> n > 2).filter(n -> n % 2 == 0) ...
		*/
		//순서1.	준비된 데이터 List 고정 배열의 Integer 숫자를 이용해 IntegerStream 입력 스트림을 만들어 반환받자
		// 요약:	IntegerStream 통로 준비
		List<Integer> newNumbers = numbers.stream()
		//순서2.	IntegerStream 통로 객체의 filter 메소드를 호출하면
		//		모든 Integer 객체에 오토 박싱되어 저장된 숫자들이 2보다 큰지 조건식으로 확인하고
		//		조건식을 만족하지 않는 Integer 객체들을 제외한 Integer 객체들이 저장된 IntegerStream 통로 객체를 반환
										  .filter(n -> n > 2)
		//순서3.	순서2. 에서 filter 메소드가 반환해준 IntegerStream 통로의 Integer 객체의 숫자들 중에서
		//		2의 배수가 포함된 Integer 객체들만 IntegerStream 통로에 남긴 IntegerStream 통로 객체를 반환
										  .filter(n -> n % 2 == 0)
		//순서4. 최종 결과 얻어 ArrayList 배열로 얻기
										  .collect(Collectors.toList()); // [4, 6]
		
		//순서5.	최종 결과 ArrayList 배열 데이터 출력
		System.out.println(newNumbers.toString()); // "[4, 6]" <--- ArrayList 배열을 문자열 형태로 보여줌
		
		/*
			collect(Collector<T, A, R> collector)
			
				- 메소드는 스트림의 결과를 리스트(list), 셋(Set) 또는 다른 컬렉션 배열에
				  수집해서 반환해줍니다.
			
				- 스트림의 요소들을 특정 형식으로 수집하여, 결과를 새로운 컬렉션으로 반환함
				  즉, 스트림을 처리한 후 최종 결과를 얻기 위해서 사용합니다.
			
				- collect 메소드는 스트림의 종료 연산을 수행하기 위한 종류 중 하나의 메소드입니다.
			
			Collectors 클래스의 toList()
			
				1. Collectors 클래스는 여러 가지 형태로 데이터를 수집하기 위한 유틸리티 클래스로
				   다양한 컬렉션으로 데이터를 수집할 수 있는 메소드를 제공합니다
				   
				2. toList() 메소드는 스트림의 모든 요소를 ArrayList 같은 리스트 형태로 수집합니다.
				   모든 데이터들을 List 부모 인터페이스 타입으로 변환해 ArrayList 배열을 반환해줍니다.
		*/
		
		// 데이터 준비
		List<String> names = Arrays.asList("Alice", "Bob", "Chrlie");
		// ["Alice", "Bob", "Chrlie"] <- 문자열 객체들이 저장된 ArrayList 고정 칸 배열
		//		0		1		2
		
		// 최종 할 일 -> 각 문자열의 문자 개수를 계산하여 새로운 ArrayList 배열에 최종 담아 반환
		
		//순서1.	준비된 데이터를 이용해 Stream 스트림 통로 객체를 만들어 반환
		List<Integer> stream = names.stream()
		
		//순서2.	위 Stream 통로 객체에 있는 각 문자열의 문자 개수가 저장된 IntegerStream 통로 객체를 반환
					  						 .map((String t) -> {return t.length();})
		//									 .map( String :: length)
					  						 
		//순서3.	IntegerStream 통로에서 꺼내온 Integer 객체들을 ArrayList 배열에 담아 반환
					  						 .collect(Collectors.toList());
		
		System.out.println(stream.toString()); // "[5, 3, 6]" <--- ArrayList 
	}// === main Method

}// --- Ex3 Class




