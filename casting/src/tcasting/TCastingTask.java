package tcasting;

public class TCastingTask {
	//   넷플릭스
	//   애니메이션, 영화, 드라마 클래스 선언
	//   사용자가 선택한 영상이
	//   애니메이션이라면 "자막지원"기능 사용
	//   영화라면 "4D"기능 사용
	//   드라마라면 "굿즈"기능 사용
	   
	   public void check(Video video) {				//자식클래스를 하나로 묶어서 부모클래스를 호출 -> 업캐스팅
//		   매개변수 비디오는 한번에 여러개일 수 없다, 낭비를 하지 않기위해 중첩if문을 사용한다. | 그냥 if문 사용시 무조건 검사를 3번하게 됨
	      if(video instanceof Animation) {			//instanceof ~의 객체인지 알아볼때 사용
	         Animation ani = (Animation) video;		//업캐스팅한 비디오를 자식 클래스인 애니메이션 클래스로 형변환(부모클래스는 자식클래스가 아니기 때문에 강제형변환해준다.)하고 다운캐스팅한다.  | 업캐스팅을하면 자식클래스의 +a 필드가 사라지므로 다운클래스 하여 자식클래스를 복구한다.
	         ani.printSubtitle();							//복구한 자식클래스의 필드 사용
	      }else if(video instanceof Film) {
	         Film film = (Film) video;
	         film.print4D();
	      }else {
	         Drama drama = (Drama) video;
	         drama.sellGoods();
	      }
	   }
	   
	   public static void main(String[] args) {
	      TCastingTask ct = new TCastingTask();	//객체화
	      ct.check(new Animation());					//객체로 클래스를 접근하여 필드를 사용한다.
	      ct.check(new Film());
	      ct.check(new Drama());
	   }
	}


