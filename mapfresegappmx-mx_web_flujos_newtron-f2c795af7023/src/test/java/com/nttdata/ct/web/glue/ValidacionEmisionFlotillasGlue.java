package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class ValidacionEmisionFlotillasGlue {
    @Autowired
    private Tasks tasks;


    @And("Ingreso información de poliza automoviles Flotillas {string}, {string}, {string}")
    public void  infPoliza(String numPolizaGrupo, String numContrato, String numSubcontrato) {
        tasks.validacionEmisionflotillasTask.primerPantalla(numPolizaGrupo, numContrato, numSubcontrato);
    }

    @And("CP001_Validar atributos Flotillas {string}, {string}, {string}, {string}, {string}, {string}")
    public void  infGeneral(String numPolizaGrupo, String tipoDocumento, String rfcUsuario, String codigoTercero, String cuadCom, String codigoOficina) {
        if (!numPolizaGrupo.contains("ZZZZZZZZZZZZZ")) {
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo(numPolizaGrupo);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo1(numPolizaGrupo);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo2(numPolizaGrupo, tipoDocumento, rfcUsuario);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo3(numPolizaGrupo, codigoTercero, cuadCom, codigoOficina);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo4(numPolizaGrupo);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo5(numPolizaGrupo);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo6();
        }else {
            tasks.validacionEmisionflotillasTask.primerPantalla2();
            tasks.validacionEmisionflotillasTask.primerPantalla3();
            tasks.validacionEmisionflotillasTask.primerPantalla4(tipoDocumento, rfcUsuario);
            tasks.validacionEmisionflotillasTask.primerPantalla5(codigoTercero, cuadCom, codigoOficina);
            tasks.validacionEmisionflotillasTask.primerPantalla6();
            tasks.validacionEmisionflotillasTask.primerPantalla7();
        }
    }

    @And("CP002_Validar tarifa y coberturas Flotillas {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void ingresoDatosSegundaPantalla2(String codTarifa, String codAmbCirculacion, String codTipoVehi, String tipoIndemnizacion, String codMarca, String codModelo, String codSubModelo, String anioSubModelo, String codUsoVehiculo, String codModalidad) {
        tasks.validacionEmisionflotillasTask.segundaPantalla(codAmbCirculacion, codTipoVehi, tipoIndemnizacion, codMarca, codModelo, codSubModelo, anioSubModelo, codUsoVehiculo);
        tasks.validacionEmisionflotillasTask.segundaPantalla2(codModalidad, codTipoVehi);
        tasks.validacionEmisionflotillasTask.segundaPantalla3(codTarifa);
        tasks.validacionEmisionflotillasTask.segundaPantalla4();
    }

    @And("Ingreso datos para validar Flotillas")
    public void ingresoDatosSegundaPantalla() {
        tasks.validacionEmisionflotillasTask.datosModificar();
        tasks.validacionEmisionflotillasTask.datosModificar2();
    }

    @Then("CP003_Validar prima tarifa {string}")
    public void emision(String cantPrima) {
        tasks.validacionEmisionflotillasTask.validacionPrima(cantPrima);
    }

    @Then("CP004_Emisión con la tarifa {string}")
    public void emisionFlotillas(String codTarifa) {
        tasks.validacionEmisionflotillasTask.emisionFlotillas(codTarifa);
        tasks.validacionEmisionflotillasTask.emision2Flotillas();
    }

    @And("CP001_Validar atributos Flotillas y descuento {string}, {string}, {string}, {string}, {string}, {string}")
    public void cp_ValidarAtributosFlotillasYDescuento( String numPolizaGrupo, String tipoDocumento, String rfcUsuario, String codigoTercero, String cuadCom, String codigoOficina) {
        if (!numPolizaGrupo.contains("ZZZZZZZZZZZZZ")) {
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo(numPolizaGrupo);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo1(numPolizaGrupo);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo2(numPolizaGrupo, tipoDocumento, rfcUsuario);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo3(numPolizaGrupo, codigoTercero, cuadCom, codigoOficina);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo4(numPolizaGrupo);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo5Descuento(numPolizaGrupo);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo6();
        }else {
            tasks.validacionEmisionflotillasTask.primerPantalla2();
            tasks.validacionEmisionflotillasTask.primerPantalla3();
            tasks.validacionEmisionflotillasTask.primerPantalla4(tipoDocumento, rfcUsuario);
            tasks.validacionEmisionflotillasTask.primerPantalla5(codigoTercero, cuadCom, codigoOficina);
            tasks.validacionEmisionflotillasTask.primerPantalla6();
            tasks.validacionEmisionflotillasTask.primerPantalla7Descuento();
        }
    }
}
