package ch09;

public class Ex06_StringBuffer {

	public static void basic() {
		/*
		 * StringBuffer 클래스는 내부적으로 버퍼를 가지고 있으며, 기본 크기는 16이다. 만약, 버퍼보다 크게 저장할 필요가 있다면 기존
		 * 버퍼를 버리고, 더 큰 크기의 버퍼를 만든 후 복사한다. 이렇게 되면, 작업 효율이 떨어지므로 문자열의 길이를 고려해서 처음부터 충분히
		 * 잡는 것이 좋다.
		 */
		StringBuffer sb = new StringBuffer(100);
		int c = sb.capacity();
		sb.append("1234").append("5678");
		StringBuffer sb2 = sb.append("910");

		System.out.println(sb == sb2); // true. append()는 기존 인스턴스에 문자열을 추가한 후, 그 인스턴스를 반환한다.
		System.out.println("The capacity is : " + c);
		System.out.println(sb);
		System.out.println(sb.length());
	}

	public static void compare() {
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		String s1 = sb1.toString();
		String s2 = sb2.toString();

		// 기본 StringBuffer는 equals() 가 오버라이드 되어있지 않아서, == 연산을 하는 것과 같다.
		// 따라서 toString()을 통해 String으로 변환한 후, equals() 를 해서 비교해야한다.
		System.out.println(sb1 == sb2); // false
		System.out.println(sb1.equals(sb2)); // false
		System.out.println(s1.equals(s2)); // true
	}

	public static void main(String[] args) {
		basic();
		compare();
	}

}
