
// 주제:	키보드에서 입력한 데이터를 파일에 기록

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOTest06 {

	public static void main(String[] args) {
		
		int data = 0; // 키보드에서 입력한 전체 데이터 크기 중에서 1바이트 크기의 데이터만 읽어 저장
		
		File f = null;
		InputStream fis = null;
		FileOutputStream fos = null;
		
		System.out.println("파일에 기록할 내용을 입력하세요.");
		System.out.println("지금 입력한 내용은 파일에 기록됩니다.");
		
		try {
			
			//1. Test.txt 파일에 접근할 수 있도록 File 클래스의 객체 생성
			f = new File("Test.txt");
			
			//2. 키보드로부터 입력한 데이터를 1(한)바이트 단위로 Test.txt 파일에 내보내어 기록하기 위한
			//	 FileOutputStream 클래스의 객체(출력 스트림 통로) 생성
			fos = new FileOutputStream(f, true); // true -> 만약 Test.txt 파일에 이미 기록된 데이터가 있다면?
												 //			출력 스트림 통로를 통해 Test.txt 파일 기록된 내용 뒤에
												 //			바이트 단위로 내보내어 추가로 기록!
			//3. 키보드로부터 입력한 데이터를 1(한)바이트 단위로 읽어들일 System.in(BufferedInputStream 입력 스트림 통로 객체) 얻기
			fis = System.in;
			
			//4. 키보드로부터 입력 받은 전체 데이터 중에서 1(한)바이트 크기의 데이터를 반복해서 읽어들여 data 변수에 저장
			while((data = fis.read()) != -1) {
				
				// BufferedInputStream 입력 스트림을 통해 한 번 읽어들인 1바이트 크기의 데이터를 반복해서
				// FileOutputStream 출력 스트림을 통해 Test.txt 파일에 1바이트 크기 단위로 데이터를 내보내어 출력(기록)합니다.
				fos.write(data);
			}// while 반복문
			
		}catch (FileNotFoundException e) {
			
			e.printStackTrace(); // 발생한 예외 메세지 얻어 출력
		}catch (IOException e) {

			e.printStackTrace(); // 발생한 예외 메세지 얻어 출력
		}finally {// 무조건! 한 번 실행될 코드가 있다면 여기 이 자리에 코드 작성.
				  // 예)	 입력 스트림 통로(BufferedInputStream 객체 메모리),
				  //	 출력 스트림 통로(FileOutputStream 객체 메모리) 모두 사용했으면 JVM 에서 제거
				  //	 요약: 메모리 자원 제거(해제)
			
			try {
				
				// -> FileOutputStream 출력 스트림 통로 역할의 객체 메모리를 모두 사용했다면? JVM 의 Heap 영역에서 제거
				if(fos != null) { fos.close(); }
				
				// -> BufferedInputStream 입력 스트림 통로 역할의 객체 메모리를 모두 사용했다면? JVM 의 Heap 영역에서 제거
				if(fis != null) { fis.close(); }
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}// finally 블럭
		
	}// === main Method

}// --- IOTest06 Class


