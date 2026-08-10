
// 주제: C:\Users\KHBS_D_04\Desktop\workspace_java\25컬렉션그리고제네릭\src\Collections01.java 파일에 기록된 데이터들을 모두 읽어와 모니터에 출력

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOTest03 {

	public static void main(String[] args) {
		
		//1. Collections01.java 파일에 기록된 전체 데이터 중에서
		//	 1byte(8bit) 메모리에 저장할 크기의 데이터만 읽어와 저장할 변수
		int data = 0;
		
		//2. 읽어들일 데이터가 기록된 Collections01.java 파일의 전체 경로(절대 경로)를 문자열로 만들어 변수에 저장
		String path = "C:\\Users\\KHBS_D_04\\Desktop\\workspace_java\\25컬렉션그리고제네릭\\src\\Collections01.java";
		
		try {
			//3. Collections01.java 파일에 기록된 바이트 단위로 읽어들이기 위한 입력 스트림 통로 역할의 FileInputStream 클래스의 객체 생성
			// 작성 방법1. FileInputStream 참조변수 = new FileInputStream("파일절대경로");
			FileInputStream fis = new FileInputStream(path);
		
			// 작성 방법2.	 File file = new File("파일절대경로");
			//			 FileInputStream 참조변수 = new FileInputStream(file 객체 전달);
			
			//4. Collections01.java 파일에 기록된 전체 데이터 중에서 1바이트 단위로 반복해서 읽어들여 모니터 화면에 내보내어 출력
			while((data = fis.read()) != -1) {
				
				// read() 메소드를 호출해 new FileInputStream(path); 입력 스트림 통로에서 한 번 1바이트 읽어들인 내용을
				// System.out -> PrintStream 출력 스트림 통로 객체를 통해서 모니터 화면에 1바이트씩 내보내어 반복해서 출력
				System.out.write((char)data);
			}
			
		}catch(Exception e) {// <--- new FileNotFoundException 또는 IOException 자식 객체의 주소를 업 캐스팅해서 모두 전달 받음.
			
			e.printStackTrace(); // 결론: 어떤 예외가 발생하던지 간에 모든 예외 메세지 출력 가능, 모든 예외 처리 코드 작성 가능
		}
		
	}// === main Method

}// --- IOTest03 Class


