package userTask;

import java.util.Scanner;

//Page 클래스 선언
//- main메소드 선언
//- 테스트 진행
public class Page {																//로그인, 회원가입, 비밀번호찾기, 로그아웃, 종료 기능이 있는 프로그램
	public static void main(String[] args) {
//	선언부
		int choice = 0, login = 0;												//로그인의 유무를 알리기 위한 int login변수, 사용자에게 실행문 선택번호를 받을 choice
		String id =null, pw = null, phoneNumber = null, name = null, menu = "1. 로그인하기\n2. 회원가입하기\n3. 비밀번호찾기\n4. 로그아웃\n5. 종료";
		//사용자의 입력을 저장할 id, pw, phoneNumber,name변수와 출력할 메뉴를 담은 menu		
		Scanner sc = new Scanner(System.in);
//		Scanner클래스를 객체 sc로 객체화
		UserField check = new UserField();
//		UserField를 check객체로 객체화,  사이트의 기능과 회원목록을 갖고 있는 클래스,
		User user = new User();
//		User를 user로 객체화, 회원정보를 가진 클래스
		Sms sms = new Sms();
//		Sms를 sms객체로 객체화, 인증번호 메소드
																										//프로세스 설명
		while(true)	{																			//무한반복
		System.out.println("------------------------------------------");
		System.out.println(menu);																//메뉴출력
		System.out.println("------------------------------------------");
		choice = sc.nextInt();																	//메뉴를 보고 사용자에게 번호를 입력받음
		if(choice == 5) {System.out.println("종료합니다.");break;}					//5(종료)선택시 종료 안내문 출력과 함께 while문을 빠져나옴
		
			switch(choice) {																		//사용자에게 입력받은 choice를 기준으로하는 스위치 케이스문
			case 1 :																					//1(로그인하기)
				System.out.println("LOGIN");													//로그인 안내문
				System.out.println("아이디 입력 : ");											//
				id = sc.next();																		//id를 입력받아 변수에 넣음
				System.out.println("패스워드 입력 : ");											//pw입력을 위한 안내문
				pw = sc.next();																	//pw를 입력받아 pw변수에 넣음
				user = check.login(id, pw);														//User타입의 user에 checkId(중복되는 아이디가 있을 시, 해당 회원 리턴)메소드 실행 값을 넣음
				if(user != null)	{																	//만약 user가 널이 아니라면?-> 중복되는 아이디가 존재함 즉, 회원정보를 리턴받았다면,
					login =1;																			//로그인을 알리는 login변수에 1을 넣어 로그인을 했다는것을 알린다.
					System.out.println(user.getName() + "님 환영합니다.");				//로그인 성공 출력문-> user에 private에 get(값을 가져옴)메소드로 접근하여 이름을 가져온다.
				} else{System.out.println("없는 회원입니다.");}								//로그인 실패 시 "없는 회원입니다."를 출력하여 로그인에 실패했다는것을 사용자에게 알린다.
				System.out.println();															
				break;																				//switch문을 탈출~
				
			case 2 :																					//2번, 회원가입하기
				System.out.println("회원가입");													//회원가입 안내문
				System.out.println("사용하실 아이디를 입력하세요.");							//아이디를 입력받기위한 출력문
				id = sc.next();																		//입력받은 아이디를 id에 넣는다.
				if(check.checkId(id) != null)	{												//만약 checkId(중복된 아이디의 회원을 반환)가 널이아니라면??--> 중복되었다면??, 회원의 값을 리턴받았다면?
					System.out.println("이미 존재하는 아이디입니다.");							//중복된 아이디임을 사용자에게 알리기 위한 출력문
					break;																			//회원가입 실패로 스위치문을 빠져나간다, 아이디가 존재할 경우, "3번 비밀번호 찾기"를 먼저 할 수 있도록 메뉴로 바로 보낸다.
				} 																
				User newUser = new User();													//id중복이 없을 경우, -> checkId메소드 실행값이 null일 경우, 새로운 유저를 생성한다.
				newUser.setId(id);																//새로운 유저에 private변수에 setter로 접근하여 id값을 사용자에게 입력받은 id로 저장한다. 
				System.out.println("사용가능한 아이디입니다.");								//사용자에게 이 아이디가 사용가능하며, 아이디의 값을 저장했다는 안내문을 출력한다.
				System.out.println("이름을 입력해주세요.");									//이름입력을 받기위한 안내문
				name = sc.next();																//사용자에게 입력받은 값을 name변수에 저장한다.
				newUser.setName(name);														//새로만든 유저에 name변수와 setter를 사용하여 이름값을 저장한다.
				System.out.println("패스워드를 입력하세요");									//패스워드를 입력받기 위한 안내문
				pw = sc.next();																	//사용자에게 패스워드를 입력받아 pw변수에 저장
				newUser.setPassword(check.encryption(pw));							//보안을 위하여 암호화메소드를 사용한 뒤, 유저의 비밀번호에 값을 저장한다.-> 실제 암호를 알 수 없도록
			while(true) {																			//무한반복, -> 올바른 핸드폰번호를 입력 받기위해
				System.out.println("핸드폰번호를 입력하세요");									//핸드폰번호를 입력받기 위한 안내문
				phoneNumber = sc.next();														//입력받은 문자열을 변수에 저장한다.
																										//핸드폰 번호검사 시작!
				if(!check.checkPhone(phoneNumber))	{									//만약 checkPhone()실행값이 false라면(! = not)
					System.out.println("다시 입력해주세요.");continue;						//입력받은 문자가 잘못됨을 알림과 동시에 올바른 번호를 전달받기 위한 경고문을 출력한다.
				}																						//continue 아래 실행문 건너뜀
				newUser.setPhoneNumber(phoneNumber);									//바른 번호 입력시(checkPhone()실행값이 true) 새로운 유저에 전화번호값을 저장한다.
				break;																				//그리고 while문 탈출
				}
				System.out.println("회원가입 하시겠습니까?\n1. 확인\n2. 취소");			//회원가입 진행을 위한 확인문을 출력한다.
				choice = sc.nextInt();															//사용자의 선택을 입력받는다.
				if(choice != 1)	{System.out.println("회원가입을 취소합니다.");break;}	//2번 혹은 확인 외에 다른 선택시에 회원을 DB에 전달하지 않고 케이스문을 탈출한다, 회원가입이 정상적으로 완료되지 않았음을 사용자에게 알린다.
					check.userDb.add(newUser);												//회원가입 수락 시, 작성한 회원을 데이타베이스(userDb)에 추가한다.
					check.idDb.add(id);															//회원의 아이디를 회원 아이디 데이타베이스(idDb)에 추가한다.
					System.out.println("회원가입 완료");										//회원가입이 정상적으로 이루어짐을 사용자에게 알린다.
				break;																				//스위치문을 탈출한다.
				
			case 3:																					//3번 비밀번호찾기 선택 시,
				System.out.println("비밀번호 찾기");											//비밀번호 찾기 
				if(login == 1) {																	//만약, 로그인이 되어있는 상황이라면,(사용자에게 유저정보를 받아올 필요가 없다면)
					while(true) {	
						System.out.println("본인인증");											//진행상황을 사용자에게 알리는 출력문
						System.out.println("");
						String key = sms.sendSms(user.getPhoneNumber());			//인증번호를 생성, 전송하는 메소드를 실행 한 후 인증번호 값은 key변수에 담는다.(비교를 위해)
						System.out.println("가입 시 입력한 번호로 인증번호가 전송되었습니다.");//인증번호가 전송되었다는것을 사용자에게 알리는 출력문
						System.out.println("-------------------------------------------------------");
						System.out.println("전송된 인증번호를 입력해주세요.");				//인증번호 확인을 위해 받은 전송받은 인증번호를 입력받는다.
						System.out.println(key);												//이건 테스트시 인증번호 확인을 위해 전달한 인증번호를 인터페이스에 출력하게 했다.
						if(!sc.next().equals(key)) {											//만약 입력받은 인증번호가 전송한 인증번호와 다르다면? (입력을 변수에 담지 않은것은, 일회성으로 사용하기 때문에 담지 않았다.)
							System.out.println("인증번호가 틀립니다!"); continue;			//인증번호가 다를 시 비밀번호 변경이 진행이 되지 않는다는 것을 사용자에게 알린다. , 
						}																				//continue로 아래 실행문을 무시한 뒤 다시 본인인증을 진행할 수 있게 한다.
						System.out.println("변경하실 비밀번호를 입력하세요.");				//본인인증 성공 시, 변경할 비밀번호를 입력받기 위한 안내문을 출력한다.
						pw = sc.next();															//pw에 입력한 문자열을 담는다.
						check.changePw(user, pw);											//입력받은 문자열(pw)를 비밀번호 변경메소드(changePw)에 매개변수로 담아 실행한다.(유저정보는, 로그인이 되어있으므로 로그인한 유저의 정보를 담은 변수를 전달한다.)
						System.out.println("비밀번호가 변경되었습니다.");						//비밀번호 변경이 정상적으로 마쳤다는것을 사용자에게 알린다.
						break;																		//while문을 탈출한다.
					}
					
				}if(login == 0 )	{																//로그인이 되지 않았을 경우, (User정보를 사용자에게 입력받아야 하는 경우)
					System.out.println("아이디를 입력하세요");									//로그인이 되었을 때와 달리, 유저의 정보를 먼저받아야 하므로 아이디를 입력받는다.
					id = sc.next();																	//입력받은 아이디를 id에 담는다
					user =  check.checkId(id);													//중복체크 메소드를 실행하여 유저의 정보를 받아온다. -> 없을 시 실패
					if(user != null)	{																//유저의 정보를 받아오는데 성공했다면,
						while(true) {																//무한반복
							System.out.println("본인인증");										//본인인증 -- 로그인 되었을 때와 똑같이 진행된다.
							System.out.println("");
							String key = sms.sendSms(user.getPhoneNumber());
							System.out.println("가입 시 입력한 번호로 인증번호가 전송되었습니다.");
							System.out.println("-------------------------------------------------------");
							System.out.println("전송된 인증번호를 입력해주세요.");
							System.out.println(key);
							if(!sc.next().equals(key)) {	
								System.out.println("인증번호가 틀립니다!"); continue;
							}
							System.out.println("변경하실 비밀번호를 입력하세요.");
							pw = sc.next();
							check.changePw(user, pw);										//위에서 입력받은 아이디로 받아온 유저의 정보와 입력받은 비밀번호를 전달한다
							System.out.println("비밀번호가 변경되었습니다.");
							break;																	//while문 탈출
							}
						}else{System.out.println("없는 회원입니다.");break;}			//아이디 중복체크 실패시(회원 정보가 없을 시) 비밀번호찾기를 실패했다는것을 사용자에게 안내한 뒤, if문을 탈출한다.
				}
				break;																				//공통 실행, 모두 실행한 뒤에는 switch문을 탈출한다.																		
			case 4:																					//4번 로그아웃
				if(login == 1)	{																	//만약 로그인이 되어있다면?
					System.out.println("로그아웃 하시겠습니까?\n1. 예\t2. 아니오");		//로그인이 되어있음을 알리며, 로그아웃을 다시한번 확인한다.
					choice = sc.nextInt();														//사용자의 선택을 입력받는다.
					if(choice == 1)	{															//만약 로그아웃을 진행한다면
						login = 0;																	//로그인을 알리는 변수 login의 값을 0으로 변경하고,
						System.out.println("로그아웃 되었습니다.");							//로그아웃 안내문을 출력한다.
					}else {System.out.println("취소합니다.");break;}						//진행을 취소했다면, 진행취소를 사용자에게 알리고 if문을 탈출한다.
				}else{System.out.println("로그인을 해주세요.");}							//만약 로그인이 되어있지 않다면, 로그인을 부탁하는 안내문을 출력한다.		
				break;																				//스위치문 탈츌, 다시 메뉴로 돌아간다
			}
		}
	
	
		
		
		
	}
}
