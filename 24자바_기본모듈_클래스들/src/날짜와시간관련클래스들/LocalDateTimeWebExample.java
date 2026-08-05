package 날짜와시간관련클래스들;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeWebExample {

	// 게시글 하나의 정보가 저장되는 역할을 하는 내부 (중첩)클래스 선언
	static class Board {
		
		int boardNo; // 글 번호
		String title; // 글 제목
		String content; // 글 내용
		LocalDateTime createdAt; // 글 작성 날짜 및 시간
		
		// 글 하나의 정보를 초기화 시킬 생성자
		Board(int boardNo, String title, String content) {
			
			this.boardNo = boardNo;
			this.title = title;
			this.content = content;
			this.createdAt = LocalDateTime.now(); // 글 작성 날짜 및 시간 정보를 현재 컴퓨터에 설정된 정보가 들어가게 저장
		}
		
	}// --- Board 내부 (중첩)클래스
	
	// 게시글 관련  기능의 메소드들을 포함하고 있는 내부 (중첩)클래스 선언
	static class BoardService {
		
		// 게시글 수정 가능 여부(24시간 이내 수정 가능 여부) 판단하는 기능의 메소드 선언
		boolean canEdit(Board board) {// <--- new Board(1, "LocalDateTime 예제", "웹 개발 응용");
			
			// 현재 날짜 및 시간 정보가 저장된 LocalDateTime 객체 얻기
			LocalDateTime now = LocalDateTime.now();
			
			// 글 작성 날짜 및 시간 정보가 저장된 LocalDateTime 객체 얻기
			LocalDateTime createdTime = board.createdAt;
			
			// 글 작성 날짜 및 시간 정보로부터 현재 날짜 및 시간이 지난 시간을 구해(시간 단위로 구해) 저장
			long hoursBetween = createdTime.until(now, ChronoUnit.HOURS);
			
			// 24시간 이내면 수정 가능
			return hoursBetween < 24;
		}// === canEdit 메소드
		
	}// --- BoardService 내부 (중첩)클래스
	
	public static void main(String[] args) {
		
		//1. 게시글 하나 작성
		Board board = new Board(1, "LocalDateTime 예제", "웹 개발 응용");
		
		// 테스트를 위해 글 작성 시간을 23시간 전으로 변경
		board.createdAt = board.createdAt.minusHours(23);
		
		BoardService service = new BoardService();
		
		//2. 글 수정 가능 여부 확인
		boolean result = service.canEdit(board);
		
		//3. 결과 출력
		if(result) {
			
			System.out.println("게시글 수정 가능(게시글 하나 작성 후 24시간 이내)");
		}else {
			
			System.out.println("게시글 수정 불가능(게시글 하나 작성 후 24시간 초과)");
		}
		
		//4. 날짜 비교 메소드 예제
		LocalDateTime now = LocalDateTime.now(); // 현재 컴퓨터에 설정된 날짜 정보가 저장된 LocalDateTime 객체 반환
		LocalDateTime future = now.plusDays(1); // 현재 컴퓨터에 설정된 날짜에서 + 1을 더한 날짜를 구한 정보가 저장된 LocalDateTime 객체 반환
		LocalDateTime past = now.minusDays(1); // 현재 컴퓨터에 설정된 날짜의 정보에서 - 1일을 한 날짜 정보가 저장된 LocalDateTime 객체 반환
		
		System.out.println("future 가 now 이후인가? " + future.isAfter(now)); // true
		System.out.println("past 가 now 이전인가? " + past.isBefore(now)); // true
		System.out.println("now 가 now 와 같은가? " + now.isEqual(now)); // true
		
		//5. 날짜 차이 계산
		long daysBetween = now.until(future, ChronoUnit.DAYS);
		System.out.println("현재와 미래 날짜 차이: " + daysBetween + "일"); // 1일
		
	}// === main 메소드

}// --- LocalDateTimeWebExample 클래스


