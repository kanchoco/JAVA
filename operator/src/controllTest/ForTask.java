package controllTest;

import java.util.Scanner;

public class ForTask {
	public static void main(String[] args) {
//		1~100까지 출력
//		100 ~ 1까지 출력
//		1~100까지 짝수만 출력
		System.out.print("1번");
		for(int i=1; i<=100; i++)	{
			System.out.print(i + "\t");
		}
		
		System.out.println();
//		---------------------------------------------------------------------------------
		System.out.println("2번");
		for(int i = 100; i>=1; i--)	{
			System.out.print(i + "\t");
		}
		
		System.out.println();
//		---------------------------------------------------------------------------------
		System.out.println("3번");
		for(int i = 1; i <= 100; i++)	{
			if( i%2 == 0) {
			System.out.print(i + "\t");
			}
		}
//		System.out.println();
//		for(int i = 1; i <= 50; i++)	{
//			System.out.print(i*2);
//			}		>> 50 으로하면 메모리 절약 가능
//		---------------------------------------------------------------------------------
		System.out.println("실버1번");
			int sum = 0;
			
			for(int i = 1; i <= 10; i++)	{
				sum += i;
			}
			System.out.println(sum);
//			---------------------------------------------------------------------------------			
			System.out.println("실버2번");
			int n = 0, sum1 = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("합을 구할 수 입력");
			n =  sc.nextInt();
			
			for(int i = 1; i <= n; i++)	{
				sum1 += i;
			}
			System.out.println(sum1);
			
			System.out.println();
//			---------------------------------------------------------------------------------
			System.out.println("골드1번");
			for(int i = (int)'A'; i <= (int)'F'; i++ )	{
				System.out.print((char)i);
			}
			
			System.out.println();
//			---------------------------------------------------------------------------------
			System.out.println("골드2");
			for(int i = (int)'A'; i <= (int)'F'; i++ )	{
				if( i != (int)'C')	{
					System.out.print((char)i);
				}
			}
//			for(int i =0; i < 5; i++)	{
//			 System.out.println((char)(i > 1 ? i + 66 : i + 65));
//			}
//			---------------------------------------------------------------------------------
			System.out.println();
			
			System.out.println("다이아1");
			for(int i = 0; i < 12; i++)	{
				System.out.print(i%4);
			}
			System.out.println();
//			---------------------------------------------------------------------------------
			int num = 0;
			System.out.println("다이아2");
			for(int i = 0; i <  26; i++)	{
				 if(i%2 == 1) {
					 num = i + 65;
				 }
				 if(i%2 == 0)	{
					 num = i + 97;
				 }
				 //삼항으로 >> i % 2 == 0 ? i + 97 : i + 65
				 System.out.print((char)num);
			}
//			---------------------------------------------------------------------------------
				

		
		
//		 1~10 까지 합 출력
//		1~n까지 합 출력
		
//		A~F까지 출력
//		A~F까지 중 C제외하고 출력
		
//		012301230123 출력
//		aBcDeFgHij...Z 출력
	}
}
