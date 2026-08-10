
/*
	주제:	 윈도우 운영체제에서 제공하는 파일을 복사할 수 있는 기능의 copy.exe 프로그램 처럼
		 FileCopy.class 자바 프로그램을 자바 언어로 만들자
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	// 명령 프롬포트 창에 입력해서 테스트 할 구문
	// java FileCopy Test.txt Test2.txt
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		int data = 0; // "원본 파일" 전체 데이터 중에서 1바이트 크기의 데이터만 읽어 저장할 변수
		int size = 0; // "원본 파일" 에서 읽어들인 byte 크기를 누적해서 저장할 변수
		
		// java FileCopy Test.txt <- 원본_파일명만 입력하고 복사될_새_파일명을 입력하지 않았다면?
		if(args.length < 2) {
			
			System.out.println("java FileCopy 원본파일명 복사될새파일명");
			
			// 잘못된 입력은 FileCopy.class 자바 프로그램 강제 정상 종료
			System.exit(0);
		}
		
		// java File Copy Test.txt Test2.txt <- 원본_파일명과 복사될_새_파일명을 모두 정상 입력해서 파일 복사 프로그램을 만든다면?
		
		// 첫 번째로 입력받은 "원본_파일명": Test.txt 문자열 경로를 넣어 바이트 단위로 읽어들일 FileInputStream 입력 스트림 통로 생성
		FileInputStream fis = new FileInputStream(args[0]);
		
		// 두 번째로 입력받은 "복사될_새_파일명": Test2.txt 문자열 경로를 또 넣어 바이트 단위로 내보내어 기록할 FileOutputStream 출력 스트림 통로 생성
		FileOutputStream fos = new FileOutputStream(args[1]);
		
		// "원본 파일" Test.txt 파일에 저장되어 있는 데이터를 한 바이트씩(한 문자씩, 1byte) 읽어들여
		// "복사될 새 파일" Test2.txt 파일에 기록(출력, 내보냄, 쓰기)하자.
		while((data = fis.read()) != -1) {
			
			// "복사될 새 파일" 에 읽어들인 한 바이트의 데이터 단위로 기록(내보내어 쓰기)
			fos.write(data);
			
			// 한 바이트 읽어들인 바이트 크기(한 문자를 읽어들인 크기)를 ++ 해서 1증가시키자
			// 이유: 읽어들인 총 문자 개수 구하기 위해
			size++;
		}
		
		// 자원해제(FileInputStream, FileOutputStream 스트림 통로 역할을 하는 객체 메모리 모두 사용 후 JVM 에서 제거)
		fis.close();	fos.close();
		
		// Test.txt 파일의 데이터를 Test2.txt 로 복사한 문자 개수 출력
		System.out.println(size + "byte are copied ...");
		
	}// === main Method

}// --- FileCopy Class


