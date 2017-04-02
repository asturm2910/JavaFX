package gui.elements;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LabelExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane root = new StackPane();
		// Define a Label...
		Label aLabelText = new Label("A Text and a description as Label. "
				+ "It is possible to use long texts as label texts. setWrapText(true) activates text wrap");
		
		// ------------------------ Add a Image to a label ----------------------------
		Image image = new Image(getClass().getResourceAsStream("ThumbsUp_small.png"));
		aLabelText.setGraphic(new ImageView(image));
		// Positioning the Image
		aLabelText.setContentDisplay(ContentDisplay.BOTTOM);
		//Set Gap arround Text
		aLabelText.setGraphicTextGap(20);
		//Activate Text Wrap and Text Alignemnt for long texts
		aLabelText.setTextAlignment(TextAlignment.CENTER);
		aLabelText.setWrapText(true);
		// ----------------------------------------------------------------------------
		
		
		root.getChildren().add(aLabelText);
		
		Scene scene = new Scene(root, 350, 200);
		primaryStage.setTitle("A Label example!");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
