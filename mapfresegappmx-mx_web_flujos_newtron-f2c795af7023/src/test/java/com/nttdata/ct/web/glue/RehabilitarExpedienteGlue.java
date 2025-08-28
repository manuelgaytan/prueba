package com.nttdata.ct.web.glue;


import com.nttdata.ct.web.task.Tasks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class RehabilitarExpedienteGlue {
    @Autowired
    private Tasks tasks;


    @And("Ir a rehabilitacion expediente")
    public void iraReabilitacionExpediente(  ) {
        tasks.rehabilitarExpedienteTask.habilitarExpediente();
    }

    @And("Causa de rehabilitacion")
    public void completarDatosPersonaLegal(  ) {
        tasks.rehabilitarExpedienteTask.consultaExpediente();
    }
    @And("Consecuencia rehabilitacion")
    public void completarDatosPersonaLegal2(  ) {
        tasks.rehabilitarExpedienteTask.consultaExpediente2();
    }
    @Then("Finalizar Rehabilitacion")
    public void completarDatosPersonaLegal3(  ) {
        tasks.rehabilitarExpedienteTask.consultaExpediente3();
        tasks.rehabilitarExpedienteTask.consultaExpediente4();
    }

}
