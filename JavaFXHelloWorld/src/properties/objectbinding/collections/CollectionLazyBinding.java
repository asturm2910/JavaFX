package properties.objectbinding.collections;

import javafx.application.Application;
import javafx.collections.ObservableListBase;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class CollectionLazyBinding extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		ListView<String> listview = new ListView<>();
		listview.setItems(new ObservableListBase<String>() {
			
			@Override
			public String get(int i) {
				// Simulate a value costs one Millisecond
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "Index [" + i + "]";
			}
			
			@Override
			public int size() {
				return 2_000_000;
			}
			
		});
			
		Scene scene = new Scene(listview,400, 800);
		stage.setScene(scene);
		stage.setTitle("List Example");
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
