
// 주제:	람다식을 Stream API 에서 활용하여 데이터 필터링(추출) 및 변환 예(짧게 작성하는 코드 방식)

import java.util.Arrays;
import java.util.List;

public class Ex2_1 {

	public static void main(String[] args) {
		
		//1. 데이터 준비(점수들 배열에 담아 준비)
		List<Integer> scores = Arrays.asList(65, 70, 80, 90, 85, 50, 40);
		
		//2. 60점 이상의 성적만 필터링(걸러내고)하고 평균을 계산해서 변수에 저장
		//순서2.	중간 연산 - 필터링(걸러내기)
		//순서2-1. 변환 연산 - IntegerStream 스트림 통로를 IntStream 스트림 통로로 변환
		//순서3.	최종 연산 - 60점 이상인 점수들의 평균 값 산출!
		double average = scores.stream() // IntegerStream 입력 스트림 통로 반환
							   .filter(score -> score >= 60) // 60점 이상 필터링 한 IntegerStream 입력 스트림 반환
							   .mapToInt(score -> score) // IntegerStream 을 IntStream 입력 스트림으로 변환해서 반환
							   .average() // 78.0 평균을 계산해서 담은 OptionalDouble 객체를 반환하는데
							   .orElse(0.0); // IntStream 통로에 점수들이 없으면 0.0 값으로 설정해 0.0 이 반환되어 사용하게 된다.
											 // IntStream 통로에 점수들이 있으면 .average() 로 계산한 평균 78.0 이 반환되어 사용하게 된다.
		//3. 60점 이상의 평균 출력
		System.out.println("60점 이상인 점수들의 평균: " + average);
		//					60점 이상인 점수들의 평균: 78.0
	}// === main Method

}// --- Ex2_1 Class




