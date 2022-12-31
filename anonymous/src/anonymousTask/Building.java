package anonymousTask;

public class Building extends FormAdapter{
//	빌딩 클래스, FormAdapter 상속
	public static void main(String[] args) {
//		[도전과제]
//		잠실점 오픈
//		잠실점은 무료 나눔 행사중이라서 판매 방식을 구현할 필요 없다
//		본사에서는 전달받은 양식을 검사할 때
//		무료나눔 행사중인 매장이라면 "무료 나눔 행사중" 출력하기
		
		 Starbucks gangnam = new Starbucks();		//객체화
		 Starbucks jamsil = new Starbucks();

		 gangnam.register(new Form() {					//익명클래스 , Form 인터페이스, 메소드 전부 재정의해야함
//	         강남점 등록을 위한 재정의/
	         @Override
	         public void sell(String order) {				//sell(카푸치노)<- Starbucks에서 전달받음
	            String[] menus = getMenu();				//getMenu()메소드를 문자열 menus로 받음
	            for (int i = 0; i < menus.length; i++) { // menus의 길이만큼 반복
	               if(order.equals(menus[i])) {				//equals -문자열 비교 | 메뉴를 돌면서 order와 같은지 비교 
	                  System.out.println("판매 완료");		//같다면, 판매완료를 출력
	               }
	            }
	         }
	         
	         @Override
	         public String[] getMenu() {		
	            String[] menus = {"아메리카노", "카푸치노", "캐모마일티"};	//String타입의 배열 menus
	            return menus;														//menus 리턴
	         }
	      });
	      
	      jamsil.register(new FormAdapter() {			//익명클래스는 $파일을 생성한다.
	    	  														//판매 방식 구현할 필요 없음, FormAdapter()를 받아왔기 때문,(강제성 조율)
	    	  @Override
	    	  public String[] getMenu() {
	    		  String[] menus = {"아메리카노", "카푸치노", "캐모마일티"};	//String타입의 배열 menus
	    		  return menus;													//menus 리턴			
	    	  }
	    	  
	    	  
	      });
	   }
	}