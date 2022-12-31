package inheritanceTest;

//	상속
// 기존에 선언된 클래스의 필드를 새롭게 만들 클래스의 필드로 사용하고자 할 때 자식클래스에 상속시켜 필드를 사용할 수 있다.
//	여러 클래스 선언 시 필드가 겹치는 경우, 부모 클래스를 먼저 선언하고 공통 필드를 묶어서 자식 클래스에게 상속해준다.
//
//※다중상속도 가능(모호성 때문에 자바는 다중상속을 지원하지 않는다. 인터페이스를 사용하여 다중상속할 수 있다. -> 부모클래스는 자식클래스 당 하나다.)
class Human	{
//	Human클래스의 필드 
	void eat()	{
		System.out.println("먹이");
	}
	void sleep()	{
		System.out.println("잠자기");
	}

	void walk()	{
		System.out.println("두 발로 걷기");
	}
}

class Monkey	extends Human{
//	Human클래스를 상속받는 자식클래스 Monkey
	void 이잡아라()	{
		System.out.println("이잡기");
	}

//	다형성 2번, Overriding(재정의)	
//	부모클래스의 필드를 그대로 사용할 수도 있고, 재정의하여 새롭게 사용할 수도 있다.
	@Override
//	@~ : 어노테이션
	void walk()	{
//		부모의 코드를 그대로 사용하고자 할 때, super()로 가져온다.
		super.walk();			
//		필드를 가져와 내용을 추가함.
		System.out.println("두 발 또는 네 발로 걷기");	
	}
	
	
}


public class InheritanceTest2 {
	public static void main(String[] args) {
//		main메소드  실행부
//		Money클래스의 필드를 kingkong이라는 객체로 객체화한다.
		Monkey kingkong = new Monkey();
//		객체를 사용하여 Monkey클래스의 필드에 접근, walk()메소드를 사용한다.
//		재정의한 내용에 따라서, 두 발로 걷기와 두 발 또는 네 발로 걷기가 출력된다.
		kingkong.walk();
	}
}
