package abstractTest;

public abstract class Electronics {
	//	public void on(); -> 일반 메소드로 인식한다
//      추상 메소드 선언을 위해서는 !abstract!를 꼭 붙여줘야한다.
	public abstract void on();			
//	구현이 안된 추상메소드
	public abstract void off();
}

//	추상 클래스
//	추상 메소드(구현이 되지 않은 메소드)를 사용하기 위해서

//	추상 메소드는 왜 쓰는가?
//	추상 메소드는 구현이 되지 않은 메소드로, 꼭 재정의를 통해 구현해야지 메모리에 할당된다.
//	즉 재정의를 꼭 해야만하는 "강제성"을 부여하기 위해서 추상 메소드를 사용한다.
