package methodTest;

public class MethodTest {
//		두 정수의 곱셈 메소드 선언	
	int multiple(int num1, int num2)	{
		int result = num1 * num2;
		return result;
	}	
	
	public static void main(String[] args) {
//		static ->컴파일러가 가장 먼저 메모리에 할당됨
//		일반 메소드를 static 메소드에서 사용하기 위해서는
//		1. static을 붙여서 같이 메모리에 올려준다.
//		2. 일반 메소드의 소속을 알려준다.
//			- static 메소드에서 사용된 일반 메소드는 Heap 영역에서 찾는다.
//			- 클래스 타입의 변수를선언할 때 Heap 영역에 할당되므로,
//			  일반 메소드도 해당 변수를 통해 접근하여 사용할 수 있다.
		MethodTest mt = new MethodTest();		//MethodTest를 동적메모리에 할당함, mt라는 변수로 사용
		int result = mt.multiple(3,7);									// .을 써서 mt안의 메소드를 사용
		System.out.println(result);
	}
}
