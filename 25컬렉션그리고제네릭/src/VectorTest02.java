import java.util.Enumeration;
import java.util.Vector;

public class VectorTest02 {

	public static void main(String[] args) {
		
		Vector vector = new Vector();
		
		System.out.println(vector.capacity()); // 총 10칸
		
		double[] arr = new double[] {38.6, 9.2, 45.3, 6.1, 4.7, 1.6};
		//							    0	 1	  2    3	4	 5
		
		// arr 배열에 저장된 모든 실수 데이터들을 차례대로 반복해서 어더
		// 위 new Vector(); 로 생성한 가변길이 배열의 각 칸에 차례대로 오토 박싱해서 저장
		for(int i = 0; i < arr.length; i++) {
			
			// 기본 자료형 double 은 객체가 아니므로 Vector 배열에 바로 저장할 수 없다.
			// 컴파일러가 Double.valueOf(꺼내온 실수 값); 을 자동 호출해 Double 래퍼 객체로 포장한 후 저장한다.(= 오토 박싱)
			vector.add(arr[i]);
		}
		
		// 일반 for 반복문을 활용하여 Vector 배열의 각 칸에 저장된 객체 개수만큼 반복해서 얻어 출력
		for(int i = 0; i < vector.size(); i++) {
			
			System.out.print("\t" + vector.get(i));
		}
		
		System.out.println(); // 한 줄 줄바꿈 출력 후 아래의 코드 실행
		
		//===================
		// 검색: indexOf 메소드
		//===================
		
		//1. Vector 배열 메모리에서 검색할 기본 자료형 실수 값을 변수에 저장
		double searchData = 6.1;
		
		//2. searchData 변수에 저장된 6.1을 오토 박싱하여 indexOf 메소드 호출할 때 매개변수로 전달하면
		//	 Vector 배열의 가장 앞 칸부터 차례로 비교해서 6.1이 저장된 칸을 찾으면
		//	 저장된 칸의 index 위치 번호 하나를 반환 해줍니다.
		//	 만약 저장되어 있지 않으면? indexOf 메소드는 -1을 반환합니다.
		int index = vector.indexOf(searchData);
		
		//3. 검색 결과 index 가 -1이 아니면 = 찾았다면 이라는 의미
		if(index != -1) {
			
			System.out.println("검색 성공!: " + index + " index 위치 칸에 검색할 데이터 " + searchData + "가 존재");
		}else {
			
			System.out.println("검색 실패!: " + index);
		}
		
		//============================================
		// 삭제: contains 로 확인 후 remove(Object) 로 삭제
		//============================================
		
		//1. Vector 배열 메모리에 저장된 데이터 중에서 삭제할 실수 값을 변수에 저장
		double delData = 45.3;
		
		// Vector 배열 메모리에 45.3과 같은 내용이 포함된 Double 래퍼 객체가 저장되어 있는가? 물어보고, 저장되어 있으면? 삭제
		if(vector.contains(delData)) {
			// true 반환 받으면? if 조건식 참
			
			// 저장되어 있기 때문에 삭제하자.
			boolean result = vector.remove(delData);
			
			if(result) System.out.println("삭제 성공");
			else System.out.println("삭제 실패");
		}
		
		System.out.println("Vector 배열 메모리의 전체 칸의 개수: " + vector.capacity()); // 10칸
		System.out.println("Vector 배열 메모리의 각 칸에 저장된 객체 전채 개수: " + vector.size()); // 5개
		
		Enumeration enu = vector.elements();
		
		while(enu.hasMoreElements()) {
			
			System.out.println(enu.nextElement());
		}
		
	}// === main 메소드

}// --- VectorTest02 클래스


