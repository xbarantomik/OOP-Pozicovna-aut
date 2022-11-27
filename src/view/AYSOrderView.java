package view;

import view.NewCustomerView;
import controllers.CustomerController;
import controllers.AYSOrderController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AYSOrderView extends Application{

	public static final Logger LOGGER = Logger.getLogger(AYSOrderView.class.getName());
	
	public AYSOrderController controllerForAreYouSureOrder = new AYSOrderController();
	public NewCustomerView viewForNewCustomer = new NewCustomerView();
	public CustomerController ControllerForCustomer = new CustomerController();
	
	public Label SummaryLb = new Label("Summary");
	public Label CarLb = new Label("");
	public Label CarConstLb = new Label("   Car:");
	public Label PriceLb = new Label("");
	public Label PriceConstLb = new Label("Price:");
	public Label CreditLb = new Label("");
	public Label CreditConstLb = new Label("Credit:");
	public Label DepositLb = new Label("");
	public Label DepositConstLb = new Label("Deposit:");
	public Label OverallLb = new Label("");
	public Label OverallConstLb = new Label("Overall:");
	public Pane pane = new Pane();	
	public Label SeparatorLb = new Label("-----------------------------------------------");
	public Button CancelBtn = new Button("Cancel");
	public Button OrderBtn = new Button("Order");
	public Label NotEnoughCreditLb = new Label("Not enough Credit");
	public Label ForDaysLb = new Label("");
	public static Label HiddenIDLb = new Label("");
	static final String FONT = "Cambria";



	private void setLayout() {	
		
		SummaryLb.setLayoutX(142);
		SummaryLb.setLayoutY(20);
		SummaryLb.setMinWidth(100);
		SummaryLb.setMinHeight(30);
		SummaryLb.setFont(new Font(FONT, 30));
		SummaryLb.setVisible(true);
		
		CarLb.setLayoutX(125);
		CarLb.setLayoutY(95);
		CarLb.setMinWidth(100);
		CarLb.setMinHeight(30);
		CarLb.setFont(new Font(FONT, 22));
		CarLb.setVisible(true);
		
		CarConstLb.setLayoutX(60);
		CarConstLb.setLayoutY(95);
		CarConstLb.setMinWidth(100);
		CarConstLb.setMinHeight(30);
		CarConstLb.setFont(new Font(FONT, 22));
		CarConstLb.setVisible(true);

		PriceLb.setLayoutX(125);
		PriceLb.setLayoutY(135);
		PriceLb.setMinWidth(100);
		PriceLb.setMinHeight(30);
		PriceLb.setFont(new Font(FONT, 22));
		PriceLb.setVisible(true);
		
		PriceConstLb.setLayoutX(60);
		PriceConstLb.setLayoutY(135);
		PriceConstLb.setMinWidth(100);
		PriceConstLb.setMinHeight(30);
		PriceConstLb.setFont(new Font(FONT, 22));
		PriceConstLb.setVisible(true);
		
		CreditLb.setLayoutX(125);
		CreditLb.setLayoutY(275);
		CreditLb.setMinWidth(100);
		CreditLb.setMinHeight(30);
		CreditLb.setFont(new Font(FONT, 22));
		CreditLb.setVisible(true);
		
		CreditConstLb.setLayoutX(50);
		CreditConstLb.setLayoutY(275);
		CreditConstLb.setMinWidth(100);
		CreditConstLb.setMinHeight(30);
		CreditConstLb.setFont(new Font(FONT, 22));
		CreditConstLb.setVisible(true);
		
		DepositLb.setLayoutX(125);
		DepositLb.setLayoutY(175);
		DepositLb.setMinWidth(100);
		DepositLb.setMinHeight(30);
		DepositLb.setFont(new Font(FONT, 22));
		DepositLb.setVisible(true);
		
		DepositConstLb.setLayoutX(35);
		DepositConstLb.setLayoutY(175);
		DepositConstLb.setMinWidth(100);
		DepositConstLb.setMinHeight(30);
		DepositConstLb.setFont(new Font(FONT, 22));
		DepositConstLb.setVisible(true);
		
		OverallLb.setLayoutX(125);
		OverallLb.setLayoutY(235);
		OverallLb.setMinWidth(100);
		OverallLb.setMinHeight(30);
		OverallLb.setFont(new Font(FONT, 22));
		OverallLb.setVisible(true);
		
		OverallConstLb.setLayoutX(39);
		OverallConstLb.setLayoutY(235);
		OverallConstLb.setMinWidth(100);
		OverallConstLb.setMinHeight(30);
		OverallConstLb.setFont(new Font(FONT, 22));
		OverallConstLb.setVisible(true);
		
		SeparatorLb.setLayoutX(30);
		SeparatorLb.setLayoutY(200);
		SeparatorLb.setMinWidth(100);
		SeparatorLb.setMinHeight(30);
		SeparatorLb.setFont(new Font(FONT, 22));
		SeparatorLb.setVisible(true);

		CancelBtn.setLayoutX(40);
		CancelBtn.setLayoutY(345);
		CancelBtn.setMinWidth(80);
		CancelBtn.setMinHeight(30);
		CancelBtn.setFont(new Font(FONT, 23));
		CancelBtn.setVisible(true);
		
		OrderBtn.setLayoutX(260);
		OrderBtn.setLayoutY(345);
		OrderBtn.setMinWidth(100);
		OrderBtn.setMinHeight(30);
		OrderBtn.setFont(new Font(FONT, 23));
		OrderBtn.setVisible(true);
		
		NotEnoughCreditLb.setLayoutX(187);
		NotEnoughCreditLb.setLayoutY(345);
		NotEnoughCreditLb.setMinWidth(100);
		NotEnoughCreditLb.setMinHeight(30);
		NotEnoughCreditLb.setFont(new Font(FONT, 22));
		NotEnoughCreditLb.setVisible(false);
		
		ForDaysLb.setLayoutX(258);
		ForDaysLb.setLayoutY(175);
		ForDaysLb.setMinWidth(100);
		ForDaysLb.setMinHeight(30);
		ForDaysLb.setFont(new Font(FONT, 22));
		ForDaysLb.setVisible(true);
		
		HiddenIDLb.setLayoutX(258);
		HiddenIDLb.setLayoutY(175);
		HiddenIDLb.setMinWidth(100);
		HiddenIDLb.setMinHeight(30);
		HiddenIDLb.setFont(new Font(FONT, 22));
		HiddenIDLb.setText(view.NewCustomerView.getHiddenIDLbText());
		HiddenIDLb.setVisible(false);


	}
	private void registerChildren()
	{
		pane.getChildren().add(SummaryLb);
		pane.getChildren().add(CarLb);
		pane.getChildren().add(CarConstLb);
		pane.getChildren().add(PriceLb);
		pane.getChildren().add(PriceConstLb);
		pane.getChildren().add(CreditLb);
		pane.getChildren().add(CreditConstLb);
		pane.getChildren().add(DepositLb);
		pane.getChildren().add(DepositConstLb);
		pane.getChildren().add(SeparatorLb);
		pane.getChildren().add(OverallLb);
		pane.getChildren().add(OverallConstLb);
		pane.getChildren().add(CancelBtn);
		pane.getChildren().add(OrderBtn);
		pane.getChildren().add(NotEnoughCreditLb);
		pane.getChildren().add(ForDaysLb);
		pane.getChildren().add(HiddenIDLb);

	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			setLayout();
			controllerForAreYouSureOrder.SetupView(this);
			registerChildren();
			primaryStage.setScene(new Scene(pane, 400, 415));
			primaryStage.setTitle("PABT - ORDER SUMMARY");
			primaryStage.show();
			
			controllerForAreYouSureOrder.ChosenCarLayout(HiddenIDLb.getText());
			
			CancelBtn.setOnAction(e -> {
				try {
					controllerForAreYouSureOrder.SetDepositZero(HiddenIDLb.getText());
					viewForNewCustomer.PlaceOrderBtn.setDisable(false);
					primaryStage.close();
					
				} catch(Exception e2) {
					LOGGER.log(Level.SEVERE, "ERROR CancelBtn in AreYouSure View", e2);
				} 
			});
			
			OrderBtn.setOnAction(e -> {
				try {
					controllerForAreYouSureOrder.CreateOrder(HiddenIDLb.getText());
					primaryStage.close();
					viewForNewCustomer.ClosingNCStage();

					
				} catch(Exception e3) {
					LOGGER.log(Level.SEVERE, "ERROR OrderBtn in AreYouSure View", e3);
					
				} 	
			});
			
			
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "", e);
		}
	}

	
	public void setCarLbText(String string) {
		this.CarLb.setText(string);
	}
	public void setPriceLbText(String string) {
		this.PriceLb.setText(string);
	}
	public void setCreditLbText(String credit) {
		this.CreditLb.setText(credit);
	}
	public void setDepositLbText(String deposit) {
		this.DepositLb.setText(deposit);
	}
	public void setOverallLbText(String overall) {
		this.OverallLb.setText(overall);
	}
	public void setForDaysLb(String days) {
		this.ForDaysLb.setText(days);
	}
}
