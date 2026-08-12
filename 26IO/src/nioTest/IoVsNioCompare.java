package nioTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class IoVsNioCompare {

	public static void main(String[] args) throws IOException {
		
		//1. 방식1. IO 스트림으로 쓰기
		System.out.println("========== [1] IO 스트림으로 쓰기 ==========");
		
		FileOutputStream fos = new FileOutputStream("io_data.txt");
		
		fos.write(65); // 'A' 1바이트가 통로에 들어간다.
		fos.write(66); // 'B'
		fos.write(67); // 'C'
		
		fos.close(); // 스트림 통로를 닫고 자원을 반납한다. 남은 데이터가 파일에 확정된다.
					 // 단점: 닫는 책임은 개발자에게 있다.
		
		System.out.println("io_data.txt 저장 완료(IO 패키지 방식)");
		System.out.println();
		
		//2. 방식1. IO 스트림으로 읽기
		System.out.println("========== [2] IO 스트림으로 읽기 ==========");
		
		FileInputStream fis = new FileInputStream("io_data.txt");
		
		int b; // 한 번 읽을 때마다 읽어들인 바이트 수 저장
		
		while((b = fis.read()) != -1) {
			
			System.out.println("IO read() = " + b);
		}
		
		fis.close(); // 읽기 통로도 개발자가 직접 작성해서 닫아야 한다 <- 단점
		System.out.println();
		
		//3. 방식2. NIO Files 클래스로 쓰기와 읽기
		System.out.println("===== [3] NIO Files 클래스로 쓰기와 읽기 =====");
		
		Path nioPath = Path.of("nio_files_data.txt");
		
		Files.writeString(nioPath, "ABC", StandardCharsets.UTF_8);
		
		System.out.println("nio_files_data.txt 저장 완료 (NIO Files 클래스 방식)");
		
		String result = Files.readString(nioPath, StandardCharsets.UTF_8);
		System.out.println("NIO Files 클래스로 읽기 결과: " + result);
		//					NIO Files 클래스로 읽기 결과: ABC
		
		System.out.println();
		
		//4. 방식3. NIO 채널 + 버퍼로 쓰기
		System.out.println("======== [4] NIO 채널 + 버퍼로 쓰기 ========");
		
		Path chPath = Path.of("nio_channel_data.txt"); // 쓰기 할 파일 경로
		
		FileChannel ch = FileChannel.open(chPath, StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE);
		
		ByteBuffer writerBuf = ByteBuffer.allocate(10);
		
		writerBuf.put((byte)65); // 'A' 를 버퍼에 담는다.
		writerBuf.put((byte)66); // 'B'
		writerBuf.put((byte)67); // 'C'
		
		writerBuf.flip();
		
		int writen = ch.write(writerBuf);
		
		System.out.println("FileChannel 채널 영역으로 쓴 바이트 수 = " + writen); // 3
		System.out.println();
		
		
		
		
	}// === main Method

}// --- IoVsNioCompare Class




