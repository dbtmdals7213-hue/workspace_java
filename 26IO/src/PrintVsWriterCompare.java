import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files; // 파일 크기 확인(size), 바이트 읽기(readAllBytes 메소드 제공) 등
							// 검증용으로 사용할 NIO 패키지의 파일 작업 클래스(전부 static 메소드 제공)
import java.nio.file.Path; // 파일 경로 저장 객체

public class PrintVsWriterCompare {

	public static void main(String[] args) throws IOException {
		
		Path psPath = Path.of("ps_out.txt"); // PrintStream 이 기록할 파일 경로 저장되어 있음
		Path pwPath = Path.of("pw_out.txt"); // PrintWriter 가 기록할 파일 경로 저장되어 있음
		
		//=====================================
		//[1] 같은 텍스트 데이터 5종을 두 통로로 각각 출력
		//=====================================
		System.out.println("===== [1] 같은 데이터를 두 통로(PrintStream, PrintWriter)로 출력 =====");
		
		// PrintStream 출력 스트림 통로 객체 생성
		// - new PrintStream("파일명"): 그 파일과 연결된 바이트 계열 출력 통로를 연다.
		// - 파일이 없으면 새로 만들고, 이미 있으면 내용을 지우고 덮어쓴다.
		// - 파일을 만들 수 없으면 예외 발생(IOException 계열)
		PrintStream ps = new PrintStream("ps_out.txt");
		
		// PrintWriter 출력 스트림 통로 객체 생성
		// - new PrintWriter("파일명"): 그 파일과 연결된 문자 계열 출력 스트림(통로) 연다.
		// - 파일 생성 / 덮어쓰기 규칙은 PrintStream 과 같다.
		PrintWriter pw = new PrintWriter("pw_out.txt");
		
		ps.println(10);			pw.println(10); // int 10 ---> 문자 "10" 으로 변환 후 파일에 기록
		ps.println(3.14);		pw.println(3.14); // double 3.14 ---> 문자 "3.14" 로 변환 후 파일에 기록
		ps.println('A');		pw.println('A'); // char 'A' ---> 문자 그대로 파일에 기록
		ps.println("가나");		pw.println("가나"); // 한글 문자열 ---> UTF-8 3바이트 x 2자 기록
		ps.println("Hello");	pw.println("Hello"); // 영문 문자열 ---> 1바이트 x 5자 기록
		
		// 출력 스트림들 통로 닫기
		// - close(): 통로 내부 버퍼에 남아있는 데이터를 전부 파일로 내보내고(확정)
		//			  파일과 연결을 끊는다.
		ps.close(); // PrintStream 객체 통로 닫기
		pw.close(); // PrintWriter 객체 통로 닫기
		
		//=========================================
		//[2] 두 파일의 크기와 바이트 내용 비교 -> 사실 1 증명
		//=========================================
		
		// Files.size(Path 객체): 디스크에서 그 파일의 실제 크기를 바이트 단위로 반환
		// - 반환 타입이 long 인 이유: 파일 크기는 int 의 최대값(약 21억)을 넘을 수 있으므로 더 큰 정수 long 으로 받는다
		long psSize = Files.size(psPath); // ps_out.txt 의 크기를 psSize 에 저장
		long pwSize = Files.size(pwPath); // pw_out.txt 의 크기를 pwSize 에 저장
		
		System.out.println("PrintStream 파일 크기 = " + psSize); // 예상 출력: 28
		System.out.println("PrintWriter 파일 크기 = " + pwSize); // 예상 출력: 28
		
		// Files.readAllBytes(Path 객체)
		// - 파일 전체를 처음부터 끝까지 읽어 byte[] 배열로 만들어 반환한다.
		
		byte[] psBytes = Files.readAllBytes(psPath); // ps_out.txt 전체 바이트
		byte[] pwBytes = Files.readAllBytes(pwPath); // pw_out.txt 전체 바이트
		
		// java.util.Arrays.equals(배열1, 배열2)
		// - 두 배열을 비교해서 (1) 길이가 같고 (2) 모든 칸의 값이 같으면 true 반환
		// - 주의! psBytes == pwBytes 로 비교하면 "같은 객체인가" 를 묻는 것이라
		//		  내용이 같아도 false 가 나온다. 내용 비교는 반드시 equals 계열을 쓴다.
		boolean same = java.util.Arrays.equals(psBytes, pwBytes);
		
		System.out.println("두 파일의 바이트 정수 값이 완전히 같은가? = " + same);
		//				   "두 파일의 바이트 정수 값이 완전히 같은가? = true"
		// -> 사실1 증명 완료: println 텍스트 출력 결과는 두 클래스가 동일하다.
		
		System.out.println(); // 빈 줄 1개 출력
		
		//=====================================================
		//[3] write(int) 차이 실증 ---> 사실 2 증명. 여기서 결과가 갈린다.
		//=====================================================
		System.out.println("========== [3] write(44032) 실증 ==========");
		
		// 실증용 통로 2개를 새 파일로 다시 연다.
		PrintStream ps2 = new PrintStream("ps_w.txt"); // 바이트 계열 스트림 통로
		PrintWriter pw2 = new PrintWriter("pw_w.txt"); // 문자 계열 스트림 통로
		
		// 같은 정수 44032 를 같은 이름의 메소드 write 의 매개변수로 전달한다.
		ps2.write(44032); // 바이트 계열: 아래 8비트만 ---> 00 기록(1바이트)
		pw2.write(44032); // 문자 계열: '가' 로 해석 ---> EA B0 B0 기록(3바이트)
		
		ps2.close(); // 실증용 통로도 반드시 닫는다(버퍼 확정)
		pw2.close();
		
		// Path.of(...) 를 변수에 담지 않고 메소드 호출 자리에 바로 쓸 수도 있다.
		System.out.println("PrintStream write 메소드 사용 결과 파일 크기: " + Files.size(Path.of("ps_w.txt")));
		// 예상 출력: PrintStream write 메소드 사용 결과 파일 크기: 1
		
		System.out.println("PrintWriter write 메소드 사용 결과 파일 크기: " + Files.size(Path.of("pw_w.txt")));
		// 예상 출력: PrintWriter write 메소드 사용 결과 파일 크기: 3
		
		// 아래 보조 메소드를 호출해서 두 파일의 바이트 정수들을 16진수로 직접 확인한다.
		printHex("ps_w.txt");
		printHex("pw_w.txt");
		
	}// === main

	//===============================================================
	//[보조 메소드] printHex
	// - 매개변수로 전달받은 파일의 모든 가이트 값들을 16진수 두 자리씩 화면에 출력하는 기능
	//===============================================================
	public static void printHex(String fileName) throws IOException {
		
		
	}
	
}// --- PrintVsWriterCompare Class


