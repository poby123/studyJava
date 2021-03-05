package ch11;

import java.util.Collections;
import java.util.LinkedList;

public class Ex02_LinkedList1 {

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		
		// list1, list2 ä���
		final int size = 10;
		System.out.println("initial size : " + list1.size());
		MyUtility.fillList(list1, size);
		MyUtility.fillList(list2, size);
		System.out.println("after fill size : " + list1.size());

		// list1 �����ϱ�
		MyUtility.printList(list1, "Before sort... list1");
		Collections.sort(list1);
		MyUtility.printList(list1, "After sort... list1");

		// list2 �����ϱ�
		MyUtility.printList(list2, "Before sort... list2");
		Collections.sort(list2);
		MyUtility.printList(list2, "After sort... list2");

		// list2���� list1�� ����� ���Ҹ� �����.
		list2.retainAll(list1);
		MyUtility.printList(list2, "After retainAll... list2");

		// list2���� ������ ���� �����
		list2.remove(list2.size() - 1);
		MyUtility.printList(list2, "After remove last element... list2");
	}

}
