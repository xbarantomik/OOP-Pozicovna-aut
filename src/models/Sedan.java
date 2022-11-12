package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Sedan extends Car  implements Serializable{
	
	private static final long serialVersionUID = 3011267682884692650L;
	
	private static ArrayList<Car> cars_sedan = new ArrayList<>();

	public Sedan(){
		
	}
	
	public Sedan(String brand, String model, String yearOfProduction, String priceFor3Days, String serialNumber) {
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
			String fileName = "serialized/Serialized-SEDAN.txt";
			serialize.Serialization.Update(getCars_SedanList(), fileName);
		} catch(Exception e2) {
			System.out.println("ERROR Serialize() v Sedan");
			e2.printStackTrace();
		} 
	}
	
	public void addCar(Car car) {
		
	}
	


	
	public static ArrayList<Car> getCars_SedanList(){
		return cars_sedan;
	}
	public static void setCars_SedanList(ArrayList<Car> array){
		cars_sedan = array;
	}
}
