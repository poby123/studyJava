package ch14;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * ��Ʈ���� �߰�����.
 * �߰������� ��Ʈ���� �Ҹ��Ű�� �ʱ� ������, ���� ��Ʈ���� ������ �ʰ�, ���� �� ����� �� �ִ�.
 * */

public class Ex3_Stream {

	static File[] fileArr = { 
			new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), 
			new File("Ex1"), new File("Ex1.txt") };

	static Student[] stuArr = {
			new Student("Lee", 3, 300),
			new Student("Kim", 1, 200),
			new Student("Ahn", 2, 100),
			new Student("Park", 2, 150),
			new Student("So", 1, 200),
			new Student("Na", 3, 290),
			new Student("Kam", 3, 180),
		};

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		/* map() */
		System.out.println("/* map() */");
		Stream<File> fileStream = Stream.of(fileArr); // Array to stream
		Stream<String> filenameStream = fileStream.map(File::getName); // map�� �̿��ؼ� Stream<File> -> Stream<String>
		filenameStream.forEach(System.out::println); // print all

		fileStream = Stream.of(fileArr); // ��Ʈ���� �ٽ� ����
		fileStream
			.map(File::getName) // Stream<File> -> Stream<String>
			.filter(s -> s.indexOf('.') != -1) // Ȯ���� ���� ���� ����
			.map(s -> s.substring(s.indexOf('.') + 1)) // Ȯ���ڸ� ����
			.map(String::toUpperCase) // ��� �빮�ڷ� ����
			.distinct() // �ߺ�����
			.forEach(System.out::print); // ��� : JAVABAKTXT
		System.out.println();
		System.out.println();
		
		/* flatMap() */
		System.out.println("/* flatMap() */");
		Stream<String[]> strArrStream = Stream.of(
				new String[] {"abc", "def", "ghi"}, 
				new String[]{"ABC","DEF","GHI"}
		);
		// �� strArrStream�� Stream<String>���� �������??
		// map()�� ����� �� ������ -> Stream<String> �� �ƴ� Stream<Stream<String>> �� �ȴ�.
//		Stream<Stream<String>> fail = strArrStream.map(Arrays::stream);
		
		// �̷��� ��� flatMap()�� ����ϸ� Stream<String>���� ���� �� �ִ�.
		Stream<String> success = strArrStream.flatMap(Arrays::stream);
		success.forEach(System.out::println);
		System.out.println();
		
		/* summaryStatistics() */
		System.out.println("/* summaryStatistics() */");
		Stream<Student> stuStream = Stream.of(stuArr); // array to stream
		stuStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
		
		stuStream = Stream.of(stuArr); // ��Ʈ�� �����
		IntStream stuScoreStream = stuStream.mapToInt(Student::getTotalScore);
		
		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
		System.out.println("count = " + stat.getCount());
		System.out.println("sum = " + stat.getSum());
		System.out.printf("average = %.2f %n", stat.getAverage());
		System.out.println("min = " + stat.getMin());
		System.out.println("max = " + stat.getMax());
	}

}

/* summaryStatistics() ������ ���� Ŭ���� */
class Student implements Comparable<Student>{

	String name;
	int ban;
	int totalScore;
	
	Student(String name, int ban, int totalScore){
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
	}
	
	@Override
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
	
	int getBan() {
		return ban;
	}
	
	int getTotalScore() {
		return totalScore;
	}
}
