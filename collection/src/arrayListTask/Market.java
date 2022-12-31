package arrayListTask;

import java.util.ArrayList;

public class Market {
//	과일들을 저장할  DB
//	과일 추가
	public static ArrayList<Fruit> fruits = new ArrayList<>();
//	static -- 모든 객체가 공유하는 값이기 때문에

//	이건  좋지않은 코드
	public static void addFruit(String fruit, int price)	{
		Fruit newFruit = new Fruit();
		newFruit.setFruit(fruit);
		newFruit.setPrice(price);
		fruits.add(newFruit);
	}
	
	public static void addFruit(Fruit fruit)	{
		fruits.add(fruit);
	}
	
//	과일 삭제//	이름으로 삭제
//	이름 전달, DB에서 검색
//	과일 이름 검색되면 객체 저장
//	저장 후 삭제

	public static void removeFruit(String fruit)	{		
		try {	
		for (Fruit fruitt : fruits) {						//빠른 for문 for(Fruit fruit : fruits)-> 이러면 객체 저장을 따로 안해도된다.
			if(fruitt.getFruit().equals(fruit))	{			//-> 빠른 for문은 주체(반복자 자리에 있는 객체)에 대한 사이즈만큼 반복하는데, 사이즈의 크기 변동이 생기면(기준점 수정) 예외가 일어난다. -> try문으로 묶음
				fruits.remove(fruitt);						//값으로 삭제	
//				fruits.remove(i) -> index로 삭제
				}
			}
		} catch(Exception e) {;}
	}
	
//	public static void removeFruit(String fruit)	{		
//		for (Fruit fruitt : fruits) {						//빠른 for문 for(Fruit fruit : fruits)-> 이러면 객체 저장을 따로 안해도된다.
//			if(fruitt.getFruit().equals(fruit))	{			//-> 빠른 for문은 주체(반복자 자리에 있는 객체)에 대한 사이즈만큼 반복하는데, 사이즈의 크기 변동이 생기면(기준점 수정) 예외가 일어난다. 따라서, break로 직접 탈출시켜줘야 한다.
//				fruits.remove(fruitt);						//값으로 삭제	
////				fruits.remove(i) -> index로 삭제
//			break;
//			}
//		}
//	}
	
//	public static void removeFruit(String fruit)	{		
//		Fruit refruit = null;
//		for (int i = 0; i < fruits.size(); i++) {
//			if(fruits.get(i).getFruit().equals(fruit))	{	
//				refruit = fruits.get(i);					
//				fruits.remove(refruit);						
//				break;
//			}
//		}
//	}
	
//	과일의 가격이 평균 가격보다 낮은 지 검사
	
	public static double average()	{	//전체평균구하기, 이건 강사님이랑 코드 같았음.
		double average = 0.0;
		int total = 0;
		
		for (Fruit fruit  : fruits) {
			total += fruit.getPrice();
		}
		average = total/(double)fruits.size();
	
		return Double.parseDouble(String.format("%.2f", average));
	}
	
	
	public static boolean check(int price)	{//과일 받아서 체크, 낮으면 트루
		return price < average();			//논리연산을해서 리턴하므로, if문을 사용할 필요가 없다 !
	}
	
	
//	이건 실습때 내 코드
//	public static boolean check(int price)	{//과일 받아서 체크, 낮으면 트루
//		if(price < average())	{	--> 이거 자체로 논리연산, if로 리턴값을 직접 나눌 필요가 없음.
//			return true;
//		}
//		return false;
//	}
	
	
	
	public static void main(String[] args) {
		Fruit apple  = new Fruit();
		Fruit pineApple  = new Fruit();
		apple.setFruit("Apple");
		apple.setPrice(1000);
		addFruit(apple);
		
		pineApple.setFruit("pineApple");
		pineApple.setPrice(500);
		addFruit(pineApple);
		
		System.out.println(average());
		System.out.println(check(pineApple.getPrice()));	//true
		System.out.println(check(apple.getPrice()));		//false
		
	}
	
	
	
}
