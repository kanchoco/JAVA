package operatorTest;

public class Oper6 {
	public static void main(String[] args) {
		
//		1 ~ 10까지 중 4까지만 출력
//		for(int i = 0; i<10; i++) {
//			System.out.println(i+1);
//			if(i == 3) {
//				break;
//			}
//		}
		
//		1~10까지 중 3을 제외하고 출력하기
		for(int i =0; i < 10 ; i++)	{
			if(i == 2)	{
				continue;			//밑 문장을 넘김, 2일 경우 밑에 출력을 건너뜀, -> 3을 제외하고 출력하게됨
			}	
			System.out.println(i + 1);
		}
	}
}
