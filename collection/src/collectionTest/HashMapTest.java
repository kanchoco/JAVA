package collectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

//	제네릭은 갯수제한이 없다.
public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, Object> userMap = new HashMap<String, Object>();
//		hashmap은 컬렉션을 상속받지 않기 때문에 , add메소드를 사용할 수없다.
		userMap.put("id", "hds1234");
		userMap.put("pw", "1234");
		userMap.put("name", "배다빈");
		userMap.put("age", "17");
//		사이즈는 4, 한 쌍씩 들어가기 때문
		System.out.println(userMap.size());
		System.out.println(userMap);
//		키값을 넣으면, 짝의 값을 가져온다. 키값이 없는경우, null
		System.out.println(userMap.get("da"));
//		entry- 쌍,
		Iterator<Entry<String, Object>> iter = userMap.entrySet().iterator();
		
		while(iter.hasNext()) {
			Entry<String, Object> entry = iter.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		Iterator<String> iter2 = userMap.keySet().iterator();
		
	    while(iter2.hasNext()) {
	         System.out.println(iter2.next());
	      }
	      
	      System.out.println("=====================");
	      
	      for (Object value : userMap.values()) {
	         System.out.println(value);
	      }

	}
}
