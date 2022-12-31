package objectTest;

import java.util.Random;


class Employee{
   int number;
   String name;
   
   public Employee() {;}

   public Employee(int number, String name) {
      super();
      this.number = number;
      this.name = name;
   }
  
   @Override
   public boolean equals(Object obj) {						//재정의
	   if(this == obj) {return true;};							// 주소값이 같으면 true리턴
	   if(obj instanceof Employee)	{							// 그게 아니라면, obj가 Employee타입인지 확인한다.	(자식 -> 부모 업캐스팅 ) 자식타입인 object에 Employee타입을 입력하게 되었으므로,
//		   업캐스팅과 다운캐스팅 -> 이게 잘 안되는듯..	
		   Employee employee = (Employee)obj;				//obj가 Employee타입이라면, obj를 다운캐스팅하여 obj가 다운캐스팅하면서 잘린 부분들을 복구해준다.(Employee안에 있는 number를 사용하기 위함)
		   if(this.number == employee.number)	{				//그리고 사원번호를 비교하여 같다면,
			   return true;											//true를 리턴한다
		   }
	   } 
	   return false;													//두 경우 모두 아니라면, false를 리턴한다.
   }
}



public class EqualsTest {
   public static void main(String[] args) {
	    
      Employee han = new Employee(1, "한동석");
      System.out.println(han.equals(new Employee(1, "한동석")));
      
//      String data1 = "ABC";
//      String data2 = "ABC";
//      String data3 = new String("ABC");
//      String data4 = new String("ABC");
//      
//      System.out.println(data1 == data2);
//      System.out.println(data1.equals(data2));
//      
//      System.out.println(data3 == data4);
//      System.out.println(data3.equals(data4));
      
//      Random r1 = new Random();
//      Random r2 = new Random();
//      
//      System.out.println(r1 == r2);
//      System.out.println(r1.equals(r2));
//      
//      r1 = r2;
//      System.out.println(r1 == r2);
//      System.out.println(r1.equals(r2));
      
   		}
	}
