
// 방법1. Thread 클래스 상속하여 하나의 작업 흐름을 정리하는 일꾼(개발자가 직접 만드는 스레드)을 만든다.
class MyThread extends Thread {

	// 스레드가 시작되면 run() 안의 코드가 실행된다.
	// 결론: 스레드가 할 일을 run() 메소드 내부에 작성 해놓자
	@Override
	public void run() {// 할 일: 1부터 3까지 반복해서 출력
		
		for(int i = 1; i <= 3; i++) {
			
			// this.getName(): 현재 일하고 있는 스레드의 이름을 반환한다.(Thread 에게 상속받은 메소드)
			System.out.println(this.getName() + " 실행: " + i);
		}
	}
	
}// --- MyThread Class


public class Thread01_Create {

	// main 스레드: 다른 스레드에게 일을 시키고, 프로그램 시작과 끝을 담당하는 스레드
	public static void main(String[] args) {
		
		// --- 방법1 ---
		// Thread 클래스를 상속한 클래스는 그 자체가 스레드이므로 바로 start() 메소드 호출 가능
		MyThread t1 = new MyThread(); // <--- 스레드
		t1.setName("상속스레드"); // 스레드 이름 저장(저장 안하면 Thread-0, Thread-1 ...)
		t1.start(); // 새 스레드를 만들고 run() 메소드를 JVM 에게 실행시키는 명령어
		
		
		
	}// === main Method

}// --- Thread01_Create Class
