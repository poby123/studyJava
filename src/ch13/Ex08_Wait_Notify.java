package ch13;

import java.util.ArrayList;

/*
 * Table
 * */
class Table {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 5; // 한 테이블에 나올 수 있는 최대 음식의 개수

	private ArrayList<String> dishes = new ArrayList<>();

	public void add(String dish) {
		if (dishes.size() >= MAX_FOOD) {
			return;
		}
		dishes.add(dish);
		System.out.println("Dishes : " + dishes);
	}

	public boolean remove(String dishName) {
		for (int i = 0; i < dishes.size(); i++) {
			if (dishName.equals(dishes.get(i))) {
				dishes.remove(i);
				return true;
			}
		}
		return false;
	}

	public int dishNum() {
		return dishNames.length;
	}
}

/*
 * Customer
 */
class Customer implements Runnable {
	private Table table;
	private String food;

	Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

			String name = Thread.currentThread().getName();

			if (eatFood()) {
				System.out.println(name + " ate a " + food);
			}
			else {
				System.out.println(name + " failed to eat. :(");
			}
		}
	}
	
	boolean eatFood() {
		return table.remove(food);
	}
}

/*
 * Cook
 * */
class Cook implements Runnable{
	
	private Table table;
	
	Cook(Table table){
		this.table = table;
	}
	
	@Override
	public void run() {
		while(true) {
			// 임의의 요리를 하나해서, table에 추가한다.
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			
			try {
				Thread.sleep(1);
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
}

/*
 * Main
 * */
public class Ex08_Wait_Notify {

	public static void main(String[] args) throws Exception {
		Table table = new Table(); // 여러 쓰레드가 공유하는 객체
		
		new Thread(new Cook(table), "Cook1").start();
		new Thread(new Customer(table, "donut"), "Customer1").start();
		new Thread(new Customer(table, "burger"), "Customer2").start();
		
		Thread.sleep(100);
		System.exit(0);
	}

}
