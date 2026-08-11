
/*
	주제:	 파일 복제 프로그램(FileCopy.class)을 업그레이드 시키되
		 BufferedInputStream 입력 보조 스트림 통로와
		 BufferedOutputStream 출력 보조 스트림 통로의 내부 버퍼 메모리를 사용한 예
*/

import java.io.BufferedInputStream; // 입력 보조 스트림
import java.io.BufferedOutputStream; // 출력 보조 스트림

import java.io.FileInputStream; // 파일 입력 스트림
import java.io.FileOutputStream; // 파일 출력 스트림

import java.io.File; // 파일 정보 조작 클래스

public class FileCopy01 {

	// 입출력 할 데이터를 수용할 만큼의 버퍼 메모리 크기 설정
	final static int BUFFER_SIZE = 256;
	
	public static void main(String[] args) {
		
		// 윈도우 명령 프롬포트 창에 입력될 구문
		// java FileCopy01 "원본파일명" "복사될새파일명"
		// 					   0		  1			<--- index
		
		int i = 0; // "원본 파일" 에서 한 번 읽어들일 때마다 읽어들인 바이트 크기의 데이터를 저장할 변수
		int len = 0; // "원본 파일" 에서 읽어들인 총 바이트 크기를 저장할 변수
		
		// "원본 파일" 에서 읽어들인 데이터를 저장하거나 내보낼 크기의 byte 배열 생성
		byte[] buffer = new byte[BUFFER_SIZE]; // 256 byte
		
		// 윈도우 명령 프롬포트 창에 "원본파일명" 만 입력하고 "복사될새파일명" 을 입력하지 않은 경우
		if(args.length < 2) {
			
			// 입력될 구문을 사용자에게 알리자
			System.out.println("java FileCopy01 원본파일명 복사될새파일명");
			
			// FileCopy01.class 복사 프로그램 종료
			System.exit(0);
		}
		
		try {
			
			// BufferedInputStream 보조 입력 스트림 객체 생성 방법
			
			//순서1.	"원본 파일" 의 데이터를 1바이트 단위로 접근해서 읽어들일 입력 스트림 통로 생성
			FileInputStream fis = new FileInputStream(new File(args[0]));
			
			//순서2.	FileInputStream 입력 스트림을 업그레이드 해서
			//		"원본 파일" 의 데이터를 우리가 지정한 256 byte 단위로 접근해서 한 번에 읽어들이기 위한
			//		BufferedInputStream 보조 입력 스트림 객체 생성
			// 참고.	BufferedInputStream 객체 메모리 내부에는 내부 버퍼 메모리(512 byte 공간)에 저장해 두었다가
			//		512 byte 크기의 데이터를 한 번에 읽어들일 수 있는 보조 입력 스트림입니다.
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			// BufferedOutputStream 보조 출력 스트림 객체 생성 방법
			
			//순서1.	순서2. "복사될 새 파일" 에 BufferedInputStream 입력 보조 스트림 통로로부터 읽어들인 데이터들을
			//		1바이트 단위로 내보내서 출력하기 위한 FileOutputStream 출력 스트림 통로 객체 생성 후
			//		업그레이드 해서 내부 버퍼 메모리 공간 512 바이트에 모아두었다가
			//		512 바이트 크기의 데이터 단위로 출력하기 위한 출력 보조 스트림 통로 BufferedOutputStream 객체 생성
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(args[1])));
			
			
		}catch (Exception e) {
			
			e.printStackTrace(); // 예외가 발생하면 출력
		}
		
		
		
	}// === main Method

}// --- FileCopy01 Class


