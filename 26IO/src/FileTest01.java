
import java.io.File; // 파일 / 디렉터리 정보 조작용 클래스
import java.io.IOException; // 입 출력 예외 클래스
import java.util.Date; // 밀리초 정수를 사람이 읽는 날짜로 바꿔주는 클래스

public class FileTest01 {

	public static void main(String[] args) throws IOException {// main 메소드 내부에서 입 출력 예외가 발생하면
															   // main 메소드를 호출한 JVM 아 니가 알아서 입 출력 예외 처리해라!
															   // 예외 처리 떠넘기기 throws IOException
		// 파일명을 입력 받아 저장할 byte 배열 메모리 생성(100칸, 각 칸의 초기값은 전부 0)
		byte[] byteFileName = new byte[100];
		
		System.out.print("정보를 확인할 파일명(또는 경로)을 입력하세요: ");
		
		/*
			키보드로부터 입력 받은 파일명을 입력 스트림 통로를 통해 
			위 선언된 byteFileName byte 배열의 크기 100바이트만큼 "최대" 한 번에 읽어들여
			byteFileName byte 배열 메모리의 각 칸에 저장시킵니다.
			요약: 키보드에서 입력 받은 파일명을 new byte[100]; 배열에 저장
			작성 방법: InputStream 에 만들어져 있는 read(byte[] b) 메소드를 호출해서 사용
		*/
		System.in.read(byteFileName);
		
		// 위 byteFileName byte 배열에 읽어온 파일명을 문자열로 변환해서 저장할 변수 선언
		String fileName = null;
		
		fileName = new String(byteFileName).trim();
		// "a.txt"
		
		// 키보드로 입력 받은 파일명 "a.txt" 을 이용해 실제 만들어져 있는 "a.txt" 파일에 접근하기 위해
		// 파일명을 포함한 경로를 File 클래스에서 제공해주는 생성자로 전달해 File 클래스의 객체 메모리 생성!
		// 작성 문법.
		// File 참조변수 = new File("파일이 실제 저장되어 있는 파일명을 포함한 파일 전체 경로")
		File file = new File(fileName);
		//			new File("a.txt"); 또는 new File("FileTest01.java"); ...
		
		// 파일 정보를 출력하기 전에 실제로 존재하는 파일인지 먼저 확인한다.(사고 방지)
		// 조건: 실제 파일이 만들어져 있지 않느냐?
		if(file.exists() == false) {
			
			// 파일이 만들어져 있지 않으면 안내 메세지만 출력
			System.out.println(fileName + " -> 존재하지 않는 파일(경로)입니다!");
			
			System.out.println("(입력한 상대 경로가 절대 경로로 어떻게 해석되는지 확인: " + file.getAbsolutePath() + ")");
			
			return; // main 메소드 강제 종료
		}
		
		// 실제 파일이 만들어져 있다면?
		System.out.println(fileName + " 파일 상세 내용 출력 *****************");
		
		// 파일이 실제 위치한 전체 경로 얻어 출력
		System.out.println(fileName + " 파일 실제 만들어져 있는 절대 경로 전체: " + file.getAbsolutePath()); // <--- 중요!!!
		
		// lastModified(): 파일이 마지막으로 수정된 시각을 "밀리초 정수" 로 반환
		// -> 사람이 읽을 수 있는 날짜로 바꾸기 위해 new Date(밀리초) 생성자에 넣어 변환한다.
		//	  (정확히는 생성일이 아니라 "마지막 수정일" 이다!)
		System.out.println(fileName + " 파일 마지막 수정일: " + new Date(file.lastModified()));
		
		// length(): 파일 크기를 바이트 단위 정수로 반환
		System.out.println(fileName + " 파일 크기: " + file.length() + "byte");
		
		// getName(): 파일 경로를 빼고 순수한 파일명만 반환	예) "C:\a\b.txt" -> "b.txt"
		System.out.println(fileName + " 파일명(실제 만들어져 있는 파일명만): " + file.getName()); // <--- 중요!!!
		
		// canRead(): 이 파일을 읽기 모드로 열어 읽을 수 있는가? true / false
		System.out.println(fileName + " 파일을 열어 파일의 내용을 읽을 수 있는지에 대한 반환 값: " + file.canRead());
		
		// isHidden(): 숨김 속성이 설정되어 있는 파일인가? true / false
		System.out.println(fileName + " 파일이 현재 숨겨져 있는 숨김 파일인지에 대한 반환 값: " + file.isHidden());
		
		// getParent(): 이 파일이 들어있는 부모(상위) 디렉터리 경로 반환
		System.out.println(fileName + "파일이 저장된 부모 상위_디렉터리 이름 반환: " + file.getParent());
		
	}// === main Method

}// --- FileTest01 Class


