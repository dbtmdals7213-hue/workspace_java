package Ex8;

//==============================================
//4. BoardService 인터페이스
// 업무 규칙을 정한다. 무엇을 검사하고 무엇을 출력할지 결정한다.
//==============================================
public interface BoardService {

	// 추상 메소드 역할: 게시판이 제공하는 기능 목록
	
	//기능1. 새 게시글 등록
	void register(Board board);
	
	//기능2. 게시글 목록 보기
	void showList();
	
	//기능3. 게시글 한 건 보기
	void showDetail(int boardId);
	
	//기능4. 게시글 수정
	void modify(int boardId, String newContent);
	
	//기능5. 게시글 삭제
	void remove(int boardId);

	// default 메소드 - 구현부를 가질 수 있고, 구현 자식 클래스에 그대로 상속되는 메소드
	//기능6. 위 다섯 기능이 모두 같은 글 제목 줄을 출력하게 구현
	default void printTitle(String title) {
		
		line();// 아래에 있는 private 메소드를 호출한다.
		
		System.out.println("[" + title + "]");// 제목을 대괄호로 감싸서 출력한다.
		
		line(); // 구분선을 한 번 더 출력하기 위해 아래의 line() 메소드를 호출한다.
	}
	
	private void line() {
		
		System.out.println("------------------------------------------------");
	}
}
