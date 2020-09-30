package com.jeanrobs.comp348.a1.alexjeanfonz;

/**
 * App entrypoint
 * @author jeanrobatto
 */
public class Program {
    
    public static void main(String[] args) {
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
