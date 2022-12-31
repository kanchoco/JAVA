package arrayListTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DateApp {
//	고객들의 정보를 담을 DB
	public static ArrayList<Love> clients = new ArrayList<Love>();
//	public static ArrayList<Love> ideals = new ArrayList<Love>();
	
	
//	이상형 추가
	public static void add(Love ideal)	{
		clients.add(ideal);
	}
	
//	사용자가 입력한 나이인 이상형 목록 조회
	public static ArrayList<Love> lookup(int idealAge) {
		ArrayList<Love> ideals = new ArrayList<Love>();
		for(Love ideal : clients) {
			if(ideal.getAge() == idealAge) {
				ideals.add(ideal);
			}
		}
		return ideals;
	}

//	내코드
//	public static ArrayList<Love> lookup(int idealAge) {
//		for(Love ideal : clients) {
//			if(ideal.getAge() == idealAge) {
//				ideals.add(ideal);
//			}
//		}
//		return ideals;
//	}
	
//	이상형의 나이 수정
//	이상형의 번호를 추가하고 번호로 조회한다.
	public static void set(Love lovers)	{
		 for (Love ideal : clients) {
			if(ideal.getNumber() == lovers.getNumber())	{
				ideal.setAge(lovers.getAge());
			}
		}
	}
	
	
//	이상형의 나이 순으로 정렬하기
	public static void sort()	{
//      이상형의 나이만 담을 ArrayList
      ArrayList<Integer> ages = new ArrayList<Integer>();
      
//      오름차순으로 정렬된 이상형 정보를 담을 ArrayList
      ArrayList<Love> loves = new ArrayList<Love>();
      
      for (Love love : DateApp.clients) {
//         이상형의 나이만 담아주기
         ages.add(love.getAge());
      }
      
//      나이 오름차순 정렬
      Collections.sort(ages);
      
      for (int i = 0; i < DateApp.clients.size(); i++) {
//         정렬된 나이 ArrayList에서 첫번째 나이부터 비교
         for (Love love : DateApp.clients) {
            if(ages.get(i) == love.getAge()) {
//            찾았다면 순서대로 loves에 담아주기
               loves.add(love);
            }
         }
//       오름차순으로 정렬된 전체 정보를 DB에 저장
         	DateApp.clients = loves;

      }
	}
	
	public static void main(String[] args) {
		Love one = new Love();
		Love two = new Love();
		Love three = new Love();
		
		one.setAge(21);
		two.setAge(22);
		three.setAge(23);
		
		clients.add(one);
		clients.add(two);
		clients.add(three);
		
	}
}
