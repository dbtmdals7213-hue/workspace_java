/*
	[연습문제 - 난이도 최상] HashSet + ArrayList 종합 : 전자 투표 개표 시스템

	■ 상황
	   반장 선거 전자 투표가 끝났다. 투표 기록은 두 개의 List에 나뉘어 저장되어 있다.

	   voterList  (누가 투표했나)   : "kim", "lee", "kim", "park", "choi", "lee", "hong", "jung"
	   choiceList (누구를 찍었나)   :  "A",   "B",   "B",   "B",    "A",    "A",   "A",    "A"

	   ★ 두 List는 같은 index끼리 한 장의 표다!
	     예) 0번 표 = kim이 A를 찍음 / 2번 표 = kim이 B를 찍음(두 번째 투표!)

	■ 개표 규칙
	   규칙 1. 같은 사람의 두 번째 이후 투표는 무효표다.
	           무효표는 "무효표(중복 투표) : 아이디" 를 출력하고 집계하지 않는다.
	   규칙 2. 유효표만 후보별로 집계한다.
	           단, 후보 명단은 미리 주어지지 않는다! 개표 중에 처음 나온 후보는
	           그때 후보 목록에 등록하면서 1표부터 세기 시작한다.
	   규칙 3. 후보별 득표수를 "후보 : N표" 형태로, 후보가 처음 등장한 순서대로 출력한다.
	   규칙 4. 최다 득표 후보를 "당선 : 후보 (N표)" 형태로 출력한다.

	■ 핵심 설계 : Map 없이 집계하는 방법 = "병렬 리스트" 기법
	   candidateList : [ "A" ][ "B" ]      <- 후보 이름
	   countList     : [  4  ][  2  ]      <- 같은 index 칸이 그 후보의 득표수!
	   -> "B의 득표수"가 궁금하면? candidateList.indexOf("B")로 위치(1)를 찾고
	      countList.get(1)을 보면 된다. 두 List를 같은 index로 짝지어 쓰는 기법이다.

	■ 예상 실행 결과

	   무효표(중복 투표) : kim
	   무효표(중복 투표) : lee
	   ===== 개표 결과 =====
	   A : 4표
	   B : 2표
	   당선 : A (4표)

	■ 힌트 모음
	   - 투표자와 선택을 "같은 i번째"로 꺼내야 하므로 1단계는 일반 for문이 필수다
	   - indexOf(객체) : 있으면 위치 반환, 없으면 -1 반환 (Collections02)
	   - countList.set( idx, countList.get(idx) + 1 )  <- 득표수 1 올리기
	     (get이 꺼낸 Integer가 오토 언박싱되어 +1 계산되고, 결과가 다시 오토 박싱되어 저장된다)
	   - 최댓값 찾기 : maxIdx를 0으로 시작해서, 더 큰 득표수를 만나면 maxIdx를 갱신
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VotePractice {
	public static void main(String[] args) {

		//투표 기록 : 같은 index끼리 한 장의 표 (병렬 리스트)
		List<String> voterList = new ArrayList<String>();
		List<String> choiceList = new ArrayList<String>();

		voterList.add("kim");   choiceList.add("A");  //0번 표 : kim -> A
		voterList.add("lee");   choiceList.add("B");  //1번 표 : lee -> B
		voterList.add("kim");   choiceList.add("B");  //2번 표 : kim -> B  (kim의 2번째 투표 = 무효!)
		voterList.add("park");  choiceList.add("B");  //3번 표 : park -> B
		voterList.add("choi");  choiceList.add("A");  //4번 표 : choi -> A
		voterList.add("lee");   choiceList.add("A");  //5번 표 : lee -> A  (lee의 2번째 투표 = 무효!)
		voterList.add("hong");  choiceList.add("A");  //6번 표 : hong -> A
		voterList.add("jung");  choiceList.add("A");  //7번 표 : jung -> A

		//이미 투표한 사람인지 확인하기 위한 Set (중복 투표 판별용)
		Set<String> votedSet = new HashSet<String>();

		//유효표의 선택(후보)만 순서대로 모아 둘 List
		List<String> validList = new ArrayList<String>();

		//=====================================================================
		// 1단계 : 무효표 걸러내기
		//=====================================================================

		//TODO 1 : 일반 for문으로 0번 표부터 마지막 표까지 반복하면서
		//         - voterList.get(i) 로 투표자를, choiceList.get(i) 로 선택을 꺼낸다
		//         - 투표자를 votedSet에 add한 반환값이 false이면 (= 이미 투표한 사람)
		//              "무효표(중복 투표) : 투표자" 출력
		//         - true이면 (= 첫 투표) 선택(후보)을 validList에 add한다
		//
		//         ※ 왜 향상된 for문을 못 쓰는가? -> 투표자와 선택을 "같은 i"로
		//           짝지어 꺼내야 하는데, 향상된 for문은 한 번에 한 List밖에 못 돌기 때문
		for(int i = 0; i < voterList.size(); i++) {
			
			String voter = voterList.get(i);
			String choice = choiceList.get(i);
			
			boolean firstVoter = votedSet.add(voter);
			
			if(firstVoter == false) {
				
				System.out.println("무효표(중복 투표): " + voter);
			}else {
				
				validList.add(choice);
			}
		}



		//=====================================================================
		// 2단계 : 후보별 득표 집계 (병렬 리스트)
		//=====================================================================

		//후보 이름 목록과 득표수 목록 (같은 index끼리 짝!)
		List<String>  candidateList = new ArrayList<String>();
		List<Integer> countList     = new ArrayList<Integer>();

		//TODO 2 : 향상된 for문으로 validList의 후보를 하나씩 꺼내
		//         - candidateList.indexOf(후보) 결과를 int 변수 idx에 받는다
		//         - idx가 -1이면  (= 처음 등장한 후보)
		//              candidateList에 후보를 add하고, countList에 1을 add한다 (1표부터 시작)
		//         - idx가 -1이 아니면 (= 이미 등록된 후보)
		//              countList의 idx 칸 값을 1 올린다
		//              힌트 : countList.set( idx, countList.get(idx) + 1 );
		for(String c : validList) {
			
			int idx = candidateList.indexOf(c);
			if(idx == -1) {
				
				candidateList.add(c);
				countList.add(1);
			}else {
				
				countList.set(idx, countList.get(idx) + 1);
			}
		}



		//=====================================================================
		// 3단계 : 개표 결과 출력
		//=====================================================================
		System.out.println("===== 개표 결과 =====");

		//TODO 3 : 일반 for문으로 candidateList와 countList를 같은 i로 짝지어
		//         "후보 : N표" 형태로 출력하시오.
		for(int i = 0; i < candidateList.size(); i++) {
			
			System.out.println(candidateList.get(i) + " : " + countList.get(i) + "표");
		}



		//=====================================================================
		// 4단계 : 당선자 찾기 (최다 득표)
		//=====================================================================

		//TODO 4 : 최다 득표 후보의 "위치"를 저장할 변수 maxIdx를 0으로 시작해서
		//         일반 for문(i=1부터)으로 countList를 돌며
		//         countList.get(i)가 countList.get(maxIdx)보다 크면 maxIdx를 i로 갱신하고,
		//         반복이 끝나면 "당선 : 후보 (N표)" 형태로 출력하시오.
		int maxIdx = 0;
		for(int i = 1; i < countList.size(); i++) {
			
			if(countList.get(i) > countList.get(maxIdx)) {
				
				maxIdx = i;
			}
		}
		System.out.println("당선 : " + candidateList.get(maxIdx) + " (" + countList.get(maxIdx) + "표)");


	}
}
