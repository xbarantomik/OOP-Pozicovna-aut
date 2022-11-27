package view;

import java.util.ArrayList;

import controllers.CustomerController;
import exceptions.EmptyComboBoxException;
import exceptions.NotRegisteredCustomerException;
import controllers.AYSOrderController;
import view.LoginView;
import view.AYSOrderView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NewCustomerView extends Application{


	public static final Logger LOGGER = Logger.getLogger(NewCustomerView.class.getName());
	public CustomerController controllerForCustomer = new CustomerController();
	public LoginView viewForLogin = new LoginView();
	public AYSOrderController controllerForAreYouSureOrder = new AYSOrderController();
	public AYSOrderView viewForAreYouSureOrder = null;
	
	private static ArrayList<String> car_suv_combobox = new ArrayList<>();
	private static ArrayList<String> car_sedan_combobox = new ArrayList<>();
	private static ArrayList<String> car_convertible_combobox = new ArrayList<>();
	private static ArrayList<Integer> car_days_combobox = new ArrayList<>();
	private static ArrayList<Stage> closingStageNewCustomer = new ArrayList<>();
	

	public Label CustomerLabel = new Label("Register & Rent");
	public Pane pane = new Pane();	
	public Button RegisterBtn = new Button("Register");
	public Button BackBtn = new Button("Back/Cancel");
	private TextField NameTf = new TextField();
	private TextField IDTf = new TextField();
	private TextField CreditTf = new TextField();
	public Label SaveInfoErrorLb = new Label("");
	private ComboBox<String> TypeOfCarCmb = new ComboBox<>();
	private ComboBox<String> SUVCmb = new ComboBox<>();
	private ComboBox<String> SedanCmb = new ComboBox<>();
	private ComboBox<String> ConvertibleCmb = new ComboBox<>();
	private ComboBox<String> EmptyCmb = new ComboBox<>();
	public ComboBox<Integer> DaysCmb = new ComboBox<>();
	public Button PriceBtn = new Button("Calculate the price");
	public Label PriceLb = new Label("");
	public static Label HiddenIDLb = new Label();
	public Button PlaceOrderBtn = new Button("Place an Order");
	private String CarFromCB;
	static final String FONT = "Cambria";
	static final String TEXT_PROMPT_CHOOSE = "--- choose ---";

	private void setLayout() {	
		
		CustomerLabel.setLayoutX(200); 
		CustomerLabel.setLayoutY(30);
		CustomerLabel.setMinWidth(100);
		CustomerLabel.setMinHeight(30);
		CustomerLabel.setFont(new Font(FONT, 28));
		
		RegisterBtn.setLayoutX(87);
		RegisterBtn.setLayoutY(286);
		RegisterBtn.setMinWidth(100);
		RegisterBtn.setMinHeight(30);
		RegisterBtn.setFont(new Font(FONT, 17));
		RegisterBtn.setVisible(false);
		
		BackBtn.setLayoutX(40);
		BackBtn.setLayoutY(410);
		BackBtn.setMinWidth(80);
		BackBtn.setMinHeight(30); 
		BackBtn.setFont(new Font(FONT, 20));
		
		NameTf.setLayoutX(40);
		NameTf.setLayoutY(120);
		NameTf.setMinWidth(80);
		NameTf.setMinHeight(30);
		NameTf.setFont(new Font(FONT, 16));
		NameTf.setPromptText("Name");	
		
		IDTf.setLayoutX(40);
		IDTf.setLayoutY(170);
		IDTf.setMinWidth(80);
		IDTf.setMinHeight(30);
		IDTf.setFont(new Font(FONT, 16));
		IDTf.setPromptText("ID");
		IDTf.setText(view.LoginView.getCustomerIDTfText());
		IDTf.setEditable(false);
		
		CreditTf.setLayoutX(40);
		CreditTf.setLayoutY(220);
		CreditTf.setMinWidth(80);
		CreditTf.setMinHeight(30);
		CreditTf.setFont(new Font(FONT, 16));
		CreditTf.setPromptText("Credit [€]");
		
		SaveInfoErrorLb.setLayoutX(35);
		SaveInfoErrorLb.setLayoutY(340);
		SaveInfoErrorLb.setMinWidth(100);
		SaveInfoErrorLb.setMinHeight(30);
		SaveInfoErrorLb.setFont(new Font(FONT, 17));
		SaveInfoErrorLb.setVisible(false);
		
		TypeOfCarCmb.setLayoutX(340);
		TypeOfCarCmb.setLayoutY(120);
		TypeOfCarCmb.setMinWidth(200);
		TypeOfCarCmb.setMinHeight(30);
		TypeOfCarCmb.setPromptText("Type of car");
		TypeOfCarCmb.getItems().addAll("Sedan", "SUV", "Convertible");
		
		SUVCmb.setLayoutX(340);
		SUVCmb.setLayoutY(170);
		SUVCmb.setMinWidth(200);
		SUVCmb.setMinHeight(30);
		SUVCmb.setPromptText(TEXT_PROMPT_CHOOSE);
		SUVCmb.setItems(FXCollections.observableArrayList(car_suv_combobox));
		SUVCmb.setVisible(false);
		
		SedanCmb.setLayoutX(340);
		SedanCmb.setLayoutY(170);
		SedanCmb.setMinWidth(200);
		SedanCmb.setMinHeight(30);
		SedanCmb.setPromptText(TEXT_PROMPT_CHOOSE);
		SedanCmb.setItems(FXCollections.observableArrayList(car_sedan_combobox));
		SedanCmb.setVisible(false);
		
		ConvertibleCmb.setLayoutX(340);
		ConvertibleCmb.setLayoutY(170);
		ConvertibleCmb.setMinWidth(200);
		ConvertibleCmb.setMinHeight(30);
		ConvertibleCmb.setPromptText(TEXT_PROMPT_CHOOSE);
		ConvertibleCmb.setItems(FXCollections.observableArrayList(car_convertible_combobox));
		ConvertibleCmb.setVisible(false);
		
		EmptyCmb.setLayoutX(340);
		EmptyCmb.setLayoutY(170);
		EmptyCmb.setMinWidth(200);
		EmptyCmb.setMinHeight(30);
		EmptyCmb.setPromptText(TEXT_PROMPT_CHOOSE);
		EmptyCmb.getItems().addAll("--- choose a car type ---");
		EmptyCmb.setVisible(true);
		
		DaysCmb.setLayoutX(340);
		DaysCmb.setLayoutY(220);
		DaysCmb.setMinWidth(200);
		DaysCmb.setMinHeight(30);
		DaysCmb.setPromptText("For how many days");
		DaysCmb.setItems(FXCollections.observableArrayList(car_days_combobox));
		DaysCmb.setVisible(true);
		
		PriceBtn.setLayoutX(360);
		PriceBtn.setLayoutY(286);
		PriceBtn.setMinWidth(100);
		PriceBtn.setMinHeight(30);
		PriceBtn.setFont(new Font(FONT, 17));
		PriceBtn.setVisible(true);
		
		PriceLb.setLayoutX(385);
		PriceLb.setLayoutY(347);
		PriceLb.setMinWidth(80);
		PriceLb.setMinHeight(30);
		PriceLb.setFont(new Font(FONT, 23));
		PriceLb.setVisible(true);
		
		HiddenIDLb.setLayoutX(365);
		HiddenIDLb.setLayoutY(347);
		HiddenIDLb.setMinWidth(80);
		HiddenIDLb.setMinHeight(30);
		HiddenIDLb.setText(view.LoginView.getCustomerIDTfText());
		HiddenIDLb.setVisible(false);
		
		PlaceOrderBtn.setLayoutX(360);
		PlaceOrderBtn.setLayoutY(410);
		PlaceOrderBtn.setMinWidth(100);
		PlaceOrderBtn.setMinHeight(30); 
		PlaceOrderBtn.setFont(new Font(FONT, 20));
		PlaceOrderBtn.setDisable(false);
		
	}
	private void registerChildren()
	{
		pane.getChildren().add(CustomerLabel);
		pane.getChildren().add(RegisterBtn);
		pane.getChildren().add(BackBtn);
		pane.getChildren().add(NameTf);
		pane.getChildren().add(IDTf);
		pane.getChildren().add(CreditTf);
		pane.getChildren().add(SaveInfoErrorLb);
		pane.getChildren().add(TypeOfCarCmb);
		pane.getChildren().add(SUVCmb);
		pane.getChildren().add(SedanCmb);
		pane.getChildren().add(ConvertibleCmb);
		pane.getChildren().add(DaysCmb);
		pane.getChildren().add(PriceBtn);
		pane.getChildren().add(PriceLb);
		pane.getChildren().add(PlaceOrderBtn);
		pane.getChildren().add(EmptyCmb);
		pane.getChildren().add(HiddenIDLb);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {

			//pre itemy v ComboBoxoch

			controllerForCustomer.ComboBoxItems();
			
			setLayout();
			controllerForCustomer.SetupView(this);
			registerChildren();
			primaryStage.setScene(new Scene(pane, 585, 480));
			primaryStage.setTitle("PABT - NEW CUSTOMER");
			primaryStage.show();
			
			view.LoginView.setCustomerIDTf(null);

			closingStageNewCustomer.clear();
			closingStageNewCustomer.add(primaryStage);

			BackBtn.setOnAction(e -> {
				try {
				models.Customer.getCustomerList().remove(models.Customer.getCustomerList().size() - 1);
				primaryStage.close();
				
				viewForLogin.EmployeeLoginLb.setVisible(false);	
				viewForLogin.ResetLayout();
				
				} catch(Exception e3) {
					SaveInfoErrorLb.setText("Error BackBtn v NewCustomer View");
					SaveInfoErrorLb.setVisible(true);
				}
			});

			TypeOfCarCmb.setOnAction( e -> {
				try {
					CarFromCB = controllerForCustomer.TypeOfCarForComboBox();
					
				} catch(Exception e2) {
					LOGGER.log(Level.SEVERE, "ERROR TypeOfCarCmb.setOnAction in NewCustomer View", e2);
				}
			});
			
			PriceBtn.setOnAction( e -> {
				try {
					SaveInfoErrorLb.setText("");
					controllerForCustomer.CheckComboBox(CarFromCB);
					controllerForCustomer.CarPrice(CarFromCB, DaysCmb.getValue());
					
				} catch (EmptyComboBoxException moe) {
					LOGGER.log(Level.SEVERE, "ERROR PriceBtn.setOnAction in NewCustomer View - EmptyComboBoxException", moe);
				} catch (Exception e3) {
					LOGGER.log(Level.SEVERE, "ERROR PriceBtn.setOnAction in NewCustomer View", e3);
				}
			});
			
			PlaceOrderBtn.setOnAction( e -> {
				try {
					SaveInfoErrorLb.setText("");
					controllerForCustomer.CheckCustomerRegistration();
					controllerForCustomer.CheckComboBox(CarFromCB);								
					int SerialCarNumber = controllerForCustomer.CarPrice(CarFromCB, DaysCmb.getValue());
					controllerForCustomer.checkCreditAndPrice(CarFromCB);
					controllerForCustomer.CustomerInfo(NameTf.getText(), Integer.parseInt(CreditTf.getText()),DaysCmb.getValue(), HiddenIDLb.getText(), SerialCarNumber);
					RegisterBtn.setVisible(false);
					NameTf.setEditable(false);
					CreditTf.setEditable(false);
					SaveInfoErrorLb.setVisible(false);
					
					controllerForAreYouSureOrder.StartAreYouSureOrderSession();
					
				} catch (NumberFormatException e3) {
					SaveInfoErrorLb.setText("Correctly fill in all text fields!");
					SaveInfoErrorLb.setVisible(true);
				} catch (NotRegisteredCustomerException | EmptyComboBoxException moe2) {
					LOGGER.log(Level.SEVERE, "ERROR PlaceOrderBtn in NewCustomer View - NotRegisteredCustomerException or EmptyComboBoxException", moe2);
				} catch (Exception e2) {
					LOGGER.log(Level.SEVERE, "ERROR PlaceOrderBtn in NewCustomer View", e2);
				}
			});
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "", e);
		}
	}
	
	public void ClosingNCStage() {
		closingStageNewCustomer.get(0).close();
	}

	public TextField getNameTf() {
		return NameTf;
	}
	public TextField getIDTf() {
		return IDTf;
	}
	public String getIDTfText() {
		return IDTf.getText();
	}
	public TextField getCreditTf() {
		return CreditTf;
	}
	public String getSUV() {
		return SUVCmb.getValue();
	}
	public String getSedan() {
		return SedanCmb.getValue();
	}
	public String getConvertible() {
		return ConvertibleCmb.getValue();
	}
	public ComboBox<String> getTypeOfCarCmb(){
		return TypeOfCarCmb;
	}
	public String getTypeOfCarCmbString(){
		return TypeOfCarCmb.toString();
	}
	public ComboBox<String> getSUVCmb(){
		return SUVCmb;
	}
	public ComboBox<String> getSedanCmb(){
		return SedanCmb;
	}
	public ComboBox<String> getConvertibleCmb(){
		return ConvertibleCmb;
	}
	public ComboBox<String> getEmptyCmb(){
		return EmptyCmb;
	}
	public ComboBox<Integer> getDaysCmb(){
		return DaysCmb;
	}
	public static ArrayList<String> getCar_suv_comboboxList(){
		return car_suv_combobox;
	}
	public static ArrayList<String> getCar_sedan_comboboxList(){
		return car_sedan_combobox;
	}
	public static ArrayList<String> getCar_conver_comboboxList(){
		return car_convertible_combobox;
	}
	public static ArrayList<Integer> getCar_days_comboboxList(){
		return car_days_combobox;
	}
	public static String getHiddenIDLbText() {
		return HiddenIDLb.getText();
	}
}