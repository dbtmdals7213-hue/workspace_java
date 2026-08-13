
// 음료를 공급해서 쌓아 두기 위한 비커 모양의 메모리를 만들기 위해 사용할 Stack 클래스 import
import java.util.Stack;

class AutoMachine {// <- 자판기
	
	Stack store = new Stack();
	
	public synchronized String getDrink() {
		
		try {
			
			this.wait();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}// catch 블록
		
		// 자판기의 음료 보관함(Stack 메모리)에서 음료 하나를 꺼내서 문자열 형태로 반환
		return store.pop().toString();
	}// === getDrink Method
	
	public synchronized void putDrink(String drink) {
		
		// 자판기의 음료 보관함(Stack 메모리)에 음료를 하나 넣음
		store.push(drink);
		
		// 바로 윗 줄에서 음료 보관함(Stack 메모리)에 음료 하나 공급했으니 소비자 스레드야 wait() 그만하고 다시 pop() 해!
		this.notify();
		
	}// === putDrink Method
	
}// --- AutoMachine Class


class Producer implements Runnable {
	
	// 자판기 객체의 주소 저장(공유 자원)
	private AutoMachine machine;
	
	// 생성자 - 자판기 객체의 주소를 매개변수로 받아 위 machine 에 저장
	public Producer(AutoMachine machine) {
		
		this.machine = machine;
	}// Producer 생성자
	
	// 공급자 스레드가 할 작업
	@Override
	public void run() {
		
		// 음료 1번 ~ 9번까지 AutoMachine 객체 내부의 Stack 음료 보관함에 공급
		for(int i = 1; i <= 9; i++) {
			
			// 공급자 스레드가 음료 보관함에 음료 공급 중이라는 모습 출력
			System.out.println(Thread.currentThread().getName() + " : 음료수 No." + i + " 공급함");
			
			// 자판기의 음료 보관함에 음료 공급(넣기)
			machine.putDrink("음료수 No." + i);
			
			// 공급자 스레드가 잠깐 0.1초 휴식 후 위 음료 공급을 하게 하기(0.1초 휴식)
			try {
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}// catch 블록
			
		}// for 반복문
		
	}// === run Method
	
}// --- Producer Class


class Consumer implements Runnable {
	
	// 자판기 객체의 주소 저장(공유 자원)
		private AutoMachine machine;
		
		// 생성자 - 자판기 객체의 주소를 매개변수로 받아 위 machine 에 저장
		public Consumer(AutoMachine machine) {
			
			this.machine = machine;
		}// Consumer 생성자
		
		// 소비자 스레드가 할 일을 run 메소드에 오버라이딩(재구현)
		@Override
		public void run() {
			
			// 음료 1번 ~ 9번까지 AutoMachine 객체 내부의 Stack 음료 보관함에서 꺼내오자(뽑아 먹자)
			for(int i = 1; i <= 9; i++) {
				
				// 음료 하나를 뽑아 먹을 때마다 모습 묘사
				System.out.println(Thread.currentThread().getName() + " : " + machine.getDrink() + " 구입해서 뽑아 먹고 있다.");
				
				// 소비자 스레드가 음료 하나를 뽑아 먹는 시간 간격을 적용하기 위해 0.1초 휴식 후 위 .getDrink() 메소드 호출되게 하자
				try {
					
					Thread.sleep(100);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}// catch 블록
				
			}// for 반복문
			
		}// === run Method
	
}// --- Consumer Class


public class SyncThreadEx {

	public static void main(String[] args) {
		
		//1. 자판기 객체 생성
		AutoMachine autoMachine = new AutoMachine();
		
		//2. 공급자 스레드 객체 생성 및 일 시작(공급 시작)
		new Thread(new Producer(autoMachine), "정우 공급자 스레드").start(); // run() 실행될 것임
		
		//3. 소비자 스레드 객체 생성 및 일 시작(소비 시작)
		new Thread(new Consumer(autoMachine), "길동 소비자 스레드").start(); // run() 은 CPU 가 이 스레드를 점유할 때 실행될 것임
		
	}// === main Method

}// --- SyncThreadEx Class




