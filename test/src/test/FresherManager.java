package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

class FresherManager extends EmployeeManager {
    public List<Fresher> fresherEmployees;

    public FresherManager(List<Fresher> fresherEmployees) {
        this.fresherEmployees = fresherEmployees;
    }

    @Override
    public void addEmployee(Employee emp) {
        if (emp instanceof Fresher) {
            fresherEmployees.add((Fresher) emp);
        } else {
            System.out.println("Invalid employee type.");
        }
    }

    @Override
    public boolean removeEmployee(String ID) {
        for (Fresher emp : fresherEmployees) {
            if (emp.ID.equals(ID)) {
                fresherEmployees.remove(emp);
                return true;
            }
        }
        return false;
    }


 

    @Override
    public void writeEmployeesToFile(String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(fresherEmployees);
            System.out.println("Danh sách nhân viên mới tốt nghiệp đã được ghi vào file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readEmployeesFromFile(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            fresherEmployees = (List<Fresher>) in.readObject();
            System.out.println("Danh sách nhân viên mới tốt nghiệp đã được đọc từ file " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void updateEmployee(String ID, Employee newEmp) {
		  for (int i = 0; i < fresherEmployees.size(); i++) {
	            if (fresherEmployees.get(i).ID.equals(ID)) {
	                fresherEmployees.set(i, (Fresher) newEmp);
	                break;
	            }
	        }
	}

	@Override
	public Fresher findEmployee(String ID) {
		 for (Fresher emp : fresherEmployees) {
	            if (emp.ID.equals(ID)) {
	                return emp;
	            }
	        }
	        return null;
	}

	@Override
	public void showAllEmployees() {
		 for (Fresher emp : fresherEmployees) {
	            emp.showInfo();
	        }
		
	}

 }