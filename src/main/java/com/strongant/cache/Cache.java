package com.strongant.cache;

/** 缓存的实体类
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Cache {
	private String key;
	private Object value;
	private Long timeout;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	public Cache() {
	}

	public Cache(String key, Object value, Long timeout) {
		this.key = key;
		this.value = value;
		this.timeout = timeout;
	}
}
