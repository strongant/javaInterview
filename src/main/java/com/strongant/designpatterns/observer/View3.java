package com.strongant.designpatterns.observer;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class View3 {
	private Student student;

	public View3(Student student) {
		this.student = student;
	}

	public void changeStudent() {
		student.setId(3);
	}
}
