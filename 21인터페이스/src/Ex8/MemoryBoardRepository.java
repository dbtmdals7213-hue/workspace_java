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
	
	// 위 boards 배열에 추가된 모든 글 중에서 글 번호에 해당하는 글 한 건을 제공하는 메소드
	@Override
	public Board selectOne(int boardId) {// <-- 2
		
		// boards 배열에 저장된 글만 확인한다.
		for(int i = 0; i < count; i++) {
			
			// 각 글의 번호와 찾는 번호를 비교한다.
			if(boards[i].getId() == boardId) {
				
				// 찾으면 그 객체를 돌려주고 반복을 즉시 끝낸다.
				return boards[i]; // return new Board(2, "인터페이스 질문", "default 메소드가 궁금합니다.", "김철수");
			}
		}
		
		// 끝까지 못 찾으면 null 을 돌려준다.
		return null;
	}
	
	// 위 boards 배열에 추가되어 있는 글 중에서 매개변수로 받은 글 번호에 해당하는 글의 내용을 수정해서 그 결과를 제공하는 메소드
	@Override
	public boolean update(int boardId, String newContent) {
		
		// 바로 위에 만든 글 번호에 해당하는 글 한 건을 제공하는 메소드 재활용
		Board found = selectOne(boardId);
		// = new Board(1, "첫 글", "내용 입니다.", "홍길동");
		
		// 못 찾았으면 null 이 들어 있다.
		if(found == null) {
			
			return false; // 글 내용 수정하지 않고 수정 실패를 알리자
		}
		// 찾은 글 객체의 내용을 새 값으로 바꾼다.
		// found 는 boards 배열 안의 Board 객체를 가리키므로 boards 배열의 칸에 저장된 Board 객체의 정보도 바뀐다.
		found.setContent(newContent);
		
		// 글 내용 수정을 알리자
		return true;
	}
	
	// 위 boards 배열에 추가되어 있는 모든 글 중에서 글 번호에 해당하는 글 한 건을 정보 삭제해 결과를 제공하는 메소드
	@Override
	public boolean delete(int boardId) {
		
		for(int i = 0; i < count; i++) {
			
			// 삭제할 글을 찾았는지 확인한다.
			if(boards[i].getId() == boardId) {
				
				// 찾은 위치부터 마지막 직전 칸까지 반복한다.
				for(int j = i; j < count - 1; j++) {
					
					// 뒤 칸의 값을 앞 칸으로 당겨 빈 칸을 메운다
					boards[j] = boards[j + 1];
				}// --- 안쪽 for
				
				// 맨 뒷 칸에 남아있는 중복 값을 삭제한다.
				boards[count - 1] = null;
				
				// 채워진 칸 수를 1줄인다.
				count--;
				
				// 삭제 성공을 알린다.
				return true;
			}// --- if
		}// --- 바깥 for
		
		// 삭제할 글 번호의 글이 boards 배열에 존재하지 않으면? 글 삭제 실패를 알린다.
		return false;
	}// -- delete 메소드 끝
}


