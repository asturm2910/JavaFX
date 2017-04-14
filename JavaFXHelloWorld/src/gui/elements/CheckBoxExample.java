package gui.elements;

import javafx.application.Application;
import javafx.beans.binding.When;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxExample extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		VBox master = new VBox(25);
		master.setPadding(new Insets(10, 10, 10, 10));
		HBox root = new HBox(5);
		root.setPadding(new Insets(50, 10, 10, 10));
		
		// ===================================== Check Boxes ==========================
		CheckBox agree = new CheckBox("I agree");
		CheckBox disagree = new CheckBox("I disagree");
		CheckBox undecided = new CheckBox("I' undecided!");
		undecided.setAllowIndeterminate(true);
		
		agree.setOnAction(e -> System.out.println("A Click on >>agree<<"));
		// ============================================================================
		
		Label myLabel = new Label("Decision");
		
		
		// ===================================== Cool High-Level-API Bind! ====================================================
		myLabel.textProperty().bind(new When(agree.selectedProperty().and(disagree.selectedProperty().not())).then("Agreed")
				.otherwise(new When(agree.selectedProperty().not().and(disagree.selectedProperty())).then("Disagree")
						.otherwise("Undefined!")));
		root.getChildren().addAll(agree, disagree, undecided);
		// ====================================================================================================================
		
		master.getChildren().addAll(root, myLabel);
		Scene scene = new Scene(master, 500, 200);
		
		stage.setScene(scene);
		stage.setTitle("A CheckBoxExample");
		stage.show();
		

	}

	public static void main(String[] args) {
		launch(args);
	}

}
