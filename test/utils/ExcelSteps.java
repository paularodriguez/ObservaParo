package utils;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import models.AutonomousCommunity;
import models.HistoricObservation;
import models.Province;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class ExcelSteps {

	private final ExcelReaderSectorUnemploymentEvolution eR = new ExcelReaderSectorUnemploymentEvolution();
	private final ProvinceCreator pC = new ProvinceCreator();
	private final ACCreator aC = new ACCreator();

	
	private InputStream input;
	private List<HistoricObservation> obsList;
	private List<Province> provincesList;
	private List<AutonomousCommunity> aCList;

	@Dado("^que obtengo el fichero excel (.+)$")
	public void que_obtengo_la_hoja_excel(String xlsFile) throws Throwable {
		String file = "documents/"+xlsFile;
		input = new FileInputStream(new File(file));
	}

	@Cuando("^leo las observaciones$")
	public void leo_las_observaciones() throws Throwable {
		obsList = eR.read(input);
	}

	@Entonces("^el año de la primera observacion es (\\d+)$")
	public void el_año_de_la_primera_observacion_es(int expected) throws Throwable {
		assertEquals(obsList.get(0).getYear(), expected);
	}

	@Entonces("^el valor de la primera observacion es (.+)$")
	public void el_valor_de_la_primera_observacion_es_(Double expected) throws Throwable {
		assertEquals(obsList.get(0).getObsValue(), expected);
	}

	@Cuando("^leo las provincias$")
	public void leo_las_provincias() throws Throwable {
		provincesList = pC.read(input);
	}
	
	@Entonces("^el numero de provincias es (\\d+)$")
	public void el_numero_de_provincias_es(int expected) throws Throwable {
		assertEquals(provincesList.size(), expected);
	}
	
	@Cuando("^leo las comunidades autonomas$")
	public void leo_las_comunidades_autonomas() throws Throwable {
		aCList = aC.read(input);
	}
	
	@Entonces("^el numero de comunidades es (\\d+)$")
	public void el_numero_de_comunidades_es(int expected) throws Throwable {
		assertEquals(aCList.size(), expected);
	}

}