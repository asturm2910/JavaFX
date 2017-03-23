package de.javafxbuch.helloworld;


import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

	public static void main(String[] args) {
		log.debug("Starting Java Application...");
		launch(args);
	}
	@Override
	public void init() {
		log.info("init");
		
		//Read all Parameters given to a JavaFX Application: getRaw();
		int i = 0;
		Parameters p = getParameters();
		i++;
		for (String s : p.getRaw()) {
			log.debug("Parameter" + "[" + i + "] " + s);
		}
		
		// Read only named Parameters to a key-value Map: getNamed()
		Map<String, String> namedParameters = p.getNamed();
		Set<Entry<String, String>> keyValues = namedParameters.entrySet();
		for (Entry<String, String> entry : keyValues) {
			log.debug("Named Parameter: " + entry.getKey() + " --> " + entry.getValue());
		}
	}
	
	@Override
	public void stop() {
		log.info("stop");
	}
	
	@Override
    public void start(Stage stage) throws Exception {

        log.info("Starting Hello JavaFX and Maven demonstration application");

        StackPane root = new StackPane();
        Label text = new Label("Hello World");
        root.getChildren().add(text);

        log.debug("Showing JFX scene");
        Scene scene = new Scene(root, 400, 200);
        
        stage.initStyle(StageStyle.UNIFIED);

        
        // Stage like a stage in Theatre: it is the window who plays the scene!
        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        
        // There can be multiple stages / windows:
        Stage stage2 = new Stage();
        stage2.setTitle("Dialog");
        stage2.setScene(new Scene(new StackPane(new Label("A Message!")), 300, 150));
        // Set Dialog Windows as MODAL to PARENT stage
        stage2.initOwner(stage);
        stage2.initModality(Modality.WINDOW_MODAL);
        stage2.show();
    }
}
