package teacherbank;

public class TDongseok extends Ttbank{
   @Override
   public int showBalance() {
      setMoney(getMoney()/2);
      return super.showBalance();
   }
}