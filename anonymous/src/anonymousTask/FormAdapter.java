package anonymousTask;

public class FormAdapter implements Form {
//	강제성 조율을 위한 Adapter클래스, 인터페이스 Form을 지정
// 강제성 조율을 위해 재정의하는 것이므로, Adapter클래스에서 구현할 필요가 없다.
	@Override
	public String[] getMenu() {
		return null;
	}

	@Override
	public void sell(String order) {;}

}
