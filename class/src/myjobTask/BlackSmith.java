package myjobTask;

import java.util.Random;

public class BlackSmith {
/*대장장이
 * 무기 단조하기
 * 체력 1소모
 * 
 * 
 *무기 판매하기(일괄)
 *대성공 무기 50000
 *성공 무기 10000
 * 
 * 먹기
 * 주먹밥
 * 10000소모
 * 체력 1증가
 * 닭꼬치
 * 10000소모
 * 체력 1증가
 * 
 * 치킨
 * 30000소모
 * 체력 5증가
 * 
 * 모루 강화하기(확률 증가)
 * 
 * 
 * 배낭보기
 * 가지고잇는 무기 
 * 체력
 * */
	
//	String[] weapons = new String[10]; 
	int success;
	int greatSuccess;
	int[] pay = {10_000, 50_000};
	String[] food = {"주먹밥", "닭꼬치", "치킨"};
	int[] foodPayment = {10_000, 10_000, 30_000};
	int[] foodRecovery = {1,1,5};
	int[] reinforcePayment = {50_000, 100_000, 200_000};
	int[] rfsuccessRating = {40,45,50,55};
	int[] rfGsuccessRating = {10, 10, 15, 20};
	
	String userName;
	int stamina;
	int income;
	int successRating;
	int greatSuccessRating;
	int count;
	int anvilLevel;
	
	Random r = new Random();
	
	public BlackSmith() {
		this("user1");}		//기본생성

	public BlackSmith(String userName) {
		this.userName = userName;
		this.stamina = 5;						//기본 체력
		this.successRating = rfsuccessRating[0];			//기본 성공률
		this.greatSuccessRating = rfGsuccessRating[0];
		this.income = 20_000;
		this.anvilLevel = 0;
	}
	
	int forging()	{
		stamina--;
		if(rate(successRating))	{
			count = 0;
			if(rate(greatSuccessRating))	{		//대성공
				greatSuccess ++;
				return 1;
			}
			success ++;
			return 0;
		}
		count++;
	return -1;
	}
	
	void eat(int foodNumber)	{
		income -= foodPayment[foodNumber - 1];
		stamina += foodRecovery[foodNumber -1];
	}
	
	void sell()	{
		income += (pay[0] * success) + (pay[1] * greatSuccess);
		success = 0;
		greatSuccess = 0;
	}
	
	void reinforce()	{
		income -= reinforcePayment[anvilLevel];
		anvilLevel ++;
		successRating = rfsuccessRating[anvilLevel];
		greatSuccessRating = rfGsuccessRating[anvilLevel];
		
	}
	

	boolean rate(int rating) {
		int[] percent = new int[100];
		for (int i = 0; i < rating; i++) {
			percent[i] = 1;
		}
		return percent[r.nextInt(percent.length)] == 1;
	}
		
	
}
