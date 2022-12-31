package exceptionTest;

import java.util.Scanner;

public class TExceptionTask {
   public static void main(String[] args) {
//      5개의 정수만 입력받기
//      - 무한 입력 상태로 구현
//      - q 입력 시 나가기
//      - 5개의 정수는 배열에 담기
//      - if문은 딱 한 번만 사용하기
      
      Scanner sc = new Scanner(System.in);																//객체화
      int[] arData = new int[5];																				//5개의 정수만 입력받을것이므로, 5칸의 배열을 선언한다.
      String msg = "번째 정수 : ", temp = null;																// msg = 출력할 메세지, temp는 사용자에게 입력을 받아올 공간이다
      int i = 0;																										//while안에서 i를 증감하여 사용하기위해 선언해준다.
      
      while(true) {																								//무한반복
         System.out.print(++i + msg);																		//i 전위 증가 -> 현재 라인에서 증가되므로 1 + msg(번째 정수 : )가 출력된다.
         temp = sc.next();																						// 문자열로 입력을 받아서 temp에 받아온다.
         if(temp.equals("q")) { break; }																		//q 입력 시 나가기 || equals(주소값 비교)은 문자열일 경우 String에서 재정의하여 값을 비교해준다.
         				
         try {																											//오류가 날 수 있는 실행문
            arData[i-1] = Integer.parseInt(temp);															//5칸 정의한 arData[]에 정수로 형변환한 temp를 넣는다, -> 공간이 초과되면 오류가 뜰 것이므로 try안에 넣는다.
         } catch (NumberFormatException e) {															//NumberFormatException(정수가 아닌 문자 입력 시)이 발생할 시 catch로 받아와 실행한다.
            System.out.println("입력하기 전에 생각이란 걸 해봤나요? 제대로 입력하세요.");					//오류가 날 시 실행할 출력문
            i--;																										//i를 감소시킨다. -> i번째 정수부터 받아오기 위해
            
         } catch (ArrayIndexOutOfBoundsException e) {												//ArrayIndexOutOfBoundsException(배열 공간 초과)이 발생 시 catch로 받아온다.			
            System.out.println("5개만 입력가능합니다.");														// 해당 예외 발생 시 실행할 출력문
            for (int j = 0; j < arData.length; j++) {														// int j 가 arData의 길이만큼 증가할 때,
               System.out.print(arData[j] + " ");															//arData의 인덱스 j의 값을 출력한다.  --> arData[j]의 들어있는 값을 출력해서 보여준다.
            }
            break;																									//for문을 나온 뒤 while문 탈출
            
         } catch (Exception e) {																				//그 외의 예외가 발생 시에 	
            System.out.println("?");																				//출력
            i--;																										//다시 i를 감소시켜 이어서 받는다.	
         }
      }
   }
}
















