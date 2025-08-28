package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;


public class ReporteSiniestroGlue {
    @Autowired
    private Tasks tasks;
    @Autowired
    private LoginUI loginUI;

    @And("Ir a Consulta de siniestro")
    public void consultaSiniestro() {
        tasks.reporteSiniestroTask.irConsultarPoliza();
    }
    @And("Busqueda de siniestro")
    public void busquedaSiniestro1() {
        tasks.reporteSiniestroTask.busquedaSiniestro();
    }
    @And("Validación de consulta siniestro {string}")
    public void validacionSiniestro(String motivoSiniestro) {
        tasks.reporteSiniestroTask.validacionConsulta();
        tasks.reporteSiniestroTask.validacionConsulta2(motivoSiniestro);
    }
}
