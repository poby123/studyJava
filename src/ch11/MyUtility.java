package ch11;

import java.util.List;

public class MyUtility {
	
	public static <T> void printList(List<T> list, String title) {
		System.out.print(title + " : ");
		
		// ����1
		for (T i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// ����2
//		Iterator<T> it =  list.iterator();
//		while(it.hasNext()) {
//			System.out.print(it.next() + " ");
//		}
	}

	public static void fillList(List<Integer> list, int size) {
		for (int i = 0; i < size; i++) {
			list.add((int) (Math.random() * size * 2));
		}
	}
}
