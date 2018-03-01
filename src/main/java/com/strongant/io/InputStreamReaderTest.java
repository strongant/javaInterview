package com.strongant.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java IO 适配者与装饰着模式应用
 * 接受一个 InputStream 的 System.in 对象，将之适配成 Reader 对象， 然后使用
 * BufferedReader 进行装饰，BufferedReader 为流提出缓冲的功能
 * InputStreamReader 起到了适配器作用
 * BufferedReader 则起到了装饰模式的作用
 * InputStreamReader 间接持有了 StreamDecoder
 * OutputStreamWriter 类似
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class InputStreamReaderTest {
	public static void main(String[] args) throws IOException {
		String line;
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		System.out.println("enter data : ");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		line = bufferedReader.readLine();
		System.out.println("Data entered: " + line);
	}
}
