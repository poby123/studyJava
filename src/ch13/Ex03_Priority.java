package ch13;

/*
 * �������� �켱������ ���� �� �ִ�.
 * �켱������ ���� ���� �����尡 ��� ����ð��� �޶����Ƿ�, 
 * �����尡 �۾��ϴ� �۾��� �߿䵵�� ���� �켱������ �޸��Ͽ�, Ư�� �����尡 �� ���� �۾��ð��� ������ �� �� �ִ�.
 * (�ð����� �κ��̳�, ����ڿ��� ������ �����ؾ��ϴ� �۾��� �ϴ� �������� �켱������ ���̴� ���� ����.)
 * 
 * setPriority() �Լ��� ���� 1~9������ �켱������ ������ �� ������, ���ڰ� ���� ���� ���� �켱������ ���´�.
 * 
 * �̱��ھ ��쿡�� �켱������ ���� �۾��� �� ���� �۾��ð��� ���� �ϰ�����,
 * ��Ƽ�ھ��� ���, OS���� �ٸ� ������� �����ٸ��ϱ� ������, OS�� �������� ����� ������ �ȴ�.
 * ���� �����忡 �켱������ �ο��ϴ� ��ſ�, �۾��� �켱������ �ּ� PriorityQueue�� �����س���,
 * �켱������ ���� �۾����� ���� ó���ϴ� ���� ���� ���� �ִ�.
 * */

class WorkerEx03 implements Runnable{
	private String s;
	
	WorkerEx03(String s){
		this.s = s;
	}
	
	@Override
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print(s);
			for(int j=0;j<10000000;j++);
		}
	}
}

public class Ex03_Priority {

	public static void main(String[] args) {
		Thread t1 = new Thread(new WorkerEx03("-"));
		Thread t2 = new Thread(new WorkerEx03("|"));
	
		// �켱���� ����. �켱���� ������ start() �Լ� ������ �־���Ѵ�.
		t1.setPriority(9);
		t1.setPriority(1);
		
		t1.start();
		t2.start();
	}

}
