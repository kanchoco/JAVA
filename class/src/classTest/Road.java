package classTest;

class Car	{
//	브랜드 색깔 가격 필드를 가진 클래스
//  전역
//	값을 따로 지정하지 않아도 자동으로 초기화가 된다.
	String brand;
	String color;
	int price;
	
//	지역
//	Alt + Shift + S  ---> + O	
	public Car(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	
// ＊오버로딩(다형성) -> 이름이 같아도 구분점(매개변수 차이)이 있다면 같은 이름으로 생성할 수 있다.
	public Car(String color) {
//		this.은 생략 가능
		brand	= "자동차";
		this.color = color;
}

	void engineStart()	{
		System.out.println(brand + " 시동 켜기");
	}
	
	void engineStop()	{
		System.out.println(brand + " 시동 끄기");
	}
	
}

public class Road {
//	실행 프로그램을 만들어주는 메소드
//10,000 ","는 문자이므로 _(자바에선 읽지않음)으로 처리한다.
	public static void main(String[] args) {

		Car momCar= new Car("Benz", "Black", 10_000);
		Car dadyCar= new Car("BMW", "Blue", 8_000);
		Car myCar= new Car("Red");
		
//		Car momCar= new Car();
//		Car dadyCar= new Car();
//		Car myCar= new Car();
//		-> 기본생성자가 사라졌기 때문에 오류가남

		
	}
}
