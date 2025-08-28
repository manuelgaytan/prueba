package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class DatosBancariosPolizaGlue {
    @Autowired
    private Tasks tasks;
    @And("Seleccionar y cargar archivo {string}")
    public void seleccionarYCargarArchivoPOLIZATESTTXT(String archivoPoliza) {
        tasks.datosBancariosPolizaTask.cargarArchivo(archivoPoliza);
    }
    //Ejecutar tarea datos bancarios 'MMXGCL1009'
    @And("Ejecutar tarea datos bancarios {string}")
    public void ejecutarTareaDatodBancarios(String tarea) {
        tasks.datosBancariosPolizaTask.ingresarNombreArchivo(tarea);
    }

    @And("Ingresar datos de la tarea datos bancarios {string}")
    public void ingresarDatosDeLaTareaDatosBancarios(String nombreArchivo) {
        tasks.datosBancariosPolizaTask.ingresarNombreArchivo(nombreArchivo);
    }
}
