package 날짜와시간관련클래스들;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 예제. 현재 컴퓨터 시간에서 년, 월, 일을 연산하는 방법

public class LocalDateTimeTest1 {

	public static void main(String[] args) {
		
		//순서1. LocalDateTime 클래스의 객체를 얻는 방법
		LocalDateTime localDateTime = LocalDateTime.now();
		
		// 우리가 원하는 현재 날짜와 시간 정보가 아니다.
		// "2026-08-04T17:50:22.386188300"
		System.out.println(localDateTime);
		
		//순서2.	
		// 참고.	DateTimeFormatter 클래스는 날짜와 시간을 주어진 문자열 패턴으로 변환할 때 사용하는 클래스로,
		//		LocalDateTime 객체의 format() 메소드를 호출할 때 매개 값으로 제공하면 문자열 패턴과 동일한 문자열을 반환 받아 얻을 수 있음
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		
		//순서3.
		System.out.println("현재 날짜와 시간 정보: " + dtf.format(localDateTime));
		//				   "현재 날짜와 시간 정보: 2026.08.05 오전 09:14:27"
		
		//순서4. 현재 날짜와 시간 정보: 2026.08.05 오전 09:14:27 에서 1년을 + 해서 2027.08.05 오전 09:14:27 로 만들자
		LocalDateTime result1 = localDateTime.plusYears(1);
		System.out.println("현재 날짜와 시간 정보에서 1년 + 한 날짜: " + result1.format(dtf));
		//				   "현재 날짜와 시간 정보에서 1년 + 한 날짜: 2027.08.05 오전 09:18:34"
		
		//순서5.	현재 날짜와 시간 정보: 2026.08.05 오전 09:14:27 에서
		//		월 정보만 2달 + 해서 2026.10.05 오전 09:14:27 날짜로 만들어 제공 받자
		LocalDateTime result2 = localDateTime.plusMonths(2);
		System.out.println("현재 날짜와 시간 정보에서 2달 + 한 날짜: " + result2.format(dtf));
		//				   "현재 날짜와 시간 정보에서 2달 + 한 날짜: 2026.10.05 오전 09:21:22"
		
		//순서6.	현재 날짜와 시간 정보: 2026.08.05 오전 09:14:27 에서
		//		일 정보만 7일 + 해서 2026.08.12 오전 09:14:27 날짜로 만들어 제공 받자
		LocalDateTime result3 = localDateTime.plusDays(7);
		System.out.println("현재 날짜와 시간 정보에서 7일 + 한 날짜: " + result3.format(dtf));
		//				   "현재 날짜와 시간 정보에서 7일 + 한 날짜: 2026.08.12 오전 09:25:40"
		
	}// === main 메소드

}// --- LocalDateTimeTest1 클래스


