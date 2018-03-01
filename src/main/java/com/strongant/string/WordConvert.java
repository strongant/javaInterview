package com.strongant.string;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class WordConvert {

	/**
	 * 将指定的非空字符串进行反转
	 * 比如： 传递 Hello 返回 olleH
	 *
	 * @param content
	 * @return
	 */
	public String reverse(String content) {
		char[] array = content.toCharArray();
		final int len = array.length / 2;
		for (int i = 0; i < len; i++) {
			char temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - i - 1] = temp;
		}
		return String.valueOf(array);
	}

	public String reverseSentence(String sentence) {
		if (null == sentence) {
			return null;
		}
		String reverseSentence = reverse(sentence);
		String mark = " ";
		String[] sentences = reverseSentence.split(mark);
		StringBuffer stringBuffer = new StringBuffer();
		int size = sentences.length;
		for (int i = 0; i < size; i++) {
			if (i != size) {
				stringBuffer.append(reverse(sentences[i]))
						.append(mark);
			}
		}
		return stringBuffer.toString();
	}

}
