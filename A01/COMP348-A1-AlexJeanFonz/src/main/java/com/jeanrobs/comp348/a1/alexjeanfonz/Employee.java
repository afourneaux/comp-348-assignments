package com.jeanrobs.comp348.a1.alexjeanfonz;

import java.math.BigDecimal;
import java.util.Objects;
import javax.naming.directory.InvalidAttributeValueException;

/**
 * Employee class
 * @author Alfonso
 */
public class Employee implements Person{
    
    //Attributes
    private String id, firstName, lastName;
    private BigDecimal salary;
    
    //Constants
    private final static int ID = 0, FIRST_NAME = 1, LAST_NAME = 2, SALARY = 3;
    private final static String IS_INT_REGEX = "^\\d+$";
    
    //Constructor
    public Employee(final String id, final String firstName, final String lastName, final BigDecimal salary) throws InvalidAttributeValueException {
        //Check for null vars
        Objects.requireNonNull(id);
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(salary);
        
        //Check for empty vars
        if (id.isEmpty()) {
            throw new InvalidAttributeValueException("Id can't be empty");
        }
        
        if (firstName.isEmpty()) {
            throw new InvalidAttributeValueException("First name can't be empty");
        }
        
        if (lastName.isEmpty()) {
            throw new InvalidAttributeValueException("Last name can't be empty");
        }
        
        //Check that the id has 7 digits
        if (id.length() != 7) {
             throw new InvalidAttributeValueException("Id needs to be 7 digits");
        }
        
        if (!id.matches(IS_INT_REGEX)) {
             throw new InvalidAttributeValueException("Id needs to be only digits");
        }
        
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
     * @throws javax.naming.directory.InvalidAttributeValueException
     */
    public static Person parse(final String employeeString) throws NumberFormatException, InvalidAttributeValueException {
        String[] attributes = employeeString.split(",");
        return new Employee(attributes[ID], attributes[FIRST_NAME], attributes[LAST_NAME], new BigDecimal(attributes[SALARY]));
    }
    
    public BigDecimal getSalary() {
        return this.salary;
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
    @Override
    public String toString() {
        return String.format("Id: %s, Name: %s %s, Salary: %s", this.id, this.firstName, this.lastName, this.salary);
    }
    
    
}
