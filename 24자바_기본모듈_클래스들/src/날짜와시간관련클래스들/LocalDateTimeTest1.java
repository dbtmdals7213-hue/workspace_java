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
		
		//순서2.	DateTimeFormatter 클래스는 날짜와 시간을 주어진 문자열 패턴으로 변환할 때 사용하는 클래스로,
		//		LocalDateTime 객체의 format() 메소드를 호출할 때 매개 값으로 제공하면 문자열 패턴과 동일한 문자열을 반환 받아 얻을 수 있음
		DateTimeFormatter dtf;
		
	}// === main 메소드

}// --- LocalDateTimeTest1 클래스


