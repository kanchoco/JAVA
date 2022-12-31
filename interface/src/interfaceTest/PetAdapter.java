package interfaceTest;
//	강제성을 조율하는 추상 클래스 - 
public abstract class PetAdapter implements Pet {
//	Pet인터페이스 지정
//	강제성 조정을 위한 추상 클래스의 경우 "Adapter"키워드를 꼭 써준다.
	
//	재정의
//강제성 조율을 위함이기 때문에 구현할 필요가 없다.
	@Override
	public void bang() {;}				

	@Override
	public void giveYourHand() {;}

	@Override
	public void bite() {;}

	@Override
	public void sitDown() {;}

	@Override
	public void waitNow() {;}
	@Override
	public void getNose() {;}

}

//	인터페이스와 추상클래스
//	인터페이스는 추상클래스를 고도화한 문법이다. 
//	즉, 인터페이스안의 모든 메소드들은 강제성을 부여받는다. --> 메소드 모두 재정의하지 않으면 안된다.
//	하지만, 상황에 따라서 불필요한 메소드들이 있을 수 있다. -> 선택적 재정의
//	이 경우에 추상클래스에서 인터페이스를 지정받아 강제성을 "조율"할 수 있다. --> 선택적 재정의 가능
