
// 주제:	파일명을 입력 받아 입력 받은 파일명의 파일에 기록된 내용을 읽어와 모니터 화면에 출력
// 명령 프롬포트 창(CMD 창)에 입력하는 모습
// java FileType01 FileTest02.java

import java.io.*; // java.io 패키지 내부에 만들어져 있는 File, FileInputStream 클래스를 포함한 모든 인터페이스 및 클래스 불러와 사용

public class FileType01 {// <-- javac FileType01.java 작성해서 컴파일하면 FileType01.class 파일이 생성된다.

	// FileType01.class 실행파일을 실행하려면
	// -> java FileType01 작성해야 실행 내부 코드를 실행시킬 수 있다.
	public static void main(String[] args) {//["FileTest02.java"] <- 읽어들일 파일명을 문자열로 입력 받아 String 배열로 받음
		
		int data = 0; // 입력 받은 파일명(FileTest02.java)에 관한 파일에 기록된 정보를 1바이트만 읽어 저장할 변수
		int size = 0; // 입력 받은 파일명(FileTest02.java)의 파일에 기록된 데이터의 크기(파일 크기)를 계산해서 저장할 변수
		
		// 명령 프롬포트 창에 파일명을 하나만 입력했다면?
		// java FileType01 <--- 만 입력했다면?
		if(args.length < 1) {
			
			// 입력할 방법을 사용자에게 보여주기 위해 메세지 출력
			System.out.println("입력하는 방법: java FileType01 읽어들일_파일명");
			
			// FileType01.class 자바 프로그램 강제 종료
			System.exit(0);
		}
		
		// 명령 프롬포트 창(CMD)에 제데로 입력했다면?
		String path = args[0];
		
		// FileInputStream 객체 생성 방법
		// 작성 방법2.	 File file = new File("읽어들일 데이터가 저장된 파일 경로");
		//			 FileInputStream 참조변수 = new FileInputStream(file);
		
		try {
			
			// FileTest02.java 파일에 접근해서 파일의 정보를 바이트 단위로 읽어들일 FileInputStream 입력 스트림 통로 생성
			File file = new File(path); // 순서1.
			FileInputStream fis = new FileInputStream(file); // 순서2.
			
			// FileTest02.java 파일에 저장되어 있는 전체 정보 중에서 1바이트 단위의 데이터를 한 번씩 반복해서 읽어들입니다.
			while((data = fis.read()) != -1) {
				
				// FileTest02.java 파일에서 한 번 읽어들인 데이터는 data 변수 값을
				// PrintStream 출력 스트림 통로를 통해 1바이트 단위로 모니터 장치에 내보내어 출력해서 보여준다.
				System.out.write((char)data);
				
				// 한 번씩 읽어들여 출력할 때마다 문자 개수 누적
				size++;
			}// while 반복문
			
			// 참고.	영문 한 문자는? 1바이트 크기
			//		한글 한 문자는? 2바이트 크기
			System.out.println("문자 개수: " + size + "byte");
		}catch(FileNotFoundException e) {
			
			System.out.println("지정된 경로에 FileTest02.java 파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}catch(IOException e) {
			
			System.out.println("지정된 경로에 FileTesto2.java 파일에 기록된 데이터를 더 이상 읽어들일 수 없습니다.");
		}
		
	}// === main Method

}// --- FileType01 Class


