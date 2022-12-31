package collectionTest;

import java.util.ArrayList;
import java.util.HashSet;
//	hashcode - 중복인지 아닌지 검사
public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> bloodTypes = new HashSet<String>();
		ArrayList<String> bloodTypeList = null;

		bloodTypes.add("A");
		bloodTypes.add("B");
		bloodTypes.add("O");
		bloodTypes.add("AB");		//hashcode값이 같기 때문에 hashset안에 들어가지 않는다.
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		
		 bloodTypeList = new ArrayList<String>(bloodTypes);

		
//		System.out.println(bloodTypes);				//--->중복 시 무시, 즉 중복검사를 해줌
																//출력시 값이 출력되는 이유는, set타입의 값이 출력된것이 아니고 toString재정의로 이터레이터타입의 값을 가져오는 것이다.
////		값을 가져오기 위해 이터레이터를 사용한다.
//		Iterator<String> iter =	bloodTypes.iterator();
////		hasNext로 다음값이 있는지 검사하고, next로 값을 가져온다.
//		while(iter.hasNext())	{
//			System.out.println(iter.next());
//		}
	}
}
