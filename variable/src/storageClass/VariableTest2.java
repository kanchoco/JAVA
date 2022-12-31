package storageClass;

public class VariableTest2 {
	public static void main(String[] args) {
		
		VariableTest vt = new VariableTest();
//		정적변수는 모든 개체가 같은 값을 써야할 때 쓴다.
		VariableTest vt2 = new VariableTest();
		
		vt.data_s = 500;
		
		System.out.println(VariableTest.data_s);
		
//		System.out.println(vt2.data_s);
//==> 정적변수는 하나이기 때문에 다른 주소로 선언해도 값이 공유한다.		
//		따라서 변수의 소속만 알려준다. 
		
		
		
		
//		vt.increaseData_s();
//		vt.increaseData_s();
//		vt.increaseData_s();
//		vt.increaseData_s();
//		정적변수는 new를 만나도 새롭게 초기화가 되지 않는다.
//		static 정적 변수는 컴파일러가 가장 먼저 메모리에 할당하기 때문에 생성자 호출로 초기화가 되지 않는다.
//		-> 무조건 하나만 호출됨
//		vt = new VariableTest();
//		vt.increaseData_s();
//		vt.increaseData_s();
//		vt.increaseData_s();
//		vt.increaseData_s();
//		vt.increaseData_s();
//		vt.increaseData_s();
//		
		
//		vt.increaseData();
//		vt.increaseData();
//		vt.increaseData();
//		vt.increaseData();
//		vt = new VariableTest();
////		전역변수는 new로 메모리에 할당되기 때문에, new를 만들면 새로이 초기화가 된다.
//		vt.increaseData();
//		vt.increaseData();
//		vt.increaseData();

	}
}
