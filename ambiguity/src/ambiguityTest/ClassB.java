package ambiguityTest;

public class ClassB extends ClassA implements InterA{			
//	에러가 나지 않는 이유
//	부모클래스가 우선순위가 더 높기 때문에 컴파일러는 모호성을 가지지 않고 부모클래스를 읽는다.

	@Override
	public void printData() {
	//그냥 쓰면 바로 부모클래스 메소드를 가져옴으로 인터페이스를 가져오려면 인터페이스.super()를 사용한다.	
		InterA.super.printData();							
	}
}

// 상속받은 부모클래스와 인터페이스 모두 같은 이름의 메소드를 가지고있을때
//	어떤 클래스의 메소드인지 지정하지 않아도 에러가 나지 않는다.
//	이유는 부모클래스가 인터페이스보다 우선순위가 더 높기때문에, 직접 지정해주지 않아도 컴파일러카 부모클래스에서 먼저 찾아오기 때문이다.
//	이러한 이유로, 인터페이스의 있는 동명의 메소드를 사용해야하는 경우, interface.super()를 사용한다.
