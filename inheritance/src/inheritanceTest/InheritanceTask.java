package inheritanceTest;

class Car{
//	브랜드, 색상, 가격
	
	String brand;
	String color;
	int price;
//	전역변수, 초기값 없음
//	데이터영역에서는 초기화를 자동으로 해줌
	
	
	
public Car() {		//기본생성자를 없애면 자식클래스에서 오류가 생긴다!!
		super();
	}
//	자식 클래스를 쓸때는 초기화 시에 반드시 기본생성자를 만든다.
public Car(String brand, String color, int price) {		//초기화 생성자
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

//	열쇠로 시동 킴
	void engineOn()	{
		System.out.println("열쇠로 시동 킴");
	}
	
//	열쇠로 시동 끔
	void engineOff()	{
		System.out.println("열쇠로 시동 끔");
	}
	
	
}

class SuperCar extends Car{
//	모드
	
	
	
	String mode;
	
//	자식 기본 생ㅇ성자는 부모의 기본 생성자를 호출한다.
//	부모에 기본 생성자가 없으면 자식의 기본 생성자는 오류가 발생한다.
public SuperCar() {;}


public SuperCar(String brand, String color, int price, String mode) {		//초기화 생성자
//		부모의 생성자 중 3개의 값을 전달받는 생성자 호출
	super(brand, color, price);
	this.mode = mode;
}


//	음성으로 시동 킴
	@Override
	void engineOn()	{
		System.out.println("음성으로 시동 킴");
	}
	
//	음성으로 시동 끔
	void engineOff()	{
		super.engineOff();
		System.out.println("음성으로 시동 끔");
	}
	
//	지붕 열기
	void roofOpen() {
		System.out.println("지붕 열기");
	}
	
//	지붕 닫기
	void roofClose() {
		System.out.println("지붕 닫기");
	}

}


public class InheritanceTask {
	public static void main(String[] args) {
		SuperCar rollsroyce = new SuperCar("롤스로이스", "하얀색과 검정색", 70000, "스포츠");
		
	}
}
