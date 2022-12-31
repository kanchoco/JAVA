package abstractTest;

public class WashingMachine extends Electronics{
//	extends -> 상속, WashingMachine 클래스는 Electronics클래스(추상)를 상속받는 자식클래스이다.
//	따라서 클래스의 필드인 추상메소드를 사용하기 위해서는 재정의를 해야한다.
	@Override
	public void on() {
		System.out.println("세탁기 전원 ON");
	}

	@Override
	public void off() {
		System.out.println("세탁기 전원 OFF");
	}

}
