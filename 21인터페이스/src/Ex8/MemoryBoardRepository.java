package Ex8;

public class MemoryBoardRepository implements BoardRepository{

	// 글 여러 건을 담아둘 배열. 크기는 인터페이스의 상수 값 100을 사용한다.
	private Board[] boards = new Board[MAX_SIZE];
	
	// 실제로 채워진 칸의 개수 저장할 변수 만들기
	private int count = 0;
	
	// 위 boards 배열에 새 글 한 건의 정보를 추가하는 기능
	@Override
	public boolean insert(Board board) {// <- new Board(1, "첫 글", "내용 입니다.", "홍길동");
		
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

	@Override
	public Board[] selectAll() {
		
		return null;
	}
	
	@Override
	public Board selectOne(int boardId) {
		
		
	}
	
	
}


