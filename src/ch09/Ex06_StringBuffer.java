package ch09;

public class Ex06_StringBuffer {

	public static void basic() {
		/*
		 * StringBuffer Ŭ������ ���������� ���۸� ������ ������, �⺻ ũ��� 16�̴�. ����, ���ۺ��� ũ�� ������ �ʿ䰡 �ִٸ� ����
		 * ���۸� ������, �� ū ũ���� ���۸� ���� �� �����Ѵ�. �̷��� �Ǹ�, �۾� ȿ���� �������Ƿ� ���ڿ��� ���̸� ����ؼ� ó������ �����
		 * ��� ���� ����.
		 */
		StringBuffer sb = new StringBuffer(100);
		int c = sb.capacity();
		sb.append("1234").append("5678");
		StringBuffer sb2 = sb.append("910");

		System.out.println(sb == sb2); // true. append()�� ���� �ν��Ͻ��� ���ڿ��� �߰��� ��, �� �ν��Ͻ��� ��ȯ�Ѵ�.
		System.out.println("The capacity is : " + c);
		System.out.println(sb);
		System.out.println(sb.length());
	}

	public static void compare() {
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		String s1 = sb1.toString();
		String s2 = sb2.toString();

		// �⺻ StringBuffer�� equals() �� �������̵� �Ǿ����� �ʾƼ�, == ������ �ϴ� �Ͱ� ����.
		// ���� toString()�� ���� String���� ��ȯ�� ��, equals() �� �ؼ� ���ؾ��Ѵ�.
		System.out.println(sb1 == sb2); // false
		System.out.println(sb1.equals(sb2)); // false
		System.out.println(s1.equals(s2)); // true
	}

	public static void main(String[] args) {
		basic();
		compare();
	}

}
