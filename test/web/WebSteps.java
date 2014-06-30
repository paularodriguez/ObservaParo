package web;
import static org.fest.assertions.Assertions.assertThat;
import play.test.TestBrowser;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class WebSteps {

    @Inject
    private TestBrowser testBrowser;

    @Inject
    @Named("PORT")
    private Integer port;

    @Dado("^que tengo arrancada la aplicacion$")
    public void que_tengo_arrancada_la_aplicacion() throws Throwable {
    }

    @Cuando("^voy a la pagina principal$")
    public void voy_a_la_pagina_principal() throws Throwable {
        testBrowser.goTo("http://localhost:" + port);
    }
    
    @Cuando("^voy a la pagina de comunidades autonomas$")
    public void voy_a_la_pagina_de_comunidades_autonomas() throws Throwable {
        testBrowser.goTo("http://localhost:" + port + "/autonomousCommunities");
    }
    
    @Cuando("^voy a la pagina de provincias$")
    public void voy_a_la_pagina_de_provincias() throws Throwable {
        testBrowser.goTo("http://localhost:" + port + "/provinces");
    }
    
    @Cuando("^consulto las estadisticas de desempleo de mujeres$")
    public void consulto_desempleo_mujeres() throws Throwable {
        testBrowser.goTo("http://localhost:" + port + "/statistics/acTotalWomen?title=Total+Mujeres");
    }
    
    @Cuando("^consulto las estadisticas del sector servicios$")
    public void consulto_sector_construccion() throws Throwable {
        testBrowser.goTo("http://localhost:" + port + "/sectorStatistics?indicator=servicesSector&title=Sector+Servicios");
    }


    @Entonces("^el titulo es (.+)$")
    public void el_titulo_es(String title) throws Throwable {
        assertThat(testBrowser.title()).isEqualTo(title);
    }
    
    

}