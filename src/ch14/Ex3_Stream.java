package ch14;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * 스트림의 중간연산.
 * 중간연산은 스트림을 소모시키지 않기 때문에, 새로 스트림을 만들지 않고, 여러 번 사용할 수 있다.
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
		Stream<String> filenameStream = fileStream.map(File::getName); // map을 이용해서 Stream<File> -> Stream<String>
		filenameStream.forEach(System.out::println); // print all

		fileStream = Stream.of(fileArr); // 스트림을 다시 생성
		fileStream
			.map(File::getName) // Stream<File> -> Stream<String>
			.filter(s -> s.indexOf('.') != -1) // 확장자 없는 파일 제외
			.map(s -> s.substring(s.indexOf('.') + 1)) // 확장자만 추출
			.map(String::toUpperCase) // 모두 대문자로 변경
			.distinct() // 중복제거
			.forEach(System.out::print); // 출력 : JAVABAKTXT
		System.out.println();
		System.out.println();
		
		/* flatMap() */
		System.out.println("/* flatMap() */");
		Stream<String[]> strArrStream = Stream.of(
				new String[] {"abc", "def", "ghi"}, 
				new String[]{"ABC","DEF","GHI"}
		);
		// 위 strArrStream을 Stream<String>으로 만드려면??
		// map()을 사용할 때 문제점 -> Stream<String> 이 아닌 Stream<Stream<String>> 이 된다.
//		Stream<Stream<String>> fail = strArrStream.map(Arrays::stream);
		
		// 이러한 경우 flatMap()을 사용하면 Stream<String>으로 만들 수 있다.
		Stream<String> success = strArrStream.flatMap(Arrays::stream);
		success.forEach(System.out::println);
		System.out.println();
		
		/* summaryStatistics() */
		System.out.println("/* summaryStatistics() */");
		Stream<Student> stuStream = Stream.of(stuArr); // array to stream
		stuStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
		
		stuStream = Stream.of(stuArr); // 스트림 재생성
		IntStream stuScoreStream = stuStream.mapToInt(Student::getTotalScore);
		
		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
		System.out.println("count = " + stat.getCount());
		System.out.println("sum = " + stat.getSum());
		System.out.printf("average = %.2f %n", stat.getAverage());
		System.out.println("min = " + stat.getMin());
		System.out.println("max = " + stat.getMax());
	}

}

/* summaryStatistics() 예제를 위한 클래스 */
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
