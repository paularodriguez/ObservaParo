package models;

import javax.persistence.OneToMany;

public class Profile {
	
	@OneToMany
	private Gender gender;
	
	@OneToMany
	private AgeRange ageRange;
	

}
