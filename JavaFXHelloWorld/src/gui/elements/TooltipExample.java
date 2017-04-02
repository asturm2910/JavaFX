package gui.elements;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TooltipExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane root = new StackPane();
		Button aButton = new Button("Click Me!");
		aButton.setTooltip(new Tooltip("Dieser Button hat keine Funktion!"));
		
		root.getChildren().add(aButton);
		
		// -------------------------------- Install a Tooltip on a non tooltip Node --------------------------
		Tooltip rootTooltip = new Tooltip("A ToolTip for the StackPane!");
		Tooltip.install(root, rootTooltip);
		// ---------------------------------------------------------------------------------------------------
		
		Scene scene = new Scene(root, 400, 200);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tooltip Example");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
