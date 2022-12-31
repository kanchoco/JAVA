package controllTest;

import java.util.Scanner;

public class Iftask {
public static void main(String[] args) {
	String message = "Q. 당신이 좋아하는 색을 선택하세요";
	String choiceMessage = "1. 빨간색\n 2. 노란색\n 3. 검은색\n 4. 흰색";
	String redMessage = "불같고 열정적이고 적극적이다.";
	String yellowMessage = "발랄하고 밝고 귀엽고 개성있고 착하다.";
	String blackMessage = "묵묵하고 든든하고 냉철하고 멋지다.";
	String whiteMessage = "천사같고 깔끔하고 정리를 좋아하고 배려심이 많다.";
	String resultMessage = null;
	String errorMessage = "다시 입력하세요";
	
	int choice = 0;
	Scanner sc = new Scanner(System.in);
	
	System.out.println(message + "\n" + choiceMessage);
	choice = sc.nextInt();
	
	//if문 사용
//	if (choice == 1) {
//		resultMessage = redMessage;
//	}else if (choice == 2)	{
//		resultMessage = yellowMessage;
//	}else if(choice == 3)	{
//		resultMessage = blackMessage;
//	}else if(choice == 4){
//		resultMessage = whiteMessage;
//	}else	{
//		resultMessage = errorMessage;
//	}
	
	//switch문 사용
	switch(choice)	{
	case 1 : 
		resultMessage = redMessage;
		break;												//맞는 문을 찾고 나서 빠져나오는 구문을 넣지 않으면 전체가 출력이됨
	case  2 : 
		resultMessage = yellowMessage;
		break;
	case 3 : 
		resultMessage = blackMessage;
		break;
	case 4 : 
		resultMessage = whiteMessage;
		break;
	default:
		resultMessage = errorMessage;
		break;
}
	
	System.out.println(resultMessage);
	
	}
}
