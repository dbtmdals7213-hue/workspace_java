
// 주제:	람다식을 Stream API 에서 활용하여 데이터 필터링(추출) 및 변환 예

import java.util.Arrays;
import java.util.List;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2 {

	public static void main(String[] args) {
		
		/*
			====================================
			[1] 데이터 준비 단계
			====================================
			
			Arrays.asList(값1, 값2, 값3, 값4, ...)
			------------------------------------
			- asList 메소드 호출 시 매개변수로 전달한 값들을 포함하는 고정 크기의 List 배열을 생성해서 반환해줌
			- 반환된 고정 크기의 List 배열에 새로운 값을 추가나 삭제할 수 없습니다.
			- 값 추가(add()) / 값 삭제(remove()) X 불가능
			- 값 조회(get(index)) / 값 수정 (set(변경값)) O 가능
		*/
		List<Integer> scores = Arrays.asList(65, 70, 80, 90, 85, 50, 40);
		
		/*
			====================================
			[2] 문제 목표
			====================================
			- 전체 점수 중 60점 이상만 걸러내고 그 점수들의 평균을 계산한다.
			- 위 고정 크기 List 배열에 저장된 점수들 중에서 60점 이상의 성적만 필터링(추출, 걸러냄)하고 평균을 계산하려고 한다.
		*/
		//순서1.	컬렉션 배열이나 고정 크기 배열에 저장된 데이터가 흘러가 읽어들일 스트림 통로 얻기
		// scores.stream(); 메소드를 호출하면 생성되는 스트림 통로는 고정 크기 배열에 저장된 Integer 객체(점수)들이
		//					순서대로 흘러가는 IntegerStream 입력 스트림 통로를 생성해서 반환해줌
		Stream<Integer> stream = scores.stream();
		
		//순서2.	중간 연산 - 필터링(데이터 추출)
		// 필터링: .filter(람다식으로 익명 메소드 작성);
		//		 메소드를 사용하여 각 성적을 검사하고, 60점 이상인 성적만 IntegerSteam 통로에 남길 수 있음
		stream = stream.filter(score -> score >= 60);
		
		// 순서2-1. 변환 연산 - IntegerStream 스트림 통로를 IntStream 스트림 통로로 변환
		/*
			mapToInt() 메소드
			- IntegerStream 스트림에 있는 Integer 객체를 정수형(int)으로 변환하여
			  IntStream 통로에 담아 IntStream 통로 주소 자체를 반환하는 메소드
			- 일반적으로 객체가 저장된 스트림을 처리할 때, 숫자 계산이나 통계 처리를 하기 위해
			  객체들을 기본 자료형 스트림(IntStream, DoubleStream, LongStream)으로 변환할 때 사용되는 메소드
		*/
		IntStream stream2 = stream.mapToInt((score) -> {return score.intValue();});
		
		//순서3.	최종 연산 결과 값 산출 - 60점 이상인 점수들의 평균 값 산출!
		
		
		
	}// === main Method

}// --- Ex2 Class




