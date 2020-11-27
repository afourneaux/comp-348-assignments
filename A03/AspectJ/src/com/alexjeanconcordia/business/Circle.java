package com.alexjeanconcordia.business;

public class Circle {
	
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * this.radius;
	}
	
	public double getArea() {
		throw new RuntimeException("Oops, I don't know how to calculate this :(");
	}

}
