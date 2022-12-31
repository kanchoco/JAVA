package userTask;

import java.util.ArrayList;

//UserField 클래스 선언
//- 회원 정보를 담을 DB를 ArrayList로 선언
//- 아이디 중복검사
//- 회원가입
//- 로그인
//- 암호화
//- 비밀번호 변경(비밀번호 찾기 서비스) -> 새로변경
//- 인증번호 전송/인증번호 비교

public class UserField  {
	public static ArrayList<User> userDb = new ArrayList<>();						//user들을 관리할 DB, User타입의 ArrayList로 선언
	public static ArrayList<String> idDb = new ArrayList<>();						//id를 관리할 DB, String타입의 ArrayList로 선언
	
//ID중복체크/ 존재여부 확인
//	외부에서 id를 받아와 데이터베이스(ArrayList)안에 있는지 검사하여, 있다면 해당 유저를 반환하고, 없으면 null을 반환하는 메소드  
	
	public static User checkId(String id)	{												//String타입의 매개변수를 받는 User타입을 반환하는(User타입으로 반환해야 접근이 편해지기 때문에) checkId메소드, 
		int index = 0;																				//index 값을 넣을 int타입의 index변수 선언
		if(idDb.contains(id))	{																	//idDb리스트에 id와 동일한 값을 찾음
				index = idDb.indexOf(id);														//있다면, index에 idDb리스트에 id값이 위치한 인덱스를 저장함
				return userDb.get(index);														//userDb리스트에 index위치의 값을 리턴함
			}																							// -> userDb와 idDb 동일한 인덱스의 동일한 회원을 가지고 있다. 	
		return null;																				//매개변수 id가 idDb안에 없다면 아무것도 리턴하지 않는다.
		}
	
	//로그인	
//	외부에서 id와 pw를 받아와 해당 id를 가진 회원이 있는지, 해당 회원이 설정한 비밀번호와 같은지 검사하여 맞으면 해당 유저를 반환, 틀리다면 null을 반환하는 메소드
	
	public static User login(String id, String pw)	{										//String 타입의 두 매개변수를 받는다(검사할 아이디와 패스워드)
		User user = checkId(id);																//id를 검사하여 해당회원을 반환하는 메소드 checkId를 사용하여 반환된 회원을 User타입의 user 변수에 담는다.
		if(user != null)	{																			//만약, user의 값이 null 이 아니라면(checkId실행 후 user를 반환받았다면 == 아이디가 존재한다면)
			if(decryption(user.getPassword()).equals(pw)) {;							//중첩if, 복호화한 암호값과 외부로 받아온 매개변수 pw의 값이 같다면,  
			return user;																			//해당하는 user를 반환한다.
			}
		}
		return null;																				//user값이 null이거나(아이디가 없거나), 비밀번호가 틀린경우 null 리턴 
	}
//	-비밀번호변경
//	외부에서 User타입의 매개변수, 회원과 변경할 비밀번호를 입력받아 해당 유저의 비밀번호를 변경하는 실행메서드
	
	public static void changePw(User user, String pw) {								//User타입의 user, String 타입의 pw를 매개변수로 받는다.
		User userOrigin = checkId(user.getId());											//User타입의 userOrigin선언, 해당회원의 Id를 받아와 checkId메서드를 실행한 후 반환된 값을 userOrigin에 넣는다.
		userOrigin.setPassword(encryption(pw));											//받아온 매개변수 pw를 암호화한 뒤 userOrigin의 패스워드로 변경한다.
	}
	
//	휴대폰번호 검사
//	외부에서 휴대폰번호를 받아와, 휴대폰번호가 올바르게 작성되었는지 검사하는 메소드
	public static boolean checkPhone(String phone) {								//String 타입의 매개변수를 받아온다.
		if(phone.startsWith("010") && phone.length() == 11)	{						//만약, 매개변수 phone이 "010"으로 시작하지 않는다면 &&(And, 모든 조건이 참이어야 참) 매개변수phone의 길이가 11이라면,
			return true;																			//true를 리턴한다.(boolean메소드)
		}return false;																				// 둘 중 하나라도 거짓이라면, false를 리턴한다.
	}
	
//	암호화
//	String타입의 encryption메소드, 외부에서 비밀번호를 받아와 암호화한 값을 반환한다.
	public static String encryption(String pw)	{										//String타입의 매개변수 pw를 받아온다.
		String encryptpw = "";																	//암호화된 비밀번호를 담을 String변수, - 초기값이 빈문자열인 이유는, 누적할 시 null을 초기값으로 쓰면 null,(누적값)으로 되기 때문
		for (int i = 0; i < pw.length(); i++) {												//int i가 pw의 문자열 길이만큼 1씩 증가할때, 아래 실행문을 반복한다.
				encryptpw += (char)(pw.charAt(i) - 80);									//encryptpw에 pw.charAt(i)/인덱스i의 문자값 - 80을 한 값을(자동형변환으로 int가됨)다시 char로 형변환한 뒤, 값을 넣음
		}return encryptpw;																		//암호화된 문자를 리턴
	}
//	복호화
//	encryption메소드를 실행하여 암호화한 패스워드를 다시 복호화하는 메서드		--> 사용자에게 비밀번호값을 비교받기 위해 다시 복호화한다.(암호화된 값은 사용자는 모르므로)
	public static String decryption(String pw)	{										//String 타입의 pw매개변수를 받아온다.
		String decryptpw = "";																	//복호화된 비밀번호를 담을 String변수
		for (int i = 0; i < pw.length(); i++) {												//int i가 0부터 pw의 길이만큼 1씩 증가할 때, 아래 실행문을 반복한다.
				decryptpw += (char)(pw.charAt(i) + 80);									//인덱스i의 pw 문자값과 80을 더한 뒤, char타입으로 강제형변환을 하여 문자열 decryptpw에 누적한다.
		}return decryptpw;																		//복호화된 문자를 리턴한다.
	}
	
	
}
