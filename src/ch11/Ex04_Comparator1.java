package ch11;

import java.util.Arrays;
import java.util.Comparator;


/*
 * Comparable : 기본 정렬기준(보통 오름차순)을 구현하는데 사용.
 * Comparator : 기본 정렬기준 이외의 다른 기준으로 정렬하고자 할 때 사용.
 * */
class DescendingOrder<T extends Comparable<T>> implements Comparator<T> {
	@Override
	public int compare(T a, T b) {
		return -a.compareTo(b);
	}
}

public class Ex04_Comparator1 {

	public static void main(String[] args) {
		String[] arr = { "ABC", "cat", "Dog", "abc", "lion", "tiger" };

		// 기본적으로 String 클래스의 Comparable에 의해 정렬된다.
		Arrays.sort(arr); // 정렬기준? => String 클래스안에 있는 Comparabale 이라는 인터페이스를 구현한 함수에.
		System.out.println("After Arrays.sort(arr) : " + Arrays.toString(arr));

		// 대소문자 구분 없이 정렬.
		Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
		System.out.println("After Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER) : " + Arrays.toString(arr));

		// 위에서 Comparator를 사용해서 만든 DescendingOrder에 의해 정렬.
		Arrays.sort(arr, new DescendingOrder<String>());
		System.out.println("After Arrays.sort(arr, new DescendingOrder<String>()); : " + Arrays.toString(arr));
	}

}
