package controllers;

import models.Employee;
import models.User;
import view.EmployeeView;
import view.LoginView;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeController {

	public static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());
	public EmployeeView employeeView = null;
	public LoginView loginView = null;
	public Employee forEmployee = new Employee();
	
	public void SetupView(EmployeeView view) {
		this.employeeView = view;
	}
	
	public void CarsArrayPrintOutAll() {
		try {
			employeeView.OutPutTa.setText(null);
			for(int i = 0; i < models.SUV.getCars_SUVList().size(); i++) {
				employeeView.OutPutTa.appendText(models.SUV.getCars_SUVList().get(i).getBrand() + " " + 
												models.SUV.getCars_SUVList().get(i).getModel() + " (" + 
												models.SUV.getCars_SUVList().get(i).getYearOfProduction() + ")\n");
			}
			for(int i = 0; i < models.Sedan.getCars_SedanList().size(); i++) {
				employeeView.OutPutTa.appendText(models.Sedan.getCars_SedanList().get(i).getBrand() + " " + 
												models.Sedan.getCars_SedanList().get(i).getModel() + " (" + 
												models.Sedan.getCars_SedanList().get(i).getYearOfProduction() + ")\n");
			}
			for(int i = 0; i < models.Convertible.getCars_ConverList().size(); i++) {
				employeeView.OutPutTa.appendText(models.Convertible.getCars_ConverList().get(i).getBrand() + " " + 
												models.Convertible.getCars_ConverList().get(i).getModel() + " (" + 
												models.Convertible.getCars_ConverList().get(i).getYearOfProduction() + ")\n");
			}
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR CarsArrayPrintOutAll() v EmployeeController", e);
		}
	}	
	
	public void CarsArrayPrintOutAvailable() {
		try {										
			employeeView.OutPutTa.setText(null);
			for(int i = 0; i < models.SUV.getCars_SUVList().size(); i++) {
				if(models.SUV.getCars_SUVList().get(i).getAvailable())	
					employeeView.OutPutTa.appendText(models.SUV.getCars_SUVList().get(i).getBrand() + " " +
													models.SUV.getCars_SUVList().get(i).getModel() + " (" +
													models.SUV.getCars_SUVList().get(i).getYearOfProduction() + ")\n");
			}
			for(int i = 0; i < models.Sedan.getCars_SedanList().size(); i++) {
				if(models.Sedan.getCars_SedanList().get(i).getAvailable())	
					employeeView.OutPutTa.appendText(models.Sedan.getCars_SedanList().get(i).getBrand() + " " +
													models.Sedan.getCars_SedanList().get(i).getModel() + " (" +
													models.Sedan.getCars_SedanList().get(i).getYearOfProduction() + ")\n");
			}
			for(int i = 0; i < models.Convertible.getCars_ConverList().size(); i++) {
				if(models.Convertible.getCars_ConverList().get(i).getAvailable())	
					employeeView.OutPutTa.appendText(models.Convertible.getCars_ConverList().get(i).getBrand() + " " +
													models.Convertible.getCars_ConverList().get(i).getModel() + " (" +
													models.Convertible.getCars_ConverList().get(i).getYearOfProduction() + ")\n");
			}
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR CarsArrayPrintOut(boolean) v EmployeeController", e);
		}
		
		
	}
	
	public void CarsArrayPrintOutUnavailable() {	
		try {
			employeeView.OutPutTa.setText(null);
			for(int i = 0; i < models.SUV.getCars_SUVList().size(); i++) {
				if(!models.SUV.getCars_SUVList().get(i).getAvailable())	
					employeeView.OutPutTa.appendText(models.SUV.getCars_SUVList().get(i).getBrand() + " " +
													models.SUV.getCars_SUVList().get(i).getModel() + " (" +
													models.SUV.getCars_SUVList().get(i).getYearOfProduction() + ")\n");
			}
			for(int i = 0; i < models.Sedan.getCars_SedanList().size(); i++) {
				if(!models.Sedan.getCars_SedanList().get(i).getAvailable())	
					employeeView.OutPutTa.appendText(models.Sedan.getCars_SedanList().get(i).getBrand() + " " +
													models.Sedan.getCars_SedanList().get(i).getModel() + " (" +
													models.Sedan.getCars_SedanList().get(i).getYearOfProduction() + ")\n");
			}
			for(int i = 0; i < models.Convertible.getCars_ConverList().size(); i++) {
				if(!models.Convertible.getCars_ConverList().get(i).getAvailable())	
					employeeView.OutPutTa.appendText(models.Convertible.getCars_ConverList().get(i).getBrand() + " " +
													models.Convertible.getCars_ConverList().get(i).getModel() + " (" +
													models.Convertible.getCars_ConverList().get(i).getYearOfProduction() + ")\n");
			}
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR CarsArrayPrintOutUnavailable() v EmployeeController", e);
		}
	}

	public void SerializeEmployees() {
		forEmployee.Serialize();
	}


	public String NameLayout(String login, String pass) {
		User employee = FindEmployee(login, pass);
		return ("Logged as: " + employee.getName());
		
	}
	
	public User FindEmployee(String login, String pass) {
		try {
			User emp = null;
			for(int i = 0; i< models.Employee.getEmployeeList().size(); i++) {
				if(models.Employee.getEmployeeList().get(i).getPassword().equals(pass) &&
						models.Employee.getEmployeeList().get(i).getLogin().equals(login)) {	
					emp = models.Employee.getEmployeeList().get(i);
					return emp;
				}
			}
			return null;
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR FindEmloyee v EmployeeController", e);
			return null;
		} 
	}

	public void IfAdmin(String login, String pass) {
		try {
			if((login.equals("admin")) && (pass.equals("admin"))) {
				employeeView.AddEmployeesBtn.setVisible(true);
			}
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR IfAdmin v EmployeeController", e);
		} 
	}
	
	public void OrderArrayPrintOut() {
		try {
			employeeView.OutPutTa.setText(null);
			if(models.Order.getOrderList().isEmpty()) {
				employeeView.OutPutTa.setText("There are no Orders");
				return;
			}else {
				for(int i = 0; i < models.Order.getOrderList().size(); i++) {
				employeeView.OutPutTa.appendText(models.Order.getOrderList().get(i).getBrand() + " " +
						models.Order.getOrderList().get(i).getModel() + " || Name: " +
						models.Order.getOrderList().get(i).getName() + ",  ID: " + 
						models.Order.getOrderList().get(i).getID() + ",  credit: " + 
						models.Order.getOrderList().get(i).getCredit() + " ?\n");
				}
			}
			
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR OrderArrayPrintOut() v EmployeeController", e);
		}
	}
	
	
	public void CustomersArrayPrintOut() {
		try {
			employeeView.OutPutTa.setText(null);
			int poc = 0;
			if(models.Customer.getCustomerList().isEmpty()) {
				employeeView.OutPutTa.setText("There are no regitered customers");
				return;
			}
			for(int i = 0;i < models.Customer.getCustomerList().size(); i++) {
				employeeView.OutPutTa.appendText("Name: " + models.Customer.getCustomerList().get(poc).getName() + ",  ID: " + 
												models.Customer.getCustomerList().get(poc).getID() + ",  credit: " + 
												models.Customer.getCustomerList().get(poc++).getCredit() + " €\n");
			}
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR CustomersArrayPrintOut() v EmployeeController", e);
		}
	}
}
