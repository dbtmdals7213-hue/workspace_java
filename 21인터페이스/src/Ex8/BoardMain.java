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
		controller.requestRegister(new Board(1, "첫 글", "내용 입니다.", "홍길동"));
		
		// 두 번째 - 새 글 객체를 만들면서 바로 Controller 에게 등록 요청을 한다.
		controller.requestRegister(new Board(2, "인터페이스 질문", "default 메소드가 궁금합니다.", "김철수"));
	}

}


