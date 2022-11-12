package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends User implements Serializable{

	private static final long serialVersionUID = 1356496756833311971L;
	
	private static ArrayList<User> employees = new ArrayList<>();
	
	public Employee() {
		
	}
	
	public Employee(String login, String password, String name) {
		this.setLogin(login);
		this.setPassword(password);
		this.setName(name);
	}
	
	public void LogInSpecific(boolean b) {
		this.LoginController.StartEmployeeSession();
	}
	
	public void delUser(int index) {
		employees.remove(index);
	}
	
	public void GetTime() {
		
	}
	
	@Override
	public void Serialize() {
		try {
			String fileName = "serialized/Serialized-EMPLOYEES.txt";
			serialize.Serialization.Update(getEmployeeList(), fileName);
		} catch(Exception e2) {
			System.out.println("ERROR Serialize() v EMPLOYEES");
			e2.printStackTrace();
		} 
	}
	
	public static void EmployeeArrayPrintOut() {
		try {
			if(employees.isEmpty()) {
				System.out.println("employeesList je Empty");
				return;
			}
			for(int i = 0;i <employees.size(); i++) {
				System.out.println("Name: " + employees.get(i).getName() + 
						", Login: " + employees.get(i).getLogin());
			}
			System.out.println("");
		}catch(Exception e) {
			System.out.println("ERROR EmployeeArrayPrintOut()");
			e.printStackTrace();
		}
	}
	
	
	
	
	public static ArrayList<User> getEmployeeList() {
		return employees;
	}
	public static void setEmployeeList(ArrayList<User> list) {
		employees = list;
	}


	


}
