
import java.io.*;

public class FileUploadDownload {

	public static void main(String[] args) {
		
		//====================
		//1. 파일 경로 설정
		//====================
		// 사용자가 가지고 있다고 가정한 업로드 할 원본 파일 경로
		String sourceFile = "userFile.txt";
		
		// 서버 역할을 하는 업로드 폴더 경로
		String uploadDir = "upload/";
		
		// 업로드 완료 후 서버(upload 폴더)에 저장될 파일의 전체 경로
		String uploadFile = uploadDir + "userFile.txt";
		//				  = "upload/userFile.txt";
		
		// 사용자가 업로드 된 파일을 내려받은 폴더 경로
		String downloadDir = "download/";
		
		// 다운로드 후 사용자에게 보일 파일 전체 경로
		// 원본 파일명과 구분하기 위해 _copy 를 붙임
		String downloadFile = downloadDir + "userFile_copy.txt";
		//					= "download/userFile_copy.txt";
		
		//====================
		//2. 폴더 생성
		//====================
		// 파일은 반드시 폴더 안에 저장되므로
		// 폴더가 없으면 파일 생성 자체가 불가능하다. 그래서 폴더를 먼저 만들어둔다.
		//
		// File 클래스의 mkdirs(): 폴더가 없으면 생성, 이미 생성되어 있으면? 아무일도 하지 않음
		new File(uploadDir).mkdirs();
		
		new File(downloadDir).mkdirs();
		
		//====================
		//3. 파일 업로드 처리
		//====================
		System.out.println("파일 업로드 시작 ...");
		
		// copyFile(원본파일, 대상파일)
		// -> 원본 파일의 내용을 읽어서 대상 위치에 그대로 복사
		// -> 복사에 성공하면 true, 실패하면 false 반환
		if(copyFile(sourceFile, uploadFile)) {
			
			System.out.println("파일 업로드 완료!");
		}else {
			
			System.out.println("파일 업로드 실패!");
			
			// 업로드 실패 = 서버에 파일이 올라가지 않았다는 의미이므로
			// main 메소드 종료하여 다운로드 기능이 실행되지 않게 한다.
			return;
		}
		
		//====================
		//4. 파일 다운로드 처리
		//====================
		System.out.println("파일 다운로드 시작 ...");
		
		// 서버(upload 폴더)의 "upload/userFile.txt" 를
		// 사용자(download 폴더)의 "download/userFile_copy.txt" 로 복사
		if(copyFile(uploadFile, downloadFile)) {
			
			System.out.println("파일 다운로드(copy) 완료!");
		}else {
			
			System.out.println("파일 다운로드(copy) 실패!");
		}
		
	}// === main Method

	//======================================
	// 파일 복사 메소드 - try-with-resources 적용
	//======================================
	// -> from 매개변수로 전달 받은 경로의 파일의 to 매개변수로 전달 받은 전체 경로의 파일 그대로 복사한다.
	
	public static boolean copyFile(String from, String to) {
		
		//1. 원본 파일이 실제로 존재하는지 확인
		// -> 컴퓨터는 저장되어 있지 않은 파일의 정보를 읽어들일 수 없다.
		//	  그래서 복사 전에 반드시 파일이 있는지 확인해야 한다.
		
		// File 객체 = 파일 정보에 접근하기 위한 객체
		File source = new File(from);
		
		// exists(): 해당 위치에 파일이 실제로 존재하면 true, 없으면 false
		if(!source.exists()) {// 업로드 할 원본 파일 "userFile.txt" 이 존재하지 않느냐?
			
			System.out.println("원본 업로드 할 파일이 존재하지 않습니다: " + from);
			
			// 자바 프로그램이 기준으로 삼는 실제 실행 위치를 출력
			System.out.println("실행 위치: " + source.getAbsolutePath());
			
			// 원본 파일이 없으므로 복사 실패
			return false;
		}
		try(FileInputStream fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(to)) {
			
			//2. 원본 파일의 내용을 읽어들여 새로운 파일에 기록(실제 복사)
			byte[] buffer = new byte[1024]; // 원본 파일 데이터를 한 번 읽어들일 때 담을 배열
											// JVM 의 Heap 영역에 1024 칸짜리 byte 배열이 만들어진다.
			
			// 반복문에서 실제로 읽어온 데이터 크기를 저장할 변수
			int readCount;
			
			while((readCount = fis.read(buffer)) != -1) {
				
				fos.write(buffer, 0, readCount);
			}// while 반복문
			
			// while 종료 후 = 파일 끝(-1)을 만남 = 전체 복사 완료를 알리기 위해 true 를 반환
			return true;
			
		}catch (Exception e) {
			
			//3. 복사 도중 예외 발생 시!
			// -> 파일이 갑자기 삭제 되거나, 파일 권한 문제 등이 발생할 수 있다.
			
			System.out.println("파일 처리 중 오류 발생");
			
			// 개발자가 원인을 확인할 수 있도록 예외 상세 정보 출력
			e.printStackTrace();
			
			return false; // 원본 파일 복사 실패
		}// catch 블럭
		
	}// === copyFile Method
	
}// --- FileUploadDownload Class


