package crawling;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dao.TotalDAO;
import vo.JoonggoVO;
import vo.TotalDTO;

public class JoonggoCrawling {
	private WebDriver webDriver;
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";

	
	public void crawling(String search) {
		//	운영체제에 드라이버 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		JoonggoCrawling joonggoCrawling = new JoonggoCrawling();
		WebDriver driver = joonggoCrawling.webDriver;
		
		String url = "https://web.joongna.com/search?keyword=";
		String searchUrl = null, lastChild = null;
		int j = 0;
		
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

//		이름
		for (WebElement webElement : driver.findElements(By.cssSelector("div.titleTxt span.css-5uwdmz"))) {
			names.add(webElement.getText());
		}
		
//		가격
		for (WebElement webElement : driver.findElements(By.cssSelector("div.css-17j97b9 div.priceTxt"))) {
			costs.add(webElement.getText());
		}
		
//		올라온 날짜
		for (WebElement webElement : driver.findElements(By.cssSelector("div.registInfo span:last-child"))) {
			dates.add(webElement.getText());
		}
		
//		동네
		for (WebElement webElement : driver.findElements(By.cssSelector("div.registInfo span:first-child"))) {
			lastChild =  driver.findElements(By.cssSelector("div.registInfo span:last-child")).get(j).getText();
			
			if(webElement.getText().equals(lastChild)) {
				sites.add("지역 정보 없음");
			} else {
				sites.add(webElement.getText());
			}
			j++;
		}
		
//		url
		for (WebElement webElement : driver.findElements(By.cssSelector("a.css-8rmnao"))) {
			String href = webElement.getAttribute("href");
			hrefs.add(href);
		}


		for (int i = 0; i < names.size(); i++) {
			TotalDAO totalDAO = new TotalDAO();
			JoonggoVO joonggoVO = new JoonggoVO();
			TotalDTO totalDTO = new TotalDTO();
			
			joonggoVO.setName(names.get(i));
			joonggoVO.setPrice(costs.get(i));
			joonggoVO.setDate(dates.get(i));
			joonggoVO.setAddress(sites.get(i));
			joonggoVO.setUrl(hrefs.get(i));
			totalDAO.joonggoResult(joonggoVO);

			totalDTO.setCompanyName("중고나라");
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
