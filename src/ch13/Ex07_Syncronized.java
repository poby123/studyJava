package ch13;

class Account{
	private int balance = 1000;
	
	// getter
	public int getBalance() {
		return balance;
	}
	
	// ���
	// ���� �����尡 ���ÿ� �����ϸ� �ܾ��� �����ѵ���, ���Ŀ� ������Ʈ�ż�
	// �ܾ��� ���̳ʽ��� �Ǵ� ���°� �Ͼ�Ƿ� synchronized Ű���带 ����,
	// �� ���� �� �����常 ������ �� �ֵ��� ����ȭ�� ������Ѵ�.
	public synchronized void withDraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			balance -= money;
		}else {
			System.out.println("�ܾ��� �����մϴ�.");
		}
	}	
}

class WorkerEx07 implements Runnable{
	
	Account account = new Account();
	
	@Override
	public void run() {
		while(account.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			account.withDraw(money);
			System.out.println("Balance : " + account.getBalance());
		}
	}
}

public class Ex07_Syncronized {

	public static void main(String[] args) {
		Runnable r = new WorkerEx07();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}

}
