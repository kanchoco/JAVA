package vo;

public class TotalDTO {
	private String companyName;
	private int number;
	private String name;
	private Object price;
	private String address;
	private String date;
	private String url;
	
	public TotalDTO() {;}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

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
	
	public Object getPrice() {
		return price;
	}

	public void setPrice(Object price) {
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
			String str =  companyName + ", " + number + ", " + name + ", " + price + ", " + address + ", " + date + ", " + url;
			return str;
	}
}
