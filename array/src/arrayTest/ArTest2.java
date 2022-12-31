package arrayTest;

public class ArTest2 {
	public static void main(String[] args) {
		int[] arData = new int[10];
//		1~10
		for(int i = 0; i < arData.length; i++) {
			arData[i] = i+1;
		}
		//기능에따라 나눔
		for(int i = 0; i < arData.length; i++) {
			System.out.print(arData[i]);
		}
		
	}
}
