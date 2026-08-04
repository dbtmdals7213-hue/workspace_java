package 날짜와시간관련클래스들;

import java.util.Date;

import java.text.SimpleDateFormat;

public class DateExample {

	public static void main(String[] args) {
		
		Date now = new Date(); // Date() 기본 생성자를 호출해 new Date(); 객체 생성하면
							   // 현재 컴퓨터에 설정된 현재 날짜 및 시간 정보를 읽어 저장시킨 Date 객체가 생성됨.
		
		// 현재 날짜 및 시간이 저장된 Date 객체의 정보를 문자열로 변환해서 반환받아 출력
		// "Tue Aug 04 16:50:47 KST 2026" <--- 현재 날짜 및 시간 정보가 영문 형태로 출력
		System.out.println(now.toString());
		
		//====================================================================================================
		// "Tue Aug 04 16:50:47 KST 2026"
		// 위 영문의 현재 날짜와 시간 정보를 우리 개발자가 원하는 포맷 형식으로 만들어서 출력하게 도와주는 SimpleDateFormat 클래스를 사용하자.
		
		//순서1. SimpleDateFormat 클래스의 생성자를 호출할 때 원하는 포맷 형식을 문자열 형태로 전달해서 저장 후 객체 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		
		//순서2.	SimpleDateFormat 클래스에 만들어져 있는 format( new Date() ); 호출하면 
		//		반환 값으로 "yyyy.MM.dd HH:mm:ss" 포맷 형식으로 변경해서 반환
		String strNow2 = sdf.format(now);
		
		System.out.println(strNow2); // "2026.08.04 17:09:20"
									 // "yyyy.MM.dd HH:mm:ss"
		
	}// main 메소드

}// --- DateExample 클래스


