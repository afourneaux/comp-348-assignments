package com.jeanrobs.comp348.a1.alexjeanfonz;

import java.math.BigDecimal;

/**
 * Employee class
 * @author Alfonso
 */
public class Employee implements Person{
    
    //Attributes
    private String id, firstName, lastName;
    private BigDecimal salary;
    
    //Constants
    private final static int ID = 0, FIRST_NAME = 1, LAST_NAME = 2, SALARY = 4;
    
    //Constructor
    public Employee(final String id, final String firstName, final String lastName, final BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    
    //Class methods
    /**
     * Parses a string to an Employee obj
     * @param employeeString  Format: "id,firstname,lastname,salary"
     * @return A constructed employee
     * @throws NumberFormatException if the salary is not a valid number
     */
    public static Person parse(String employeeString) throws NumberFormatException {
        String[] attributes = employeeString.split(",");
        return new Employee(attributes[ID], attributes[FIRST_NAME], attributes[LAST_NAME], new BigDecimal(attributes[SALARY]));
    }
    
    //Interface methods
    @Override
    public String getId() {
        return this.id;
    }
    
    @Override
    public String getName() {
        return this.firstName + " " + this.lastName;
    }
    
    //Object methods
    //TODO: Finish this method
    @Override
    public String toString() {
        return "";
    }
    
    
}
