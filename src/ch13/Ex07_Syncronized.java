package ch13;

class Account{
	private int balance = 1000;
	
	// getter
	public int getBalance() {
		return balance;
	}
	
	// 출금
	// 여러 쓰레드가 동시에 접근하면 잔액이 부족한데도, 비교후에 업데이트돼서
	// 잔액이 마이너스가 되는 사태가 일어나므로 synchronized 키워드를 통해,
	// 한 번에 한 쓰레드만 접근할 수 있도록 동기화를 해줘야한다.
	public synchronized void withDraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			balance -= money;
		}else {
			System.out.println("잔액이 부족합니다.");
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
