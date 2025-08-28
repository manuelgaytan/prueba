package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class EndosoAnulacionSuplementoGlue {
    @Autowired
    private Tasks tasks;

    @And("Ir al apartado de anulacion de suplementos")
    public void irAlApartadoDePlanDePagoPoliza() {
        tasks.anulacionSuplementoTask.primerPantalla();
    }

    @And("Suplemento de poliza aceptar")
    public void suplementoDePolizaAceptar() {
        tasks.anulacionSuplementoTask.comentarioSuplemento();
    }

    @Then("Generando el endoso anulacion de suplemento")
    public void generandoElEndosoAnulacionDeSuplemento() {
        tasks.anulacionSuplementoTask.aceptarGrabacion();
        tasks.anulacionSuplementoTask.finalizar();
    }
}
