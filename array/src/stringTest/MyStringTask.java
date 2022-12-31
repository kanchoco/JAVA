package stringTest;

import java.util.Scanner;

public class MyStringTask {
	public static void main(String[] args) {
//		사용자에게 입력받은 문자열 중 소문자는 모두 대문자로,
//		대문자는 모두 소문자로 변경한다.
//		String msg = "문자열을 입력하세요." ,string = null, result = "";  //누적연결시 백문자열로 초기화
//		Scanner sc = new Scanner(System.in);
//				
//		System.out.println(msg);
//		string = sc.next();
//		
//		for(int i = 0; i < string.length(); i++) {
//			if(string.charAt(i) > (char)96 && string.charAt(i) < (char)123) {
//				result += (char)(string.charAt(i) - 32);				//result가 ""이기 때문에 result + () 하게 될 경우 모두 ""안으로 들어간다.
//			}
//			else if(string.charAt(i) > (char)64 && string.charAt(i) < (char)91) {
//				result += (char)(string.charAt(i) + 32);
//			}
//		}
//		System.out.println(result);
		
		
//		정수를 한글로 변경
//		예) 1024
//		-> 일공이사
		String changeWord[] = {"공", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
//		문자배열쓰지말고 문자열로, changeWord ="공일이삼사오육칠팔구"
		Scanner sc = new Scanner(System.in);
		String msg = "한글로 변경할 정수 입력",  userWord = null, result = "";
		
		System.out.println(msg);
		userWord = sc.next();
		
		for(int i = 0; i < userWord.length(); i++)	{
			int compare = userWord.charAt(i)-48;
			result += changeWord[compare%10];
		}
		System.out.println(result);

//			switch - case문			
//		for(int i = 0; i < userWord.length(); i++)	{
//			switch ((int)userWord.charAt(i)) {
//			case 49 :
//				result += changeWord[1];
//				break;
//			case 50 :
//				result += changeWord[2];
//				break;
//			case 51 :
//				result += changeWord[3];
//				break;
//			case 52 :
//				result += changeWord[4];
//				break;
//			case 53 :
//				result += changeWord[5];
//				break;
//			case 54 :
//				result += changeWord[6];
//				break;
//			case 55 :
//				result += changeWord[7];
//				break;
//			case 56 :
//				result += changeWord[8];
//				break;
//			case 57 :
//				result += changeWord[9];
//				break;
//			default :
//				result += changeWord[0];
//				break;
//			}
//		}
//		System.out.println(result);
	}
}
