package ch13;

/*
 * 쓰레드의 우선순위를 정할 수 있다.
 * 우선순위의 값에 따라 쓰레드가 얻는 실행시간이 달라지므로, 
 * 쓰레드가 작업하는 작업의 중요도에 따라 우선순위를 달리하여, 특정 쓰레드가 더 많은 작업시간을 갖도록 할 수 있다.
 * (시각적인 부분이나, 사용자에게 빠르게 반응해야하는 작업을 하는 쓰레드의 우선순위를 높이는 것이 좋다.)
 * 
 * setPriority() 함수를 통해 1~9까지의 우선순위를 결정할 수 있으며, 숫자가 높을 수록 높은 우선순위를 갖는다.
 * 
 * 싱글코어에 경우에는 우선순위가 높은 작업에 더 많은 작업시간을 갖게 하겠지만,
 * 멀티코어인 경우, OS마다 다른 방식으로 스케줄링하기 때문에, OS에 종속적인 결과가 나오게 된다.
 * 차라리 쓰레드에 우선순위를 부여하는 대신에, 작업에 우선순위를 둬서 PriorityQueue에 저장해놓고,
 * 우선순위가 높은 작업들을 먼저 처리하는 것이 나을 수도 있다.
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
	
		// 우선순위 설정. 우선순위 설정은 start() 함수 이전에 있어야한다.
		t1.setPriority(9);
		t1.setPriority(1);
		
		t1.start();
		t2.start();
	}

}
