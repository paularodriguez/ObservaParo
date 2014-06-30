package api;
import static org.fest.assertions.Assertions.assertThat;
import play.test.TestBrowser;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class APISteps {

    @Inject
    private TestBrowser testBrowser;

    @Inject
    @Named("PORT")
    private Integer port;

    @Dado("^que tengo iniciada la aplicacion$")
    public void que_tengo_iniciada_la_aplicacion() throws Throwable {
    }

    @Cuando("^ejecuto un servicio REST para obtener una provincia por su código (.+)$")
    public void servicio_REST_provincia_por_codigo(String codigo) throws Throwable {
        testBrowser.goTo("http://localhost:" + "/api/province/"+codigo);
    }
    
    @Cuando("^ejecuto un servicio REST para obtener el listado de comunidades autónomas$")
    public void servicio_REST_comunidades_autonomas() throws Throwable {
        testBrowser.goTo("http://localhost:" + "/api/autonomouscommunities");
    }
    
    @Cuando("^ejecuto un servicio REST para obtener una observacion del año (.+)$")
    public void servicio_REST_observacion_año(int año) throws Throwable {
        testBrowser.goTo("http://localhost:" + "/api/historicobservations/year/"+año);
    }
    
    @Cuando("^ejecuto un servicio REST para obtener una observacion del mes (.+)$")
    public void servicio_REST_observacion_mes(String mes) throws Throwable {
        testBrowser.goTo("http://localhost:" + "/api/historicobservations/month/"+mes);
    }

    @Entonces("^el contenido resultante contiene (.+)$")
    public void el_contenido_contiene(String content) throws Throwable {
        assertThat(testBrowser.pageSource().contains(content));
    }
    
    @Entonces("^el contenido resultante no contiene (.+)$")
    public void el_contenido_no_contiene(String content) throws Throwable {
        assertThat(!testBrowser.pageSource().contains(content));
    }
    

}