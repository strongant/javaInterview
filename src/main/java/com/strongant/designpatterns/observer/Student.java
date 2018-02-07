package com.strongant.designpatterns.observer;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Student extends Subject {
	private int id;
	private String name;
	private String birth;

	public Student() {}

	public Student(int id, String name, String birth) {

		this.id = id;
		this.name = name;
		this.birth = birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		notifyObserver();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyObserver();
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
		notifyObserver();
	}
}
