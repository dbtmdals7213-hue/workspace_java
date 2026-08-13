
//=========================================
//[클래스 1] 1부터 max 변수 값까지의 합계를 구하는 작업
//=========================================
class SumTask implements Runnable {
	
	int max; // 계산 범위의 끝 값. 생성자로 전달 받는다.
	long result = 0; // 계산 결과 값. 스레드가 끝난 뒤 main 메소드에서 꺼내 쓴다.
	
	// 생성자
	public SumTask(int max) {
		
		this.max = max;
	}
	
	// 스레드가 작업할 코드 작성하는 run 메소드 오버라이딩
	@Override
	public void run() {// 작업: 1부터 max 변수 값까지의 합계 구하기
		
		for(int i = 1; i <= max; i++) {
			
			result = result + i;
		}
		
		// 계산이 다 끝난 뒤 실행되는 코드 줄
		// Thread.currentThread(): 지금 이 코드를 실행 중인 스레드 객체를 얻고(1단계)
		// .getName(): 그 스레드의 이름을 얻는다.(2단계)
		System.out.println(Thread.currentThread().getName() + " 계산 완료!");
	}// === run Method
	
}// --- SumTask Class


public class Thread03_Join {

	public static void main(String[] args) {
		
		// 작업 객체(run 메소드가 작성된 클래스의 객체) 2개를 따로 만든다.
		SumTask task1 = new SumTask(100); // 1부터 100까지의 합계를 구할 작업을 run 메소드 내부에서 코드에 의해 한다.
		SumTask task2 = new SumTask(1000); // 1부터 1000까지의 합계를 구할 작업을 run 메소드 내부에서 코드에 의해 한다.
		
		// 실제 스레드 2개를 만든다.
		// 방법
		// new Thread(작업객체, 스레드 이름);
		Thread t1 = new Thread(task1, "계산기-1");
		Thread t2 = new Thread(task2, "계산기-2");
		
		
	}// === main Method

}// --- Thread03_Join Class




