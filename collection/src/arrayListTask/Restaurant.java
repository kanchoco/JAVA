package arrayListTask;

import java.util.ArrayList;

public class Restaurant {
//	음식 정보를 담을  DB선언
	public static ArrayList<Food> foods = new ArrayList<Food>();
//	음식 추가
	public static void addFood(Food food)	{
		foods.add(food);
	}
	//매개변수 타입이 애매할때, 
//	여러개거나, 수정은 객체로 받는다, 하나 전달받을때는 맵핑작업때문에 하나만 생각하는것이 효율적이다
	
//	양식인지 중식인지 일식인지 한식인지 검사
//	스파게티 입력 시 "양식"리턴
	public static String checkSpecific(String foodName)	{	//매개변수로 음식이름을 받음
//		빠른포문, Food타입의 food가 리스트foods를 돌며 값을 가져온다.
		for (Food food : foods) {
//		만약 foods안에 사용자가 입력한음식이 있다면
			if(food.getName().equals(foodName))	{
//		해당 음식의 종류를 리턴한다
				return food.getSpecific();
			}
		}	
		return null;	
	}
//	사용자가 말하는 종류의 음식 목록 조회
//	예)한식 입력 시 한식만 조회
	public static ArrayList<Food> lookup(String specific)	{
//		음식의 목록을 조회하므로, 리턴타입을 어레이리스트로 한다.
//		조회한 음식을 담을 리스트
		ArrayList<Food> wantedFood = new ArrayList<Food>();
		for (Food food : foods) {
//		만약 foods안에 사용자가 입력한 종류의 해당하는 음식이 있다면
			if(food.getSpecific().equals(specific)) {
//		조회한 음식을 담을 리스트에 추가해준다.
				wantedFood.add(food);
			}
		}
//		음식을 담은 리스트를 리턴한다.
		return wantedFood;
	}
	
//	음식의 종류 수정(가격 10%상승)
//	예)한식 -> 
	public static void setSpecific(Food setFood)	{
//			반복문을 돌면서 해당하는 음식을 찾아 변경한다. | 음식의 이름과 수정할 종류를 받아야 하므로 Food타입으로 받는다.
		for (Food food : foods) {
//			입력받은 Food타입의 name값의 접근해서 foods값의 name과 비교하여 일치하는지 검사한다.
			if (food.getName().equals(setFood.getName())) {
//			값이 일치할때,	종류를 변경해야하므로 food에 set으로 접근, 입력한setFood의 get으로 접근하여 값을 가져온뒤 food에 set한다.
				food.setSpecific(setFood.getSpecific());
//			10%계산은 double타입으로 진행된다. 계산 후에 String format으로 소수점을 떼고 문자열로 타입변환한 뒤, Integer.parseInt로 형변환한다. -> food set으로 값을 변경한다.
				food.setPrice(Integer.parseInt(String.format("%.0f",food.getPrice() + food.getPrice()*0.1)));
				break;
			}
		}
	}
	
//	사용자가 원하는 종류의 음식 개수 조회
//	예) 불고기, 제육볶음, 파스타, 초밥
//	한식 입력 시 2개
	public static int lookupNumber(String specific)	{
		int number=0;
		for (Food food : foods) {
			if(food.getSpecific().equals(specific)) {
				number++;
			}
		}
		return number;
	}
	
	public static void main(String[] args) {
//		객체화
		Food bulgogi = new Food();
		Food tteok = new Food();
		Food lamen = new Food();
		Food sushi	= new Food();
		Food jajangmyeon = new Food();
		Food setfood = new Food();
		Food pasta = new Food();
		Food pizza = new Food();
		Food chicken = new Food();
//		값 추가
		setfood.setName("bulgogi");
		setfood.setSpecific("양식");
		
		bulgogi.setName("bulgogi");
		bulgogi.setPrice(5000);
		bulgogi.setSpecific("한식");
		addFood(bulgogi);
		
		tteok.setName("tteok");
		tteok.setPrice(3000);
		tteok.setSpecific("한식");
		addFood(tteok);
		
		lamen.setName("lamen");
		lamen.setPrice(10000);
		lamen.setSpecific("일식");
		addFood(lamen);
		
		sushi.setName("sushi");
		sushi.setPrice(10000);
		sushi.setSpecific("일식");
		addFood(sushi);
		
		jajangmyeon.setName("jajangmyeon");
		jajangmyeon.setPrice(10000);
		jajangmyeon.setSpecific("중식");
		addFood(jajangmyeon);
		
		pasta.setName("pasta");
		pasta.setPrice(10000);
		pasta.setSpecific("양식");
		addFood(pasta);
		
		pizza.setName("pizza");
		pizza.setPrice(10000);
		pizza.setSpecific("양식");
		addFood(pizza);
		
//		리스트 출력
		System.out.println(foods);		
//		음식 이름을 받고 종류를 출력하는 메서드
		System.out.println(checkSpecific("pasta"));	//양식
		System.out.println(checkSpecific("lamen"));	//일식
//		음식의 종류를 입력받아 해당하는 음식을 출력
		System.out.println(lookup("한식"));
		System.out.println(lookup("양식"));
//		음식의 종류를 입력받아 해당하는 음식의 개수를 출력
		System.out.println(lookupNumber("한식") + " 개");
		System.out.println(lookupNumber("양식") + " 개");
//		음식의 종류 수정, 음식타입으로 매개변수를 받은 뒤 종류 수정, 가격+10%
		setSpecific(setfood);
//		불고기, 5000, 한식 --> 불고기 , 5500, 양식 으로 변경
		System.out.println(bulgogi);
		
	}
	
}
