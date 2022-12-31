package bank;


import java.util.Iterator;
import java.util.Random;

public class Bank {
//	부모 - Bank 
//	공통기능!  - 출금, 입금, 잔액조회, 계좌개설, 계좌번호 중복검사, 로그인, 핸드폰 번호 중복검사

//	변수 선언
	
	public static Bank[][] bankMembers = new  Bank[3][100];
	public static int[] arrbank = new int[3];									//뱅크멤버 조회시 사용할 배열로 행만큼 할당한다.
	
//	예금주 계좌번호 핸드폰번호 비밀번호 통장잔고
	private String name;
	private String account;
	private String phoneNumber;
	private String password;
	private int balance;
	
	
	
	public Bank() {;}		//기본 생성자
	
		
	public Bank(String name, String account, String phoneNumber, String password, int balance) {	//초기화 생성자
		super();
		this.name = name;
		this.account = account;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.balance = balance;
	}

//	private 변수 접근 메소드
	
	public String getName() {					//값을 반환해줌
		return name;
	}
	
	
	public void setName(String name) {	//	값을 가져와서 할당함
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
	
	
	public int getBalance() {
		return balance;
	}
	
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

//	은행 공통 기능들
	void deposit(int money) {	//입금
		balance += money;
	}
	
	void withdraw(int money) {	//출금
		balance -= money;
	}
	
	public int  checkBalance() {		//잔액조회
		return balance;
	}

	public static Bank checkAccount(String account) {		//계좌번호 중복검사
//					검사해서 중복값을 뱅크타입으로 전달받는 형태로 
		Bank bank = null;
		int j = 0;															//바깥쪽 포문을 나올때 사용해야하므로 바깥쪽에서 선언해준다		
		for (int i = 0; i < bankMembers.length; i++) {
			for (j = 0; j < arrbank[i]; j++) {
				if(bank.account.equals(account))	{
					bank = bankMembers[i][j];
					break;
				}
			}
			if(j != arrbank[i])	{break;}								//j는 arrbank[i]만큼 증가 중이다, 즉 중첩for문 안에서의 j는 arrbank[i]와 값이 같다,
		}
		return bank;
	}
	
	public static Bank login(String account, String password) {		//로그인, ID : 계좌번호 
		Bank bank = checkAccount(account);
		if(bank != null)	{									//뱅크타입의 중복 계좌번호를 반환하는 메소드이므로, null이 아닐경우 -> 아이디가 존재할 경우 가 된다.
			if(bank.password.equals(password))	{	//받은 계좌 회원정보의 패스워드와 입력한 패스워드가 일치하는지 확인한다.
				return bank;									//해당 회원을 리턴		 
			}
		}
		return null;											//회원이 존재하지 않을 시, 아무값도 반환하지 않는다.
	}
	
	static Bank checkPhoneNumber(String phoneNumber) {		//핸드폰 번호 중복검사
		Bank bank = null;
		int j = 0;															//바깥쪽 포문을 나올때 사용해야하므로 바깥쪽에서 선언해준다		
		for (int i = 0; i < bankMembers.length; i++) {
			for (j = 0; j < arrbank[i]; j++) {
				if(bank.account.equals(phoneNumber))	{
					bank = bankMembers[i][j];
					break;
				}
			}
			if(j != arrbank[i])	{break;}								//j는 arrbank[i]만큼 증가 중이다, 즉 중첩for문 안에서의 j는 arrbank[i]와 값이 같다,
		}																		//중첩for문을 나왔는지 확인 후 나왔다면 for문을 빠져나간다.			
		return bank;														//핸드폰번호가 일치하는 회원을 bank에 넣고 리턴한다.
	}
	

	
}
