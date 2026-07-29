package Ex8;

public class MemoryBoardRepository implements BoardRepository{

	// 글 여러 건을 담아둘 배열. 크기는 인터페이스의 상수 값 100을 사용한다.
	private Board[] boards = new Board[MAX_SIZE];
	
	// 실제로 채워진 칸의 개수 저장할 변수 만들기
	private int count = 0;
	
	// 위 boards 배열에 새 글 한 건의 정보를 추가하는 기능
	@Override
	public boolean insert(Board board) {// <- new Board(1, "첫 글", "내용 입니다.", "홍길동");
										// <- new Board(2, "인터페이스 질문", "default 메소드가 궁금합니다.", "김철수");
										// <- new Board(3, "  ", "제목이 공백뿐입니다.", "이영희");
		
		// boards 배열 칸이 최대치에 도달했는지 확인한다.
		if(count >= MAX_SIZE) {
			
			// 새 글 추가할 boards 배열의 칸이 없으므로 새 글 추가 실패를 알린다.
			return false;
		}
		
		// 위 boards 배열의 비어있는 첫 칸에 새 글 한 건의 정보를 넣는다.
		// 그 index 위치가 count 변수의 값이다.
		boards[count] = board;
		
		// 위 boards 배열에 채워진 칸의 그 다음 위치 칸으로 이동하기 위해 index 위치 변경
		count++;
		
		// 저장 성공을 알립니다.
		return true;
	}

	// boards 배열에 추가된 모든 글을 가져와 제공하는 메소드
	@Override
	public Board[] selectAll() {
		
		// 실제 글 개수만큼만 새로운 배열을 만듭니다.
		// 이유: 100칸 배열을 그대로 넘기면 뒤쪽 칸에 null 이 모두 저장되기 때문에 나중에 오류가 난다.
		Board[] result = new Board[count];

		// 0번 칸부터 count - 1 번 index 칸까지 반복한다.
		for(int i = 0; i < count; i++) {
			
			// 새 글이 각 칸에 저장된 배열의 각 칸의 new Board(1, "첫 글", "내용 입니다.", "홍길동"); 와
			// new Board(2, "인터페이스 질문", "default 메소드가 궁금합니다.", "김철수"); 을 반복해서 얻어
			// result 배열의 각 칸에 차례대로 반복해서 담는다.
			result[i] = boards[i];
		}
		
		// 추가된 글들이 저장된 복사가 끝난 배열을 돌려준다.
		return result;
	}
	
	@Override
	public Board selectOne(int boardId) {
		
		return null;
	}
	
	@Override
	public boolean update(int boardId, String newContent) {
		
		return false;
	}
}


