package ch06;

/*
 * 함수의 가변인자
 * 가변인자는 함수의 매개변수 중 마지막에 올 수 있다.
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
