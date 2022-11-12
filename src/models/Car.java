package models;

import java.io.Serializable;
import interfaces.ISerializeUpdate;
import interfaces.IAvailAble;

public class Car implements IAvailAble, Serializable, ISerializeUpdate{


	private static final long serialVersionUID = 5091738390176031388L;
	
	protected String Brand;
	protected String Model;
	protected int YearOfProduction;
	protected double PriceFor3Days;
	protected int FinalPrice;
	protected int Deposit;
	protected boolean Available;
	protected int IndexOfUsage = 0;
	protected int SerialNumber;
	protected String CarType;
	protected int IndexInArrayList;


	
	public void IsAvailable() {
		
	}
	
	public void IsNotAvailable() {

	}
	
	public Car() {
		
	}

	public void addCar(Car car) {
		
	}
	
	@Override
	public void Serialize() {

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
	public double getPriceFor3Days() {
		return PriceFor3Days;
	}	
	public void setPriceFor3Days(double priceFor3Days) {
		this.PriceFor3Days = priceFor3Days;
	}	
	public int getFinalPrice() {
		return FinalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.FinalPrice = finalPrice;
	}
	public String getFinalPriceString() {
		return String.valueOf(FinalPrice);
	}
	public boolean getAvailable() {
		return Available;
	}
	public int getDeposit() {
		return Deposit;
	}	
	public void setDeposit(int deposit) {
		this.Deposit = deposit;
	}	
	public int getIndexOfUsage() {
		return IndexOfUsage;
	}	
	public void setIndexOfUsage(int index) {
		this.IndexOfUsage = index;
	}	
	public int getSerialNumber() {
		return SerialNumber;
	}	
	public void setSerialNumber(int serialNumber) {
		this.SerialNumber = serialNumber;
	}	
	public String getCarType() {
		return CarType;
	}	
	public void setCarType(String carType) {
		this.CarType = carType;
	}
	public int getIndexInArrayList() {
		return IndexInArrayList;
	}	
	public void setIndexInArrayList(int indexInArrayList) {
		this.IndexInArrayList = indexInArrayList;
	}

	
	
	
	
}
