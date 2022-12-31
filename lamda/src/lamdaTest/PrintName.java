package lamdaTest;

// 함수형 인터페이스로 선언
@FunctionalInterface
public interface PrintName {
//	성과 이름을 전달받은 후 String으로 리턴하는 추상 메소드
	public String name(String firstName, String secondName);
}
