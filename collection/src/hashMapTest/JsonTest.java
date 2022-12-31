package hashMapTest;

import java.util.HashMap;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonTest {
	public static void main(String[] args) {
		HashMap<String, Object> userMap = new HashMap<String, Object>();
		JSONObject userJSON = null;
		JSONArray users = new JSONArray();
//		hashmap은 컬렉션을 상속받지 않기 때문에 , add메소드를 사용할 수없다.
		userMap.put("id", "hds1234");
		userMap.put("pw", "1234");
		userMap.put("name", "배다빈");
		userMap.put("age", "17");
		
		userJSON = new JSONObject(userMap);
//		System.out.println(userJSON.toJSONString());
//		회원이 여럿일 때, 제이슨어레이를 쓴다.[], 어레이는 인덱스가 있으므로 밸루값만 갖고있다., defalut : -> 디폴트값으로 밸루를 가져옴
		
		users.add(userJSON);
		
		userMap.put("id", "hds12334");
		userMap.put("pw", "5555");
		userMap.put("name", "배다빈");
		userMap.put("age", "20");
		
		userJSON = new JSONObject(userMap);
		users.add(userJSON);
		
		System.out.println(users.toJSONString());
		
		System.out.println(((JSONObject)users.get(0)).toJSONString());
		
	}
}
