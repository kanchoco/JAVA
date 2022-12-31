package dktlamp;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * 전원 끄기 예약이 가능한 책상 조명
 */
public class TimerDeskLamp extends DeskLamp  implements Runnable{

    final static int DELAY_MILLISECOND = 5000;

    private Thread offDelayThread; // 전원 끄기 예약 쓰레드
    private Thread previousThread; //기존 실행된 스레드와 새로 실행된 스레드 구분을 위해 새로 선언

    // TODO - TimerDeskLamp 클래스의 나머지 코드를 구현해 주세요.
    
    public void offDelay() {//메소드가 사용됨 , 예약중
    	if(previousThread != null)	{
    		previousThread.interrupt();	//중복 실행 시 초기화이므로 인터럽트 발생해줌
    	}
    	offDelayThread = new Thread(this);
    	offDelayThread.start();
    	previousThread = offDelayThread;	//그리고 다시실행하면서 중복실행된 이전스레드. previous를 offdelay에 넣음
    }
    
    @Override
    public void run() {
//    	예약 여부 확인
    	while(true)	{
    		try {
				Thread.sleep(DELAY_MILLISECOND);
			} catch (InterruptedException e) {	//중복 실행 시 인터럽트를 발생시켜서 이쪽으로 들어오게함
				System.out.println("타이머 리셋");
				break;	//반복문이 나가지면서 새로운 스레드가 다시 들어옴, 그렇게 타이머가 다시 리셋이 되는것.
			}
    		turnOff();//5초 후 종료
    		previousThread = null;	//전원종료가 되고 나서 다시 previous를 초기화
    		break; //스레드 종료
    	}
	}

}
