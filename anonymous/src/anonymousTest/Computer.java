package anonymousTest;

public class Computer {
	public static void main(String[] args) {
		Game game = new Game() 	{	//익명 클래스

			@Override
			public void play() {
			}

			@Override
			public void exit() {
			}	
		};
		
	}
}
//	익명 클래스(Anonymous Inner Class)
//	-> 구현을 위한 클래스로, 이름이 없는 클래스이다.
//	--> 내부 클래스의 일종으로  extends를 사용하지 않고, 영역안에서 선언되는 클래스이다.
//	구현을 위해 일회성으로 생성되는 클래스이므로 이름을 요구하지 않는다.

//	내부 클래스(Inner Class)
//	extends를 사용할 필요가 없어진다.
//	어떤 영역안에서 생성된 클래스를 말한다.(메소드 안에서도 클래스 생성 가능)
//	구현이 되어야 메모리에 할당, 객체화할 수 있는 점을 이용하여 클래스를 숨겨야할 때 사용하기도 한다.(캡슐화, 은닉화 - 다른곳에서 접근 불가)
//	사용하는 이유는?
//	한 클래스 내에서 a와 b작업이 있을 때 따로 분리하여 만들지 않고(번거로워지기 때문) 내부에서 클래스를 만든다.