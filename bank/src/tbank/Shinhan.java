package tbank;

public class Shinhan extends Tbank{
   @Override
   public void deposit(int money) {
      money *= 0.5;
      super.deposit(money);
   }
}