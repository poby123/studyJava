package ch13;

/*
 * ���� �������, �Ϲ� �������� �۾��� �����ִ� �������� ������ �������.
 * �Ϲ� �������� �۾��� ������, ���� �����嵵 �� �̻� �ʿ����� �����Ƿ� �ڵ����� ����ȴ�.
 * 
 * ���� �����忡�� �� �����带 �����ϴ� ���, �� ������� �ڵ����� ���� �����尡 �ȴ�.
 * */

class WorkerEx04 implements Runnable {

	private boolean autoSave = true;

	@Override
	public void run() {
		// ���� �ݺ�
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
		
		// �����带 ���� ������� �����Ѵ�. �� ������ �ݵ�� start() ������ �Ǿ���Ѵ�.
		// �׷��� ������ IllegalThreadStateException �� �߻��Ѵ�.
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
