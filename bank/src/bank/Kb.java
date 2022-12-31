package bank;

public class Kb extends Bank {
//	자식 - Nh(입금 시 수수료 50%), Kb(출금 시 수수료 50%), Ibk(잔액조회 시 재산 반토막)
@Override
void withdraw(int money) {	//출금
		money *= 1.5;
	super.withdraw(money);
}
}
