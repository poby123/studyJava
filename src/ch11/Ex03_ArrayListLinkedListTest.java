package ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * ArrayList와 LinkedList의 비교
 * 
 * 중간에서 데이터를 수정하는 경우, LinkedList가 훨씬 더 빠르다.
 * 순차적으로 데이터를 수정하는 경우, ArrayList가 더 빠르다.
 * 데이터를 조회하는 경우, ArrayList가 훨씬 더 빠르다.
 *
 * <실행 결과>
== 순차적으로 추가하기 ==
ArrayList : 178
LinkedList : 230

== 중간에 추가하기 ==
ArrayList : 3253
LinkedList : 13

== 조회하기 ==
ArrayList : 1
LinkedList : 77

== 중간에서 삭제하기 ==
ArrayList : 2554
LinkedList : 85

== 순차적으로 삭제하기 ==
ArrayList : 8
LinkedList : 20
 * 
 * */

public class Ex03_ArrayListLinkedListTest {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>(2000000);
		LinkedList<String> ll = new LinkedList<>();

		System.out.println("== 순차적으로 추가하기 ==");
		System.out.println("ArrayList : " + add1(al));
		System.out.println("LinkedList : " + add1(ll));
		System.out.println();

		System.out.println("== 중간에 추가하기 ==");
		System.out.println("ArrayList : " + add2(al));
		System.out.println("LinkedList : " + add2(ll));
		System.out.println();

		System.out.println("== 조회하기 ==");
		System.out.println("ArrayList : " + access(al));
		System.out.println("LinkedList : " + access(ll));
		System.out.println();

		System.out.println("== 중간에서 삭제하기 ==");
		System.out.println("ArrayList : " + remove2(al));
		System.out.println("LinkedList : " + remove2(ll));
		System.out.println();

		System.out.println("== 순차적으로 삭제하기 ==");
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
