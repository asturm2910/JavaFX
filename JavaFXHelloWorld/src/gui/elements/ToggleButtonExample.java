package gui.elements;

import javafx.application.Application;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.BooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ToggleButtonExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox root = new VBox();
		
		root.setPadding(new Insets(25));
		
		ToggleButton tb1 = new ToggleButton("Toggle Button 1");
		ToggleButton tb2 = new ToggleButton("Toggle Button 2");
		ToggleButton tb3 = new ToggleButton("Toggle Button 3");
		ToggleButton tb4 = new ToggleButton("Toggle Button 4");
		ToggleButton tb5 = new ToggleButton("Toggle Button 5");
		
		tb1.setTooltip(new Tooltip("This Button will change the Label --Toggle Button 1--"));
		tb2.setTooltip(new Tooltip("This Button will change the Label --Toggle Button 2--"));
		tb3.setTooltip(new Tooltip("This Button will change the Label --Toggle Button 3--"));
		tb4.setTooltip(new Tooltip("This Button will change the Label --Toggle Button 4--"));
		tb5.setTooltip(new Tooltip("This Button will change the Label --Toggle Button 5--"));
		
		ToggleGroup tbg = new ToggleGroup();
		tb1.setToggleGroup(tbg);
		tb2.setToggleGroup(tbg);
		tb3.setToggleGroup(tbg);
		tb4.setToggleGroup(tbg);
		tb5.setToggleGroup(tbg);
		
		tb1.setOnAction(e -> System.out.println(tb1.getText() + " is pressed"));
		tb2.setOnAction(e -> System.out.println(tb2.getText() + " is pressed"));
		tb3.setOnAction(e -> System.out.println(tb3.getText() + " is pressed"));
		tb4.setOnAction(e -> System.out.println(tb4.getText() + " is pressed"));
		tb5.setOnAction(e -> System.out.println(tb5.getText() + " is pressed"));
		
		Label l = new Label("Pressed Button is: [UNDEFINED]");
		l.textProperty().bind(new ToggleToStringBinding(tb1, tb2, tb3, tb4, tb5));
		
		
		root.getChildren().addAll(tb1, tb2, tb3, tb4, tb5, l);
		
		Scene scene = new Scene(root, 300, 500);
		
		primaryStage.setTitle("ToggleButton Example");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}
	
	
	class ToggleToStringBinding extends StringBinding {
		private ToggleButton[] tButtons;
		
		public ToggleToStringBinding(ToggleButton... buttons) {
			
			BooleanProperty[] p = new BooleanProperty[buttons.length];
			for (int i = 0; i < buttons.length; i++) {
				p[i] = buttons[i].selectedProperty();
			}
			
			super.bind(p);
			this.tButtons = buttons;
		}

		@Override
		protected String computeValue() {
			for (ToggleButton tb : tButtons) {
				if (tb.isSelected()) {
					return "Pressed Button is: ["+tb.getText() + "]";
				}
			}
			return "UNDEFINED";
		}
	}
}
