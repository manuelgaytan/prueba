package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class AutoConsultaFlotillasGlue {

    @Autowired
    private Tasks tasks;

    @And("Voy al apartado consultar póliza flotillas")
    public void menuPrincipal() {
        tasks.autoFlotillasConsultaTask.irConsultarPoliza();
    }

    @And("Consulta de la póliza flotillas")
    public void consultamosPolizaflotillas(){
        tasks.autoFlotillasConsultaTask.informacionConsulta();

    }
    @And("Informacion general de la póliza flotillas")
    public void informacionGeneralFlotillas(){
        tasks.autoFlotillasConsultaTask.validacionConsulta();
        tasks.autoFlotillasConsultaTask.validacionConsulta2();
        tasks.autoFlotillasConsultaTask.validacionConsulta3();
    }

}