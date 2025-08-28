package com.nttdata.ct.web.glue;


import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;



public class EndosoCancelacionGlue {
    @Autowired
    private Tasks tasks;

    @And("Ir al apartado de cancelacion de agente")
    public void irAlApartadoDePlanDePagoPoliza() {
        tasks.endosoCancelacionTask.primerPantalla();
    }

    @And("Cancelacion de poliza aceptar")
    public void cancelacionDePolizaComentario() {
        tasks.endosoCancelacionTask.comentarioCancelacion();
    }

    @Then("Generando el endoso de cancelacion")
    public void polizaCancelada() {
        tasks.endosoCancelacionTask.GeneraEndosoAceptar();
    }
}
