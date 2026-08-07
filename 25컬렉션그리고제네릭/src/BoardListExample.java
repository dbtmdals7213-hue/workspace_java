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
		
		//==================================================
		//3. 글 목록 전체 출력(JSP 에서 <table> 에 반복 출력하는 처리!)
		//==================================================
		System.out.println("번호\t제목\t\t작성자\t조회수");
		System.out.println("------------------------------------------");
		
		// 향상된 for 문: boardList 참조변수에 저장된 ArrayList 배열에서 BoardDTO 객체를 하나씩 꺼내 dto 변수에 담아가며 반복
		for(BoardDTO dto : boardList) {
			
			// ArrayList 배열에서 꺼낸 BoardDTO 객체의 getter 메소드를 호출해 글 1건의 각 컬럼 값을 출력한다.
			System.out.println(dto.getNo() + "\t" 
				+ dto.getTitle()+ "\t" 
				+ dto.getWriter() + "\t" 
				+ dto.getHit());
		}
		
		//========================================
		//4. 상세 보기: 글 번호로 글 1건 찾기 + 조회 수 증가
		//	 (게시판에서 제목을 클릭하면 일어나는 일을 흉내)
		//========================================
		
		int targetNo = 2; // 사용자가 클릭한 글 번호(JSP 에서는 파라미터로 전달받는 값)
		
		System.out.println("===== " + targetNo + "번 글 상세보기 =====");
		
		// ArrayList 배열을 돌면서 글 번호가 일치하는 BoardDTO 객체를 찾는다.
		for(BoardDTO dto : boardList) {
			
			// ArrayList 배열에서 꺼낸 BoardDTO 객체의 글 번호가 찾는 글 번호 2의 글과 같다면?
			if(dto.getNo() == targetNo) {
				
				// 상세 보기가 일어났으므로 글 조회 수 1 올린다.
				dto.increaseHit(); // hit 인스턴스 변수 값 1 누적해서 글 조회 수 1 올릴 수 있다.
				
				// 2번 글 번호의 글 상세 내용 출력
				System.out.println("제목: " + dto.getTitle());
				System.out.println("작성자: " + dto.getWriter());
				System.out.println("조회 수: " + dto.getHit());
			}// if 조건문
		}// for 반복문
		
		//=======================================================================
		//5. 수정이 진짜 반영되었는지 글 목록 다시 출력해서 확인 <- DB 의 테이블에 저장된 모든 글을 조회
		//=======================================================================
		
		System.out.println("===== 상세 보기 후 목록 다시 출력 =====");
		for(BoardDTO dto : boardList) {
			
			// ArrayList 배열에서 꺼낸 BoardDTO 객체의 getter 메소드를 호출해 글 1건의 각 컬럼 값을 출력한다.
			System.out.println(dto.getNo() + "\t" 
				+ dto.getTitle()+ "\t" 
				+ dto.getWriter() + "\t" 
				+ dto.getHit()); // <--- 2번 글의 조회 수가 1 증가된 상태로 출력
		}
		
	}// === main 메소드

}// --- BoardListExample 클래스


