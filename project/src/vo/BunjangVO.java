package vo;

public class BunjangVO {
	private int bunjangNumber;
	private String bunjangItem;
	private String bunjangPrice;
	private String bunjangURL;
	
	public BunjangVO() {;}
	
	
	
	public int getBunjangNumber() {
		return bunjangNumber;
	}



	public void setBunjangNumber(int bunjangNumber) {
		this.bunjangNumber = bunjangNumber;
	}



	public String getBunjangItem() {
		return bunjangItem;
	}



	public void setBunjangItem(String bunjangItem) {
		this.bunjangItem = bunjangItem;
	}



	public String getBunjangPrice() {
		return bunjangPrice;
	}



	public void setBunjangPrice(String bunjangPrice) {
		this.bunjangPrice = bunjangPrice;
	}



	public String getBunjangURL() {
		return bunjangURL;
	}



	public void setBunjangURL(String bunjangURL) {
		this.bunjangURL = bunjangURL;
	}



	@Override
	public String toString() {
		String str = bunjangNumber + "\n" + bunjangItem +"\n" + bunjangPrice +"\n" + bunjangURL;
		return str;
	}
}
