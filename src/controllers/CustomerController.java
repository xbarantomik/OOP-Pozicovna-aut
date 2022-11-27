package controllers;

import view.CustomerView;
import view.LoginView;
import view.NewCustomerView;
import view.AYSOrderView;
import controllers.LoginController;
import exceptions.EmptyComboBoxException;
import exceptions.NotRegisteredCustomerException;
import models.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerController{

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class.getName());
	public CustomerView customerView = null;
	public NewCustomerView newCustomerView = null;
	public Customer customer = new Customer();
	public LoginController ControllerForLogin = new LoginController();
	public AYSOrderView viewrForAreYouSureOrder = null;
	public LoginView loginView = null;
	static final String SUV = "SUV";
	static final String SEDAN = "Sedan";
	static final String CONVERTIBLE = "Convertible";
	
	private static ArrayList<Car> oneCarOnly = new ArrayList<>();
	
	public void SetupView(CustomerView view) {
		this.customerView = view;
	}
	
	
	public void SetupView(NewCustomerView view) {
		this.newCustomerView = view;
	}
	

//----------


	/**
	 * hladam v zozname zakaznika podla ID, aby si pri registracii mu doplnil info
	 * @param name
	 * @param credit
	 * @param days
	 * @param ID
	 * @param serialNumber
	 */
	public void CustomerInfo(String name, int credit, int days, String ID, int serialNumber) {
		for(int i = 0; i < models.Customer.getCustomerList().size(); i++) {
			if(models.Customer.getCustomerList().get(i).getID().equals(ID)) {
				models.Customer.getCustomerList().get(i).setName(name);
				models.Customer.getCustomerList().get(i).setCredit(credit);
				models.Customer.getCustomerList().get(i).setDays(days);
				models.Customer.getCustomerList().get(i).setIndexInArray(i);
				models.Customer.getCustomerList().get(i).setCarSerialNumber(serialNumber);
			}
		}
	}

    private Car comboBoxConvertible(){
        for (int i = 0; i < models.Convertible.getCars_ConverList().size(); i++) {
            if (newCustomerView.getConvertible().equals(models.Convertible.getCars_ConverList().get(i).getBrand() + " " +
                    models.Convertible.getCars_ConverList().get(i).getModel() + " (" +
                    models.Convertible.getCars_ConverList().get(i).getYearOfProduction() + ")"))
            {
                return models.Convertible.getCars_ConverList().get(i);
            }
        }
        return null;
    }

    private Car comboBoxSUV(){
        for (int i = 0; i < models.SUV.getCars_SUVList().size(); i++) {
            if (newCustomerView.getSUV().equals(models.SUV.getCars_SUVList().get(i).getBrand() + " " +
                    models.SUV.getCars_SUVList().get(i).getModel() + " (" +
                    models.SUV.getCars_SUVList().get(i).getYearOfProduction() + ")"))
            {
                return models.SUV.getCars_SUVList().get(i);
            }
        }
        return null;
    }

    private Car comboBoxSedan(){
        for (int i = 0; i < models.Sedan.getCars_SedanList().size(); i++) {
            if (newCustomerView.getSedan().equals(models.Sedan.getCars_SedanList().get(i).getBrand() + " " +
                    models.Sedan.getCars_SedanList().get(i).getModel() + " (" +
                    models.Sedan.getCars_SedanList().get(i).getYearOfProduction() + ")"))
            {
                return models.Sedan.getCars_SedanList().get(i);
            }
        }
        return null;
    }

	/**
	 * hladanie object Car z vyznacenych moznosti v CB
	 * @param carFromCB
	 * @return
	 */
	public Car ComboBoxCar(String carFromCB) {
		try {
            Car theCar;
			switch(carFromCB) {		//hladanie objektu typu Car vybraneho v ComboBox
				case CONVERTIBLE:
                    theCar = comboBoxConvertible();
                    if (theCar != null){
                        return theCar;
                    }
					break;
				case SUV:
                    theCar = comboBoxSUV();
                    if (theCar != null){
                        return theCar;
                    }
					break;
				case SEDAN:
                    theCar = comboBoxSedan();
                    if (theCar != null){
                        return theCar;
                    }
					break;
				default:
					break;
			}
			return null;
		
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error ComboBoxItems() v CustomerController", e);
			return null; 
		}

	}
	
	/**
	 * pocitanie ceny Car, prve tri dni rucne, potom kazde tri dni sa meni cena
	 * @param carFromCB
	 * @param days
	 * @return
	 */
	public int CarPrice(String carFromCB, int days) {	
		try {
			Car TheCar = ComboBoxCar(carFromCB);
	
			double price = TheCar.getPriceFor3Days();
			int trojDnoveSkoky = 0;
			
			if(days <= 3) {									//rucne 1 - 3
				switch (days) {
					case 1:
						break;
					case 2:
						price *= 1.94;
						break;
					case 3:
						price *= 2.53;
						break;
					default:
						break;
				}
			}
			else {
				price *= 2.53;								//algoritmom 4 - 30
				for (int i = 4; i <= days; i++ ) {
					if ((i % 3) == 0) {
						price = price * utils.StaticDb.cars_price.get(trojDnoveSkoky);
						trojDnoveSkoky++;
					}
					if(i == days) 
						break;	
				}
			}
			
			price = Math.round(price);
			TheCar.setFinalPrice((int)Math.round(price));
			newCustomerView.PriceLb.setText("Price: " + (int)price + "€ ?");
			return TheCar.getSerialNumber();
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error CarPrice() v CustomerController", e);
			return -1;
		}
		
	}

	/**
	 * nacitavanie moznosti v ComboBoxe pomocou ArrayList<String> - ou
	 */
	public void ComboBoxItems() {
		try {
			view.NewCustomerView.getCar_sedan_comboboxList().clear();
			view.NewCustomerView.getCar_suv_comboboxList().clear();
			view.NewCustomerView.getCar_conver_comboboxList().clear();
			view.NewCustomerView.getCar_days_comboboxList().clear();
			
			for(int i = 0; i < models.SUV.getCars_SUVList().size(); i++) {
				if(models.SUV.getCars_SUVList().get(i).getAvailable()) {
					view.NewCustomerView.getCar_suv_comboboxList().add(models.SUV.getCars_SUVList().get(i).getBrand() + " " + 
															models.SUV.getCars_SUVList().get(i).getModel() + " (" + 
															models.SUV.getCars_SUVList().get(i).getYearOfProduction() + ")");
				}
			}
			for(int i = 0; i < models.Sedan.getCars_SedanList().size(); i++) {
				if(models.Sedan.getCars_SedanList().get(i).getAvailable()) {
					view.NewCustomerView.getCar_sedan_comboboxList().add(models.Sedan.getCars_SedanList().get(i).getBrand() + " " + 
																models.Sedan.getCars_SedanList().get(i).getModel() + " (" + 
																models.Sedan.getCars_SedanList().get(i).getYearOfProduction() + ")");
				}
			}
			for(int i = 0; i < models.Convertible.getCars_ConverList().size(); i++) {
				if(models.Convertible.getCars_ConverList().get(i).getAvailable()) {
					view.NewCustomerView.getCar_conver_comboboxList().add(models.Convertible.getCars_ConverList().get(i).getBrand() + " " + 
																	models.Convertible.getCars_ConverList().get(i).getModel() + " (" + 
																	models.Convertible.getCars_ConverList().get(i).getYearOfProduction() + ")");
				}
			}
			for(int i = 1; i <= 30; i++) {
				view.NewCustomerView.getCar_days_comboboxList().add(i);
			}
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error ComboBoxItems() v CustomerController", e);
		}
	}

	
	/**
	 * zistovanie moznosti v prvom CB (SUV, Sedan, Convertible)
	 * @return
	 */
	public String TypeOfCarForComboBox() {
		try {
			newCustomerView.getEmptyCmb().setVisible(false);
			if (newCustomerView.getTypeOfCarCmb().getValue().equals(SEDAN)) {
				newCustomerView.getSedanCmb().setVisible(true);
				newCustomerView.getSUVCmb().setVisible(false);
				newCustomerView.getSUVCmb().setValue(null);
				newCustomerView.getConvertibleCmb().setVisible(false);
				newCustomerView.getConvertibleCmb().setValue(null);
				return newCustomerView.getTypeOfCarCmb().getValue();
			}
			else if (newCustomerView.getTypeOfCarCmb().getValue().equals(SUV)) {
				newCustomerView.getSUVCmb().setVisible(true);
				newCustomerView.getSedanCmb().setVisible(false);
				newCustomerView.getSedanCmb().setValue(null);
				newCustomerView.getConvertibleCmb().setVisible(false);
				newCustomerView.getConvertibleCmb().setValue(null);
				return newCustomerView.getTypeOfCarCmb().getValue();
			}
			else if (newCustomerView.getTypeOfCarCmb().getValue().equals(CONVERTIBLE)) {
				newCustomerView.getConvertibleCmb().setVisible(true);
				newCustomerView.getSedanCmb().setVisible(false);
				newCustomerView.getSedanCmb().setValue(null);
				newCustomerView.getSUVCmb().setVisible(false);
				newCustomerView.getSUVCmb().setValue(null);
				return newCustomerView.getTypeOfCarCmb().getValue();
			}		
			return null;
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error TypeOfCarForComboBox() v CustomerController", e);
			return null;
		}
	}

	
	/**
	 * Exception na prazdne CB
	 * @param carType
	 * @throws EmptyComboBoxException
	 */
	public void CheckComboBox(String carType) throws EmptyComboBoxException{ 
		 if(newCustomerView.getTypeOfCarCmb().getSelectionModel().isEmpty()) {
				newCustomerView.SaveInfoErrorLb.setText("Choose what type of car");
				newCustomerView.SaveInfoErrorLb.setVisible(true);
			 throw new EmptyComboBoxException("Choose what type of car");
		 }
		 switch (carType) {
			 case SUV:
				if(newCustomerView.getSUVCmb().getSelectionModel().isEmpty()) {
					newCustomerView.SaveInfoErrorLb.setText("Choose a SUV");
					newCustomerView.SaveInfoErrorLb.setVisible(true);
					throw new EmptyComboBoxException("Choose a SUV");
				}
				break;
			 case SEDAN:
				 if(newCustomerView.getSedanCmb().getSelectionModel().isEmpty()) {
					newCustomerView.SaveInfoErrorLb.setText("Choose a Sedan");
					newCustomerView.SaveInfoErrorLb.setVisible(true);
					throw new EmptyComboBoxException("Choose a Sedan");
				 }
				 break;
			 case CONVERTIBLE:
				 if(newCustomerView.getConvertibleCmb().getSelectionModel().isEmpty()) {
					newCustomerView.SaveInfoErrorLb.setText("Choose a Convertible");
					newCustomerView.SaveInfoErrorLb.setVisible(true);
					throw new EmptyComboBoxException("Choose a Convertible");
				 }
				 break;
			 default:
				 break;
		 }
		 if(newCustomerView.getDaysCmb().getSelectionModel().isEmpty()) {
			newCustomerView.SaveInfoErrorLb.setText("Choose for how many days");
			newCustomerView.SaveInfoErrorLb.setVisible(true);
			throw new EmptyComboBoxException("Choose for how many days");
		 }
	}

	/**
	 * Exception na prazdnu Registraciu
	 * @throws NotRegisteredCustomerException
	 */
	public void CheckCustomerRegistration() throws NotRegisteredCustomerException{
		if (newCustomerView.getNameTf().getText().equals("") || newCustomerView.getCreditTf().getText().equals("")) {
			newCustomerView.SaveInfoErrorLb.setText("Register!");
			newCustomerView.SaveInfoErrorLb.setVisible(true);
			throw new NotRegisteredCustomerException("Register!");
		}
	}
	
	/**
	 * Exception na malo Creditu oproti vypocitenej ceny
	 * @param carFromCB
	 * @throws EmptyComboBoxException
	 */
	public void checkCreditAndPrice(String carFromCB) throws EmptyComboBoxException{

		Car TheCar = ComboBoxCar(carFromCB);
		if(TheCar.getFinalPrice() > Integer.valueOf(newCustomerView.getCreditTf().getText())) {
			newCustomerView.SaveInfoErrorLb.setText("You don't have enough Credit!");
			newCustomerView.SaveInfoErrorLb.setVisible(true);
			throw new EmptyComboBoxException("Not enough Credit");
		}
		
	}

	
	
	
//----------
	
	
	
	public void CustomerOrderLayout(String ID) {
		try {
			Order order = FindOrder(ID);
			User userCustomer = models.Customer.getCustomerList().get(models.Customer.FindCustomerIndex(ID));
			
			if(userCustomer.getHasCar()) {	//zakaznik ma pozicane auto
				customerView.NameLb.setText(order.getName());
				customerView.IDLb.setText(order.getID());
				customerView.CredtidLb.setText(String.valueOf(order.getCredit()));
				customerView.CarLb.setText(order.getBrand() + " " + order.getModel() + " (" + order.getYearOfProduction() + ")");
				customerView.DaysLeft.setText(String.valueOf(CheckDate(ID)));

			}else {						//zakaznik nema pozicane auto
				customerView.NameLb.setText(order.getName());
				customerView.IDLb.setText(order.getID());
				customerView.CredtidLb.setText(String.valueOf(order.getCredit()));
				customerView.ReturnCarBtn.setVisible(false);
				customerView.CarLb2.setVisible(false);
				customerView.NoCarLb.setVisible(true);
			}
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error CustomerOrderLayout() v CustomerController", e);
		}
	}

	public Order FindOrder(String ID) {
		try {
			for(int i = 0; i < models.Order.getOrderList().size(); i++) {
				if(models.Order.getOrderList().get(i).getID().equals(ID)) {
					Order order = models.Order.getOrderList().get(i);
					return order;
				}
			}
			return null;
			
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error FindOrder() in CustomerController", e);
			return null;
		}
	}

	public void ReturnCar() {
		try {
			LOGGER.info("ReturnCar() v CustomerController - returning car");
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error ReturnCar() in CustomerController", e);
		}
	}
	
	public boolean CheckDateBool(String ID) {		//return true ked splnil dnovy limit 
		try {
			Date dateNow = new Date();
			Order order = FindOrder(ID);
			
			int daysdiff = 0;
			long diff = dateNow.getTime() - order.getDate().getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
			daysdiff = (int) diffDays;
			
			if(daysdiff <= order.getForHowLong())
				return true;
			else
				return false;
			
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error CheckDate() in CustomerController", e);
			return false;
		}
	}
	
	public int CheckDate(String ID) {		//zostavajuci pocet dni 
		try {
			Date dateNow = new Date();
			Order order = FindOrder(ID);
			int days = order.getForHowLong();

			int daysdiff = 0;
			long diff = dateNow.getTime() - order.getDate().getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
			daysdiff = (int) diffDays;
			
			return (days - daysdiff);
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error CheckDate() in CustomerController", e);
			return -1;
		}
	}

	public ArrayList<Car> getOneCarOnly(){
		return oneCarOnly;
	}
}
