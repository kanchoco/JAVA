package wrapperTest;

public class WrapperTest {
	public static void main(String[] args) {
		int data_i = 10;
		
//		박싱
//		Integer data_I =new Integer(data_i);
//		줄  -> 디프리케이티드 : 권장하지 않음
//		Integer data_I = Integer.valueOf(data_i);
//		를 더 권장한다.
		
//		unboxing
//		data_i = data_I.intValue();
//		일반타입 변수 = 객체.000Value(); //unboxing
		
//		-> 4이상부터은 auto 박싱이 가능하다.

		
//		자동
//		클래스타입 객체 = 일반타입의 값; //auto boxing
		Integer data_I = data_i;
//		일반타입 변수 = 객체; //auto unboxing
		data_i = data_I;
		
		
	}
}
