package teamProject;

import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 중고나라
 * 당근마켓
 * 번개장터
 * 데이터 검색하여 가져오는 크롤링
 * 
 * 당근마켓은 카테고리가 없음. 검색하는거까지해서 데이터 추출해야함?
 * 
 * 사용자에게 질문받고 각각따로 출력해서 보여줌*/
	
	/*
	 * 카테고리
	 *1.  육아*/
	
public class SecondHandMarket {
	private WebDriver webDriver;
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	
	
	public static void main(String[] args) {
		SecondHandMarket market = new SecondHandMarket();
		WebDriver driver = market.webDriver;
		String menu = "사이트 1. 중고나라\n 2. 당근마켓\n 3. 번개장터\n";
		int choice = 0;
		String countText = null;
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
//		중고나라
		String junggoNara = "https://cafe.naver.com/joonggonara.cafe?iframe_url=/ArticleList.nhn%3Fsearch.clubid=10050146%26search.boardtype=L%26viewType=pc";
//		당근마켓
		String daangn = "https://www.daangn.com";
//		번개장터
		String bunjang="https://m.bunjang.co.kr";
		
		ArrayList<String> item = new ArrayList<>();
		ArrayList<String> category = new ArrayList<>();
		ArrayList<String> price = new ArrayList<>();
		ArrayList<String> hrefs = new ArrayList<>();
		WebElement input =null;
		
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		
		System.out.println(menu);
		choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			String url = "https://web.joongna.com/search?keyword="+"포토카드";
			driver.get(url);
			
			String regist = driver.findElement(By.cssSelector("div.registInfo span:first-child")).getText();
			
			System.out.println(regist);
			
			break;
		case 2:
			driver.get(daangn);
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			
			input = driver.findElement(By.className("_1knjz49b"));
			input.sendKeys("육아");
			input.sendKeys("\n");
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			
			for (int i = 0; i < 5; i++) {
				driver.findElement(By.className("more-btn")).click();
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			}
			
			
			for (WebElement webElement : driver.findElements(By.className("flea-market-article-link"))) {
				hrefs.add(webElement.getAttribute("href"));
			}
			
			for (String href : hrefs) {
				
				driver.get(href);
				
				for (WebElement webElement : driver.findElements(By.id("article-title"))) {
					item.add(webElement.getText());
				}
				
				for (WebElement webElement : driver.findElements(By.id("article-price"))) {
					price.add(webElement.getText());
				}
				
				for (WebElement webElement : driver.findElements(By.id("article-category"))) {
					category.add(webElement.getText());
				}
				
			}
			
			for (int i = 0; i < item.size(); i++) {
				System.out.println(++num + ". "+ item.get(i) +"\t카테고리 : " + category.get(i) + "\t가격 : " + price.get(i));
			}
			
			
			
			break;
		case 3:
//			번개장터
			driver.get(bunjang);
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			
			for (WebElement webElement : driver.findElements(By.className("sc-jKVCRD"))) {
				hrefs.add(webElement.getAttribute("href"));
			}
			
			for (String href : hrefs) {
				driver.get(href);
				
				for (WebElement webElement : driver.findElements(By.className("sc-sdtwF"))) {
					item.add(webElement.getText());
				}
				for (WebElement webElement : driver.findElements(By.className("sc-iQtOjA"))) {
					category.add(webElement.getText());
				}
				for (WebElement webElement : driver.findElements(By.className("sc-cHSUfg"))) {
					price.add(webElement.getText());
				}
			}
			
			for (int i = 0; i < item.size(); i++) {
				System.out.println(++num + ". "+ item.get(i) +" 카테고리 : " + category.get(i) + " 가격 : " + price.get(i));
			}
			break;
			
		default:
			break;
		}
		
		driver.close();
		driver.quit();
		
	}
	
}
