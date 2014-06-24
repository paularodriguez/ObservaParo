package controllers;

import java.util.HashMap;
import java.util.Map;

import models.ACObservation;
import models.AutonomousCommunity;
import models.HistoricObservation;
import models.ProvinceObservation;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.autonomousCommunities;
import views.html.bars;
import views.html.index;
import views.html.provinces;
import views.html.statistics;

public class Application extends Controller {

	/**
	 * Handle default path requests, redirect to computers list
	 */
	public static Result index() {
		return list(0, "", "");
	}

	/**
	 * Display the paginated list of observations.
	 * 
	 * @param page
	 *            Current page number (starts from 0)
	 */
	public static Result list(int page, String filterYear, String filterMonth) {
		return ok(index.render(HistoricObservation.page(page, 12,filterYear,filterMonth ), filterYear, filterMonth));
	}

	public static Result showAutonomousCommunities(String filter) {
		return ok(autonomousCommunities.render(ACObservation.filterCommunities(filter), AutonomousCommunity.all(), filter));
	}

	public static Result showProvinces(String filter) {
		return ok(provinces.render(ProvinceObservation.filterProvinces(filter),filter));
	}
	
	public static Result bars(Long indicator) {
    	return ok(bars.render(ACObservation.findByCode(indicator)));
    }
	
	public static Result ACObservationByCode(Long code) {
		ACObservation aC = ACObservation.findByCode(code);
		return ok(Json.toJson(aC));
	}
	
	public static Result statistics(String indicator, String title){
		Map<String,Object> values = new HashMap<String, Object>();
		if (indicator.startsWith("p"))
				values = ProvinceObservation.getTotalStatistics(indicator);
		Double average = (Double) values.get("average");
		ProvinceObservation.observationsOverAverageValue(average, indicator);
		ProvinceObservation.observationsUnderAverageValue(average, indicator);
		return ok(statistics.render(title,values,ProvinceObservation.observationsOverAverageValue(average, indicator),ProvinceObservation.observationsUnderAverageValue(average, indicator)));
	}
	
}
