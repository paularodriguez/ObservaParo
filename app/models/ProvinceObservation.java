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

	public Integer getObsValue() {
		return totalValue;
	}

	public void setObsValue(Integer obsValue) {
		this.totalValue = obsValue;
	}

	public static Map<String, Object> getTotalStatistics(String indicator) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("average", (average(ProvinceObservation.all(), indicator)));
		values = maxValue(ProvinceObservation.all(), indicator, values);
		values = minValue(ProvinceObservation.all(), indicator, values);
		return values;
	}

	private static Map<String, Object> minValue(
			List<ProvinceObservation> observations, String indicator,
			Map<String, Object> values) {
		int minValue = Integer.MAX_VALUE;
		ProvinceObservation minObs = new ProvinceObservation();
		for (ProvinceObservation obs : observations) {
			if (indicator.equals("pTotal"))
				if (obs.totalValue < minValue) {
					minValue = obs.totalValue;
					minObs = obs;
				}
			if (indicator.equals("pTotalMen"))
				if (obs.totalValueMen < minValue) {
					minValue = obs.totalValueMen;
					minObs = obs;
				}
			if (indicator.equals("pTotalWomen"))
				if (obs.totalValueWomen < minValue) {
					minValue = obs.totalValueWomen;
					minObs = obs;
				}
			if (indicator.equals("pTotalUnder25"))
				if (obs.totalValueUnder25 < minValue) {
					minValue = obs.totalValueUnder25;
					minObs = obs;
				}
			if (indicator.equals("pTotalMenUnder25"))
				if (obs.valueMenUnder25 < minValue) {
					minValue = obs.valueMenUnder25;
					minObs = obs;
				}
			if (indicator.equals("pTotalWomenUnder25"))
				if (obs.valueWomenUnder25 < minValue) {
					minValue = obs.valueWomenUnder25;
					minObs = obs;
				}
			if (indicator.equals("pTotalOver25"))
				if (obs.totalValueOver25 < minValue) {
					minValue = obs.totalValueOver25;
					minObs = obs;
				}
			if (indicator.equals("pTotalMenOver25"))
				if (obs.valueMenOver25 < minValue) {
					minValue = obs.valueMenOver25;
					minObs = obs;
				}
			if (indicator.equals("pTotalWomenOver25"))
				if (obs.valueWomenOver25 < minValue) {
					minValue = obs.valueWomenOver25;
					minObs = obs;
				}
		}
		values.put("minValue", minValue);
		values.put("minValueProvince", minObs.province.name);
		return values;
	}

	private static Map<String, Object> maxValue(
			List<ProvinceObservation> observations, String indicator,
			Map<String, Object> values) {
		ProvinceObservation maxObs = new ProvinceObservation();
		int maxValue = Integer.MIN_VALUE;
		for (ProvinceObservation obs : observations) {
			if (indicator.equals("pTotal"))
				if (obs.totalValue > maxValue) {
					maxValue = obs.totalValue;
					maxObs = obs;
				}
			if (indicator.equals("pTotalMen"))
				if (obs.totalValueMen > maxValue) {
					maxValue = obs.totalValueMen;
					maxObs = obs;
				}
			if (indicator.equals("pTotalWomen"))
				if (obs.totalValueWomen > maxValue) {
					maxValue = obs.totalValueWomen;
					maxObs = obs;
				}
			if (indicator.equals("pTotalUnder25"))
				if (obs.totalValueUnder25 > maxValue) {
					maxValue = obs.totalValueUnder25;
					maxObs = obs;
				}
			if (indicator.equals("pTotalMenUnder25"))
				if (obs.valueMenUnder25 > maxValue) {
					maxValue = obs.valueMenUnder25;
					maxObs = obs;
				}
			if (indicator.equals("pTotalWomenUnder25"))
				if (obs.valueWomenUnder25 > maxValue) {
					maxValue = obs.valueWomenUnder25;
					maxObs = obs;
				}
			if (indicator.equals("pTotalOver25"))
				if (obs.totalValueOver25 > maxValue) {
					maxValue = obs.totalValueOver25;
					maxObs = obs;
				}
			if (indicator.equals("pTotalMenOver25"))
				if (obs.valueMenOver25 > maxValue) {
					maxValue = obs.valueMenOver25;
					maxObs = obs;
				}
			if (indicator.equals("pTotalWomenOver25"))
				if (obs.valueWomenOver25 > maxValue) {
					maxValue = obs.valueWomenOver25;
					maxObs = obs;
				}
		}
		values.put("maxValue", maxValue);
		values.put("maxValueProvince", maxObs.province.name);
		return values;
	}

	public static Double average(List<ProvinceObservation> observations,
			String indicator) {
		Double sum = 0.0;
		for (ProvinceObservation obs : observations) {
			if (indicator.equals("pTotal"))
				sum += obs.totalValue;
			if (indicator.equals("pTotalMen"))
				sum += obs.totalValueMen;
			if (indicator.equals("pTotalWomen"))
				sum += obs.totalValueWomen;
			if (indicator.equals("pTotalUnder25"))
				sum += obs.totalValueUnder25;
			if (indicator.equals("pTotalMenUnder25"))
				sum += obs.valueMenUnder25;
			if (indicator.equals("pTotalWomenUnder25"))
				sum += obs.valueWomenUnder25;
			if (indicator.equals("pTotalOver25"))
				sum += obs.totalValueOver25;
			if (indicator.equals("pTotalMenOver25"))
				sum += obs.valueMenOver25;
			if (indicator.equals("pTotalWomenOver25"))
				sum += obs.valueWomenOver25;
		}
		return sum / observations.size();
	}

	public static List<ProvinceObservation> observationsOverAverageValue(
			Double average, String indicator) {
		List<ProvinceObservation> overAverageList = new ArrayList<>();
		for (ProvinceObservation o : ProvinceObservation.all()) {
			if (o.totalValue > average) {
				overAverageList.add(o);
			}
		}
		return overAverageList;
	}

	public static List<ProvinceObservation> observationsUnderAverageValue(
			Double average, String indicator) {
		List<ProvinceObservation> underAverageList = new ArrayList<>();
		for (ProvinceObservation o : ProvinceObservation.all()) {
			if (indicator.equals("pTotal"))
				if (o.totalValue < average)
					underAverageList.add(o);
			if (indicator.equals("pTotalMen"))
				if (o.totalValueMen < average)
					underAverageList.add(o);
			if (indicator.equals("pTotalWomen"))
				if (o.totalValueWomen < average)
					underAverageList.add(o);
			if (indicator.equals("pTotalUnder25"))
				if (o.totalValueUnder25 < average)
					underAverageList.add(o);
			if (indicator.equals("pTotalMenUnder25"))
				if (o.valueMenUnder25 < average)
					underAverageList.add(o);
			if (indicator.equals("pTotalWomenUnder25"))
				if (o.valueWomenUnder25 < average)
					underAverageList.add(o);
			if (indicator.equals("pTotalOver25"))
				if (o.totalValueOver25 < average)
					underAverageList.add(o);
			if (indicator.equals("pTotalMenOver25"))
				if (o.valueMenOver25< average)
					underAverageList.add(o);
			if (indicator.equals("pTotalWomenOver25"))
				if (o.valueWomenOver25 < average)
					underAverageList.add(o);		}
		return underAverageList;
	}
}