
/*
	주제:	 키보드로 입력한 전체 데이터 중에서 "한 줄 단위" 로 읽어서 그 결과를 모니터에 출력하는 예제
	
	이 예제의 핵심 목적
	 - 왜 BufferedReader 를 쓰는지 이해
	 - readLine() 이 정확히 무엇을 읽는지 이해
	 - 문자 스트림의 실제 사용 방법 이해
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderWriterTest01 {

	public static void main(String[] args) throws IOException {
		
		//1. 키보드로 파일명을 입력 받아 저장할 변수 선언
		String fileName = null;
		
		//2. 문자 입력 스트림 통로 BufferedReader 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//3. 사용자에게 입력 안내 메세지 출력해서 보여주자
		System.out.println("파일 이름을 입력하세요: ");
		
		//4. 한 줄 단위로 입력한 데이터를 BufferedReader 입력 스트림 통로를 통해 읽어들이자
		fileName = br.readLine();
		
		//5. 입력한 결과 확인 용도 출력
		// 사용자가 키보드로 입력한 파일 이름을 화면에 다시 출력하여 확인
		System.out.println("입력한 파일명: " + fileName);
		
		//6. 스트림 통로 닫기(매우 중요!)
		
		// BufferedReader 스트림 통로 사용이 끝났으므로 반드시 close() 메소드를 호출하여 메모리 자원 제거
		
		// close() 를 호출하면 내부에 연결된 InputStreamReader 와 System.in 까지 함께 정리된다.
		br.close();
		
	}// === main Method

}// --- ReaderWriterTest01 Class


