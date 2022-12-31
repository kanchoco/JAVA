package methodTest;

import java.util.Scanner;

public class MymethodTask {
	
//		1~10까지 println()으로 출력하는 메소드
		 void printnumber()	{
			 for(int i =0; i < 10; i++) {
				 System.out.println(i+1);
			 }
		}
		
//		"홍길동"을 n번 println()으로 출력하는 메소드
		 void hong(int n) {
				 for(int i =0; i < n; i++) {
					 System.out.println("홍길동");
				 }
			 }
//		이름을 n번 println()으로 출력하는 메소드
		 void name(String na, int n) {
			
			 for(int i =0; i < n; i++) {
				 System.out.println(na);
			 }
		 }
		
//		세 정수의 뺄셈을 해주는 메소드
		 int minus(int num1, int num2, int num3)	{
				int result = num1 - num2 - num3;
				return result;
			}
		
//		두 정수의 나눗셈을 해주는 메소드(몫과 나머지 둘 다)
		
		int[] division(int num1, int num2)	{
			 int[] devide = null;
			 
			 if(num2 != 0) {
				 devide = new int[2];
				 
				 devide[0] = num1 / num2;
				 devide[1] = num1 % num2;	 	
			 }
			 
			 return devide;
			}
//		1~n까지의 합을 구해주는 메소드
		int sum(int n)	{
			int result = 0;
			
			for(int i=0; i < n-1; i++) {
				result = 1 + i;
			}
			return result;
		}
		
//		홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
		int change(int number)	{
			int result = 0;
			if (number%2 == 0) {
				result = number-1;
			}else  {
				result = number *2;
			}
			return result;
		}
//		문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
		String changeWord(String word) {
			String result = "";
			
			for(int i = 0; i < word.length();i++)	{
				int compare = word.charAt(i);
				if (compare > 64 && compare < 91) {
					result += (char)(compare + 32);
				}else if(compare > 96 && compare < 123) {
					result += (char)(compare - 32);
				}else {
					result += (char)compare;
				}
			}
			return result;
		}
//		문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
		int countWord(String word, char c)	{
			int count = 0;
			for(int i = 0; i < word.length(); i++)	{
				if(word.charAt(i) == c)	{
					count++;
				}
			}
			return count;
		}
//		5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드

		char rankWord(String number, int rank ) {
			char result = 0;
			for(int i=0; i < rank; i++)	{
				result = number.charAt(i);
			}
			return result;
		}
//		한글을 정수로 바꿔주는 메소드
		int hangeul(String changeNumber)	{
			String hnumber = "공일이삼사오육칠팔구" , result = "";
			int num = 0;
				
			for(int i = 0; i < changeNumber.length(); i++)	{
				result += hnumber.indexOf(changeNumber.charAt(i));
			}
			return Integer.parseInt(result);
		}
				
		 

		
		
//		5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
//		매개변수 수정해서 다시 써보기~~~~~~~~~
		int[] BigSmallWord(int num1,int num2, int num3, int num4, int num5 ) {
			int[] num = {num1, num2, num3, num4, num5};
			int max = num[0], min = num[0];
			
			for(int i=0; i < 5; i++)	{
				if(max < num[i])	{
					max = num[i];
				}
				if(min > num[i]) {
					min = num[i];
				}
			}
			int result[] = {max, min};
			return result;
		}
		
//		5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드(Void로 하되, 출력 없이 사용하는 부분에 결과를 전달한다. 매개변수는 2개 전달)
//		getMaxAndMin();
		void getMaxAndMin(String number, int maxmin ) {
			for(int i=0; i < 5; i++)	{
				int max = number.charAt(0), min = number.charAt(0);
				if(max < number.charAt(i))	{
					max = number.charAt(i);
				}
				if(max < number.charAt(i))	{
					min = number.charAt(i);
				}
			}
			

		}
		 public static void main(String[] args) {
			MymethodTask mt = new MymethodTask();
			System.out.println(mt.hangeul("일공이사"));
//			System.out.println("최대 : " + mt.BigSmallWord(8,23,9,41,0)[0] + "최소  : " + mt.BigSmallWord(8,23,9,41,0)[1]);
		}
		 
}
