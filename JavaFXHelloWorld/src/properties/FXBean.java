package properties;

import java.io.Serializable;
import java.util.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class FXBean implements Serializable {

	private static final long serialVersionUID = -7643010671593970765L;

	private ObjectProperty<Date> birthday = new SimpleObjectProperty<Date>(this, "birthday", new Date());
	
	
	public void setBirthday(Date birthday) {
		this.birthday.setValue(birthday);
	}
	
	public Date getBirthday() {
		return birthday.get();
	}
	
	public ObjectProperty<Date> birthdayProperty() {
		return birthday;
	}
}
