package threadTest1;

public class Test2 implements Runnable{
	@Override
	public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(300);
				}
			} catch (Exception e) {;}
	}	
}

