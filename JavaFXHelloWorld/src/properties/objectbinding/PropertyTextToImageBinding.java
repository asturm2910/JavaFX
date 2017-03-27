package properties.objectbinding;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PropertyTextToImageBinding extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane root = new BorderPane();
		ImageView img = new ImageView();
		TextField urlInput = new TextField("http://www.strangecosmos.com/images/content/170477.jpg");
		
		root.setTop(urlInput);
		root.setCenter(img);
		
		img.imageProperty().bind(new ImageViewerBinding(urlInput.textProperty()));
		
		Scene s = new Scene(root, 1200, 1000);
		primaryStage.setScene(s);
		primaryStage.setTitle("Text to Image Binding Example");	
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
