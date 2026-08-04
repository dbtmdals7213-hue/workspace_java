package 날짜와시간관련클래스들;

import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		
		Date now = new Date(); // Date() 기본 생성자를 호출해 new Date(); 객체 생성하면
							   // 현재 컴퓨터에 설정된 현재 날짜 및 시간 정보를 읽어 저장시킨 Date 객체가 생성됨.
		
		// 현재 날짜 및 시간이 저장된 Date 객체의 정보를 문자열로 변환해서 반환받아 출력
		System.out.println(now.toString());
		
		
		
		
		
		
		
	}// main 메소드

}// --- DateExample 클래스
