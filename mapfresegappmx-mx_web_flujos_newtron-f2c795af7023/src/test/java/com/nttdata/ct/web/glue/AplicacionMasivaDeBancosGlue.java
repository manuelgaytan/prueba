package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class AplicacionMasivaDeBancosGlue {
    @Autowired
    private Tasks tasks;
    @Autowired
    private LoginUI loginUI;

    @And("Completar formulario Atributos AMB {string},{string},{string}")
    public void completarFormularioAtrib(String codcompania,String tipoproceso,String tipogestor) {
        tasks.aplicacionMasivaDeBancosTask.completarFormulario(codcompania,tipoproceso,tipogestor);

    }
    @And("Completar formulario Atributos AMB2 {string},{string},{string},{string}")
    public void completarFormularioAtrib2(String codgestor, String tiponegocio, String formacompensacion, String nombrearchivo) {
        tasks.aplicacionMasivaDeBancosTask.completarFormulario2(codgestor,tiponegocio,formacompensacion,nombrearchivo);
        tasks.aplicacionMasivaDeBancosTask.validarERROR();
    }
    @And("Aceptar formulario {string},{string}")
    public void aceptarForm(String codcompania, String nombrearchivo) {
        tasks.aplicacionMasivaDeBancosTask.aceptarFormulario(codcompania, nombrearchivo);
    }


    @And("Descargar archivo de salida")
    public void descargarArchivoDeSaida() {
        tasks.aplicacionMasivaDeBancosTask.descargarArchivoDeSalida();
    }

    @And("Consulta aplicación de cobros")
    public void consultaAplicacionDeCobros() {
        tasks.aplicacionMasivaDeBancosTask.consultaAplicacionDeCobro();
        tasks.aplicacionMasivaDeBancosTask.consultaAplicacionDeCobroAceptar();
        tasks.aplicacionMasivaDeBancosTask.consultaAplicacionDeCobroAceptarAplicacionCobro();
        tasks.aplicacionMasivaDeBancosTask.consultaAplicacionDeCobroAceptarAplicacion();
    }


    @Then("Historico cobros")
    public void historicoCobros() {
        tasks.aplicacionMasivaDeBancosTask.historicocobros();
        tasks.aplicacionMasivaDeBancosTask.historicocobrosconsultar();
    }
}
