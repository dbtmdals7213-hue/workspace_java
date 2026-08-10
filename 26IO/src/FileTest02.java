
import java.io.File;
import java.io.IOException;

public class FileTest02 {

	public static void main(String[] args) throws IOException {

		// 현재 26IO 디렉터리 정보를 얻기 위한 File 클래스의 객체 메모리 생성
		File fileDir = new File(".");
		
		// 현재 26IO 디렉터리 내부에 만들어져 있는 파일명 / 디렉터리 정보 문자열들을 모두 String[] 배열에 담아 얻어오기
		String[] strs = fileDir.list();
		
		for(int i = 0; i < strs.length; i++) {
			
			System.out.println(strs[i]);
		}// for 반복문
		
		// d.txt 파일에 접근해서 정보를 보기 위해 File 클래스의 객체 메모리 생성
		File file = new File("C:\\a\\d.txt");
		
		/*
			File 클래스의 delete() 메소드를 호출해서 사용하면 d.txt 파일 삭제 후 
			삭제에 성공하면 true 반환, 삭제에 실패하면 false 반환하게 됩니다.
		*/
		if(file.delete()) {// d.txt 파일 삭제 후 삭제에 성공했느냐? 라고 조건식
			
			System.out.println("d.txt 파일 삭제 완료");
		}else {// d.txt 파일 삭제에 실패했느냐?
			
			System.out.println("d.txt 파일 삭제 실패");
		}
		
		System.out.println("---------------------------");
		
		// 실제 만들어져 있지 않은 b 디렉터리를 a 디렉터리 내부에 새로 만들어 접근하기 위해 File 클래스의 객체 메모리 생성!
		// 작성 방법: 새로 만들 b 디렉터리의 경로를 생성자로 전달해서 File 클래스의 객체 생성
		File file2 = new File("C:\\a\\b");
		
		file2.mkdir(); // <--- 디렉터리 생성
		// file2.delete(); // <--- 디렉터리 또는 파일 색제
		
		/*
			File 클래스에서 제공해주는 isDirectory() 메소드는
			File 클래스의 객체 생성 시 전달한 전체 경로의 주소가 실제 디렉터리이냐? 라고 물어보는 메소드로
			디렉터리이면? true 반환하고, 디렉터리가 아니면? false 반환하는 메소드입니다.
		*/
		if(file2.isDirectory()) {
			
			System.out.println("b 는 디렉터리입니다."); // <--- 출력
		}else {
			
			System.out.println("b 는 파일입니다.");
		}
		
		file2 = new File("C:\\a\\c");
		
		file2.createNewFile(); // c 파일 새로 생성 후 생성에 성공하면 true 반환, 실패하면 false 반환
		
		/*
			File 클래스에서 제공해주는 isFile() 메소드는
			File 클래스의 객체 생성 시 생성자로 전달한 전체 경로의 주소가 실제 파일이냐? 라고 물어보는 메소드로
			실제 파일이면? true 반환하고, 파일이 아니면? false 를 반환하는 메소드입니다.
		*/
		if(file2.isFile()) {
			
			System.out.println("c 는 파일입니다."); // <--- 출력
		}else {
			
			System.out.println("c 는 디렉터리입니다.");
		}
		
		System.out.println("---------------------------");
		
		File file3 = new File("C:\\c");
		
		// File 클래스에서 제공해주는 mkdirs() 메소드를 호출하면
		// File 클래스의 생성자로 전달한 디렉터리가 존재하지 않으면? c 디렉터리를 생성합니다.
		file3.mkdirs();
		
		File file4 = new File("C:\\x\\y\\z");
		file4.mkdirs();
		
	}// === main Method

}// --- FileTest02 Class


