package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;


public class EmisionConsultaPolizaGlue {
    @Autowired
    private Tasks tasks;

    @And("Ingresar a Consulta Poliza Emision")
    public void ingresarAConsultaPolizaEmision() {
        tasks.emisionGestionControlTecnicoTask.ingresarAEmison();
        tasks.emisionConsultaPolizaTask.ingresarAConsultaPolizaEmision();
    }

    @And("Buscar Poliza Consulta Poliza {string}")
    public void buscarPoliza(String numeroPoliza) {
        tasks.emisionConsultaPolizaTask.buscarPoliza(numeroPoliza);
        tasks.emisionConsultaPolizaTask.ingresarANumeroPoliza(numeroPoliza);
    }

    @And("Ingresar a Recibos de poliza")
    public void ingresar_a_recibos_de_poliza() {
        tasks.emisionConsultaPolizaTask.ingresoReciboDePoliza();

    }
}
