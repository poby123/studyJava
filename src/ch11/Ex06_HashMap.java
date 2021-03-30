package ch11;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Map <- HashMap
 * */
public class Ex06_HashMap {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();

		// put
		map.put("id", "user-id");
		map.put("password", "user-password");
		map.put("name", "user-name");

		// entry set
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> e : entrySet) {
			System.out.print("Key : " + e.getKey());
			System.out.print(", Value : " + e.getValue());
			System.out.println();
		}
		System.out.println("=============================");

		// key set
		Set<String> keySet = map.keySet();
		for (String s : keySet) {
			System.out.println("Key : " + s);
		}
		System.out.println("=============================");

		// value list
		Collection<String> values = map.values();
		for (String s : values) {
			System.out.println("Value : " + s);
		}
		System.out.println("=============================");

		// get by key
		String idValue = map.get("id");
		System.out.println("id value : " + idValue);

		// check contains
		boolean r1 = map.containsKey("id");
		boolean r2 = map.containsValue("user-id");
		System.out.println("r1 : " + r1 + ", r2 : " + r2);
		
	}

}
