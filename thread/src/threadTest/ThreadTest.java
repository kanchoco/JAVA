package threadTest;

public class ThreadTest {
	public static void main(String[] args) {
//		Runnable -> functional interface
		//람다
		Runnable runner = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName());
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			}
		};
		
		
		Runnable t1 = new Thread2();
		Thread2 t2 = new Thread2();
		
//		인터페이스 지정 시, 스케줄링을 위해 스레드 클래스를 직접 객체화한다.
//		상속은 단일상속밖에 안되기 때문에, 실무에선 인터페이스 지정을 더 많이 사용한다.(다중상속 가능)
//		Thread thread1 = new Thread(t1, "!");
//		Thread thread2 = new Thread(t2, "?");
//		runner - Runnable타입
		Thread thread1 = new Thread(runner, "!");
		Thread thread2 = new Thread(runner, "?");
		
		
		thread1.start();
		thread2.start();

//		우선순위 부여는 별 의미가 없음. , 속도가 못따라가는 경우가 있어서
//		join 무조건 먼저 실행 :  사용한 객체의 스레드가 모두 종료되어야 다른 쓰레드가 실행된다.
//									이미 start()한(스케줄링한) 스레드는 영향을 받지 않는다.
//									만약 나중에 실행하고자 하는 스레드가 있다면, join() 다음에  start()를 실행해야 한다.
//		실행여부보다, 정확히 쓰는데 초점을 맞춰야한다.
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {;}
		
		System.out.println("main 스레드 종료");
		
//		Thread1 t1 = new Thread1("?");
//		Thread1 t2 = new Thread1("!");
//		스레드 클래스 상속 시 스케줄링 메소드를 사용할 수 있다.
//		t1.start();
//		t2.start();
		
	}
}
