package ch13;

/*
 * 데몬 쓰레드는, 일반 쓰레드의 작업을 도와주는 보조적인 역할의 쓰레드다.
 * 일반 쓰레드의 작업이 끝나면, 데몬 쓰레드도 더 이상 필요하지 않으므로 자동으로 종료된다.
 * 
 * 데몬 쓰레드에서 또 쓰레드를 생성하는 경우, 이 쓰레드는 자동으로 데몬 쓰레드가 된다.
 * */

class WorkerEx04 implements Runnable {

	private boolean autoSave = true;

	@Override
	public void run() {
		// 무한 반복
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (autoSave) {
				autoSave();
			}
		}
	}
	
	public void autoSave() {
		System.out.println("The file is auto saved.");
	}

}

public class Ex04_Daemon {

	public static void main(String[] args) {
		Thread t1 = new Thread(new WorkerEx04());
		
		// 쓰레드를 데몬 쓰레드로 설정한다. 이 설정은 반드시 start() 이전에 되어야한다.
		// 그렇지 않으면 IllegalThreadStateException 이 발생한다.
		t1.setDaemon(true);
		
		t1.start();
		
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
		
		System.out.println("The execution is ended.");
	}

}
