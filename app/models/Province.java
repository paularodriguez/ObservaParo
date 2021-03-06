package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

/**
 * This class show a province.
 * 
 * @author Paula
 * 
 */
@Entity
public class Province extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public String id;
	public String name;

	/**
	 * Generic query helper for entity Company with id Long
	 */
	public static Model.Finder<Long, Province> find = new Model.Finder<Long, Province>(
			Long.class, Province.class);

	public Province(String provinceId, String provinceName) {
		this.id = provinceId;
		this.name = provinceName;

	}

	public Province() {
	}

	public static Province findByName(String name) {
		return find.where().eq("name", name).findUnique();
	}

	public static List<Province> all() {
		return find.all();
	}

	public static Object findByCode(String code) {
		return find.where().eq("id", code).findUnique();
	}

	public static void deleteAll() {
		for (Province p : all()) {
			p.delete();
		}

	}
}
