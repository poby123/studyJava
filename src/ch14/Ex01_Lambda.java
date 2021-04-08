package ch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * ���ٽ��� ��� �����ұ�?
 * => ���ٽ��� �͸� Ŭ������ ��ü�� �����ϸ�, �Լ��� �������̽��� ���� ������ �� �ִ�.
 * �Լ��� �������̽����� �߻� �޼��尡 �� �ϳ��� �־���Ѵ�. �׷��� ���ٽİ� 1:1�� ����� �� �ֱ� �����̴�.
 * (static �޼���� default �޼���� ���� ���� �־ �ȴ�.)
 * */
@FunctionalInterface
interface MyFunction {
	public abstract int max(int a, int b);
}

/*
  �ڹٿ��� �̹� �������� �Լ��� �������̽���. �����ϸ�, �̹� �������� �͵��� ������ ����.��� 
  A. ���� �⺻���� �Լ��� �������̽�
    1. java.lang.Runnable // void run()        // �Ű�����x, ��ȯ��x 
    2. Supplier<T>        // T get()           // �Ű�����x, ��ȯ��O 
    3. Consumer<T>        // void accept(T t)  // �Ű�����o, ��ȯ��x 
    4. Function<T, R>     // R apply(T t)      // �Ű�����o, ��ȯ��o <- �Ϲ����� �Լ� 
    5. Predicate<T>       // boolean test(T t) // �Ű�����o, ��ȯ��o <- ���ǽ��� ���ٷ� ǥ��.
  
  B. �Ű������� 2���� �Լ��� �������̽� 
    1. BiConsumer<T, U>    // void accept(T t, U u) 
    2. BiPredicate<T, U>   // boolean test(T t, U u) 
    3. BiFunction<T, U, R> // R apply(T t, U u)
  
  C. Function�� ���� 
    1. UnaryOperator<T>    // T apply(T t)      // Function�� �޸�, �Ű������� Ÿ�԰� ��ȯ Ÿ���� ����. 
    2. BinaryOperator<T>   // T apply(T t, T t) // BiFunction�� �޸�, �Ű������� Ÿ�԰� ��ȯ Ÿ���� ����.
 */

public class Ex01_Lambda {
	// ����Ʈ�� ��� ��Ҹ� ����ϴ� ���ٽ�
	static Consumer<List<?>> printAll = (l) -> l.forEach(i -> System.out.print(i + " "));

	
	
	public static void main(String[] args) {
		/* ���ٽ� ����1 */
		System.out.println("/* Part1 */");
		MyFunction maxF = (a, b) -> a > b ? a : b; // ���ٽ��� �������̽��� ����
		
		System.out.println("Max : " + maxF.max(3, 5)); // ȣ��
		System.out.println();

		/* ���ٽ� ����2 */
		System.out.println("/* Part2 */");
		ArrayList<Integer> b2l = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		printAll.accept(b2l);
		System.out.println();
		
		b2l.removeIf(i -> i % 2 == 0); // 2�� ��� ����
		printAll.accept(b2l);
		System.out.println();

		b2l.replaceAll(i -> i * 2); // 2�辿 ����
		printAll.accept(b2l);
		System.out.println();
		
		/* Function �ռ� */
		System.out.println("Function --- ");
		Function<Integer, String> binaryG = i -> Integer.toBinaryString(i); // Integer -> String
		Function<String, Integer> parseF = s -> Integer.parseInt(s, 16); // String -> Integer
		
		Function<String, String> h1 = parseF.andThen(binaryG); // f�� ���� �����ϰ�, g�� ����
		Function<Integer, Integer> h2 = parseF.compose(binaryG); // g�� ���� �����ϰ�, f�� ����
		
		System.out.println(h1.apply("1A"));
		System.out.println(h2.apply(26));
		System.out.println();
		
		/* Predicate �ռ� */
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
