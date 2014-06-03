import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import models.Observation;
import play.Application;
import play.GlobalSettings;
import utils.ExcelReaderProvinceCAUnemployment;
import utils.ExcelReaderSectorUnemploymentEvolution;

import com.avaje.ebean.Ebean;

public class Global extends GlobalSettings {

	public void onStart(Application app) {
        InitialData.insert(app);
    }
    
	static class InitialData {
		public static void insert(Application app) {
			Observation.deleteAll();
			if (Observation.all().isEmpty()) {
				
				List<Observation> all;
				try {
					all = new ExcelReaderProvinceCAUnemployment().read(new FileInputStream(
						new File("documents/parosexoedadprov.xls")));
					Ebean.save(all);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 				
				
			}
		}
	}
}
