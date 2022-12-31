package lamdaTask;

import java.util.Scanner;

public class MyMath {
	
	public static  Calc calculation(String oper)	{
		//* 두 정수의 덧셈, 뺄셈을 구해주는 함수형 인터페이스를 리턴하는 static 메소드 선언(람다식 리턴)
//		--> Calc를 구현하는것
		Calc c = null;
		
		switch(oper)	{			//덧셈과 뺄셈을 할 조건을 만들기
		case "+" :
			c = (n1, n2) -> n1 + n2;
			break;
		case "-" :
			c = (n1, n2) -> n1 - n2;
			break;
		}
		return c;
		
	}
	public static void main(String[] args) {
		//* main메소드에 getOper를 람다식으로 구현
		//* 첫번째 정수가 음수일 경우 오류 해결
		
//		* "ABC".split("")은 [A][B][C] 3칸 문자열 배열로 리턴된다.
//		   "A,B,C".split(",")은 [A][B][C] 3칸 문자열 배열로 리턴된다.
//		   split("구분점")을 전달하면 문자열에서 동일한 구분점을 기준으로 문자열 값을 잘라낸 후 문자열 배열로 리턴한다.
//		   구분점을 여러 개 사용할 때에는 split("구분점|구분점")으로 사용하며, "+", "-"를 구분점으로 사용할 때에는 "\\+", "\\-"로 표현한다.
//		   예)"4 + 9".split("\\+")은 [4][9] 2칸 문자열 배열로 리턴
		
		
		
			Opercheck checkOper = (expression) -> {
				String temp = "";
//			전체 식에서 연산자만 골라서 문자열에 담고
				for (int i = 0; i < expression.length(); i++) {
					char c = expression.charAt(i);
					if (c == '-' || c == '+') {
						temp += c;
					}
				}
//			String[]로 리턴하는
			return "+-".split("");
		};
		
//		실행부
		String msg = "정수의 덧셈, 뺄셈에 대한 식을 입력하세요.";
		String exampleMessage = "예)9+7-5";
		String expression = null;
		String[] opers = null;
		String[]	nums = null;
		int number1 = 0, number2 =0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(msg);
		System.out.println(exampleMessage);
		expression = sc.next();
//		checkOper를 사용해서 문자열을 나눔, 그 문자열을 opers에 담음
		opers = checkOper.checkOper(expression);	//연산자 분리
//		구분점으로 나눠서 반복해야한다.
		nums = expression.split("\\+|\\-");	//문자 분리
//		opers {+,-}  nums = {9,7,5}
		
//		맨앞글자가 -일경우
//		nums[0] = (nums[0].equals("") ? "0" : nums[0]);
//		ex) -1+9일때 nums는 "","1","9"이기 때문에 빈문자열 일 경우 첫글자가 음수라는 뜻이된다.
//		따라서 nums의 첫번째가 빈문자열일 경우 0을 넣어서 0-1+9로 연산하게 해주고,
//		아니라면, 원래 nums[0]번째 그대로 넣어준다/
//		number1 = Integer.parseInt(nums[0]);
		
//		연산자의 개수 만큼 연산해야함 -> opers(연산자가 들어있는 문자열)의 길이만큼 반복한다.
//		for (int i = 0; i < opers.length; i++) {
//			number2 = Integer.parseInt(nums[i+1]);
//			number1 = calculation(opers[i]).calc(number1, number2);
//			calculation메소드에 {+,-}가 담긴 opers[i]를 전달, calc에 두 정수를 전달
//			왜 첫번째 숫자가 담긴 number1에 값을 넣는지?
//			--> 연산은 누적해서 되어야한다. 즉 다음번째 숫자만 계속 가져오며 연산한다.
//			9+7-5 --> 9(number1) + 7(number2) = 16
//			16-5 --> 16(number1) - 5(number2) = 11
//			...        ==> 연산자의 갯수만큼 이렇게 연산이 진행되므로 number1은 처음 숫자를 담고 연산값을 누적하는 변수가된다.
//		}
		
		
		 number1 = Integer.parseInt(nums[0].equals("") ? opers[0] + nums[1] : nums[0]);
	      
	      for (int i = 0; i < opers.length; i++) {
	         if(i == 0 && number1 < 0) {continue;}
	         number2 = Integer.parseInt(nums[i + 1]);
	         number1 = calculation(opers[i]).calc(number1, number2);
	      }

		
		System.out.println(number1);
	}
}
