package ch08;

public class Ex02_Multicatch {

	public static void main(String[] args) {

		try {
			throw new IllegalArgumentException("This is IllegalArgument exception.");
//			throw new IllegalStateException("This is IllegalState exception.");
		}

		/* 
		 * IllegalArgumentException �Ǵ� IllegalStateException�� ��� ó���� �� �ִ�.
		 * catch �� ���� ���ܴ� ����-�ڼ� ���谡 �ƴϾ���Ѵ�.
		 * ����-�ڼ� ����� �׳� ���� ���ܸ� ������ �Ǳ� �����̴�.
		*/
		catch (IllegalArgumentException | IllegalStateException ile) {
			System.out.println(ile.getMessage());
		}

	}

}
