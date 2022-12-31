package lamdaTask;

@FunctionalInterface
public interface Opercheck {
	//* 전체 식을 전달받은 후 String[]로 리턴하는 getOpers 추상메소드 선언(함수형 인터페이스 제작)
	public String[] checkOper(String expression);
}
