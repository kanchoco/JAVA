package synchronizedTest;

public class ATM implements Runnable{
	
	public int money;
	
	public  ATM() {
		this(10000);
		}

	public ATM(int money) {
		super();
		this.money = money;
	}


	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			withdraw(1000);
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
	}
	
	public synchronized  void withdraw(int money) {		//영역 전체 동기화, 멀티스레드임에도 특정부분이 단일로 출력된다.
//		mutex : 동기화를 걸어줄 자원 객체
//		synchronized (this) {			//동기화에 사용할 자원을 넣는다./ 자원이 있는 필드의 주소입력
			this.money -= money;
//		}
		System.out.println(Thread.currentThread().getName() + "이(가) " + money + "원 출금");
		System.out.println("현재 잔액 : " + this.money + "원");
	}
}
