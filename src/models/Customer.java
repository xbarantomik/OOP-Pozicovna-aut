package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer extends User implements Serializable{
	

	private static final long serialVersionUID = -3963819229986716453L;
	public static final Logger LOGGER = Logger.getLogger(Customer.class.getName());
	private static ArrayList<User> customers = new ArrayList<>();
	private static ArrayList<String> banList = new ArrayList<>();
	

	public Customer() {
		
	}
	
	public Customer(String id) {
		this.setID(id);
	}
	
	public Customer(String name, String id, String credit) {
		this.setName(name);
		this.setID(id);
		this.setCredit(Integer.valueOf(credit));
	}

	@Override
	public void delUser(int index) {
		Iterator<User> itr = customers.iterator();
		while(itr.hasNext()) {
			User cust = itr.next();
			if(cust.getIndexInArray() == index) {
				itr.remove();
			}
		}
		for(int i = 0; i < customers.size(); i++) {
			customers.get(i).setIndexInArray(i);
		}
	}

	@Override
	public void Serialize() {
		try {
			String fileName = "serialized/Serialized-CUSTOMERS.txt";
			serialize.Serialization.Update(getCustomerList(), fileName);
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR Serialize() v Customer", e);
		} 
	}

	@Override
	public void GetTime() {
		// overwrites a parent function (polymorphism)
	}

	@Override
	public void addDepositToCredit(Order order) {
		this.setCredit(order.getDeposit() + this.getCredit());
	}

	@Override
	public void LogInSpecific(boolean b) {
		this.LoginController.StartCustomerSession(b);
	}

	
	public Customer CreateNewCustomer(String cisloOP) {
		Customer newCustomer = new Customer();
		newCustomer.setID(cisloOP);

		customers.add(newCustomer);
		return newCustomer;
	}

	@Override
	public void AddToBanList(User customer) {
		banList.add(customer.getID());
	}

	@Override
	public void SerializeBanList() {
		try {
			String fileName = "serialized/Serialized-BANLIST.txt";
			serialize.Serialization.Update(getBanList(), fileName);
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR SerializeBanList() v Customer", e);
		} 
	}
	
	public static int FindCustomerIndex(String ID) {
		try {
			for(int i = 0; i <customers.size(); i++) {
				if(customers.get(i).getID().equals(ID))
					return i;
			}
			return -1;
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error FindCustomerIndex() v Customer", e);
			return -1;
		}
	}

	
	public static ArrayList<User> getCustomerList(){
		return customers;
	}
	public static void setCustomerList(ArrayList<User> Customers){
		customers = Customers;
	}
	public static ArrayList<String> getBanList(){
		return banList;
	}
	public static void setBanList(ArrayList<String> list){
		banList = list;
	}
}
