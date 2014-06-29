package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	}

	public static List<ACObservation> all() {
		return find.all();
	}

	public static void deleteAll() {
		for (ACObservation obs : all()) {
			obs.delete();
		}
	}

	public static ACObservation findByCode(Long indicator) {
		return find.byId(indicator);
	}

	public static List<ACObservation> filterCommunities(String filter) {
		return find.where()
				.ilike("autonomousCommunity.name", "%" + filter + "%")
				.findList();
	}

	public static Map<String, Object> getTotalStatistics(String indicator) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put(
				"average",
				Math.rint((average(ACObservation.all(), indicator)) * 100) / 100);
		values = maxValue(ACObservation.all(), indicator, values);
		values = minValue(ACObservation.all(), indicator, values);
		return values;
	}

	private static Map<String, Object> minValue(
			List<ACObservation> observations, String indicator,
			Map<String, Object> values) {
		int minValue = Integer.MAX_VALUE;
		ACObservation minObs = new ACObservation();
		for (ACObservation obs : observations) {
			if (indicator.equals("acTotal"))
				if (obs.totalValue < minValue) {
					minValue = obs.totalValue;
					minObs = obs;
				}
			if (indicator.equals("acTotalMen"))
				if (obs.totalValueMen < minValue) {
					minValue = obs.totalValueMen;
					minObs = obs;
				}
			if (indicator.equals("acTotalWomen"))
				if (obs.totalValueWomen < minValue) {
					minValue = obs.totalValueWomen;
					minObs = obs;
				}
			if (indicator.equals("acTotalUnder25"))
				if (obs.totalValueUnder25 < minValue) {
					minValue = obs.totalValueUnder25;
					minObs = obs;
				}
			if (indicator.equals("acTotalMenUnder25"))
				if (obs.valueMenUnder25 < minValue) {
					minValue = obs.valueMenUnder25;
					minObs = obs;
				}
			if (indicator.equals("acTotalWomenUnder25"))
				if (obs.valueWomenUnder25 < minValue) {
					minValue = obs.valueWomenUnder25;
					minObs = obs;
				}
			if (indicator.equals("acTotalOver25"))
				if (obs.totalValueOver25 < minValue) {
					minValue = obs.totalValueOver25;
					minObs = obs;
				}
			if (indicator.equals("acTotalMenOver25"))
				if (obs.valueMenOver25 < minValue) {
					minValue = obs.valueMenOver25;
					minObs = obs;
				}
			if (indicator.equals("acTotalWomenOver25"))
				if (obs.valueWomenOver25 < minValue) {
					minValue = obs.valueWomenOver25;
					minObs = obs;
				}
		}
		values.put("minValue", minValue);
		values.put("minValueZone", minObs.autonomousCommunity.name);
		return values;
	}

	private static Map<String, Object> maxValue(
			List<ACObservation> observations, String indicator,
			Map<String, Object> values) {
		ACObservation maxObs = new ACObservation();
		int maxValue = Integer.MIN_VALUE;
		for (ACObservation obs : observations) {
			if (indicator.equals("acTotal"))
				if (obs.totalValue > maxValue) {
					maxValue = obs.totalValue;
					maxObs = obs;
				}
			if (indicator.equals("acTotalMen"))
				if (obs.totalValueMen > maxValue) {
					maxValue = obs.totalValueMen;
					maxObs = obs;
				}
			if (indicator.equals("acTotalWomen"))
				if (obs.totalValueWomen > maxValue) {
					maxValue = obs.totalValueWomen;
					maxObs = obs;
				}
			if (indicator.equals("acTotalUnder25"))
				if (obs.totalValueUnder25 > maxValue) {
					maxValue = obs.totalValueUnder25;
					maxObs = obs;
				}
			if (indicator.equals("acTotalMenUnder25"))
				if (obs.valueMenUnder25 > maxValue) {
					maxValue = obs.valueMenUnder25;
					maxObs = obs;
				}
			if (indicator.equals("acTotalWomenUnder25"))
				if (obs.valueWomenUnder25 > maxValue) {
					maxValue = obs.valueWomenUnder25;
					maxObs = obs;
				}
			if (indicator.equals("acTotalOver25"))
				if (obs.totalValueOver25 > maxValue) {
					maxValue = obs.totalValueOver25;
					maxObs = obs;
				}
			if (indicator.equals("acTotalMenOver25"))
				if (obs.valueMenOver25 > maxValue) {
					maxValue = obs.valueMenOver25;
					maxObs = obs;
				}
			if (indicator.equals("acTotalWomenOver25"))
				if (obs.valueWomenOver25 > maxValue) {
					maxValue = obs.valueWomenOver25;
					maxObs = obs;
				}
		}
		values.put("maxValue", maxValue);
		values.put("maxValueZone", maxObs.autonomousCommunity.name);
		return values;
	}

	private static Double average(List<ACObservation> observations,
			String indicator) {
		Double sum = 0.0;
		for (ACObservation obs : observations) {
			if (indicator.equals("acTotal"))
				sum += obs.totalValue;
			if (indicator.equals("acTotalMen"))
				sum += obs.totalValueMen;
			if (indicator.equals("acTotalWomen"))
				sum += obs.totalValueWomen;
			if (indicator.equals("acTotalUnder25"))
				sum += obs.totalValueUnder25;
			if (indicator.equals("acTotalMenUnder25"))
				sum += obs.valueMenUnder25;
			if (indicator.equals("acTotalWomenUnder25"))
				sum += obs.valueWomenUnder25;
			if (indicator.equals("acTotalOver25"))
				sum += obs.totalValueOver25;
			if (indicator.equals("acTotalMenOver25"))
				sum += obs.valueMenOver25;
			if (indicator.equals("acTotalWomenOver25"))
				sum += obs.valueWomenOver25;
		}
		return sum / observations.size();
	}

	public static List<ACObservation> observationsOverAverageValue(
			Double average, String indicator) {
		List<ACObservation> overAverageList = new ArrayList<>();
		for (ACObservation o : ACObservation.find.orderBy(
				"autonomousCommunity.id").findList()) {
			if (indicator.equals("acTotal"))
				if (o.totalValue > average)
					overAverageList.add(o);
			if (indicator.equals("acTotalMen"))
				if (o.totalValueMen > average)
					overAverageList.add(o);
			if (indicator.equals("acTotalWomen"))
				if (o.totalValueWomen > average)
					overAverageList.add(o);
			if (indicator.equals("acTotalUnder25"))
				if (o.totalValueUnder25 > average)
					overAverageList.add(o);
			if (indicator.equals("acTotalMenUnder25"))
				if (o.valueMenUnder25 > average)
					overAverageList.add(o);
			if (indicator.equals("acTotalWomenUnder25"))
				if (o.valueWomenUnder25 > average)
					overAverageList.add(o);
			if (indicator.equals("acTotalOver25"))
				if (o.totalValueOver25 > average)
					overAverageList.add(o);
			if (indicator.equals("acTotalMenOver25"))
				if (o.valueMenOver25 > average)
					overAverageList.add(o);
			if (indicator.equals("acTotalWomenOver25"))
				if (o.valueWomenOver25 > average)
					overAverageList.add(o);
		}
		return overAverageList;
	}

	public static List<ACObservation> observationsUnderAverageValue(
			Double average, String indicator) {
		List<ACObservation> underAverageList = new ArrayList<>();
		for (ACObservation o : ACObservation.find.orderBy(
				"autonomousCommunity.id").findList()) {
			if (indicator.equals("acTotal"))
				if (o.totalValue < average)
					underAverageList.add(o);
			if (indicator.equals("acTotalMen"))
				if (o.totalValueMen < average)
					underAverageList.add(o);
			if (indicator.equals("acTotalWomen"))
				if (o.totalValueWomen < average)
					underAverageList.add(o);
			if (indicator.equals("acTotalUnder25"))
				if (o.totalValueUnder25 < average)
					underAverageList.add(o);
			if (indicator.equals("acTotalMenUnder25"))
				if (o.valueMenUnder25 < average)
					underAverageList.add(o);
			if (indicator.equals("acTotalWomenUnder25"))
				if (o.valueWomenUnder25 < average)
					underAverageList.add(o);
			if (indicator.equals("acTotalOver25"))
				if (o.totalValueOver25 < average)
					underAverageList.add(o);
			if (indicator.equals("acTotalMenOver25"))
				if (o.valueMenOver25 < average)
					underAverageList.add(o);
			if (indicator.equals("acTotalWomenOver25"))
				if (o.valueWomenOver25 < average)
					underAverageList.add(o);
		}
		return underAverageList;
	}

	public static ACObservation findByACId(String acId) {
		return find.where().eq("autonomousCommunity.id", acId).findUnique();
	}

	public static ACObservation findByACName(String acName) {
		return find.where().eq("autonomousCommunity.name", acName).findUnique();

	}

}