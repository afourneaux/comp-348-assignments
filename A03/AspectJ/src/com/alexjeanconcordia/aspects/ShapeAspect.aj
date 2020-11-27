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

}
