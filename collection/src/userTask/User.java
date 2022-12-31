package userTask;

import java.util.ArrayList;

public class User {
	private String name;
	private String id;
	private String password;
	private String phoneNumber;

	
	//기본생성자
	public User() {;}			

	//게터 세터
//	private - 다른클래스에서 접근 불가, 오직 메소드로만 접근 가능
//	getter - 값을 가져옴, setter - 값을 설정함.(단축키 Alt+Shift+S  + R)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

//	toString 재정의
	@Override
	public String toString() {													//출력시 생략되는 toString을 재정의하여 회원정보를 확인할 수 있게 한다.
		String str = name + "," + id + "," + phoneNumber;				//이름, 아이디, 폰넘버가 출력될 수 있도록 재정의
		return str;																	//str 리턴
	}
	
}
