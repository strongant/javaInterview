package com.strongant.base.map;

/** 用于存放自定义 Map 中存放的元素
 *  用在链表中桶的冲突的处理，如果多个键值对有相同的 hashcode 但是有不同的 key，
 *  使用指针 "next"
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Entry {
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
