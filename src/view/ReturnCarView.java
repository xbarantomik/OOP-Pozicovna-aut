package view;

import controllers.ReturnCarController;

import controllers.CustomerController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReturnCarView extends Application{

	public static final Logger LOGGER = Logger.getLogger(ReturnCarView.class.getName());
	public ReturnCarController controllerReturnCar = new ReturnCarController();
	public CustomerView customerView = new CustomerView();
	public CustomerController ControllerForCustomer = new CustomerController();

	public Label AYSLb = new Label("Thank you for your Order");
	public Label Mgs1Lb = new Label("Press the 'Take Credit' button if you wish to take out your\n"
									+ "Credit + Deposit");
	public Label Mgs2Lb = new Label("Press the 'Leave Credit' button and your Registration alongside\n"
									+ "with your Credit will be saved and easy to use for your next Rental");
	public Pane pane = new Pane();	
	public Button CancelBtn = new Button("Cancel");
	public Button LeaveCreditBtn = new Button("Leave Credit");
	public Button TakeCreditBtn = new Button("Take Credit");
	public static Label HiddenIDLb = new Label("");
	static final String FONT = "Cambria";


	private void setLayout() {	
		
		AYSLb.setLayoutX(115);
		AYSLb.setLayoutY(18);
		AYSLb.setMinWidth(100);
		AYSLb.setMinHeight(30);
		AYSLb.setFont(new Font(FONT, 26));
		AYSLb.setVisible(true);
		
		Mgs1Lb.setLayoutX(22);
		Mgs1Lb.setLayoutY(91);
		Mgs1Lb.setMinWidth(100);
		Mgs1Lb.setMinHeight(10);
		Mgs1Lb.setFont(new Font(FONT, 17));
		Mgs1Lb.setVisible(true);
		
		Mgs2Lb.setLayoutX(22);
		Mgs2Lb.setLayoutY(131);
		Mgs2Lb.setMinWidth(100);
		Mgs2Lb.setMinHeight(10);
		Mgs2Lb.setFont(new Font(FONT, 17));
		Mgs2Lb.setVisible(false);

		CancelBtn.setLayoutX(40);
		CancelBtn.setLayoutY(215);
		CancelBtn.setMinWidth(80);
		CancelBtn.setMinHeight(30);
		CancelBtn.setFont(new Font(FONT, 23));
		CancelBtn.setVisible(true);
		
		LeaveCreditBtn.setLayoutX(420);
		LeaveCreditBtn.setLayoutY(230);
		LeaveCreditBtn.setMinWidth(100);
		LeaveCreditBtn.setMinHeight(30);
		LeaveCreditBtn.setFont(new Font(FONT, 23));
		LeaveCreditBtn.setVisible(false);
		
		HiddenIDLb.setLayoutX(10);
		HiddenIDLb.setLayoutY(175);
		HiddenIDLb.setMinWidth(100);
		HiddenIDLb.setMinHeight(30);
		HiddenIDLb.setText(view.CustomerView.getHiddenIDLbText());
		HiddenIDLb.setVisible(false);
		
		TakeCreditBtn.setLayoutX(330);
		TakeCreditBtn.setLayoutY(215);
		TakeCreditBtn.setMinWidth(100);
		TakeCreditBtn.setMinHeight(30);
		TakeCreditBtn.setFont(new Font(FONT, 23));
		TakeCreditBtn.setVisible(true);
	}

	private void registerChildren(){
		
		pane.getChildren().add(AYSLb);
		pane.getChildren().add(Mgs1Lb);
		pane.getChildren().add(Mgs2Lb);
		pane.getChildren().add(CancelBtn);
		pane.getChildren().add(HiddenIDLb);
		pane.getChildren().add(TakeCreditBtn);
		pane.getChildren().add(LeaveCreditBtn);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			setLayout();
			controllerReturnCar.SetupView(this);
			registerChildren();
			primaryStage.setScene(new Scene(pane, 522, 290));
			primaryStage.setTitle("PABT - Returning Order");
			primaryStage.show();
			
			CancelBtn.setOnAction(e -> {
				try {
					primaryStage.close();
					
				} catch(Exception e2) {
					LOGGER.log(Level.SEVERE, "ERROR CancelBtn in AreYouSure View", e2);
				} 
			});
			
			TakeCreditBtn.setOnAction(e -> {
				try {
					controllerReturnCar.OrderDeleteAll(HiddenIDLb.getText());
					primaryStage.close();
					customerView.ClosingROStage();
					
				} catch(Exception e3) {
					LOGGER.log(Level.SEVERE, "ERROR TakeCreditBtn in ReturnCar View", e3);
				} 	
			});
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "ERROR start v ReturnCar View", e);
		} 	
	}
}
