
/*
	스토리. 도서관 책 한 권을 관리한다. 대출 여부를 두고, 이미 대출 중이면 다시 대출할 수 없다.
*/

//1단계: 현실의 도서 - "자바의 정석", "수학의 정석" 객체 모델링(데이터와 기능 추출)
// - 데이터: 제목(title), 저자(author), 대출 여부(isRented)
// - 기능: 대출(rent), 반납(returnBook), 상태 출력(printStatus)

//2단계: 현실의 도서를 추상화해서 도서 설계도(class) 설계
public class BookTest {
	// 클래스 변수 선언
		String title; //1. 책 제목 저장할 변수 선언
		String author; //2. 책 저자 저장할 변수 선언
		boolean isRented; //3. 대출 여부 저장할 변수 선언
	
	// 클래스 메소드 선언
		/*
			메소드명: rent
			기능: 대출 중이 아니면 대출 처리하고 완료 메시지 출력,
				 이미 대출 중이면 "이미 대출 중입니다." 출력
		*/
		void rent() {
		
			if(isRented == false) {
				
				isRented = true;
				System.out.println("대출이 완료되었습니다.");
			}else {
				System.out.println("이미 대출 중입니다.");
			}
		}
	
		/*
			메소드명: returnBook
			기능: isRented 를 false 로 바꾸고 반납 완료 메시지 출력
		*/
		void returnBook() {
			
			isRented = false;
			System.out.println("반납 완료했습니다.");
		}
		
		/*
			메소드명: printStatus
			기능: 제목, 저자, 대출 여부를 한 줄로 출력한다.
		*/
		void printStatus() {
			
			System.out.println("제목: " + title + ", 저자: " + author + ", 대출 여부: " + isRented);
		}
		
	public static void main(String[] args) {
		
		BookTest book = new BookTest();
		
		book.title = "자바의 정석";
		book.author = "";
		book.isRented = true;
		
		book.rent();
		book.returnBook();
		book.printStatus();
	}

}
