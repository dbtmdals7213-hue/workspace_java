package 배열문제;
/*
[배열문제1]
다음은 거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제이다 변.
수 의 금액을 동전으로 바꾸었을 때 각각 몇 개의 동전이 필요한지 계산해서 출력하 money
라 단 가능한 한 적은 수의 동전으로 거슬러 주어야한다   (1)에 알맞은 코드를 넣어서 
프로그램을 완성하시오.
[Hint] 나눗셈 연산자와 나머지 연산자를 사용해야 한다.
*/

public class One {
	public static void main(String args[]) {
		
		//큰 금액의 동전을 우선적으로 거슬러 줘야한다
		int[] coinUnit = { 500, 100, 50, 10 };
		// 사용할 수 있는 동전은 500원, 100원, 50원, 10원
		
		int money = 2680;
		
		System.out.println("money=" + money);
		
		for (int i = 0; i < coinUnit.length; i++) {
			
			//1. 현재 동전 단위로 몇 개의 동전을 사용할 수 있는가?
			int count = money / coinUnit[i];
			
			System.out.println(coinUnit[i] + " : " + count + "개");
			
			//2. 그 동전을 사용하고 남은 금액은 얼마인가?
			
			money = money % coinUnit[i];
			
			/*
				내가 푼 답
				
		        if(money % coinUnit[i] < coinUnit[0]) {
		        	System.out.println(coinUnit[i] + " : " + money / coinUnit[i] + "개");
		        	money -= money / coinUnit[i] * coinUnit[i];
		        }else if(money % coinUnit[i] < coinUnit[1]) {
		        	System.out.println(coinUnit[i] + " : " + money / coinUnit[i] + "개");
		        	money -= money / coinUnit[i] * coinUnit[i];
		        }else if(money % coinUnit[i] < coinUnit[2]) {
		        	System.out.println(coinUnit[i] + " : " + money / coinUnit[i] + "개");
		        	money -= money / coinUnit[i] * coinUnit[i];
		        }else {
		        	System.out.println(coinUnit[i] + " : " + money / coinUnit[i] + "개");
		        	money -= money / coinUnit[i] * coinUnit[i];
		        }
	        */
			
		}// for
	} // main
}
/*
 실행결과
		money=2680
		500 : 5 개
		100 : 1 개
		50 : 1 개
		10 : 3 개
*/