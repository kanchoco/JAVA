package jobTask;

import java.util.Random;

public class OakSeller {

		String[]	table = {"사원", "팀장", "다이아"};
		int[] pay = {0, 10_000, 100_000};
		int[] incomes = {1_000, 3_000, 9_000};
		
		String name;
		int positionNumber;
		int successRating;
		int income;
		int count;

		Random r = new Random();
		
		public OakSeller() {
			this("한동석", 0);
		}

		public OakSeller(String name, int positionNumber) {
			this.name = name;
			this.positionNumber = positionNumber;
			this.successRating = 50;
		}
		
		int sell()	{	//성공 0 대성공 1 실패 -1 --> 반환값이 있으므로 타입메소드
			if(rate(successRating))	{
				count = 0;
//				50프로 계산 후 20퍼센트의 대성공 검사이므로 중첩if로 대성공 여부를 판단
				if(rate(20)) {
					income += incomes[positionNumber]*3;					//포지션 넘버로 incomes에 접근 후 * 3
					successRating -= 5;												//대성공이므로 성공률 낮춤
					return 1;															//대성공값 반환
				}
				income += incomes[positionNumber];
				successRating -= 2;
				return 0;
			}
//			실패
			income -= 2_000;
			successRating += 10;
			return -1;
		}
		
		boolean rate(int rating)	{
			int[]	percent = new int[100];		//1의 단위 확률
			for (int i = 0; i < rating; i++) {percent[i] = 1;}
			return percent[r.nextInt(percent.length)] == 1;
//			랜덤으로 나온 percent[]가 1인지 아닌지 판단해주는 boolean 메소드 
		}
		
		void demote() {		//강등
			positionNumber--;
		}
		boolean promote()	{	//승진
			income -= pay[(positionNumber+1)];				//승진시 지불할 돈이기 때문에 positionNumber+1
			if(positionNumber == 0 ? rate(30) : rate(10))	{	//사원일 경우 30퍼센트, 그 외에는 10퍼센트로 승진
				positionNumber++;
				return true;
			}
				return false;
		}
		
		
		
	}
		
