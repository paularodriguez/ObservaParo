package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Province;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ProvinceCreator {

	public List<Province> read(InputStream input) throws IOException, Exception {

		List<Province> provinceList = new ArrayList<Province>();

		org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory
				.create(input);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();
		
		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			Province prov = null;
			// util data start at row 1
			if (row.getRowNum() > 0) {
				
				prov = new Province();
				
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					
					if (cell.getColumnIndex() == 0) {
						prov.id = cell.getStringCellValue();
					}
					if (cell.getColumnIndex() == 1) {
						prov.name = cell.getStringCellValue();
					}
				}
			}
			if (prov != null)
				provinceList.add(prov);

		}
		return provinceList;
	}
}
