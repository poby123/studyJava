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

	/* equals 메서드를 오버라이딩하여, 비교 방법을 지정해준다. */
	boolean equals(AdvancedValue av) {
		return this.value == av.getValue();
	}
}

class Ex01_Equals {

	public static void main(String[] args) {
		/* 1. 기본적인 equals */
		BasicValue val1 = new BasicValue(10);
		BasicValue val2 = new BasicValue(10);

		// 기본적인 Object의 equals 연산은 val1 == val2 와 동일하다.
		// Object에 있어서 == 은 인스턴스의 주소값을 비교한다.
		if (val1.equals(val2)) { 
			System.out.println("val1과 val2는 같습니다.");
		} else {
			System.out.println("val1과 val2는 다릅니다.");
		}

		/* 2. 오버라이딩한 equals */
		AdvancedValue aval1 = new AdvancedValue(7);
		AdvancedValue aval2 = new AdvancedValue(7);

		if (aval1.equals(aval2)) {
			System.out.println("aval1과 aval2는 같습니다.");
		} else {
			System.out.println("aval1과 aval2는 다릅니다.");
		}
	}

}
