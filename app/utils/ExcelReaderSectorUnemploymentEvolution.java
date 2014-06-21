package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.HistoricObservation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReaderSectorUnemploymentEvolution {
	public List<HistoricObservation> read(InputStream input) throws IOException,
			Exception {
		List<HistoricObservation> obsList = new ArrayList<HistoricObservation>();

		org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory
				.create(input);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		int year = 2005;
		String month = "";
		double totalValue = 0;
		double agricultureSector = 0;
		double industrySector = 0;
		double buildingSector = 0;
		double servicesSector = 0;
		double withoutEmploy = 0;

		while (rowIterator.hasNext()) {
			HistoricObservation obs = null;
			Row row = rowIterator.next();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();
			
			// Util data start at line 5 and finish at line 126
			if (row.getRowNum() > 4 && row.getRowNum() < 126) {
				obs = new HistoricObservation();
				obs.setYear(year);
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					
					if (cell.getColumnIndex() == 2) {
						month = cell.getStringCellValue();
						obs.setMonth(month);
					}

					if (cell.getColumnIndex() == 3) {
						totalValue = cell.getNumericCellValue();
						obs.setObsValue(totalValue);
					}
					if (cell.getColumnIndex() == 4) {
						agricultureSector = cell.getNumericCellValue();
						obs.setAgricultureSectorValue(agricultureSector);
					}
					if (cell.getColumnIndex() == 5) {
						industrySector = cell.getNumericCellValue();
						obs.setIndustrySector(industrySector);
					}
					if (cell.getColumnIndex() == 6) {
						buildingSector = cell.getNumericCellValue();
						obs.setBuildingSector(buildingSector);
					}
					if (cell.getColumnIndex() == 9) {
						servicesSector = cell.getNumericCellValue();
						obs.setServicesSector(servicesSector);
					}
					if (cell.getColumnIndex() == 12) {
						withoutEmploy = cell.getNumericCellValue();
						obs.setWithoutEmploy(withoutEmploy);
					}
				}
				if(obs.getMonth().equals("DICIEMBRE")){
					year=year+1;
				}
			}
			if (obs != null && !obs.getMonth().equals("")){
				obsList.add(obs);
			}
		}
		return obsList;

	}

}