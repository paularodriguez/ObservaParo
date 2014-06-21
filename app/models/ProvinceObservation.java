package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class ProvinceObservation extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@ManyToOne
	public Province province;
	
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
	public static Model.Finder<Long, ProvinceObservation> find = new Model.Finder<Long, ProvinceObservation>(
			Long.class, ProvinceObservation.class);


	public ProvinceObservation() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<ProvinceObservation> all() {
		return find.all();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public static void deleteAll() {
		for (ProvinceObservation obs : all()) {
			obs.delete();
		}
	}

	public static Double average(List<ProvinceObservation> observations) {
		Double sum = 0.0;
		for (ProvinceObservation obs : observations) {
			sum += obs.getObsValue();
		}
		return sum / observations.size();
	}

	public Integer getObsValue() {
		return totalValue;
	}

	public void setObsValue(Integer obsValue) {
		this.totalValue = obsValue;
	}

}