package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class TerminacionExpedientesGlue {
    @Autowired
    private Tasks tasks;
    @And("Ir a terminacion de expedientes")
    public void cp_CompletarDatosPersonaLegal() {
        tasks.terminacionExpedienteTask.terminacionExpediente();
    }

    @And("Motivo de terminacion")
    public void motivoDeTerminacion() {
        tasks.terminacionExpedienteTask.motivoTerminacion();
    }

    @And("Finaliza expediente")
    public void finalilizacion() {
        tasks.terminacionExpedienteTask.aceptarOperacion();
    }
}
