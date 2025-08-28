package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class SiniestrosCristalesGlue {

    @Autowired
    private Tasks tasks;

    @And("Busqueda de apertura de siniestro nuevo {string},{string},{string},{string}")
    public void ingresoDatosPantalla1(String codigoMotivoSiniestro, String codTipoAsegurado, String motivoSiniestro, String motivoSiniestro2) {
        tasks.siniestrosCristalesTask.motivoSiniestronew(codigoMotivoSiniestro, codTipoAsegurado, motivoSiniestro, motivoSiniestro2);
        tasks.siniestrosCristalesTask.motivoSiniestro2new();
    }

    @And("Ir a apertura de expediente cristales")
    public void irExpedientes() {
        tasks.siniestrosCristalesTask.irAperturaExpedientes();
    }

    @And("Ir a apertura de expediente lesionados")
    public void irExpedienteslesionados() {
        tasks.siniestrosCristalesTask.irAperturaExpedientesLesionados();
    }
    @And("Llenado de lesiones ocupantes")
    public void llenadoLesionados(){
        tasks.siniestrosCristalesTask.llenadoLesionadosCrist();
    }
    @And("Datos Complementarios lesionados")
    public void datosComplLesionados(){
        tasks.siniestrosCristalesTask.datosCompleLesionados();
    }

    @And("Finalizar expediente Leo")
    public void finalizarLesionados(){
        tasks.siniestrosCristalesTask.finalizarLEO();
        tasks.siniestrosCristalesTask.finalizarLEO2();
    }
    @And("Llenado de danos cristales")
    public void llenadoDeDañosParciales() {
        tasks.siniestrosCristalesTask.irLlenadoDatos1();
    }
    @And("Ventana de siniestro Cristales exitoso nuevo")
    public void noPolizaColision() {
        tasks.siniestrosCristalesTask.polizaSiniestroColisionnew();
    }

    @And("Datos Complementarios expediente")
    public void llenadoDatosCompl() {
        tasks.siniestrosCristalesTask.valoracionInicialExpediente();
    }

}
