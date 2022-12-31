package inputTest;

import java.util.Scanner;

public class InputTask2 {
// 		3개의 정수를 한 번에 입력받은 후
//	    3개의 정수의 곱 출력
	public static void main(String[] args) {
		//상단에 변수 선언
		int firstNumber, secondNumber, thirdNumber, result = 0;
		String Msg = "3개의 정수를 입력하시오(구분 : 공백) > ";
		//scanner 변수 선언, C + S + O import 단축키
		Scanner sc = new Scanner(System.in);
		
	    System.out.println(Msg);
	    //String타입을 int로 변환하여 변수에 값을 대입
		firstNumber = Integer.parseInt(sc.next());
		secondNumber = Integer.parseInt(sc.next());
		thirdNumber = Integer.parseInt(sc.next());
		
		//result 값에 세 정수의 곱을 대입
		result = firstNumber * secondNumber * thirdNumber;
		System.out.println("세 수의 곱 : " + result);
		
		
	}
}
