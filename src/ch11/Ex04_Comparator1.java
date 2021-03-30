package ch11;

import java.util.Arrays;
import java.util.Comparator;


/*
 * Comparable : �⺻ ���ı���(���� ��������)�� �����ϴµ� ���.
 * Comparator : �⺻ ���ı��� �̿��� �ٸ� �������� �����ϰ��� �� �� ���.
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

		// �⺻������ String Ŭ������ Comparable�� ���� ���ĵȴ�.
		Arrays.sort(arr); // ���ı���? => String Ŭ�����ȿ� �ִ� Comparabale �̶�� �������̽��� ������ �Լ���.
		System.out.println("After Arrays.sort(arr) : " + Arrays.toString(arr));

		// ��ҹ��� ���� ���� ����.
		Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
		System.out.println("After Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER) : " + Arrays.toString(arr));

		// ������ Comparator�� ����ؼ� ���� DescendingOrder�� ���� ����.
		Arrays.sort(arr, new DescendingOrder<String>());
		System.out.println("After Arrays.sort(arr, new DescendingOrder<String>()); : " + Arrays.toString(arr));
	}

}
