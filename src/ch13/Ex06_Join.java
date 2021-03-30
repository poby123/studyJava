package ch13;

/*
 * join()
 * 쓰레드 자신이 하던 일을 잠시 멈추고, 다른 쓰레드가 지정된 시간동안 작업을 하도록 한다.
 * 시간을 지정하지 않으면, 그 쓰레드가 일을 모두 마칠 때까지 기다린다.
 * */
class WorkerEx06 implements Runnable {

	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10 * 1000); // 10초를 기다린다.
			} catch (InterruptedException e) {
				System.out.println("Thread awaken by interrupt()");
			}

			gc(); // invoke garbage collector
			System.out.println("Garbage is collected. Free memory : " + freeMemory());
		}
	}

	public void gc() {
		usedMemory -= 300;
		if (usedMemory < 0) {
			usedMemory = 0;
		}
	}

	public int totalMemory() {
		return MAX_MEMORY;
	}

	public int freeMemory() {
		return MAX_MEMORY - usedMemory;
	}

}

public class Ex06_Join {

	public static void main(String[] args) {
		WorkerEx06 r = new WorkerEx06();
		Thread gc = new Thread(r);
		gc.setDaemon(true);
		gc.start();

		int requiredMemory = 0;

		for (int i = 0; i < 20; i++) {
			requiredMemory = (int) (Math.random() * 10) * 20;
		
			// 필요한 메모리가 사용할 수 있는 양보다 크거나, 
			// 전체 메모리의 60% 이상이면, gc를 깨운다.
			if(r.freeMemory() < requiredMemory || r.freeMemory() < r.totalMemory() * 0.4) {
				gc.interrupt(); // gc를 깨운다.
				try {
					// gc가 작업을 한 후, 메모리를 사용해야하기 때문에,
					// gc가 작업을 모두 완료하도록 일정시간 join을 통해 기다려준다.
					gc.join(100);
				}catch(InterruptedException e) {}
			}
			r.usedMemory += requiredMemory;
			System.out.println("usedMemory :" + r.usedMemory);
		}

	}

}
