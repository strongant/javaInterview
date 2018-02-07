package com.strongant.designpatterns.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public abstract class Subject {
	private List<Observer> observers = new LinkedList<>();

	protected void notifyObserver() {
		for (Observer observer: observers) {
			observer.update();
		}
	}

	public void register(Observer observer) {
		observers.add(observer);
	}

	public void remove(Observer observer) {
		observers.remove(observer);
	}
}
