package teacherbank;

import teacherbank.Ttbank;

public class TShinhan extends Ttbank{
   @Override
   public void deposit(int money) {
      money *= 0.5;
      super.withdraw(money);
   }
}