package controllers;

import models.Observation;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
	
  /*  public static Result index(){
    	 return ok(index.render(Observation.all()));
    }*/
	
    /**
     * Handle default path requests, redirect to computers list
     */
    public static Result index() {
    	return list(0, "name", "asc", "");
    }
    
    
    public static void rellenarListadoObservaciones(){
    /*	Observation ob1 = new Observation(new Indicator("PAST","Paro Asturias"), 13.6);
    	Observation ob2 = new Observation(new Indicator("PBCN","Paro BCN"), 15.4);
    	observations.add(ob1);
    	observations.add(ob2);*/
    }

    /**
     * Display the paginated list of observations.
     *
     * @param page Current page number (starts from 0)
     * @param sortBy Column to be sorted
     * @param order Sort order (either asc or desc)
     * @param filter Filter applied on computer names
     */
    public static Result list(int page, String sortBy, String order, String filter) {
        return ok(
            index.render(
                Observation.page(page, 10, sortBy, order, filter),
                sortBy, order, filter
            )
        );
    }
}
