package ch13;

import javax.swing.JOptionPane;

class WorkerEx02 implements Runnable{
	@Override
	public void run(){
		for(int i=10;i>=0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Ex02_Thread {

	public static void main(String[] args) throws Exception{
		// 1. �����带 �̿��� ī��Ʈ
//		Thread count = new Thread(new WorkerEx02());
//		count.start();
		
		String input =  JOptionPane.showInputDialog("�ƹ� ���̳� �Է����ּ���: ");
		System.out.println("The input value is " + input);
		
		// 2. �����带 �̿����� ���� ī��Ʈ
		nonThreadCount();

	}
	
	public static void nonThreadCount() throws InterruptedException {
		for(int i=5;i>=0;i--) {
			System.out.println(i);
			Thread.sleep(1000);
		}
	}

}
