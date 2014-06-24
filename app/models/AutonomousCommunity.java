package models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * This class show an autonomous community. An autonomous community can be
 * formed by one or more provinces. The autonomous cities like Ceuta and Melilla
 * will be considered as autonomous communities.
 * 
 * @author Paula
 * 
 */
@Entity
public class AutonomousCommunity extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public String id;
	@Id
	public String name;

	public AutonomousCommunity() {

	}

	/**
	 * Generic query helper for entity Company with id Long
	 */
	public static Model.Finder<Long, AutonomousCommunity> find = new Model.Finder<Long, AutonomousCommunity>(
			Long.class, AutonomousCommunity.class);

	/**
	 * Query thats allowed the capability to order the list
	 * 
	 * @return
	 */
	public static Map<String, String> options() {
		LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
		for (AutonomousCommunity c : AutonomousCommunity.find.orderBy("name")
				.findList()) {
			options.put(c.getId().toString(), c.getName());
		}
		return options;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static List<AutonomousCommunity> all() {
		return find.all();
	}

	public static AutonomousCommunity findByName(String name) {
		return find.where().eq("name", name).findUnique();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void deleteAll() {
		for (AutonomousCommunity a: all()) {
			a.delete();
		}
		
	}	  

}
