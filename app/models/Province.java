package models;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.Constraints;


/**
 * This class show a province.  
 * @author Paula
 *
 */
@Entity
public class Province extends Model{
	
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
    public static Model.Finder<Long,Province> find = new Model.Finder<Long,Province>(Long.class, Province.class);

    /**
     * Query thats allowed the capability to order the list
     * @return
     */
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Province c: Province.find.orderBy("name").findList()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }
}
