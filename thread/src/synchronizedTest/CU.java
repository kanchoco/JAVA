package synchronizedTest;

public class CU {
	public static void main(String[] args) {
		ATM atm = new ATM();				//자원
		
		Thread mom = new Thread(atm, "엄마");				//자원 공유
		Thread son = new Thread(atm, "아들");					//단계 건너뛰는 예외가 발생, -> 동기화로 해결
		
		mom.start();
		son.start();
	}
}
