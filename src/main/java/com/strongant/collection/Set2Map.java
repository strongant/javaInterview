package com.strongant.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 用HashSet实现一个Map
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class Set2Map<K, V> extends HashSet<SimpleEntry<K, V>> {

	// 实现所有清空Key Value对的方法
	public void clear() {
		super.clear();
	}

	// 判断是否包含某个Key
	public boolean containsKey(Object k) {
		return super.contains(new SimpleEntry(k, null));
	}

	// 判断是否包含某个value
	boolean containsValue(Object value) {
		for (SimpleEntry<K, V> se : this) {
			if (se.getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

	// 根据指定的key取出对应的value
	public V get(Object key) {
		for (SimpleEntry<K, V> se : this) {
			if (se.getKey().equals(key)) {
				return se.getValue();
			}
		}
		return null;
	}

	// 将指定的key-value 对放入集合中
	public V put(K key, V value) {
		add(new SimpleEntry<K, V>(key, value));
		return value;
	}

	// 将另一个Map中的Key Value对放入到该Map中
	public void putAll(Map<? extends K, ? extends V> map) {
		for (K k : map.keySet()) {
			add(new SimpleEntry<K, V>(k, map.get(k)));
		}
	}

	// 根据Key 删除指定Entry
	public V removeEntry(Object key) {
		for (Iterator<SimpleEntry<K, V>> it = this.iterator(); it.hasNext(); ) {
			SimpleEntry<K, V> simpleEntry = it.next();
			if (simpleEntry.getKey().equals(key)) {
				V v = simpleEntry.getValue();
				it.remove();
				return v;
			}
		}
		return null;
	}

	// 获取该Map中包含多少个Key Value对
	public int size() {
		return super.size();
	}




}
