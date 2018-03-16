package com.strongant.base.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class CustomHashMapTest {
	public static void main(String[] args) {
		CustomHashMap customHashMap = new CustomHashMap();
		Map<String, String> map = new HashMap<>();

		long customMapStart = System.currentTimeMillis();

		customHashMap.put("a", "a");
		customHashMap.put("b", "b");
		customHashMap.put("c", "c");
		customHashMap.put("d", "d");
		customHashMap.put("e", "e");
		customHashMap.put("f", "f");
		customHashMap.put("g", "g");
		customHashMap.put("h", "h");
		customHashMap.put("i", "i");
		customHashMap.put("j", "j");
		customHashMap.put("k", "k");
		customHashMap.put("l", "l");
		customHashMap.put("m", "m");
		customHashMap.put("n", "n");
		customHashMap.put("o", "o");
		customHashMap.put("p", "p");
		customHashMap.put("q", "q");
		customHashMap.put("r", "r");
		customHashMap.put("s", "s");
		customHashMap.put("t", "t");
		customHashMap.put("u", "u");
		customHashMap.put("v", "v");
		customHashMap.put("w", "w");
		customHashMap.put("x", "x");
		customHashMap.put("y", "y");
		customHashMap.put("z", "z");

		map.put("a", "a");
		map.put("b", "a");
		map.put("c", "a");
		map.put("d", "a");
		map.put("e", "a");
		map.put("f", "a");
		map.put("g", "a");
		map.put("h", "a");
		map.put("i", "a");
		map.put("j", "a");
		map.put("k", "a");
		map.put("l", "a");
		map.put("m", "a");
		map.put("n", "a");
		map.put("o", "a");
		map.put("p", "a");
		map.put("q", "a");
		map.put("r", "a");
		map.put("s", "a");
		map.put("t", "a");
		map.put("u", "a");
		map.put("v", "a");
		map.put("w", "a");
		map.put("x", "a");
		map.put("y", "a");
		map.put("z", "a");

		long customMapEnd = System.currentTimeMillis();
		long customDiff = customMapEnd - customMapStart;
		System.out.println("自定义 HashMap 存放消耗时间：" + customDiff);
		//设置开始时间
		long startTime = System.nanoTime();
		int size = 97 + 26;
		CustomHashMap.Entry entry = null;
		/*for (int i = 97; i < size; i++) {
			entry = customHashMap.get(String.valueOf((char) i));
			if (null != entry) {
				System.out.println(entry.getValue());
			}
		}*/
		entry = customHashMap.get("a");
		while (entry != null) {
			System.out.println(entry.getValue());
			entry = entry.next;
		}

		//设置结束时间
		/*long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("自己实现的HashMap " + duration);

		//设置开始时间
		startTime = System.nanoTime();
		String mapResult = (String) map.get("a");
		//设置结束时间
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("原有的java.util.HashMap " + duration);*/
		//System.out.println("原有的java.util.HashMap取值： "+mapResult);


	}
}
