package wrapperTest;

public class WrapperTask {
	public static void main(String[] args) {
		//1, 12.5, 86.6F, 'Z', "Hi", false
//		위 6개의 값을 6칸 배열에 담기
		int data1 = 1;		
		float data2 = 86.6F;
		double data3 = 12.5;
		char data4 = 'Z';
		String data5 = "Hi";
		boolean data6 = false;
		String data[] = null;
		
//		하나로 묶을때는 항상
//		모든타입의 부모 클래스로 박싱한다.
//		안될경우? 마커인터페이스를 생각한다.
		
		Object dataA = data1;
		Object dataB = data2;
		Object dataC = data3;
		Object dataD = data4;
		Object dataE = data5;
		Object dataF = data6;
		
//	효율적으로 쓰려고 노력하기
		
		Object dataArr[] = {dataA, dataB, dataC, dataD, dataE, dataF}; 
		
	}
}
