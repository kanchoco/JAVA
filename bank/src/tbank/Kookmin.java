package tbank;

public class Kookmin extends Tbank{
   @Override
   public void withdraw(int money) {
      money *= 1.5;
      super.withdraw(money);
   }
}