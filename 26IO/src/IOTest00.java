
// 주제:	키보드로부터 문자를 입력 받아 모니터 장치 화면에 출력

import java.io.IOException;
import java.io.InputStream;

public class IOTest00 {

	public static void main(String[] args) {

		// 입력 스트림 통로에서 1바이트씩 읽어들인 정수 값(0 ~ 255 또는 끝이면 -1)을 저장할 변수
		int data = 0;
		
		try {
			System.out.print("하나의 문자를 입력하세요: ");
			
			//1. 키보드와 연결된 입력 스트림 통로 객체의 주소를 얻는다.
			//   (부모 InputStream 추상 클래스 자료형의 참조변수에 저장 - 업 캐스팅)
			InputStream inputStream = System.in;
			
			//1-1. 입력한 전체 데이터 중에서 첫 1바이트만 읽어들여 data 변수에 저장
			//	   (사용자가 아직 입력 전이면 여기서 멈춰 기다리다가,
			//		Enter 를 치는 순간 통로에 바이트들이 들어오고 첫 바이트를 읽는다.)
			data = inputStream.read();
			
			//1-2. 읽어들일 데이터가 아직 통로에 존재하면(끝 표시 -1이 아니면)
			//	   계속 반복해서 1바이트 단위로 읽어와 data 변수에 저장 후 사용
			while(data != -1) {
				
				//1-3. 읽은 정수 값을 (char)로 캐스팅해서 문자로 바꾼 후
				//	   출력 스트림 통로(System.out)를 통해 모니터로 내보낸다.
				//	   예: data 가 97이면 -> (char)97 -> 'a' 가 화면에 출력됨
				System.out.println((char)data);
				
				//1-4. 입력 스트림 통로에서 다음 1바이트를 읽어 저장(while 조건 검사로 되돌아감)
				data = inputStream.read();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}// === main Method

}// --- IOTest00 Class


