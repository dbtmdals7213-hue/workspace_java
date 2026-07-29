package Ex8;

import Ex8.Board;

public class BoardMain {
	
	// main 메소드: 자바 프로그램의 시작 지점
	public static void main(String[] args) {
		
		//-----------------------------------
		//[1] 조립 단계
		//-----------------------------------
		
		// 저장소 객체를 만들어 부모 인터페이스 자료형의 참조 변수에 담는다.(업 캐스팅)
		BoardRepository repository = new MemoryBoardRepository(); // <--- 사원
		
		// Service 를 만들면서 위에서 만든 저장소를 생성자로 전달한다.
		// 이 순간 Service 와 Repository 가 연결된다.
		BoardService service = new BoardServiceImpl(repository); // <--- 부장
		
		// Controller 를 만들면서 바로 위에서 만든 Service 를 생성자로 전달한다.
		// Controller -> Service -> Repository 연결이 완성된다.
		BoardController controller = new BoardController(service); // <--- 사장
		
		//----------------------------------------------------
		//[2] 사장인 Controller 가 클라이언트에게 새 글 등록 요청을 받았다.
		//----------------------------------------------------
		
		// 첫 번째 - 새 글 객체를 만들면서 바로 Controller 에게 등록 요청을 한다.
		// 참고. 첫 번째 글 등록에 성공한다! 이유: "첫 글" 제목이 정상이기 때문
		controller.requestRegister(new Board(1, "첫 글", "내용 입니다.", "홍길동"));
		
		// 두 번째 - 새 글 객체를 만들면서 바로 Controller 에게 등록 요청을 한다.
		// 참고. 두 번째 글 등록에 성공한다! 이유: "인터페이스 질문" 제목이 정상이기 때문
		controller.requestRegister(new Board(2, "인터페이스 질문", "default 메소드가 궁금합니다.", "김철수"));
		
		// 세 번째 - 새 글 객체를 만들면서 바로 Controller 에게 등록 요청을 한다.
		//		   단! 글 제목을 입력하지 않고 새 글 등록 요청을 한다.
		// 참고. 세 번째 글 등록에 실패한다! 이유: "  " 빈 공백을 전달하여 글 제목이 정상적이지 않기 때문
		controller.requestRegister(new Board(3, "  ", "제목이 공백뿐입니다.", "이영희"));
		
		//--------------------------
		//[3] 글 목록 조회 요청을 받았을 때
		//--------------------------
		
		// 추가에 성공한 글 2개의 정보를 출력(조회)하자
		controller.requestList();
		
		//----------------------------------------
		//[4] 글 한 건 정보(글 상세) 조회: 있는 글과 없는 글
		//----------------------------------------
		
		// 2번 글 번호의 글은 존재하므로 정상 출력된다.
		controller.requestDetail(2);
		
		// 99번 글 번호의 글은 없으므로 안내 문구가 출력된다.
		
	}

}


