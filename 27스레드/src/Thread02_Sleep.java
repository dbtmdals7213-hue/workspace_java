
// 1초 간격으로 진행 상황을 출력하는 작업을 하는 스레드를 만들기 위한 일반 클래스
class DownloadTask implements Runnable {

	@Override
	public void run() {
		
		try {
			
			for(int i = 1; i <= 3; i++) {
				
				// 현재 작업 중인 스레드 이름과 진행률을 출력한다.
				System.out.println(Thread.currentThread().getName() + " 진행중... " + i + " / 3");
				
				// 현재 작업 중인 스레드를 1초(1000 밀리초) 정지(휴식) 시킨다.
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			
			// sleep 메소드 실행 중에 interrupt 되면 여기로 온다.
			e.printStackTrace();
		}// catch 블럭
		
		// 반복이 끝나면 완료 메세지를 출력한다.
		System.out.println(Thread.currentThread().getName() + " 작업 완료!");
		
	}// === run Method
	
}// --- DownloadTask Class


public class Thread02_Sleep {

	public static void main(String[] args) {
		
		//1. 스레드가 작업할 코드가 작성된 run() 메소드가 작성된 일반 클래스의 객체 생성
		DownloadTask task = new DownloadTask();
		
		//2. 실제 스레드 2개를 만든다
		Thread t1 = new Thread(task, "파일다운로드-A");
		Thread t2 = new Thread(task, "파일다운로드-B");
		
		//3. 스레드 작업시키기
		// start(): 새 스레드를 만들고, 그 스레드가 new DownloadTask(); 내부의 run() 을 실행하게 된다.
		t1.start();
		t2.start();
		
		//4. main 스레드는 두 다운로드를 기다리지 않으므로 이 줄이 대게 가장 먼저 출력된다.
		System.out.println("main 스레드: 두 다운로드하는 스레드를 시작시켰다.");
		
	}// === main Method

}// --- Thread02_Sleep Class




