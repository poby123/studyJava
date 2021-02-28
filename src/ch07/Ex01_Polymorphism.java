package ch07;

import java.util.List;

class Ex01_Polymorphism {

	public static void main(String[] args) {

		Tv tv1 = new CaptionTv(); // ���� Ŭ������ ���������� �ڼ� �ν��Ͻ��� ����
		CaptionTv tv2 = new CaptionTv(); // �⺻���� ����.
//		CaptionTv tv3 = new Tv(); // �ڼ� ���������� ���� �ν��Ͻ��� �����ϴ� ���� ������� �ʴ´�. 

		/* Q1. ���� ���������� �ڼ� �ν��Ͻ��� �����ϴ� ���, �ڼտ��� �ִ� ��� ������ ������ �� ������? */
		// A1. �Ұ����ϴ�. �ڼ� �ν��Ͻ����� �ִ� ��� ������, ���� Ŭ������ ���������� ������ �� ����.
//		tv1.text = "tv1"; // �Ұ��� 
		tv2.text = "tv2";

		/* Q2. ���� ���������� �ڼ� �ν��Ͻ��� �����ϴ� ���, ����� �ڼտ� �Ȱ��� �޼��尡 �ִٸ� ��� �ɱ�? */
		// A2. ���� Ÿ������ �ڼ� �ν��Ͻ��� �����ϴ���, �������̵��� �ڽ� �޼��尡 ȣ��ȴ�.
		tv1.getPower(); // in CaptionTv Class, power is : false
		tv2.getPower(); // in CaptionTv Class, power is : false

		/* Q3. ���� ���������� �ڼ� �ν��Ͻ��� �����ϴ� ���, ����� �ڼտ� �Ȱ��� ��� ������ �ִٸ� ��� �ɱ�? */
		// A3. ���� Ÿ������ �����ϸ� ������ ��������� �����ϰ�, �ڼ� Ÿ������ �����ϸ� �ڼ��� ��� ������ �����Ѵ�.
		System.out.println(tv1.common); // Parent
		System.out.println(tv2.common); // Child

		/* ���������� ����ȯ */
		/*
		 * <<< ���ǻ��� >>> 1. ���� ��Ӱ��迡 �ִ� Ŭ�������̿����� �����ϴ�. 2. �ν��Ͻ��� ����ȯ�� �ƴ�, �ν��Ͻ��� �����ϴ�
		 * "���������� ����ȯ�̴�." 3. ���������� ����ȯ�� ����, �����ϰ� �ִ� �ν��Ͻ����� ����� �� �ִ� ����� ���� �����ϴ� ���� ��
		 * �����̴�. 4. �ν��Ͻ��� ��ȯ�ϴ� ���� �ƴϱ� ������, �ν��Ͻ����� �ƹ� ������ ����.
		 */
		Tv cast_t1 = tv2; // �ڼ� ���������� ���� Ÿ������ ����ȯ�� ��(Up-casting)�� ����ȯ�� ������ �� �ִ�.
		CaptionTv cast_t2 = (CaptionTv) tv1; // ���� ���������� �ڼ� Ÿ������ ����ȯ�� ��(Down-casting)�� ����ȯ�� ������ �� ����.

		/*
		 * instanceof ������
		 * 
		 * ���������� �����ϰ� �ִ� �ν��Ͻ��� ���� Ÿ���� �� �� �ִ�. ���ʿ��� ����������, �����ʿ��� Ÿ��(Ŭ���� �̸�)�� ��ġ�Ѵ�.
		 * 
		 * ������ true��, ���������� �˻��� Ÿ������ ����ȯ �� �� ������ �ǹ��Ѵ�.
		 */
		System.out.println(cast_t1 instanceof Tv); // true
		System.out.println(cast_t2 instanceof Tv); // true
		System.out.println(cast_t2 instanceof List); // false

	}

}

// Tv Class
class Tv {
	boolean power = false;
	int channel = 100;
	String common = "Parent"; // ���� �������

	void power() {
		power = !power;
	}

	void channelUp() {
		++channel;
	}

	void channelDown() {
		--channel;
	}

	void getPower() {
		System.out.println("in Tv Class, power is : " + power);
	}
}

// Caption Tv Class
class CaptionTv extends Tv {
	String text;
	String common = "Child"; // ���� �������

	void caption() {
		System.out.println("this is caption method");
	}

	@Override
	void getPower() {
		System.out.println("in CaptionTv Class, power is : " + power);
	}
}
