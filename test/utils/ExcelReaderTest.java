package utils;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import models.AutonomousCommunity;
import models.HistoricObservation;
import models.Province;

import org.junit.Test;

public class ExcelReaderTest {

	@Test
	public void provinceCreatorTest() throws Throwable {
		ProvinceCreator pC = new ProvinceCreator();
		List<Province> obsList = new ArrayList<>();
		obsList = pC.read(new FileInputStream(
				new File("documents/list-pro.xls")));
		assertEquals(obsList.size(), 52);
		assertEquals(obsList.get(0).name, "Araba/Álava");
		assertEquals(obsList.get(0).id, "01");
		assertEquals(obsList.get(26).name, "Lugo");
		assertEquals(obsList.get(26).id, "27");
		assertEquals(obsList.get(51).name, "Melilla");
		assertEquals(obsList.get(51).id, "52");

	}

	@Test
	public void ACCreatorTest() throws Throwable {
		ACCreator aC = new ACCreator();
		List<AutonomousCommunity> obsList = new ArrayList<>();
		obsList = aC.read(new FileInputStream(
				new File("documents/list-pro.xls")));
		assertEquals(obsList.size(), 19);
		assertEquals(obsList.get(0).id, "16");
		assertEquals(obsList.get(0).name, "País Vasco");
		assertEquals(obsList.get(3).id, "01");
		assertEquals(obsList.get(3).name, "Andalucía");
		assertEquals(obsList.get(17).id, "18");
		assertEquals(obsList.get(17).name, "Ceuta");
	}

	@Test
	public void sectorUnemploymentExcelReaderTest() throws Throwable {
		ExcelReaderSectorUnemploymentEvolution eR = new ExcelReaderSectorUnemploymentEvolution();
		List<HistoricObservation> obsList = new ArrayList<>();
		obsList = eR.read(new FileInputStream(new File(
				"documents/evolparoseries.xls")));
		assertEquals(obsList.get(0).getYear(), 2005);
		assertEquals(obsList.get(0).getMonth(), "ENERO");
		assertEquals(obsList.get(0).getObsValue(), 2176599, 0.001);

		assertEquals(obsList.get(12).getYear(), 2006);
		assertEquals(obsList.get(12).getMonth(), "ENERO");
		assertEquals(obsList.get(12).getAgricultureSector(), 66401, 0.001);
		assertEquals(obsList.get(12).getIndustrySector(), 305207, 0.001);
		assertEquals(obsList.get(12).getBuildingSector(), 241161, 0.001);

		assertEquals(obsList.get(48).getYear(), 2009);
		assertEquals(obsList.get(48).getMonth(), "ENERO");
		assertEquals(obsList.get(48).getServicesSector(), 1936296, 0.001);

		assertEquals(obsList.get(85).getYear(), 2012);
		assertEquals(obsList.get(85).getMonth(), "FEBRERO");
		assertEquals(obsList.get(85).getWithoutEmploy(), 401521, 0.001);

	}
}
