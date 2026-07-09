package 배열문제;
/*
  문제.  다음은 배열을 선언하거나 초기화 한것이다.
        잘못된 것을 고르고 그 이유를 작성하시오.   4, 5 <-- 정답
        
        1.  int[] arr[];   올바른 구문
        
        	풀이: 2차원 배열 메모리 주소 번지를 담을 참조 변수를 선언할 때
        		int[][] arr; 가능
        		int[] arr[]; 가능
        		int arr[][]; 가능
        		
        		          
        2.  int[] arr = {1,2,3,};	올바른 구문
        
			풀이: 마지막의 쉼표(,)는 작성해놔도 상관없음
        
        
        3.  int[] arr = new int[5];    올바른 구문
        
        
        4.  int[] arr = new int[5]{1,2,3,4,5};    잘못된 구문
        	
        	풀이: 두 번째 대괄호[5] 에 숫자를 넣으면 안됨
        		 두 번째 대괄호[] 안에 배열의 크기를 지정할 수 없음
        		 중괄호{} 안의 데이터의 개수에 따라 자동으로 배열의 크기(칸 수)가 결정되기 때문.
        
                   
        5.  int arr[5];   잘못된 구문
        
        	풀이: 배열 메모리의 주소를 담을 참조 변수 arr 선언에 배열 크기 지정할 수 없음
        
        
        6.  int[] arr[] = new int[3][];  올바른 구문 
        

*/


public class test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
