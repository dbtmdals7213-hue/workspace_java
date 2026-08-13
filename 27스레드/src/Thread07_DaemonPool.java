
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//1. 데몬 스레드용 작업: 1초 마다 자동 저장을 반복한다.
class AutoSaveTask implements Runnable {
	
	@Override
	public void run() {
		
		// 무한 반복: 데몬 스레드는 main 스레드의 작업이 끝나면 자동으로 함께 종료되어 무한 반복 작업해도 된다.
		while(true) {
			
			try {
				
				// 1초 대기 후  저장 메세지를 출력한다.
				Thread.sleep(1000);
				
				System.out.println("(데몬 스레드)자동 저장 실행...");
			} catch (InterruptedException e) {
				
				break; // 데몬 스레드가 중단되면 반복 종료
			}// catch 블록
			
		}// while 반복문
		
	}// === run Method
	
}// --- AutoSaveTask Class


//2. 스레드 풀용 작업: 요청 1건 처리를 흉내낸다.
class HttpRequestTask implements Runnable {
	
	int requestNo; // 요청 번호
	
	// 생성자: 요청 번호 초기화
	public HttpRequestTask(int requestNo) {
		
		this.requestNo = requestNo;
	}// HttpRequestTask 생성자
	
	@Override
	public void run() {
		
		// 어떤 스레드가 이 요청을 처리하는지 출력하기
		System.out.println("요청" + requestNo + " 처리 시작 - 담당: " + Thread.currentThread().getName());
		
		// 요청 처리에 0.5초가 걸린다고 가정
		try {
			
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}// catch 블록
		
		// 처리 완료 메세지 출력한다.
		System.out.println("요청" + requestNo + " 처리 완료!");
		
	}// === run Method
	
}// --- HttpRequestTask Class


public class Thread07_DaemonPool {

	// main 스레드 역할: 다른 일반 작업 스레드를 생성하고 작업 시작 후 끝내는 역할
	public static void main(String[] args) throws InterruptedException {
		
		//---------- [1] 데몬 스레드 생성 ----------
		// 데몬 스레드 만드는 방법
		//순서1.	일반 작업 스레드 생성
		//순서2.	일반 작업 스레드를 데몬 스레드로 변경
		
		Thread autoSave = new Thread(new AutoSaveTask(), "자동 저장 스레드"); // <- 일반적인 작업 스레드
		autoSave.setDaemon(true); // <- 데몬 스레드로 변경
		autoSave.start();
		
		// ---------- [2] 스레드 풀 생성 ----------
		// 스레드 2개 보관할 수 있는 스레드 풀을 만든다.
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		// 요청 5건을 풀에 제출한다.(사용자 5명이 거의 동시에 접속)
		for(int i = 1; i <= 5; i++) {
			
			pool.execute(new HttpRequestTask(i));
		}
		
		// 풀 종료 예약: 제출된 작업이 다 끝나면 풀의 스레드들을 정리한다.
		pool.shutdown();
		
		// 데몬 스레드 동작을 관찰하기 위해 main 스레드가 3.5초 유지한다.
		
		Thread.sleep(3500);
		System.out.println("main 스레드 종료 -> 데몬 스레드도 자동 종료된다.");
		
	}// === main Method

}// --- Thread07_DaemonPool Class




