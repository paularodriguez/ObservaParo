package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

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
		for (AutonomousCommunity a : all()) {
			a.delete();
		}

	}

	public static Object findByCode(String code) {
		return find.where().eq("id", code).findUnique();
	}

}
