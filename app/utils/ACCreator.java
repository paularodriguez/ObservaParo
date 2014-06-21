package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.AutonomousCommunity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ACCreator {

	public List<AutonomousCommunity> read(InputStream input)
			throws IOException, Exception {

		List<AutonomousCommunity> ACList = new ArrayList<AutonomousCommunity>();

		org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory
				.create(input);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			AutonomousCommunity aC = null;			
			// util data start at row 1
			if (row.getRowNum() > 0) {

				aC = new AutonomousCommunity();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
			/*	if (cell.getColumnIndex() == 0) {
						provinceId =  cell.getStringCellValue();
					}
					if (cell.getColumnIndex() == 1) {
						provinceName =  cell.getStringCellValue();
					}*/
					if (cell.getColumnIndex() == 2) {
						aC.setId(cell.getStringCellValue());
					}
					if (cell.getColumnIndex() == 3) {
						aC.setName(cell.getStringCellValue());
					}
				}
			}
			//Add autonomous communities without duplicates
			if (aC != null && !ACList.contains(aC)){
			//	aC.getProvinces().add(new Province(provinceId,provinceName,aC));
				ACList.add(aC);
			}
		/*	else if (aC != null && ACList.contains(aC)){
				ACList.get(ACList.indexOf(aC)).getProvinces().add(new Province(provinceId,provinceName,aC) );
			}*/
		}
		return ACList;
	}
}
