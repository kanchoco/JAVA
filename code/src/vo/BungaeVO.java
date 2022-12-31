package vo;

public class BungaeVO {
	
	private int number;
	private String name;
	private String price;
	private String address;
	private String date;
	private String url;
	
	public BungaeVO() {;}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
		public String toString() {
			String str =  number + ", " + name + ", " + price + ", " + address + ", " + date + ", " + url;
			return str;
	}
}
