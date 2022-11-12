package controllers;

import view.AYSOrderView;
import javafx.stage.Stage;
import view.NewCustomerView;
import controllers.CustomerController;
import exceptions.NotRegisteredCustomerException;
import models.*;



public class AYSOrderController{
	

	public AYSOrderView viewForAreYouSureOrderView = null;
	public NewCustomerView newCustomerView = null;
	public CustomerController ControllerForCustomer = new CustomerController();
	public Order orderFor = new Order();
	public Customer customerFor = new Customer();
	public SUV suvFor = new SUV();
	public Sedan sedanFor = new Sedan();
	public Convertible converFor = new Convertible();

	public void SetupView(AYSOrderView view) {
		this.viewForAreYouSureOrderView = view;
	}
	
	public void StartAreYouSureOrderSession() {
		new AYSOrderView().start(new Stage());;
	}
	
	public void SetDepositZero(String ID) {
		try {
			int index = models.Customer.FindCustomerIndex(ID);
			User customer = models.Customer.getCustomerList().get(index);
			Car car = FindCar(customer.getCarSerialNumber());
			CheckCarForNull(car);
			car.setDeposit(0);
			
		}catch(Exception e2) {							
			System.out.println("ERROR ChosenCar v AreYouSureOrder Controller");
			e2.printStackTrace();
		}
	}

	public void ChosenCarLayout(String ID) {	//vypisovanie znoleneho auta na AreYouSureView
		try {
			int index = models.Customer.FindCustomerIndex(ID);
			User customer = models.Customer.getCustomerList().get(index);
			Car car = FindCar(customer.getCarSerialNumber());
			CheckCarForNull(car);
			
			viewForAreYouSureOrderView.setCarLbText(car.getBrand() + " " + car.getModel() + " (" + car.getYearOfProduction() + ")");
			viewForAreYouSureOrderView.setPriceLbText(car.getFinalPriceString() + " €");
			
			int credit = customer.getCredit();
			int deposit = CalculateDeposit(car.getFinalPrice());
			int price =  car.getFinalPrice();
			String days = String.valueOf(customer.getDays());
			
			viewForAreYouSureOrderView.setCreditLbText(credit + " €");
			viewForAreYouSureOrderView.setDepositLbText(deposit + " €");
			viewForAreYouSureOrderView.setOverallLbText((price + deposit) + " €");
			viewForAreYouSureOrderView.setForDaysLb("Days:  " + days);

			car.setDeposit(deposit);
			if((price + deposit) > credit) {
				viewForAreYouSureOrderView.OrderBtn.setVisible(false);
				viewForAreYouSureOrderView.NotEnoughCreditLb.setVisible(true);
			}

		}catch(Exception e2) {							
			System.out.println("ERROR ChosenCar v AreYouSureOrder Controller");
			e2.printStackTrace();
		}
	}
	
	public void CheckCarForNull(Car car) throws NotRegisteredCustomerException{
		if (!(car instanceof Car)) {
			throw new NotRegisteredCustomerException("FindCar v CreateOrder returnlo null");
		}
	}
	
	public Car FindCar(int serialNumber) {
		try {
			Car TheCar;
				for (int i = 0; i < models.Convertible.getCars_ConverList().size(); i++) {
					if (models.Convertible.getCars_ConverList().get(i).getSerialNumber() == serialNumber){
						TheCar = models.Convertible.getCars_ConverList().get(i);
						TheCar.setIndexInArrayList(i);
						return TheCar;
					}
				}
				for (int i = 0; i < models.SUV.getCars_SUVList().size(); i++) {
					if (models.SUV.getCars_SUVList().get(i).getSerialNumber() == serialNumber){
						TheCar = models.SUV.getCars_SUVList().get(i);
						TheCar.setIndexInArrayList(i);
						return TheCar;
					}
				}
				for (int i = 0; i < models.Sedan.getCars_SedanList().size(); i++) {
					if (models.Sedan.getCars_SedanList().get(i).getSerialNumber() == serialNumber){
						TheCar = models.Sedan.getCars_SedanList().get(i);
						TheCar.setIndexInArrayList(i);
						return TheCar;
					}
				}
			return null;
		}catch(Exception e2) {							
			System.out.println("ERROR FindCar v AreYouSureOrder Controller");
			e2.printStackTrace();
			return null;
		}
		
	}
	
	
	public int CalculateDeposit(int price) {
		return (int)(price * 0.15);
	}
	
	
	/**
	 * najdem si Car, User, urobim potrebne veci a vytvorim Order
	 * 
	 * @param ID
	 */
	public void CreateOrder(String ID) {

		try {
			User customer = models.Customer.getCustomerList().get(models.Customer.FindCustomerIndex(ID));
			Car car = FindCar(customer.getCarSerialNumber());
			CheckCarForNull(car);
			
			orderFor.SubPriceAndDeposit(car, customer);
			car.IsNotAvailable();
			customer.setHasCar(true);
			
			Order newOrder = new Order(car, customer);
	
			orderFor.setForHowLong(customer.getDays());
			orderFor.addOrder(newOrder);
			orderFor.setCarType(car.getCarType());
			
			Serialize();
			
		}catch(NotRegisteredCustomerException e2) {	
		}catch(Exception e2) {							
			System.out.println("ERROR CreateOrder v AreYouSureOrder Controller");
			e2.printStackTrace();
		}
	}
	
	public void Serialize() {
		orderFor.Serialize();
		customerFor.Serialize();
		suvFor.Serialize();
		sedanFor.Serialize();			
		converFor.Serialize();
	}


	
}
