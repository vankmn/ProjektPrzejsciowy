package Client;

import java.io.IOException;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main{
	public static void main(String args[]) throws UnknownHostException, IOException {
		ClientSocket client = new ClientSocket();
	    client.startConnection("127.0.0.1", 6666);
	    String response = client.sendMessage("5.0/2.0");
	    System.out.println(response);
	    CalculatorView calculator = new CalculatorView();
	    calculator.showCalculator(args);
	}


}

