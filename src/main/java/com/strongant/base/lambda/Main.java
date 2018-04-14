package com.strongant.base.lambda;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Main {
	public static void main(String[] args) {
		Integer[] sixNums = {1, 2, 3, 4, 5, 6};
		Integer[] evens = Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);
		Arrays.asList(evens).forEach((Integer value) -> System.out.println(value));
	}
}
