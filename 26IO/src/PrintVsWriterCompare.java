import java.nio.file.Path; // 파일 경로 저장 객체

public class PrintVsWriterCompare {

	public static void main(String[] args) {
		
		Path psPath = Path.of("ps_out.txt"); // PrintStream 이 기록할 파일 경로
		Path pwPath = Path.of("pw_put.txt"); // PrintWriter 가 기록할 파일 경로
		
		//=====================================
		//[1] 같은 텍스트 데이터 5종을 두 통로로 각각 출력
		//=====================================
		System.out.println("===== [1] 같은 데이터를 두 통로(PrintStream, PrintWriter)로 출력 =====");
		
		
		
		
	}// === main

}// --- PrintVsWriterCompare Class


