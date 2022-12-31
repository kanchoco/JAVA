package threadTest2;

import java.util.Scanner;

public class ThreadMain1 {
	public static void main(String[] args) {
		int[] numbers = new int[3];
		Thread[] thread = new Thread[numbers.length];
		ThreadTask1 threadTask = new ThreadTask1();   
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < thread.length; i++) {
			thread[i] = new Thread(threadTask);
		}
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
			thread[i].setName(String.valueOf(numbers[i]));
		}
		
		for (int i = 0; i < thread.length; i++) {
			thread[i].start();
			try {thread[i].join();
			} catch (Exception e) {
				;
			} 
		}
		
		
	}
}
