package ch09;

/*
 * - String �� �ٷ�� 2���� ���
 * 1. String str = "abc"
 * ���ڿ� ���ͷ��� ����ϴ� ����� �̹� �����ϴ� �ν��Ͻ��� �ܼ��� �����Ͽ� ����ϴ� ���̴�.
 * ���ڿ� ���ͷ��� Ŭ������ �޸𸮿� �ε�� �� �ڵ������� �̸� �����Ǳ� �����̴�.
 * (�߰� : ��� ���ڿ� ���ͷ��� ������ �ÿ� Ŭ���� ���Ͽ� ����Ǹ�, ���� ������ ���ڿ� ���ͷ��� �� ���� ����ȴ�.
 * Ŭ���� ������ �޸𸮿� �ε�� ��, ���ͷ� ��Ͽ� �ִ� ��� ���ͷ����� JVM ������ ��� �����(constant pool)�� ����ȴ�.) 
 * 
 * 2. String str = new String("abc")
 * String Ŭ������ �����ڸ� �̿��ϴ� �����, �׻� ���ο� String �ν��Ͻ��� �����Ѵ�.
 * 
 * - String �ν��Ͻ��� Ư¡
 * �� �� ������ String �ν��Ͻ��� �д� ���� �����ϳ� ������ ���� ����. (immutable �ϴ�.)
 * '+' �����ڸ� ���� String�� �����ϴ� ���� ������ �ϰԵǸ� �ν��Ͻ��� �ٲ�� ���� �ƴ϶� ���ο� �ν��Ͻ��� �����ϰ� �ȴ�.
 * ����, ���ڿ��� �ٷ�� �۾��� ���� �ؾ��ϴ� ��쿡�� StringBuffer Ŭ������ ����ϴ� ���� ����.
 * StringBuffer �ν��Ͻ��� �ִ� ���ڿ��� ������ �����ϱ� �����̴�.
 * 
 * */
public class Ex04_StringBasic {

	public static void main(String[] args) {
		
		// ���� �ν��Ͻ��� �����Ѵ�.
		String str1 = "12345";
		String str2 = "12345";
		
		// ���� �ٸ� �ν��Ͻ��� �����Ѵ�.
		String str3 = new String("12345");
		String str4 = new String("12345");

		System.out.println(str1 == str2); // true
		System.out.println(str3 == str4); // false
		
		System.out.println(str1.equals(str2)); // true
		System.out.println(str3.equals(str4)); // true
	}

}
