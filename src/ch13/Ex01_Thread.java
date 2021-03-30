package ch13;

// Thread를 상속받아서 쓰레드를 만드는 방법
class ThreadWorker extends Thread{
	
	ThreadWorker(){
		super("Thread Worker");
	}
	
	@Override
	public void run() {
		// 부모인 Thread의 getName() 호출.
		System.out.println("\n"+getName() + " : 1");
		for(int i=0;i<300;i++) {
			System.out.print("1");
		}
	}
}

// Runnable 인터페이스를 구현하는 방법
class RunnableWorker implements Runnable{
	
	@Override
	public void run() {
		// 부모가 Thread가 아니므로 Thread.currentThread().getName() 호출.
		System.out.println("\n"+Thread.currentThread().getName() + " : 2");
		for(int i=0;i<300;i++) {
			System.out.print("2");
		}
	}
	
}

public class Ex01_Thread {

	public static void main(String[] args) throws InterruptedException {
		// Thread를 상속받은 쓰레드 객체를 만드는 방법
		Thread t1 = new ThreadWorker();
		
		// Runnable 인터페이스를 구현한 쓰레드 객체를 만드는 방법
		Runnable r = new RunnableWorker();
		Thread t2 = new Thread(r, "Runnable Worker");
		
		// 쓰레드 시작 : start() => 호출 스택을 새로 만들고, run() 함수를 호출한다.
		t1.start();
		t2.start();
	}

}
