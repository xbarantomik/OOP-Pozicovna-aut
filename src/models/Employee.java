package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee extends User implements Serializable{

	private static final long serialVersionUID = 1356496756833311971L;
	public static final Logger LOGGER = Logger.getLogger(Employee.class.getName());
	private static ArrayList<User> employees = new ArrayList<>();
	
	public Employee() {
		
	}
	
	public Employee(String login, String password, String name) {
		this.setLogin(login);
		this.setPassword(password);
		this.setName(name);
	}

	@Override
	public void LogInSpecific(boolean b) {
		this.LoginController.StartEmployeeSession();
	}

	@Override
	public void delUser(int index) {
		employees.remove(index);
	}

	@Override
	public void GetTime() {
		// overwrites a parent function (polymorphism)
	}
	
	@Override
	public void Serialize() {
		try {
			String fileName = "serialized/Serialized-EMPLOYEES.txt";
			serialize.Serialization.Update(getEmployeeList(), fileName);
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR Serialize() v EMPLOYEES", e);
		} 
	}
	
	public static void EmployeeArrayPrintOut() {
		try {
			if(employees.isEmpty()) {
				System.out.println("employeesList is Empty");
				return;
			}
			for(int i = 0;i <employees.size(); i++) {
				System.out.println("Name: " + employees.get(i).getName() +
						", Login: " + employees.get(i).getLogin());
			}
			System.out.println("");
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR EmployeeArrayPrintOut()", e);
		}
	}

	public static ArrayList<User> getEmployeeList() {
		return employees;
	}
	public static void setEmployeeList(ArrayList<User> list) {
		employees = list;
	}

}
