package operatorTest;

public class MyOper {
	public static void main(String[] args) {
		boolean isTrue = 10 > 11;
		
		System.out.println(10 == 11);
		System.out.println(10 != 11);
		System.out.println(!true);
		System.out.println(isTrue);
		System.out.println(isTrue && 10 == 10);
		System.out.println(isTrue || 10 == 10);
		
		System.out.println(isTrue && 10 == 10);
		//true로 바꾸기, || 또는 !isTrue(true)로 바꾸기
	}
}
