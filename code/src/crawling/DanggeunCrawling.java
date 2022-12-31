package crawling;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dao.TotalDAO;
import vo.DanggeunVO;
import vo.TotalDTO;

public class DanggeunCrawling {
	private WebDriver webDriver;
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	
	public void crawling(String search) {
		//	운영체제에 드라이버 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		DanggeunCrawling danggeunCrawling = new DanggeunCrawling();
		WebDriver driver = danggeunCrawling.webDriver;
		
		String url = "https://www.daangn.com/search/";
		String searchUrl = null, date = null;
		
//		가져올 항목들을 담을 ArrayList 만들기
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> costs = new ArrayList<String>();
		ArrayList<String> dates = new ArrayList<String>();
		ArrayList<String> sites = new ArrayList<String>();
		ArrayList<String> hrefs = new ArrayList<String>();

//		WebDriver객체에 크롬 드라이버 대입
		driver = new ChromeDriver();
		
//		원하는 경로를 브라우저에 전달
		searchUrl = url + search;
		driver.get(searchUrl);
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
//      더보기 클릭
      for (int i = 0; i < 1; i++) {
         driver.findElement(By.className("more-btn")).click();
         try {Thread.sleep(1000);} catch (InterruptedException e) {;}
      }

		
//    이름
    for (WebElement webElement : driver.findElements(By.cssSelector("div.article-title-content span.article-title"))) {
       names.add(webElement.getText());
    }
    
//    가격
    for (WebElement webElement : driver.findElements(By.cssSelector("p.article-price"))) {
       costs.add(webElement.getText());
    }
    
//    동네
    for (WebElement webElement : driver.findElements(By.cssSelector("p.article-region-name"))) {
       sites.add(webElement.getText());
    }
    
//    url
    for (WebElement webElement : driver.findElements(By.cssSelector("a.flea-market-article-link"))) {
       String href = webElement.getAttribute("href");
       hrefs.add(href);
    }

//    올라온 날짜
    for (String href : hrefs) {
       driver.get(href);
       date = driver.findElement(By.cssSelector("p time")).getText();
       dates.add(date);
    }

		
		for (int i = 0; i < names.size(); i++) {
			TotalDAO totalDAO = new TotalDAO();
			DanggeunVO danggeunVO = new DanggeunVO();
			TotalDTO totalDTO = new TotalDTO();
			
			danggeunVO.setName(names.get(i));
			danggeunVO.setPrice(costs.get(i));
			danggeunVO.setDate(dates.get(i));
			danggeunVO.setAddress(sites.get(i));
			danggeunVO.setUrl(hrefs.get(i));
			totalDAO.danggeunResult(danggeunVO);
			
			totalDTO.setCompanyName("당근마켓");
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
