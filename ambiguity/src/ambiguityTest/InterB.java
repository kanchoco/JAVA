package ambiguityTest;

public interface InterB {
	default void printData()	{		
//		인터페이스에선 추상메소드 abstract가 생략되어 있다, default메소드 생성을 위해 직접 사용해줘야한다.
		System.out.println("InterA");
	}
}
