package ch06;

/*
 * �⺻��(primitive type) �Ű������� ������(reference type) �Ű�����
 * �Ű������� �⺻���� ���� ���� ���������, �������� ���� �ν��Ͻ��� �ּҰ� ����ȴ�.
 * */
class Val {

	private int x;

	public Val(int x) {
		this.x = x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public String toString() {
		return Integer.toString(x);
	}
}

class Ex02_CallByX {

	public static void change(int a, int b) {
		a += 3;
		b += 2;
	}

	public static void change(String a, String b) {
		a += "3";
		b += "2";
	}

	public static void change(Val x) {
		x.setX((int) (Math.random() * 100));
	}

	public static void change(int[] x) {
		for (int i = 0; i < x.length; i++) {
			x[i] += i;
		}
	}

	public static void intTest() {
		int a = 3;
		int b = 4;
		change(a, b);
		System.out.println("int test => a : " + a + ", b : " + b);
	}

	public static void stringTest() {
		String a = "3";
		String b = "4";
		change(a, b);
		System.out.println("string test => a : " + a + ", b : " + b);
	}

	public static void arrayTest() {
		int[] a = { 1, 2, 3, 4, 5 };
		change(a);

		System.out.print("array test => a : ");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void objectTest() {
		Val a = new Val(1);
		change(a);
		System.out.println("object test => a : " + a);
	}

	public static void main(String[] args) {
		
		// primitive type
		intTest();
		stringTest();
		
		// reference type
		objectTest();
		arrayTest();
	}

}
