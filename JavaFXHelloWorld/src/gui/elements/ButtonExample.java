package gui.elements;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonExample extends Application {
	
	public void start(Stage primaryStage) {
		
		StackPane root = new StackPane();
		Button aButton = new Button("Click Me!");
		aButton.setOnAction(e -> aButton.setText("Thank you!"));
		
		aButton.setDefaultButton(true);
		
		root.getChildren().add(aButton);
		
		Scene scene = new Scene(root, 300, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Button Example");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
