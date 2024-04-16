package test;

import java.util.ArrayList;
import java.util.List;

abstract class EmployeeManager {
    protected List<Employee> employees;

    public abstract void addEmployee(Employee emp);
    public abstract boolean removeEmployee(String ID);
    public abstract void updateEmployee(String ID, Employee newEmp);
    public abstract Employee findEmployee(String ID);
    public abstract void showAllEmployees();
    public abstract void writeEmployeesToFile(String fileName);
    public abstract void readEmployeesFromFile(String fileName);
	
}

