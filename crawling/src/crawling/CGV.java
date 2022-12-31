package crawling;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 크롤링
 * 웹페이지의 정보를 가져온다.
 * 
 * jsoup를 사용한 방법과 selenium을 사용하는 방법이 있다.
 * jsoup을 사용하면 웹페이지의 기능은 사용하지 못하고, 접속한 웹페이지 내에서만 정보를 추출할 수 있다
 * selenium을 사용하면 웹페이지의 기능도 사용할 수 있어, 접속한 웹페이지의 여러 주소로 접근하여 다른 정보도 가져올 수 있다
 * -> 일종의 매크로처럼 생각하면 될것같다*/


/*
 * ※ 셀레니움 사용 시 주의사항
 * 브라우저의 url을 변경할 때에는, 미리 WebElement를 담아놓았던 객체의 해당 필드를 전부 다 사용하고 나서 url이 변경되어야 한다.
 * 해당 페이지의 작업은 무조건 다 끝내고 URL을 변경하자!
 */


public class CGV {
//	selenium 드라이버 
	private WebDriver webDriver;
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";

	public static void main(String[] args) {
		CGV cgv = new CGV();
//		크롤링할 사이트의 주소
		String url = "http://www.cgv.co.kr/movies/?lt=1&ft=0";
		WebDriver driver= cgv.webDriver;
		Scanner sc = new Scanner(System.in);
	      String countText = null;
	      int i = 0, total = 0;

		
//		운영체제에 드라이버 설정 (크롬은 운영체제에 설치된 소프트웨어이므로 메모리가 아닌 운영체제에 접근해서 설정한다.)
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
//		webDriver객체에 크롬 드라이버 대입
		driver = new ChromeDriver();
		
//		원하는 경로를 브라우저에 전달
		driver.get(url);
		
//		브라우저보다 컴파일러의 속도가 훨씬 빠르므로, 동적데이터를 가져올때는 컴파일러를 재우면서 사용한다.
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
//		더 보기 버튼 클릭
//		driver.findElement(By.className("btn-more-fontbold")).click();
//		동적데이터 기다리기.
//		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
//		영화제목 가져오기
//		예매율도 가져오기
//		장르가져오기
		
//		각 정보를 담을 ArrayList 선언
		  ArrayList<String> reservationRates = new ArrayList<String>();
	      ArrayList<String> names = new ArrayList<String>();
	      ArrayList<String> genres = new ArrayList<String>();
//		얘는 주소를 담을 리스트이다,     -- 주소 이동을 위해 	      
	      ArrayList<String> hrefs = new ArrayList<String>();
	      
//	      빠른포문으로 객체를 가져온다
//	      findElements -> 요소들을 가져옴    cssSelector -> CSS주소를 전달하면 해당 CSS요소를 가져온다.    	
	      for (WebElement webElement : driver.findElements(By.cssSelector("strong.percent span"))) {
//	    	  가져온 요소를 텍스트로 변환하고, 예매율 리스트에 담는다.
	          reservationRates.add(webElement.getText());
	       }
	       
//	    	   마찬가지로 가져올 요소가 있는 주소를 전달하여 webElement로 가져오고 .getText()를 사용해 텍스트로 출력하여 String타입의 리스트에 담는다
	       for (WebElement webElement : driver.findElements(By.cssSelector("div.box-contents strong.title"))) {
	          names.add(webElement.getText());
	       }
	       
//	    	   마찬가지로 가져올 요소가 있는 주소를 전달하여 webElement로 가져오고 .getText()를 사용해 텍스트로 출력하여 String타입의 리스트에 담는다
	       for(WebElement webElement : driver.findElements(By.cssSelector("div.box-image a"))) {
//	       소스코드내에서 링크가 하나 더 존재한다, 그래서 반복을 실행하면 링크가 계속 바뀌게 된다.
//	    	   해당 작업을 건너뛰기 위해 if문을 선언하여 해당 주소일시 점프한다.
	    	   if(webElement.getAttribute("href") == "http://www.cgv.co.kr/movies/?lt=1&ft=0#") {continue;}
	    	   hrefs.add(webElement.getAttribute("href"));
	       }
	       
//	       장르는 세부정보이므로, 메인페이지에서는 가져올 수 없는 정보이다.
//	       따라서 드라이버에 주소를 넘겨서 페이지를 이동한 후, 해당 페이지에서 정보를 가져오는 작업을 진행한다.
	       for (String href : hrefs) {
//	    	   주소가들어있는 hrefs리스트의 요소를 가져와 driver.get()에 넘긴다.
	          driver.get(href);
//	          이전과 마찬가지로 해당 요소가 있는 CSS주소를 넘겨 자바로 요소를 받아온다.
	          for(WebElement webElement : driver.findElements(By.cssSelector("div.spec dl dt"))) {
//	        	 바로 리스트에 넘기지 않고 출력하여 genre문자열에 담은 뒤
	             String genre = webElement.getText();
//	             만약, genre에 담긴 문자열이 "장르"로 시작하는 경우에만
	             if(genre.startsWith("장르")) {
//	            	 genres리스트에 담는다
	                genres.add(genre);
	             }
//	            가져온 dt안에는 장르뿐만아니라 감독, 개봉일 등의 다른 요소들이 들어있었기 때문에 다시 걸러주는 작업을 진행해야 했다
	          }
	       }
	       
//	       리스트에 요소들에 하나씩 접근해서 출력한다. 따라서 빠른포문은 사용하지 못하고 index를 사용한다.
//	       index가 0부터 리스트의 크기만큼 증가할 때, 
	       for(int j = 0; j < names.size(); j++) {
//	    	   #i는 0이기 때문에 출력부분에선 전위형을 사용하여 증가시킨다.-> 해당라인부터 증가하므로,
//	    	   get(int index)메소드를 사용하여 리스트의 값을 차례로 출력한다.
	          System.out.println(++i + ". " + names.get(j) + ", " + reservationRates.get(j) + ", " + genres.get(j));
	       }
//	       사용자에게 입력받는 부분, 원하는 영화의 예매관을 찾기위해 사용자에게 입력을 받는다.
	       i = sc.nextInt();
//	       사용자에게 출력하는i는 전위 증가, 즉 1부터 출력되었다. 리스트의 값은 0부터 시작하므로 감소시킨다.
	       i--;
	       
//	       이전 작업을 통해 페이지는 세부정보 페이지로 넘어갔다, 따라서 메인페이지의 경로를 다시 전달해준다.
//	       ---- 작업을 모두 마친 뒤 접근하게 되면 가장 마지막에 작업한 페이지의 내에서 접근한다,(ex 미니언즈, 
//	      			따라서 값에 오류가 생겨버리므로 반드시 주소를 다시 설정해주도록 한다.
	       driver.get(url);
	       try {Thread.sleep(1000);} catch (InterruptedException e) {;}
	       
//	       예매하기 버튼 다 가져오기
	       List<WebElement> btns = driver.findElements(By.className("link-reservation"));
	       
//	       예매하기 버튼은 클릭 안되기 때문에, 이동할 경로를 직접 가져온다.
//	       가져온 경로를 직접 브라우저 주소창(URL)에 넣어준다.
//	       ---> 각 버튼에 접근해서 href속성 값(주소)을 가져온것이다, 가져온 주소값을 driver.get()에 넣어 해당 주소로 이동한다.
	       driver.get(btns.get(i).getAttribute("href"));
//	       동적 데이터를 가져올때는 반드시 컴파일러를 멈춰야한다. 브라우저보다 컴파일러가 읽는 속도가 더 빠르므로 값에 오차가 생긴다.
	       try {Thread.sleep(1000);} catch (InterruptedException e) {;}
	       
//	       극장 정보는 새로운 iframe에 담겨있기 때문에,
//	       현재 브라우저의 주소창(URL)을 iframe src(경로)로 변경해준다.
	       driver.get(driver.findElement(By.id("ticket_iframe")).getAttribute("src"));
	       try {Thread.sleep(2000);} catch (InterruptedException e) {;}
	       
//	       가져온 CSS요소를 가져오는 빠른 포문
	       for(WebElement webElement : driver.findElements(By.className("count"))) {
//	    	   counText에 가져온 요소를 출력하여 담는다.
	          countText = webElement.getText();
//	          만약 countText값의 길이가 0 -> 즉 가져온 값이 공백이라면 다음작업을 점프한다.
	          if(countText.length() == 0) {continue;}
//	          total-> 예매 가능 영화관 수이므로, 누적합산을 해야한다 따라서 += 
//	          영화관 수는 (30)으로 표시가 되어있다, substring으로 문자열을 잘라준다.(0은 (이므로 1부터 마지막-1까지 가져온다)
	          total += Integer.valueOf(countText.substring(1, countText.length() - 1));
	       }
	       
	       System.out.println("예매 가능한 영화관 수 : " + total);


//		드라이버를 종료
		driver.close();
//		chrome종료
		driver.quit();
			
		
	}
}
