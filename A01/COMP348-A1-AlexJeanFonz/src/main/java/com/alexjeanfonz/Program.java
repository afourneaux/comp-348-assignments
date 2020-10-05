package com.alexjeanfonz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * App entrypoint
 * @author Jean, Alex
 */
public class Program {
    
    public static void main(String[] args) {
        //Load Employees from file
        Employee[] employees = new Employee[0];
        try {
            employees = readEmployeesFromFile();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        if (employees.length > 0) {
            displayEmployeeData(employees);
        }
    }
    
    /**
     * Ask the user for a file name, read the file, and convert its contents to Employee objects
     * @return An array of employees as described in the data file
     */
    private static Employee[] readEmployeesFromFile() {
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
    private static String userInput(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    /**
     * Displays different sorted and filtered lists of employees
     * @param employees 
     */
    private static void displayEmployeeData(Employee[] employees) {
        //Sort and display by First name and Last name
        System.out.println("SORT BY LAST NAME, THEN FIRST NAME");
        Arrays.sort(employees,(Employee a, Employee b) -> {
                    //Handle nulls
                    String firstA = a.getFirstName() != null ? a.getFirstName() : "";
                    String firstB = b.getFirstName() != null ? b.getFirstName() : "";
                    String lastA = a.getLastName() != null ? a.getLastName() : "";
                    String lastB = b.getLastName() != null ? b.getLastName() : "";

                    int ck = (lastA).compareTo(lastB); // lastName
                    return ck != 0 ? ck : (firstA).compareTo(firstB); // then firstName
                });
        Arrays.stream(employees).forEach(System.out::println);
        System.out.println("*************************************");
        
        //Sort and display by ID
        System.out.println("SORT BY ID");
        Arrays.stream(employees)
                .sorted(Comparator.comparing(Employee::getId))
                    .forEach(System.out::println);
        System.out.println("*************************************");
        
        //Salary Ranges
        System.out.println("SALARY BRACKET STATISTICS");
        Arrays.stream(employees)
                .collect(Collectors.groupingBy(Employee::getSalaryBracket, Collectors.summarizingDouble(empl -> empl.getSalary().doubleValue())))
                .forEach((salaryBracket, summarizingDouble) -> {
                    System.out.printf("%s -> Average: %.2f| Count: %d", salaryBracket, summarizingDouble.getAverage(), summarizingDouble.getCount());
                    System.out.println();
                });
        System.out.println("*************************************");
        
        //Total salary average and total count
        System.out.println("TOTAL SALARY AVERAGE AND EMPLOYEE COUNT");
        DoubleSummaryStatistics stats = Arrays.stream(employees).collect(Collectors.summarizingDouble(empl -> empl.getSalary().doubleValue()));
        System.out.printf("Total salary average: %.2f | Total count: %d", stats.getAverage(), stats.getCount());
    }
}
