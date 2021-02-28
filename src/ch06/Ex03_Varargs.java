package ch06;

/*
 * �Լ��� ��������
 * �������ڴ� �Լ��� �Ű����� �� �������� �� �� �ִ�.
 * */
public class Ex03_Varargs {

	public static String concatenate(String delim, String... numbers) {
		String res = "";
		for (int i = 0; i < numbers.length; i++) {
			res += numbers[i];
			if (i != (numbers.length - 1)) {
				res += delim;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] numbers = { "010", "1234", "1234" };
		String res1 = concatenate("-", numbers);
		String res2 = concatenate(" ", numbers);
		System.out.println(res1);
		System.out.println(res2);
	}

}
