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
	 * hashCode()�� ������ ���� ������ �����ؾ��Ѵ�.
	 * 1. ���� ���� ���ø����̼ǿ���, ������ ��ü�� ���ؼ� ���� �� hashCode()�� ȣ���ص� ������ ���� ��ȯ�ؾ��Ѵ�.
	 *  (�ٽ� �����ϰų�, ��ü ���� �ٲ� ��쿡�� �ٸ� ���� ��ȯ�ص� �ȴ�.)
	 *  
	 * 2. equals() �޼��带 �̿��� �񱳿� ���ؼ� true�� ��� �� ��ü�� ���� ���� hashCode()�� ȣ���ؼ� ���� ����� 
	 * �ݵ�� ���ƾ��Ѵ�.
	 * 
	 * 3. equals() �޼��带 ȣ������ ��, false�� ��ȯ�ϴ� �� ��ü�� ���� ���� hashCode()�� ȣ���ؼ� ���� ����� 
	 * ���Ƶ� ������, ������ ����� ���ؼ� �ٸ� ���� ��ȯ�ϵ��� �ϴ� ���� ����.
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
		
		set.add(new Person("�Ƿη�", 2));
		set.add(new Person("�Ƿη�", 10));
		set.add(new Person("ũ��", 1));
		set.add(new Person("����", 15));
	
		// hashCode()�� equals()�� �������̵� ���� ������ [�Ƿη�: 2, ����: 15, �Ƿη�: 2, ũ��: 1]
		// �Ȱ��� ���� ������ ��ü�� �ߺ����� ����.
		System.out.println(set);
	}

}
