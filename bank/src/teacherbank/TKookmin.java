package teacherbank;

public class TKookmin extends Ttbank{
   @Override
   public void withdraw(int money) {
      money *= 1.5;
      super.withdraw(money);
   }
}