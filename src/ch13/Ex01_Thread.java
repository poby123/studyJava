package ch13;

// Thread�� ��ӹ޾Ƽ� �����带 ����� ���
class ThreadWorker extends Thread{
	
	ThreadWorker(){
		super("Thread Worker");
	}
	
	@Override
	public void run() {
		// �θ��� Thread�� getName() ȣ��.
		System.out.println("\n"+getName() + " : 1");
		for(int i=0;i<300;i++) {
			System.out.print("1");
		}
	}
}

// Runnable �������̽��� �����ϴ� ���
class RunnableWorker implements Runnable{
	
	@Override
	public void run() {
		// �θ� Thread�� �ƴϹǷ� Thread.currentThread().getName() ȣ��.
		System.out.println("\n"+Thread.currentThread().getName() + " : 2");
		for(int i=0;i<300;i++) {
			System.out.print("2");
		}
	}
	
}

public class Ex01_Thread {

	public static void main(String[] args) throws InterruptedException {
		// Thread�� ��ӹ��� ������ ��ü�� ����� ���
		Thread t1 = new ThreadWorker();
		
		// Runnable �������̽��� ������ ������ ��ü�� ����� ���
		Runnable r = new RunnableWorker();
		Thread t2 = new Thread(r, "Runnable Worker");
		
		// ������ ���� : start() => ȣ�� ������ ���� �����, run() �Լ��� ȣ���Ѵ�.
		t1.start();
		t2.start();
	}

}
