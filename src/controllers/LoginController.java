package controllers;

import javafx.stage.Stage;
import models.User;
import models.Customer;
import models.Order;
import view.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController implements Serializable{

	private static final long serialVersionUID = 8940767725827848793L;
	private static ArrayList<Integer> customerIndexForView = new ArrayList<>();
	public static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
	
	private int IndexOfSelectedCustomer;
	public LoginView loginView = null;
	
	public void SetupView(LoginView view) { 
		this.loginView = view;
	}
	
	public void StartCustomerSession(boolean NewCustomer) {
		if(NewCustomer) {
			new NewCustomerView().start(new Stage());
		}
		else {
			new CustomerView().start(new Stage());
		}
	}
	
	public void StartEmployeeSession() {
		new EmployeeView().start(new Stage());
	}
	
	public static void OrderArrayPrintOut() {
		utils.StaticDb.OrderArrayPrintOut();
	}
	
	public static void EmployeeArrayPrintOut() {
		models.Employee.EmployeeArrayPrintOut();	
	}

	
	public void TryLoginEmployee(String login, String pass) {
		
		User foundEmployee = null;
		
		loginView.getEmployeeLoginLb().setVisible(false);
		
		for(int i = 0; i< models.Employee.getEmployeeList().size(); i++) {	
			if(models.Employee.getEmployeeList().get(i).getPassword().equals(pass) &&
					models.Employee.getEmployeeList().get(i).getLogin().equals(login)) {	
				foundEmployee = models.Employee.getEmployeeList().get(i);
				loginView.UpdateAfterLogin();
				foundEmployee.LogIn(this);
				return;
			}
		}
		loginView.UserNotFound();
		
	}

	/**
	 * zistujem ci je zakaznik s cisloOP zaregistrovany alebo nie 
	 * @param cisloOP
	 */
	public void TryLoginCustomer(String cisloOP) {
		
		try {
			if(view.LoginView.getCustomerIDTf().getText().isEmpty() || (view.LoginView.getCustomerIDTfText() != null && view.LoginView.getCustomerIDTfText().equals(""))) {
				view.LoginView.setCustomerIDTf("");
				return;
			}

			Customer newCustomer = null;
			User registeredCustomer = null;	
			ArrayList<Order> orderList = models.Order.getOrderList();
			for(int i = 0; i< orderList.size(); i++){	
				if(orderList.get(i).getID().equals(cisloOP)) {		
					
					registeredCustomer = models.Customer.getCustomerList().get(i);
					loginView.UpdateAfterLogin();							//je v zozname tak ukazem info o objednavke
					customerIndexForView.clear();
					customerIndexForView.add(i);
					registeredCustomer.LogIn(this);
					return;
				}
			}
			
			for(int i = 0; i < models.Customer.getBanList().size(); i++) {
				if(models.Customer.getBanList().get(i).equals(cisloOP)) { 	//ci neni v banListe
					loginView.BanListWLb.setVisible(true);
					view.LoginView.getCustomerIDTf().setText(null);
					return;
				}
			}
			
			newCustomer = new Customer().CreateNewCustomer(cisloOP);		//neni v zozname tak idem vytvorit noveho 
			loginView.UpdateAfterLogin();
			newCustomer.LogInNewCustomer(this);
		
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Error TryLoginCustomer", e);
		}
	}
	
	
	public static void Initializer() {
		new Thread(() -> {
			try {
				utils.StaticDb.InitializeCarsPriceList();
				models.Order.setOrderList(utils.StaticDb.DeserializeOrder("serialized/Serialized-ORDERS.txt"));
				models.Customer.setCustomerList(utils.StaticDb.DeserializeUser("serialized/Serialized-CUSTOMERS.txt"));
				models.Customer.setBanList(utils.StaticDb.DeserializeString("serialized/Serialized-BANLIST.txt"));
				models.Employee.setEmployeeList(utils.StaticDb.DeserializeUser("serialized/Serialized-EMPLOYEES.txt"));
				models.SUV.setCars_SUVList(utils.StaticDb.DeserializeCar("serialized/Serialized-SUV.txt"));
				models.Sedan.setCars_SedanList(utils.StaticDb.DeserializeCar("serialized/Serialized-SEDAN.txt"));
				models.Convertible.setCars_ConverList(utils.StaticDb.DeserializeCar("serialized/Serialized-CONVERTIBLE.txt"));
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "ERROR Initializer v LoginCustomer", e);
			}
		}).start();
	}

	public int getCustomerIndex() {
		return IndexOfSelectedCustomer;
	}	
	public void setCustomerIndex(int index) {
		this.IndexOfSelectedCustomer = index;
	}
	public static ArrayList<Integer> getcustomerIndexForView(){
		return customerIndexForView;
	}
}
