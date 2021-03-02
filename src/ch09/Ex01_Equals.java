package ch09;

class BasicValue {

	private int value;

	BasicValue(int value) {
		this.value = value;
	}

	int getValue() {
		return value;
	}
}

class AdvancedValue {
	private int value;

	AdvancedValue(int value) {
		this.value = value;
	}

	int getValue() {
		return value;
	}

	/* equals �޼��带 �������̵��Ͽ�, �� ����� �������ش�. */
	boolean equals(AdvancedValue av) {
		return this.value == av.getValue();
	}
}

class Ex01_Equals {

	public static void main(String[] args) {
		/* 1. �⺻���� equals */
		BasicValue val1 = new BasicValue(10);
		BasicValue val2 = new BasicValue(10);

		// �⺻���� Object�� equals ������ val1 == val2 �� �����ϴ�.
		// Object�� �־ == �� �ν��Ͻ��� �ּҰ��� ���Ѵ�.
		if (val1.equals(val2)) { 
			System.out.println("val1�� val2�� �����ϴ�.");
		} else {
			System.out.println("val1�� val2�� �ٸ��ϴ�.");
		}

		/* 2. �������̵��� equals */
		AdvancedValue aval1 = new AdvancedValue(7);
		AdvancedValue aval2 = new AdvancedValue(7);

		if (aval1.equals(aval2)) {
			System.out.println("aval1�� aval2�� �����ϴ�.");
		} else {
			System.out.println("aval1�� aval2�� �ٸ��ϴ�.");
		}
	}

}
