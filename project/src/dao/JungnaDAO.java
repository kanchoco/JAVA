package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JungnaDAO {

	private WebDriver webDriver;
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	
	public ArrayList<String> items;
	public ArrayList<String> hrefs;
	public ArrayList<String> prices;
	
	public void crawling(String key) {
		JungnaDAO market = new JungnaDAO();
		WebDriver driver = market.webDriver;
		String url = "https://web.joongna.com/search?keyword="+key;
		String item = null, price = null, href = null;
		String result = null;
		int resultNum,count;
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		
		driver.get(url);
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
//		result = driver.findElement(By.className("css-8yt95i")).getText();
//		resultNum = Integer.valueOf(result.substring(result.indexOf("(")+1, result.length()-1));
//		count = ((resultNum < 100)? resultNum : 100 );
		
		String query = "INSERT INTO TBL_JUNGNA(JUNGNA_NUMBER,JUNGNA_ITEM, JUNGNA_PRICE, JUNGNA_URL) VALUES(SEQ_JUNGNA.NEXTVAL,?,?,?)";
		try {
				connection = DBConnecter.getConnection();
				for(int i = 0; i <  100; i++) {
					if(i == 80) {
						driver.findElement(By.cssSelector("div.css-1bifidt a")).click();
						try {Thread.sleep(1000);} catch (InterruptedException e) {;}
					}
					int j = 0;
					
					item = driver.findElements(By.className("css-5uwdmz")).get(i).getText(); 
					price =  driver.findElements(By.className("priceTxt")).get(i).getText();
					href =  driver.findElements(By.className("css-8rmnao")).get(i).getAttribute("href");
				
			
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(++j, item);
					preparedStatement.setString(++j, price);
					preparedStatement.setString(++j, href);
					preparedStatement.executeUpdate();
					System.out.println(i + "번째 작업완료");
					
					 
					}
				} catch(IndexOutOfBoundsException e){
					driver.close();
					driver.quit();			
				}catch (SQLException e) {
					e.printStackTrace();
					System.out.println("insertItem()에서 쿼리문 오류");
				}finally {
					try {
						if (preparedStatement != null) {
							preparedStatement.close();
						}
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}
				}
	
		}
	
	public void inserItem()	{
		String query = "INSERT INTO TBL_JUNGNA(JUNGNA_NUMBER,JUNGNA_ITEM, JUNGNA_PRICE, JUNGNA_URL) VALUES(SEQ_JUNGNA.NEXTVAL,?,?,?)";
		try {
			connection = DBConnecter.getConnection();
			for (int i = 0; i < 100; i++) {
				int j = 0;
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(++j, items.get(i));
				preparedStatement.setString(++j, prices.get(i));
				preparedStatement.setString(++j, hrefs.get(i));
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insertItem()에서 쿼리문 오류");
		}finally {
	         try {
	             if (preparedStatement != null) {
	                preparedStatement.close();
	             }
	             if (connection != null) {
	                connection.close();
	             }
	          } catch (SQLException e) {
	             throw new RuntimeException(e.getMessage());
	          }
	       }
	}
	
	

}
