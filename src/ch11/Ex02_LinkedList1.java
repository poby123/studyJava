package ch11;

import java.util.Collections;
import java.util.LinkedList;

public class Ex02_LinkedList1 {

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		
		// list1, list2 채우기
		final int size = 10;
		System.out.println("initial size : " + list1.size());
		MyUtility.fillList(list1, size);
		MyUtility.fillList(list2, size);
		System.out.println("after fill size : " + list1.size());

		// list1 정렬하기
		MyUtility.printList(list1, "Before sort... list1");
		Collections.sort(list1);
		MyUtility.printList(list1, "After sort... list1");

		// list2 정렬하기
		MyUtility.printList(list2, "Before sort... list2");
		Collections.sort(list2);
		MyUtility.printList(list2, "After sort... list2");

		// list2에서 list1과 공통된 원소만 남기기.
		list2.retainAll(list1);
		MyUtility.printList(list2, "After retainAll... list2");

		// list2에서 마지막 원소 지우기
		list2.remove(list2.size() - 1);
		MyUtility.printList(list2, "After remove last element... list2");
	}

}
