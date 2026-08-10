
// 주제:	키보드로부터 입력된 데이터의 바이트 총 개수 세기

import java.io.IOException;
import java.io.InputStream; // 바이트 단위로 데이터를 읽어들이기 위한 입력 스트림 통로 역할을 하는 추상 클래스로
							// InputStream 추상 클래스를 구현한 자식 클래스의 객체를 입력 스트림 통로로 사용

import java.io.OutputStream; // 바이트 단위로 데이터를 출력 장치에 내보내기 위한 출력 스트림 통로 역할을 하는 추상 클래스로
							 // OutputStream 추상 클래스를 구현한 자식 PrintStream 클래스의 객체를 출력 스트림 통로로 사용)

public class IOTest01 {

	public static void main(String[] args) {
		
		// 키보드 장치에서 입력 받은 전체 데이터 중에서 1바이트 크기의 데이터만 읽어들여 저장시킬 변수
		// (read() 의 반환값: 읽은 바이트의 정수 0 ~ 255, 입력 스트림 통로 끝이면 -1을 반환)
		int data = 0;
		
		// 읽어들인 바이트의 총 개수를 계산해서 저장할 변수(입력 스트림으로부터 데이터를 1번씩 읽어들일 때마다 1씩 증가시킬 예정)
		int cnt = 0;
		
		//1. 키보드로부터 입력한 전체 데이터 중에서 1바이트 단위로 읽어들일 입력 스트림 통로 역할을 하는
		//	 InputStream 추상 부모 클래스를 구현한 자식 클래스의 객체 주소 얻기(업 캐스팅)
		InputStream myIn = System.in; // <- 바이트 단위로 읽어들일 입력 스트림 통로
		
		//2. 입력 스트림 통로를 통해 읽어들인 바이트를 모니터 출력 장치 화면에 보내어 출력하기 위한 출력 스트림 통로 객체(PrintStream) 주소 얻기
		//	 (업 캐스팅: 부모 OutputStream 추상 클래스 자료형의 myOut 참조변수에 저장)
		OutputStream myOut = System.out;
		
		System.out.println("문자를 입력하세요. IOTest01.class 프로그램을 끝내려면 x 혹은 X 나 ctrl + z 단축키를 누르세요.");
		
		try {
			
			// 위 입력 스트림 통로를 통해 1바이트씩 읽어들이는데
			// 입력 스트림 통로 끝(-1)을 만나기 전까지 반복해서 계속 읽어들여 data 변수에 저장하자.
			// 참고. 실행 순서: read() 로 읽기 -> data 변수에 저장 -> 저장된 값을 -1과 비교
			while((data = myIn.read()) != -1) {
				
				// 소문자 x 나 대문자 X 를 입력하면 더 이상 입력 스트림 통로를 통해서 읽어들이지 못하게 while 반복 종료
				if(data == 'x' || data == 'X') {
					
					break; // break 가 cnt++ 보다 앞에 있으므로 x 자신은 개수에 세어지지 않고 화면에 출력되지도 않은 채로 while 반복 종료
				}
				
				// 1바이트씩 읽어들일 때마다 읽어들인 바이트 수 저장
				cnt++;
				
				// 1바이트씩 읽어들인 데이터를 출력 스트림 통로(PrintStream 객체)를 통해 모니터에 읽어들인 바이트 그대로 내보낸다.
				myOut.write(data);
			}
			
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("입력받은 총 문자의 개수 -> " + cnt);
		
	}// === main Method

}// --- IOTest01 Class


