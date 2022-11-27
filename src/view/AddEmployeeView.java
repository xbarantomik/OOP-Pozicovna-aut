package view;

import java.util.ArrayList;

import controllers.AddEmployeeController;
import controllers.CustomerController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AddEmployeeView extends Application{

	public static final Logger LOGGER = Logger.getLogger(AddEmployeeView.class.getName());
	public AddEmployeeController controllerAddEmployee = new AddEmployeeController();
	public CustomerView customerView = new CustomerView();
	public CustomerController ControllerForCustomer = new CustomerController();

	public Label AYSLb = new Label    ("Enter the Data");
	public Label WarningLb = new Label("Fill in all Fields!");
	public Label Warning2Lb = new Label("Passwords aren't identical!");
	public TextField NameTf = new TextField();
	public TextField LoginTf = new TextField();
	public PasswordField PassTf = new PasswordField();
	public PasswordField Pass2Tf = new PasswordField();
	public Pane pane = new Pane();	
	public Button CancelBtn = new Button("Cancel");
	public Button AddEmployeeBtn = new Button("Add Employee");
	private ArrayList<Stage> addEmpStage = new ArrayList<>();
	static final String FONT = "Cambria";


	private void setLayout() {	
		
		AYSLb.setLayoutX(127);
		AYSLb.setLayoutY(27);
		AYSLb.setMinWidth(100);
		AYSLb.setMinHeight(30);
		AYSLb.setFont(new Font(FONT, 22));
		AYSLb.setVisible(true);
		
		WarningLb.setLayoutX(122);
		WarningLb.setLayoutY(27);
		WarningLb.setMinWidth(100);
		WarningLb.setMinHeight(30);
		WarningLb.setFont(new Font(FONT, 22));
		WarningLb.setVisible(false);
		
		Warning2Lb.setLayoutX(80);
		Warning2Lb.setLayoutY(27);
		Warning2Lb.setMinWidth(100);
		Warning2Lb.setMinHeight(30);
		Warning2Lb.setFont(new Font(FONT, 22));
		Warning2Lb.setVisible(false);
		
		NameTf.setLayoutX(110);
		NameTf.setLayoutY(85);
		NameTf.setMinWidth(180);
		NameTf.setMinHeight(30);
		NameTf.setVisible(true);
		NameTf.setPromptText("Name");	
		
		LoginTf.setLayoutX(110);
		LoginTf.setLayoutY(125);
		LoginTf.setMinWidth(180);
		LoginTf.setMinHeight(30);
		LoginTf.setVisible(true);
		LoginTf.setPromptText("Login");	
		
		PassTf.setLayoutX(110);
		PassTf.setLayoutY(165);
		PassTf.setMinWidth(180);
		PassTf.setMinHeight(30);
		PassTf.setVisible(true);
		PassTf.setPromptText("Password");	
		
		Pass2Tf.setLayoutX(110);
		Pass2Tf.setLayoutY(205);
		Pass2Tf.setMinWidth(180);
		Pass2Tf.setMinHeight(30);
		Pass2Tf.setVisible(true);
		Pass2Tf.setPromptText("Repeat password");	

		CancelBtn.setLayoutX(50);
		CancelBtn.setLayoutY(270);
		CancelBtn.setMinWidth(80);
		CancelBtn.setMinHeight(30);
		CancelBtn.setFont(new Font(FONT, 20));
		CancelBtn.setVisible(true);
		
		AddEmployeeBtn.setLayoutX(195);
		AddEmployeeBtn.setLayoutY(270);
		AddEmployeeBtn.setMinWidth(100);
		AddEmployeeBtn.setMinHeight(30);
		AddEmployeeBtn.setFont(new Font(FONT, 20));
		AddEmployeeBtn.setVisible(true);


	}
	private void registerChildren()
	{
		pane.getChildren().add(AYSLb);
		pane.getChildren().add(WarningLb);
		pane.getChildren().add(Warning2Lb);
		pane.getChildren().add(NameTf);
		pane.getChildren().add(LoginTf);
		pane.getChildren().add(PassTf);
		pane.getChildren().add(Pass2Tf);
		pane.getChildren().add(CancelBtn);
		pane.getChildren().add(AddEmployeeBtn);

	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			setLayout();
			controllerAddEmployee.SetupView(this);
			registerChildren();
			primaryStage.setScene(new Scene(pane, 400, 340));
			primaryStage.setTitle("PABT - Add New Employee");
			primaryStage.show();
			addEmpStage.add(primaryStage);
			
			CancelBtn.setOnAction(e -> {
				try {
					primaryStage.close();
				} catch(Exception e2) {
					LOGGER.log(Level.SEVERE, "ERROR CancelBtn in AddEmployeeView", e2);
				} 
			});
			
			AddEmployeeBtn.setOnAction(e -> {
				try {
					controllerAddEmployee.AddEmployee(NameTf.getText(), LoginTf.getText(), PassTf.getText(), Pass2Tf.getText());
				} catch(Exception e3) {
					LOGGER.log(Level.SEVERE, "ERROR AddEmployeeBtn in AddEmployeeView", e3);
				} 	
			});
			
			
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR start in ReturnCar View", e);
		} 	
	}
	
	public void closeThisStage() {
		addEmpStage.get(0).close();
	}
}

