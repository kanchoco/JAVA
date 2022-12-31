package classTest;

import java.util.Random;

public class Animal {
	 String name;
	   int age;
	   String feed;
	   int feedCount;
	   int life;
	   
	public Animal() {;}

	public Animal(String name, int age, String feed, int feedCount, int life) {
		this.name = name;
		this.age = age;
		this.feed = feed;
		this.feedCount = feedCount;
		this.life = life;
	}

	void eat()	{		//음식을 소모해서 체력을 회복하는 기능
		feedCount--;
		life++;
	}
	
	void sleep() {		//잠을 잠으로써, 체력을 회복한다.
		life++;
	}
//	외부에서 모든 문제를 전달받는다.
//	전달받은 문제 중 랜덤한 한 개의 문제만 리턴한다.
	Quiz walk(Quiz[] quizes)	{						//외부에서 문제를 전달받을 거임 -> 매개변수는 quizes 배열
																//		퀴즈를 가져올것이다. 따라서 메소드 타입은 Quiz 클래스 타입이 된다.
		life--;													//생명을 소모해서 산책
		
		Random r = new Random();					//랜덤으로 받을것이므로, 랜덤 클래스를 객체화한다.
//	잭팟문제 추가
//      잭팟 문제, 확률은 10%
//      확률이 10단위라면 10칸 배열을, 1단위라면 100칸 배열을 선언한다.
//      int배열로 선언한 뒤 사용자가 원하는 확률 만큼 1로 값을 바꿔준다.
      
//      예) 30% 확률이라면 10칸 배열에 3개의 값만 1로 바꿔준다.
//      따라서 원하는 확률 / 10 을 하여 반복횟수를 결정해주고,
//      그 만큼 1이 들어가게 된다.
      
//      위의 배열이 완성되었으면 랜덤한 인덱스번호로 값에 접근하여
//      1이 나왔을 때에는 원하는 확률로 성공한 것이고,
//      0이 나왔을 때에는 실패한 것이다.

		Quiz quiz = null;
		int[] percent = new int[10];					//10단위 퍼센트이므로 10칸 배열 생성
		int rating = 50;									//잭팟 문제의 확률;
		
//		설정된 확률만큼 배열에 1을 넣는다.
		for (int i = 0; i < rating/10; i++) {
			percent[i] = 1;
		}
		
//		잭팟인지 확인하는 부분
//		확률만큼 반복함
		if(percent[r.nextInt(percent.length)] == 1)	{
//			퀴즈배열을 도는동안 boolean jackpot을 통해 퀴즈가 잭팟인지 검사하고 출력
			for (int i = 0; i < quizes.length; i++) {
				if(quizes[i].jackpot)	{
					return quizes[i];
				}
			}
		}
		
//		퀴즈 출력
		
		while(true) {
			quiz = quizes[r.nextInt(quizes.length)];
			if(!quiz.jackpot) {break;}			//퀴즈가 잭팟이 아닐경우
		}
		return quiz;
		
		
		
		
//		return quizes[r.nextInt(quizes.length)];	//매개변수 quizes에서 랜덤문제를 뽑을것이므로, quizes[랜덤번호]가 되어야한다
//따라서 r.nextInt로 quizes를 받을것이다. quizes[1,2,3,...]이므로 quizes.length에서 r.nextInt로 랜덤한 번호를 가져오면 된다.	
	}
}
