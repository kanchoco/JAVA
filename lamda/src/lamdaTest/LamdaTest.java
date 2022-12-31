package lamdaTest;

public class LamdaTest {
	public static void main(String[] args) {
		LamdaInter lamdaInter1 = (number) -> number % 10 == 0;
//		이렇게 쓰는거에 익숙해져야함, 
		
//		아래와 같다, 축약
		boolean result = lamdaInter1.checkMultipleOf10(11);
		System.out.println(result);
		
		LamdaInter lamdaInter2 = (n) -> {
			System.out.println("10의 배수 검사");
			return n % 10 == 0;
		};
		boolean result2 = lamdaInter2.checkMultipleOf10(20);
		System.out.println(result2);
	}
}
