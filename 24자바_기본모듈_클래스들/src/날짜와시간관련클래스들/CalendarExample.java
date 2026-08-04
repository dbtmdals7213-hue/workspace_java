package 날짜와시간관련클래스들;

import java.util.Calendar;

public class CalendarExample {

	public static void main(String[] args) {
		
		//1. Calendar 추상클래스로는 new 로 객체 생성이 불가능하기 때문에
		//	 Calendar 추상 클래스를 구현한 하위 자식 GregorianCalendar 객체를 얻어 사용
		Calendar now = Calendar.getInstance();
		
		//2. 현재 날짜와 시간 정보를 구해 변수에 각각 저장
		int year = now.get(Calendar.YEAR); // 현재 년도 정보를 반환 받아 저장
		int month = now.get(Calendar.MONTH) + 1; // 현재 월 정보를 get 메소드로 1적게 얻어 +1 해서 월 정보 저장
		int day = now.get(Calendar.DAY_OF_MONTH); // 현재 일 정보를 반환 받아 저장
		int week = now.get(Calendar.DAY_OF_WEEK); // 현재 요일 정보를 반환 받아 저장
		
		String strWeek = null;
		//3. 현재 요일에 정수 값에 따라 한글로 요일을 저장
		switch (week) {// 현재 요일 정수 값이
			case Calendar.MONDAY: // 월요일 정수 값과 같다면?
				strWeek = "월";
				break;
	
			case Calendar.TUESDAY: // 화요일 정수 값과 같다면?
				strWeek = "화";
				break;
				
			case Calendar.WEDNESDAY: // 수요일 정수 값과 같다면?
				strWeek = "수";
				break;
				
			case Calendar.THURSDAY: // 목요일 정수 값과 같다면?
				strWeek = "목";
				break;
				
			case Calendar.FRIDAY: // 금요일 정수 값과 같다면?
				strWeek = "금";
				break;
				
			case Calendar.SATURDAY: // 토요일 정수 값과 같다면?
				strWeek = "토";
				break;
				
			default: // 일요일 정수 값과 같다면?
				strWeek = "일";
				break;
		}
		
		//4. 현재 오전 또는 오후인지에 대한 정보 반환 받아 저장
		int amPm = now.get(Calendar.AM_PM);
		
		String strAmPm = null;
		
		if(amPm == Calendar.AM) {// 현재 시간이 오전이라면?
			
			strAmPm = "오전";
		}else {
			
			strAmPm = "오후";
		}
		
		//5. 현재 시, 분, 초 정보 구하기
		int hour = now.get(Calendar.HOUR); // 현재 시간 정보 반환
		int minute = now.get(Calendar.MINUTE); // 현재 분 정보 반환
		int second = now.get(Calendar.SECOND); // 현재 초 정보 반환
		
		//6. 현재 날짜와 시간 정보 모두 출력
		System.out.println(year + "년 " + month + "월 " + day + "일 " + strWeek + "요일");
		System.out.println(strAmPm + " " + hour + "시 " + minute + "분 " + second + "초");
		
	}// === main 메소드

}// --- CalendarExample 클래스


