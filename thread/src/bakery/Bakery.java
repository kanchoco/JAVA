package bakery;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
		BreadMaker breadMaker = new BreadMaker();
		Thread maker = new Thread(breadMaker);
		 BreadPlate breadPlate = BreadPlate.getInstance();
		String[] btns = {"빵 먹기" , "나가기"};
		int choice = 0;
		
		ImageIcon icon = new ImageIcon("src/img/bread2.gif");
		
		maker.start();
		// java.lang.IllegalMonitorStateException: current thread is not owner -> 여러 스레드가 개입할 때, wait로 조정할 수 없음.
//		동기화로 스레드를 제어해서 문제해결
//		JOptionPane.showMessageDialog(null, args);
		while (true) {
			choice = JOptionPane.showOptionDialog(null, "", "빵집",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, btns, null);
			if(choice == 0) {
				breadPlate.eatBread();
			}else {
				System.exit(0);	//전체 종료
//				maker.interrupt();
//				break;
			}
		}	
	}
}
