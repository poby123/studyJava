package ch07;

/*
 * 인터페이스의 모든 메서드는 public abstract 이어야하며, 이를 생략할 수 있다.(static, default method 제외)
 * 인터페이스의 모든 멤버변수는 public static final 이어야하며, 이를 생략할 수 있다. 
 * 
 * 인터페이스의 장점.
 * 1. 개발 시간의 단축.
 * 2. 표준화 가능.
 * 3. 하나의 인터페이스를 공통적으로 구현하게 함으로써, 클래스끼리의 관계를 쉽게 맺어줄 수 있다.
 * 4. 독립적인 프로그래밍이 가능해진다. 클래스의 선언과 구현을 분리시킬 수 있기 때문이다.
 * */
interface Parseable {
	public abstract void parse(String filename);
}

class XMLParser implements Parseable {
	@Override
	public void parse(String filename) {
		System.out.println(filename + " => XML parsing completed.");

	}
}

class HTMLParser implements Parseable {
	@Override
	public void parse(String filename) {
		System.out.println(filename + " => HTML parsing completed.");

	}
}

class ParserManager {
	// 리턴 타입이 인터페이스라는 것은, 해당 메서드가 그 인터페이스를 구현한 인스턴스를 반환하는 것을 의미한다.
	public static Parseable getParser(String type) {
		if (type.equals("XML")) {
			return new XMLParser();
		} else {
			return new HTMLParser();
		}
	}
}

class Ex02_Interface {

	public static void main(String[] args) {
		ParserManager.getParser("XML").parse("test.xml");;
		ParserManager.getParser("HTML").parse("test.html");;
	}

}
