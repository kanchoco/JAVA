package operatorTest;

import java.util.Scanner;

public class MyOper2 {
	public static void main(String[] args) {
//		두 정수 입력받기
		Scanner sc = new Scanner(System.in);
		int firstNumber = 0, lastNumber;
		String msg = "정수 입력", result = null;
		boolean isBigger = false, isSame = false; 	//논리 초기값은 false
		
		System.out.println(msg);
		firstNumber = sc.nextInt();
		lastNumber = sc.nextInt();
		
		isBigger = firstNumber > lastNumber;
		isSame = firstNumber == lastNumber;	
		
		result = isBigger ? "큰 값 : " + firstNumber	: isSame ? "두 수가 같습니다." : "큰 값 : " + lastNumber;		//큰 값을 출력
//		result = isBigger ? firstNumber	: isSame ? "두 수가 같습니다." : lastNumber;		//큰 값을 출력
//		int result 안에 문자가 들어갈 수 없음, 혼합적인 상황일 때 문자열로 바꾼다.
		
		System.out.println("큰 값" + result);		
	
	}
}
