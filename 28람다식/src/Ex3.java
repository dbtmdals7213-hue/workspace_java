
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
		*/
		
		
		
	}// === main Method

}// --- Ex3 Class




