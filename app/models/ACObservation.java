package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class ACObservation extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	@ManyToOne
	public AutonomousCommunity autonomousCommunity;

	public Integer totalValue;
	public Integer totalValueMen;
	public Integer totalValueWomen;
	public Integer totalValueUnder25;
	public Integer valueMenUnder25;
	public Integer valueWomenUnder25;
	public Integer totalValueOver25;
	public Integer valueMenOver25;
	public Integer valueWomenOver25;

	/**
	 * Generic query helper for entity Company with id Long
	 */
	public static Model.Finder<Long, ACObservation> find = new Model.Finder<Long, ACObservation>(
			Long.class, ACObservation.class);

	public ACObservation() {
		// TODO Auto-generated constructor stub
	}

	public static List<ACObservation> all() {
		return find.all();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public static void deleteAll() {
		for (ACObservation obs : all()) {
			obs.delete();
		}
	}

	public static ACObservation findByCode(Long indicator) {
		return find.byId(indicator);
	}

}