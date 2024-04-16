package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class ExperienceManager extends EmployeeManager {
    public List<Experience> experienceEmployees = new ArrayList<>();

    @Override
    public void addEmployee(Employee emp) {
        if (emp instanceof Experience) {
            experienceEmployees.add((Experience) emp);
        } else {
            System.out.println("Invalid employee type.");
        }
    }

    @Override
    public boolean removeEmployee(String ID) {
        for (Experience emp : experienceEmployees) {
            if (emp.ID.equals(ID)) {
                experienceEmployees.remove(emp);
                return true;
            }
        }
        return false;
    }


    @Override
    public void writeEmployeesToFile(String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(experienceEmployees);
            System.out.println("Danh sách nhân viên kinh nghiệm đã được ghi vào file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readEmployeesFromFile(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            experienceEmployees = (List<Experience>) in.readObject();
            System.out.println("Danh sách nhân viên kinh nghiệm đã được đọc từ file " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void updateEmployee(String ID, Employee newEmp) {
		for (int i = 0; i < experienceEmployees.size(); i++) {
            if (experienceEmployees.get(i).ID.equals(ID)) {
                experienceEmployees.set(i, (Experience) newEmp);
                break;
            }
        }
    }


	@Override
	public Experience findEmployee(String ID) {
		for (Experience emp : experienceEmployees) {
            if (emp.ID.equals(ID)) {
                return emp;
            }
        }
        return null;
	}

	@Override
	public void showAllEmployees() {
		 for (Experience emp : experienceEmployees) {
	            emp.showInfo();
	        }
		
	}

}
