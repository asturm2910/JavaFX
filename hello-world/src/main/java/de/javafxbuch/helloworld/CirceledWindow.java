package de.javafxbuch.helloworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CirceledWindow extends Application{

	public static void main(String[] args) {
		launch(args);

	}
	
	public void start(Stage primaryStage) {
		Circle circle = new Circle(100, 100, 100);
		StackPane root = new StackPane();
		Button b = new Button("Press Me!");
		b.setOnAction(e -> circle.setFill(Color.BLUE));
		root.getChildren().add(b);
		root.setShape(circle);
		Scene scene = new Scene(root, 200, 200);
		scene.setFill(Color.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}

}
