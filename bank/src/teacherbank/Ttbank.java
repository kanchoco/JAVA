package teacherbank;


public class Ttbank {
//	은행이 3개, 각 은행별 회원수 배열
   public static Ttbank[][] arrBank = new Ttbank[3][100];
   public static int[] arCount = new int[3];
   
   private String name;
   private String account;
   private String phoneNumber;
   private String password;
   private int money;
   
   public Ttbank() {;}

   public Ttbank(String name, String account, String phoneNumber, String password, int money) {
      this.name = name;
      this.account = account;
      this.phoneNumber = phoneNumber;
      this.password = password;
      this.money = money;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAccount() {
      return account;
   }

   public void setAccount(String account) {
      this.account = account;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public int getMoney() {
      return money;
   }

   public void setMoney(int money) {
      this.money = money;
   }
   
//   static을 붙여서 선언한 메소드
//   객체화 없이 사용해야 할 때가 있기 때문
//   객체화 없이 사용하면 편하기 때문
   
   
//   계좌번호 중복검사
//   외부에서 생성된 계좌번호를 전달받는다.
   public static Ttbank checkAccount(String account) {
      Ttbank bank = null;
      for (int i = 0; i < arrBank.length; i++) {							// 은행 수 만큼 반복
         int j = 0;																//for문 영역 밖에서 사용하기 위해 밖에서 선언
         for (j = 0; j < arCount[i]; j++) {								// 각 은행별 가입된 회원 수 만큼 반복			
            if(arrBank[i][j].account.equals(account)) {				// 각 회원들의 계좌번호와 생성된 계좌번호를 비교한다.
//            만약 일치하는 계좌번호가 있다면 해당 객체를 bank에 담아준다
            	bank = arrBank[i][j];
//            	더 이상 반복을 진행할 필요가 없다.
               break;
            }
         }
//         위에서 강제로 break를 했다면 j가 arCount[i]까지 증가하지 못하기 때문에
//         위에서 break 후 밖에 있는 for문도 break 해준다.
         if(j != arCount[i]) {break;}
//         중첩for문은 j가 증가하는 중, 중첩문을 빠져나간 후 j는 증가하지않는다, j가 arCount[i]와 같지 않다면 break는 즉, 중첩문을 나왔다면 바깥for문도 나온다.
      }
      return bank;
   }
//   핸드폰 번호 검사
   public static Ttbank checkPhoneNumber(String phoneNumber) {
      Ttbank bank = null;
      for (int i = 0; i < arrBank.length; i++) {
         int j = 0;
         for (j = 0; j < arCount[i]; j++) {
            if(arrBank[i][j].phoneNumber.equals(phoneNumber)) {
               bank = arrBank[i][j];
               break;
            }
         }
         if(j != arCount[i]) {break;}
      }
      return bank;
   }
//   로그인
//   외부에서 생성된 계좌번호와 비밀번호를 전달받는다.
   public static Ttbank login(String account, String password) {
//	   계좌번호는 checkAccount에 전달한다.
//	   계좌가 있다면 해당 회원의 전체 정보를 가져온다.
//	   계좌가 없다면 null을 가져온다.
      Ttbank bank = checkAccount(account);
//      계좌번호가 존재한다면,
      if(bank != null) {
//    	  그 회원의 비밀번호와 입력받은 비밀번호를 비교한다.
         if(bank.password.equals(password)) {
//        	 로그인 성공 시, 회원의 전체 정보를 리턴한다.
            return bank;
         }
      }
//      로그인 실패시 null을 리턴한다.
      return null;
   }
//   입금
   public void deposit(int money) {
      this.money += money;
   }
//   출금
   public void withdraw(int money) {
      this.money -= money;
   }
//   잔액조회
   public int showBalance() {
      return money;
   }
   
}

