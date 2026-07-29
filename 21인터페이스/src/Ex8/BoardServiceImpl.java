package Ex8;

//===========================================
//5. BoardServiceImpl 클래스(부장)
// 업무 규칙의 실제 코드, 추상 메소드 5개를 오버라이딩 한다.
// default 메소드는 구현하지 않아도 상속 받아 사용한다.
//===========================================
public class BoardServiceImpl implements BoardService {

	// HAS-A 관계: BoardServiceImpl 객체가 
	//			  MemoryBoardRepository 객체(새 글 정보 저장)를 변수에 저장하여 포함하는 관계
	private BoardRepository repository;
	
	// 생성자로 MemoryBoardRepository 객체 초기화
	public BoardServiceImpl(BoardRepository repository) {
		
		this.repository = repository;
	}
	
	// 새 게시글 등록 메소드
	@Override
	public void register(Board board) {// <- new Board(1, "첫 글", "내용 입니다.", "홍길동");
		
		// 인터페이스로부터 상속 받은 default 메소드를 호출해서 사용
		printTitle("게시글 등록");
		
		// static 메소드는 인터페이스명을 앞에 붙여 호출한다
		// 글 제목이 부적합하면 아래 블록이 실행된다.
		if(BoardService.isVailidTitle(board.getTitle()) == false) {
			
			System.out.println("글 등록 실패: 글 제목을 입력해야 합니다.");
			
			return; // register 메소드 종료
		}
		
		// 저장소에 새 글 정보 저장을 요청하고 저장 여부를 바로 판단한다.
		// insert 메소드가 true 를 돌려주면 성공이다.
		if(repository.insert(board)) {
			
			System.out.println("새 글 등록 성공: " + board.getId() + "번 - " + board.getTitle());
		}else {
			
			System.out.println("새 글 등록 실패: 저장 공간이 가득 찼습니다.");
		}
	}

	@Override
	public void showList() {
		
		
	}

	@Override
	public void showDetail(int boardId) {
		
		
	}

	@Override
	public void modify(int boardId, String newContent) {
		
		
	}

	@Override
	public void remove(int boardId) {
		
		
	}

}


