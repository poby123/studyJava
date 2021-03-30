package ch11;

import java.util.HashSet;
import java.util.Objects;

/*
 * Collection <- Set <- HashSet
 * */

class Person{
	String name;
	int age;

	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name + ": " + age;
	}
	
	/*
	 * hashCode()는 다음과 같은 조건을 만족해야한다.
	 * 1. 실행 중인 애플리케이션에서, 동일한 객체에 대해서 여러 번 hashCode()를 호출해도 동일한 값을 반환해야한다.
	 *  (다시 실행하거나, 객체 값이 바뀐 경우에는 다른 값을 반환해도 된다.)
	 *  
	 * 2. equals() 메서드를 이용한 비교에 의해서 true를 얻는 두 객체에 대해 각각 hashCode()를 호출해서 얻은 결과는 
	 * 반드시 같아야한다.
	 * 
	 * 3. equals() 메서드를 호출했을 때, false를 반환하는 두 객체에 대해 각각 hashCode()를 호출해서 얻은 결과는 
	 * 같아도 되지만, 성능의 향상을 위해서 다른 값을 반환하도록 하는 것이 좋다.
	 * */
	public int hashCode() {
		return Objects.hash(name + age);
	}
	
	public boolean equals(Object o) {
		if(o instanceof Person) {
			Person p = (Person)o;
			return this.name.equals(p.name) && this.age == p.age;
		}
		return false;
	}
}

public class Ex05_HashSet {

	public static void main(String[] args) {
		HashSet<Person> set = new HashSet<>();
		
		set.add(new Person("뽀로로", 2));
		set.add(new Person("뽀로로", 10));
		set.add(new Person("크롱", 1));
		set.add(new Person("포비", 15));
	
		// hashCode()와 equals()를 오버라이딩 하지 않으면 [뽀로로: 2, 포비: 15, 뽀로로: 2, 크롱: 1]
		// 똑같은 값을 가지는 객체가 중복으로 들어간다.
		System.out.println(set);
	}

}
