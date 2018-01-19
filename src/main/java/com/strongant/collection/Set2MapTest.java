package com.strongant.collection;

/**
 * 对自定义Map测试
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class Set2MapTest {

	public static void main(String[] args) {
		Set2Map<String, Integer> scoresMap = new Set2Map<>();

		// 将Key, Value放入集合
		scoresMap.put("语文", 100);
		scoresMap.put("英语", 90);
		scoresMap.put("数学", 80);

		System.out.println(scoresMap);

		// 访问Map大小
		System.out.println(scoresMap.size());

		// 删除数学
		scoresMap.removeEntry("数学");

		System.out.println(scoresMap);

		// 根据Key 取出对应的Value
		System.out.println(scoresMap.get("语文"));
	}
}
