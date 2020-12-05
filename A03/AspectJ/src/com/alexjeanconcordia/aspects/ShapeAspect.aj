package com.alexjeanconcordia.aspects;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.alexjeanconcordia.business.*;
import com.alexjeanconcordia.interfaces.*;

public privileged aspect ShapeAspect {
	
	//Question 4
	declare parents: Circle implements Shape;
    declare parents: Rectangle implements Shape;

    public String Circle.getName() {
    	return "Circle";
    }
    
    public String Rectangle.getName() {
    	return "Rectangle";
    }
    
    //Question 5
    public String Circle.toString() {
    	DecimalFormat df = new DecimalFormat("#.########");
    	df.setRoundingMode(RoundingMode.CEILING);
    	return this.getName() + "(" + df.format(this.radius) + ") ";
    }
    
    public String Rectangle.toString() {
    	DecimalFormat df = new DecimalFormat("#.########");
    	df.setRoundingMode(RoundingMode.CEILING);
    	return this.getName() + "(" + df.format(this.width) + ", " + df.format(this.height) + ") ";
    }
    
    //Question 7
    pointcut getRectangle(Rectangle r) : execution(double Rectangle.get*()) && this(r);
    pointcut getCircle(Circle c) : execution(double Circle.get*()) && this(c);
    double around(Rectangle r) : getRectangle(r) {
    	if (r.height <= 0 || r.width <= 0) {
    		return 0;
    	}
    	return proceed(r);
    }
    double around(Circle c) : getCircle(c) {
    	if (c.radius <= 0) {
    		return 0;
    	}
    	return proceed(c);
    }
    
    //Question 6
    pointcut getAreaCircle(Circle c) : execution(double Circle.getArea()) && this(c);
    double around(Circle c) : getAreaCircle(c) {
    	return Math.pow(c.radius, 2) * Math.PI;
    }
    
    //Question 8
    private static int shapeId = 1;
    public int Shape.id;
    public int Shape.getId() {
    	return this.id;
    }
    public void Shape.setId(int newId) {
    	this.id = newId;
    }
    
    before(Shape s) : initialization(Shape.new()) && this(s) {
    	s.setId(shapeId++);
    }
}