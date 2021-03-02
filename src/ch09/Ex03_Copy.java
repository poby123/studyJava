package ch09;

class Point3 {
	int x, y;

	Point3(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

class Circle implements Cloneable {
	Point3 p; // ����
	double radius;

	Circle(Point3 p, double radius) {
		this.p = p;
		this.radius = radius;
	}

	/* ���� ����. Point �ν��Ͻ��� �ּҸ� ����ȴ�. ���� ������ �ν��Ͻ��� ���� �ν��Ͻ� ��� ���� Point �ν��Ͻ��� ����Ų��.*/
	public Circle shallowCopy() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Circle) obj;
	}

	/* ���� ����. Point �ν��Ͻ��� ���� �����ϵ�, ���� �� �Ȱ��� ������ش�.
	 * ������ �ν��Ͻ��� ���� �ν��Ͻ��� ���� �ٸ� Point �ν��Ͻ��� ������.
	 * */
	public Circle deepCopy() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		Circle c = (Circle) obj;
		c.p = new Point3(this.p.x, this.p.y);

		return c;
	}

	@Override
	public String toString() {
		return "[p=" + p + ", r=" + radius + "]";
	}
}

class Ex03_Copy {

	public static void main(String[] args) {
		Circle c1 = new Circle(new Point3(1, 1), 2.0);
		Circle c2 = c1.shallowCopy();
		Circle c3 = c1.deepCopy();
		
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		System.out.println("c3 : " + c3);
		
		c1.p.x = 9;
		c1.p.y = 10;
		
		System.out.println("After c1 is changed =>");
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		System.out.println("c3 : " + c3);
	}

}
