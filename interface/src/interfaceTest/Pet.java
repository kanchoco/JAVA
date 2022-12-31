package interfaceTest;

public interface Pet {
	//틀만 짜놓는것
	final static int eyes = 2;			//변수가 아니라 상수이다 -> 인터페이스에선 상수만 가능하므로 final을 생략해준다.
												//또한, 구현이 되지 않아 메모리에 할당이 안되므로, static을 붙여야한다.(생략)
	int nose = 1;
	
	public void bang();					//또한, 추상메소드만 가능하므로, abstract또한 생략해준다.
	public void giveYourHand();
	public void bite();
	public void sitDown();
	public void waitNow();
	public void getNose();
	
}

//인터페이스란?
//추상클래스를 """고도화"""시킨 문법이다. ----> 강제성을 ""심화""시킨 문법이다.
//인터페이스 안에서는 "상수"와 "추상메소드"만 존재한다.				--> abstract와 final을 생략할 수 있는 이유

//틀을 제공한다
//-> 말 그대로 틀만을 제공하며, 구현은 인터페이스를 지정한(implements) 클래스에서 한다.
