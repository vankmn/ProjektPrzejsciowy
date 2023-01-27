package Client;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CalculatorView extends Application{
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FXMLLoader loader= new FXMLLoader(getClass().getResource("/Client/Client/Calculator.fxml"));
			
//			Scene scene = new Scene(loader.load(), 600, 400);	  
//			primaryStage.setScene(scene);    
//			primaryStage.show();
			
			Parent root = loader.load();
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	public void showCalculator(String string[]) {
		launch(string);
	}

}
