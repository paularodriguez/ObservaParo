package models;

import javax.persistence.Entity;

@Entity
public class Year implements Period {

	private int value;
	
	public Year(){}
	
	public Year(int value){
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
