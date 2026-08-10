import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOTest0A {

	public static void main(String[] args) {
		
		//1. 키보드로 입력 받은 전체 데이터 중에서 1바이트 크기의 데이터만
		//	 입력 스트림 통로를 통해 읽어들여 저장할 변수
		int data = 0;
		
		try {
			
			//2. PrintStream 출력 스트림 통로 역할의 객체 주소 얻기
			//	 (OutputStream 부모 추상 클래스 자료형의 참조변수에 저장 - 업 캐스팅)
			OutputStream outputStream = System.out;
			
			//=============================================
			// 시연1. void write(int b): 1바이트씩 하나하나 내보내기
			//=============================================
			outputStream.write(74); // 1바이트 내보냄 -> 'J'
			outputStream.write(97); // 1바이트 내보냄 -> 'a'
			outputStream.write(118); // 1바이트 내보냄 -> 'v'
			outputStream.write(97); // 1바이트 내보냄 -> 'a'
			outputStream.write(10); // 줄바꿈 문자 \n -> (10)도 내보냄
			outputStream.flush(); // 모아둔 것을 지금 즉시 화면으로 전부 내보내라!
			
			//=================================================
			// 시연2. void write(byte[] b): 배열 전체를 한 번에 내보내기
			//=================================================
			// 내보낼 바이트들을 미리 배열에 담아둔다.
			// 72 = 'H', 101 = 'e', 108 = 'l', 108 = 'l', 111 = 'o', 33 = '!'
			byte[] msg = {72, 101, 108, 108, 111, 33, 10}; // 마지막 10은 줄바꿈 '\n'
			
			outputStream.write(msg); // msg byte 배열 전체(7바이트)를 한 번에 출력 스트림 통로에 실어 모니터로 내보냄
			outputStream.flush(); // 즉시! 모니터 화면에 강제로 모두 보내기
			
			//==================================================================
			// 시연3. void write(byte[] b, int off, int len): 배열의 일부 구간만 내보내기
			//==================================================================
			// msg byte 배열에서 1번 index 부터 (off = 1) 4개(len = 4)만 골라 모니터 화면에 내보낸다.
			outputStream.write(msg, 1, 4); // msg[1] ~ msg[4]: 101, 108, 111 -> "ello"
			outputStream.write(10); // 보기 좋게 '\n' 한 줄 줄바꿈 추가
			outputStream.flush();
			
			//==============================================================================================
			// 시연4. 입력 스트림 통로와 연결: 입력 스트림 통로로부터 읽은 바이트 단위 데이터 그대로 write 메소드로 모니터에 되돌려주기(에코)
			//==============================================================================================
			//3. 입력 스트림 통로 역할의 객체 얻기
			InputStream inputStream = System.in;
			
			//4. 사용자에게 입력 요청 메세지  출력
			System.out.print("문자를 입력하세요.(끝내려면 Ctrl + Z 후 Enter): ");
			
			//5. 입력 스트림 통로에서 더 이상 읽어들일 데이터가 없을 때(read() 호출했을 때 반환 값 -1)까지
			//	 입력 스트림 통로에서 계속 반복해서 읽어들여 출력 스트림 PrintStream 객체의 write() 메소드로 모니터에 반복 내보내어 출력
			while((data = inputStream.read()) != -1) {
				
				// 한 번씩 읽은 1바이트 크기의 데이터를 모니터에 내보낸다.
				outputStream.write(data);
			}
		}catch(IOException e) {
			
			e.printStackTrace(); // 입 출력 예외 발생하면 보여줄 여외 메세지 출력
		}
		
	}// === main Method

}// --- IOTest0A Class


