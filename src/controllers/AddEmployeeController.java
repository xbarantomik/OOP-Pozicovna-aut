package controllers;

import exceptions.EmptyComboBoxException;
import exceptions.NotRegisteredCustomerException;
import javafx.stage.Stage;
import models.*;
import view.AddEmployeeView;

public class AddEmployeeController {
	
	
	public AddEmployeeView viewAddEmployee = null;
	public CustomerController ControllerForCustomer = new CustomerController();
	public Employee forEmployee = new Employee();
	public Order orderFor = new Order();
	public Customer customerFor = new Customer();
	public SUV suvFor = new SUV();
	public Sedan sedanFor = new Sedan();
	public Convertible converFor = new Convertible();
	
	
	
	public void SetupView(AddEmployeeView view) {
		this.viewAddEmployee = view;
	}
	
	public void StartAddEmployeeSession() {
		new AddEmployeeView().start(new Stage());;
	}

	public boolean CheckTextFields(String name, String login, String pass, String pass2) throws EmptyComboBoxException {
		if (name.equals(null) || login.equals(null) || pass.equals(null) || pass2.equals(null) ||
				name.equals("") || login.equals("") || pass.equals("") || pass2.equals("")) {
			viewAddEmployee.WarningLb.setVisible(true);
			viewAddEmployee.AYSLb.setVisible(false);
			throw new EmptyComboBoxException("Fill in all Fields!");
		}else {
			return true;
		}
	}
	
	public boolean CheckPasswords(String pass, String pass2) throws NotRegisteredCustomerException {
	if (!pass.equals(pass2)) {
		viewAddEmployee.Warning2Lb.setVisible(true);
		viewAddEmployee.AYSLb.setVisible(false);
		throw new NotRegisteredCustomerException("Passwords aren't identical");
		}else {
			return true;
		}
	}

	public void AddEmployee(String name, String login, String pass, String pass2) {
		try {
			
			boolean bool1 = CheckTextFields(name, login, pass,pass2);
			boolean bool2 = CheckPasswords(pass, pass2);
			if(bool1 && bool2) {
				models.Employee.getEmployeeList().add(new Employee(login, pass, name));
				SerializeEmployees();
				viewAddEmployee.closeThisStage();
			}
			
		} catch(EmptyComboBoxException e3) {	
		} catch(NotRegisteredCustomerException e3) {
		} catch(Exception e3) {
			System.out.println("ERROR AddEmployee v AddEmployeeController");
			e3.printStackTrace();
		} 	
	}
	
	public void SerializeEmployees() {
		forEmployee.Serialize();
		
	}


}
