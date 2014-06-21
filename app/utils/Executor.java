package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.ACObservation;

public class Executor {

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		ExcelReaderCAUnemployment eR = new ExcelReaderCAUnemployment();
		List<ACObservation> obsList = new ArrayList<>();
		try {
			obsList = eR.read(new FileInputStream(new File(
					"documents/parosexoedadprov.xls")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
