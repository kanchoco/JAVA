package myjobTask;

import java.util.Scanner;

public class Smithery {
	public static void main(String[] args) {
		BlackSmith smith = new BlackSmith();
		Scanner sc = new Scanner(System.in);
		
		String title = "대장장이 게임";
		String optionMsg = "1. 게임시작\n2. 종료";
		String msg = "\n1. 단조하기\n2. 판매하기\n3. 먹기\n4. 모루강화하기\n5. 배낭 보기\n6. 나가기";
		int optionChoice = 0, choice = 0, resultForging = 0, foodNumber = 0;

		while(true)	{
			System.out.println(title);
			System.out.println(optionMsg);
			optionChoice = sc.nextInt();
			if(optionChoice == 2) {break;}
			
			while(true) {
				System.out.println(msg);
				choice = sc.nextInt();
				if(choice ==  6 ) {break;}

				switch(choice) {
				case 1 :		//단조하기
					if(smith.stamina > 1)	{	
						resultForging = smith.forging();	
						switch(resultForging) {
						case 1:
							for (int i = 0; i < 5; i++) {
				    			try {Thread.sleep(900);} catch(InterruptedException e) {;}
								System.out.println("○●[깡]●○○●[깡]●○○●[깡]●○○●[깡]●○○●[깡]●○○●[깡]●○");
							}
								System.out.println("대성공");
							break;
						case 0:
							for (int i = 0; i < 5; i++) {
								try {Thread.sleep(900);} catch(InterruptedException e) {;}
								System.out.println("○●[깡]●○○●[깡]●○○●[깡]●○○●[깡]●○○●[깡]●○○●[깡]●○");
							}
							System.out.println("성공");
							break;
						case -1:
							for (int i = 0; i < 5; i++) {
								try {Thread.sleep(900);} catch(InterruptedException e) {;}
								System.out.println("○●[깡]●○○●[깡]●○○●[깡]●○○●[깡]●○○●[깡]●○○●[깡]●○");
							}
							smith.count++;
							System.out.println("실패!");
							
							break;
						}
					}
					else {
						System.out.println("체력 부족!!");
					}
						System.out.println(smith.count);
						System.out.println("남은 체력 : " + smith.stamina);
				
						break;

				case 2 :			//판매하기(일괄)
					if(smith.greatSuccess != 0 || smith.success != 0) {	
						System.out.println("무기(대성공) : " + smith.greatSuccess + " 개");
						System.out.println("무기(성공) : " + smith.success + " 개");
						System.out.println("총 판매가 : " + ((smith.pay[0] * smith.success) + (smith.pay[1] * smith.greatSuccess)));
						smith.sell();
						System.out.println("현재 자산 : " + smith.income);
					
						break;
					}
					System.out.println("판매할 무기가 없습니다.");
				
					break;
				
				case 3 :		//먹기
					System.out.println("〓〓〓〓 식당 〓〓〓〓");
					System.out.println("       ☞ 주문하기");
					System.out.println("1. 주먹밥(10,000원 | 체력 1회복)\n2. 닭꼬치(10,000원 | 체력 1회복)\n3. 치킨(30,000원 | 체력 5회복)\n4. 나가기");
					foodNumber = sc.nextInt();
					if(foodNumber == 4)	{break;}
					if(smith.income >= smith.foodPayment[foodNumber-1])	{	
						smith.eat(foodNumber);
						for (int i = 0; i < 3; i++) {
			    			try {Thread.sleep(900);} catch(InterruptedException e) {;}
							System.out.println("♪♬");
						}
						System.out.println("체력 " + "[" + smith.foodRecovery[foodNumber-1] + "]" + " 회복!");
						System.out.println("현재 체력 : " + smith.stamina);
						System.out.println("현재 자산 : " + smith.income);
						break;
						}			//돈 부족할 경우
						System.out.println("자산 부족!");
						System.out.println("현재 자산 : " + smith.income);
						System.out.println("현재 체력 : " + smith.stamina);
						break;
					
				case 4 :			//모루강화하기
					System.out.println("현재 모루 레벨 : " + (smith.anvilLevel + 1));
					System.out.println("[단조] 성공률 : " + smith.successRating);
					System.out.println("[단조] 대성공률 : " + smith.greatSuccessRating);
					System.out.println();
					if(smith.anvilLevel != 2)	{	
						System.out.println("다음 모루 레벨 :" + (smith.anvilLevel + 2));
						System.out.println("[단조] 성공률 : " + smith.rfsuccessRating[smith.anvilLevel + 1]);
						System.out.println("[단조] 대성공률 : " + smith.rfGsuccessRating[smith.anvilLevel + 1]);
						System.out.println();
						System.out.println("강화 비용 : " + smith.reinforcePayment[smith.anvilLevel]);
						System.out.println();
						System.out.println("강화하시겠습니까?(Y/N)");
						String decision = sc.next();
						if("Y".equals(decision))	{
							if(smith.income >= smith.reinforcePayment[smith.anvilLevel])	{
								smith.reinforce();
								System.out.println("!!!!!!!! 레벨업 !!!!!!!!");
								System.out.println("현재 모루 레벨 : " + (smith.anvilLevel + 1));
								System.out.println("[단조] 성공률 : " + smith.successRating);
								System.out.println("[단조] 대성공률 : " + smith.greatSuccessRating);
								System.out.println("현재 자산 : " + smith.income);
								System.out.println();
								break;
							}
								System.out.println("자산이 부족합니다!!!!!!!");
								System.out.println("현재 자산 : " + smith.income);
								System.out.println();
								break;
							}
						System.out.println("강화 취소하셨습니다.");
						break;
						
					}
							
					System.out.println(" ! ! 최고 레벨입니다 ! ! ");
						
						break;
					
				case 5 :		//배낭보기
					System.out.println(smith.userName + " 의 배낭");
					System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
					System.out.println("현재 체력 : " + smith.stamina);
					System.out.println("--------------------------------------------------");
					System.out.println("무기(대성공) : " + smith.greatSuccess + " 개");
					System.out.println("--------------------------------------------------");
					System.out.println("무기(성공) : " + smith.success + " 개");
					System.out.println("--------------------------------------------------");
					System.out.println("현재 자산 : " + smith.income);
					System.out.println("--------------------------------------------------");
					System.out.println("[단조] 성공률 : " + smith.successRating);
					System.out.println("--------------------------------------------------");
					System.out.println("[단조] 대성공률 : " + smith.greatSuccessRating);
					System.out.println("--------------------------------------------------");
					break;
					
				}
			}
		}
	}
}
