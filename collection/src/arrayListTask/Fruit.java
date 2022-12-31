package arrayListTask;

import java.util.ArrayList;

public class Fruit {
//	과일이름, 과일 가격
//	private
//	기본 생성자
//	to String()
	
	
	private String fruit;
	private int price;

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Fruit()	{;}
	
	@Override
		public String toString() {
		String str =  fruit + "은 " + price + "원";
		return str;
			
	}
}
