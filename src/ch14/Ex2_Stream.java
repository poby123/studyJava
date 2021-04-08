package ch14;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2_Stream {

	static String[] strArr = { "ccc", "aaa", "bbb" };
	static List<String> strList = Arrays.asList(strArr);

	public static void main(String[] args) throws Exception {
		/* ��Ʈ�� ����1 - ��Ʈ�� ���� */
		Stream<String> ex1Stream1 = Arrays.stream(strArr);
		Stream<String> ex1Stream2 = strList.stream();

		// ��Ʈ���� �̿��ϸ� �����ϰ� ����ϴ� �ڵ带 �Ȱ��� �� �� �ִ�.
		ex1Stream1.sorted().forEach(System.out::print); // aaabbbccc
		System.out.println();
		ex1Stream2.sorted().forEach(System.out::print); // aaabbbccc
		System.out.println();

		// Ư¡1. ��Ʈ���� �ҽ��� �������� �ʴ´�.
		strList.forEach(System.out::print); // cccaaabbb, ������ sorted�� �ߴٰ� �ؼ� ������ ���� �ʴ´�.
		System.out.println();

		// Ư¡2. ��Ʈ���� ��ȸ���̴�.
//		 ex1Stream2.forEach(System.out::print); // IllegalStateException

		/* ��Ʈ�� ����2 - ���� ���� */
		IntStream ex2Stream1 = IntStream.range(0, 5); // 01234
		IntStream ex2Stream2 = IntStream.rangeClosed(0, 5); // 012345

		ex2Stream1 = new Random().ints(0, 10).distinct().limit(5); // 0~9 ���� ���ѽ�Ʈ�� ���� -> �ߺ� ���� -> 5����
		ex2Stream1.forEach(i -> System.out.print(i + " "));
		System.out.println();

		ex2Stream2.filter(x -> x % 2 == 0).forEach(i -> System.out.print(i + " ")); // filter. 0~5�߿� ¦���� �͸�
		System.out.println();

		/* ��Ʈ�� ����3 - ���ٽ� �̿��ϱ� [iterate, generate] */
		// 1. iterate() : seed ������ �����ؼ�, ���ٽĿ� ���� ���� ����� �ٽ� seed������ �ؼ� ����� �ݺ��Ѵ�.
		Stream<Integer> ex3EvenStream = Stream.iterate(0, n -> n + 2); // <- ���ѽ�Ʈ���� �����Ѵ�.
		ex3EvenStream.limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();

		// 2. generate() : iterate() �ʹ� �޸�, ���� ����� �̿��ؼ� ���� ��Ҹ� ������� �ʴ´�.
		Stream<Double> ex3RandomStream = Stream.generate(Math::random); // DoubleStream���� �ٲٷ��� �Ʒ��� ���� mapToDouble�� �̿�.
		// DoubleStream ex3RandomDoubleStream =
		// ex3RandomStream.mapToDouble(Double::valueOf);
		ex3RandomStream.limit(5).forEach(i -> System.out.print(String.format("%.2f ", i)));
		System.out.println();

		/* ��Ʈ�� ����4 - �� ��Ʈ����, ��Ʈ���� ���� */
		// 1. �� ��Ʈ��
		Stream<Integer> ex4EmptyStream = Stream.empty(); // null���� �� ��Ʈ���� ��ȯ�ϴ� ���� ����.
//		System.out.println(ex4EmptyStream == null); // false ?

		// 2. ��Ʈ�� ����
		String ex4Str1[] = { "111", "222", "333" };
		String ex4Str2[] = { "444", "555", "666" };

		Stream<String> ex4Stream1 = Stream.of(ex4Str1);
		Stream<String> ex4Stream2 = Stream.of(ex4Str2);
		Stream<String> ex4Stream3 = Stream.concat(ex4Stream1, ex4Stream2);
		ex4Stream3.forEach(s -> System.out.print(s + " ")); // 111 222 333 444 555 666
	}

}
