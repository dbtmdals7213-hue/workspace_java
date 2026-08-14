
// 주제:	Stream API 에서 제공하는 메소드들 살펴보기 2 - distinct() / sorted()

import java.util.ArrayList; // 클래스. asList() 메소드로 고정 크기 배열을 만들 때 사용
import java.util.Arrays;
import java.util.Comparator; // 인터페이스. 정렬 기준을 담는 함수형 인터페이스
import java.util.List; // 인터페이스. 목록의 공통 규격(추상 메소드들)
import java.util.stream.Collectors; // 클래스. 스트림 통로의 결과를 컬렉션 배열에 수집할 때 사용

public class Ex4 {

	public static void main(String[] args) {
		
		//1. 데이터들 준비
		List<String> items = Arrays.asList("apple", "banana", "apple", "orange");
		
		//순서1.	준비된 items 고정 배열의 String 객체를 읽어들이기 위한 Stream 입력 스트림 통로를 만들어 반환받자.
		// 요약:	Stream<String> 통로 준비
		List<String> distinctItems = items.stream()
		
		//순서2.	Stream 통로 객체의 distinct 메소드를 호출하면
		//		통로를 지나가는 문자열들을 equals 메소드로 비교하여
		//		앞에서 이미 지나간 값과 내용이 같은 것을 제외한 Stream 통로 객체를 반환
		.distinct()
		
		//순서3.	위 Stream<String> 통로에 흘러가는 모든 문자열 데이터들을 ArrayList 배열에 담아 반환(종료 연산)
		.collect(Collectors.toList());
		
		//순서4. 최종 결과 ArrayList 배열 데이터 출력
		System.out.println(distinctItems); // "[apple, banana, orange]" <- ArrayList
		
		//==================================================================================
		
		//1. 데이터 준비
		List<Integer> numbers = Arrays.asList(3, 5, 1, 4, 2);
		
		//================================
		//[형태 1] sorted() - 기본 오름차순 정렬
		//================================
		//순서1.	numbers 고정 칸 배열의 Integer 객체를 읽어들이기 위한 Stream 통로 준비
		
		List<Integer> sortedNumbers = numbers.stream()
				
		//순서2.	괄호가 빈 sorted 를 호출하면 기본 오름차순(작은 값이 앞)으로
		//		정렬된 Stream 통로 객체를 반환, Integer 클래스이 이미
		//		"숫자는 작은 것이 먼저" 라는 기준이 만들어져 있어서
		//		기준을 따로 주지 않아도 정렬이 된다.
											 .sorted()
		
		//순서3.	통로의 모든 데이터를 ArrayList 배열에 담아 반환
											 .collect(Collectors.toList());
		
		System.out.println(sortedNumbers); // "[1, 2, 3, 4, 5]" <- ArrayList
		
		//================================================================
		//[형태 2] sorted( Comparator.reverseOrder() ) - 내림차순 정렬
		//================================================================

		//순서1. 같은 numbers 배열로 Stream 통로를 "새로" 준비한다
		//      (스트림 통로는 1회용이라 위에서 쓴 통로를 다시 쓸 수 없다)
		List<Integer> newNumbers = numbers.stream()
/*
									Stream<Integer> 통로 객체 ->
									------------------------------
									  -> 2 -> 4 -> 1 -> 5 -> 3
									------------------------------
*/
		//순서2. Comparator.reverseOrder() 는 "기본 순서를 뒤집은 정렬 기준" 객체를 만들어 준다.
		//      그 기준을 sorted 에 전달하면 내림차순(큰 값이 앞)으로 정렬된 통로 객체를 반환
		                                   .sorted( Comparator.reverseOrder() )
/*
									Stream<Integer> 통로 객체 -> (내림차순 정렬 후)
									------------------------------
									  -> 1 -> 2 -> 3 -> 4 -> 5
									------------------------------
									 (통로 맨 앞에서 5 부터 꺼내진다)
*/
		   //순서3. 통로의 모든 데이터를 ArrayList 배열에 담아 반환
		                                   .collect(Collectors.toList());
		   //[5, 4, 3, 2, 1]

		   System.out.println(newNumbers); // [5, 4, 3, 2, 1]  <-- ArrayList

		   //----------------------------------------------------------------------
		   //  최종 결과 상태
		   //----------------------------------------------------------------------
		   //  numbers       : [3, 5, 1, 4, 2]   (변경 없음. 원본은 그대로다)
		   //  sortedNumbers : [1, 2, 3, 4, 5]   (새로 생성된 리스트)
		   //  newNumbers    : [5, 4, 3, 2, 1]   (새로 생성된 리스트)
		   //----------------------------------------------------------------------

		   /*
		   참고.
		   Comparator 란?

		   Comparator 는 객체를 비교하기 위한 함수형 인터페이스입니다.

		   특정 기준에 따라 두 객체를 비교하고, 그 결과에 따라 정렬 순서를 결정합니다.

		   이 인터페이스는 compare(T o1, T o2) 메소드를 구현하여 두 객체의 크기를 비교합니다.

		   이 compare 메소드는 다음과 같은 값을 반환합니다:
		   		0   : 두 객체가 동일함
		   		양수 : 첫 번째 객체가 두 번째 객체보다 큼
		   		음수 : 첫 번째 객체가 두 번째 객체보다 작음

		   [정렬이 정해지는 과정 - 값 3 과 5 를 비교할 때]

		     기본 오름차순 sorted()
		       compare(3, 5) 호출 --> 3 이 5 보다 작으므로 음수 반환
		       --> 첫 번째 값(3)을 앞에 둔다 --> 작은 값이 앞 (오름차순)

		     reverseOrder() 를 준 sorted()
		       기본 결과의 부호를 뒤집는다 --> 양수로 바뀜
		       --> 두 번째 값(5)을 앞에 둔다 --> 큰 값이 앞 (내림차순)

		   Comparator.reverseOrder() 의 사용

		   Comparator.reverseOrder() 는 기본 정렬 순서(오름차순)를 반전시켜
		   내림차순 정렬을 위한 Comparator 객체를 생성합니다.

		   이 메소드는 숫자, 문자열 등 Comparable 인터페이스를 구현한 클래스의 객체를
		   내림차순으로 정렬하는 데 유용합니다.

		   [참고] 직접 람다식으로 기준을 만들 수도 있다
		     .sorted( (a, b) -> a - b )   <- 오름차순 (reverseOrder 없이 sorted() 와 같은 결과)
		     .sorted( (a, b) -> b - a )   <- 내림차순 (reverseOrder() 와 같은 결과)
		     외우는 법 : "앞에 오길 원하는 쪽을 뒤에 빼면 된다"
		    */
		
	}// === main Method

}// --- Ex4 Class




