import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import models.ACObservation;
import models.AutonomousCommunity;
import models.HistoricObservation;
import models.Province;
import models.ProvinceObservation;
import play.Application;
import play.GlobalSettings;
import utils.ACCreator;
import utils.ExcelReaderCAUnemployment;
import utils.ExcelReaderProvinceUnemployment;
import utils.ExcelReaderSectorUnemploymentEvolution;
import utils.ProvinceCreator;

import com.avaje.ebean.Ebean;

public class Global extends GlobalSettings {

	public void onStart(Application app) {
		InitialData.insert(app);
	}

	static class InitialData {
		public static void insert(Application app) {
			HistoricObservation.deleteAll();
			if (HistoricObservation.all().isEmpty()) {
				List<AutonomousCommunity> autonomousCommunities;
				List<ACObservation> autonomousCommunitiesObservations;
				List<HistoricObservation> historicObservations;
				
				List<Province> provinces;
				List<ProvinceObservation> provinceObservations;
				try {
					historicObservations = new ExcelReaderSectorUnemploymentEvolution()
							.read(new FileInputStream(new File(
									"documents/evolparoseries.xls")));
					Ebean.save(historicObservations);
					autonomousCommunities = new ACCreator()
							.read(new FileInputStream(new File(
									"documents/list-pro.xls")));
					Ebean.save(autonomousCommunities);
					provinces = new ProvinceCreator().read(new FileInputStream(
							new File("documents/list-pro.xls")));
					Ebean.save(provinces);
					autonomousCommunitiesObservations = new ExcelReaderCAUnemployment().read(new FileInputStream(new File(
									"documents/parosexoedadprov.xls")));
					Ebean.save(autonomousCommunitiesObservations);
					provinceObservations = new ExcelReaderProvinceUnemployment().read(new FileInputStream(new File(
									"documents/parosexoedadprov.xls")));
					Ebean.save(provinceObservations);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
