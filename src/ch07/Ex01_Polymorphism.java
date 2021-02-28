package ch07;

import java.util.List;

class Ex01_Polymorphism {

	public static void main(String[] args) {

		Tv tv1 = new CaptionTv(); // 조상 클래스의 참조변수로 자손 인스턴스를 참조
		CaptionTv tv2 = new CaptionTv(); // 기본적인 참조.
//		CaptionTv tv3 = new Tv(); // 자손 참조변수로 조상 인스턴스를 참조하는 것은 허용하지 않는다. 

		/* Q1. 조상 참조변수로 자손 인스턴스를 참조하는 경우, 자손에만 있는 멤버 변수를 참조할 수 있을까? */
		// A1. 불가능하다. 자손 인스턴스에만 있는 멤버 변수는, 조상 클래스의 참조변수로 참조할 수 없다.
//		tv1.text = "tv1"; // 불가능 
		tv2.text = "tv2";

		/* Q2. 조상 참조변수로 자손 인스턴스를 참조하는 경우, 조상과 자손에 똑같은 메서드가 있다면 어떻게 될까? */
		// A2. 조상 타입으로 자손 인스턴스를 참조하더라도, 오버라이딩된 자식 메서드가 호출된다.
		tv1.getPower(); // in CaptionTv Class, power is : false
		tv2.getPower(); // in CaptionTv Class, power is : false

		/* Q3. 조상 참조변수로 자손 인스턴스를 참조하는 경우, 조상과 자손에 똑같은 멤버 변수가 있다면 어떻게 될까? */
		// A3. 조상 타입으로 참조하면 조상의 멤버변수를 참조하고, 자손 타입으로 참조하면 자손의 멤버 변수를 참조한다.
		System.out.println(tv1.common); // Parent
		System.out.println(tv2.common); // Child

		/* 참조변수의 형변환 */
		/*
		 * <<< 주의사항 >>> 1. 서로 상속관계에 있는 클래스사이에서만 가능하다. 2. 인스턴스의 형변환이 아닌, 인스턴스를 참조하는
		 * "참조변수의 형변환이다." 3. 참조변수의 형변환을 통해, 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 수를 조절하는 것이 주
		 * 목적이다. 4. 인스턴스를 변환하는 것이 아니기 때문에, 인스턴스에는 아무 지장이 없다.
		 */
		Tv cast_t1 = tv2; // 자손 참조변수를 조상 타입으로 형변환할 때(Up-casting)는 형변환을 생략할 수 있다.
		CaptionTv cast_t2 = (CaptionTv) tv1; // 조상 참조변수를 자손 타입으로 형변환할 때(Down-casting)은 형변환을 생략할 수 없다.

		/*
		 * instanceof 연산자
		 * 
		 * 참조변수가 참조하고 있는 인스턴스의 실제 타입을 알 수 있다. 왼쪽에는 참조변수를, 오른쪽에는 타입(클래스 이름)이 위치한다.
		 * 
		 * 연산이 true면, 참조변수를 검사한 타입으로 형변환 할 수 있음을 의미한다.
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
	String common = "Parent"; // 공통 멤버변수

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
	String common = "Child"; // 공통 멤버변수

	void caption() {
		System.out.println("this is caption method");
	}

	@Override
	void getPower() {
		System.out.println("in CaptionTv Class, power is : " + power);
	}
}
