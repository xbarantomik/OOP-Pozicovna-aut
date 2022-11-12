package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import interfaces.IDate;
import interfaces.ISerializeUpdate;

public class Order implements Serializable, IDate, ISerializeUpdate{

	private static final long serialVersionUID = 2369357396475779277L;
	
	
	private static ArrayList<Order> orderList = new ArrayList<>();
	
	
	private String Name;
	private String ID;
	private int Credit;
	private String Brand;
	private String Model;
	private int YearOfProduction;
	private int Price;
	private int Deposit;
	private Date Date;
	private int ForHowLong;
	private int IndexInArray;
	private int CarSerialNumber;
	private String CarType;
	
	
	public Order() {
		
	}
	
	public Order(Car car, User customer) {
		
		this.Name = customer.getName();
		this.ID = customer.getID();
		this.Credit = customer.getCredit();
		this.Brand = car.getBrand();
		this.Model = car.getModel();
		this.YearOfProduction = car.getYearOfProduction();
		this.Price = car.getFinalPrice();
		this.Deposit = car.getDeposit();
		this.getdate();
		this.ForHowLong = customer.getDays();
		this.CarSerialNumber = car.getSerialNumber();
		this.CarType = car.getCarType();
	}
	

	@Override
	public void getdate() {
		this.Date = new Date();
	}

	
	@Override
	public void Serialize() {
		try {
			String fileName = "serialized/Serialized-ORDERS.txt";
			serialize.Serialization.Update(getOrderList(), fileName);
		} catch(Exception e2) {
			System.out.println("ERROR Update() v Order");
			e2.printStackTrace();
		} 
	}


	public void addOrder(Order list) {
		list.setIndexInArray(orderList.size());
		orderList.add(list);
	}
	
	public void deleteOrder(int index) {
		Iterator<Order> itr = orderList.iterator();
		while(itr.hasNext()) {
			Order ord = itr.next();
			if(ord.getIndexInArray() == index) {
				itr.remove();
			}
		}
		for(int i = 0; i < orderList.size(); i++) {
			orderList.get(i).setIndexInArray(i);
		}
	}
	
	
	public void SubPriceAndDeposit(Car car, User customer) {
		customer.setCredit(customer.getCredit() - car.getDeposit() - car.getFinalPrice()); 
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
	public int getCredit() {
		return Credit;
	}
	public void setCredit(int credit) {
		this.Credit = credit;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		this.Brand = brand;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		this.Model = model;
	}
	public int getYearOfProduction() {
		return YearOfProduction;
	}
	public void setYearOfProduction(int yearOfProduction) {
		this.YearOfProduction = yearOfProduction;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		this.Price = price;
	}
	public int getDeposit() {
		return Deposit;
	}
	public void setDeposit(int deposit) {
		this.Deposit = deposit;
	}
	public static ArrayList<Order> getOrderList(){
		return orderList;
	}
	public static void setOrderList(ArrayList<Order> list){
		orderList = list;
	}
	public Date getDate() {
		return Date;
	}
	public int getForHowLong() {
		return ForHowLong;
	}
	public void setForHowLong(int days) {
		this.ForHowLong = days;
	}
	public int getIndexInArray() {
		return IndexInArray;
	}
	public void setIndexInArray(int index) {
		this.IndexInArray = index;
	}
	public int getCarSerialNumber() {
		return CarSerialNumber;
	}
	public void setCarSerialNumber(int index) {
		this.CarSerialNumber = index;
	}
	public String getCarType() {
		return CarType;
	}
	public void setCarType(String carType) {
		this.CarType = carType;
	}

	
}
