package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Convertible extends Car  implements Serializable{

	private static final long serialVersionUID = 3484670098499424702L;
	
	private static ArrayList<Car> cars_conver = new ArrayList<>();

	public Convertible(){
		
	}
	
	public Convertible(String brand, String model, String yearOfProduction, String priceFor3Days, String serialNumber) {
		this.setBrand(brand);
		this.setModel(model);
		this.setYearOfProduction(Integer.valueOf(yearOfProduction));
		this.setPriceFor3Days(Double.valueOf(priceFor3Days));
		this.setSerialNumber(Integer.valueOf(serialNumber));
	}
	
	public void IsAvailable() {
		this.Available = true;
	}
	
	public void IsNotAvailable() {
		this.Available = false;
	}
	

	@Override
	public void Serialize() {
		try {
			String fileName = "serialized/Serialized-CONVERTIBLE.txt";
			serialize.Serialization.Update(getCars_ConverList(), fileName);
		} catch(Exception e2) {
			System.out.println("ERROR Serialize() v CONVERTIBLE");
			e2.printStackTrace();
		} 
	}

	public void addCar(Car car) {
		
	}
	
	public static ArrayList<Car> getCars_ConverList(){
		return cars_conver;
	}
	public static void setCars_ConverList(ArrayList<Car> array){
		cars_conver = array;
	}
}
