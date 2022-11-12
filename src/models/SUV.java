package models;

import java.io.Serializable;
import java.util.ArrayList;

public class SUV extends Car  implements Serializable{
	
	private static final long serialVersionUID = 387818384086766933L;

	private static ArrayList<Car> cars_suv = new ArrayList<>();
	
	public SUV(){
		
	}
	
	public SUV(String brand, String model, String yearOfProduction, String priceFor3Days, String serialNumber) {
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
			String fileName = "serialized/Serialized-SUV.txt";
			serialize.Serialization.Update(getCars_SUVList(), fileName);
		} catch(Exception e2) {
			System.out.println("ERROR Serialize() v SUV");
			e2.printStackTrace();
		} 
	}
	
	public void addCar(Car car) {
		
	}

	
	public static ArrayList<Car> getCars_SUVList(){
		return cars_suv;
	}
	public static void setCars_SUVList(ArrayList<Car> array){
		cars_suv = array;
	}

	
}
