package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class EmisionGestionControlTecnicoGlue {
    @Autowired
    private Tasks tasks;

    @And("Ingresar a Gestión Control Técnico Emisión")
    public void ingresarAGestionControlTecnicoEmision() {
        tasks.emisionGestionControlTecnicoTask.ingresarAEmison();
        tasks.emisionGestionControlTecnicoTask.ingresarAGestionControlTecnicoEmision();
    }

    @And("Buscar poliza")
    public void buscarPoliza() {
        tasks.emisionGestionControlTecnicoTask.buscarPoliza();
    }

    @And("Seleccionar poliza {string}")
    public void seleccionarPoliza(String observaciones) {
        tasks.emisionGestionControlTecnicoTask.seleccionarPoliza();
        tasks.emisionGestionControlTecnicoTask.seleccionarPolizaParaAutorizar(observaciones);
    }

    @And("Autorizar poliza")
    public void autorizarPoliza() {
        tasks.emisionGestionControlTecnicoTask.autorizarPiloza();
    }

    @And("Rechazar poliza")
    public void rechazarPoliza() {
        tasks.emisionGestionControlTecnicoTask.rechazarPiloza();
    }
}
