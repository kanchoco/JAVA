package exceptionTest;

public class ExceptionTest {
	public static void main(String[] args) {
		try {													//오류가 날 수도 있는 실행문
			System.out.println(10/0);			 
		}	catch(Exception e)	{						//모든 오류를 감지한다.
			System.out.println("알 수 없는 오류");		//어떤 오류인지는 알 수 없으므로, "알 수 없는 오류"출력
			System.out.println(e);						//어떤 오류인지 확인, 어떤 오류인지 출력한다.
			
		}
		System.out.println("반드시 실행해야 하는 문장");	
	}
}
