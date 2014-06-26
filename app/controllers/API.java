package controllers;

import java.util.List;

import models.ACObservation;
import models.AutonomousCommunity;
import models.HistoricObservation;
import models.Province;
import models.ProvinceObservation;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class API extends Controller {

    public static Result autonomousCommunities() {
    	return ok(Json.toJson(AutonomousCommunity.all()));
    }
    
    public static Result autonomousCommunitiesXML() {
    	return ok(Json.toJson(AutonomousCommunity.all()));
    }
    
    public static Result provinces() {
    	return ok(Json.toJson(Province.all()));
    }

    public static Result autonomousCommunity(String code) {
    	return ok(Json.toJson(AutonomousCommunity.findByCode(code)));
    }
    
    public static Result province(String code) {
    	return ok(Json.toJson(Province.findByCode(code)));
    }

    public static Result ACObservations() {
    	List<ACObservation> obsList = ACObservation.all();
    	return ok(Json.toJson(obsList));
    }
    
    public static Result provinceObservations() {
    	List<ProvinceObservation> obsList = ProvinceObservation.all();
    	return ok(Json.toJson(obsList));
    }
    
    public static Result ACObservationsByCommunityID(String acId) {
    	ACObservation obs= ACObservation.findByACId(acId);
    	return ok(Json.toJson(obs));
    }
    
    public static Result provinceObservationsByProvinceID(String provinceId) {
    	ProvinceObservation obs = ProvinceObservation.findByProvinceId(provinceId);
    	return ok(Json.toJson(obs));
    }
    
    public static Result ACObservationsByCommunityName(String acName) {
    	ACObservation obs= ACObservation.findByACName(acName);
    	return ok(Json.toJson(obs));
    }
    
    public static Result provinceObservationsByProvinceName(String provinceName) {
    	ProvinceObservation obs = ProvinceObservation.findByProvinceName(provinceName);
    	return ok(Json.toJson(obs));
    }
    
    public static Result historicObservations() {
    	List<HistoricObservation> obsList = HistoricObservation.all();
    	return ok(Json.toJson(obsList));
    }

    public static Result historicObservationsByYear(Integer year) {
    	List<HistoricObservation> obsList = HistoricObservation.findByYear(year);
    	return ok(Json.toJson(obsList));
    }
    
    public static Result historicObservationsByMonth(String month) {
    	List<HistoricObservation> obsList = HistoricObservation.findByMonth(month);
    	return ok(Json.toJson(obsList));
    }
    
/*    public static Result historicObservationsBySector(String sectorName) {
    	List<HistoricObservation> obsList = HistoricObservation.findBySector(sectorName);
    	return ok(Json.toJson(obsList));
    }*/

}
