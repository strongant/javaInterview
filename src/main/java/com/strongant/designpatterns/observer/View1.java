package com.strongant.designpatterns.observer;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class View1 implements Observer {

	private Student student;

	public View1(Student s) {
		this.student = s;
	}

	@Override
	public void update() {
		System.out.println("View1:" + student.getId() + "\t" +  student.getName());
	}
}
