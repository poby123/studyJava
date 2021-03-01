package ch08;

public class Ex01_Basic {

	public static void main(String[] args) {
		int number = 10;
		int result = 0;

		for (int i = 0; i < 10; i++) {
			try {
				result = number / (int) (Math.random() * 5);
				System.out.println("result : " + result);
				System.out.println("Exception isn't occured.");
			} catch (ArithmeticException ae) {
				ae.printStackTrace();
				System.out.println("Exception is occured. The exception is : " + ae.getMessage());
			}
		}

	}

}
