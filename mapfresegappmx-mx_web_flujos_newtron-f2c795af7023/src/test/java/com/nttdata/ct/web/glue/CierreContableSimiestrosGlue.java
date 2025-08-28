package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class CierreContableSimiestrosGlue {
    @Autowired
    private Tasks tasks;
    @And("Ingresar datos tarea {string}")
    public void ingresarDatosTareaTarea(String numTarea) {
        tasks.cierreContableSimiestrosTask.datosTareas(numTarea);
    }
}
