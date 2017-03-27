package properties;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PropertyTestMain extends Application implements ChangeListener<Date> {

	private FXBean bean;
	private DateFormat df;
	private Label label;
	
	@Override
	public void init() {
		bean = new FXBean();
		bean.birthdayProperty().addListener(this);
		df = new SimpleDateFormat("dd.MM.yyyy");
		
	}
	@Override
	public void start(Stage stage) throws Exception {
		
		StackPane root = new StackPane();
		label = new Label("Not yet set...");
		label.textProperty().bind(Bindings.createStringBinding(() -> df.format(bean.birthdayProperty().getValue()), bean.birthdayProperty()));
		
		Date birthday = new Date();
		try {
			birthday = df.parse("29.10.1980");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		root.getChildren().add(label);
		
		Scene s = new Scene(root, 400, 150);
		stage.setScene(s);
		stage.setTitle("Birthday");
		stage.show();
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					bean.setBirthday(df.parse("30.10.1980"));
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		};
//		Thread t = new Thread(r);
//		t.start();
		Platform.runLater(r);
		bean.setBirthday(birthday);

	}

	public static void main(String[] args) {
		launch(args);
		System.out.println("Hier");

	}
	@Override
	public void changed(ObservableValue<? extends Date> observable, Date oldValue, Date newValue) {
		System.out.println("Changed from: " + oldValue + " to " + newValue);
//		label.setText(df.format(newValue));
		
	}
	
	

}
