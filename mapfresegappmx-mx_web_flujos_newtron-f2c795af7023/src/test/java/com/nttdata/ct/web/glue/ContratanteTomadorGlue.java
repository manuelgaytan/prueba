package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class ContratanteTomadorGlue {

    @Autowired
    private Tasks tasks;

    @And("Ir al apartado de rutina de terceros Tomador")
    public void irAlApartadoDeRutinaDeTerceros() {
        tasks.contratanteTomadorTask.irATerceros();
        tasks.contratanteTomadorTask.irATerceros2();
    }

    @Then("Aceptar cambio de contratante Tomador")
    public void aceptarCambioDeConductorHabitual() {
        tasks.contratanteTomadorTask.irATerceros3();
        tasks.contratanteTomadorTask.validarINE();
    }
}
