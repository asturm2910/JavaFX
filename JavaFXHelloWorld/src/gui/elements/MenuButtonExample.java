package gui.elements;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuButtonExample extends Application {

	public static void main(String[] args) {
		launch(args);

	}
	
	public void start(Stage stage) {
		
		VBox root = new VBox();
		
		MenuButton mb = new MenuButton();
		mb.setText("Bad Boys...");
		
		SplitMenuButton smb = new SplitMenuButton();
		smb.setText("Bad Boys II");
		
		MenuItem mi1 = new MenuItem("Darth Vader");
		MenuItem mi2 = new MenuItem("Dr. No");
		MenuItem mi3 = new MenuItem("The Joker");
		MenuItem mi4 = new MenuItem("Magneto");
		MenuItem mi5 = new MenuItem(".Net");
		
		mb.getItems().addAll(mi1, mi2, mi3, mi4, mi5);
		root.getChildren().add(mb);
		
		smb.getItems().addAll(mi1, mi2, mi3, mi4, mi5);
		root.getChildren().add(smb);
		
		Scene s = new Scene(root, 200, 100);
		
		stage.setScene(s);
		stage.setTitle("MenuItme Example");
		stage.show();
	}

}
