package utils;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.*;
import java.io.ObjectInputStream;
import java.nio.file.Paths;
import java.util.Scanner;
import models.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StaticDb{

	public static ArrayList<Double> cars_price = new ArrayList<>();
	public static final Logger LOGGER = Logger.getLogger(StaticDb.class.getName());

	public static void InitializeEmployee() {
		try (
				Scanner sc1 = new Scanner(Paths.get("Cars/EmployeesTXT.txt"));
		) {
			models.Employee.getEmployeeList().clear();
			while (sc1.hasNext()) {
				models.Employee.getEmployeeList().add(new Employee(sc1.nextLine(), sc1.nextLine(), sc1.nextLine()));
			}
		}
		catch (Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR InitializeEmployee()", e);
		}
	}
	
	public static void InitializeCars() {
		try (
				Scanner sc1 = new Scanner(Paths.get("Cars/SUVTXT.txt"));
				Scanner sc2 = new Scanner(Paths.get("Cars/SedanTXT.txt"));
				Scanner sc3 = new Scanner(Paths.get("Cars/ConvertibleTXT.txt"));
		) {
			models.SUV.getCars_SUVList().clear();
			models.Sedan.getCars_SedanList().clear();
			models.Convertible.getCars_ConverList().clear();
			int poc = 0;
			while (sc1.hasNext()) {
				models.SUV.getCars_SUVList().add(new SUV(sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine()));
				models.SUV.getCars_SUVList().get(poc).IsAvailable();
				models.SUV.getCars_SUVList().get(poc++).setCarType("SUV");
			}
			poc = 0;
			while (sc2.hasNext()) {
				models.Sedan.getCars_SedanList().add(new Sedan(sc2.nextLine(), sc2.nextLine(), sc2.nextLine(), sc2.nextLine(), sc2.nextLine()));
				models.Sedan.getCars_SedanList().get(poc).IsAvailable();
				models.Sedan.getCars_SedanList().get(poc++).setCarType("Sedan");
			}
			poc = 0;
			while (sc3.hasNext()) {
				models.Convertible.getCars_ConverList().add(new Convertible(sc3.nextLine(), sc3.nextLine(), sc3.nextLine(), sc3.nextLine(), sc3.nextLine()));
				models.Convertible.getCars_ConverList().get(poc).IsAvailable();
				models.Convertible.getCars_ConverList().get(poc++).setCarType("Convertible");
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR InitializeCars()", e);
		}
	}
		
			
	public static void InitializeCarsPriceList() {
		try (
				Scanner sc = new Scanner(Paths.get("PriceList.txt"));
		) {
			while (sc.hasNext()) {
				cars_price.add(Double.parseDouble(sc.nextLine()));
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR InitializeCarsPriceList()", e);
		}
	}

	
	public static void CustomersArrayPrintOut() {			//button na vypis customers array
		try {
			int poc = 0;
			if(models.Customer.getCustomerList().isEmpty()) {
				System.out.println("Customers is Empty");
				return;
			}
			for(int i = 0;i < models.Customer.getCustomerList().size(); i++) {
				System.out.println("Name: " + models.Customer.getCustomerList().get(poc).getName() + ", ID: " + 
											models.Customer.getCustomerList().get(poc).getID() + ", credit: " + 
											models.Customer.getCustomerList().get(poc++).getCredit());
			}
			System.out.println("");
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR CustomersArrayPrintOut()", e);
		}
	}
	
	public static void OrderArrayPrintOut() {			//button na vypis order array
		try {
			int poc = 0;

			if(models.Order.getOrderList().isEmpty()) {
				System.out.println("orderList is Empty");
				return;
			}
			for(int i = 0;i < models.Order.getOrderList().size(); i++) {
				System.out.println(models.Order.getOrderList().get(poc).getBrand() + " " +
						models.Order.getOrderList().get(poc).getModel() + " : Name: " +
						models.Order.getOrderList().get(poc).getName() + ", ID: " +
						models.Order.getOrderList().get(poc).getID() + ", credit: " +
						models.Order.getOrderList().get(poc++).getCredit());
			}
			System.out.println("");
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR OrderArrayPrintOut()", e);
		}
	}

	
	public static ArrayList<Order> DeserializeOrder(String text) throws Exception {
		try (
				FileInputStream	fis = new FileInputStream(text);
				ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			ArrayList<Order> array;
			array = (ArrayList<Order>) ois.readObject();
			return array;
		} catch (FileNotFoundException c) {
			LOGGER.log(Level.SEVERE, "File not found - DeserializeOrder in StaticDb\n", c);
			return new ArrayList<>();
		} catch (IOException ioe) {
			LOGGER.log(Level.SEVERE, "ERROR DeserializeOrder in StaticDb\n", ioe);
			return new ArrayList<>();
		}
	}
	
	public static ArrayList<User> DeserializeUser(String text) throws Exception {
		try (
				FileInputStream	fis = new FileInputStream(text);
				ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			ArrayList<User> array;
			array = (ArrayList<User>) ois.readObject();
			return array;
		} catch (FileNotFoundException c) {
			LOGGER.log(Level.SEVERE, "File not found - DeserializeUser in StaticDb\n", c);
			return new ArrayList<>();
		} catch (IOException ioe) {
			LOGGER.log(Level.SEVERE, "ERROR DeserializeUser in StaticDb\n", ioe);
			return new ArrayList<>();
		}
	}		
	
	public static ArrayList<Car> DeserializeCar(String text) throws Exception {
		try (
				FileInputStream	fis = new FileInputStream(text);
				ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			ArrayList<Car> array;
			array = (ArrayList<Car>) ois.readObject();
			return array;
		} catch (FileNotFoundException c) {
			LOGGER.log(Level.SEVERE, "File not found - DeserializeCar in StaticDb\n", c);
			return new ArrayList<>();
		} catch (IOException ioe) {
			LOGGER.log(Level.SEVERE, "ERROR DeserializeCar in StaticDb\n", ioe);
			return new ArrayList<>();
		}
	}	
	
	public static ArrayList<String> DeserializeString(String text) throws Exception {
		try (
				FileInputStream	fis = new FileInputStream(text);
				ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			ArrayList<String> array;
			array = (ArrayList<String>) ois.readObject();
			return array;
		} catch (FileNotFoundException c) {
			LOGGER.log(Level.SEVERE, "File not found - DeserializeCar in StaticDb\n", c);
			return new ArrayList<>();
		} catch (IOException ioe) {
			LOGGER.log(Level.SEVERE, "\"ERROR DeserializeCar in StaticDb\\n", ioe);
			return new ArrayList<>();
		}
	}
}