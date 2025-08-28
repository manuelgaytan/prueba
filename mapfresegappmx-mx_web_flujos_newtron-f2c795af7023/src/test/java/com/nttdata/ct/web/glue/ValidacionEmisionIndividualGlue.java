package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class ValidacionEmisionIndividualGlue {
    @Autowired
    private Tasks tasks;

    @And("Ingreso información de poliza automoviles individual {string}, {string}, {string}")
    public void infPoliza(String numPolizaGrupo, String numContrato, String numSubcontrato) {
        tasks.validacionEmisionIndividualTask.primerPantalla(numPolizaGrupo, numContrato, numSubcontrato);
    }
    @And("CP001_Validar atributos individual {string}, {string}, {string}, {string}, {string}, {string}")
    public void infGeneral(String numPolizaGrupo, String tipoDocumento, String rfcUsuario, String codigoTercero, String cuadCom, String codigoOficina) {
        if (!numPolizaGrupo.contains("ZZZZZZZZZZZZZ")) {
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo(numPolizaGrupo);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo1(numPolizaGrupo);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo2(numPolizaGrupo, tipoDocumento, rfcUsuario);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo3(numPolizaGrupo, codigoTercero, cuadCom, codigoOficina);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo4(numPolizaGrupo);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo5(numPolizaGrupo);
            tasks.validacionEmisionflotillasTask.primerPantallaConPolizaGrupo6();
        }else {
            tasks.validacionEmisionIndividualTask.primerPantalla2();
            tasks.validacionEmisionIndividualTask.primerPantalla3();
            tasks.validacionEmisionIndividualTask.primerPantalla4(tipoDocumento, rfcUsuario);
            tasks.validacionEmisionIndividualTask.primerPantalla5(codigoTercero, cuadCom, codigoOficina);
            tasks.validacionEmisionIndividualTask.primerPantalla6();
            tasks.validacionEmisionIndividualTask.primerPantalla7();
        }
    }

    @And("CP002_Validar tarifa y coberturas individual {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void ingresoDatosSegundaPantalla2(String codTarifa, String codAmbCirculacion, String codTipoVehi, String tipoIndemnizacion, String codMarca, String codModelo, String codSubModelo, String anioSubModelo, String codUsoVehiculo, String codModalidad) {
        tasks.validacionEmisionIndividualTask.segundaPantalla(codAmbCirculacion, codTipoVehi, tipoIndemnizacion, codMarca, codModelo, codSubModelo, anioSubModelo, codUsoVehiculo);
        tasks.validacionEmisionIndividualTask.segundaPantalla2(codModalidad, codTipoVehi);
        tasks.validacionEmisionIndividualTask.segundaPantalla3(codTarifa);
        tasks.validacionEmisionIndividualTask.segundaPantalla4();
    }

    @And("Ingreso datos para validar individual")
    public void ingresoDatosSegundaPantalla() {
        tasks.validacionEmisionIndividualTask.datosModificar();
        tasks.validacionEmisionIndividualTask.datosModificar2();
    }

    @Then("CP004_Emisión con la tarifa individual {string}")
    public void emisionFlotillas(String codTarifa) {
        tasks.validacionEmisionIndividualTask.emisionIndividual(codTarifa);
        tasks.validacionEmisionIndividualTask.emision2Individual();
    }


}
