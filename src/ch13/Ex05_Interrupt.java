package ch13;

import javax.swing.JOptionPane;

/*
 * interrupt(), interrupted()
 * �����尡 �۾��� �ϰ� ���� ��, ��ҽ����� �� ����Ѵ�.
 * interrupt()�� �����忡�� �۾� ���Ḧ ��û�Ѵ�. ������ �����Ű���� ���Ѵ�.
 * */

class WorkerEx05 implements Runnable{
	@Override
	public void run() {
		for(int i=10;i>=0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
				// sleep() �� ���� �������� ��, interrupt()�� �ϸ�
				// InterruptedException�� �߻��ϰ�, interrupted�� false�� �ǹǷ�,
				// catch������ interrupt() �ؾ��Ѵ�.
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
