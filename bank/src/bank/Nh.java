package bank;

public class Nh extends Bank{
//	자식 - Nh(입금 시 수수료 50%), Kb(출금 시 수수료 50%), Ibk(잔액조회 시 재산 반토막)
@Override
	void deposit(int money) {	//입금
		money *= 0.5;
		super.deposit(money);
	}
}
