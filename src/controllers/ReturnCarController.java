package controllers;

import javafx.stage.Stage;
import models.*;
import view.ReturnCarLateView;
import view.ReturnCarView;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReturnCarController {

	public static final Logger LOGGER = Logger.getLogger(ReturnCarController.class.getName());
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

	private Car findConvertible(int serialnumber){
		Car convertible;
		for (int i = 0; i < models.Convertible.getCars_ConverList().size(); i++) {
			if (models.Convertible.getCars_ConverList().get(i).getSerialNumber() == serialnumber){
				convertible = models.Convertible.getCars_ConverList().get(i);
				convertible.setIndexInArrayList(i);
				return convertible;
			}
		}
		return null;
	}

	private Car findSUV(int serialnumber){
		for (int i = 0; i < models.SUV.getCars_SUVList().size(); i++) {
			if (models.SUV.getCars_SUVList().get(i).getSerialNumber() == serialnumber){
				Car suv = models.SUV.getCars_SUVList().get(i);
				suv.setIndexInArrayList(i);
				return suv;
			}
		}
		return null;
	}

	private Car findSedan(int serialnumber){
		for (int i = 0; i < models.Sedan.getCars_SedanList().size(); i++) {
			if (models.Sedan.getCars_SedanList().get(i).getSerialNumber() == serialnumber){
				Car sedan = models.Sedan.getCars_SedanList().get(i);
				sedan.setIndexInArrayList(i);
				return sedan;
			}
		}
		return null;
	}

	public Car FindCar(String carType, int serialnumber) {
		try {
			Car theCar;
			switch(carType) {
				case "Convertible":
					theCar = findConvertible(serialnumber);
					if (theCar != null){
						return theCar;
					}
					break;
				case "SUV" :
					theCar = findSUV(serialnumber);
					if (theCar != null){
						return theCar;
					}
					break;
				case "Sedan":
					theCar = findSedan(serialnumber);
					if (theCar != null){
						return theCar;
					}
					break;
				default:
					break;
			}
			return null;
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error CustomerOrderLayout() v CustomerController", e);
			return null;
		}
	}
}