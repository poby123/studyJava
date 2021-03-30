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
		// 1. 쓰레드를 이용한 카운트
//		Thread count = new Thread(new WorkerEx02());
//		count.start();
		
		String input =  JOptionPane.showInputDialog("아무 값이나 입력해주세요: ");
		System.out.println("The input value is " + input);
		
		// 2. 쓰레드를 이용하지 않은 카운트
		nonThreadCount();

	}
	
	public static void nonThreadCount() throws InterruptedException {
		for(int i=5;i>=0;i--) {
			System.out.println(i);
			Thread.sleep(1000);
		}
	}

}
