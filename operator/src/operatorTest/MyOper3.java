package operatorTest;

import java.util.Scanner;

public class MyOper3 {
	public static void main(String[] args) {
//		 사용자에게 키를 입력받고, 정수라면 정수로 출력
//		실수라면 실수로 출력
//		예 183 -> 183출력
//		183.5 -> 183.5출력
//		삼항 연산자를 사용한다.
		String msg = "키 입력", inputHeight = null, height = null;
		boolean isInt = false, isDouble = false;
		Scanner sc = new Scanner(System.in);
		
		System.out.println(msg);
		inputHeight = sc.next();
		
		isDouble = (Double.parseDouble(inputHeight) - (int)Double.parseDouble(inputHeight)) != 0;
		
		System.out.println(Integer.parseInt("A"));
    	isInt = (Double.parseDouble(inputHeight) - (int)Double.parseDouble(inputHeight)) == 0;

		height = isDouble ? "키 : " + Double.parseDouble(inputHeight) + "cm" : Integer.parseInt(inputHeight) + "cm";
		height = isDouble ? "키 : " + Double.parseDouble(inputHeight) + "cm" : isInt? "키 : " + Integer.parseInt(inputHeight) +"cm" : "잘못입력" ;
		
		System.out.println(height);
		
	}
}
