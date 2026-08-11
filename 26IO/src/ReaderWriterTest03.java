
import java.io.*;

public class ReaderWriterTest03 {

	public static void main(String[] args) throws IOException {
		
		//1. 변수 선언
		// - 사용자가 키보드로 입력한 "파일 이름" 을 저장할 변수
		String fileName = null;
		
		// - 파일에 저장할 내용을 "한 줄씩" 읽어서 임시로 담아둘 변수
		String buf = null;
		
		//2. 키보드로부터 입력 받은 데이터를 한 줄씩 읽어서 저장할 BufferedReader 입력 스트림 생성
		BufferedReader keyBr = new BufferedReader(new InputStreamReader(System.in));
		
		//3. 파일 이름 입력 받기
		System.out.print("파일 이름을 입력하세요 -> ");
		
		// 사용자가 키보드로 입력하고 엔터를 누를 때까지 기다린 후 입력한 내용을 한 줄(String)로 읽어옴
		fileName = keyBr.readLine();
		
		//4. 입력 받은 파일에 저장할 내용 입력을 받습니다
		System.out.println("파일에 기록할 내용을 입력하세요.");
		
		//5. 파일에 저장(출력, 기록)용 출력 스트림 통로 -> BufferedWriter 객체 생성
		BufferedWriter fileBw = new BufferedWriter(new FileWriter(fileName));
		
		//6. 키보드로부터 입력 받은 데이터 읽어서 -> 파일에 저장 이걸 반복 처리
		while((buf = keyBr.readLine()) != null) {
			
			//7. 파일에 한 줄씩 기록
			fileBw.write(buf);
			fileBw.newLine();
		}// while 반복문
		
		//8. 사용이 끝난 스트림 통로 닫기(아주 중요!)
		
		// 키보드 입력 스트림(BufferedReader) 종료
		// - 더 이상 입력한 데이터 읽어들일 수 없음
		keyBr.close();
		
		// 파일에 기록하는 출력 스트림(BufferedWriter) 종료
		// - BufferedWriter 객체 메모리 안에 포함되어 있는 내부 버퍼 메모리에 남아있던 데이터를 모두 강제로 파일에 기록하고
		//	 파일과의 연결을 해제하여 더 이상 파일에 내보내어 기록할 수 없음
		fileBw.close();
		
	}// === main Method

}// --- ReaderWriterTest03 Class


