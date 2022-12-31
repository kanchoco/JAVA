package objectTest;

import java.util.Random;

public class HashCodeTest {
	public static void main(String[] args) {
		
		String data1 = "ABC";
		String data2 = "ABC";
		String data3 = new String("ABC");			
		String data4 = new String("ABC");
		System.out.println(data1.hashCode());
		System.out.println(data2.hashCode());				
		System.out.println(data3.hashCode());
		System.out.println(data4.hashCode());				
		
	
//		String data1 = "ABC";
//		String data2 = "ABC";
//		System.out.println(data1.hashCode());
//		System.out.println(data2.hashCode());				
		
//		Random r1 = new Random();
//		Random r2 = new Random();
//		System.out.println(r1.hashCode());
//		System.out.println(r2.hashCode());				
//		hashcode가 다르다, JVM에 올라가는 주소가 다르기 때문
//		Random은 주소가 계속 새롭게 할당된다, -> 메모리에서 주소를 더 효율적으로 관리하기 위해서이다.
	}
}
