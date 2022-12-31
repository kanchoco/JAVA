package arrayTest;

import java.util.Scanner;

public class Artask {
	public static void main(String[] args) {
		
//		브론즈
//		1~10까지 배열에 담고 출력
//		int[] AData = new int[10];
//		for(int i = 0; i < AData.length; i++)	{
//			AData[i] = i+1;
//		}
//		
//		for(int i = 0; i < AData.length; i++)	{
//			System.out.print(AData[i]);
//		}
//		
//		System.out.println();
		
//		10 ~ 1까지 중 짝수만 배열에 담고 출력
//		for(int i = 0; i < AData.length; i++) {
//			if(i%2 == 0) {
//				AData[i] = 10-i;
//				System.out.print(AData[i]);
//			}
//		}
//		arData[i] = (5-i) *2
		
		System.out.println();
		
//		1~100까지 배열에 담은 후 홀수만 출력
//		int[]arrData = new int[100];
//		for(int i = 0; i < 100; i++)	{
//			arrData[i] = i+1;
//		}
//		for(int i = 0; i < 100; i++) {
//			if(i%2 == 0)	{
//				System.out.print(arrData[i]);
//			}
//		}
//		if(arData[i) % 2 == 0	{
//			continue;
//	}
		
		
//		실버
		
//		1~100까지 배열에 담은 후 짝수의 합 출력
//		int  result = 0;
//		for(int i = 0; i < 100; i++)	{
//			arrData[i] = i+1;
//			if(i%2 == 0)	{
//				result += arrData[i] ;
//			}
//		}
//		System.out.println(result);
//		
//		System.out.println();
		
//		A~F까지 배열에 담고 출력
//		int[] AData1 = new int[6];
//		for(int i = 0; i < AData1.length; i++)	{
//			AData1[i] = i + 65;
//			System.out.print((char)AData1[i]);
//		}
//		
//		System.out.println();
		
//		A~F까지 중 C제외하고 배열에 담은 후 출력
			
//		for(int i = 0; i < AData1.length-1; i++)	{
//			if(i < 2)	{
//				AData1[i] = i + 65;
//			}if(i >= 2)	{
//				AData1[i] = i + 66;
//			}
//			System.out.print((char)AData1[i]);
//		}
//		AData[i] = (char)(i > 1 ? i + 65 : i + 66)
		
//		골드
//		5개의 정수를 입력받고 배열에 담은 후 최대값과 최소값 출력
//		int[] SData = new int[5];
//		int max = 0, min = 0;
//		String msg = "정수를 입력하시오";
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println(msg);
//		for(int i = 0; i < SData.length; i++) {
//			SData[i] = sc.nextInt(); 
//		}
//		
//		max =SData[0];
//		min = SData[0];
//		
//		for(int i = 0; i < SData.length; i++)	{
//			if(max < SData[i])	{
//				max = SData[i];
//			}if(min > SData[i])	{
//				min = SData[i];
//			}	
//		}
//		
//		System.out.println(max);
//		System.out.println(min);
		
		
//      다이아
//      사용자가 입력할 정수의 개수만큼 배열을 만든 후 정수를 입력받고 평균 구하기
      
//      값도 모르고 칸도 아직 모름
//      int[] arData = null;
//      Scanner sc = new Scanner(System.in);
//      String countingMsg = "정수 개수 : ", msg = "번째 정수 : ";
//      int total = 0;
//      double avg = 0.0;
//      
//      System.out.print(countingMsg);
////      사용자가 입력한 정수만큼 칸 할당
//      arData = new int[sc.nextInt()];
//      
//      for (int i = 0; i < arData.length; i++) {
//         System.out.print(i + 1 + msg);
////         사용자가 입력한 정수를 순서대로 넣는다.
//         arData[i] = sc.nextInt();
//      }
//      
//      for (int i = 0; i < arData.length; i++) {
//         total += arData[i];
//      }
//      
//      avg = (double)total / arData.length;
////      소수점 둘 째자리까지 나누기 위해서, String 클래스의 format 메소드를 사용한다.
//      avg = Double.parseDouble(String.format("%.2f", avg));
//      System.out.println(avg);
	}
}	
