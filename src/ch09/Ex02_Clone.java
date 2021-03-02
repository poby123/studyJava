package ch09;

/*
 * clone()을 사용하기 위해서는, 먼저 복제할 클래스가 Cloneable 인터페이스를 구현해야하고,
 * clone()을 오버라이딩하면서, 접근 제어자를 public으로 변경해야한다.
 * */
class Point implements Cloneable {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "x = " + x + ", y = " + y;
	}

	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
}

class Ex02_Clone {

	public static void main(String[] args) {
		
		/* 객체의 clone */
		Point p1 = new Point(1, 2);
		Point p2 = (Point) p1.clone();

		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);

		p2.x = 3;
		p2.y = 4;

		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);

		/* 배열의 clone */
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = arr1.clone();

		arr2[arr2.length - 1] = (int) (Math.random() * 10);

		for (int i : arr1) {
			System.out.print(i);
		}
		System.out.println();

		for (int i : arr2) {
			System.out.print(i);
		}
		System.out.println();

	}

}
