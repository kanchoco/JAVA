package ambiguityTest;

public class ClassC implements InterA, InterB {
//	어떤 부모인지 모를때는 직접 재정의해서 사용해야 한다.
// ->>super, Override사용
	@Override
	public void printData() {
//		InterA와 InterB모두 printData()메소드가 있으므로, 직접 지정해준다.(InterA.super.printData() - InterA의 printData())
		InterA.super.printData();
	}
}

//	implements -> 인터페이스 지정
//	다중의 인터페이스를 지정받았고, 두 인터페이스에 중복되는 메소드가 있다.
//	-> 이럴경우 직접 재정의해서 사용하면 된다.