package interfaceTest;

public class Stone extends PetAdapter {
//	강제성 조율이 필요한경우 조율한 추상클래스를 부모로 받아서 확장한다/
	
//	받아온 추상메소드들 재정의(구현)
	@Override
	public void sitDown() {
		System.out.println("앉는다");
	}

	@Override
	public void waitNow() {
		System.out.println("기다린다");
		
	}

}
