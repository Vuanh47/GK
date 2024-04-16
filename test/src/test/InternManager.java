package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

class InternManager extends EmployeeManager {
    public List<Intern> internEmployees;

    public InternManager(List<Intern> internEmployees) {
        this.internEmployees = internEmployees;
    }

    @Override
    public void addEmployee(Employee emp) {
        if (emp instanceof Intern) {
            internEmployees.add((Intern) emp);
        } else {
            System.out.println("Invalid employee type.");
        }
    }

    @Override
    public boolean removeEmployee(String ID) {
        for (Intern emp : internEmployees) {
            if (emp.ID.equals(ID)) {
                internEmployees.remove(emp);
                return true;
            }
        }
        return false;
    }


	@Override
	public void updateEmployee(String ID, Employee newEmp) {
		 for (int i = 0; i < internEmployees.size(); i++) {
	            if (internEmployees.get(i).ID.equals(ID)) {
	                internEmployees.set(i, (Intern) newEmp);
	                break;
	            }
	        }
	}

	@Override
	public Intern findEmployee(String ID) {
		 for (Intern emp : internEmployees) {
	            if (emp.ID.equals(ID)) {
	                return emp;
	            }
	        }
	        return null;
	}

	@Override
	public void showAllEmployees() {
		 for (Intern emp : internEmployees) {
	            emp.showInfo();
	        }
	}

	  @Override
	    public void writeEmployeesToFile(String fileName) {
	        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
	            out.writeObject(internEmployees);
	            System.out.println("Danh sách nhân viên thực tập đã được ghi vào file " + fileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void readEmployeesFromFile(String fileName) {
	        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
	            internEmployees = (List<Intern>) in.readObject();
	            System.out.println("Danh sách nhân viên thực tập đã được đọc từ file " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }


}