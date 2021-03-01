package ch08;

public class Ex03_throws {

	public static void err1() {
		err2();
	}

	public static void err2() throws ArithmeticException {
		throw new ArithmeticException("this is arithmetic exception");
	}

	public static void main(String[] args) {

		try {
			err1();
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
			System.out.println(ae.getMessage() + " is handled at main method.");
		}

	}

}
