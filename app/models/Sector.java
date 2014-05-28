package models;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.Constraints;

/**
 * This class represent an employment sector. 
 * @author Paula
 *
 */
@Entity
public class Sector extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    public Long id;
    
    @Constraints.Required
    public String name;
    
    
    /**
     * Generic query helper for entity Company with id Long
     */
    public static Model.Finder<Long,Sector> find = new Model.Finder<Long,Sector>(Long.class, Sector.class);

    /**
     * Query thats allowed the capability to order the list
     * @return
     */
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Sector c: Sector.find.orderBy("name").findList()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }
}
