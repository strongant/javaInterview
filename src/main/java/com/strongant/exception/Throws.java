package com.strongant.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * TODO
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class Throws {

	public static void main(String[] args) {


		//assertTest();

		int result = catchTest();
		System.out.println(result);
	}

	private static int catchTest() {
		int a = 0;
		try {
			// 网络 IO 操作
			File file = new File("/tmp/a.txt");
			FileInputStream fis = new FileInputStream(file);
			int len = 0;
			while ((len = fis.read()) != -1) {
				System.out.print((char)len);
			}
			a = 10;
			return a;
		} catch (IOException e) {
			e.printStackTrace();
			a = 20;
			return a;
		} finally {
			a = 30;
			return a;
		}
	}

	private static void assertTest() {
		String str = null;

		//e.g. com.jk.util.SpringUtils#getBean Assert.notNull(type);
		Throws.notNull(str, "参数不能为空");

		System.out.println("抛出后是否继续执行");
	}

	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}
}
