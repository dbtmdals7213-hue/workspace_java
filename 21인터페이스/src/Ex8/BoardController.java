package Ex8;

//=====================================================================
//6. BoardController 클래스(사장)
// 클라이언트의 글 기능 중 하나의 요청을 받아 Service(부장) 에게 넘긴다. 직접 일하지 않는다.
//=====================================================================
public class BoardController {

	// HAS-A 관계: Controller 가 Service 클래스를 포함하고 있는 관계
	private BoardService service; // <--- new BoardServiceImpl(); 저장될 것이다.
	
	// 생성자로 new BoardServiceImpl(); 부장 객체 초기화
	public BoardController(BoardService service) {
		
		this.service = service;
	}
	
	// 새 게시글 등록 요청을 클라이언트로부터 받아 new BoardServiceImpl 부장 객체에게 넘긴다.
	public void requestRegister(Board board) {// <- new Board(1, "첫 글", "내용 입니다.", "홍길동");
		
		this.service.register(board);
	}
}


