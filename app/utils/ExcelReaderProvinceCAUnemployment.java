package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Observation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReaderProvinceCAUnemployment {

	public List<Observation> read(InputStream input) throws IOException,
			Exception {

		List<Observation> obsList = new ArrayList<Observation>();

		org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory
				.create(input);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		String province = "";
		String CA = "";
		double totalValue = 0;
		double totalValueMen = 0;
		double totalValueWomen = 0;
		double totalValueUnder25 = 0;
		double valueMenUnder25 = 0;
		double valueWomenMenUnder25 = 0;
		double totalValueOver25 = 0;
		double valueMenOver25 = 0;
		double valueWomenOver25 = 0;

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			Observation obs = new Observation();
			// util data start at row 9 and finish at row 70
			if (row.getRowNum() > 7 && row.getRowNum() < 70) {
				
				
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					if (cell.getColumnIndex() == 1) {
						String value = cell.getStringCellValue();
						if (value.equals("ANDALUCIA") || value.equals("ARAGON")
								|| value.equals("PRINCIPADO DE ASTURIAS")
								|| value.equals("ILLES BALEARS")
								|| value.equals("CANARIAS")
								|| value.equals("CANTABRIA")
								|| value.equals("CASTILLA-LA MANCHA")
								|| value.equals("CASTILLA Y LEON")
								|| value.equals("CATALUÑA")
								|| value.equals("COM. VALENCIANA")
								|| value.equals("EXTREMADURA")
								|| value.equals("GALICIA")
								|| value.equals("COM. DE MADRID")
								|| value.equals("REGION DE MURCIA")
								|| value.equals("COM. FORAL DE NAVARRA")
								|| value.equals("PAIS VASCO")
								|| value.equals("LA RIOJA")
								|| value.equals("CEUTA")
								|| value.equals("MELILLA")) {
							CA = value;
							obs.setAutonomousCommunity(CA);
							System.out.print("Comunidad autónoma ");
						} else {
							province = value;
							obs.setProvince(province);
							System.out.print("Provincia ");
						}
					}
					if (cell.getColumnIndex() == 2) {
						totalValue = cell.getNumericCellValue();
						System.out.println(totalValue);
						obs.setObsValue(totalValue);
					}
					if (cell.getColumnIndex() == 3) {
						totalValueMen = cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 4) {
						totalValueWomen = cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 5) {
						totalValueUnder25 = cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 6) {
						valueMenUnder25 = cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 7) {
						valueWomenMenUnder25 = cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 8) {
						totalValueOver25 = cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 9) {
						valueMenOver25 = cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 10) {
						valueWomenOver25 = cell.getNumericCellValue();
					}

				}
				
			}
			System.out.println(obs.getProvince() + " - " + obs.getObsValue());
			obsList.add(obs);

		}
		return obsList;

	}
}