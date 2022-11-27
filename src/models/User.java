package models;

import java.io.Serializable;
import controllers.LoginController;
import interfaces.ISerializeUpdate;


public class User implements Serializable, ISerializeUpdate{


	private static final long serialVersionUID = 6973818821217703232L;
	
	protected String Name;
	protected String ID;
	protected String Password;
	protected String Login;
	protected int Credit;
	protected boolean HasCar = false;
	protected LoginController LoginController;
	protected boolean NewCustomer;
	protected int Days;
	protected int IndexInArray;
	protected int CarSerialNumber;
	
	/**
	 * ked idem zaregistrovate noveho zakaznika tak je NewCustomer == true
	 * @param loginController
	 * @return
	 */
	public User LogInNewCustomer(LoginController loginController) {
		NewCustomer = true;
		this.LoginController = loginController;
		LogInSpecific(NewCustomer);
		return this;
	}
	
	/**
	 * ked idem zaregistrovate noveho zakaznika tak je NewCustomer == false
	 * @param loginController
	 * @return
	 */
	public User LogIn(LoginController loginController) {
		NewCustomer = false;
		this.LoginController = loginController;
		LogInSpecific(NewCustomer);
		return this;
	}
	
	public void delUser(int index) {
		// will be overwritten (polymorphism)
	}

	public void GetTime() {
		// will be overwritten (polymorphism)
	}

	public void addDepositToCredit(Order order) {
		// will be overwritten (polymorphism)
	}
	
	protected void LogInSpecific(boolean b) {
		// will be overwritten (polymorphism)
	}
	
	@Override
	public void Serialize() {
		// will be overwritten (polymorphism)
	}
	
	public void SerializeBanList() {
		// will be overwritten (polymorphism)
	}
	public void AddToBanList(User customer) {
		// will be overwritten (polymorphism)
	}
	

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		this.ID = id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		this.Login = login;
	}
	public int getCredit() {
		return Credit;
	}
	public void setCredit(int credit) {
		this.Credit = credit;
	}
	public boolean getHasCar() {
		return HasCar;
	}
	public void setHasCar(boolean b) {
		this.HasCar = b;
	}
	public int getDays() {
		return Days;
	}
	public void setDays(int days) {
		this.Days = days;
	}
	public int getIndexInArray() {
		return IndexInArray;
	}
	public void setIndexInArray(int indexInArray) {
		this.IndexInArray = indexInArray;
	}
	public int getCarSerialNumber() {
		return CarSerialNumber;
	}
	public void setCarSerialNumber(int carSerialNumber) {
		this.CarSerialNumber = carSerialNumber;
	}
}

