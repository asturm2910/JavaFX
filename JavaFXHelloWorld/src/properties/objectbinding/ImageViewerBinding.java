package properties.objectbinding;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class ImageViewerBinding extends ObjectBinding<Image> {

	StringProperty urlText;
	
	public ImageViewerBinding(StringProperty url) {
		super.bind(url);
		this.urlText = url;
		
	}
	
	
	@Override
	protected Image computeValue() {
		System.out.println("computeValue: " + urlText.get());
		try {
			Image img = new Image(urlText.get(), true);
			return img;
		} catch (Exception e) {
			System.out.println(urlText.get() + "... Not an valid URL");
			return null;
		}
	}

}
