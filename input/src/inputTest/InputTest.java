package inputTest;

import java.util.Scanner;

public class InputTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		//Scanner라는 클래스가 선언되지 않았기 때문에 Import로 선언해주어야 함(Scanner는 내장클래스가 아니다)		
		// 선언방법
//		Ctrl + space
//		Ctrl + Shift + O >> import 단축키, 해당 클래스가 존재하는 패키지 전체를 불러줌
		//sc.next() - 사용자가 입력한 값
//		 초기값
//		정수 : 0
//		실수 : 0.0
//		문자 : ' '
//		문자열 : null or " "
		String name = null;
		String firstName = null;
		
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.println(name + "님 환영합니다.");
//		name  = sc.next();
//		firstName = sc.next();	
//		System.out.println(name + firstName + " 님 환영합니다.");
	}
}
