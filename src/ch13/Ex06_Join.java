package ch13;

/*
 * join()
 * ������ �ڽ��� �ϴ� ���� ��� ���߰�, �ٸ� �����尡 ������ �ð����� �۾��� �ϵ��� �Ѵ�.
 * �ð��� �������� ������, �� �����尡 ���� ��� ��ĥ ������ ��ٸ���.
 * */
class WorkerEx06 implements Runnable {

	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10 * 1000); // 10�ʸ� ��ٸ���.
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
		
			// �ʿ��� �޸𸮰� ����� �� �ִ� �纸�� ũ�ų�, 
			// ��ü �޸��� 60% �̻��̸�, gc�� �����.
			if(r.freeMemory() < requiredMemory || r.freeMemory() < r.totalMemory() * 0.4) {
				gc.interrupt(); // gc�� �����.
				try {
					// gc�� �۾��� �� ��, �޸𸮸� ����ؾ��ϱ� ������,
					// gc�� �۾��� ��� �Ϸ��ϵ��� �����ð� join�� ���� ��ٷ��ش�.
					gc.join(100);
				}catch(InterruptedException e) {}
			}
			r.usedMemory += requiredMemory;
			System.out.println("usedMemory :" + r.usedMemory);
		}

	}

}
