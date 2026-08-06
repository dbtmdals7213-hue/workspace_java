import java.util.ArrayList;
import java.util.List;

class BoardDTO {
	
	// 멤버 변수: DB 컬럼 하나가 변수 하나에 대응된다.
	// private: 외부에서 변수에 직접 접근하지 못하게 막고(정보 은닉)
	//			아래에 getter 역할을 하는 메소드를 통해서만 값을 꺼내게 한다.(DTO 작성 표준)
	private int no; // 글 번호
	private String title; // 글 제목
	private String writer; // 작성자
	private int hit; // 조회수
	
	// 생성자: 글 1건의 데이터 4개를 전달받아 멤버 변수에 저장하며 객체를 만든다.
	public BoardDTO(int no, String title, String writer, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.hit = hit;
	}

	// getter 메소드들: private 멤버 변수의 값을 외부(.jsp 화면 등)에서 꺼낼 때 사용
	public int getNo() { return no; }
	public String getTitle() { return title; }
	public String getWriter() { return writer; }
	public int getHit() { return hit; }
	
	// 글 조회 수를 1올리는 메소드(상세 보기를 할 때마다 호출된다.)
	public void increaseHit() { hit = hit + 1; }// === increaseHit 메소드
	
}// --- BoardDTO 클래스

public class BoardListExample {

	public static void main(String[] args) {
		
		//=====================================================
		//1. 글 목록을 담을 가변 배열 생성: 제네릭에 "내가 만든 클래스명을 지정"
		//=====================================================
		
		// BoardDTO 객체만 저장할 수 있는 ArrayList 가변 배열 생성(업 캐스팅)
		// - <BoardDTO> 지정을 add 는 BoardDTO 만 받고, get 은 BoardDTO 로 반환한다.
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		//======================================================================================
		//2. 글 3건을 BoardDTO 객체로 만들어 ArrayList 배열에 추가해서 각각 저장(DB 에서 3행을 조회해 온 상황을 흉내)
		//======================================================================================
		
		// 글 1건의 데이터가 저장된 class BoardDTO 의 객체를 생성해서 ArrayList 배열에 저장
		boardList.add(new BoardDTO(1, "가입 인사드립니다.", "kim", 5));
		boardList.add(new BoardDTO(2, "자바 질문 있어요.", "lee", 3));
		boardList.add(new BoardDTO(3, "스터디 모집합니다.", "park", 5));
		
	}// === main 메소드

}// --- BoardListExample 클래스


