package com.alexjeanfonz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * App entrypoint
 * @author jeanrobatto
 */
public class Program {
    
    public static void main(String[] args) {
        PartOneTests();
        
        Employee[] employees = new Employee[0];
        try {
            employees = ReadEmployeesFromFile();
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
    
    public static Employee[] ReadEmployeesFromFile() {
        Employee[] employees = new Employee[0];
        String filename = UserInput("Please enter a file name:");
        // try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader("./data/" + filename + ".txt"))) {
            employees = br.lines().map(Employee::parse).toArray(Employee[]::new);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return employees;
    }
    
    public static String UserInput(String request) {
        System.out.println(request);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public static void PartOneTests() {
        
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
