import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderWriterTest00 {

	public static void main(String[] args) throws IOException {
		
		int data = -1;
		// data 변수 설명
		// - 키보드로부터 입력된 "문자 1개" 를 지정할 변수
		// - read() 메소드는 int 타입을 반환하므로 int 로 선언
		// - -1은 "더 이상 읽을 데이터가 없다" 는 특별한 의미로 사용됨
		
		//========================
		//1. 바이트 스트림(System.in)
		//========================
		// 컴퓨터는 문자를 바로 이해하지 못하고 모든 데이터를 숫자(바이트) 형태로 처리한다.
		
		// System.in 은
		// - 키보드와 연결된 입력 통로이며 1바이트(byte)씩 데이터를 읽어들이기 위한 바이트 스트림 통로입니다.
		// 예)
		// 키보드에서 'A' 입력 -> 65(숫자)
		// 키보드에서 '가' 입력 -> 여러 개의 숫자(바이트)
		
		Reader myIn = new InputStreamReader(System.in);
		
		while(true) {
			
			data = myIn.read();
			
			if(data == -1) {
				
				break; // while 무한 반복 종료해서 InputStreamReader 입력 스트림에서 읽어들이지 말자!
			}
			
			System.out.println((char)data);
			
		}// while 반복문
		
	}// === main

}// --- ReaderWriterTest00 Class
