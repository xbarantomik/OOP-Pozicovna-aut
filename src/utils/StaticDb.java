package utils;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.*;
import java.io.ObjectInputStream;
import java.nio.file.Paths;
import java.util.Scanner;
import models.*;

public class StaticDb{

	public static ArrayList<Double> cars_price = new ArrayList<>(); 

	
	public static void InitializeEmployee() {		
		try {
			models.Employee.getEmployeeList().clear();
			
			Scanner sc1 = new Scanner(Paths.get("Cars/EmployeesTXT.txt"));
			while(sc1.hasNext()){ 
				models.Employee.getEmployeeList().add(new Employee(sc1.nextLine(), sc1.nextLine(), sc1.nextLine()));
			}
			sc1.close();
		} catch (Exception e) {
 			System.out.println("ERROR InitializeEmployee()");
			e.printStackTrace();
		}
	}
	
	public static void InitializeCars() {
		try {
			int poc = 0;
			models.SUV.getCars_SUVList().clear();
			models.Sedan.getCars_SedanList().clear();
			models.Convertible.getCars_ConverList().clear();
			
			Scanner sc1 = new Scanner(Paths.get("Cars/SUVTXT.txt"));
			while(sc1.hasNext()){ 
				models.SUV.getCars_SUVList().add(new SUV(sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine()));
				models.SUV.getCars_SUVList().get(poc).IsAvailable();
				models.SUV.getCars_SUVList().get(poc++).setCarType("SUV");
			}
			poc = 0;
			Scanner sc2 = new Scanner(Paths.get("Cars/SedanTXT.txt"));
			while(sc2.hasNext()){ 
				models.Sedan.getCars_SedanList().add(new Sedan(sc2.nextLine(), sc2.nextLine(), sc2.nextLine(), sc2.nextLine(), sc2.nextLine()));
				models.Sedan.getCars_SedanList().get(poc).IsAvailable();
				models.Sedan.getCars_SedanList().get(poc++).setCarType("Sedan");
			}
			poc = 0;
			Scanner sc3 = new Scanner(Paths.get("Cars/ConvertibleTXT.txt"));
			while(sc3.hasNext()){ 
				models.Convertible.getCars_ConverList().add(new Convertible(sc3.nextLine(), sc3.nextLine(), sc3.nextLine(), sc3.nextLine(), sc3.nextLine()));
				models.Convertible.getCars_ConverList().get(poc).IsAvailable();
				models.Convertible.getCars_ConverList().get(poc++).setCarType("Convertible");
			}
			sc1.close();
			sc2.close();
			sc3.close();
			
		} catch (Exception e) {
 			System.out.println("ERROR InitializeCars()");
			e.printStackTrace();
		}
	}
		
			
	public static void InitializeCarsPriceList() {
		try {
			Scanner sc = new Scanner(Paths.get("PriceList.txt"));
			while(sc.hasNext()){ 
				cars_price.add(Double.parseDouble(sc.nextLine()));
			}

			sc.close();
		} catch (Exception e) {
 			System.out.println("ERROR InitializeCarsPriceList()");
			e.printStackTrace();
		}
	}

	
	public static void CustomersArrayPrintOut() {			//button na vypis customers array
		try {
			int poc = 0;
			if(models.Customer.getCustomerList().isEmpty()) {
				System.out.println("Customers je Empty");
				return;
			}
			for(int i = 0;i < models.Customer.getCustomerList().size(); i++) {
				System.out.println("Name: " + models.Customer.getCustomerList().get(poc).getName() + ", ID: " + 
											models.Customer.getCustomerList().get(poc).getID() + ", credit: " + 
											models.Customer.getCustomerList().get(poc++).getCredit());
			}
			System.out.println("");
		}catch(Exception e) {
			System.out.println("ERROR CustomersArrayPrintOut()");
			e.printStackTrace();
		}
	}
	
	
	
	public static void OrderArrayPrintOut() {			//button na vypis order array
		try {
			int poc = 0;
			
			if(models.Order.getOrderList().isEmpty()) {
				System.out.println("orderList je Empty");
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
			System.out.println("ERROR OrderArrayPrintOut()");
			e.printStackTrace();
		}
	}

	
	public static ArrayList<Order> DeserializeOrder(String text) throws Exception{		
		try{
			ArrayList<Order> array = new ArrayList<>();
	        FileInputStream fis = new FileInputStream(text);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        
	        array = (ArrayList<Order>) ois.readObject();			
		    ois.close();
	        fis.close();	     
		    return array;
	    } catch (FileNotFoundException c) {
	       System.out.println("File not found - DeserializeOrder v StaticDb\n" + c);
	       return null;
	    }
	    catch (IOException ioe) {
	        System.out.println("ERROR DeserializeOrder v StaticDb\n" + ioe);
	        ioe.printStackTrace();
	        return null;
	    } 
	}
	
	public static ArrayList<User> DeserializeUser(String text) throws Exception{		
		try{
			ArrayList<User> array = new ArrayList<>();
	        FileInputStream fis = new FileInputStream(text);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        
	        array = (ArrayList<User>) ois.readObject();			
		    ois.close();
	        fis.close();	     
		    return array;
	    } catch (FileNotFoundException c) {
	       System.out.println("File not found - DeserializeUser v StaticDb\n" + c);
	       return null;
	    }
	    catch (IOException ioe) {
	        System.out.println("ERROR DeserializeUser v StaticDb\n" + ioe);
	        ioe.printStackTrace();
	        return null;
	    } 
	}		
	
	public static ArrayList<Car> DeserializeCar(String text) throws Exception{		
		try{
			ArrayList<Car> array = new ArrayList<>();
	        FileInputStream fis = new FileInputStream(text);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        
	        array = (ArrayList<Car>) ois.readObject();			
		    ois.close();
	        fis.close();	     
		    return array;
	    } catch (FileNotFoundException c) {
	       System.out.println("File not found - DeserializeCar v StaticDb\n" + c);
	       return null;
	    }
	    catch (IOException ioe) {
	        System.out.println("ERROR DeserializeCarv v StaticDb\n" + ioe);
	        ioe.printStackTrace();
	        return null;
	    } 
	}	
	
	public static ArrayList<String> DeserializeString(String text) throws Exception{		
		try{
			ArrayList<String> array = new ArrayList<>();
	        FileInputStream fis = new FileInputStream(text);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        
	        array = (ArrayList<String>) ois.readObject();			
		    ois.close();
	        fis.close();	     
		    return array;
	    } catch (FileNotFoundException c) {
	       System.out.println("File not found - DeserializeCar v StaticDb\n" + c);
	       return null;
	    }
	    catch (IOException ioe) {
	        System.out.println("ERROR DeserializeCarv v StaticDb\n" + ioe);
	        ioe.printStackTrace();
	        return null;
	    } 
	}

	
}

 