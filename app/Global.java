import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import utils.UpdateDocuments;

import com.avaje.ebean.Ebean;

public class Global extends GlobalSettings {

	public void onStart(Application app) {
		InitialData.initialize(app);
	}

	static class InitialData {
		public static void initialize(Application app) {
			UpdateDocuments.checkDocumentAge();

			try {
				deletePreviousData();
				loadData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	private static void loadData() throws IOException, Exception,
				FileNotFoundException {
			List<AutonomousCommunity> autonomousCommunities;
			List<ACObservation> autonomousCommunitiesObservations;
			List<HistoricObservation> historicObservations;
			List<Province> provinces;
			List<ProvinceObservation> provinceObservations;

			historicObservations = new ExcelReaderSectorUnemploymentEvolution()
					.read(new FileInputStream(new File(
							"documents/evolparoseries.xls")));
			Ebean.save(historicObservations);
			autonomousCommunities = new ACCreator().read(new FileInputStream(
					new File("documents/list-pro.xls")));
			Ebean.save(autonomousCommunities);
			provinces = new ProvinceCreator().read(new FileInputStream(
					new File("documents/list-pro.xls")));
			Ebean.save(provinces);
			autonomousCommunitiesObservations = new ExcelReaderCAUnemployment()
					.read(new FileInputStream(new File(
							"documents/parosexoedadprov.xls")));
			Ebean.save(autonomousCommunitiesObservations);
			provinceObservations = new ExcelReaderProvinceUnemployment()
					.read(new FileInputStream(new File(
							"documents/parosexoedadprov.xls")));
			Ebean.save(provinceObservations);
		}
	}

	private static void deletePreviousData() {
		ACObservation.deleteAll();
		HistoricObservation.deleteAll();
		ProvinceObservation.deleteAll();
		AutonomousCommunity.deleteAll();
		Province.deleteAll();
	}
}
