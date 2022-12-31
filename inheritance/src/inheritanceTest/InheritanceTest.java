package inheritanceTest;

class A {
	String name = "A";
	int data = 10;

	void printName() {
		System.out.println(name);
//		this가 생략됨, 가장 가까운 name을 찾음
	}
	
}

class B extends A {			//상속
//A필드의 값을 가지고 있음
//	호출 시 메모리에는 부모필드가 먼저 할당 되고 이후에 자식필드가 할당된다.
	public B() {
//		super(); - !부모생성자!  | 컴파일시 자동생성(생략가능)
//				      부모에서 여러 필드를 가져올 때 사용
//					  - super(부모 필드 1, 부모 필드 2)
		
		name = "B";
//		super(); 				부모생성자이므로, super()가 B필드 밑에서는 에러가 남,(부모가 먼저 할당되어야 하므로)
	}
	
	void printData() {
		System.out.println(data);
	}
	
}


public class InheritanceTest {
	public static void main(String[] args) {
		B b = new B();
		b.printName();
		b.printData();
		
	}
}
