package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;


public class SiniestrosGlue {
    @Autowired
    private Tasks tasks;
    @Autowired
    private LoginUI loginUI;


    @And("Introduccion de datos {string},{string}")
    public void introduccionDeDatos(String siniestro, String expediente) {
        tasks.siniestrosTask.intruducciondatos(siniestro, expediente);
        tasks.siniestrosTask.intruducciondatosseleccionarmotivo();
        tasks.siniestrosTask.intruducciondatosfinalizar();
    }

    @And("Introduccion de datos rehabilitar siniestro {string},{string}")
    public void introduccionDeDatosRehabilitarSiniestro(String siniestro, String expediente) {
        tasks.siniestrosTask.introduccionrehabilitarsiniestro(siniestro, expediente);
    }

    @And("Seleccionar Motivo de Siniestro")
    public void seleccionarMotivoDeSiniestro() {
    tasks.siniestrosTask.seleccionarmotivosiniestro();
    tasks.siniestrosTask.motivosiniestroexpediente();
    //tasks.siniestrosTask.consecuanciasexpediente();
    }

    @And("Aceptar datos complementarios")
    public void aceptarDatosCmplementarios() {
        tasks.siniestrosTask.datoscomplementarios();
        tasks.siniestrosTask.seleccionartipoexpediente();
        tasks.siniestrosTask.seleccionartipoexpediente2();
        tasks.siniestrosTask.seleccionarabogado();
        tasks.siniestrosTask.aperturaexpediente();
    }

    @And("Introduccion de datos modificiacion de expediente {string},{string}")
    public void introduccionDeDatosModificiacionDeExpediente(String siniestro, String expediente) {
        tasks.siniestrosTask.introduccionmodificacionexpediente(siniestro,expediente);
        tasks.siniestrosTask.introduccionmodificacionexpedientemotivosiniestro();

    }

    @And("Seleccionar Abogado")
    public void seleccionarAbogado() {
        tasks.siniestrosTask.modificacionexpedienteactualizarabogado();
        tasks.siniestrosTask.finalizarmodificacionexpediente();
    }

    @And("Introduccion de datos para modificar siniestro {string}")
    public void introduccionDeDatosModificarSiniestro(String siniestro) {
        tasks.siniestrosTask.introduccionmodificacionsiniestro(siniestro);
    }


    @And("Modificiar siniestro")
    public void modificiarSiniestro() {
        tasks.siniestrosTask.modificarsiniestro();
        tasks.siniestrosTask.consecuenciassiniestro();
        tasks.siniestrosTask.datoscomplementariosmodificacionsiniestro();
    }

    @And("Introduccion de datos apertura expediente {string}")
    public void introduccionDeDatosAperturaExpediente(String siniestro) {
        tasks.siniestrosTask.intruducciondatosaperturaexpediente(siniestro);
        tasks.siniestrosTask.pantallatipoexpediente();
        tasks.siniestrosTask.ventanaerror();
    }
}