package test;

import java.util.*;
import java.io.*;


// Lớp cơ bản Employee
abstract class Employee implements IEmployee {
    protected String ID;
    protected String fullName;
    protected String birthDay;
    protected String phone;
    protected String email;
    protected String employeeType;
    protected static int employeeCount = 0;

    public Employee(String ID, String fullName, String birthDay, String phone, String email, String employeeType) {
        this.ID = ID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        employeeCount++;
    }	

    public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void showInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Full Name: " + fullName);
        System.out.println("Birth Day: " + birthDay);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Employee Type: " + employeeType);
    
    }
    public static int getEmployeeCount() {
        return employeeCount;
    }
}




