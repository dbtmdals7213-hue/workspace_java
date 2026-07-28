
/*
	게시판 기능 구현에 관한 미완성 설계도(추상 클래스) 만들기
	추상 클래스명: Board
	질문1. 추상 클래스는 무엇인가요?
	답변1. 메소드 기능 구현이 완벽히 작성되지 않은 추상 메소드를 포함하고 있는 미완성 클래스이며,
		  상속을 통해서만 자식 클래스를 새롭게 만들 수 있게 도와주는 클래스가 추상 클래스입니다.
*/
abstract class Board {
	
	/* 
		글 제목, 글 내용, 글 작성자 명, 글 작성 날짜를 저장할 변수들 선언
		질문2. protected 키워드는 무엇인가요?
		답변2. 동일한 패키지나 상속 받은 자식 클래스에서만 변수에 접근할 수 있도록 하는 접근 제어자 종류 중 하나
	*/
	protected String title, content, author, date;
	
	/*
		생성자
		역할: 자식 클래스의 객체 메모리 생성 시 글 제목, 글 내용, 글 작성자 명, 글 작성 날짜를 모두 초기화
	*/
	public Board(String title, String content, String author, String date) {
		
		//질문3.	this 키워드는 왜 사용하나요?
		//답변3.	생성자의 매개변수이자 지역 변수와 객체 변수의 이름이 같기 때문에
		//		객체 변수를 구분하기 위해 사용됨. -> this.객채변수명 = 매개변수명;
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
	}
	
}



public class Main {

	public static void main(String[] args) {
		
		
	}

}
