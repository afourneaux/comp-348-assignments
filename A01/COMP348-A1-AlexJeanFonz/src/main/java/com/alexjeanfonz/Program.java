package com.alexjeanfonz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * App entrypoint
 * @author jeanrobatto
 */
public class Program {
    
    public static void main(String[] args) {
        partOneTests();
        
        Employee[] employees = new Employee[0];
        try {
            employees = readEmployeesFromFile();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        // TEST: Output the first read employee
        if (employees.length > 0) {
            System.out.println(employees[0].toString());
        } else {
            System.out.println("Employees list is empty!");
        }
        
    }
    
    /**
     * Ask the user for a file name, read the file, and convert its contents to Employee objects
     * @return An array of employees as described in the data file
     */
    public static Employee[] readEmployeesFromFile() {
        Employee[] employees = new Employee[0];
        String filename = userInput("Please enter a file name:");
        // try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader("./data/" + filename + ".txt"))) {
            // Use the Stream API to map each of the reader's lines to the 
            // Employee's parse function, then return all data as an array
            employees = br.lines().map(Employee::parse).toArray(Employee[]::new);
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate file: \"/data/" + filename + ".txt\"!");
        } catch (IOException e) {
            System.out.println("Error reading file: \"/data/" + filename + ".txt\"!");
            System.out.println(e.toString());
        }
        return employees;
    }
    
    /**
     * Display a message, then request console input from the user
     * @param prompt The message to display for the user to prompt their input
     * @return The text input entered by the user
     */
    public static String userInput(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public static void partOneTests() {
        
        //Part 1 tests
        
        //Successful parse
        String employeeString1 = "4563723,Jean,Robatto,80000";
        try {
            Person p = Employee.parse(employeeString1);
            System.out.println(p);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        //Wrong parse = id too short
        String employeeString2 = "4723,Jean,Robatto,80000";
        try {
            Person p = Employee.parse(employeeString2);
            System.out.println(p);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        //Wrong parse = id not an int
        String employeeString3 = "4563df2,Jean,Robatto,80000";
        try {
            Person p = Employee.parse(employeeString3);
            System.out.println(p);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        //Wrong parse = empty strings
        String employeeString4 = "4563df2,Jean,,80000";
        try {
            Person p = Employee.parse(employeeString4);
            System.out.println(p);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
         //Wrong parse = salary not a number
        String employeeString5 = "4563df2,Jean,Robatto,salary";
        try {
            Person p = Employee.parse(employeeString5);
            System.out.println(p);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
         //Wrong parse = missing a field
        String employeeString6 = "4563df2,Jean,20000";
        try {
            Person p = Employee.parse(employeeString6);
            System.out.println(p);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
