package models;

import javax.persistence.Entity;



@Entity
public class Month implements Period{

	private String value;
	
	public Month(){}
	
	public Month(String value){
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	
}
