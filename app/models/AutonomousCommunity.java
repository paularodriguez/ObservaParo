package models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * This class show an autonomous community. An autonomous community can be formed by one or more provinces.
 * The autonomous cities like Ceuta and Melilla will be considered as autonomous communities.
 * 
 * @author Paula
 *
 */
@Entity
public class AutonomousCommunity extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    public Long id;
    
    @Constraints.Required
    public String name;
    
    /**
     * Provinces of the autonomous community
     */
    @OneToMany
	private List<Province> provinces;
    
    /**
     * Generic query helper for entity Company with id Long
     */
    public static Model.Finder<Long,AutonomousCommunity> find = new Model.Finder<Long,AutonomousCommunity>(Long.class, AutonomousCommunity.class);

    /**
     * Query thats allowed the capability to order the list
     * @return
     */
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(AutonomousCommunity c: AutonomousCommunity.find.orderBy("name").findList()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}
	
	public void addProvince(Province province){
		this.provinces.add(province);
	}    
    
}
