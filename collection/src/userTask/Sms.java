package userTask;
import java.util.ArrayList;
//	인증번호 메소드를 선언하기 위한 클래스
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
public class Sms  {							

		String api_key = "NCSHHRBBRQFFVMUV";											//쿨SMS 서비스를 이용하기위해 적은 계정 인증 키들
	    String api_secret = "7QNH9PVZDK6AKCQXR3LKVZBPZVAIYUKD";
	    Message coolsms = new Message(api_key, api_secret);
	
	    public static String random() {														//랜덤 인증번호를 만드는 메소드
	    	Random r = new Random();														// 객체화, 랜덤클래스를 객체 r로 객체화한다.
	    	String random ="";																	//String random, 랜덤으로 출력된 숫자를 담을 문자열 변수이다.(누적값은 빈문자열)
		   for (int i = 0; i < 6; i++) {															//int i 가 0부터 5까지 1씩 증가할 때, 아래 실행문을 반복한다,(랜덤숫자는 총 6개)		
			random += (char)(r.nextInt(10) + 48);											//객체r로 Random클래스에 접근하여 nextInt메소드를 사용한다.(bound = 10, 0~9까지의 숫자를 가져온다.)
																										//아스키코드로 0이 48이므로 + 48을 해준 뒤, 문자열에 담을것이므로 계산이 끝난 int값을 char로 강제형 변환한다.
		}
		   return random;																			//랜덤한 숫자 6개로 이루어진 문자열 random을 리턴
	   }
//	인증번호를 보내는 메소드
//	외부에서 전화번호를 입력받은 뒤, 위 랜덤메소드을 실행하여 랜덤한 번호를 인증번호로 보낸다.
	public String sendSms(String phone) {													//매개변수 String phone, 전화번호를 입력받는다.
		String random = random();															//String타입의 문자열 random에 random()실행값을 넣는다.
																										//변수에 담은이유는, 매 출력시마다 random()을 쓰게되면 호출이 아닌 실행을 하게된다, 우린 호출이 필요하므로 변수에 담는다.
		    // 4 params(to, from, type, text) are mandatory. must be filled
		    HashMap<String, String> params = new HashMap<String, String>();//해쉬맵<String(key),String(value)>을 params 객체로 객체화
		    params.put("to", phone);														  						//put(key, value)키에 value값을 전달, to(받는이), 매개변수 phone(입력받은 전화번호)
		    params.put("from", "ㅇㅇㅇ");																			//from(보내는이), "ㅇㅇㅇ"
		    params.put("type", "SMS");																			//type은 SMS
		    params.put("text", "고객님의 인증번호는 [" + random + "]입니다.\n정확하게 입력해주세요.");		//text(내용), "고객님의 인증번호는 [랜덤한 6개의 숫자]입니다.\n(줄바꿈)정확하게 입력해주세요."
		    params.put("app_version", "test app 1.2"); // application name and version
	
		    try {																											//예외가 날 수 있는 실행문을 담음 
		      JSONObject obj = (JSONObject) coolsms.send(params);
		      System.out.println(obj.toString());
		    } catch (CoolsmsException e) {																		//해당예외(CoolsmsException) 발생시 catch로 받는다.
		      System.out.println(e.getMessage());																//예외메세지를 출력한다.
		      System.out.println(e.getCode());																	//예외코드를 출력한다.
		    }
		return random;																								//사용자에게 보낸 인증번호를 리턴한다. -> 인증번호 확인을 위해 
		}
	}


