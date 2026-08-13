
//=======================================
//[클래스 1] synchronized 로 보호된 서비스 클래스
//=======================================
class SafeCountService {
	
	// 모든 스레드(홈페이지에 접속하는 클라이언트)가 공유하는 변수
	int count = 0;
	
	// ----- [형태 1] synchronized 키워드가 작성된 메소드 -----
	
	// 사이트 방문자 수를 1 올리는 기능의 메소드
	public synchronized void increase() {
		
		// 이 코드는 하나의 스레드가 실행하면 다른 스레드는 increase() 메소드 밖에서 대기하게 된다.
		// 이 코드를 실행 중인 스레드가 코드 실행을 마치면 대기중인 스레드가 이 코드를 실행하게 된다.
		count++;
	}// === increase Method
	
	// ----- [형태 2] synchronized 블록 -----
	public void increaseBlock() {
		
		String threadName = Thread.currentThread().getName();
		
		synchronized(this) {
			
			// 이 블록 안은 한 번에 한 스레드만 이 코드를 실행한다.
			count++;
		}// synchronized 보호 구역
		
	}// === increaseBlock Method
	
}// --- SafeCountService Class


//=============================================================
//[클래스 2] increase() 메소드를 반복 호출하는 작업(사용자 1명의 요청을 흉내 냄)
//=============================================================

class SafeIncreaseTask implements Runnable {
	
	// 어떤 서비스 객체를 사용할지 전달받아 저장한다.
	SafeCountService service;
	
	// 생성자: 사용할 서비스 객체를 전달받아 초기화
	public SafeIncreaseTask(SafeCountService service) {
		
		this.service = service;
	}// IncreaseTask 생성자
	
	@Override
	public void run() {
		
		// increase() 메소드를 1,000,000 번 호출한다
		for(int i = 0; i < 1000000; i++) {
			
			// synchronized 예약어로 보호된 increase() 메소드 호출.
			// service.increase();
			
			// synchronized 블록으로 보호된 increaseBlock() 메소드 호출.
			service.increaseBlock();
		}
		
	}// === run Method
	
}// --- SafeIncreaseTask Class


public class Thread05_Synchronized {

	public static void main(String[] args) throws InterruptedException {
		
		// 동기화가 적용된 서비스 객체를 "딱 1개" 만든다.
		SafeCountService service = new SafeCountService(); // 모든 스레드가 공유해서 사용할 count 변수가 포함되어 있음
		
		// 같은 서비스를 사용하는 run() 메소드가 작성된 작업 객체
		SafeIncreaseTask task = new SafeIncreaseTask(service); // 스레드가 할 작업의 코드 run() 이 적힌 일반 클래스의 작업 객체
		
		// 홈페이지에 접속하는 사람 2명
		Thread t1 = new Thread(task, "사람A");
		Thread t2 = new Thread(task, "사람B");
		
		// 홈페이지에 동시에 접속(사람A, 사람B 스레드 동시에 시작시키자)
		t1.start();		t2.start();
		
		// 사람A, 사람B 가 접속할 때까지 main 스레드 대기
		t1.join();		t2.join();
		
		// 사람A 100만번 접속, 사람B 100만번 접속이 끝날 때까지 main 스레드는 모든 접속이 끝나면 아래의 작업을 출력
		System.out.println("기대 총 접속 수: 2000000");
		System.out.println("실제 총 접속 수: " + service.count);
		
	}// === main Method

}// --- Thread05_Synchronized Class




