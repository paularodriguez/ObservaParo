package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import com.avaje.ebean.Page;

@Entity
public class Observation extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Required
	public Double obsValue;

	@Required
	public String month;

	public double agricultureSector;
	public double industrySector;
	public double buildingSector;
	public double servicesSector;
	public double withoutEmploy;
	
	public String autonomousCommunity;
	public String province;

	/**
	 * Generic query helper for entity Company with id Long
	 */
	public static Model.Finder<Long, Observation> find = new Model.Finder<Long, Observation>(
			Long.class, Observation.class);


	public Observation() {
		// TODO Auto-generated constructor stub
	}

	public static Observation create(Double obsValue, String month, Double agricultureSector) {
		Observation observation = new Observation(obsValue, month, agricultureSector);
		observation.save();
		return observation;
	}
	
	public Observation (double obsValue, String month, double agricultureSector) {
		this.obsValue = obsValue;
		this.month = month;
		this.agricultureSector = agricultureSector;
	}
	
	public static List<Observation> all() {
		return find.all();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public static void deleteAll() {
		for (Observation obs : all()) {
			obs.delete();
		}
	}

	public static Double average(List<Observation> observations) {
		Double sum = 0.0;
		for (Observation obs : observations) {
			sum += obs.getObsValue();
		}
		return sum / observations.size();
	}

	public Double getObsValue() {
		return obsValue;
	}

	public void setObsValue(Double obsValue) {
		this.obsValue = obsValue;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setAgricultureSectorValue(double agricultureSector) {
		this.setAgricultureSector(agricultureSector);

	}

	public double getAgricultureSector() {
		return agricultureSector;
	}

	public void setAgricultureSector(double agricultureSector) {
		this.agricultureSector = agricultureSector;
	}

	public double getIndustrySector() {
		return industrySector;
	}

	public void setIndustrySector(double industrySector) {
		this.industrySector = industrySector;
	}

	public double getBuildingSector() {
		return buildingSector;
	}

	public void setBuildingSector(double buildingSector) {
		this.buildingSector = buildingSector;
	}

	public double getServicesSector() {
		return servicesSector;
	}

	public void setServicesSector(double servicesSector) {
		this.servicesSector = servicesSector;
	}

	public double getWithoutEmploy() {
		return withoutEmploy;
	}

	public void setWithoutEmploy(double withoutEmploy) {
		this.withoutEmploy = withoutEmploy;
	}

	/**
	 * Return a page of observation
	 * 
	 * @param page
	 *            Page to display
	 * @param pageSize
	 *            Number of observations per page
	 * @param sortBy
	 *            Observation property used for sorting
	 * @param order
	 *            Sort order (either or asc or desc)
	 * @param filter
	 *            Filter applied on the name column
	 */
	public static Page<Observation> page(int page, int pageSize, String sortBy,
			String order, String filter) {
		return find.where().findPagingList(pageSize).setFetchAhead(false).getPage(page);
	}

	public String getAutonomousCommunity() {
		return autonomousCommunity;
	}

	public void setAutonomousCommunity(String autonomousCommunity) {
		this.autonomousCommunity = autonomousCommunity;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}