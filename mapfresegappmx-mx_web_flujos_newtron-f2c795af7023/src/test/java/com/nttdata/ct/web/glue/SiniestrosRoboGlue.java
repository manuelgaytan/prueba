package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class SiniestrosRoboGlue {

    @Autowired
    private Tasks tasks;

    @And("Busqueda de apertura de siniestro nuevo {string},{string},{string},{string},{string}")
    public void ingresoDatosPantalla1(String codigoMotivoSiniestro, String codTipoAsegurado, String motivoSiniestro, String motivoSiniestro2, String motivoSiniestro3) {
        tasks.siniestrosRoboTask.motivoSiniestronew(codigoMotivoSiniestro, codTipoAsegurado, motivoSiniestro, motivoSiniestro2,motivoSiniestro3);
        tasks.siniestrosRoboTask.motivoSiniestro2new();
    }

    @And("Ventana de siniestro Robo exitoso nuevo")
    public void ventanaDeSiniestroRoboExitosoNuevo() {
        tasks.siniestrosRoboTask.polizaSiniestroRobo();
    }

    @And("Ir a apertura de expediente robo total")
    public void irAAperturaDeExpedienteRoboTotal() {
        tasks.siniestrosRoboTask.irAperturaExpedientesRoboTotal();
    }

    @And("Llenado de danos robo")
    public void llenadoDeDanosRobo() {
        tasks.siniestrosRoboTask.irLlenadoDatos1();
    }
}
