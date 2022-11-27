package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sedan extends Car  implements Serializable{
	
	private static final long serialVersionUID = 3011267682884692650L;
	public static final Logger LOGGER = Logger.getLogger(Sedan.class.getName());
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
			String fileName = "serialized/Serialized-SEDAN.txt";
			serialize.Serialization.Update(getCars_SedanList(), fileName);
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR Serialize() in Sedan", e);
		} 
	}

	@Override
	public void addCar(Car car) {
		// overwrites a parent function (polymorphism)
	}

	public static ArrayList<Car> getCars_SedanList(){
		return cars_sedan;
	}
	public static void setCars_SedanList(ArrayList<Car> array){
		cars_sedan = array;
	}
}
