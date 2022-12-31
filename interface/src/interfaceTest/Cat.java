package interfaceTest;

public class Cat extends PetAdapter {
//	강제성 조정을 위한 PetAdapter 추상클래스를 부모로 상속받는다.
	
//	받아온 추상메소드 선택적으로 재정의(구현)
	@Override
	public void bang() {
		System.out.println("안한다");
	}

	@Override
	public void giveYourHand() {
		System.out.println("문다.");
	}

	@Override
	public void bite() {
		System.out.println("지나간다.");
	}
	
	@Override
	public void waitNow() {
		System.out.println("안기다린다.");
	}

	@Override
	public void getNose() {
		System.out.println("나를 안본다.");
	}

}
