
import java.util.Stack;

// 주제: Vector 클래스의 자식 클래스인? Stack 클래스로 가변 배열 메모리 만들어 사용
public class StackTest01 {

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		
		stack.push("1-자바");
		stack.push("2-자바스크립트");
		stack.push("3-API");
		stack.push("4-데이터베이스");
		
		// isEmpty(): Stack 메모리 내부에 객체가 저장되어 있지 않느냐? 물어보는 메소드로
		//			  저장되어 있지 않으면 true, 저장되어 있으면 false 반환
		
		// 조건: Stack 메모리 내부에 객체가 저장되어 있는 동안만 반복
		while(!stack.isEmpty()) {
			
			// Stack 메모리에 저장된 객체들을 역순으로 꺼내오고 제거
			System.out.println(stack.pop());
			
			System.out.println(stack.isEmpty()); // true <- 저장되어 있지 않다!
		}
		
	}// === main 메소드

}// --- StackTest01 클래스


