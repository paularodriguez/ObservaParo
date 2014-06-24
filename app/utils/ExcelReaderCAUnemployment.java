package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.ACObservation;
import models.AutonomousCommunity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReaderCAUnemployment {

	public List<ACObservation> read(InputStream input) throws IOException,
			Exception {

		List<ACObservation> obsList = new ArrayList<ACObservation>();

		org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory
				.create(input);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			ACObservation obs = null;
			// util data start at row 9 and finish at row 70
			if (row.getRowNum() > 7 && row.getRowNum() < 70) {
				obs = new ACObservation();
				
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
							switch (value) {
							case "ANDALUCIA":
								value = "Andalucía";
								break;
							case "ARAGON":
								value = "Aragón";
								break;
							case "PRINCIPADO DE ASTURIAS":
								value = "Principado de Asturias";
								break;
							case "ILLES BALEARS":
								value = "Illes Balears";
								break;
							case "CANARIAS":
								value = "Canarias";
								break;
							case "CANTABRIA":
								value = "Cantabria";
								break;
							case "CASTILLA-LA MANCHA":
								value = "Castilla-La Mancha";
								break;
							case "CASTILLA Y LEON":
								value = "Castilla y León";
								break;
							case "CATALUÑA":
								value = "Cataluña";
								break;
							case "COM. VALENCIANA":
								value = "Comunitat Valenciana";
								break;
							case "EXTREMADURA":
								value = "Extremadura";
								break;
							case "GALICIA":
								value = "Galicia";
								break;
							case "COM. DE MADRID":
								value = "Comunidad de Madrid";
								break;
							case "REGION DE MURCIA":
								value = "Región de Murcia";
								break;
							case "COM. FORAL DE NAVARRA":
								value = "Comunidad Foral de Navarra";
								break;
							case "PAIS VASCO":
								value = "País Vasco";
								break;
							case "LA RIOJA":
								value = "La Rioja";
								break;
							case "CEUTA":
								value = "Ceuta";
								break;
							case "MELILLA":
								value = "Melilla";
								break;
							default:
								break;
							}
							obs.autonomousCommunity =AutonomousCommunity.findByName(value);
						} else {
							obs.autonomousCommunity = null;
						}
					}
					if (cell.getColumnIndex() == 2) {
						obs.totalValue = (int)cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 3) {
						obs.totalValueMen = (int)cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 4) {
						obs.totalValueWomen =(int)cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 5) {
						obs.totalValueUnder25 = (int)cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 6) {
						obs.valueMenUnder25 = (int)cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 7) {
						obs.valueWomenUnder25 =(int)cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 8) {
						obs.totalValueOver25 = (int)cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 9) {
						obs.valueMenOver25 = (int)cell.getNumericCellValue();
					}
					if (cell.getColumnIndex() == 10) {
						obs.valueWomenOver25 = (int)cell.getNumericCellValue();
					}
				}
			}
			if (obs != null)
				if (obs.autonomousCommunity!=null)
					obsList.add(obs);
		}
		return obsList;
	}
}