package ch07;

/*
 * �������̽��� ��� �޼���� public abstract �̾���ϸ�, �̸� ������ �� �ִ�.(static, default method ����)
 * �������̽��� ��� ��������� public static final �̾���ϸ�, �̸� ������ �� �ִ�. 
 * 
 * �������̽��� ����.
 * 1. ���� �ð��� ����.
 * 2. ǥ��ȭ ����.
 * 3. �ϳ��� �������̽��� ���������� �����ϰ� �����ν�, Ŭ���������� ���踦 ���� �ξ��� �� �ִ�.
 * 4. �������� ���α׷����� ����������. Ŭ������ ����� ������ �и���ų �� �ֱ� �����̴�.
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
	// ���� Ÿ���� �������̽���� ����, �ش� �޼��尡 �� �������̽��� ������ �ν��Ͻ��� ��ȯ�ϴ� ���� �ǹ��Ѵ�.
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
