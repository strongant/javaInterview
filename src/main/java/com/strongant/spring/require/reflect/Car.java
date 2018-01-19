package com.strongant.spring.require.reflect;

/**
 * 练习Java反射的实体
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Car {

	private String brand;
	private String color;
	private int maxSpeed;

	public void introduce() {
		System.out.printf("brand: %s, color: %s, maxSpeed: %d" , brand, color, maxSpeed);
	}

	public Car() {
	}

	public Car(String brand, String color, int maxSpeed) {
		this.brand = brand;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	public Car(String brand, String color) {
		this.brand = brand;
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
}
