package controllers;

import javafx.stage.Stage;
import models.*;
import view.ReturnCarLateView;
import view.ReturnCarView;

public class ReturnCarController {

	public ReturnCarLateView viewReturnCarLate = null;
	public ReturnCarView viewReturnCar = null;
	public CustomerController ControllerForCustomer = new CustomerController();
	public Order orderFor = new Order();
	public Customer customerFor = new Customer();
	public SUV suvFor = new SUV();
	public Sedan sedanFor = new Sedan();
	public Convertible converFor = new Convertible();
	
	
	
	public void SetupView(ReturnCarView view) {
		this.viewReturnCar = view;
	}
	
	public void StartReturnCarSession() {
		new ReturnCarView().start(new Stage());;
	}
	
	public void SetupViewLate(ReturnCarLateView view) {
		this.viewReturnCarLate = view;
	}
	
	public void StartReturnCarLateSession() {
		new ReturnCarLateView().start(new Stage());;
	}


	
public void OrderDeleteAllLate(String ID) {
		
		Order order = ControllerForCustomer.FindOrder(ID);	
		User customer = models.Customer.getCustomerList().get(models.Customer.FindCustomerIndex(ID));
		Car car = FindCar(order.getCarType(), order.getCarSerialNumber());
		
		SetCarDefault(car);
		
		customer.AddToBanList(customer);
		customer.delUser(customer.getIndexInArray());
		order.deleteOrder(order.getIndexInArray());		
		
		order.Serialize();
		customer.Serialize();
		customer.SerializeBanList();
		car.Serialize();
		
	}
	
	public void OrderDeleteAll(String ID) {
		
		Order order = ControllerForCustomer.FindOrder(ID);	
		User customer = models.Customer.getCustomerList().get(models.Customer.FindCustomerIndex(ID));
		Car car = FindCar(order.getCarType(), order.getCarSerialNumber());
		
		SetCarDefault(car);
		
		customer.addDepositToCredit(order);
		customer.delUser(customer.getIndexInArray());
		order.deleteOrder(order.getIndexInArray());		
		

		order.Serialize();
		customer.Serialize();
		car.Serialize();
		
	}
	
	public void SetCarDefault(Car car) {
		car.IsAvailable();
		car.setIndexOfUsage(car.getIndexOfUsage() + 1);
		car.setDeposit(0);
		car.setFinalPrice(0);
	}


	public Car FindCar(String carType, int serialnumber) {
		try {
			Car TheCar;
			switch(carType) {
				case "Convertible":
					for (int i = 0; i < models.Convertible.getCars_ConverList().size(); i++) {
						if (models.Convertible.getCars_ConverList().get(i).getSerialNumber() == serialnumber){
							TheCar = models.Convertible.getCars_ConverList().get(i);
							TheCar.setIndexInArrayList(i);
							return TheCar;
						}
					}
					break;
				case "SUV" :
					for (int i = 0; i < models.SUV.getCars_SUVList().size(); i++) {
						if (models.SUV.getCars_SUVList().get(i).getSerialNumber() == serialnumber){
							TheCar = models.SUV.getCars_SUVList().get(i);
							TheCar.setIndexInArrayList(i);
							return TheCar;
						}
					}
					break;
				case "Sedan":
					for (int i = 0; i < models.Sedan.getCars_SedanList().size(); i++) {
						if (models.Sedan.getCars_SedanList().get(i).getSerialNumber() == serialnumber){
							TheCar = models.Sedan.getCars_SedanList().get(i);
							TheCar.setIndexInArrayList(i);
							return TheCar;
						}
					}
					break;	
				}
			return null;
		}catch (Exception e) {
			System.out.println("Error CustomerOrderLayout() v CustomerController");
			e.printStackTrace();
			return null;
		}
	}


	
	
	
}
