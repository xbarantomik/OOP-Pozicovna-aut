package view;

import java.io.Serializable;

import controllers.LoginController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


public class LoginView extends Application implements Serializable{

	private static final long serialVersionUID = 1L;

	private LoginController ControllerForLogin = new LoginController();
	
	transient Label WelcomeLb = new Label("Login");
	public transient Label BanListWLb = new Label("This person is on our BanList!");
	transient Label EmpLogLb = new Label("Employee Not Found!");
	transient Button CustomerLoginBtn = new Button("Customer Login");
	transient Button EmployeeLoginBtn = new Button("Employee Login");
	private transient static TextField EmployeeLoginTf = new TextField();
	private transient static PasswordField EmployeePasswordPf = new PasswordField();
	private transient static TextField CustomerIDTf = new TextField();
	transient Label EmployeeLoginLb = new Label("Logged as Employee");
	transient Button CustomerArrayPrintOutBtn = new Button("C");
	transient Button STB = new Button("O");
	transient Button EpmBtn = new Button("E");
	transient Pane pane = new Pane();	

	private void setLayout() {
		
		WelcomeLb.setText("Pick an option");
		WelcomeLb.setLayoutX(95);
		WelcomeLb.setLayoutY(30);
		WelcomeLb.setMinWidth(100);
		WelcomeLb.setMinHeight(40);
		WelcomeLb.setFont(new Font("Cambria", 35));
		
		BanListWLb.setLayoutX(52);
		BanListWLb.setLayoutY(238);
		BanListWLb.setMinWidth(100);
		BanListWLb.setMinHeight(40);
		BanListWLb.setFont(new Font("Cambria", 23));
		BanListWLb.setVisible(false);
		
		EmpLogLb.setLayoutX(116);
		EmpLogLb.setLayoutY(428);
		EmpLogLb.setMinWidth(100);
		EmpLogLb.setMinHeight(40);
		EmpLogLb.setFont(new Font("Cambria", 18));
		EmpLogLb.setVisible(false);		
		
		CustomerLoginBtn.setLayoutX(110);
		CustomerLoginBtn.setLayoutY(150);
		CustomerLoginBtn.setMinWidth(180);
		CustomerLoginBtn.setMinHeight(30);
		CustomerLoginBtn.setFont(new Font("Cambria", 20));
		CustomerLoginBtn.setVisible(true);
		
		CustomerIDTf.setLayoutX(110);
		CustomerIDTf.setLayoutY(200);
		CustomerIDTf.setMinWidth(180);
		CustomerIDTf.setMinHeight(30);		
		CustomerIDTf.setPromptText("ID");	

		EmployeeLoginBtn.setLayoutX(110);
		EmployeeLoginBtn.setLayoutY(300);
		EmployeeLoginBtn.setMinWidth(180);
		EmployeeLoginBtn.setMinHeight(30);
		EmployeeLoginBtn.setFont(new Font("Cambria", 20));
		EmployeeLoginBtn.setVisible(true);
		
		EmployeePasswordPf.setLayoutX(110);
		EmployeePasswordPf.setLayoutY(390);
		EmployeePasswordPf.setMinWidth(180);
		EmployeePasswordPf.setMinHeight(30);
		EmployeePasswordPf.setPromptText("Password");	
		
		EmployeeLoginTf.setLayoutX(110);
		EmployeeLoginTf.setLayoutY(350);
		EmployeeLoginTf.setMinWidth(180);
		EmployeeLoginTf.setMinHeight(30);
		EmployeeLoginTf.setPromptText("Login");	
		
		EmployeeLoginLb.setLayoutX(110);
		EmployeeLoginLb.setLayoutY(440);
		EmployeeLoginLb.setMinWidth(180);
		EmployeeLoginLb.setMinHeight(30);
		EmployeeLoginLb.setFont(new Font("Cambria", 20));
		EmployeeLoginLb.setVisible(false);
		
		CustomerArrayPrintOutBtn.setLayoutX(0);
		CustomerArrayPrintOutBtn.setLayoutY(460);
		CustomerArrayPrintOutBtn.setMaxWidth(20);
		CustomerArrayPrintOutBtn.setMinHeight(20);
		CustomerArrayPrintOutBtn.setFont(new Font("Cambria", 12));
		CustomerArrayPrintOutBtn.setVisible(false);
		
		STB.setLayoutX(0);
		STB.setLayoutY(430);
		STB.setMaxWidth(20);
		STB.setMinHeight(20);
		STB.setFont(new Font("Cambria", 12));
		STB.setVisible(false);	
		
		EpmBtn.setLayoutX(0);
		EpmBtn.setLayoutY(400);
		EpmBtn.setMaxWidth(20);
		EpmBtn.setMinHeight(20);
		EpmBtn.setFont(new Font("Cambria", 12));
		EpmBtn.setVisible(false);	

		
	
	}
	private void registerChildren()
	{
		pane.getChildren().add(EmployeePasswordPf);
		pane.getChildren().add(EmployeeLoginTf);
		pane.getChildren().add(WelcomeLb);
		pane.getChildren().add(BanListWLb);
		pane.getChildren().add(EmpLogLb);
		pane.getChildren().add(CustomerLoginBtn);
		pane.getChildren().add(CustomerIDTf);
		pane.getChildren().add(EmployeeLoginBtn);
		pane.getChildren().add(EmployeeLoginLb);
		pane.getChildren().add(CustomerArrayPrintOutBtn);
		pane.getChildren().add(STB);
		pane.getChildren().add(EpmBtn);
	}
	
	

	@Override
	public void start(Stage primaryStage) {
		try {
		ControllerForLogin.SetupView(this);
		primaryStage.setTitle("PABT");
		controllers.LoginController.Initializer();
		setLayout();
		registerChildren();

		primaryStage.setScene(new Scene(pane, 400, 480));
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> Platform.exit());
		
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		
		CustomerArrayPrintOutBtn.setOnAction(e -> {
			try {
				utils.StaticDb.CustomersArrayPrintOut();
			}catch(Exception e2) {
				System.out.println("ERROR CustomerArrayPrintOutBtn v loginView");
				e2.printStackTrace();
			}
		});
	
		STB.setOnAction(e -> {
			try {
				LoginController.OrderArrayPrintOut();
			}catch(Exception e2) {
				System.out.println("ERROR STB button v loginView");
				e2.printStackTrace();
			}
		});
		
		EpmBtn.setOnAction(e -> {
			try {
				LoginController.EmployeeArrayPrintOut();
			}catch(Exception e2) {
				System.out.println("ERROR EpmBtn v loginView");
				e2.printStackTrace();
			}
		});
		
		CustomerLoginBtn.setOnAction(e -> {
			try {
				BanListWLb.setVisible(false);
				ControllerForLogin.TryLoginCustomer(CustomerIDTf.getText());
			}catch(Exception e2) {
				System.out.println("ERROR CustomerLoginBtn v loginView");
				e2.printStackTrace();
			}
			
			
		});
		
		EmployeeLoginBtn.setOnAction(e -> {
			try {
			ControllerForLogin.TryLoginEmployee(EmployeeLoginTf.getText(), EmployeePasswordPf.getText());
			}catch(Exception e2) {
				System.out.println("ERROR EmployeeLoginBtn v loginView");
				e2.printStackTrace();
			}

		});
		
		
		
	}
	
	public void UpdateAfterLogin() {
		this.EmpLogLb.setVisible(false);
	}
	public void UserNotFound() {
		this.EmpLogLb.setVisible(true);	
	}
	public void ResetLayout() {
		this.pane.setVisible(true);		
	}
	
		

	public Label getEmployeeLoginLb() {
		return EmployeeLoginLb;
	}
	public static PasswordField getEmployeePasswordPf() {
		return EmployeePasswordPf;
	}
	public static void setEmployeePasswordPf(String string) {
		EmployeePasswordPf.setText(string);
	}
	public static TextField getEmployeeLoginTf() {
		return EmployeeLoginTf;
	}
	public static void setEmployeeLoginTf(String string) {
		EmployeeLoginTf.setText(string);
	}
	public static TextField getCustomerIDTf() {
		return CustomerIDTf;
	}
	public static String getCustomerIDTfText() {
		return CustomerIDTf.getText();
	}
	public static void setCustomerIDTf(String string) {
		CustomerIDTf.setText(string);
	}

	
	
	

	public static void main(String[] args) {
		launch(args);
	}

}

