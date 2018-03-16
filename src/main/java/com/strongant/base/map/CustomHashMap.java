package com.strongant.base.map;

import java.util.Map;

/**
 * 自定义实现 HashMap
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class CustomHashMap {
	private final static int SIZE = 16;
	private Entry[] table = new Entry[SIZE];


	class Entry {
		String key;
		String value;
		Entry next;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Entry(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	/**
	 * 根据指定的 key 查找对应的 value
	 *
	 * @param key
	 * @return
	 */
	public Entry get(String key) {
		int hash = key.hashCode() % SIZE;
		Entry e = table[hash];

		// 如果找到对应的桶，则沿着链表查找 key 对应的 value
		while (e != null) {
			if (e.key.equals(key)) {
				return e;
			}
			e = e.next;
		}

		return null;
	}

	/**
	 * 在 map 中将特定的 key 和 value 关联起来。
	 * 如果包含了相同的 key，原来的旧值将会被替换掉
	 */
	public void put(String key, String value) {
		int hash = key.hashCode() % SIZE;
		Entry e = table[hash];
		if (e != null) {
			// 检查是否有相同的 key， 如果有则新值代替旧值
			while (e.next != null) {
				if (e.key.equals(key)) {
					e.value = value;
					return;
				}
				e = e.next;
			}
			// 在链表的末尾添加新元素
			Entry entryInOldBucket = new Entry(key, value);
			e.next = entryInOldBucket;
		} else {
			// 建立一个新桶
			Entry entryInNewBucket = new Entry(key, value);
			table[hash] = entryInNewBucket;
		}

	}
}
