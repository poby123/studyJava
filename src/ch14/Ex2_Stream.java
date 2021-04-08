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
		/* 스트림 예제1 - 스트림 생성 */
		Stream<String> ex1Stream1 = Arrays.stream(strArr);
		Stream<String> ex1Stream2 = strList.stream();

		// 스트림을 이용하면 정렬하고 출력하는 코드를 똑같이 할 수 있다.
		ex1Stream1.sorted().forEach(System.out::print); // aaabbbccc
		System.out.println();
		ex1Stream2.sorted().forEach(System.out::print); // aaabbbccc
		System.out.println();

		// 특징1. 스트림은 소스를 변경하지 않는다.
		strList.forEach(System.out::print); // cccaaabbb, 위에서 sorted를 했다고 해서 정렬이 되지 않는다.
		System.out.println();

		// 특징2. 스트림은 일회용이다.
//		 ex1Stream2.forEach(System.out::print); // IllegalStateException

		/* 스트림 예제2 - 정수 생성 */
		IntStream ex2Stream1 = IntStream.range(0, 5); // 01234
		IntStream ex2Stream2 = IntStream.rangeClosed(0, 5); // 012345

		ex2Stream1 = new Random().ints(0, 10).distinct().limit(5); // 0~9 난수 무한스트림 생성 -> 중복 제거 -> 5개만
		ex2Stream1.forEach(i -> System.out.print(i + " "));
		System.out.println();

		ex2Stream2.filter(x -> x % 2 == 0).forEach(i -> System.out.print(i + " ")); // filter. 0~5중에 짝수인 것만
		System.out.println();

		/* 스트림 예제3 - 람다식 이용하기 [iterate, generate] */
		// 1. iterate() : seed 값부터 시작해서, 람다식에 의해 계산된 결과를 다시 seed값으로 해서 계산을 반복한다.
		Stream<Integer> ex3EvenStream = Stream.iterate(0, n -> n + 2); // <- 무한스트림을 생성한다.
		ex3EvenStream.limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();

		// 2. generate() : iterate() 와는 달리, 이전 결과를 이용해서 다음 요소를 계산하지 않는다.
		Stream<Double> ex3RandomStream = Stream.generate(Math::random); // DoubleStream으로 바꾸려면 아래와 같이 mapToDouble을 이용.
		// DoubleStream ex3RandomDoubleStream =
		// ex3RandomStream.mapToDouble(Double::valueOf);
		ex3RandomStream.limit(5).forEach(i -> System.out.print(String.format("%.2f ", i)));
		System.out.println();

		/* 스트림 예제4 - 빈 스트림과, 스트림의 연결 */
		// 1. 빈 스트림
		Stream<Integer> ex4EmptyStream = Stream.empty(); // null보다 빈 스트림을 반환하는 것이 낫다.
//		System.out.println(ex4EmptyStream == null); // false ?

		// 2. 스트림 연결
		String ex4Str1[] = { "111", "222", "333" };
		String ex4Str2[] = { "444", "555", "666" };

		Stream<String> ex4Stream1 = Stream.of(ex4Str1);
		Stream<String> ex4Stream2 = Stream.of(ex4Str2);
		Stream<String> ex4Stream3 = Stream.concat(ex4Stream1, ex4Stream2);
		ex4Stream3.forEach(s -> System.out.print(s + " ")); // 111 222 333 444 555 666
	}

}
