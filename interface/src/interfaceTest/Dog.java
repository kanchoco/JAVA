package interfaceTest;

public class Dog implements Pet{

//	지정받은 Pet인터페이스의 추상메소드를 사용하기위해 재정의한다.
	@Override
	public void bang() {
		System.out.println("드러눕는다");
	}
//	재정의된(구현된) 추상메소드들은 메모리에 할당된다.

	@Override
	public void giveYourHand() {
		System.out.println("손을 준다.");
	}

	@Override
	public void bite() {
		System.out.println("문다.");		
	}

	@Override
	public void sitDown() {
		System.out.println("앉는다");		
	}

	@Override
	public void waitNow() {
		System.out.println("기다린다.");		
	}

	@Override
	public void getNose() {
		System.out.println("코를 손가락에 쑤셔 넣는다.");		
	}
	
}
