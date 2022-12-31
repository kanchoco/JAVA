package classTest;

class A{
	int data;
	
	A(int data)	{
		this.data = data;	
//		this = 접근하고 있는 객체가 가지고 있는 주소값을 가져옴
	}
	void printData() {
		System.out.println(data);
	}
}


public class ClassTest {
// 	`	클래스 안에 클래스 선언도 가능하다		
	public static void main(String[] args) {
		A a = new A(10);		// -> 객체 생성
		
	}
}
