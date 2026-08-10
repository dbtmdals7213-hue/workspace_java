
import java.io.File;

public class FileTest02 {

	public static void main(String[] args) {

		// 현재 26IO 디렉터리 정보를 얻기 위한 File 클래스의 객체 메모리 생성
		File fileDir = new File(".");
		
		// 현재 26IO 디렉터리 내부에 만들어져 있는 파일명 / 디렉터리 정보 문자열들을 모두 String[] 배열에 담아 얻어오기
		String[] strs = fileDir.list();
		
		for(int i = 0; i < strs.length; i++) {
			
			System.out.println(strs[i]);
		}
		
		
	}// === main Method

}// --- FileTest02 Class


