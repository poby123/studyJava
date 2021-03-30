package ch13;

import javax.swing.JOptionPane;

/*
 * interrupt(), interrupted()
 * 쓰레드가 작업을 하고 있을 때, 취소시켜할 때 사용한다.
 * interrupt()는 쓰레드에게 작업 종료를 요청한다. 강제로 종료시키지는 못한다.
 * */

class WorkerEx05 implements Runnable{
	@Override
	public void run() {
		for(int i=10;i>=0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
				// sleep() 에 의해 멈춰있을 때, interrupt()를 하면
				// InterruptedException이 발생하고, interrupted가 false가 되므로,
				// catch문에서 interrupt() 해야한다.
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("The count is ended.");
	}
}

public class Ex05_Interrupt {

	public static void main(String[] args) {
		Thread t = new Thread(new WorkerEx05());
		
		t.start();
		System.out.println("Thread interrupted status : " + t.isInterrupted()); // false
		String input = JOptionPane.showInputDialog("Please input any string : ");
		System.out.println("The input value is : " + input);
		
		t.interrupt();
		System.out.println("Thread interrupted status : " + t.isInterrupted());
		
	}

}
