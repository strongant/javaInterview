package com.strongant.jvm.gc;

/**运行时需要添加的参数
 * java -Xms20M -Xmx20M -Xmn10M -XX:+UseParallelGC -XX:+PrintGCDetails
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class FullGCTest {
	public static void main(String[] args) {
		int m = 1024 * 1024;
		byte[] b1 = new byte[2 * m];
		byte[] b2 = new byte[2 * m];
		byte[] b3 = new byte[2 * m];
		byte[] b4 = new byte[2 * m];
		byte[] b5 = new byte[2 * m];
		byte[] b6 = new byte[2 * m];
		byte[] b7 = new byte[2 * m];
		byte[] b8 = new byte[2 * m];

	}
}
