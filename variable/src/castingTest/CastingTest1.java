package castingTest;

public class CastingTest1 {
	public static void main(String[] args) {
//		자동 형변환
		System.out.println(11/9);
		System.out.println(11/9.0);
	
//	강제 형변환
		System.out.println(11/(double)9);
		System.out.println((int)8.43+2.59);
		System.out.println((int)(8.43+2.59));
		
		System.out.println("dk" +  (int)2.59);
	
	}
}
