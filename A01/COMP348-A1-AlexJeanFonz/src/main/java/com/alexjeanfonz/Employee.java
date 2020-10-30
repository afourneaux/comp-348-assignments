package com.alexjeanfonz;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Employee class
 * @author Jean, Alex
 */
public class Employee implements Person{
    
    //Attributes
    private String id, firstName, lastName;
    private BigDecimal salary;
    
    //Constants
    private final static int ID = 0, FIRST_NAME = 1, LAST_NAME = 2, SALARY = 3;
    private final static String IS_INT_REGEX = "^\\d+$";
    
    //Constructor
    public Employee(final String id, final String firstName, final String lastName, final BigDecimal salary) { 
        //Check for null vars
        Objects.requireNonNull(id);
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(salary);
        
        //Check for empty vars
        if (id.isEmpty()) {
            throw new IllegalArgumentException("Id can't be empty");
        }
        
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("First name can't be empty");
        }
        
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name can't be empty");
        }
        
        //Check that the id has 7 digits
        if (id.length() != 7) {
             throw new IllegalArgumentException("Id needs to be 7 digits");
        }
        
        if (!id.matches(IS_INT_REGEX)) {
             throw new IllegalArgumentException("Id needs to be only digits");
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
     */
    public static Person parse(final String employeeString) throws NumberFormatException {
        String[] attributes = employeeString.split(",");
        if (attributes.length != 4) {
            throw new IllegalArgumentException("Invalid parse string. Number of columns needs to be exactly 4.");
        }
        return new Employee(attributes[ID], attributes[FIRST_NAME], attributes[LAST_NAME], new BigDecimal(attributes[SALARY]));
    }
    
    /**
     * Get the employee's salary bracket, based on where they fall in various ranges.
     * @return The employee's salary bracket enum
     */
    public SalaryBracket getSalaryBracket() {
        if (salary.compareTo(new BigDecimal(25000.00)) < 0) {
            return SalaryBracket.First;
        }
        if (salary.compareTo(new BigDecimal(40000.00)) < 0) {
            return SalaryBracket.Second;
        }
        if (salary.compareTo(new BigDecimal(70000.00)) < 0) {
            return SalaryBracket.Third;
        }
        return SalaryBracket.Fourth;
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
    public String getFirstName() {
        return this.firstName;
    }
    
    @Override
    public String getLastName() {
        return this.lastName;
    }
    
    //Object methods
    @Override
    public String toString() {
        return String.format("Id: %s, Name: %s %s, Salary: %s", this.id, this.firstName, this.lastName, this.salary);
    }
}
