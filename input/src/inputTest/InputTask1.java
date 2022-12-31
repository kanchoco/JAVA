package inputTest;

import java.util.Scanner;

public class InputTask1 {
	public static void main(String[] args) {
		// 두 정수를 입력한 뒤 덧셈 결과 출력
//		단, next()만 사용
//		Scanner sc = new Scanner(System.in);
//		String num1 = null;								//초기화 꼭 하기
//		String num2 = null;
//		
//		System.out.println("합을 구할 두 수 입력 : ");
//		num1 = sc.next();
//		num2 = sc.next();
//		int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
//
//		System.out.println("두 수의 합" + sum);
		
		int firstNumber = 0, lastNumber = 0, result = 0;
		String firstNumberMsg = "첫번째 정수 : ", lastNumberMsg = "두 번째 정수";
		Scanner sc = new Scanner(System.in);
		
		System.out.println(firstNumberMsg);
		firstNumber = Integer.parseInt(sc.next());
		
		System.out.println(lastNumberMsg);
		lastNumber = Integer.parseInt(sc.next());
		
		result = firstNumber + lastNumber;
		
		System.out.println(result);
		
		
	}
}
