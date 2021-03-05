package ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * ArrayList�� LinkedList�� ��
 * 
 * �߰����� �����͸� �����ϴ� ���, LinkedList�� �ξ� �� ������.
 * ���������� �����͸� �����ϴ� ���, ArrayList�� �� ������.
 * �����͸� ��ȸ�ϴ� ���, ArrayList�� �ξ� �� ������.
 *
 * <���� ���>
== ���������� �߰��ϱ� ==
ArrayList : 178
LinkedList : 230

== �߰��� �߰��ϱ� ==
ArrayList : 3253
LinkedList : 13

== ��ȸ�ϱ� ==
ArrayList : 1
LinkedList : 77

== �߰����� �����ϱ� ==
ArrayList : 2554
LinkedList : 85

== ���������� �����ϱ� ==
ArrayList : 8
LinkedList : 20
 * 
 * */

public class Ex03_ArrayListLinkedListTest {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>(2000000);
		LinkedList<String> ll = new LinkedList<>();

		System.out.println("== ���������� �߰��ϱ� ==");
		System.out.println("ArrayList : " + add1(al));
		System.out.println("LinkedList : " + add1(ll));
		System.out.println();

		System.out.println("== �߰��� �߰��ϱ� ==");
		System.out.println("ArrayList : " + add2(al));
		System.out.println("LinkedList : " + add2(ll));
		System.out.println();

		System.out.println("== ��ȸ�ϱ� ==");
		System.out.println("ArrayList : " + access(al));
		System.out.println("LinkedList : " + access(ll));
		System.out.println();

		System.out.println("== �߰����� �����ϱ� ==");
		System.out.println("ArrayList : " + remove2(al));
		System.out.println("LinkedList : " + remove2(ll));
		System.out.println();

		System.out.println("== ���������� �����ϱ� ==");
		System.out.println("ArrayList : " + remove1(al));
		System.out.println("LinkedList : " + remove1(ll));
		System.out.println();
	}

	public static Long add1(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			list.add(i + "");
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	public static Long add2(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			list.add(500, "X");
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	public static Long remove1(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = list.size() - 1; i >= 0; i--) {
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	public static Long remove2(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	public static Long access(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			list.get(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
}
