package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class EndosoCambioAgenteGlue {
    @Autowired
    private Tasks tasks;



    @And("Ir al apartado de cambio de agente {string},{string}")
    public void irAlApartadoDeCambioDeAgente(String codSuplemento, String suplemento) {
        tasks.endosoCambioAgenteTask.primerPantalla(codSuplemento, suplemento);

    }
    @And("Modificar poliza por agente {string},{string},{string},{string}")
    public void modificarPolizaPorAgente(String codTercero, String cuadComision, String codOficina, String canalDsitrib) {
        tasks.endosoCambioAgenteTask.cambioAgente();
        tasks.endosoCambioAgenteTask.cambioAgente2( codTercero,  cuadComision, codOficina,  canalDsitrib);
        tasks.endosoCambioAgenteTask.cambioAgente3(codTercero);
    }

    @Then("Generando el endoso cambio de agente")
    public void generandoElEndosoCambioDeAgente() {
        tasks.endosoCambioAgenteTask.GeneraEndosoAceptar();
        tasks.endosoCambioAgenteTask.salirGrabacion();
    }

}
