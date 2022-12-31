package anonymousTask;

public class Starbucks {
	//등록을 위한 메소드, 양식에 따른 값을 빌딩에서 가져온다.
   public void register(Form form) {			
      String[] menus = form.getMenu();										// String타입의 배열 menus에 form의 getMenu()를 대입한다.

//	      System.out.println("=======메뉴========");    
//	       if(form instanceof FormAdapter){//  -> 두 경우로 나누기 때문에 if/else if로 사용하지 않는다. 
////	    	   												if(menus == null)		==> menu로 가정할 필요없이, FormAdapter와 타입비교하면 구현하지 않았다는(선택적 재정의) 뜻이 된다. 
//	    	  System.out.println("무료 나눔 행사중");
//	      }		
//	      else{for (int i = 0; i < menus.length; i++) { 
//		    	  System.out.println(i + 1 + ". " + menus[i]);
//		      }
//	      	form.sell("카푸치노");
//	      }
//      문제를 잘못이해함,, 메뉴 출력 후에 무료나눔 행사중 출력
      
      System.out.println("=======메뉴========");    
      
      	for (int i = 0; i < menus.length; i++) { 							//int i가 0부터 menus배열의 길이만큼 증가할 때,
    	  System.out.println(i + 1 + ". " + menus[i]);						//i(0 ~)+1.menus[i]출력, -> 배열은 0부터 시작, 메뉴판은 1부터 출력하기 위해 i에 1을 더한다.
      	}																				//+ menus[i] 메뉴의 인덱스i번째 값을 출력한다.	
      	
      	form.sell("카푸치노");														//sell값은 카푸치노 고정, 빌딩에 전달
      	
      	if(form instanceof FormAdapter)	{								//만약, form이 FormAdapter타입이라면, (선택적으로 재정의할때는 Adapter클래스를 상속받아 재정의한다.(강제성조정))
      		System.out.println("무료 나눔 행사중");								//"무료 나눔 행사중"을 출력한다.
      	}
   }
}