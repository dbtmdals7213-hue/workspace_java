import java.util.Comparator;

public class Ex6 {

	public static void main(String[] args) {
		
		Comparator<Integer> recomparator = Comparator.reverseOrder();
		
		// 10이 20보다 더 크냐? 물음에 20이 더 크므로 원래는 음수 -1 반환하지만
		// -> Comparator.reverseOrder(); 호출하여 정렬 거꾸로 판단하는 자식 객체를 반환받아서 사용하기 때문에
		//	  Compare(10, 20). 호출 결과는 거꾸로 판단해 양수 1을 반환합니다.
		int result1 = recomparator.compare(10, 20); // 10이 20보다 더 작으냐? 작으면 양수 1 반환
		
		System.out.println(result1); // 양수 1 출력
		
		// 20이 10보다 더 작으냐?
		int result2 = recomparator.compare(20, 10); // 20이 10보다 더 작으냐? 작으면 양수 1 반환, 크면 음수 -1 반환
		
		System.out.println(result2); // 음수 -1 출력
		
		int result3 = recomparator.compare(10, 10); // 10과 10이 같으냐? -> 두 값이 같으면 0 반환
		System.out.println(result3); // 두 값이 같으므로 0 출력
		
	}// === main Method

}// --- Ex6 Class




