package view;

import java.util.ArrayList;
import controllers.CustomerController;
import view.LoginView;
import controllers.LoginController;
import controllers.ReturnCarController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CustomerView extends Application{
	
	public CustomerController ControllerForCustomer = new CustomerController();
	public LoginView ViewForLogin = new LoginView();
	public LoginController ControllerForLogin = new LoginController();
	public ReturnCarController controllerReturnCar = new ReturnCarController();
	
	private static ArrayList<Stage> closingStageReturnOrder = new ArrayList<>();

	
	public Label CustomerLabel = new Label("Customer");
	public Label NameLb = new Label("");
	public Label NameLb2 = new Label("Name: ");
	public Label IDLb = new Label("");
	public Label IDLb2 = new Label("ID: ");
	public Label CredtidLb = new Label("");
	public Label CredtidLb2 = new Label("Credit [€]: ");
	public Label CustomerLabe2 = new Label("Customer2");
	public TextField OrderTf = new TextField();
	public Pane pane = new Pane();	
	public Button CancelOrderBtn = new Button("Cancel ORDER");
	public Button ReturnCarBtn = new Button("Return CAR");
	public Button BackBtn = new Button("Back");
	public Label CarLb = new Label("");
	public Label CarLb2 = new Label("Car:");
	public Label DaysLeft = new Label("");
	public Label DaysLeft2 = new Label("DaysLeft:");
	public Label NoCarLb = new Label("You don't have a rented car");
	public static Label HiddenIDLb = new Label();

	
	private void setLayout() {	
		
		CustomerLabel.setLayoutX(300);
		CustomerLabel.setLayoutY(30);
		CustomerLabel.setMinWidth(100);
		CustomerLabel.setMinHeight(30);
		CustomerLabel.setFont(new Font("Cambria", 28));
		CustomerLabel.setVisible(false);
		
		CustomerLabe2.setLayoutX(420);
		CustomerLabe2.setLayoutY(30);
		CustomerLabe2.setMinWidth(100);
		CustomerLabe2.setMinHeight(30);
		CustomerLabe2.setFont(new Font("Cambria", 20));
		CustomerLabe2.setVisible(false);
		
		NameLb.setLayoutX(137);
		NameLb.setLayoutY(30);
		NameLb.setMinWidth(100);
		NameLb.setMinHeight(30);
		NameLb.setFont(new Font("Cambria", 23));
		
		NameLb2.setLayoutX(75);
		NameLb2.setLayoutY(30);
		NameLb2.setMinWidth(100);
		NameLb2.setMinHeight(30);
		NameLb2.setFont(new Font("Cambria", 18));
		
		IDLb.setLayoutX(137);
		IDLb.setLayoutY(70);
		IDLb.setMinWidth(100);
		IDLb.setMinHeight(30);
		IDLb.setFont(new Font("Cambria", 23));
		
		IDLb2.setLayoutX(102);
		IDLb2.setLayoutY(70);
		IDLb2.setMinWidth(100);
		IDLb2.setMinHeight(30);
		IDLb2.setFont(new Font("Cambria", 18));
		
		CredtidLb.setLayoutX(137);
		CredtidLb.setLayoutY(110);
		CredtidLb.setMinWidth(100);
		CredtidLb.setMinHeight(30);
		CredtidLb.setFont(new Font("Cambria", 23));
		
		CredtidLb2.setLayoutX(45);
		CredtidLb2.setLayoutY(110);
		CredtidLb2.setMinWidth(100);
		CredtidLb2.setMinHeight(30);
		CredtidLb2.setFont(new Font("Cambria", 18));
		
		OrderTf.setLayoutX(30);
		OrderTf.setLayoutY(175);
		OrderTf.setMinWidth(640);
		OrderTf.setMinHeight(120);
		OrderTf.setFont(new Font("Cambria", 18));
		OrderTf.setEditable(false);
		OrderTf.setVisible(false);
		
		CancelOrderBtn.setLayoutX(350);
		CancelOrderBtn.setLayoutY(355);
		CancelOrderBtn.setMinWidth(80);
		CancelOrderBtn.setMinHeight(30);
		CancelOrderBtn.setFont(new Font("Cambria", 20));
		CancelOrderBtn.setVisible(false);
		
		ReturnCarBtn.setLayoutX(215);
		ReturnCarBtn.setLayoutY(250);
		ReturnCarBtn.setMinWidth(80);
		ReturnCarBtn.setMinHeight(30);
		ReturnCarBtn.setFont(new Font("Cambria", 20));
		ReturnCarBtn.setVisible(true);
		
		BackBtn.setLayoutX(50);
		BackBtn.setLayoutY(250);
		BackBtn.setMinWidth(80);
		BackBtn.setMinHeight(30);
		BackBtn.setFont(new Font("Cambria", 20));
		
		DaysLeft.setLayoutX(137);
		DaysLeft.setLayoutY(190);
		DaysLeft.setMinWidth(100);
		DaysLeft.setMinHeight(30);
		DaysLeft.setFont(new Font("Cambria", 23));
		
		DaysLeft2.setLayoutX(51);
		DaysLeft2.setLayoutY(190);
		DaysLeft2.setMinWidth(100);
		DaysLeft2.setMinHeight(30);
		DaysLeft2.setFont(new Font("Cambria", 18));
		DaysLeft2.setVisible(true);
		
		CarLb.setLayoutX(137);
		CarLb.setLayoutY(150);
		CarLb.setMinWidth(100);
		CarLb.setMinHeight(30);
		CarLb.setFont(new Font("Cambria", 23));
		
		CarLb2.setLayoutX(93);
		CarLb2.setLayoutY(150);
		CarLb2.setMinWidth(100);
		CarLb2.setMinHeight(30);
		CarLb2.setFont(new Font("Cambria", 18));
		CarLb2.setVisible(true);
		
		HiddenIDLb.setLayoutX(10);
		HiddenIDLb.setLayoutY(175);
		HiddenIDLb.setMinWidth(100);
		HiddenIDLb.setMinHeight(30);
		HiddenIDLb.setText(view.LoginView.getCustomerIDTfText());
		HiddenIDLb.setVisible(false);
		
		NoCarLb.setLayoutX(60);
		NoCarLb.setLayoutY(180);
		NoCarLb.setMinWidth(100);
		NoCarLb.setMinHeight(30);
		NoCarLb.setFont(new Font("Cambria", 24));
		NoCarLb.setVisible(false);
		
	}
	private void registerChildren()
	{
		pane.getChildren().add(CustomerLabel);
		pane.getChildren().add(CustomerLabe2);
		pane.getChildren().add(NameLb);
		pane.getChildren().add(NameLb2);
		pane.getChildren().add(IDLb);
		pane.getChildren().add(IDLb2);
		pane.getChildren().add(CredtidLb);
		pane.getChildren().add(CredtidLb2);
		pane.getChildren().add(OrderTf);
		pane.getChildren().add(CancelOrderBtn);
		pane.getChildren().add(ReturnCarBtn);
		pane.getChildren().add(BackBtn);;
		pane.getChildren().add(CarLb);
		pane.getChildren().add(CarLb2);
		pane.getChildren().add(NoCarLb);
		pane.getChildren().add(DaysLeft);
		pane.getChildren().add(DaysLeft2);
		pane.getChildren().add(HiddenIDLb);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			setLayout();
			ControllerForCustomer.SetupView(this);
			registerChildren();
			primaryStage.setScene(new Scene(pane, 400, 320));
			primaryStage.setTitle("PABT - CUSTOMER");
			primaryStage.show();
			
			view.LoginView.setCustomerIDTf(null);
			
			closingStageReturnOrder.clear();
			closingStageReturnOrder.add(primaryStage);
			
			ControllerForCustomer.CustomerOrderLayout(HiddenIDLb.getText());
			
			BackBtn.setOnAction(e -> {
				try {
					ViewForLogin.EmployeeLoginLb.setVisible(false);		//zavriem okno ale nerestetnem hlavne okno

				ViewForLogin.ResetLayout();
				primaryStage.close();
				} catch(Exception e2) {
					System.out.println("ERROR BackBtn v CustomerView");
					e2.printStackTrace();
				}
				
			});
			
			ReturnCarBtn.setOnAction(e -> {
				try {
					if(ControllerForCustomer.CheckDateBool(HiddenIDLb.getText()))
						controllerReturnCar.StartReturnCarSession();
					else
						controllerReturnCar.StartReturnCarLateSession();
						
				ViewForLogin.ResetLayout();

				} catch(Exception e2) {
					System.out.println("ERROR ReturnCarBtn v CustomerView");
					e2.printStackTrace();
				}
				
			});
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		} 	
		
	}
	
	
	
	public void ClosingROStage() {
		closingStageReturnOrder.get(0).close();
	}
	public static String getHiddenIDLbText() {
		return HiddenIDLb.getText();
	}

	
}
