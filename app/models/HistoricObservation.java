package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import com.avaje.ebean.Page;

@Entity
public class HistoricObservation extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Required
	public Double obsValue;

	@Required
	public int year;

	@Required
	public String month;

	public double agricultureSector;
	public double industrySector;
	public double buildingSector;
	public double servicesSector;
	public double withoutEmploy;

	/**
	 * Generic query helper for entity Company with id Long
	 */
	public static Model.Finder<Long, HistoricObservation> find = new Model.Finder<Long, HistoricObservation>(
			Long.class, HistoricObservation.class);

	public HistoricObservation() {
		// TODO Auto-generated constructor stub
	}

	public static List<HistoricObservation> all() {
		return find.all();
	}

	public static void deleteAll() {
		for (HistoricObservation obs : all()) {
			obs.delete();
		}
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
	 */
	public static Page<HistoricObservation> page(int page, int pageSize,
			String filterYear, String filterMonth) {
		return find.where().ilike("year", "%" + filterYear + "%")
				.ilike("month", "%" + filterMonth + "%")
				.findPagingList(pageSize).setFetchAhead(false).getPage(page);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	// REST services

	public static List<HistoricObservation> findByYear(int year) {
		return find.where().eq("year", year).findList();
	}

	public static List<HistoricObservation> findByMonth(String month) {
		return find.where().eq("month", month.toUpperCase()).findList();
	}

	// /Sector statistics
	public static Map<String, Object> getSectorStatistics(String value) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("average", Math.rint((average(HistoricObservation.all(), value))*100)/100);
		values = maxValue(HistoricObservation.all(), value, values);
		values = minValue(HistoricObservation.all(), value, values);
		values = yearsAverage(HistoricObservation.all(), value, values);
		values = yearsMaxValues(HistoricObservation.all(), value, values);
		values = yearsMinValues(HistoricObservation.all(), value, values);
		return values;
	}

	private static Map<String, Object> yearsMaxValues(
			List<HistoricObservation> all, String value,
			Map<String, Object> values) {
		values = maxValueYear(HistoricObservation.all(), 2005, value, values);
		values = maxValueYear(HistoricObservation.all(), 2006, value, values);
		values = maxValueYear(HistoricObservation.all(), 2007, value, values);
		values = maxValueYear(HistoricObservation.all(), 2008, value, values);
		values = maxValueYear(HistoricObservation.all(), 2009, value, values);
		values = maxValueYear(HistoricObservation.all(), 2010, value, values);
		values = maxValueYear(HistoricObservation.all(), 2011, value, values);
		values = maxValueYear(HistoricObservation.all(), 2012, value, values);
		values = maxValueYear(HistoricObservation.all(), 2013, value, values);
		values = maxValueYear(HistoricObservation.all(), 2014, value, values);

		return values;
	}

	private static Map<String, Object> yearsMinValues(
			List<HistoricObservation> all, String value,
			Map<String, Object> values) {
		values = minValueYear(HistoricObservation.all(), 2005, value, values);
		values = minValueYear(HistoricObservation.all(), 2006, value, values);
		values = minValueYear(HistoricObservation.all(), 2007, value, values);
		values = minValueYear(HistoricObservation.all(), 2008, value, values);
		values = minValueYear(HistoricObservation.all(), 2009, value, values);
		values = minValueYear(HistoricObservation.all(), 2010, value, values);
		values = minValueYear(HistoricObservation.all(), 2011, value, values);
		values = minValueYear(HistoricObservation.all(), 2012, value, values);
		values = minValueYear(HistoricObservation.all(), 2013, value, values);
		values = minValueYear(HistoricObservation.all(), 2014, value, values);

		return values;
	}

	private static Map<String, Object> maxValueYear(
			List<HistoricObservation> observations, int year, String value,
			Map<String, Object> values) {
		HistoricObservation maxObs = new HistoricObservation();
		double maxValue = Double.MIN_VALUE;
		for (HistoricObservation obs : observations) {
			if (value.equals("totalValue") && obs.getYear() == year)
				if (obs.obsValue > maxValue) {
					maxValue = obs.obsValue;
					maxObs = obs;
				}
			if (value.equals("agricultureSector") && obs.getYear() == year)
				if (obs.agricultureSector > maxValue) {
					maxValue = obs.agricultureSector;
					maxObs = obs;
				}
			if (value.equals("industrySector") && obs.getYear() == year)
				if (obs.industrySector > maxValue) {
					maxValue = obs.industrySector;
					maxObs = obs;
				}
			if (value.equals("buildingSector") && obs.getYear() == year)
				if (obs.buildingSector > maxValue) {
					maxValue = obs.buildingSector;
					maxObs = obs;
				}
			if (value.equals("servicesSector") && obs.getYear() == year)
				if (obs.servicesSector > maxValue) {
					maxValue = obs.servicesSector;
					maxObs = obs;
				}
			if (value.equals("withoutEmploy") && obs.getYear() == year)
				if (obs.withoutEmploy > maxValue) {
					maxValue = obs.withoutEmploy;
					maxObs = obs;
				}
		}
		values.put("maxValue" + year, (int)maxValue);
		values.put("maxValueMonth" + year, maxObs.month);
		return values;
	}

	private static Map<String, Object> minValueYear(
			List<HistoricObservation> observations, int year, String indicator,
			Map<String, Object> values) {
		double minValue = Double.MAX_VALUE;
		HistoricObservation minObs = new HistoricObservation();
		for (HistoricObservation obs : observations) {
			if (indicator.equals("totalValue") && obs.getYear() == year)
				if (obs.obsValue < minValue) {
					minValue = obs.obsValue;
					minObs = obs;
				}
			if (indicator.equals("agricultureSector") && obs.getYear() == year)
				if (obs.agricultureSector < minValue) {
					minValue = obs.agricultureSector;
					minObs = obs;
				}
			if (indicator.equals("industrySector") && obs.getYear() == year)
				if (obs.industrySector < minValue) {
					minValue = obs.industrySector;
					minObs = obs;
				}
			if (indicator.equals("buildingSector") && obs.getYear() == year)
				if (obs.buildingSector < minValue) {
					minValue = obs.buildingSector;
					minObs = obs;
				}
			if (indicator.equals("servicesSector") && obs.getYear() == year)
				if (obs.servicesSector < minValue) {
					minValue = obs.servicesSector;
					minObs = obs;
				}
			if (indicator.equals("withoutEmploy") && obs.getYear() == year)
				if (obs.withoutEmploy < minValue) {
					minValue = obs.withoutEmploy;
					minObs = obs;
				}
		}
		values.put("minValue" + year, (int)minValue);
		values.put("minValueMonth" + year, minObs.month);
		return values;
	}

	private static Map<String, Object> yearsAverage(
			List<HistoricObservation> observations, String value,
			Map<String, Object> values) {
		values.put("average2005",  Math.rint(yearAverage(observations, 2005, value)*100)/100);
		values.put("average2006",  Math.rint(yearAverage(observations, 2006, value)*100)/100);
		values.put("average2007",  Math.rint(yearAverage(observations, 2007, value)*100)/100);
		values.put("average2008",  Math.rint(yearAverage(observations, 2008, value)*100)/100);
		values.put("average2009",  Math.rint(yearAverage(observations, 2009, value)*100)/100);
		values.put("average2010",  Math.rint(yearAverage(observations, 2010, value)*100)/100);
		values.put("average2011",  Math.rint(yearAverage(observations, 2011, value)*100)/100);
		values.put("average2012",  Math.rint(yearAverage(observations, 2012, value)*100)/100);
		values.put("average2013",  Math.rint(yearAverage(observations, 2013, value)*100)/100);
		values.put("average2014",  Math.rint(yearAverage(observations, 2014, value)*100)/100);
		return values;
	}

	private static double yearAverage(List<HistoricObservation> observations,
			int year, String value) {
		Double sum = 0.0;
		for (HistoricObservation obs : observations) {
			if (value.equals("totalValue") && obs.getYear() == year)
				sum += obs.getObsValue();
			if (value.equals("agricultureSector") && obs.getYear() == year)
				sum += obs.getAgricultureSector();
			if (value.equals("industrySector") && obs.getYear() == year)
				sum += obs.getIndustrySector();
			if (value.equals("buildingSector") && obs.getYear() == year)
				sum += obs.getBuildingSector();
			if (value.equals("servicesSector") && obs.getYear() == year)
				sum += obs.getServicesSector();
			if (value.equals("withoutEmploy") && obs.getYear() == year)
				sum += obs.getWithoutEmploy();
		}
		int numObs = 0;
		for (HistoricObservation o: observations){
			if (o.getYear() == year){
				numObs++;
			}
		}
		
		return sum / numObs;
	}

	private static Double average(List<HistoricObservation> observations,
			String value) {
		Double sum = 0.0;
		for (HistoricObservation obs : observations) {
			if (value.equals("totalValue"))
				sum += obs.getObsValue();
			if (value.equals("agricultureSector"))
				sum += obs.getAgricultureSector();
			if (value.equals("industrySector"))
				sum += obs.getIndustrySector();
			if (value.equals("buildingSector"))
				sum += obs.getBuildingSector();
			if (value.equals("servicesSector"))
				sum += obs.getServicesSector();
			if (value.equals("withoutEmploy"))
				sum += obs.getWithoutEmploy();
		}
		return sum / observations.size();
	}

	private static Map<String, Object> maxValue(
			List<HistoricObservation> observations, String value,
			Map<String, Object> values) {
		HistoricObservation maxObs = new HistoricObservation();
		double maxValue = Double.MIN_VALUE;
		for (HistoricObservation obs : observations) {
			if (value.equals("totalValue"))
				if (obs.obsValue > maxValue) {
					maxValue = obs.obsValue;
					maxObs = obs;
				}
			if (value.equals("agricultureSector"))
				if (obs.agricultureSector > maxValue) {
					maxValue = obs.agricultureSector;
					maxObs = obs;
				}
			if (value.equals("industrySector"))
				if (obs.industrySector > maxValue) {
					maxValue = obs.industrySector;
					maxObs = obs;
				}
			if (value.equals("buildingSector"))
				if (obs.buildingSector > maxValue) {
					maxValue = obs.buildingSector;
					maxObs = obs;
				}
			if (value.equals("servicesSector"))
				if (obs.servicesSector > maxValue) {
					maxValue = obs.servicesSector;
					maxObs = obs;
				}
			if (value.equals("withoutEmploy"))
				if (obs.withoutEmploy > maxValue) {
					maxValue = obs.withoutEmploy;
					maxObs = obs;
				}
		}
		values.put("maxValue", (int)maxValue);
		values.put("maxValueYear", maxObs.year);
		values.put("maxValueMonth", maxObs.month);
		return values;
	}

	private static Map<String, Object> minValue(
			List<HistoricObservation> observations, String indicator,
			Map<String, Object> values) {
		double minValue = Double.MAX_VALUE;
		HistoricObservation minObs = new HistoricObservation();
		for (HistoricObservation obs : observations) {
			if (indicator.equals("totalValue"))
				if (obs.obsValue < minValue) {
					minValue = obs.obsValue;
					minObs = obs;
				}
			if (indicator.equals("agricultureSector"))
				if (obs.agricultureSector < minValue) {
					minValue = obs.agricultureSector;
					minObs = obs;
				}
			if (indicator.equals("industrySector"))
				if (obs.industrySector < minValue) {
					minValue = obs.industrySector;
					minObs = obs;
				}
			if (indicator.equals("buildingSector"))
				if (obs.buildingSector < minValue) {
					minValue = obs.buildingSector;
					minObs = obs;
				}
			if (indicator.equals("servicesSector"))
				if (obs.servicesSector < minValue) {
					minValue = obs.servicesSector;
					minObs = obs;
				}
			if (indicator.equals("withoutEmploy"))
				if (obs.withoutEmploy < minValue) {
					minValue = obs.withoutEmploy;
					minObs = obs;
				}
		}
		values.put("minValue", (int)minValue);
		values.put("minValueYear", minObs.year);
		values.put("minValueMonth", minObs.month);
		return values;
	}

}