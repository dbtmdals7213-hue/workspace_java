
// 주제:	DataOutputStream 출력 스트림 통로를 통해
//		각 기본 자료형 변수에 저장된 데이터들을 파일에 쓰기(기록)

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataStreamTest1 {

	public static void main(String[] args) {
		
		// 기본 자료형 변수 선언 후 모두 데이터 저장
		char c = 'a'; // char 는 2 byte 크기 한 문자
		byte b = 10; // byte 는 1 byte 크기의 정수
		short s = 20; // short 는 2 byte 크기의 정수
		int i = 100; // int 는 4 byte 크기의 정수
		float f = 3.14f; // float 는 4 byte 크기의 실수
		double d = 1.5; // double 는 8 byte 크기의 실수
		
		// 참조 자료형 변수 선언 후 "문자열" 이 저장된 객체 메모리 주소 저장
		String str = "hello"; // String 클래스의 객체 메모리가 생성되고 그 내부에 "hello" 문자열이 저장됨
		
		try {
			
			/*
				참고.	 FileOutputStream
					 -> 파일에 바이트 단위로 데이터를 내보내는 기본 출력 스트림 통로
				
					 DataOutputStream
					 -> 기본 자료형(int, double, char 등)을 그대로 파일에 쓸 수 있도록 기능을 확장한 출력 스트림 통로
			*/
			// data.txt 파일에 위 변수에 저장된 값들을 쓰기(내보내기) 위한 메소드를 제공하는
			// DataOutputStream 출력 스트림 통로 역할을 하는 객체 생성
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
			
			dos.writeChar(c); // 'a'
			dos.writeByte(b); // 10
			dos.writeShort(s); // 20
			dos.writeInt(i); // 100
			dos.writeFloat(f); // 3.14f
			dos.writeDouble(d); // 1.5d
			dos.writeUTF(str); // "hello"
			
			// DataOutputStream 객체 메모리 다 사용 후 JVM 에서 제거
			dos.close();
			
		}catch (Exception e) {

			e.printStackTrace();
		}// catch 블럭
		
	}// === main Method

}// --- DataStreamTest1 Class


