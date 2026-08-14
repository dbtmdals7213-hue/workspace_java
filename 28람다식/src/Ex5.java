
// 주제:	람다식, Stream API 활용 - 스트림 통로를 변수에 담아 단계별로 처리하기

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors; // 스트림 통로의 결과 데이터를 컬렉션 배열에 수집할 때 사용하는 클래스
import java.util.stream.Stream; // 데이터 스트림 통로의 부모 인터페이스 자료형 

public class Ex5 {

	public static void main(String[] args) {
		
		//1. 데이터 준비
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		//2. 데이터들(Integer 객체들)을 읽어들일 데이터 스트림 통로(IntegerStream 통로) 만들기
		Stream<Integer> stream = numbers.stream();
		
		//3. 중간 연산에 사용할 filter 메소드를 이용하여 조건식의 결과가 참인 데이터들을 추출한 IntegerStream 데이터 스트림 통로 반환
		// -> 위 IntegerStream 데이터 스트림 통로에 흘러가는 new Integer(...) 객체들 중에서 2의 배수인 짝수 데이터만
		//	  새로운 IntegerStream 에 담아 반환 받자
		stream = stream.filter((Integer n) -> {return n % 2 == 0;});
		
		//4. 최종 연산의 결과 데이터들이 저장된 산출물 얻기 collect 메소드 사용
		List<Integer> eventNumbers = stream.collect(Collectors.toList());
		
		// ArrayList 의 toString(): 배열에 담긴 내용을 사람이 쉽게 볼 수 있도록 ArrayList 배열 자체 모습을 문자열로 변환해서 반환
		System.out.println(eventNumbers.toString());
		
		
	}// === main Method

}// --- Ex5 Class




