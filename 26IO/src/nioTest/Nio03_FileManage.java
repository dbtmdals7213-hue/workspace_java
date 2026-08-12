
package nioTest;

import java.nio.charset.StandardCharsets;      // 문자 인코딩 상수 모음. UTF_8 사용
import java.nio.file.DirectoryStream;          // 폴더 안 항목을 하나씩 꺼내는 스트림 타입
import java.nio.file.Files;                    // 파일 작업을 실행하는 클래스. 전부 static 메서드
import java.nio.file.Path;                     // 파일 경로를 담는 객체의 타입
import java.nio.file.StandardCopyOption;       // 복사/이동 옵션 상수 모음 (REPLACE_EXISTING 등)
import java.io.IOException;                    // 파일 작업 실패 시 발생하는 예외 클래스
import java.util.List;                         // 목록 타입

/*
 * ==================================================================
 * [NIO 예제 3] 파일 복사, 이동, 삭제, 폴더 목록
 * ==================================================================
 *
 * ------------------------------------------------------------------
 * 1. 용어 정리 (이 예제에 나오는 자바 용어)
 * ------------------------------------------------------------------
 *
 *   버퍼        			: 데이터를 옮길 때 중간에 잠시 담아 두는 byte 배열.
 *                     	  Heap 에 만들어진다. 한 바이트씩 옮기는 것보다
 *                     	  묶어서 옮기는 것이 훨씬 빠르기 때문에 사용한다.
 *   DirectoryStream 	: 폴더 안의 항목(Path 객체)을 하나씩 꺼내 주는 스트림.
 *                     	  NIO 에서 유일하게 내 코드로 닫아야 하는 스트림이다.
 *   try-with-resources : try (스트림 생성) { 사용 } 형태의 문법.
 *                     	  try 블록이 끝나면 스트림의 close() 가 자동 호출된다.
 *   예외            		: 실행 중 오류. 아래 세 가지가 이 예제와 관련 있다.
 *                     	  FileAlreadyExistsException  이미 있는데 또 만들 때
 *                    	  NoSuchFileException         없는 것을 지우거나 읽을 때
 *                     	  DirectoryNotEmptyException  안 비운 폴더를 지울 때
 *
 *
 * ------------------------------------------------------------------
 * 2. copy 와 move 의 차이 (이 예제의 핵심)
 * ------------------------------------------------------------------
 *
 *   Files.copy(원본, 대상)  실행 후
 *     원본 위치 : 파일 그대로 있음
 *     대상 위치 : 파일 새로 생김
 *     디스크의 파일 개수 : 2개
 *
 *   Files.move(원본, 대상)  실행 후
 *     원본 위치 : 파일 없어짐
 *     대상 위치 : 파일 생김
 *     디스크의 파일 개수 : 1개
 *
 *   백업 작업은 원본이 남아야 하므로 copy 를 쓰고,
 *   분류/정리 작업은 원본 위치가 비워져야 하므로 move 를 쓴다.
 *
 *
 * ------------------------------------------------------------------
 * 2-1. IO(java.io) 와의 비교 - 같은 일을 하는 옛날 방식
 * ------------------------------------------------------------------
 *
 *   [이 예제의 NIO 코드와 IO 대응 코드]
 *
 *     NIO (이 예제, 각 1줄)     	 | IO (java.io 방식)
 *     --------------------------+------------------------------------------
 *     Files.copy                | 전용 메서드 없음. 스트림 2개 + 버퍼 반복을
 *                               | 직접 구현해야 했다 ([2] 에서 상세 비교)
 *     Files.move                | f.renameTo(대상) - 실패 시 false 만 반환
 *     Files.deleteIfExists      | f.delete()      - 실패 시 false 만 반환
 *     Files.newDirectoryStream  | f.listFiles()   - 전체를 배열로 한 번에
 *
 *   요약	 : IO 는 "복사 기능이 아예 없고", 나머지도 실패 원인을
 *    	   알려 주지 않는다. 이 두 가지가 NIO 로 바뀐 핵심 이유다.
 *
 *
 * ------------------------------------------------------------------
 * 3. 실행 순서 (게시판 첨부파일 처리 흐름)
 * ------------------------------------------------------------------
 *
 *   temp 폴더    : 업로드 직후 파일을 임시 보관하는 폴더
 *   upload 폴더  : 검사 후 정식으로 저장하는 폴더
 *   backup 폴더  : 복사본을 보관하는 폴더
 *
 *   [1] 폴더 3개 생성, 파일 2개 준비
 *   [2] temp 에서 upload 로 복사   --> 원본 유지 확인
 *   [3] temp 에서 upload 로 이동   --> 원본 소멸 확인
 *   [4] 파일 이름 변경 (같은 폴더 안 move)
 *   [5] upload 폴더 목록 출력 (DirectoryStream)
 *   [6] upload 전체를 backup 으로 복사
 *   [7] temp 의 파일 삭제
 *   [8] 백업된 파일 내용 확인
 * ==================================================================
 */
public class Nio03_FileManage {

    public static void main(String[] args) throws IOException {

        //==============================================================
        //[1] 폴더 3개와 파일 2개 준비
        //==============================================================
        System.out.println("======= [1] 폴더와 임시 파일 준비 =======");
        
        Path tempDir = Path.of("temp"); // temp 폴더의 경로가 저장된 Path 객체 얻기
        Path uploadDir = Path.of("uploads"); // upload 폴더의 경로가 저장된 Path 객체 얻기
        Path backupDir = Path.of("backup"); // backup 폴더의 경로가 저장된 Path 객체 얻기
        
        // Files.createDirectories(Path 객체);
        // - Path 객체 내부의 경로에 적힌 폴더를 생성하는 메소드
        Files.createDirectories(tempDir); // temp 폴더 생성
        Files.createDirectories(uploadDir); // uploads 폴더 생성
        Files.createDirectories(backupDir); // backup 폴더 생성
        
        System.out.println("temp / uploads / backup 폴더 준비 완료");
        
        // Path 인터페이스의 resolve("파일명"); 
        // - Path 객체에 저장된 "폴더 경로" + "/파일명" 한 새 경로 "폴더경로/파일명" 를 만들어 반환 해줍니다.
        Path tempReport = tempDir.resolve("report.txt"); // "temp/report.txt" <- 경로가 저장된 Path 객체
        Path tempNotice = tempDir.resolve("notice.txt"); // "temp/notice.txt" <- 경로가 저장된 Path 객체
        
        Files.writeString(tempReport, "8월 업무 보고서\n작성자 홍길동\n", StandardCharsets.UTF_8);
        Files.writeString(tempNotice, "8월 공지사항\n휴무일 안내\n", StandardCharsets.UTF_8);
        
        System.out.println("임시 원본 파일 2개 생성 완료");
        System.out.println();
        
        //==============================================================
        //[2] 원본 파일 복사해서 새 파일로 만든다 - Files.copy 메소드 사용
        //==============================================================
        System.out.println("========== [2] 복사(copy) ==========");
        
        // 복사본이 만들어질 위치의 경로(uploadDir + "report.txt")가 보관되는 Path 객체 만들기
        // 결과 -> "uploads/report.txt" 경로 만들어서 보관됨
        Path uploadReport = uploadDir.resolve("report.txt");
        
        Files.copy(tempReport, uploadReport, StandardCopyOption.REPLACE_EXISTING);
        
        System.out.println("복사 완료: " + tempReport + " -> " + uploadReport);
        //					복사 완료: temp\report.txt -> uploads\report.txt
        
        System.out.println("원본 파일 남아 있나? : " + Files.exists(tempReport)); // true <- 원본 파일 유지한다
        System.out.println("사본 생겼나? : " + Files.exists(uploadReport)); // true <- 복제한 사본이 새로 생김
        System.out.println();
        
        //==============================================================
        //[3] 파일 이동 - Files.move 메소드 사용
        //==============================================================
        System.out.println("======== [3] 파일 이동(move) ========");
        
        // 파일 이동 후 저장될 위치 경로 정보(upload/notice.txt)를 보관하는 Path 객체 얻기
        Path uploadNotice = uploadDir.resolve("notice.txt");
        
        Files.move(tempNotice, uploadNotice, StandardCopyOption.REPLACE_EXISTING);
        
        System.out.println("파일 이동 완료: " + tempNotice + " -> " + uploadNotice);
        //					파일 이동 완료: temp\notice.txt -> uploads\notice.txt
        
        // move 메소드의 성질 확인: 원본 위치는 비었고, 대상 이동 위치에만 파일이 이동되어 있다.(파일 1개 존재)
        System.out.println("원본 파일 남아 있나? : " + Files.exists(tempNotice)); // false <- move 메소드로 인해 원본 파일 이동되었으니 없음
        System.out.println("이동한 파일 있나? : " + Files.exists(uploadNotice)); // true
        System.out.println();
        
        //==============================================================
        //[4] 파일 이름 변경
        // 이름 변경 전용 메소드 NIO 패키지에 없다.
        // 같은 폴더 안에서 다른 이름으로 move 하면 결과가 이름 변경이 된다.
        //==============================================================
        System.out.println("======== [4] 파일 이름 바꾸기 ========");
        
        // 같은 uploads 폴더 안에서 "파일명만 다른" 경로가 보관된 Path 객체를 만든다.
        // 결과 -> "uploads/notice_202608.txt"
        Path renamed = uploadDir.resolve("notice_202608.txt");
        
        // 원본 파일과 대상의 "폴더는 같고 이름만 다른" move 메소드 사용
        // 실무에서는 파일명 중복을 막기 위해 날짜를 붙여 저장할 때 이렇게 쓴다.
        Files.move(uploadNotice, renamed, StandardCopyOption.REPLACE_EXISTING);
        
        System.out.println("파일 이름 변경: notice.txt -> notice_202608.txt");
        System.out.println();
        
        //==========================================================================
        //[5] 폴더 목록 출력 - DirectoryStream 스트림 통로 이용
        // 여기서만 스트림 통로 객체를 개발자가 직접 코드 작성해서 다룬다.
        // 그래서 유일하게 예외 처리를 통한 스트림 통로 제거해야 한다. try-with-resources 구문이 나온다.
        //==========================================================================
        System.out.println("===== [5] uploads 폴더 목록 출력 =====");
        
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(uploadDir)) {
        	
        	for(Path p : stream) {
        		
        		// 출력 예) 파일명: notice_202608.txt / 크기: 35 bytes
        		//		  파일명: report.txt / 크기: 42 bytes
        		System.out.println("파일명: " + p.getFileName() + " / 크기: " + Files.size(p) + " bytes");
        	}// for 반복문
        }// try(...){} 블록의 끝. 이 중괄호 } 내부에서 stream.close() 가 자동으로 호출된다.
        
        System.out.println();
        
        //==============================================================
        //[6] 전체 파일 백업 - uploads 폴더에 모든 파일을 backup 폴더로 복사
        //==============================================================
        System.out.println("========= [6] 전체 파일 백업 =========");
        
        int count = 0;
        
        // uploads 폴더를 향해 스트림 통로를 다시 연다
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(uploadDir)) {
        	
        	for(Path p : stream) {// uploads 폴더 안 항목을 1개씩 꺼내 반복
        		
        		// uploads/notice_202608.txt
        		// uploads/report.txt
        		
        		Path target = backupDir.resolve(p.getFileName());
        		
        		// 백업이므로 Files 클래스의 copy 메소드를 사용한다.(원본 파일 유지가 백업의 목적)
        		Files.copy(p, target, StandardCopyOption.REPLACE_EXISTING);
        		
        		// 백업한 파일명을 반복해서 출력
        		System.out.println("백업: " + p.getFileName());
        		
        		// 총 몇 번 파일 백업했는지
        		count++;
        	}// for 반복문
        }// try(...){}
        
        System.out.println("총 " + count + "개 파일 백업 완료"); // 총 2개 파일 백업 완료
        System.out.println();
        
        //==============================================================
        //[7] 파일 삭제 - Files.deleteIfExitsts() 메소드 사용
        //==============================================================
        System.out.println("=========== [7] 파일 삭제 ===========");
        
        // 삭제할 파일의 경로가 보관되는 Path 객체 만들기
        Path tempTarget = tempDir.resolve("report.txt");
        
        // Files.deleteIfExists(삭제할파일경로);
        // -> 삭제할 파일 경로에 파일 있으면? 삭제하고 true 를 돌려준다.
        // -> 삭제할 파일 경로에 파일이 있는데 삭제에 실패하면? 삭제 실패 이유에 관한 예외 메세지를 알려준다.
        // -> 삭제할 파일 경로에 파일 없으면? 아무일 없이 false 를 돌려준다.
        boolean deleted = Files.deleteIfExists(tempTarget);
        
        System.out.println("temp/report.txt 삭제되었나? : " + deleted); // true <- 삭제됨
        System.out.println("삭제 후 존재? : " + Files.exists(tempTarget)); // false
        System.out.println();
        
        //==============================================================
        //[8] 백업 파일 내용 확인
        // 파일 개수만으로 백업 성공을 확신할 수 없다.
        // 내용까지 같아야 진짜 성공이므로 읽어서 확인한다.
        //==============================================================
        System.out.println("======= [8] 백업 파일 내용 확인 =======");
        
        // 백업이 되어있는 파일의 전체 경로를 보관하는 Path 객체 얻기
        // -> "backup/report.txt"
        Path backupReport = backupDir.resolve("report.txt");
        
        List<String> lines = Files.readAllLines(backupReport, StandardCharsets.UTF_8);
        
        // ArrayList 배열의 각 칸에 저장된 report.txt 에서 읽어들인 문자열을 반복해서 얻어 출력
        for(String line : lines) {
        	
        	System.out.println("report.txt 파일에서 읽어온 내용: " + line);
        	// report.txt 파일에서 읽어온 내용: 8월 업무 보고서
        	// report.txt 파일에서 읽어온 내용: 작성자 홍길동
        }// for 반복문
        
        System.out.println();
    }// === main Method

}// --- Nio03_FileManage Class




