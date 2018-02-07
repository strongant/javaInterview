package com.strongant.designpatterns.observer;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class View2 implements Observer {

	private Student student;

	public View2(Student student) {
		this.student = student;
	}
	@Override
	public void update() {
		System.out.println("View2:" + student.getId()+ "\t"  + student.getName());
	}
}
