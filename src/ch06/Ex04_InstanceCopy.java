package ch06;

import java.time.LocalDateTime;

/*
 * 생성자를 이용한 인스턴스의 복사.
 * */
class MyDate {
	private int year;
	private int month;
	private int date;
	private static LocalDateTime now = LocalDateTime.now();

	MyDate() {
		this(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
	}

	MyDate(int year, int month, int date) throws IllegalArgumentException {
		if (month < 1 || month > 12 || date < 1 || date > 31) {
			throw new IllegalArgumentException();
		}
		this.year = year;
		this.month = month;
		this.date = date;
	}

	MyDate(MyDate md) {
		year = md.year;
		month = md.month;
		date = md.date;
	}

	public String toString() {
		return year + "." + month + "." + date;
	}
}

class Ex04_InstanceCopy {
	public static void main(String[] args) {
		MyDate md = new MyDate();
		MyDate cp = new MyDate(md);
		
		try {
			MyDate ct = new MyDate(2019, 12, 25);
		
			System.out.println(md);
			System.out.println(cp);
			System.out.println(ct);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
