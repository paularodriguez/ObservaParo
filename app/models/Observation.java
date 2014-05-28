package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;


@Entity
public class Observation extends Model {
    
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  @Id
  public Long id;
  
  @Required
  private Double obsValue;

  @ManyToOne
  public Indicator indicator;
  
  @Required
  public Sector sector;
  
  @Required
  public Year year;
  
  @Required
private Month month;

private double agricultureSector;
  

  /**
   * Generic query helper for entity Company with id Long
   */
  public static Model.Finder<Long,Observation> find = new Model.Finder<Long,Observation>(Long.class, Observation.class);
  
  public Observation(Indicator indicator, Double value) {
	  this.indicator=indicator;
	  this.setObsValue(value) ;
  }

  public Observation() {
	// TODO Auto-generated constructor stub
}

public static List<Observation> all() {
    return find.all();
  }
  
  public static void delete(Long id) {
	find.ref(id).delete();
  }
  
  public static void deleteAll() {
	for (Observation obs: all()) {
		obs.delete();
	}
  }
  
  public static Double average(List<Observation> observations) {
	  Double sum = 0.0;
		for (Observation obs : observations) {
			sum += obs.getObsValue();
		}
		return sum / observations.size() ;
  }

public Double getObsValue() {
	return obsValue;
}

public void setObsValue(Double obsValue) {
	this.obsValue = obsValue;
}

public Month getMonth() {
	return month;
}

public void setMonth(Month month) {
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

 

}