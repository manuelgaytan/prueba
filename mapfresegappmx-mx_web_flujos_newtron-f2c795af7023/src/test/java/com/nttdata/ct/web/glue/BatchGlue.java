package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class BatchGlue {

    @Autowired
    private Tasks tasks;

    @And("Voy al apartado suplemento de administracion de tareas")
    public void menuPrincipal() {
        tasks.batchTask.irConsultarPoliza();
    }
    @And("Voy al apartado de tareas {string}, {string}")
    public void irTareas(String tarea, String codEstructura) {
        tasks.batchTask.irLanzadorTareas(tarea, codEstructura);
    }
    @And("Validamos tareas")
    public void validacion() {
        tasks.batchTask.clicAceptarTareas();
        tasks.batchTask.validarTareas();
    }



}