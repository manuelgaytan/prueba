package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.CreacionExpedientesUI;
import com.nttdata.ct.web.ui.IndividualSiniestroUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class CreacionExpedienteGlue {
    @Autowired
    private Tasks tasks;

    @And("Finalizar apertura")
    public void completarDatosPersonaLegal(  ) {
        tasks.creacionExpedientesTask.finalizarApertura();
    }

    @And("Ir a apertura de expediente")
    public void irAAperturaDeExpediente() {
        tasks.creacionExpedientesTask.irAperturaExpedientes();
    }

    @And("Llenado de daños parciales")
    public void llenadoDeDañosParciales() {
        tasks.creacionExpedientesTask.irAperturaSimiestro2();
    }

    @And("Datos Complementarios")
    public void datosComplementarios() {
        tasks.creacionExpedientesTask.datosComplementarios();
    }

    @Then("Fiinalizar expediente")
    public void fiinalizarExpediente() {
        tasks.creacionExpedientesTask.finalizarExpediente();
        tasks.creacionExpedientesTask.finalizarExpediente2();
    }
}
