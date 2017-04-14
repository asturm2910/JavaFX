package gui.elements;



import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChoiceBoxExample extends Application {
	private Map<String, String> items;

	@Override
	public void start(Stage mainStage) throws Exception {
		ChoiceBox<String> mb = new ChoiceBox();

		
		items = new HashMap<>();
		
		items.put("A new Hope", "https://lumiere-a.akamaihd.net/v1/images/Star-Wars-New-Hope-IV-Poster_c217085b.jpeg?region=46%2C333%2C580%2C290");
		items.put("The Empire Strikes Back", "https://lumiere-a.akamaihd.net/v1/images/Star-Wars-Empire-Strikes-Back-V-Poster_878f7fce.jpeg?region=31%2C272%2C603%2C302&width=600");
		items.put("Return of the Jedi", "https://lumiere-a.akamaihd.net/v1/images/Star-Wars-Return-Jedi-VI-Poster_a10501d2.jpeg?region=40%2C244%2C593%2C296");
		items.put("The Phantom Menace", "https://lumiere-a.akamaihd.net/v1/images/Star-Wars-Phantom-Menace-I-Poster_f5832812.jpeg?region=0%2C241%2C678%2C339&width=600");
		items.put("Attack of the Clones", "https://lumiere-a.akamaihd.net/v1/images/Star-Wars-Attack-Clones-II-Poster_53baa2e7.jpeg?region=0%2C136%2C678%2C339&width=600");
		items.put("Revenge of the Sith", "https://lumiere-a.akamaihd.net/v1/images/Star-Wars-Revenge-Sith-III-Poster_646108ce.jpeg?region=61%2C329%2C634%2C319&width=600");
		items.put("The Force Awakens", "https://lumiere-a.akamaihd.net/v1/images/avco_payoff_1-sht_v7_lg_32e68793.jpeg?region=0%2C96%2C1620%2C815&width=600");
		items.put("Rouge One", "https://lumiere-a.akamaihd.net/v1/images/rogueone_onesheeta_8a255456.jpeg?region=0%2C77%2C1688%2C849&width=600");
		
		for (String movie: items.keySet()) {
			mb.getItems().add(movie);
		}
		
		mb.getSelectionModel().selectFirst();
		
		
		HBox root = new HBox();
		root.setPadding(new Insets(20));
		root.getChildren().add(mb);
		
		ImageView view = new ImageView();
		view.imageProperty().bind(new ImageViewObjectBinding(mb.valueProperty(), items));
		root.getChildren().add(view);
		
		Scene scene = new Scene(root, 850, 400);
		
		mainStage.setTitle("Menu Button Example");
		mainStage.setScene(scene);
		mainStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}
}


class ImageViewObjectBinding extends ObjectBinding<Image> {

	ObjectProperty<String> prop;
	Map<String, String> items;
	
	public ImageViewObjectBinding(ObjectProperty<String> s, Map<String, String> items) {
		super.bind(s);
		this.prop = s;
		this.items = items;
	}
	
	@Override
	protected Image computeValue() {
		try {
			Image img = new Image(items.get(prop.get()), true);
			return img;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
