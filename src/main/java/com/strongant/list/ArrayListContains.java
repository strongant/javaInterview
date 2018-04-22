package com.strongant.list;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class ArrayListContains {
	public static void main(String[] args) {
		List<String> elements = Arrays.asList("A","B","C");
		String target = "D";
		if (!elements.contains(target)) {
			System.out.println("not match it");
		}
	}
}
