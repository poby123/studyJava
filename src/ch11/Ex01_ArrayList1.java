package ch11;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Collection <- List <- ArrayList
 * */

public class Ex01_ArrayList1 {

	/*
	 * main methods
	 */
	public static void main(String[] args) {
		final int capacity = 10;
		ArrayList<Integer> list1 = new ArrayList<>(capacity);
		ArrayList<Integer> list2 = new ArrayList<>(capacity);
		
		// list1, list2 ä���.
		System.out.println("initial size : " + list1.size());
		MyUtility.fillList(list1, capacity);
		MyUtility.fillList(list2, capacity);
		System.out.println("after fill size : " + list1.size());

		// list1 �����ϱ�
		MyUtility.printList(list1, "Before sort... list1");
		Collections.sort(list1);
		MyUtility.printList(list1, "After sort... list1");

		// list2 �����ϱ�
		MyUtility.printList(list2, "Before sort... list2");
		Collections.sort(list2);
		MyUtility.printList(list2, "After sort... list2");
		
		// list2�� �����ϴ� ��ü list3 ����.
		ArrayList<Integer> list3 = new ArrayList<>(list2);

		// list2���� list1�� �ٸ� �κ� �����.
		list2.retainAll(list1);
		MyUtility.printList(list2, "After retainAll... list2");
		
		// list3���� list1�� ���� �κ� �����.
		list3.removeAll(list1);
		MyUtility.printList(list3, "After removeAll... list3");
		
		// list2���� ������ ���� �����
		list2.remove(list2.size() - 1);
		MyUtility.printList(list2, "After remove last element... list2");
	}

}
