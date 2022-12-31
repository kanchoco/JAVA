package tbank;

public class Tbank {

	   public static Tbank[][] arrBank = new Tbank[3][100];															//은행 3개 이차원 배열
	   public static int[] arCount = new int[3];																				//반복문 검사범위를 잡기 위함
	   
//	   arrBank
//	   3행 100열
//	 
//	 은행1  {}   	 {}	   {}	.	.	.	   
//	 은행2  {} 	 {}	   {}	.	.	.	
//	 은행3  {} 	 {} 	   {}	.	.	.
//	   
//	   arCount
//		3행
//	   {} 
//	   {}
//	   {}
//	   이렇게 되면 3행씩 arrBank를 검사할 수 있다.
 
//		변수 선언
//	   private 변수 -> 클래스 "내부에서만 사용"
//	   --> 다른 클래스에서 접근하지 못하게 
//	   get set 메소드를 이용하여 접근
//		회원정보  - 예금주 계좌번호 핸드폰번호 비밀번호 통장잔고
	   private String name;																											//예금주
	   private String account;																										//계좌번호
	   private String phoneNumber;																								//전화번호
	   private String password;																									//비밀번호
	   private int money;																											//통장잔고
	   
	   public Tbank() {;}																											//기본 생성자
	   
	   public Tbank(String name, String account, String phoneNumber, String password, int money) {		//초기화 생성자
	      this.name = name;
	      this.account = account;
	      this.phoneNumber = phoneNumber;
	      this.password = password;
	      this.money = money;
	   }

//	   private 변수는 인터페이스에서 접근할 수 없기 때문에 get set 메소드를 사용하여 값을 변경한다
	   public String getName() {																												
	      return name;															//예금주 값을 전달함
	   }

	   public void setName(String name) {
	      this.name = name;														//예금주 값을 가져옴
	   }

	   public String getAccount() {
	      return account;														//계좌번호 반환
	   }

	   public void setAccount(String account) {							
	      this.account = account;												//계좌번호 값 세팅
	   }

	   public String getPhoneNumber() {
	      return phoneNumber;													//전화번호 반환	
	   }

	   public void setPhoneNumber(String phoneNumber) {
	      this.phoneNumber = phoneNumber;								//전화번호 값 세팅
	   }

	   public String getPassword() {
	      return password;														//패스워드 반환
	   }

	   public void setPassword(String password) {
	      this.password = password;											//패스워드 세팅
	   }

	   public int getMoney() {
	      return money;															//잔액 반환
	   }

	   public void setMoney(int money) {
	      this.money = money;													//잔액 세팅
	   }
	   
//	 public 메인에서만 사용가능한 접근자로 모든 곳에서 접근이 가능하다
//	   static(정적) 변수 컴파일러를 통해 메모리에 단 한번 할당, 모든 객체가 공유하는 값
//	   -> static 변수를 사용한 이유는 매번 객체화를 해야한다( = 계좌를 생성해야만 사용 가능하다), 
//	   중복검사는 개설 전과 후 모두 사용해야하는 메소드이므로 static 변수를 사용한다.
	   
	   //   계좌번호 중복검사
	   public static Tbank checkAccount(String account) {			//매개변수로 계좌번호를 받음
	      Tbank bank = null;														//Tbank타입의 bank 선언 및 초기화
	      for (int i = 0; i < arrBank.length; i++) {							//반복문, int i가 0부터 arrBank(2차원 회원배열)의 길이만큼 증가할 때,
	         int j = 0;																//j를 반복문 바깥쪽에서도 사용하기 위해 바깥쪽에 선언
	         for (j = 0; j < arCount[i]; j++) {								//j가 0부터 arCount[i](3행)까지 증가할 때, 		==> 3행, 3행, 3행 씩 검사한다
	            if(arrBank[i][j].account.equals(account)) {				// arrBank[i][j]의 계좌번호가 입력받은 계좌번호와 같다면,
	               bank = arrBank[i][j];											//	bank는 arrBank[i][j]이다. ==> 중복된 값을 bank에 넣음
	               break;															// 중첩for문 빠져나옴
	            }
	         }																			
	         if(j != arCount[i]) {break;}										//만약 j 가 arCount[i]와 같지 않다면 for문을 빠져나간다
	      }																				//	==> 즉, 중첩for문을 빠져나오면 바깥 for문도 빠져나간다	
	      return bank;																//bank(중복된값) 반환
	   }
	//   핸드폰 번호 검사
	   public static Tbank checkPhoneNumber(String phoneNumber) {
	      Tbank bank = null;
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
	   public static Tbank login(String account, String password) {		//계좌번호와 비밀번호를 매개변수로 받는다
	      Tbank bank = checkAccount(account);									//Tbank타입의 bank변수에 checkAccount(계좌번호 중복검사 메소드)를 사용하여 값을 받는다.
	      if(bank != null) {																//bank가 null이 아니라면, ==> bank는 중복값을 받아온다, 즉 일치하는(중복되는)값이 있다면
	         if(bank.password.equals(password)) {									//중첩if, 뱅크의 
	            return bank;
	         }
	      }
	      return null;
	   }
	//   입금
	   public void deposit(int money) {				//입력한 금액만큼 증가
	      this.money += money;						//매개변수와 전역변수가 같은 이름이므로, this가 생략불가해진다.
	   }
	//   출금
	   public void withdraw(int money) {			//입력한 금액만큼 감소
	      this.money -= money;
	   }
	//   잔액조회
	   public int showBalance() {
	      return money;									//this 생략, 총 금액을 리턴
	   }
	   
	}

