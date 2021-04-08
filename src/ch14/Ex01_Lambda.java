package ch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * 람다식은 어떻게 참조할까?
 * => 람다식은 익명 클래스의 객체와 동등하며, 함수형 인터페이스를 통해 참조할 수 있다.
 * 함수형 인터페이스에는 추상 메서드가 단 하나만 있어야한다. 그래야 람다식과 1:1로 연결될 수 있기 때문이다.
 * (static 메서드와 default 메서드는 여러 개가 있어도 된다.)
 * */
@FunctionalInterface
interface MyFunction {
	public abstract int max(int a, int b);
}

/*
  자바에서 이미 만들어놓은 함수형 인터페이스들. 가능하면, 이미 만들어놓은 것들을 쓰도록 하자.↓↓ 
  A. 가장 기본적인 함수형 인터페이스
    1. java.lang.Runnable // void run()        // 매개변수x, 반환값x 
    2. Supplier<T>        // T get()           // 매개변수x, 반환값O 
    3. Consumer<T>        // void accept(T t)  // 매개변수o, 반환값x 
    4. Function<T, R>     // R apply(T t)      // 매개변수o, 반환값o <- 일반적인 함수 
    5. Predicate<T>       // boolean test(T t) // 매개변수o, 반환값o <- 조건식을 람다로 표현.
  
  B. 매개변수가 2개인 함수형 인터페이스 
    1. BiConsumer<T, U>    // void accept(T t, U u) 
    2. BiPredicate<T, U>   // boolean test(T t, U u) 
    3. BiFunction<T, U, R> // R apply(T t, U u)
  
  C. Function의 변형 
    1. UnaryOperator<T>    // T apply(T t)      // Function과 달리, 매개변수의 타입과 반환 타입이 같다. 
    2. BinaryOperator<T>   // T apply(T t, T t) // BiFunction과 달리, 매개변수의 타입과 반환 타입이 같다.
 */

public class Ex01_Lambda {
	// 리스트의 모든 요소를 출력하는 람다식
	static Consumer<List<?>> printAll = (l) -> l.forEach(i -> System.out.print(i + " "));

	
	
	public static void main(String[] args) {
		/* 람다식 기초1 */
		System.out.println("/* Part1 */");
		MyFunction maxF = (a, b) -> a > b ? a : b; // 람다식을 인터페이스로 참조
		
		System.out.println("Max : " + maxF.max(3, 5)); // 호출
		System.out.println();

		/* 람다식 기초2 */
		System.out.println("/* Part2 */");
		ArrayList<Integer> b2l = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		printAll.accept(b2l);
		System.out.println();
		
		b2l.removeIf(i -> i % 2 == 0); // 2의 배수 삭제
		printAll.accept(b2l);
		System.out.println();

		b2l.replaceAll(i -> i * 2); // 2배씩 증가
		printAll.accept(b2l);
		System.out.println();
		
		/* Function 합성 */
		System.out.println("Function --- ");
		Function<Integer, String> binaryG = i -> Integer.toBinaryString(i); // Integer -> String
		Function<String, Integer> parseF = s -> Integer.parseInt(s, 16); // String -> Integer
		
		Function<String, String> h1 = parseF.andThen(binaryG); // f를 먼저 적용하고, g를 적용
		Function<Integer, Integer> h2 = parseF.compose(binaryG); // g를 먼저 적용하고, f를 적용
		
		System.out.println(h1.apply("1A"));
		System.out.println(h2.apply(26));
		System.out.println();
		
		/* Predicate 합성 */
		System.out.println("Predicate --- ");
		Predicate<Integer> isPlus = i -> i > 0;
		Predicate<Integer> isEven = i -> i % 2 == 0;
		Predicate<Integer> isPlusAndEven = isPlus.and(isEven);
		Predicate<Integer> isMinusAndOdd = isPlusAndEven.negate();
		
		System.out.println("-2 is plus : " + isPlus.test(-1));
		System.out.println("-3 is minus and odd : " + isMinusAndOdd.test(-3));
		System.out.println("16 is plus And Even : " + isPlusAndEven.test(16));

	}
}
