package casting;

import java.util.Scanner;

//	월요일 - 상속, 다형성(오버로딩(차이점이 있다면 메소드 중복네임 가능), 오버라이딩 - 덮어쓰기), 변수, 접근자, 업캐스팅, 다운캐스팅, 
//	
//	다운캐스팅 활용이 미숙, 잘 생각이 안남.
//	이거 복습이 필요함.
//	비슷한 예제 3개정도 만들기.

class VideoGenre	{
	
	String video[] = {"totoro", "drama", "hansan"};
	
	
	void printGenre()	{
		System.out.println("장르");
	}
	void plus(){
		System.out.println("추가요소");
	}
}

class Anime extends VideoGenre	{
	
	@Override
	void printGenre()	{
		System.out.println("애니메이션");
	}
	
	void plus(){
		System.out.println("자막지원");
	}
}

class Movie extends VideoGenre	{
	
	@Override
	void printGenre()	{
		System.out.println("영화");
	}
	
	void plus(){
		System.out.println("4D");
	}
}

class Drama extends VideoGenre	{
	@Override
	void printGenre()	{
		System.out.println("드라마");
	}
	void plus(){
		System.out.println("굿즈");
	}
	
}
public class MyCastingTask {
//	넷플릭스
//	애니메이션, 영화, 드라마 클래스 선언
//	사용자가 선택한 영상이
//	애니메이션이라면 "자막지원"기능 사용
//	영화라면 "4D"기능 사용
//	드라마라면 "굿즈"기능 사용
	
	
	public void check(VideoGenre video) {		
		if(video instanceof Anime) {
			Anime ani = (Anime)video;
			ani.printGenre();
			ani.plus();
		}
			else if(video instanceof Drama) {
	//			genre = new Drama();		//이건 새로생성, 다운캐스팅으로 해야함
					Drama drama = (Drama)video;			//이게 다운캐스팅!, 생성하려고 하지말것
					drama.printGenre();
					drama.plus();
			}
				else {
					Movie movie = (Movie)video;
					movie.printGenre();
					movie.plus();
						}
	}
	
	public static void main(String[] args) {
		MyCastingTask ct = new MyCastingTask();
		
		VideoGenre totoro = new Anime();
		VideoGenre drama = new Drama();
		VideoGenre hansan = new Movie();
		
		Scanner sc = new Scanner(System.in);
		
		int movieChoice=0;
		VideoGenre video[] = {totoro, drama, hansan};
		
		
		System.out.println("영상을 골라주세요");
		System.out.println("1. 토토로, 2. 드라마, 3. 한산");
		movieChoice = sc.nextInt();
		VideoGenre movie = video[movieChoice - 1];
		
		ct.check(movie);
		
	
		}
		
	}

