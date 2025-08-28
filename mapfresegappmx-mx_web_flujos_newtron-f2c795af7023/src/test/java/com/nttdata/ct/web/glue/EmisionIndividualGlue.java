package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class EmisionIndividualGlue {
    @Autowired
    private Tasks tasks;

    @Given("Inicio la sesión con usuario y contrasena")
    public void inicioLaSesiónConUsuarioYContrasenaYPerfil() {
        tasks.emisionIndividualTask.ingresoCredencialesCotEmi();
    }

    @And("Inicio la sesión con usuario y contrasena REC")
    public void inicioLaSesiónConUsuarioYContrasenaYPerfilRec() {
        tasks.emisionIndividualTask.ingresoCredencialesCotEmiRec();
    }

    @And("Ingreso datos primer pantalla cotización de automoviles individual {string}, {string}, {string}, {string}, {string}")
    public void  meEncuentroEnLaPrimerPantalla(String tipoDocumento, String rfcUsuario, String codigoTercero, String cuadCom, String codigoOficina) {
        tasks.emisionIndividualTask.primerPantalla();
        tasks.emisionIndividualTask.primerPantalla2();
        tasks.emisionIndividualTask.primerPantalla3();
        tasks.emisionIndividualTask.primerPantalla4(tipoDocumento, rfcUsuario);
        tasks.emisionIndividualTask.primerPantalla5(codigoTercero, cuadCom, codigoOficina);
        tasks.emisionIndividualTask.primerPantalla6();
        tasks.emisionIndividualTask.primerPantalla7();
    }

    @And("Ingreso datos segunda pantalla cotización de automoviles individual {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void ingresoDatosSegundaPantalla2(String codAmbCirculacion, String codTipoVehi, String tipoIndemnizacion, String codMarca, String codModelo, String codSubModelo, String anioSubModelo, String codUsoVehiculo, String codModalidad) {
        tasks.emisionIndividualTask.segundaPantalla(codAmbCirculacion, codTipoVehi, tipoIndemnizacion, codMarca, codModelo, codSubModelo, anioSubModelo, codUsoVehiculo, codModalidad);
    }
    @And("Ingreso datos para cotizar individual")
    public void ingresoDatosSegundaPantalla() {
        tasks.emisionIndividualTask.datosModificar();
        tasks.emisionIndividualTask.datosModificar2();
    }
    @Then("Ingreso datos para emisión")
    public void emision() {
        tasks.emisionIndividualTask.emisionIndividual();
        tasks.emisionIndividualTask.emisionIndividual2();
    }

}
