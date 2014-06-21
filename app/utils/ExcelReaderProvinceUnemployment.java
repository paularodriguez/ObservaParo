package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Province;
import models.ProvinceObservation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReaderProvinceUnemployment {

	public List<ProvinceObservation> read(InputStream input)
			throws IOException, Exception {

		List<ProvinceObservation> obsList = new ArrayList<ProvinceObservation>();

		org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory
				.create(input);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			ProvinceObservation obs = null;
			// util data start at row 9 and finish at row 70
			if (row.getRowNum() > 7 && row.getRowNum() < 70) {
				obs = new ProvinceObservation();
				
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						String value = cell.getStringCellValue();
						if (!(value.equals("ANDALUCIA")
								|| value.equals("ARAGON")
								|| value.equals("CANARIAS")
								|| value.equals("CASTILLA-LA MANCHA")
								|| value.equals("CASTILLA Y LEON")
								|| value.equals("CATALUÑA")
								|| value.equals("COM. VALENCIANA")
								|| value.equals("EXTREMADURA")
								|| value.equals("GALICIA")
								|| value.equals("PAIS VASCO"))) {
							switch (value) {
							case "ALMERIA":
								value = "Almería";
								break;
							case "CADIZ":
								value = "Cádiz";
								break;
							case "CORDOBA":
								value = "Córdoba";
								break;
							case "GRANADA":
								value = "Granada";
								break;
							case "HUELVA":
								value = "Huelva";
								break;
							case "JAEN":
								value = "Jaén";
								break;
							case "ILLES BALEARS":
								value = "Balears (Illes)";
								break;
							case "MALAGA":
								value = "Málaga";
								break;
							case "SEVILLA":
								value = "Sevilla";
								break;
							case "HUESCA":
								value = "Huesca";
								break;
							case "TERUEL":
								value = "Teruel";
								break;
							case "ZARAGOZA":
								value = "Zaragoza";
								break;
							case "PRINCIPADO DE ASTURIAS":
								value = "Asturias";
								break;
							case "PALMAS LAS":
								value = "Palmas (Las)";
								break;
							case "STA. CRUZ DE TENERIFE":
								value = "Santa Cruz de Tenerife";
								break;
							case "CANTABRIA":
								value = "Cantabria";
								break;
							case "ALBACETE":
								value = "Albacete";
								break;
							case "CIUDAD REAL":
								value = "Ciudad Real";
								break;
							case "CUENCA":
								value = "Cuenca";
								break;
							case "GUADALAJARA":
								value = "Guadalajara";
								break;
							case "TOLEDO":
								value = "Toledo";
								break;
							case "AVILA":
								value = "Ávila";
								break;
							case "BURGOS":
								value = "Burgos";
								break;
							case "LEON":
								value = "León";
								break;
							case "PALENCIA":
								value = "Palencia";
								break;
							case "SALAMANCA":
								value = "Salamanca";
								break;
							case "SEGOVIA":
								value = "Segovia";
								break;
							case "SORIA":
								value = "Soria";
								break;
							case "VALLADOLID":
								value = "Valladolid";
								break;
							case "ZAMORA":
								value = "Zamora";
								break;
							case "BARCELONA":
								value = "Barcelona";
								break;
							case "GIRONA":
								value = "Girona";
								break;
							case "LLEIDA":
								value = "Lleida";
								break;
							case "TARRAGONA":
								value = "Tarragona";
								break;
							case "ALICANTE/ALACANT":
								value = "Alicante/Alacant";
								break;
							case "CASTELLON/CASTELLO":
								value = "Castellón/Castelló";
								break;
							case "VALENCIA":
								value = "Valencia/València";
								break;
							case "BADAJOZ":
								value = "Badajoz";
								break;
							case "CACERES":
								value = "Cáceres";
								break;
							case "CORUÑA A":
								value = "Coruña (A)";
								break;
							case "LUGO":
								value = "Lugo";
								break;
							case "OURENSE":
								value = "Ourense";
								break;
							case "PONTEVEDRA":
								value = "Pontevedra";
								break;
							case "COM. DE MADRID":
								value = "Madrid";
								break;
							case "REGION DE MURCIA":
								value = "Murcia";
								break;
							case "COM. FORAL DE NAVARRA":
								value = "Navarra";
								break;
							case "ARABA/ALAVA":
								value = "Araba/Álava";
								break;
							case "BIZKAIA":
								value = "Bizkaia";
								break;
							case "GIPUZKOA":
								value = "Gipuzkoa";
								break;
							case "LA RIOJA":
								value = "Rioja (La)";
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
							 obs.province = Province.findByName(value);
						} else {
							obs.province = null;
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
				if (obs.province!=null)
					obsList.add(obs);
		}
		return obsList;

	}
}