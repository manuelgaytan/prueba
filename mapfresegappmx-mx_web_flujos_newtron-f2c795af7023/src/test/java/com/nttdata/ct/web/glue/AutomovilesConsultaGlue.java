package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.IndividualConsultaUI;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;


public class AutomovilesConsultaGlue {
    @Autowired
    private Tasks tasks;
    @Autowired
    private LoginUI loginUI;
    @Autowired
    private IndividualConsultaUI individualConsultaUI;

    @And("Voy al apartado consultar póliza")
    public void menuPrincipal() {
        tasks.automovilesConsultaTask.irConsultarPoliza();
    }

    @And("Consulta de la póliza")
    public void irConsultaIndividual() {
        tasks.automovilesConsultaTask.informacionConsulta();
    }

    @And("Informacion general de la póliza")
    public void irConsultaIndividual2() {
        tasks.automovilesConsultaTask.validacionConsulta();
        tasks.automovilesConsultaTask.validacionConsulta2();
    }






}
