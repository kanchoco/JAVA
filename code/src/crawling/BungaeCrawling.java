package crawling;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dao.TotalDAO;
import vo.BungaeVO;
import vo.TotalDTO;

public class BungaeCrawling {
	private WebDriver webDriver;
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	
	public void crawling(String search) {
		//	운영체제에 드라이버 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		BungaeCrawling bungaeCrawling = new BungaeCrawling();
		WebDriver driver = bungaeCrawling.webDriver;
		
		String url = "https://m.bunjang.co.kr/search/products?q=";
		String searchUrl = null, date = null;
		
		searchUrl = url + search;
		
//		운영체제에 드라이버 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
//		WebDriver객체에 크롬 드라이버 대입
		driver = new ChromeDriver();
		
		
//		원하는 경로를 브라우저에 전달
		driver.get(searchUrl);
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
//		가져올 항목들을 담을 ArrayList 만들기
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> costs = new ArrayList<String>();
		ArrayList<String> dates = new ArrayList<String>();
		ArrayList<String> sites = new ArrayList<String>();
		ArrayList<String> hrefs = new ArrayList<String>();

//		이름
		for (WebElement webElement : driver.findElements(By.cssSelector("div.sc-fcdeBU"))) {
			names.add(webElement.getText());
		}
		
//		가격
		for (WebElement webElement : driver.findElements(By.cssSelector("div.sc-gmeYpB"))) {
			costs.add(webElement.getText());
		}
		
		
//		동네
		for (WebElement webElement : driver.findElements(By.cssSelector("div.sc-kZmsYB"))) {
			sites.add(webElement.getText());
		}
		
//		올라온 날짜
		for (WebElement webElement : driver.findElements(By.cssSelector("div.sc-iSDuPN"))) {
			if(webElement.getText().startsWith("AD")) {
				dates.add("광고");
			}
			else {
				dates.add(webElement.getText());				
			}
		}


//		url
		for (WebElement webElement : driver.findElements(By.cssSelector("a.sc-chbbiW"))) {
			String href = webElement.getAttribute("href");
			hrefs.add(href);
		}
		
		for (int i = 0; i < names.size(); i++) {
			TotalDAO totalDAO = new TotalDAO();
			BungaeVO bungaeVO = new BungaeVO();
			TotalDTO totalDTO = new TotalDTO();

			bungaeVO.setName(names.get(i));
			bungaeVO.setPrice(costs.get(i));
			bungaeVO.setDate(dates.get(i));
			bungaeVO.setAddress(sites.get(i));
			bungaeVO.setUrl(hrefs.get(i));
			totalDAO.bungaeResult(bungaeVO);
			
			totalDTO.setCompanyName("번개장터");
			totalDTO.setName(names.get(i));
			totalDTO.setPrice(costs.get(i));
			totalDTO.setDate(dates.get(i));
			totalDTO.setAddress(sites.get(i));
			totalDTO.setUrl(hrefs.get(i));
			totalDAO.totalResult(totalDTO);
		}

		
		driver.quit();
	}
}
