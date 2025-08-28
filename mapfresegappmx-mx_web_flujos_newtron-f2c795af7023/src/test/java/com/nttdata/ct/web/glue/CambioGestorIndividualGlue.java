package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.CambioGestionIndividualTask;
import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class CambioGestorIndividualGlue {
    @Autowired
    private Tasks tasks;

    public CambioGestionIndividualTask cambioGestionIndividualTask;

    @And("Atributos de poliza")
    public void atributosTareas() {
        tasks.cambioGestionIndividualTask.atributosPioliza();
        tasks.cambioGestionIndividualTask.historialEjecucion();
    }
    @Then("Consultar cambios")
    public void consultarCambios() {
        //tasks.cambioGestionIndividualTask.historialEjecucion();
        tasks.cambioGestionIndividualTask.consultarCambiosPoliza();
        tasks.cambioGestionIndividualTask.consultarCambiosPoliza2();
    }
}
