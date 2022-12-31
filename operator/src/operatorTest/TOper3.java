package operatorTest;

import java.util.Iterator;
import java.util.Scanner;

public class TOper3 {
   public static void main(String[] args) {
//      사용자에게 키를 입력받고, 정수라면 정수로 출력
//      실수라면 실수로 출력
//      예) 183 -> 183 출력
//          183.5 -> 183.5 출력
//      삼항 연산자를 사용한다.
      
//      정수인지 실수인지 : 전체에서 진수부를 뺐을 때 0인지 아닌지 검사
//      3.5 - 3 = 0.5 -> 실수
//      3.0 - 3 = 0.0 -> 정수
      
      double height = 0.0;
      boolean check = false;
      //정수인지 실수인지 확인할 변수
      String message = "키 : ", format = null;
      char newLine = '\n';
      Scanner sc = new Scanner(System.in);
      
      System.out.print(message);
      height = sc.nextDouble();
      // 입력값을 실수로 받음
      
      check = height - (int)height == 0;
      //실수의 정수부를 빼서 실수인지 화인
      
//      System.out.println(check ? (int)height : height);
      format = check ? "%.0fcm%c" : "%.2fcm%c";
      //서식 문자를 사용해서 실수와 정수 출력
      // 포맷 = check ? (참일 때 출력할 값) : (거짓일 때 출력할 값)
      System.out.printf(format, height, newLine);
   }
}
