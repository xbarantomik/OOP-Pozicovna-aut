package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Convertible extends Car  implements Serializable{

	private static final long serialVersionUID = 3484670098499424702L;
	public static final Logger LOGGER = Logger.getLogger(Convertible.class.getName());
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

	@Override
	public void IsAvailable() {
		this.Available = true;
	}

	@Override
	public void IsNotAvailable() {
		this.Available = false;
	}
	

	@Override
	public void Serialize() {
		try {
			String fileName = "serialized/Serialized-CONVERTIBLE.txt";
			serialize.Serialization.Update(getCars_ConverList(), fileName);
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR Serialize() in CONVERTIBLE", e);
		} 
	}

	@Override
	public void addCar(Car car) {
		// overwrites a parent function (polymorphism)
	}
	
	public static ArrayList<Car> getCars_ConverList(){
		return cars_conver;
	}
	public static void setCars_ConverList(ArrayList<Car> array){
		cars_conver = array;
	}
}
