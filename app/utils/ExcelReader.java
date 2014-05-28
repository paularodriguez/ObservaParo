package utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Month;
import models.Observation;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public List<Observation> read(InputStream input) throws IOException,
			InvalidFormatException {
		List<Observation> obsList = new ArrayList<Observation>();

		org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory
				.create(input);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

		FormulaEvaluator evaluator = workbook.getCreationHelper()
				.createFormulaEvaluator();
		Iterator<Row> rowIterator = sheet.iterator();
		Observation obs = new Observation();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				// Check the cell type after eveluating formulae
				// If it is formula cell, it will be evaluated otherwise no
				// change will happen
				double year = 0;
				String month = "";
				double totalValue= 0;
				double agricultureSector= 0;
				double industrySector= 0;
				double buildingSector= 0;
				double servicesSector= 0;
				double withoutEmploy= 0;
				
				
				switch (evaluator.evaluateInCell(cell).getCellType()) {

				case Cell.CELL_TYPE_NUMERIC:
					if (cell.getColumnIndex()==3){
						totalValue = cell.getNumericCellValue();
						obs.setObsValue(totalValue);
					}
					if (cell.getColumnIndex()==4){
						agricultureSector = cell.getNumericCellValue();
						obs.setAgricultureSectorValue(agricultureSector);
						//System.out.print("A" + agricultureSector + " - ");
					}
					if (cell.getColumnIndex()==5){
						industrySector = cell.getNumericCellValue();
						//System.out.print("I " + industrySector + " - ");
					}
					if (cell.getColumnIndex()==6){
						buildingSector = cell.getNumericCellValue();
						//System.out.print("B " + buildingSector + " - ");
					}
					if (cell.getColumnIndex()==9){
						servicesSector = cell.getNumericCellValue();
						//System.out.print("S "+ servicesSector + " - ");
					}
					if (cell.getColumnIndex()==12){
						withoutEmploy = cell.getNumericCellValue();
						//System.out.print("W " + withoutEmploy + " - ");
					}
					break;
				case Cell.CELL_TYPE_STRING:
					if (cell.getColumnIndex() == 2){
						month = cell.getStringCellValue();
						obs.setMonth(new Month(month));
					}
					break;
				}
				System.out.println("Valor" + obs.getObsValue() + " " + obs.getAgricultureSector());
				
			}
			System.out.println("");
		}

		return obsList;
	}
}