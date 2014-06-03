package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import models.Observation;

public class Executor {

	public static void main(String[] args) {
		ExcelReaderProvinceCAUnemployment eR = new ExcelReaderProvinceCAUnemployment();
		List<Observation> obsList = null;
		try {
			obsList = eR.read(new FileInputStream(
					new File("documents/parosexoedadprov.xls")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
