package view;

import controllers.AddEmployeeController;
import controllers.EmployeeController;
import view.LoginView;
import models.Employee;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EmployeeView extends Application{

	public EmployeeController ControllerForEmployee = new EmployeeController();
	public AddEmployeeController controllerAddEmployee = new AddEmployeeController();
	public LoginView viewForLogin = new LoginView();
	public Employee forEmployee = new Employee();
	
	public Label EmployeeLabel = new Label();
	public Pane pane = new Pane();	
	public Button AllCarBtn = new Button("All CARS");
	public Button AvailableCarBtn = new Button("Available CARS");
	public Button UnavailableCarBtn = new Button("Unavailable CARS");
	public TextArea OutPutTa = new TextArea();
	public Button BackBtn = new Button("Back");
	public Button AddEmployeesBtn = new Button("Add");
	public Button PrintCustomersBtn = new Button("Customers");
	public Button PrintOrdersBtn = new Button("Orders");
	public static Label HPaLb = new Label();
	public static Label HLoLB = new Label();
	static final String FONT = "Cambria";

	private void setLayout() {	
		
		EmployeeLabel.setLayoutX(35);
		EmployeeLabel.setLayoutY(30);
		EmployeeLabel.setMinWidth(100);
		EmployeeLabel.setMinHeight(30);
		EmployeeLabel.setFont(new Font(FONT, 28));
		
		OutPutTa.setLayoutX(250);
		OutPutTa.setLayoutY(120);
		OutPutTa.setMaxWidth(320);
		OutPutTa.setMinHeight(290);
		OutPutTa.setFont(new Font(FONT, 14));
		OutPutTa.setEditable(false);
		
		AllCarBtn.setLayoutX(40);
		AllCarBtn.setLayoutY(120);
		AllCarBtn.setMinWidth(105);
		AllCarBtn.setMinHeight(20);
		AllCarBtn.setFont(new Font(FONT, 15));
		
		AvailableCarBtn.setLayoutX(40);
		AvailableCarBtn.setLayoutY(165);
		AvailableCarBtn.setMinWidth(105);
		AvailableCarBtn.setMaxHeight(20);
		AvailableCarBtn.setFont(new Font(FONT, 15));
		
		UnavailableCarBtn.setLayoutX(40);
		UnavailableCarBtn.setLayoutY(210);
		UnavailableCarBtn.setMinWidth(105);
		UnavailableCarBtn.setMaxHeight(20);
		UnavailableCarBtn.setFont(new Font(FONT, 15));
		
		BackBtn.setLayoutX(40);
		BackBtn.setLayoutY(370);
		BackBtn.setMinWidth(80);
		BackBtn.setMinHeight(20);
		BackBtn.setFont(new Font(FONT, 20));
		
		AddEmployeesBtn.setLayoutX(490);
		AddEmployeesBtn.setLayoutY(30);
		AddEmployeesBtn.setMinWidth(80);
		AddEmployeesBtn.setMaxHeight(20);
		AddEmployeesBtn.setFont(new Font(FONT, 15));
		AddEmployeesBtn.setVisible(false);
		
		PrintCustomersBtn.setLayoutX(40);
		PrintCustomersBtn.setLayoutY(255);
		PrintCustomersBtn.setMinWidth(80);
		PrintCustomersBtn.setMaxHeight(20);
		PrintCustomersBtn.setFont(new Font(FONT, 15));
		PrintCustomersBtn.setVisible(true);
		
		PrintOrdersBtn.setLayoutX(40);
		PrintOrdersBtn.setLayoutY(300);
		PrintOrdersBtn.setMinWidth(80);
		PrintOrdersBtn.setMaxHeight(20);
		PrintOrdersBtn.setFont(new Font(FONT, 15));
		PrintOrdersBtn.setVisible(true);
		
		HPaLb.setLayoutX(40);
		HPaLb.setLayoutY(370);
		HPaLb.setMinWidth(80);
		HPaLb.setMinHeight(30);
		HPaLb.setFont(new Font(FONT, 20));
		HPaLb.setVisible(false);
		
		HLoLB.setLayoutX(40);
		HLoLB.setLayoutY(370);
		HLoLB.setMinWidth(80);
		HLoLB.setMinHeight(30);
		HLoLB.setFont(new Font(FONT, 20));
		HLoLB.setVisible(false);
	}
	
	private void registerChildren(){
		pane.getChildren().add(EmployeeLabel);
		pane.getChildren().add(OutPutTa);
		pane.getChildren().add(AllCarBtn);
		pane.getChildren().add(AvailableCarBtn);
		pane.getChildren().add(UnavailableCarBtn);
		pane.getChildren().add(BackBtn);
		pane.getChildren().add(AddEmployeesBtn);
		pane.getChildren().add(PrintCustomersBtn);
		pane.getChildren().add(PrintOrdersBtn);
		pane.getChildren().add(HPaLb);
		pane.getChildren().add(HLoLB);

	}
	
	@Override
	public void start(Stage primaryStage) {
		try {	
			setLayout();
			ControllerForEmployee.SetupView(this);
			registerChildren();
			primaryStage.setScene(new Scene(pane, 620, 450));
			primaryStage.setTitle("PABT - EMPLOYEES");
			primaryStage.show();
			
			HPaLb.setText(view.LoginView.getEmployeePasswordPf().getText());
			HLoLB.setText(view.LoginView.getEmployeeLoginTf().getText());
			view.LoginView.setEmployeeLoginTf("");
			view.LoginView.setEmployeePasswordPf("");
			
			EmployeeLabel.setText(ControllerForEmployee.NameLayout(HLoLB.getText(), HPaLb.getText()));
			ControllerForEmployee.IfAdmin(HLoLB.getText(), HPaLb.getText());
			
			BackBtn.setOnAction(e -> {
				viewForLogin.EmployeeLoginLb.setVisible(false); 
				viewForLogin.ResetLayout();
				primaryStage.close();
			});
			
			AllCarBtn.setOnAction(e -> ControllerForEmployee.CarsArrayPrintOutAll());
			
			AvailableCarBtn.setOnAction(e -> ControllerForEmployee.CarsArrayPrintOutAvailable());
			
			UnavailableCarBtn.setOnAction(e -> ControllerForEmployee.CarsArrayPrintOutUnavailable());
			
			AddEmployeesBtn.setOnAction(e -> controllerAddEmployee.StartAddEmployeeSession());
			
			PrintCustomersBtn.setOnAction(e -> ControllerForEmployee.CustomersArrayPrintOut());
			
			PrintOrdersBtn.setOnAction(e -> ControllerForEmployee.OrderArrayPrintOut());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static String getBHLoLB() {
		return HLoLB.getText();
	}
	public static String getHPaLb() {
		return HPaLb.getText();
	}
}
