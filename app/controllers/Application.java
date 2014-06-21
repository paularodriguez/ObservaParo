package controllers;

import models.ACObservation;
import models.AutonomousCommunity;
import models.HistoricObservation;
import models.ProvinceObservation;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.autonomousCommunities;
import views.html.index;
import views.html.provinces;

public class Application extends Controller {

	/**
	 * Handle default path requests, redirect to computers list
	 */
	public static Result index() {
		return list(0);
	}

	/**
	 * Display the paginated list of observations.
	 * 
	 * @param page
	 *            Current page number (starts from 0)
	 */
	public static Result list(int page) {
		return ok(index.render(HistoricObservation.page(page, 12)));
	}

	public static Result showAutonomousCommunities() {
		return ok(autonomousCommunities.render(ACObservation.all(), AutonomousCommunity.all()));
	}

	public static Result showProvinces() {
		return ok(provinces.render(ProvinceObservation.all()));
	}
}
