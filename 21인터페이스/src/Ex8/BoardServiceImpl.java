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
									   // <- new Board(2, "인터페이스 질문", "default 메소드가 궁금합니다.", "김철수");
									   // <- new Board(3, "  ", "제목이 공백뿐입니다.", "이영희");
		
		// 인터페이스로부터 상속 받은 default 메소드를 호출해서 사용
		printTitle("게시글 등록");
		
		// static 메소드는 인터페이스명을 앞에 붙여 호출한다
		// 글 제목이 부적합하면 아래 블록이 실행된다.
		if(BoardService.isVailidTitle(board.getTitle()) == false) {
			
			System.out.println("글 등록 실패: 글 제목을 입력해야 합니다.");
			
			return; // register 메소드 종료
		}
		
		// 저장소(MemoryBoardRepository 객체)에 새 글 정보 저장을 요청하고 저장 여부를 바로 판단한다.
		// insert 메소드가 true 를 돌려주면 성공이다.
		if(repository.insert(board)) {
			
			System.out.println("새 글 등록 성공: " + board.getId() + "번 - " + board.getTitle());
		}else {
			
			System.out.println("새 글 등록 실패: 저장 공간이 가득 찼습니다.");
		}
	}// -- register 메소드 끝

	// 새 글 목록 보기
	@Override
	public void showList() {
		
		// 인터페이스로부터 상속 받은 default 메소드를 호출해서 사용
		printTitle("전체 목록");
		
		// 저장소(MemoryBoardRepository 객체)에서 추가된 새 글 2건의 정보를 배열에 담아 받아옵니다.
		Board[] boards = repository.selectAll();
		
		// boards 배열의 길이가 0이면 저장된 글이 없다는 뜻이므로 출력해주자
		if(boards.length == 0) {
			
			System.out.println("등록된 글이 없습니다.");
			return; // 아래의 for 반복문을 실행하지 않고 showList() 메소드 종료
		}
		
		// length 는 배열의 칸 수다 여기서는 글 개수와 같다.
		System.out.println("총 " + boards.length + "건");
		
		// 받아온 배열을 처음부터 끝까지 반복해서 추가된 글들을 얻어 옵니다.
		for(Board board : boards) {
			
			// 추가된 글의 정보를 반복해서 하나씩 출력
			System.out.println(board.getId() + " | " + board.getTitle() + " | " + board.getWriter());
		}
		
	}// -- showList 메소드 끝

	// 글 한 건 상세 보기
	@Override
	public void showDetail(int boardId) {
		
		printTitle("상세 보기");
		
		// 매개변수 boardId 로 받은 글 번호 2로 글을 찾아 받아옵니다.
		// 방법. MemoryBoardRepository 객체의 selectOne(2); 메소드 호출해서 명령한다.
		repository.selectOne(boardId);
	}

	@Override
	public void modify(int boardId, String newContent) {
		
		
	}

	@Override
	public void remove(int boardId) {
		
		
	}

}


