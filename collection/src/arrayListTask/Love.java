package arrayListTask;

public class Love {
	//이름, 나이
//	private 
//	기본생성자
//	toString
	
	private String name;
	private int age;
	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Love()	{;}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + "," + age; 
	}
	
	public static void main(String[] args) {
		Love person = new Love();
		person.setAge(10);
		person.setName("ddx");
		
		System.out.println(person);
	}
	
}
