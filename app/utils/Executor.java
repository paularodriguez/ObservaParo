package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.ACObservation;
import models.HistoricObservation;

public class Executor {

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		ExcelReaderSectorUnemploymentEvolution eR = new ExcelReaderSectorUnemploymentEvolution();
		List<HistoricObservation> obsList = new ArrayList<>();
		try {
			obsList = eR.read(new FileInputStream(new File(
					"documents/evolparoseries.xls")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obsList.size());
		for (HistoricObservation o : obsList){
			System.out.println(o.year + " - "+ o.month);
		}
	}
}
