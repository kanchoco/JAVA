package bakery;

public class BreadPlate {
//매 선언마다 new할시 여러 빵집이 만들어져서 어떤 주소에 접근할지 모르게됨. -> 싱글턴패턴
	public static BreadPlate breadPlate;
	
	public int breadCount;
	public int eatCount;
	
	  private BreadPlate() {;}
	   
	   public static BreadPlate getInstance() {
	      if(breadPlate == null) {
	         breadPlate = new BreadPlate();
	      }
	      return breadPlate;
	   }
	
//	빵만들기
//	만든 빵이 9개가 넘어가면, 스레드를 멈춰준다.
	//스레드 제어를 위해 동기화
		public synchronized void makeBread()	{
			if(breadCount > 9)	{
				System.out.println("빵이 가득찼습니다.");
//				스레드 종료를 위해서는 스레드가 멈춰야한다. / 스레드의 종료는 반복문탈출로 할 수 있다.
				try {wait();} catch (InterruptedException e) {BreadMaker.check = true;}
			} else {
			breadCount++;
			System.out.println("빵을 1개 만들었습니다. 현재 빵 개수 : " + breadCount);
			}
		}
	
//	빵먹기
//	만든 빵이 0개면 못먹고, 먹은 방이 20개면 못먹는다.
//	만약 빵을 먹게 되면, 멈춰있던 스레드를 깨워준다.
	public synchronized void eatBread()	{
		if(breadCount  == 20)	{
			System.out.println("빵이 다 떨어졌습니다.");
		}else if(breadCount < 1)	{
			System.out.println("🍩🍩🍩🍩 빵을 만들고 있어요! 🥞🧇🥨🥐🍞🥞🧇🥨🥐");
			}else	{
				breadCount++;
				breadCount--;
				System.out.println("빵을 1개 먹었습니다. 현재 빵 개수 : " + breadCount + "개");
				notify();
			}
		}
}
