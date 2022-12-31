package storageClass;

public class VariableTest {
	int data = 10;
	static int data_s = 10;
	
//	전역변수
	void increaseData()	{
		System.out.println(++data);
	}
	
//	정적변수
	static void increaseData_s()	{
		System.out.println(++data_s);
	}
}
