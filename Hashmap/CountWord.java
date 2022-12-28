package Hashmap;

import java.util.HashMap;

public class CountWord {
	public static void main(String[] args) {

		String str = "My Name is Gibi and I am working in UST for 3 years.Currently I am undergoing Java training";
		String[] split = str.split(" ");

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < split.length; i++) {
		if (map.containsKey(split[i])) {
		int count = map.get(split[i]);
		map.put(split[i], count + 1);
		} else {
		map.put(split[i], 1);
		}
		}
		System.out.println(map);
		}

}
