package com.strongant.collection;

import java.util.Map;

/**
 * TODO
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class SimpleEntry<K, V> implements Map.Entry<K, V>, java.io.Serializable {

	private final K k;

	private V value;

	public K getKey() {
		return k;
	}

	public V getValue() {
		return value;
	}

	public SimpleEntry(K k, V value) {
		this.k = k;
		this.value = value;
	}

	public SimpleEntry(Map.Entry<? extends K, ? extends V> entry) {
		this.k = entry.getKey();
		this.value = entry.getValue();
	}

	@Override
	public V setValue(V value) {
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	/**
	 * 根据key 比较两个SimpleEntry 是否相等
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {

		if ( obj == this) {
			return true;
		}

		if ( obj.getClass() == SimpleEntry.class) {
			SimpleEntry simpleEntry = (SimpleEntry)obj;
			return simpleEntry.getKey().equals(getKey());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return k == null ? 0 : k.hashCode();
	}

	public String toString() {
		return k + "=" + value;
	}
}
