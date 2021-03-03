package ch09;

import java.io.UnsupportedEncodingException;
import java.util.StringJoiner;

public class Ex05_StringMethods {

	/*
	 * Split and Join
	 */
	public static void splitAndJoin() {
		System.out.println("======== \n Split and Join example => ");
		String animals = "dog, cat, bear";
		String[] arr = animals.split(", ");

		// 기본적인 join
		String str1 = String.join("-", arr);
		System.out.println(str1);

		// StringJoiner를 이용한 join
		StringJoiner sj = new StringJoiner(",", "[", "]");
		for (String a : arr) {
			sj.add(a);
		}
		System.out.println(sj);
	}

	/*
	 * Encoding
	 */
	public static void joinByteArr() throws UnsupportedEncodingException {
		System.out.println("======== \n String Encoding example => ");
		String str = "가";

		// 문자열을 지정된 형식으로 반환
		byte[] barr = str.getBytes("UTF-8");
		byte[] barr2 = str.getBytes("CP949");

		// byte 배열을 문자열로 저장
		System.out.println(str);
		System.out.println(new String(barr, "UTF-8"));
		System.out.println(new String(barr2, "CP949"));
	}

	/*
	 * Primitive <-> String
	 */
	public static void casting() {
		System.out.println("======== \n Primitve <-> String example => ");
		String ingeger = "107";
		String number = "107.2563";

		// string to int
		int i1 = Integer.parseInt(ingeger);
		int i2 = Integer.valueOf(ingeger);
		System.out.println(i1 + " " + i2);

		// int to String
		System.out.println(String.valueOf(i1));

		// string to double
		double d1 = Double.valueOf(number);
		System.out.println(d1);

		// double to String
		System.out.println(String.valueOf(d1));
	}

	/*
	 * Extract
	 */
	public static void extract() {
		System.out.println("======== \n substring example => ");
		String name = "Hello.java";

		int idx = name.indexOf('.');

		String filename = name.substring(0, idx);
		String ext = name.substring(idx, name.length());

		System.out.println("The fullname is : " + name);
		System.out.println("The filename is : " + filename);
		System.out.println("The extenstion is : " + ext);
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		splitAndJoin();
		joinByteArr();
		casting();
		extract();
	}

}
