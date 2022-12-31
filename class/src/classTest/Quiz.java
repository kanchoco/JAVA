package classTest;

public class Quiz {
//	문제, 정답, 먹이개수
	String question;
	String answer;
	int feedCount;
//	잭팟
	boolean jackpot;
	
	public Quiz() {;}		//기본생성자

	public Quiz(String question, String answer, int feedCount) {		//문제, 정답, 먹이갯수를 받아서 퀴즈를 생성함
		super();
		this.question = question;
		this.answer = answer;
		this.feedCount = feedCount;
	}

	public Quiz(String question, String answer, int feedCount, boolean jackpot) {
		this.question = question;
		this.answer = answer;
		this.feedCount = feedCount;
		this.jackpot = jackpot;
	}
	
	
	
}
