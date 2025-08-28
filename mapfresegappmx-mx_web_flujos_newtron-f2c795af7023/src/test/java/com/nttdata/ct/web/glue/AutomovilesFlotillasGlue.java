package com.nttdata.ct.web.glue;


import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class AutomovilesFlotillasGlue {

    @Autowired
    private Tasks tasks;


    @And("Ingreso datos primer pantalla cotización de automoviles flotillas {string}, {string}, {string}, {string}, {string}")
    public void capturaDatosInformacionGeneral(String tipoDocumento, String rfcUsuario, String codigoTercero, String cuadCom, String codigoOficina){
            tasks.automovilesFlotillasTask.primerPantalla();
            tasks.automovilesFlotillasTask.primerPantalla2();
            tasks.automovilesFlotillasTask.primerPantalla3();
            tasks.automovilesFlotillasTask.primerPantalla4(tipoDocumento, rfcUsuario);
            tasks.automovilesFlotillasTask.primerPantalla5(codigoTercero, cuadCom, codigoOficina);
            tasks.automovilesFlotillasTask.primerPantalla6();
            tasks.automovilesFlotillasTask.primerPantalla7();
    }

    @Then("Ingreso datos segunda pantalla cotización de automoviles flotillas {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void capturarDatosRiesgos(String codAmbCirculacion, String codTipoVehi, String tipoIndemnizacion, String codMarca, String codModelo, String codSubModelo, String anioSubModelo, String codUsoVehiculo, String codModalidad){
        tasks.automovilesFlotillasTask.segundaPantalla(codAmbCirculacion, codTipoVehi, tipoIndemnizacion, codMarca, codModelo, codSubModelo, anioSubModelo, codUsoVehiculo, codModalidad);
    }

    @And("Ingreso datos para cotizar flotillas")
    public void ingresoDatosSegundaPantallaFlotillas1() {
        tasks.automovilesFlotillasTask.datosModificar();
        tasks.automovilesFlotillasTask.datosModificar2();
    }
    @Then("Ingreso datos para emisión flotillas")
    public void emisionFlotillas() {
        tasks.automovilesFlotillasTask.emisionFlotillas();
        tasks.automovilesFlotillasTask.emision2Flotillas();
    }
}
