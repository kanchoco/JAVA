package arrayListTask;

public class Food {
//	이름, 가격, 종류(한식, 중식, 양식, 일식)
//	private
//	기본생성자
//	toString
	
	private String name;
	private int price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSpecific() {
		return specific;
	}

	public void setSpecific(String specific) {
		this.specific = specific;
	}

	private String specific;
	
	public Food()	{;}
	
	@Override
		public String toString() {
		return name + "," + price + "," + specific;
		}
}
