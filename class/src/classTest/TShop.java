package classTest;

import java.util.Scanner;

class SuperCar {
//   브랜드, 색상, 가격, 비밀번호
   String brand;
   String color;
   int price;
   
   String password;
   
   boolean check;

   public SuperCar() {
      password = "0000";
   }
   
   public SuperCar(String password) {
      this.password = password;
   }

   public SuperCar(String brand, String color, int price, String password) {
      this.brand = brand;
      this.color = color;
      this.price = price;
      this.password = password;
   }
   
//   시동 켜기
//   시동의 상태를 확인하고 
//   시동이 꺼져있다면, "시동 켜기" 출력
//   이미 시동이 켜져있다면, "시동이 이미 켜져있습니다" 출력
   boolean engineStart() {
      if(!check) {
         check = true;
         return true;
      }
      return false;
   }
   
//   시동 끄기
//   시동의 상태를 확인하고 
//   시동이 켜져있다면, "시동 끄기" 출력
//   이미 시동이 꺼져있다면, "시동이 이미 꺼져있습니다" 출력
   boolean engineStop() {
      if(check) {
         check = false;
         return true;
      }
      return false;
   }
   
//   [심화]
//   시동을 켜기 위해서는 비밀번호 4자리를 입력해야 한다.
//   입력한 비밀번호가 3회 연속 실패하면 "경찰 출동" 메세지를 출력한다.
   boolean checkPassword(String password) {
      return this.password.equals(password);
   }
   
}

public class TShop {
   public static void main(String[] args) {
      SuperCar ferrari = new SuperCar();
      
      String msg = "1.시동켜기\n2.시동끄기", pwMsg = "비밀번호 : ", pw = null;
      Scanner sc = new Scanner(System.in);
      int choice = 0, count = 0;
      boolean stopedEngine = false;
      
      do {
         System.out.println(msg);
         choice = sc.nextInt();
         
         switch(choice) {
         case 1: // 시동 켜기
            if(!ferrari.check) {
               System.out.print(pwMsg);
               pw = sc.next();
               if(ferrari.checkPassword(pw)) {
                  ferrari.engineStart();
                  count = 0;
                  System.out.println("시동 켜짐");
               }else {
                  count++;
                  System.out.println("비밀번호 오류 " + count + "회");
                  if(count == 3) {
                     System.out.println("경찰 출동");
                  }
               }
               break;
            }
            
            System.out.println("이미 시동이 켜져있습니다.");
            break;
         case 2:
            if(stopedEngine = ferrari.engineStop()) {
               System.out.println("시동 꺼짐");
               break;
            }
            
            System.out.println("이미 시동이 꺼져있습니다.");
            break;
         }
      }while(!stopedEngine && count != 3);
   }
}




