package threadTest1;

import java.util.Iterator;

//실습]
//동석이네 동물원에는 3마리의 동물이 있다.
//각 동물은 울음 소리가 다르고 2마리의 동물은 동시에 운다.
//나머지 1마리 동물은 2마리 동물이 모두 울고 나서 마지막에 운다.
//
//package명은 threadTest1으로 만들고 클래스는 2개만 선언한다.
//하나의 클래스에는 main 쓰레드가 있다.
//Runnable 인터페이스로 멀티 쓰레드를 구현하고 반드시 join()을 사용한다.
//※ 각 동물은 10번씩만 운다.
public class Test1 {

	public static void main(String[] args) {
		String[] sounds = {"어흥", "야옹", "음메"};
		Test2[] animals = new Test2[sounds.length];			//자원, run()재정의된 클래스 타입으로 동물배열을 생성한다.,-> 현재 자원은 스레드의 이름을 불러와 출력하기 때문에
		Thread[] thread = new Thread[sounds.length];			//스레드 타입의 배열 선언 -> 멀티 스레드를 위해 실행시킬 스레드 파티션을 만든다.
		
		for (int i = 0; i < thread.length; i++) {						//스레드 배열의 길이만큼, 스레드의 갯수만큼 반복할 때
			animals[i] = new Test2();									//Test2(Runnable)타입으로 선언
			thread[i] = new Thread(animals[i], sounds[i]);		//Thread(Runnable , String name), 러너블타입과 이름을 넣어 선언한다
		}
		for (int i = 0; i < thread.length; i++) {
//			멀티 스레드 시작 - 이상태로는 세마리 모두 동시에 울기 때문에
			thread[i].start();
//			join을 걸어 반드시 먼저 실행해야하는 경우를 나눈다
			if(i != 0)	{	//0이 아닌경우 중괄호 안으로 들어온다.
//				0어흥은 이미 start했음으로 join을 기다리지 않고 동시출력이 되며, 음메는 앞 야옹에 join을 기다리게 된다
				try {thread[i].join();} catch (InterruptedException e) {;}
			}
		}
		
	}
}
// 집가서다시쓰기----------------------------------------------------------------------
// 배열 사용
//	안보고 20분맞춰서 써보기.
	