package access1;

public class Access1 {
	int data1	= 10;
	public int data2 = 20;
	protected int data3 = 30;
	private int data4 = 40;
	
//	Alt + Shift + R
//	게터 세터 메소드
//	프라이베이트 변수를 접근하기 위해 생성함
//	jsp에선 초기화생성자 생성이 불가능함, 따라서 생성할때 무조건 !!기본생성자!!를 만든다.
	public int getData4() {
		return data4;
	}
	public void setData4(int data4) {
		this.data4 = data4;
	}
	
}
