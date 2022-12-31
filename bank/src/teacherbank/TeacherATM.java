package teacherbank;

import java.util.Random;
import java.util.Scanner;

public class TeacherATM {
   public static void main(String[] args) {
//      은행 선택
      String msg ="1. 신한은행\n2. 국민은행\n3. 동석은행\n4. 나가기";
      
      /*
       * 1. 계좌개설
       * - 13자리 랜덤 계좌번호
       * - 기존 고객의 계좌번호와 중복이 없는 번호로 개설해야 한다.
       * - 핸드폰 번호는 숫자만 입력하도록 하고, 문자가 포함되면 안되고 0~9사이의 정수여야 한다.
       * - 비밀번호 4자리로만 입력하도록 한다.
       * 
       * 2. 입금하기
       * - 계좌를 개설한 은행에서만 입금 가능
       * 
       * 3. 출금하기
       * 4. 잔액조회
       * 5. 계좌번호 찾기
       * 6. 나가기
       */
      
      String menu = "1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회\n5. 계좌번호 찾기\n6. 은행선택메뉴로 이동";
      String name = null, account = "", phoneNumber = null, password = "";
      int money = 0, bankNumber = 0, choice = 0;
      String[] bankName = {"신한은행", "국민은행", "동석은행"};
      
      Scanner sc = new Scanner(System.in);
      Random r = new Random();
      Ttbank bank = null;
      
      
      while(true) {
         System.out.println(msg);
         bankNumber = sc.nextInt();
         if(bankNumber == 4) {break;}
         
         while(true) {
            System.out.println(menu);
            choice = sc.nextInt();
            if(choice == 6) {break;}
            
            switch(choice) {
            case 1: //계좌개설
               Ttbank[] arBank = {new TShinhan(), new TKookmin(), new TDongseok()};

               while(true) {
                  account = "";
                  for (int i = 0; i < 12; i++) {
                     account += r.nextInt(10);
                  }
   //               쓸데없이 객체화를 해야 할 때에는 빨리 static으로 전환한다!
   //               Bank bank = new Bank();
   //               bank.checkAccount()
                  if(Ttbank.checkAccount(account) == null) {break;}
               }
               //은행 번호를 맨 앞에 추가해준다.
               account = bankNumber - 1 + account;
               
               arBank[bankNumber - 1].setAccount(account);
               
               System.out.print("예금주 : ");
               name = sc.next();
               
               arBank[bankNumber - 1].setName(name);
               
               while(true) {
                  System.out.print("핸드폰 번호['-' 제외] : ");
                  phoneNumber = sc.next();
                  
   //               숫자만 있는 지
                  int i = 0;
                  for (i = 0; i < phoneNumber.length(); i++) {
                     char c = phoneNumber.charAt(i);
                     if(c < 48 || c > 57) {
                        break;
                     }
                  }
                  
                  if(i != phoneNumber.length()) {
                     System.out.println("숫자만 입력해주세요.");
                     continue;
                  }
                  
   //               입력한 문자열 값이 11자리인지
                  if(phoneNumber.length() != 11) {
                     System.out.println("핸드폰 번호를 입력해주세요.");
                     continue;
                  }
   //               핸드폰 번호가 중복되었는 지
                  if(Ttbank.checkPhoneNumber(phoneNumber) != null) {
                     System.out.println("중복된 핸드폰 번호입니다.");
                     continue;
                  }
   //               010으로 시작하는 지
                  if(!phoneNumber.startsWith("010")) {
                     System.out.println("핸드폰 번호를 입력해주세요.");
                     continue;
                  }
                  break;
               }
               
               arBank[bankNumber - 1].setPhoneNumber(phoneNumber);
               
               password = "";
               while (password.length() != 4) {
                  System.out.print("비밀번호 : ");
                  password = sc.next();
               }
               
               arBank[bankNumber - 1].setPassword(password);
               
//               do {
//                  System.out.print("비밀번호 : ");
//                  password = sc.next();
//               } while (password.length() != 4);
                  
               
               Ttbank.arrBank[bankNumber - 1][Ttbank.arCount[bankNumber - 1]] = arBank[bankNumber - 1];
               Ttbank.arCount[bankNumber - 1]++;
               
               System.out.println("🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊");
               System.out.println("축하합니다. 감사합니다. 사랑합니다.");
               System.out.println("더 노력하는 " + bankName[bankNumber - 1] + "이 되겠습니다!");
               System.out.println("고객님의 계좌번호는 " + account + "입니다.");
               System.out.println("분실 시 계좌번호 찾기 서비스를 이용해주세요~!");
               System.out.println("🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊");
               break;
            case 2: //입금하기
               System.out.print("계좌번호 : ");
               account = sc.next();
               
               if(account.charAt(0) - 48 != bankNumber - 1) {
                  System.out.println("계좌를 개설한 은행에서만 입금 서비스를 이용하실 수 있습니다.");
                  break;
               }
               
               System.out.print("비밀번호 : ");
               password = sc.next();
               
               bank = Ttbank.login(account, password);
               if(bank != null) {
                  System.out.print("입금액 : ");
                  money = sc.nextInt();
                  if(money < 0) {System.out.println("금액이 잘못 입력되었습니다^^"); break;}
                  bank.deposit(money);
                  break;
               }
               System.out.println("계좌번호나 비밀번호를 다시 확인해주세요.");
               break;
            case 3: //출금하기
               System.out.print("계좌번호 : ");
               account = sc.next();
               System.out.print("비밀번호 : ");
               password = sc.next();
               
               bank = Ttbank.login(account, password);
               if(bank != null) {
                  System.out.print("출금액 : ");
                  money = sc.nextInt();
                  if(money < 0) {System.out.println("금액이 잘못 입력되었습니다^^"); break;}
                  if(bank.showBalance() - (bank instanceof TKookmin ? money * 1.5 : money) < 0) {
                     System.out.println("잔액이 부족합니다"); 
                     break;
                  }
                  bank.withdraw(money);
                  break;
               }
               System.out.println("계좌번호나 비밀번호를 다시 확인해주세요.");
               break;
            case 4: //잔액조회
               System.out.print("계좌번호 : ");
               account = sc.next();
               System.out.print("비밀번호 : ");
               password = sc.next();
               
               bank = Ttbank.login(account, password);
               if(bank != null) {
                  System.out.println("현재 잔액 : " + bank.showBalance() + "원");
               }
               break;
            case 5: //계좌번호 찾기
               System.out.print("핸드폰 번호 : ");
               phoneNumber = sc.next();
               
               bank = Ttbank.checkPhoneNumber(phoneNumber);
               
               if(bank != null) {
                  System.out.print("비밀번호 : ");
                  password = sc.next();
                  if(bank.getPassword().equals(password)) {
                     while(true) {
                        account = "";
                        for (int i = 0; i < 13; i++) {
                           account += r.nextInt(10);
                        }
                        if(Ttbank.checkAccount(account) == null) {break;}
                     }
                     bank.setAccount(account);
                     System.out.println("고객님의 계좌번호를 새롭게 발급해드렸습니다.");
                     System.out.println("고객님의 새로운 계좌번호는 " + account + "입니다.");
                     System.out.println("분실 시 계좌번호 찾기 서비스를 다시 이용해주세요~!");
                  }
               }
               break;
            }
            
         }
         
      }
      
   }
}
















