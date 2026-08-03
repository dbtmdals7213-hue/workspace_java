package StringTokenizerTest;

// java.util 패키지에 만들어져 있는 StringTokenizer 클래스를 현재 파일에서 불러와 사용하기 위해 import 구문 작성
import java.util.StringTokenizer;

public class StringTokenizerVsSplitExample {

	public static void main(String[] args) {
		
		//---------------------
		//[1] 잘라낼 전체 원본 문자열
		//---------------------
		// 실무 사항 예	: 사용자 주소, 이름, 데이터 입력 시 여러 기호가 섞여 들어왔을 때
		//			  "보기엔 한 줄이지만 사실 내부적으로 '정리가 필요함'"
		String data = "홍길동/이수홍,박연수-김재배|최영훈";
		
		//-----------------------------
		//[2] StringTokenizer 클래스 방식
		//-----------------------------
		System.out.println("========== 1) StringTokenizer 클래스 사용 ==========");
		
		StringTokenizer st = new StringTokenizer(data, "/,-|");
		
		// st.countTokens() -> "현재 몇 개의 문자열로 나눠지는지 숫자로 반환"
		//					   "분리될 문자열의 총 개수를 숫자로 반환"
		int totalCount = st.countTokens();
		System.out.println("분리될 문자열 총 개수: " + totalCount); // 5
		
		System.out.println("-------------------------------------------------");
		
		// st.hasMoreTokens()
		// -> StringTokenizer 객체 메모리에 저장된 전체 원본 문자열에서 분리하여 잘라낼 문자열이 남아 있는지 물어보는 메소드로
		//	  자를 문자열이 남아 있으면 true 반환하고, 없으면 false 반환하는 메소드
		while(st.hasMoreTokens()) {
			
			// st.nextToken()
			// -> 전체 원본 문자열에서 구분자 기호로 구분해 차례대로 문자열을 잘라서 한 번 반환
			String name = st.nextToken(); // "홍길동"
										  // "이수홍"
										  // "박연수"
										  // "김재배"
										  // "최영훈"
			
			// 잘라낸 문자열 출력
			System.out.println("전체 문자열에서 구분자 기호를 중심으로 잘라낸 문자열: " + name);
		}// while 반복문
		
		//--------------------------------------
		//[3] String 클래스의 split() 메소드 사용 방식
		//--------------------------------------
		System.out.println("======== 2) String 클래스의 split() 메소드 사용 ========");
		
		String[] names = data.split("/|,|-|\\|"); // 전체 문자열에서 문자열을 모두 잘라서 배열에 담고 배열 자체를 반환
		
		for(int i = 0; i < names.length; i++) {
			
			System.out.println("split() 결과 [" + i + "]: " + names[i]);
		}
		
		System.out.println("\n");
		
		//-------------------------
		//[4] 종합 결론: 상황에 따라 선택
		//-------------------------
		
		System.out.println("===== 📌 최종 비교 결론 =====");
		System.out.println("✔ 단순하게 / 하나만 자르고 싶다 → StringTokenizer 가 간단함");
		System.out.println("✔ 기호가 여러 개, 규칙 다양 → split() + 정규 표현식이 유리");
		System.out.println("✔ 실무에서는 데이터 형태에 따라 둘 다 사용됨");
		System.out.println("※ 핵심: 도구 선택 능력 = 개발자의 실력");
	}// === main 메소드

}// --- StringTokenizerVsSplitExample 클래스


