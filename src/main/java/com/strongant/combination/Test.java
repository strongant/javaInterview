package com.strongant.combination;

import java.util.*;

/** Java并发编程实战  组合章节测试
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Test {

	public static void main(String[] args) {
		List<String> list = Collections.synchronizedList(new ArrayList<String>());

	}
}

final class Counter {
	private long value = 0;

	public synchronized  long getValue() {
		return value;
	}

	public synchronized long increment() {
		if (value == Long.MAX_VALUE) {
			throw new RuntimeException("counter overflow");
		}
		return ++value;
	}
}

class PersonSet {
	private final Set<Person> personSet = new HashSet<>();

	public synchronized void addPerson (Person person) {
		this.personSet.add(person);
	}

	public synchronized boolean containsPerson(Person person) {
		return this.personSet.contains(person);
	}
}


class Person {
	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}

/**
 * 私有锁保护
 */
class PrivateLock {
	private final Object myLock = new Object();

	Person person;

	void someMethod() {
		synchronized (myLock) {
			//
		}
	}
}

/**
 * 同步锁助手
 */
class ListHelper<E> {
	public List<E> list = Collections.synchronizedList(new ArrayList<E>());

	public boolean putIfAbsent(E e) {
		synchronized (list) {
			boolean absent = !list.contains(e);
			if (absent) {
				list.add(e);
			}
			return absent;
		}
	}
}
