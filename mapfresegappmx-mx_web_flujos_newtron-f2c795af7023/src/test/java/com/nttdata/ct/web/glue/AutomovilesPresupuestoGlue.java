package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.IndividualConsultaUI;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class AutomovilesPresupuestoGlue {
    @Autowired
    private Tasks tasks;

    @And("Datos primer pantalla cotización presupuesto de automoviles individual {string}, {string}, {string}, {string}, {string}, {string}")
    public void  meEncuentroEnLaPrimerPantallaPresupuesto(String tipoDocumento, String rfcUsuario, String codigoTercero, String cuadCom, String codigoOficina, String codigoFuenteDist) {
        tasks.automovilesPresupuestoTask.primerPantalla();
        tasks.automovilesPresupuestoTask.primerPantalla2();
        tasks.automovilesPresupuestoTask.primerPantalla3();
        tasks.automovilesPresupuestoTask.primerPantalla4(tipoDocumento, rfcUsuario);
        tasks.automovilesPresupuestoTask.primerPantalla5(codigoTercero, cuadCom, codigoOficina, codigoFuenteDist);
        tasks.automovilesPresupuestoTask.primerPantalla6();
        tasks.automovilesPresupuestoTask.primerPantalla7();
    }


    @And("Datos segunda pantalla cotización presupuesto de automoviles individual {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void ingresoDatosSegundaPantalla2Presupuesto(String codAmbCirculacion, String codTipoVehi, String tipoIndemnizacion, String codMarca, String codModelo, String codSubModelo, String anioSubModelo, String codUsoVehiculo, String codModalidad) {
        tasks.automovilesPresupuestoTask.segundaPantalla(codAmbCirculacion, codTipoVehi, tipoIndemnizacion, codMarca, codModelo, codSubModelo, anioSubModelo, codUsoVehiculo, codModalidad);
    }
    @And("Ingreso datos para cotización de presupuesto")
    public void ingresoDatosSegundaPantalla1Presupuesto() {
        tasks.automovilesPresupuestoTask.datosModificar();
        tasks.automovilesPresupuestoTask.datosModificar2();
    }
    @And("Ingreso datos para presupuesto de emisión")
    public void emisionPesupuestoIndividual() {
        tasks.automovilesPresupuestoTask.emisionIndividual();
        tasks.automovilesPresupuestoTask.emisionIndividual2();
    }
    @Then("Consulta de emisión de presupuesto")
    public void consultaEmisionPesupuestoIndividual() {
        tasks.automovilesPresupuestoTask.consultaPresupuesto();

    }





}
