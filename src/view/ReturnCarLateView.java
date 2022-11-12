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

public class ReturnCarLateView extends Application{
	
	public ReturnCarController controllerReturnCar = new ReturnCarController();
	public CustomerView customerView = new CustomerView();
	public CustomerController ControllerForCustomer = new CustomerController();

	public Label AYSLb = new Label("You are LATE!");
	public Label Mgs1Lb = new Label("And because of this we are keeping your deposit and putting you on our BanList");
	public Label Mgs2Lb = new Label("You are no longer welcomed to use our services!");
	public Pane pane = new Pane();	
	public Button OKBtn = new Button("OK");
	public static Label HiddenIDLb = new Label("");


	private void setLayout() {	
		
		AYSLb.setLayoutX(237);
		AYSLb.setLayoutY(18);
		AYSLb.setMinWidth(100);
		AYSLb.setMinHeight(30);
		AYSLb.setFont(new Font("Cambria", 26));
		AYSLb.setVisible(true);
		
		Mgs1Lb.setLayoutX(22);
		Mgs1Lb.setLayoutY(91);
		Mgs1Lb.setMinWidth(100);
		Mgs1Lb.setMinHeight(10);
		Mgs1Lb.setFont(new Font("Cambria", 17));
		Mgs1Lb.setVisible(true);
		
		Mgs2Lb.setLayoutX(22);
		Mgs2Lb.setLayoutY(131);
		Mgs2Lb.setMinWidth(100);
		Mgs2Lb.setMinHeight(10);
		Mgs2Lb.setFont(new Font("Cambria", 17));
		Mgs2Lb.setVisible(true);

		OKBtn.setLayoutX(275);
		OKBtn.setLayoutY(185);
		OKBtn.setMinWidth(80);
		OKBtn.setMinHeight(30);
		OKBtn.setFont(new Font("Cambria", 23));
		OKBtn.setVisible(true);

		HiddenIDLb.setLayoutX(10);
		HiddenIDLb.setLayoutY(175);
		HiddenIDLb.setMinWidth(100);
		HiddenIDLb.setMinHeight(30);
		HiddenIDLb.setText(view.CustomerView.getHiddenIDLbText());
		HiddenIDLb.setVisible(false);

	}
	private void registerChildren(){
		
		pane.getChildren().add(AYSLb);
		pane.getChildren().add(Mgs1Lb);
		pane.getChildren().add(Mgs2Lb);
		pane.getChildren().add(OKBtn);
		pane.getChildren().add(HiddenIDLb);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			setLayout();
			controllerReturnCar.SetupViewLate(this);
			registerChildren();
			primaryStage.setScene(new Scene(pane, 620, 260));
			primaryStage.setTitle("PABT - Returning Order Late");
			primaryStage.show();
			
			OKBtn.setOnAction(e -> {
				try {
					customerView.ClosingROStage();
					controllerReturnCar.OrderDeleteAllLate(HiddenIDLb.getText());
					primaryStage.close();
					
				} catch(Exception e2) {
					System.out.println("ERROR CancelBtn v AreYouSure View");
					e2.printStackTrace();
				} 
			});
			
		} catch(Exception e) {
			System.out.println("ERROR start v ReturnCarLate View");
			e.printStackTrace();
		} 	
	}
}

