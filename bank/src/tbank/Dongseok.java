package tbank;

public class Dongseok extends Tbank{
   @Override
   public int showBalance() {
      setMoney(getMoney() / 2);
      return super.showBalance();
   }
}