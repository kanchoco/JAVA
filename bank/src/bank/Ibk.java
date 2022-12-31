package bank;

public class Ibk extends Bank{
//	자식 - Nh(입금 시 수수료 50%), Kb(출금 시 수수료 50%), Ibk(잔액조회 시 재산 반토막)
@Override
public int checkBalance() {		//잔액조회
	setBalance(getBalance() / 2);					//-> private는 "메소드"로만 접근가능, get으로 값을 가져온다음, set으로 값을 할당한다!
	return super.checkBalance();
	}
}
