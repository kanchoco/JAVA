package abstractTest;

public class Regrigerator extends Electronics{
//	extends -> 상속 , Regrigerator는 Electronics(추상클래스)를 상속받는 자식 클래스이다.
//	추상 클래스의 추상메소드는 사용을 위해선 "재정의"를 필수로 요하므로, @Override한다.
	@Override
	public void on() {
		System.out.println("냉장고 전원 ON");
	}

	@Override
	public void off() {
		System.out.println("냉장고 전원 OFF");
	}

}
