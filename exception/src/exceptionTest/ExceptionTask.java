package exceptionTest;

import java.util.Scanner;

public class ExceptionTask {
//	5개의 정수만 입력받기
//	- 무한 입력 상태로 구현
//	- q 입력 시 나가기
//	- 5개의 정수는 배열에 담기
//	- if문은 딱 한 번만 사용하기
	public static void main(String[] args) {
		int[] numbers = new int[4];
		String choice = null;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("input integer.. \nexit 	q\npress anykey to start");
			if(sc.next().equals("q") ){break;}

			try {
					for (int i = 0; i < 10; i++) {		
						System.out.println("정수 입력");
						numbers[i] =  Integer.parseInt(sc.next());
					}
			}catch(Exception e){
				System.out.println("초과!");		//공간을 넘어서 초과될 경우, 예외상황 발생 -> 출력할 메세지
				break;
			}
		}
		
	}
}
