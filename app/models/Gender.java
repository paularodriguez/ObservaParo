package models;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * It can be male, female or both.
 * @author Paula
 *
 */
@Entity
public class Gender extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Required
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
