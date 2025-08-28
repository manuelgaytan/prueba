package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class ConductorHabitualGlue {
    @Autowired
    private Tasks tasks;

    @And("Ir al apartado de rutina de terceros")
    public void irAlApartadoDeRutinaDeTerceros() {
        tasks.conudctorHabitualTask.irATerceros();
        tasks.conudctorHabitualTask.irATerceros2();
    }

    @Then("Aceptar cambio de conductor habitual")
    public void aceptarCambioDeConductorHabitual() {
        tasks.conudctorHabitualTask.irATerceros3();
        tasks.conudctorHabitualTask.validarINE();
    }
}
