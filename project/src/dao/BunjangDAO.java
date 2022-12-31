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

public class BunjangDAO {
	private WebDriver webDriver;
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	
//	검색어 받아와서 크롤링
	public void crawling(String key) {
		BunjangDAO market = new BunjangDAO();
		WebDriver driver = market.webDriver;
//		검색어입력 결과 주소
		String url = "https://m.bunjang.co.kr/search/products?q="+key;
		String item = null, price = null, href = null;
				
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		
		driver.get(url);
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		String query = "INSERT INTO TBL_BUNJANG(BUNJANG_NUMBER,BUNJANG_ITEM, BUNJANG_PRICE, BUNJANG_URL) VALUES(SEQ_BUNJANG.NEXTVAL,?,?,?)";
		try {
//			DB커넥션 할당
			connection = DBConnecter.getConnection();
			for(int i = 0; i < 100; i++) {
				int j = 0;
//				텍스트 받아오자마자 데이터베이스로 전송하는게 효율이 가장좋음
//				String으로 받아서 변수에 담음
					item = driver.findElements(By.className("sc-iBEsjs")).get(i).getText();
					price = driver.findElements(By.className("sc-hzNEM")).get(i).getText();
					href = driver.findElements(By.className("sc-jKVCRD")).get(i).getAttribute("href");
//					데이터베이스에 쿼리문 전송
						preparedStatement = connection.prepareStatement(query);
//						쿼리 패러미터에 값전달
						preparedStatement.setString(++j, item);
						preparedStatement.setString(++j, price);
						preparedStatement.setString(++j, href);
//						쿼리문 실행
						preparedStatement.executeUpdate();
//						확인출력
				System.out.println(i + "번째 작업완료");
			}
			
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
			
			
	
	
}
