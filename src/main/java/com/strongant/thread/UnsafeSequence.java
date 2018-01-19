package com.strongant.thread;

import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class UnsafeSequence {
	private int value;

	public synchronized int getNext() {
		return value++;
	}

	public static void main(String[] args) throws InterruptedException {
		/*UnsafeSequence unsafeSequence = new UnsafeSequence();

		Set<Integer> collections = new HashSet<>();

		int maxSize = 100000;
		for (int i = 0; i < maxSize; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					int result = unsafeSequence.getNext();
					collections.add(result);
					System.out.printf("result： %s \n", result);
				}
			});
			thread.start();
			//thread.join();
		}
		System.out.println("collections maxSize = " + collections.size());*/
		/*((NULL)null).haha();
		float max = Float.MAX_VALUE;
		float min = Float.MIN_VALUE;

		System.out.println(max);
		System.out.println(min);*/

		/*String str1 = "hello";
		String str2 = "he" + new String("llo");
		System.out.println(str1 == str2);*/

		/*BufferedWriter bf = new BufferedWriter(new FileWriter("a.txt"));
		bf.write("aaa");
		bf.close();*/

		/*new BufferedReader(new FileInputStream("a.txt"));*/

		/*Map<String, String> map = new HashMap<>();
		map.put(null, null);
		System.out.println(map);*/

		/*try {
			FileReader fr = new FileReader(new File("b.txt"));
			int line;
			while ((line = fr.read()) != -1) {
				System.out.println(line);
			}
		} catch (java.io.FileNotFoundException e) {
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}*/

		String str = "药 ABC13网 7GMNQQ2049PN5FFF";
		str=str.trim();
		findNumbers(str);
		findChineseWords(str);
		String a = null;
		int b = 0;
		System.out.println("a = " + a);
		System.out.println("b = " + b);

		// 整型
		System.out.println("Byte Byte's Size : " + Byte.BYTES);
		System.out.println("Short Byte's Size : " + Short.BYTES);
		System.out.println("Integer Byte's Size : " + Integer.BYTES);
		System.out.println("Long Byte's Size : " + Long.BYTES);

		// 浮点型
		System.out.println("Float Byte's Size : " + Float.BYTES);
		System.out.println("Double Byte's Size : " + Double.BYTES);
		// 逻辑型 1/8
		System.out.println("Boolean Byte's Size : " + Boolean.class);
		// 字符型
		System.out.println("Character Byte's Size : " + Character.BYTES);





	}

	private static void findNumbers(String str) {
		List<Integer> target= new ArrayList<>();
		if(str != null && !"".equals(str)){
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)>=48 && str.charAt(i)<=57){
					target.add(Integer.parseInt(String.valueOf(str.charAt(i))));
				}
			}

		}
		Collections.sort(target);
		System.out.println(target);
	}

	private static void findChineseWords(String str) {
		String regex = "[^\u4E00-\u9FA5]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		String strs  = matcher.replaceAll("");
		System.out.println(strs);
	}

}

class NULL {
	public static void haha() {
		System.out.println("haha");
	}
}