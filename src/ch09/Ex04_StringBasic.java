package ch09;

/*
 * - String 을 다루는 2가지 방법
 * 1. String str = "abc"
 * 문자열 리터럴을 사용하는 방법은 이미 존재하는 인스턴스를 단순히 참조하여 사용하는 것이다.
 * 문자열 리터럴은 클래스가 메모리에 로드될 때 자동적으로 미리 생성되기 때문이다.
 * (추가 : 모든 문자열 리터럴은 컴파일 시에 클래스 파일에 저장되며, 같은 내용의 문자열 리터럴은 한 개만 저장된다.
 * 클래스 파일이 메모리에 로드될 때, 리터럴 목록에 있는 모든 리터럴들은 JVM 내부의 상수 저장소(constant pool)에 저장된다.) 
 * 
 * 2. String str = new String("abc")
 * String 클래스의 생성자를 이용하는 방법은, 항상 새로운 String 인스턴스를 생성한다.
 * 
 * - String 인스턴스의 특징
 * 한 번 생성된 String 인스턴스는 읽는 것은 가능하나 수정할 수는 없다. (immutable 하다.)
 * '+' 연산자를 통해 String을 결합하는 등의 동작을 하게되면 인스턴스가 바뀌는 것이 아니라 새로운 인스턴스를 생성하게 된다.
 * 따라서, 문자열을 다루는 작업을 많이 해야하는 경우에는 StringBuffer 클래스를 사용하는 것이 좋다.
 * StringBuffer 인스턴스에 있는 문자열은 변경이 가능하기 때문이다.
 * 
 * */
public class Ex04_StringBasic {

	public static void main(String[] args) {
		
		// 같은 인스턴스를 참조한다.
		String str1 = "12345";
		String str2 = "12345";
		
		// 각각 다른 인스턴스를 참조한다.
		String str3 = new String("12345");
		String str4 = new String("12345");

		System.out.println(str1 == str2); // true
		System.out.println(str3 == str4); // false
		
		System.out.println(str1.equals(str2)); // true
		System.out.println(str3.equals(str4)); // true
	}

}
